package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the watchLater database table.
 * 
 */
@Entity
@Table(name="watchLater")
@NamedQuery(name="WatchLater.findAll", query="SELECT w FROM WatchLater w")
public class WatchLater implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean watched;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;

	public WatchLater() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getWatched() {
		return this.watched;
	}

	public void setWatched(boolean watched) {
		this.watched = watched;
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