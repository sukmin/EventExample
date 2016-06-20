package me.ujung.eventexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import me.ujung.eventexample.domain.User;
import me.ujung.eventexample.event.Events;
import me.ujung.eventexample.event.UserJoinEvent;

@Service
public class DefaultUserService implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

	@Override
	public State join(User aUser) {
		logger.info("가입신청 {}", aUser.toString());

		Events.handle((UserJoinEvent event) -> {
			logger.info("가입SMS발송 동기 1 " + event.getPhoneNumber());
		});
		Events.handle((UserJoinEvent event) -> {
			logger.info("가입SMS발송 동기 2 " + event.getPhoneNumber());
		});
		Events.handle((UserJoinEvent event) -> {
			logger.info("가입SMS발송 동기 3 " + event.getPhoneNumber());
		});

		Events.handleAsync((UserJoinEvent event) -> {
			logger.info("가입SMS발송 비동기 1 " + event.getPhoneNumber());
		});
		Events.handleAsync((UserJoinEvent event) -> {
			logger.info("가입SMS발송 비동기 2 " + event.getPhoneNumber());
		});
		Events.handleAsync((UserJoinEvent event) -> {
			logger.info("가입SMS발송 비동기 3 " + event.getPhoneNumber());
		});

		logger.info("가입처리 {}", aUser.toString());

		Events.raise(new UserJoinEvent(aUser.getId(), aUser.getPhoneNumber()));

		logger.info("가입완료 {}", aUser.toString());
		Events.reset();
		return State.SUCCESS;
	}

}
