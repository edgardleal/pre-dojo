package br.com.edgardleal.amil.log.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.Player;
import br.com.edgardleal.amil.log.data.Weapon;
import br.com.edgardleal.amil.log.data.WorldKillGameEvent;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class WorldKillEventParser implements LogLineParser {
	List<LogEventListener> listeners = new ArrayList<LogEventListener>();
	/**
	 * Compila apenas uma vez porque regex é (relativamente) lento
	 */
	private static Pattern pattern = Pattern.compile(String.format("%s %s",
			DATE_PATTERN, "- <WORLD> killed (\\w+) by (\\w+)"));

	@Override
	public void parserLine(String line, List<GameEvent> events)
			throws ParserException {
		try {
			Matcher matcher = pattern.matcher(line);
			matcher.find();

			Player victim = new Player(matcher.group(2));
			Weapon weapon = new Weapon(matcher.group(3));
			WorldKillGameEvent event = new WorldKillGameEvent().setVictim(
					victim).setWeapon(weapon);
			event.setTime(dateFormat.parse(matcher.group(1)));
			events.add(event);
		} catch (Exception e) {
			throw new ParserException(e);
		}
	}

	@Override
	public boolean checkLine(String line) {
		return line != null && pattern.matcher(line).matches();
	}

	@Override
	public LogLineParser addEventListener(LogEventListener listener) {
		listeners.add(listener);
		return this;
	}

}
