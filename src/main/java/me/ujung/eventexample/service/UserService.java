package me.ujung.eventexample.service;

import me.ujung.eventexample.domain.User;

public interface UserService {

	public State join(User aUser);

	public enum State {
		SUCCESS, EXIST_ID, FAIL
	}

}
