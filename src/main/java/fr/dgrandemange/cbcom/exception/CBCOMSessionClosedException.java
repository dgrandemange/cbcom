package fr.dgrandemange.cbcom.exception;

/**
 * @author dgrandemange
 *
 */
@SuppressWarnings("serial")
public class CBCOMSessionClosedException extends CBCOMSessionException {

	public CBCOMSessionClosedException() {
		super();
	}

	public CBCOMSessionClosedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CBCOMSessionClosedException(String arg0) {
		super(arg0);
	}

	public CBCOMSessionClosedException(Throwable arg0) {
		super(arg0);
	}

}
