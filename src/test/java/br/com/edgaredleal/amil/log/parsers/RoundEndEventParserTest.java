package br.com.edgaredleal.amil.log.parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.RoundEndEvent;
import br.com.edgardleal.amil.log.parsers.ParserException;
import br.com.edgardleal.amil.log.parsers.RoundEndEventParser;

public class RoundEndEventParserTest {

	private final String line = "23/04/2013 15:34:22 - Match 11348965 has ended";
	private RoundEndEventParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new RoundEndEventParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckOk() {
		assertTrue(parser.checkLine(line));
	}

	@Test(expected = ParserException.class)
	public void testWrongParse() throws ParserException {
		List<GameEvent> events = new ArrayList<GameEvent>();
		parser.parserLine("15/45/41 44:88:44 - match ended", events);
	}

	@Test
	public void testParse() throws ParserException {
		List<GameEvent> events = new ArrayList<GameEvent>();
		parser.parserLine(line, events);
		assertTrue(events.size() > 0);
		assertTrue(events.get(0) instanceof RoundEndEvent);
		assertEquals(11348965, ((RoundEndEvent) events.get(0)).getRound()
				.getId());
	}

}
