/**
 * 
 */
package br.com.edgaredleal.amil.log.parsers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.WorldKillGameEvent;
import br.com.edgardleal.amil.log.parsers.ParserException;
import br.com.edgardleal.amil.log.parsers.WorldKillEventParser;

/**
 * @author Edgard Leal
 * 
 */
public class WorldKillEventParserTest {

	WorldKillEventParser parser;
	String line = "01/01/2012 15:10:10 - <WORLD> killed Pedro by DROWN";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new WorldKillEventParser();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckTrue() {
		assertTrue(parser.checkLine(line));
		assertTrue(parser.checkLine(line));
	}

	@Test
	public void testCheckAction() {
		assertTrue(!parser
				.checkLine("01/01/2012 15:10:10 - <WORLD> afogou Pedro using Faca"));
	}

	@Test(expected = ParserException.class)
	public void testWrongKiller() throws ParserException {
		List<GameEvent> events = new ArrayList<GameEvent>();
		parser.parserLine("01/01/2012 15:10:10 - Maria afogou Pedro using Faca", events);
	}

	@Test
	public void testCheckDate() {
		assertTrue(!parser
				.checkLine("01/01/12 15:10:10 - Joao killed Pedro using Faca"));
	}

	@Test
	public final void testObjectReturn() throws ParserException {
		List<GameEvent> events = new ArrayList<GameEvent>();

		assertTrue(parser.checkLine(line));
		parser.parserLine(line, events);
		assertTrue(events.size() > 0);
		assertTrue(events.get(0) instanceof WorldKillGameEvent);
		assertEquals("Pedro", ((WorldKillGameEvent) events.get(0)).getVictim()
				.getName());
		assertEquals("DROWN", ((WorldKillGameEvent) events.get(0)).getWeapon()
				.getName());
	}
}
