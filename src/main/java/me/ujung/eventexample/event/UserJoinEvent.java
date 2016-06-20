package me.ujung.eventexample.event;

public class UserJoinEvent extends Event {

	private String id;
	private String phoneNumber;

	public UserJoinEvent(String id, String phoneNumber) {
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}