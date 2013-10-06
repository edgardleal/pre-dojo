package br.com.edgardleal.amil.log.data;

import java.util.Date;

public class GameLogEvent implements GameEvent, Comparable<GameEvent> {
	private Date time;

	public GameLogEvent() {
		super();
	}

	public GameLogEvent(Date time) {
		super();
		this.time = time;
	}

	@Override
	public Date getTime() {
		return time;
	}

	@Override
	public int compareTo(GameEvent o) {
		return time.getTime() > o.getTime().getTime() ? 1 : time.getTime() < o
				.getTime().getTime() ? -1 : 0;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
