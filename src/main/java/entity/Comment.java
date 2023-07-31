package entity;

import java.io.Serializable;
import javax.persistence.*;

import handler.Formatter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@Table(name="comment")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String content;

	private Timestamp time;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;

	//bi-directional many-to-one association to LikeComment
	@OneToMany(mappedBy="comment")
	private List<LikeComment> likeComments;

	public Comment() {
		this.time = new Timestamp(new Date().getTime());
	}

	public String getTimeAgo() {
		return Formatter.getTimeAgo(getTime());
	}
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<LikeComment> getLikeComments() {
		return this.likeComments;
	}

	public void setLikeComments(List<LikeComment> likeComments) {
		this.likeComments = likeComments;
	}

	public LikeComment addLikeComment(LikeComment likeComment) {
		getLikeComments().add(likeComment);
		likeComment.setComment(this);

		return likeComment;
	}

	public LikeComment removeLikeComment(LikeComment likeComment) {
		getLikeComments().remove(likeComment);
		likeComment.setComment(null);

		return likeComment;
	}

}