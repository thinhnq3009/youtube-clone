package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.mindrot.jbcrypt.BCrypt;

import enums.DefaultValue;
import handler.Originator;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String acceptToken;

	private String avatar;

	private String channelId;

	private String channelName;

	@Column(name = "dateJoin", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp dateJoin;

	private boolean isActive;

	private boolean isSystemAdmin;

	private boolean isVerified;

	private String password;

	private String resetPasswordToken;

	private String story;

	private String username;

	private String email;

	// bi-directional many-to-one association to Comment
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	// bi-directional many-to-one association to Like
	@OneToMany(mappedBy = "user")
	private List<Liked> likes;

	// bi-directional many-to-one association to LikeComment
	@OneToMany(mappedBy = "user")
	private List<LikeComment> likeComments;

	// bi-directional many-to-one association to Notification
	@OneToMany(mappedBy = "user")
	private List<Notification> notifications;

	// bi-directional many-to-one association to Share
	@OneToMany(mappedBy = "user")
	private List<Share> shares;

	// bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy = "channel")
	private List<Subscription> listSubcriber;

	// bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy = "subscriber")
	private List<Subscription> listChannelSubcribed;

	// bi-directional many-to-one association to Video
	@OneToMany(mappedBy = "user")
	private List<Video> videos;

	// bi-directional many-to-one association to View
	@OneToMany(mappedBy = "user")
	private List<View> views;

	// bi-directional many-to-one association to WatchLater
	@OneToMany(mappedBy = "user")
	private List<WatchLater> watchLaters;

	public User() {
		Originator.initDefaultUser(this);
	}

	public boolean checkSub(User channel) {
		return this.getListChannelSubcribed().stream().anyMatch(sub -> sub.getChannel().getId() == channel.getId());
	}
	
	public long getTotalViews() {
		return this.getVideos().stream().flatMap(v -> v.getViews().stream()).count();
	}

	public boolean checkLike(Video video) {
		return video.getLikes().stream().anyMatch(like -> this.getId() == like.getUser().getId() && like.getIsLike());
	}
	public boolean checkDislike(Video video) {
		return video.getLikes().stream().anyMatch(like -> this.getId() == like.getUser().getId() && !like.getIsLike());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User user) {
			return user.getId() == this.getId();
		} else {
			return false;
		}
	}
	
	// Getter/Setter

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAcceptToken() {
		return this.acceptToken;
	}

	public void setAcceptToken(String acceptToken) {
		this.acceptToken = acceptToken;
	}

	public String getAvatar() {
		return this.avatar == null ? DefaultValue.USER_AVATAR : this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Timestamp getDateJoin() {
		return this.dateJoin;
	}

	public void setDateJoin(Timestamp dateJoin) {
		this.dateJoin = dateJoin;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsSystemAdmin() {
		return this.isSystemAdmin;
	}

	public void setIsSystemAdmin(boolean isSystemAdmin) {
		this.isSystemAdmin = isSystemAdmin;
	}

	public boolean getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetPasswordToken() {
		return this.resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public String getStory() {
		return this.story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Liked> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Liked> likes) {
		this.likes = likes;
	}

	public Liked addLike(Liked like) {
		getLikes().add(like);
		like.setUser(this);

		return like;
	}

	public Liked removeLike(Liked like) {
		getLikes().remove(like);
		like.setUser(null);

		return like;
	}

	public List<LikeComment> getLikeComments() {
		return this.likeComments;
	}

	public void setLikeComments(List<LikeComment> likeComments) {
		this.likeComments = likeComments;
	}

	public LikeComment addLikeComment(LikeComment likeComment) {
		getLikeComments().add(likeComment);
		likeComment.setUser(this);

		return likeComment;
	}

	public LikeComment removeLikeComment(LikeComment likeComment) {
		getLikeComments().remove(likeComment);
		likeComment.setUser(null);

		return likeComment;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setUser(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUser(null);

		return share;
	}

	public List<Subscription> getListChannelSubcribed() {
		return this.listChannelSubcribed;
	}

	public void setListChannelSubcribed(List<Subscription> subscriptions1) {
		this.listChannelSubcribed = subscriptions1;
	}

	public Subscription addChannelSubcribed(Subscription subscription) {
		getListChannelSubcribed().add(subscription);
		subscription.setChannel(this);

		return subscription;
	}

	public Subscription removeChannelSubcribed(Subscription subscription) {
		getListChannelSubcribed().remove(subscription);
		subscription.setChannel(null);

		return subscription;
	}

	public List<Subscription> getListSubcriber() {
		return this.listSubcriber;
	}

	public void setListSubcriber(List<Subscription> listSubcriber) {
		this.listSubcriber = listSubcriber;
	}

	public Subscription addSubcriber(Subscription subscription) {
		getListSubcriber().add(subscription);
		subscription.setSubscriber(this);

		return subscription;
	}

	public Subscription removeSubcriber(Subscription subscription) {
		getListSubcriber().remove(subscription);
		subscription.setSubscriber(null);

		return subscription;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setUser(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setUser(null);

		return video;
	}

	public List<View> getViews() {
		return this.views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}

	public View addView(View view) {
		getViews().add(view);
		view.setUser(this);

		return view;
	}

	public View removeView(View view) {
		getViews().remove(view);
		view.setUser(null);

		return view;
	}

	public List<WatchLater> getWatchLaters() {
		return this.watchLaters;
	}

	public void setWatchLaters(List<WatchLater> watchLaters) {
		this.watchLaters = watchLaters;
	}

	public WatchLater addWatchLater(WatchLater watchLater) {
		getWatchLaters().add(watchLater);
		watchLater.setUser(this);

		return watchLater;
	}

	public WatchLater removeWatchLater(WatchLater watchLater) {
		getWatchLaters().remove(watchLater);
		watchLater.setUser(null);
		return watchLater;
	}

	public void hashPassword() {
		String oldPassword = getPassword();

		if (oldPassword.startsWith("$2a$")) {
			System.err.println("Passwork may be hashed");
		}

		String hashString = BCrypt.hashpw(oldPassword, BCrypt.gensalt());

		setPassword(hashString);

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}