package br.com.edgardleal.amil.log.data;

import java.util.Date;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class RoundStartEvent implements GameEvent {
	private Date start;
	private Date time;

	public RoundStartEvent() {
		super();
	}

	public RoundStartEvent(Date start) {
		super();
		this.start = start;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Override
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
