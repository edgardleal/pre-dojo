/**
 * 
 */
package br.com.edgaredleal.amil.log.parsers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.edgardleal.amil.log.data.GameEvent;
import br.com.edgardleal.amil.log.data.KillGameEvent;
import br.com.edgardleal.amil.log.parsers.KillEventParser;
import br.com.edgardleal.amil.log.parsers.ParserException;

/**
 * @author Edgard Leal
 * 
 */
public class KillEventParserTest {

	KillEventParser parser;
	String line = "01/01/2012 15:10:10 Joao killed Pedro using Faca";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new KillEventParser();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckTrue() {
		assertTrue(parser
				.checkLine(line));
		assertTrue(parser
				.checkLine(line));
	}

	@Test
	public void testCheckAction() {
		assertTrue(!parser
				.checkLine("01/01/2012 15:10:10 Joao matou Pedro using Faca"));
	}

	@Test
	public void testCheckDate() {
		assertTrue(!parser
				.checkLine("01/01/12 15:10:10 Joao killed Pedro using Faca"));
	}

	@Test
	public final void testObjectReturn() throws ParserException {
		List<GameEvent> events = new ArrayList<GameEvent>();
		
		assertTrue(parser.checkLine(line));
		parser.parserLine(line, events);
		assertTrue(events.size() > 0);
		assertTrue(events.get(0) instanceof KillGameEvent);
		assertEquals("Joao", ((KillGameEvent) events.get(0)).getKiller().getName());
		assertEquals("Pedro", ((KillGameEvent) events.get(0)).getVictim().getName());
		assertEquals("Faca", ((KillGameEvent) events.get(0)).getWeapon().getName());
	}
}
