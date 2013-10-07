package br.com.edgaredleal.amil.log.parsers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.edgardleal.amil.log.data.Round;
import br.com.edgardleal.amil.log.parsers.DefaultLogFileParser;

public class DefaultLogFileParserTest {

	DefaultLogFileParser fileParser;

	@Before
	public void setUp() throws Exception {
		fileParser = new DefaultLogFileParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadFile() {
		fileParser.parser(new File("log100.log"));
	}

	@Test
	public void testLoadFileContent() {
		List<Round> rounds = fileParser.parser(new File("log100.log"));
		assertTrue(rounds!=null);
		assertTrue(rounds.size()>0);
		assertTrue(rounds.get(0).getEvents().size()>0);
	}
}
