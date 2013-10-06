package br.com.edgardleal.amil.log.data;

import java.util.Date;
/**
 * Não deve ser ordenado por ser o ultimo item da lista
 * @author Edgard Leal
 *
 */
public class RoundEndEvent implements GameEvent {

	private Date time;

	public RoundEndEvent() {
		super();
	}

	public RoundEndEvent(Date time) {
		super();
		this.time = time;
	}

	@Override
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
