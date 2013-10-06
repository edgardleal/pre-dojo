package br.com.edgardleal.amil.log.parsers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.KillGameEvent;
import br.com.edgardleal.amil.log.data.Player;
import br.com.edgardleal.amil.log.data.Weapon;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class KillEventParser implements LogLineParser {
	/**
	 * Compila apenas uma vez porque regex é (relativamente) lento
	 */
	private static Pattern pattern = Pattern.compile(String.format("%s %s",
			DATE_PATTERN, "- (\\w+) killed (\\w+) using (\\w+)"));

	
	
	@Override
	public void parserLine(String line, List<GameEvent> events)
			throws ParserException {
		try {
			Matcher matcher = pattern.matcher(line);
			matcher.find();
			
			Player killer = new Player(matcher.group(2));
			Player victim = new Player(matcher.group(3));
			Weapon weapon = new Weapon(matcher.group(4));
			KillGameEvent event = new KillGameEvent().setKiller(killer).setVictim(victim)
					.setWeapon(weapon);
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

}
