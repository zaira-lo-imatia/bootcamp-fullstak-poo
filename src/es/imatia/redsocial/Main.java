package es.imatia.redsocial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.imatia.units.Input;

public class Main {

	public static void main(String[] args) {
		//La lista de los usuarios que forman parte de la red social
		//Tabla de usuarios en la bbddd
		UserList userList = new UserList (new ArrayList<User>());
		//Usuarios
		User pepe = new User("pepe");
		User manolita = new User("manolita");
		User juan = new User("juan");
		User julia = new User("julia");
		User sandra = new User("sandra");
		User diego = new User("diego");
		User carlos = new User("carlos");
		
		//seguidores de pepe
		List<User> followedpepe = new ArrayList<>();
		followedpepe.add(manolita);
		//seguidores de manolita
		//Tabla relacional en la bbdd
		List<User> followedmanolita = new ArrayList<>();
		followedmanolita.add(juan);
		followedmanolita.add(pepe);
		followedmanolita.add(diego);
		
		//post de pepe
		Post imagpepe = new ImagePost(LocalDate.of(2022, 5, 4),new ArrayList<Comment>(), "Selfie.jpg", 400, 450);
		Post textpepe = new TextPost(LocalDate.of(2022, 4, 1), new ArrayList<Comment>(), "Hoy salí de acampada");
		//Tablta de post en la bbddd
		List<Post> postlistpepe = new ArrayList<>();
		postlistpepe.add(imagpepe);
		postlistpepe.add(textpepe);
		
		//comentarios de diego y manolita en el post de pepe
		Comment commenttextpepediego = new Comment("Menuda suerte", LocalDate.of(2022, 4, 2), diego);
		Comment commenttextpepemanolita = new Comment("Espero que no lloviese", LocalDate.of(2022, 4, 2), manolita);
		//tabla comentarios en la bbddd
		List<Comment>commentlist = new ArrayList<>();
		commentlist.add(commenttextpepemanolita);
		commentlist.add(commenttextpepediego);
		//añadimos los comentarios al post de pepe
		textpepe.setCommentlist(commentlist);
		//añadimos la lista de post a pepe
		pepe.setPostlist(postlistpepe);
		//añadimos amigos de pepe a pepe
		pepe.setFollowedlist(followedpepe);
		//añadimos amigos de manolita a manolita
		manolita.setFollowedlist(followedmanolita);
		
		//añadimos los usuarios a la lista de usuarios de la red social
		userList.getUserlist().add(diego);
		userList.getUserlist().add(carlos);
		userList.getUserlist().add(pepe);
		userList.getUserlist().add(manolita);
		userList.getUserlist().add(julia);
		userList.getUserlist().add(sandra);
		userList.getUserlist().add(juan);
		
		
		String option = "";
		System.out.println();
		String name;
		do {
			option = Input.string(
					"Selección: \n     '1' - Crear usuario y añadirlo a la red social\n     '2' - Añadir un post\n     '3' - Añadir un comentario\n     '4' - Seguir a un usuario\n"
					+ "     '5' - Dejar de seguir a un usuario\n     '6' - Eliminar un comentario tuyo\n     '7' - Eliminar un comentario de un post tuyo\n"
					+ "     '8' - Eliminar un post\n     '9' - Eliminar un usuario\n     '10' - Listar los Post de un usuario\n"
					+ "     '11' - Ver los comentarios de un post\n     '12' - Ver los comentarios de un usuario\n"
					+ "     '13' - Contar los comentarios de un post\n     '14' - Mostrar el muro de un usuario\n"
					+ "     '15' - Mostrar sugerencias de amistad\n     '0' - Salir\n     \nQué opción desea hacer?: ");
			System.out.println();
			switch (option) {
			case "1":
				name = Input.string("Introduce el nombre del nuevo usuario: ");
				User u = new User(name);
				u.addUsers(userList.getUserlist());
				break;
			case "2":
				User userposter =Utils.loginUser(userList, "Introduce tu usuario");
				if(userposter != null) {
					
					String type = Input.string("Tipo de Post (1 = texto , 2 = imagen , 3 = video)");
					switch (type) {
					case "1":
						String contenido = Input.string("Escribe el contenido");
						TextPost texpost = new TextPost(LocalDate.now(), new ArrayList(), contenido);
						userposter.getPostlist().add(texpost);
						break;
					case "2":
						String titleimagen = Input.string("Escribe el titulo de la imagen");
						int anchoimagen = Input.integer("Ancho de imagen");
						int largoimagen = Input.integer("Largo de imagen");
						ImagePost imagepost = new ImagePost(LocalDate.now(), new ArrayList(), titleimagen , largoimagen , anchoimagen);
						userposter.getPostlist().add(imagepost);
						break;
					case "3":
						String titlevideo = Input.string("Escribe el titulo del video");
						String calidadvideo = Input.string("Calidad del video");
						int duracion = Input.integer("Duracion de video en segundos");
						VideoPost videopost = new VideoPost(LocalDate.now(), new ArrayList(), titlevideo , calidadvideo , duracion);
						userposter.getPostlist().add(videopost);
						break;
					}
				}

				break;
			case "3":
				User userCommenter =Utils.loginUser(userList, "Introduce tu usuario");
				if(userCommenter != null) {
					System.out.println("A que usuario vas a comentar");
					for (User user : userList.getUserlist()) {
						System.out.println(user.getName());
					}
					String nameCommented = Input.string();
					User userCommented =userList.findUserByName(nameCommented);
					/* COMPROBAMOS QUE EXISTE EL USUARIO COMENTADO */
					if(userCommented != null) {
						userCommented.listPosts(userCommented.getPostlist(), "");
					int numberPost = Input.integer("Elige el número del post que vas a comentar: ");
						if (userCommented.getPostlist().size() > numberPost ) {
							String textComment = Input.string("Escribe el comentario");
							Comment addComment = new Comment(textComment, LocalDate.now(), userCommenter);
							Post postCommented = userCommented.getPostlist().get(numberPost);
							postCommented.getCommentlist().add(addComment);
						}
					
					}
				}
				break;
			case "4":
				User userFollower =Utils.loginUser(userList, "Introduce tu usuario");
				if(userFollower!= null) {
					String nameFollowed = Input.string("Qué usuario desea seguir");
					User userFollowed =userList.findUserByName(nameFollowed);
					if(userFollowed!=null) {
						userFollower.addFriends(userFollowed);
					}else {
						System.out.println("El usuario al que quiere seguir no está registrado");
					}
				}else {
					System.out.println("No estás registrado, selecciona la opción 1 para crear usuario nuevo primero.");
				}
				
				break;
			case "5":
				User userUnFollower =Utils.loginUser(userList, "Introduce tu usuario");
				if(userUnFollower!=null) {
					System.out.println("¿Qué usuario quieres dejar de seguir?");
					for(User user : userUnFollower.getFollowedlist()) {
						System.out.println(user.getName());
					}
					String nameUnFollowed = Input.string();
					User userUnFollowed =userList.findUserByName(nameUnFollowed);
					if(userUnFollowed!=null) {
						userUnFollower.getFollowedlist().remove(userUnFollowed);
					}else {
						System.out.println("El usuario al que quiere seguir no está registrado");
					}
				}else {
					System.out.println("No estás registrado, selecciona la opción 1 para crear usuario nuevo primero.");
				}
				
				break;
			case "6":
				User useLogged = Utils.loginUser(userList, "Introduce tu usuario");
				if (useLogged != null) {
					int i = 0;
					System.out.println("¿Qué comentario quieres borrar?");
					for (User user : userList.getUserlist()) {
						for (Post post : user.getPostlist()) {
							for (Comment comment : post.getCommentlist()) {
								if(useLogged.equals(comment.getOwner())){
									System.out.println(i + "- El usuario ha comentado en el post de " + user.getName() + 
											" el siguiente texto: "+ comment.getText());
									i++;
								}
							}
						}
					}
					int numberComment = Input.integer("Elige el número del comentario que quieres borrar: ");
					i =0;
					Post removedPost = new Post();
					Comment removedComment = new Comment();
					for (User user : userList.getUserlist()) {
						for (Post post : user.getPostlist()) {
							for (Comment comment : post.getCommentlist()) {
								if (useLogged.equals(comment.getOwner())){
									if (i == numberComment) {
										removedComment = comment;
										removedPost = post;
									} 
									i++;
									
								}
							}
						}
					}
					removedPost.getCommentlist().remove(removedComment);
				}
				break;
			case "7":
				User userOwner =Utils.loginUser(userList, "Introduce tu usuario");
				if(userOwner!= null) {
					userOwner.listPosts(userOwner.getPostlist(), "Elige el post del que quieres eliminar un comentario");
					int numberPost = Input.integer("");
					if (userOwner.getPostlist().size() > numberPost ) {
						Post postCommented = (Post) userOwner.getPostlist().get(numberPost);
						int j = 0;
						System.out.println("Elige el comentario que quieres eliminar");
						for (Comment comment : postCommented.getCommentlist()) {
							System.out.println(j + "- " + comment.getText());
							j++;
						}
						int numberComment = Input.integer();
						if(numberComment< postCommented.getCommentlist().size()) {
							postCommented.getCommentlist().remove(numberComment);
						}else {
							System.out.println("El comentario que quieres eliminar no existe");
						}
					}
				
				}
				break;
			case "8":
				User ownerPost = Utils.loginUser(userList, "Introduce tu usuario");
				if(ownerPost!= null) {
					ownerPost.listPosts(ownerPost.getPostlist(), "Elige el post que quieras eliminar");
					int numberPost = Input.integer("");
					if (ownerPost.getPostlist().size() > numberPost ) {
						Post postToDelete = (Post) ownerPost.getPostlist().get(numberPost);
						ownerPost.getPostlist().remove(postToDelete);
					}else {
						System.out.println("El post que quieres eliminar no existe");
					}
				}else {
					System.out.println("No existes en la base de datos. Selecciona la opcion 1 para crear tu usuario.");
				}
				break;
			case"9":
				System.out.println("Introduce tu usuario que quieres eliminar");
				for (User user : userList.getUserlist()) {
					System.out.println(user.getName());
				}
				String nameDeleteUser = Input.string();
				User userDelete =userList.findUserByName(nameDeleteUser);
				if(userDelete!= null) {
					userList.getUserlist().remove(userDelete);
				}
				break;
			case "10":
				User posterer = Utils.loginUser(userList,"Introduce el nombre del usuario del que quieras listar los posts");
				if(posterer!=null) {
					posterer.listPosts(posterer.getPostlist(), "Estos son los post del usuario: " + posterer.getName());
				}
				break;
			case "11":
				User ufound = Utils.loginUser(userList, "Introduce tu usuario");
				if(ufound!=null) {
					ufound.listPosts(ufound.getPostlist(), "");
					int numberPost = Input.integer("Elige el número del post del que quieres ver los comentarios: ");
					if (ufound.getPostlist().size() > numberPost ) {
						Post commentedPost = (Post) ufound.getPostlist().get(numberPost);
						for (Comment comment : commentedPost.getCommentlist()) {
							System.out.println(comment.getText());
						}
					}
				}
				break;
			case "12":
				User uLoged = Utils.loginUser(userList, "Introduce el usuario del que quieres ver los comentarios");
				if(uLoged!=null) {
					boolean comments = false;
					for (User user : userList.getUserlist()) {
						for (Post post : user.getPostlist()) {
							for (Comment comment : post.getCommentlist()) {
								if(uLoged.equals(comment.getOwner())){
									System.out.println("El usuario ha comentado en el post de " + user.getName() + 
											" el siguiente texto: "+ comment.getText());
									comments = true;
								}
							}
						}
						
					}
					if(!comments) {
						System.out.println("No has comentado en ningún post");
					}
				}
				break;
			case "13":
				User uCountComments = Utils.loginUser(userList, "Introduce el usuario del post del que quieres saber el numero de comentarios");
				if(uCountComments !=null) {
					uCountComments.listPosts(uCountComments.getPostlist(), "Estos son los post del usuario "+uCountComments.getName());
					int numberPost = Input.integer("Elige el número del post del que quieres contar los comentarios: ");
					if (uCountComments.getPostlist().size() > numberPost) {
						Post commentedPost = (Post) uCountComments.getPostlist().get(numberPost);
						System.out.println("numero de comentarios: " + commentedPost.getCommentlist().size());
					}
				}
				break;
			case "14":
				User userstimeline = Utils.loginUser(userList, "Introduce el usuario del que quieras ver el muro");
				if(userstimeline!=null) {
					List<Post> listapost = new ArrayList<>();
					List<LocalDate> listaDate = new ArrayList<>(); 
					for (User user : userstimeline.getFollowedlist()) {
						for (Post post : user.getPostlist()) {
							listapost.add(post);
							listaDate.add(post.getDate());
						}
					}
					listaDate.sort(Comparator.reverseOrder());
					Set<LocalDate> setDate = new HashSet<LocalDate>(listaDate);
					for (LocalDate date : setDate) {
						int i = 0;
						while (i < setDate.size() && i < 4) {
							if( listapost.get(i).getDate().equals(date)){
								if ( listapost.get(i) instanceof TextPost) {
									System.out.println(date + "- " + ((TextPost)listapost.get(i)).getContent() );
								}
								if ( listapost.get(i) instanceof VideoPost) {
									System.out.println(date + "- " + ((VideoPost)listapost.get(i)).getTitle() );
								}
								if ( listapost.get(i) instanceof ImagePost) {
									System.out.println(date + "- " + ((ImagePost)listapost.get(i)).getTitle() );
								}
								
							}
							
						i++;	
						} 
						
					}
				}
				break;
			case "15":
				User usSuggested = Utils.loginUser(userList, "Introduce tu usario");
				if(usSuggested!=null) {
					List <User> usersSuggested = usSuggested.friendsSuggestion(userList.getUserlist());
					if(!usersSuggested.isEmpty()) {
						System.out.println("Usuarios sugeridos");
						for (User user : usersSuggested) {
							System.out.println(user.getName());
						}
					}
				}
				break;
			case "0":
				break;
			default:
				System.out.println("No existe esa opción");
				break;
			}
		} while (!option.equalsIgnoreCase("0"));

		
		

	}

}
