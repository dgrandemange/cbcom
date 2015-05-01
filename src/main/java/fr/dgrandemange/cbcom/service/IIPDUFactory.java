package fr.dgrandemange.cbcom.service;

import fr.dgrandemange.cbcom.exception.CBCOMException;
import fr.dgrandemange.cbcom.model.IPDU;

/**
 * Factory that creates IPDU instances from different sources
 * 
 * @author dgrandemange
 * 
 */
public interface IIPDUFactory {

	/**
	 * @param ipduExtractSrv
	 *            Service that offer a strategy to extract IPDU parts from an
	 *            input stream
	 * @return IPDU extracted from input stream
	 * @exception CBCOMException
	 *                if unable to extract a valid IPDU
	 */
	IPDU create(IIPDUExtractionService ipduExtractSrv)
			throws CBCOMException;

}
