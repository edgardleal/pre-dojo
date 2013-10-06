package br.com.edgardleal.amil.log.data;

import java.util.Date;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class RoundStartEvent implements GameEvent {
	private Date time;
	private Round round = new Round();

	public RoundStartEvent() {
		super();
	}

	public RoundStartEvent(Date start) {
		super();
		this.time = start;
	}

	public Date getStart() {
		return time;
	}

	@Override
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public RoundStartEvent setRoundId(final long id) {
		round.setId(id);
		return this;
	}
}
