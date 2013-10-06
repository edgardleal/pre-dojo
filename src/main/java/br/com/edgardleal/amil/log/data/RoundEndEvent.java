package br.com.edgardleal.amil.log.data;

import java.util.Date;

/**
 * Não deve ser ordenado por ser o ultimo item da lista
 * 
 * @author Edgard Leal
 * 
 */
public class RoundEndEvent implements GameEvent {

	private Round round = new Round();
	private Date time;

	public RoundEndEvent() {
		super();
	}

	public RoundEndEvent(Date time, long id) {
		super();
		this.time = time;
		round.setId(id);
	}

	@Override
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public RoundEndEvent setRoundId(final long id) {
		round.setId(id);
		return this;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	
}
