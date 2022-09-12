package es.imatia.redsocial;

import es.imatia.units.Input;

public class Utils {
	
	public static User loginUser(UserList userList, String message) {
		System.out.println(message);
		for (User user : userList.getUserlist()) {
			System.out.println(user.getName());
		}
		String nameOwnerPost = Input.string();
		User loggedUser =userList.findUserByName(nameOwnerPost);
		return loggedUser;
	}

}
