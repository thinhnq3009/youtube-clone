package entity;

import java.io.Serializable;
import javax.persistence.*;

import com.google.gson.Gson;

import handler.Formatter;
import handler.Originator;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@Table(name = "video")
@NamedQuery(name = "Video.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String code;

	private Timestamp datePost;

	private String description;

	private boolean isActive;

	private boolean isPublic;

	private String poster;

	private long secondLength;

	private String title;

	private String videoUrl;

	// bi-directional many-to-one association to Comment
	@OneToMany(mappedBy = "video")
	private List<Comment> comments;

	// bi-directional many-to-one association to Like
	@OneToMany(mappedBy = "video")
	private List<Liked> likes;

	// bi-directional many-to-one association to Notification
	@OneToMany(mappedBy = "video")
	private List<Notification> notifications;

	// bi-directional many-to-one association to Share
	@OneToMany(mappedBy = "video")
	private List<Share> shares;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// bi-directional many-to-one association to View
	@OneToMany(mappedBy = "video")
	private List<View> views;

	// bi-directional many-to-one association to WatchLater
	@OneToMany(mappedBy = "video")
	private List<WatchLater> watchLaters;

	public Video() {
		Originator.initDeafaultVideo(this);
	}

	public long getLikeCount() {
		return this.getLikes().stream().filter(Liked::getIsLike).count();

	}

	public long getDislikeCount() {
		return this.getLikes().stream().filter(l -> !l.getIsLike()).count();
	}

	public long getViewCount() {
		return getViews() == null ? 0 : getViews().size();
	}

	public boolean checkOwner(User user) {
		return this.getUser().getId() == user.getId();
	}

//	Getter/Setter
	public boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getDatePost() {
		return this.datePost;
	}

	public String getTimeAgo() {
		return Formatter.getTimeAgo(getDatePost());
	}

	public void setDatePost(Timestamp datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public long getSecondLength() {
		return this.secondLength;
	}

	public String getDuration() {
		return Formatter.formatTime(getSecondLength());
	}

	public void setSecondLength(long secondLength) {
		this.secondLength = secondLength;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setVideo(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setVideo(null);

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
		like.setVideo(this);

		return like;
	}

	public Liked removeLike(Liked like) {
		getLikes().remove(like);
		like.setVideo(null);

		return like;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setVideo(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setVideo(null);

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
		share.setVideo(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setVideo(null);

		return share;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<View> getViews() {
		return this.views;
	}

	public void setViews(List<View> views) {
		this.views = views;
	}

	public View addView(View view) {
		getViews().add(view);
		view.setVideo(this);

		return view;
	}

	public View removeView(View view) {
		getViews().remove(view);
		view.setVideo(null);

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
		watchLater.setVideo(this);

		return watchLater;
	}

	public WatchLater removeWatchLater(WatchLater watchLater) {
		getWatchLaters().remove(watchLater);
		watchLater.setVideo(null);

		return watchLater;
	}

}