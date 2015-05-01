package fr.dgrandemange.cbcom.service.support;

import java.io.ByteArrayInputStream;

import fr.dgrandemange.cbcom.exception.CBCOMException;
import fr.dgrandemange.cbcom.service.IIPDUExtractionService;

/**
 * IPDU extraction service
 * 
 * @author dgrandemange
 * 
 */
public class IPDUExtractionServiceImpl implements IIPDUExtractionService {

	/**
	 * IPDU len as read in 4 bytes header
	 */
	private int ipduLen;

	private ByteArrayInputStream ipduIs;

	/**
	 * @param bufIpdu
	 * @param ipduLen
	 * @throws CBCOMException
	 */
	public IPDUExtractionServiceImpl(byte[] bufIpdu, int ipduLen) {
		super();
		this.ipduLen = ipduLen;
		this.ipduIs = new ByteArrayInputStream(bufIpdu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dgrandemange.cbcom.service.IIPDUExtractionService#getApdu(int)
	 */
	public byte[] getApdu(int apduLen) {
		byte[] buf = new byte[apduLen];
		ipduIs.read(buf, 0, apduLen);
		return buf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dgrandemange.cbcom.service.IIPDUExtractionService#getIpduLGI()
	 */
	public int getIpduLGI() {
		byte[] buf = new byte[1];
		ipduIs.read(buf, 0, 1);
		return buf[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dgrandemange.cbcom.service.IIPDUExtractionService#getIpduLen()
	 */
	public int getIpduLen() {
		return ipduLen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dgrandemange.cbcom.service.IIPDUExtractionService#getIpduPGI()
	 */
	public byte getIpduPGI() {
		byte[] buf = new byte[1];
		ipduIs.read(buf, 0, 1);
		return buf[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.dgrandemange.cbcom.service.IIPDUExtractionService#getIpduParams
	 * (int)
	 */
	public byte[] getIpduParams(int lgi) {
		byte[] buf = new byte[lgi];
		ipduIs.read(buf, 0, lgi);
		return buf;
	}

}