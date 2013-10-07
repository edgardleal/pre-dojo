package br.com.edgardleal.amil.log.data;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class Round {
	private static long roundIdGenerator = 0;
	private long id;

	private List<GameEvent> events = new ArrayList<>();

	public static synchronized long getNewId() {
		return ++roundIdGenerator;
	}

	public long getId() {
		return id;
	}

	public Round setId(long id) {
		this.id = id;
		return this;
	}

	public List<GameEvent> getEvents() {
		return events;
	}

	public void setEvents(List<GameEvent> events) {
		this.events = events;
	}
}
