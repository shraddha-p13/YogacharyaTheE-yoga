package com.app.eyogaapplication.model;

import java.util.List;

public class UserDetailsDto extends UserDetails{

	private List<Roles> userRoleList;

	public List<Roles> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<Roles> userRoleList) {
		this.userRoleList = userRoleList;
	}
	
}
