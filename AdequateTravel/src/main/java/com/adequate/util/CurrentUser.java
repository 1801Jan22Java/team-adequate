package com.adequate.util;

public class CurrentUser {

	private static Integer userID;
	private static String username;
	private static String password;
	private static Boolean validSession;

	public static void login(Integer userID, String username, String password) {
		CurrentUser.userID = userID;
		CurrentUser.username = username;
		CurrentUser.password = password;
		CurrentUser.validSession = true;
	}
	
	public static void logout() {
		CurrentUser.userID = null;
		CurrentUser.username = null;
		CurrentUser.password = null;
		CurrentUser.validSession = false;
	}
	
	public static int getUserID() {
		return userID != null ? userID : -1;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static Boolean getValidSession() {
		return validSession;
	}

}
