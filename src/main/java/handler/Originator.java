package handler;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import entity.Subscription;
import entity.User;
import entity.Video;

public class Originator {
	
	private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int LENGTH_INIT_CHANNEL_ID = 10;
	private static final int LENGTH_INIT_VIDEO_CODE = 10;
	
	/**
	 * Auto init ramdom String have 10 letter
	 * @return String
	 */
	public static String randomString(int length) {
	      Random random = new Random();
	      StringBuilder sb = new StringBuilder();

	      for (int i = 0; i < length; i++) {
	         int randomIndex = random.nextInt(ALPHANUMERIC.length());
	         char randomChar = ALPHANUMERIC.charAt(randomIndex);
	         sb.append(randomChar);
	      }
	      
	      return sb.toString();
	}

	
	/**
	 * Auto init ramdom String have 10 letter. And set this channel id for user
	 * @return user.getChannelId()
	 */
	public static String initChannelId(User user) {
		String id = randomString(LENGTH_INIT_CHANNEL_ID) ;
		user.setChannelId(id);
		return id;
	}
	
	/**
	 * Auto init ramdom String have 10 letter. And set this channel id for user
	 * @return user.getChannelId()
	 */
	public static String initVideoCode(Video video) {
		String id = randomString(LENGTH_INIT_CHANNEL_ID) ;
		video.setCode(id);
		return id;
	}
	
	
	
	/**
	 * Set default User() 
	 */
	public static void initDefaultUser(User user) {
		initChannelId(user);
		user.setDateJoin(new Timestamp(new Date().getTime()));
		user.setIsActive(true);
	}
	
	public static void initDeafaultVideo(Video video) {
		String code = randomString(LENGTH_INIT_VIDEO_CODE);
		video.setCode(code);
		video.setDatePost(new Timestamp(new Date().getTime()));
		video.setIsActive(true);
	}
	
	public static void initDefaultSubscription(Subscription subscription) {
		subscription.setTime(new Timestamp(new Date().getTime()));
	}
	
}
