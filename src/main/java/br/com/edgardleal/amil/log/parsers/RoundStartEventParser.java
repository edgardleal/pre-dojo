package br.com.edgardleal.amil.log.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.RoundStartEvent;

/**
 * 
 * @author Edgard Leal
 * 
 */
public class RoundStartEventParser implements LogLineParser {
	List<LogEventListener> listeners = new ArrayList<LogEventListener>();
	/**
	 * Compila apenas uma vez porque regex é (relativamente) lento
	 */
	private static Pattern pattern = Pattern.compile(String.format("%s %s",
			DATE_PATTERN, "- New match (\\d+) has started"));

	@Override
	public void parserLine(String line, List<GameEvent> events)
			throws ParserException {
		try {
			Matcher matcher = pattern.matcher(line);
			matcher.find();

			RoundStartEvent event = new RoundStartEvent(
					dateFormat.parse(matcher.group(1))).setRoundId(Long
					.valueOf(matcher.group(2)));

			events.add(event);
		} catch (Exception e) {
			throw new ParserException(e);
		}
	}

	@Override
	public boolean checkLine(final String line) {
		return line != null && pattern.matcher(line).matches();
	}

	@Override
	public LogLineParser addEventListener(LogEventListener listener) {
		listeners.add(listener);
		return this;
	}
}
