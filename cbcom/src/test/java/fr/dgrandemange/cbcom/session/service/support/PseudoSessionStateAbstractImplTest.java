package fr.dgrandemange.cbcom.session.service.support;

import junit.framework.TestCase;
import fr.dgrandemange.cbcom.exception.CBCOMSessionStateException;
import fr.dgrandemange.cbcom.session.server.service.support.DummyState;

/**
 * @author dgrandemange
 *
 */
public class PseudoSessionStateAbstractImplTest extends TestCase {

	private DummyState state = new DummyState();
	
	public void testTransNotImplementedForCurrState() {
			try {
				state.onIpduCNReceived(null);
				fail("Exception expected");
			} catch (CBCOMSessionStateException e) {
				assertEquals(DummyState.class.getSimpleName(), e.getState());
				assertEquals("onIpduCNReceived", e.getTransition());
			}
		}

}
