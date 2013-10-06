/**
 * 
 */
package br.com.edgardleal.amil.log.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.edgardleal.amil.log.data.Round;
import br.com.edgardleal.amil.log.parsers.KillEventParser;
import br.com.edgardleal.amil.log.parsers.LogFileParser;
import br.com.edgardleal.amil.log.parsers.LogLineParser;
import br.com.edgardleal.amil.log.parsers.ParserException;
import br.com.edgardleal.amil.log.parsers.RoundEndEventParser;
import br.com.edgardleal.amil.log.parsers.RoundStartEventParser;
import br.com.edgardleal.amil.log.parsers.WorldKillEventParser;

/**
 * @author Edgard Leal
 * 
 */
public class DefaultLogFileParser implements LogFileParser, LogEventListener {

	LogLineParser parsers[] = new LogLineParser[] { 
			new KillEventParser().addEventListener(this),
			new WorldKillEventParser().addEventListener(this), 
			new RoundStartEventParser().addEventListener(this),
			new RoundEndEventParser().addEventListener(this) };

	@Override
	public List<Round> parser(File file) {
		BufferedReader reader = null;
		List<Round> rounds = new ArrayList<Round>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				for (LogLineParser parser : parsers) {
					if (parser.checkLine(line)) {
						parser.parserLine(line, rounds.get(rounds.size() - 1)
								.getEvents());
						continue;
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return rounds;
	}

	@Override
	public void logEvent(Class<? extends LogLineParser> parser, String info) {
		// TODO Auto-generated method stub
		
	}

}
