package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the like database table.
 * 
 */
@Entity
@Table(name="liked")
@NamedQuery(name="Liked.findAll", query="SELECT l FROM Liked l")
public class Liked implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean isLike;

	private Timestamp time;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;

	public Liked() {
		this.time = new Timestamp(new Date().getTime());
	}
	
	
	

	public Liked(User user, Video video) {
		this.time = new Timestamp(new Date().getTime());
		this.user = user;
		this.video = video;
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

}