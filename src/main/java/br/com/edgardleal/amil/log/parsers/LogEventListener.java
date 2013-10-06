/**
 * 
 */
package br.com.edgardleal.amil.log.parsers;

/**
 * @author Edgard Leal
 *
 */
public interface LogEventListener {
   public void logEvent(Class<? extends LogLineParser> parser, final String info);
}
