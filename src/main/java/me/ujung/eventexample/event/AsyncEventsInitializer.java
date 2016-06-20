package me.ujung.eventexample.event;

import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class AsyncEventsInitializer {

	@PostConstruct
	public void init() {
		Events.init(Executors.newFixedThreadPool(10));
	}

	@PreDestroy
	public void close() {
		Events.close();
	}

}
