package es.imatia.redsocial;

import java.util.List;

public class UserList {
	private List<User> userlist;

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public UserList(List<User> userlist) {
		this.userlist = userlist;
	}
	
	public User findUserByName ( String name) {
		User userfind = null;
		for (User user : this.userlist) {
			if (user.getName().equals(name)) {
				userfind =user;
			}
		}
		return userfind;
	}
	

}
