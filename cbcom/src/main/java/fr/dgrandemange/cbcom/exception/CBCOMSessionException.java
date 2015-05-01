package fr.dgrandemange.cbcom.exception;

/**
 * @author dgrandemange
 *
 */
@SuppressWarnings("serial")
public class CBCOMSessionException extends RuntimeException {

	public CBCOMSessionException() {
		super();
	}

	public CBCOMSessionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CBCOMSessionException(String arg0) {
		super(arg0);
	}

	public CBCOMSessionException(Throwable arg0) {
		super(arg0);
	}

}
