package fr.dgrandemange.cbcom.exception;

/**
 * @author dgrandemange
 * 
 */
@SuppressWarnings("serial")
public class CBCOMException extends Exception {

	/**
	 * PI01 value associated to the exception<BR>
	 * Typical use is to pass it in an IPDU AB<BR>
	 * Default value is 0x04
	 */
	private byte pv01 = 0x04;

	public CBCOMException() {
		super();
	}

	public CBCOMException(byte pv01) {
		super();
		this.pv01 = pv01;
	}

	public CBCOMException(String arg0, Throwable arg1, byte pv01) {
		super(arg0, arg1);
		this.pv01 = pv01;
	}

	public CBCOMException(String arg0, byte pv01) {
		super(arg0);
		this.pv01 = pv01;
	}

	public CBCOMException(Throwable arg0, byte pv01) {
		super(arg0);
		this.pv01 = pv01;
	}

	public byte getPI01Value() {
		return pv01;
	}

	public String getMessage() {
		StringBuffer buf = new StringBuffer();
		
		String pi01 = Integer
				.toString((this.getPI01Value() & 0xff) + 0x100, 16)
				.substring(1);
		buf.append(String.format(
				"CBCOM pseudo session response code (PIO1) = %s", pi01));
		
		if (this.getCause() != null) {
			buf.append("/nCause : ");
			buf.append(this.getCause().getClass().getName());
			buf.append(" ");
			buf.append(this.getCause().getMessage());
		}
		
		return buf.toString();
	}

}
