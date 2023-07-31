package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import entity.Video;

import static enums.AttributeName.*;
import enums.Permission;
import exception.PermissionException;

public class PermissionManager {
	/*
	 * public static void check(Users user, Permission permission) throws Exception{
	 * Exception exception = new Exception("Not have access");
	 * 
	 * try {
	 * 
	 * if (permission == Permission.PUBLIC) { return; } else if (permission ==
	 * Permission.ADMIN_ONLY) { if (user.getIsSystemAdmin()) { return ; } else {
	 * throw exception; } } else if (permission == permission.REQUIRED_LOGIN) { if
	 * (user != null) { return; } else { throw exception; } } else if (permission ==
	 * Permission.USER_ONLY){ if (!user.getIsSystemAdmin()) { return; } else { throw
	 * exception; } }
	 * 
	 * } catch (NullPointerException e) { if (permission == Permission.PUBLIC) {
	 * return; } else { throw exception; } } }
	 */

	public static void check(User user, Permission permission) throws PermissionException {
		boolean accessAllowed = false;

		switch (permission) {
		case PUBLIC:
			accessAllowed = true;
			break;
		case ADMIN_ONLY:
			accessAllowed = user != null && user.getIsSystemAdmin();
			break;
		case REQUIRED_LOGIN:
			accessAllowed = user != null;
			break;
		case USER_ONLY:
			accessAllowed = user != null && !user.getIsSystemAdmin();
			break;
		case NOT_LOGIN: 
			accessAllowed = user == null;
			break;
		}

	
		if (!accessAllowed) {
			throw new PermissionException("Not have access");
		}
	}

	public static void checkRequeste(HttpServletRequest request, Permission permissions) throws PermissionException {

		User user = (User) request.getSession().getAttribute(USER_LOGIN);	
		check(user, permissions);

	}
	
	public static void checkOwnerVideo(User user, Video video, boolean checkAdmin) throws PermissionException {
		
		if (video.getUser().equals(user) || (user.getIsSystemAdmin() && checkAdmin)) {
			return ; 
		} else {
			throw new PermissionException("Bạn không phải chủ sở hữu video này");
		}
		
	}
	public static void checkOwnerVideo(User user, Video video) throws PermissionException {
		checkOwnerVideo(user, video, false);
	}
}
