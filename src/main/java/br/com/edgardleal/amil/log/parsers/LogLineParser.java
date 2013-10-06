/**
 * 
 */
package br.com.edgardleal.amil.log.parsers;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.edgardleal.amil.log.data.GameEvent;

/**
 * @author Edgard Leal
 * 
 */
public interface LogLineParser {
	public static final String DATE_PATTERN = "(\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2})";
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	public void parserLine(final String line, List<GameEvent> events)
			throws ParserException;

	public boolean checkLine(final String line);
	public LogLineParser addEventListener(LogEventListener listener);
}
