package entity;

import java.io.Serializable;
import javax.persistence.*;

import handler.Originator;

import java.sql.Timestamp;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@Table(name="subscription")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Timestamp time;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="channelId")
	private User channel;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User subscriber;

	public Subscription() {
		Originator.initDefaultSubscription(this);
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public User getChannel() {
		return this.channel;
	}

	public void setChannel(User user1) {
		this.channel = user1;
	}

	public User getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(User user2) {
		this.subscriber = user2;
	}

}