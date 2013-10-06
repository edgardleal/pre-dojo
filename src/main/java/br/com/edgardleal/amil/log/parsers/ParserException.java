package br.com.edgardleal.amil.log.parsers;

public class ParserException extends Exception {
	private static final long serialVersionUID = 1L;

	public ParserException() {
		super();
	}

	public ParserException(String message) {
		super(message);
	}
	public ParserException(long line) {
		super(String.format("Exception parsing line: [%d]", line));
	}

	public ParserException(Exception e) {
		super(e);
	}
	
}
