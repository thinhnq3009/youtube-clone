package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the likeComment database table.
 * 
 */
@Entity
@Table(name="likeComment")
@NamedQuery(name="LikeComment.findAll", query="SELECT l FROM LikeComment l")
public class LikeComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean isLike;

	private Timestamp time;

	//bi-directional many-to-one association to Comment
	@ManyToOne
	@JoinColumn(name="commentId")
	private Comment comment;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public LikeComment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getIsLike() {
		return this.isLike;
	}

	public void setIsLike(boolean isLike) {
		this.isLike = isLike;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}