package br.com.edgaredleal.amil.log;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.edgaredleal.amil.log.parsers.DefaultLogFileParserTest;
import br.com.edgaredleal.amil.log.parsers.KillEventParserTest;
import br.com.edgaredleal.amil.log.parsers.RoundEndEventParserTest;
import br.com.edgaredleal.amil.log.parsers.RoundStartEventParserTest;
import br.com.edgaredleal.amil.log.parsers.WorldKillEventParserTest;

@RunWith(Suite.class)
@SuiteClasses({ KillEventParserTest.class, RoundStartEventParserTest.class,
		RoundEndEventParserTest.class, WorldKillEventParserTest.class,
		DefaultLogFileParserTest.class})
public class AllTests {

}
