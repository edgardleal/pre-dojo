/**
 * 
 */
package br.com.edgardleal.amil.log.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.com.edgardleal.amil.log.data.Round;


/**
 * @author Edgard Leal
 *
 */
public interface LogFileParser {
	
	public List<Round> parser(File file) throws ParserException, IOException;
}
