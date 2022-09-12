package es.imatia.redsocial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zaira.lopez
 *
 */
public class User {
	private String name;
	private List<User> followedlist = new ArrayList<>();
	private List<Post> postlist = new ArrayList<>();

	public User(String name) {
		this.name = name;
	}
	
	public User(String name, List<User> followedlist, List<Post> postlist) {
		this.name = name;
		this.followedlist = followedlist;
		this.postlist = postlist;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the followedlist
	 */
	public List<User> getFollowedlist() {
		return followedlist;
	}

	/**
	 * @param followedlist the followedlist to set
	 */
	public void setFollowedlist(List<User> followedlist) {
		this.followedlist = followedlist;
	}

	

	/**
	 * @return the postlist
	 */
	public List<Post> getPostlist() {
		return postlist;
	}

	/**
	 * @param postlist the postlist to set
	 */
	public void setPostlist(List<Post> postlist) {
		this.postlist = postlist;
	}

	public void addUsers(List<User> users) {
		if(!users.contains(this)) {
			users.add(this);
			System.out.println("El usuario se ha añadido correctamente: " + this.name);
		}else {
			System.out.println("El usuario ya existe, no se puede volver a insertar");
		}
	}
	
	public void addFriends(User user) {
		if(!this.getFollowedlist().contains(user)) {
			this.getFollowedlist().add(user);
			System.out.println("El usuario se ha añadido correctamente a la lista de amigos: "+ user.name);
		}else {
			System.out.println("El usuario ya existe, no se puede volver a insertar");
		}
	}
	
	public void listPosts(List<Post> postList, String message) {
		System.out.println(message);
		int i = 0;
		for (Post post : postList) {
			if ( post instanceof TextPost) {
				System.out.println(i + "- " + ((TextPost)post).getContent());
			}
			if ( post instanceof VideoPost) {
				System.out.println(i + "- " + ((VideoPost)post).getTitle() );
			}
			if ( post instanceof ImagePost) {
				System.out.println(i + "- " + ((ImagePost)post).getTitle() );
			}
			i++;
		}
		
	}
	
	public List<User> friendsSuggestion(List<User> users){
		List <User> suggestions = new ArrayList<>();
		
		for (User userFollowed : this.followedlist) {
			for (User userFriendFollowed : userFollowed.followedlist) {
				if(!this.getFollowedlist().contains(userFriendFollowed) && !userFriendFollowed.equals(this)) {
					suggestions.add(userFriendFollowed);
				}
			}
		}
		if(suggestions.isEmpty()) {
			System.out.println("No existen sugerencias para este usuario");
		}
		return suggestions;
	}
	
	
}
