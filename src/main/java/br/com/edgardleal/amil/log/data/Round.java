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
}
