package fr.dgrandemange.cbcom.session.model;

import java.util.List;
import java.util.concurrent.Future;

import fr.dgrandemange.cbcom.model.IPDU;
import fr.dgrandemange.cbcom.model.PI;
import fr.dgrandemange.cbcom.service.IIPDUFactory;
import fr.dgrandemange.cbcom.session.service.IChannelCallback;
import fr.dgrandemange.cbcom.session.service.IIdentificationProtocolValidator;
import fr.dgrandemange.cbcom.session.service.IPseudoSessionState;
import fr.dgrandemange.cbcom.session.service.ISessionStateFactory;
import fr.dgrandemange.cbcom.session.service.IThreadPoolExecutorProvider;

/**
 * A context dedidacted to a CBCOM pseudo session.<BR>
 * Its life cycle is bounded to the pseudo session life cycle.<BR>
 * Wraps the current pseudo session state. <BR>
 * 
 * @author dgrandemange
 * 
 */
/**
 * @author dgrandemange
 * 
 */
public class PseudoSessionContext implements Cloneable {

	/**
	 * Context id
	 */
	private long id;

	/**
	 * Pseudo session state
	 */
	private IPseudoSessionState sessionState;

	/**
	 * Last IPDU received
	 */
	private IPDU ipdu;

	/**
	 * Last apdu to send
	 */
	private byte[] apdu;

	/**
	 * channel callback
	 */
	protected IChannelCallback channelCallback;

	/**
	 * Session state factory
	 */
	protected ISessionStateFactory stateFactory;

	/**
	 * ipdu factory
	 */
	protected IIPDUFactory ipduFactory;

	/**
	 * Thread pool executor provider
	 */
	private IThreadPoolExecutorProvider pseudoSessionTimerTasksExecutorProvider;
	
	/**
	 * Future on any timer expiration related task
	 */
	private Future<?> taskFuture = null;

	/**
	 * Timer configuration
	 */
	private TimerConfig timerConfig;

	/**
	 * CBCOM protocol identification<BR>
	 * 4 bytes composition : <BR>
	 * 
	 * byte 1 : CBCOM protocol version number (0x11=CBCOM version 1.1, 0x12=CBCOM
	 * version 1.2, ...<BR>
	 * 
	 * byte 2 : application protocol type among {0x01=CB2A transfer, 0x02=CB2A
	 * transactional, 0x03=CB2A file}<BR>
	 * 
	 * byte 3-4 : application protocol version number (0x1230 stands for
	 * application protocol version number 1.2.3)<BR>>
	 */
	private byte[] protocolIdentification;

	/**
	 * List of PIs to send in the next IPDU
	 */
	private List<PI> timerPIs;

	private byte cbcomProtocolVersion;

	private byte[] cb2aProtocolVersion;

	private byte protocolType;

	private IIdentificationProtocolValidator idProtValidator;

	public IPseudoSessionState getSessionState() {
		return sessionState;
	}

	public void setSessionState(IPseudoSessionState sessionState) {
		this.sessionState = sessionState;
	}

	public IPDU getIpdu() {
		return ipdu;
	}

	public void setIpdu(IPDU ipdu) {
		this.ipdu = ipdu;
	}

	public IChannelCallback getChannelCallback() {
		return channelCallback;
	}

	public void setChannelCallback(IChannelCallback channelCallback) {
		this.channelCallback = channelCallback;
	}

	public ISessionStateFactory getStateFactory() {
		return stateFactory;
	}

	public void setStateFactory(ISessionStateFactory stateFactory) {
		this.stateFactory = stateFactory;
	}

	public IIPDUFactory getIpduFactory() {
		return ipduFactory;
	}

	public void setIpduFactory(IIPDUFactory ipduFactory) {
		this.ipduFactory = ipduFactory;
	}

	public Future<?> getTaskFuture() {
		return taskFuture;
	}

	public void setTaskFuture(Future<?> taskFuture) {
		this.taskFuture = taskFuture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getApdu() {
		return apdu;
	}

	public void setApdu(byte[] apdu) {
		this.apdu = apdu;
	}

//	public ScheduledExecutorService getDefferedTaskExecutor() {
//		return defferedTaskExecutor;
//	}
//
//	public void setDefferedTaskExecutor(
//			ScheduledExecutorService defferedTaskExecutor) {
//		this.defferedTaskExecutor = defferedTaskExecutor;
//	}

	public byte[] getProtocolIdentification() {
		return protocolIdentification;
	}

	public void setProtocolIdentification(byte[] protocolIdentification) {
		this.protocolIdentification = protocolIdentification;
	}

	public TimerConfig getTimerConfig() {
		return timerConfig;
	}

	public void setTimerConfig(TimerConfig timerConfig) {
		this.timerConfig = timerConfig;
	}

	public List<PI> getTimerPIs() {
		return timerPIs;
	}

	public void setTimerPIs(List<PI> timerPIs) {
		this.timerPIs = timerPIs;
	}

	public void setCbcomProtocolVersion(byte cbcomProtocolVersion) {
		this.cbcomProtocolVersion = cbcomProtocolVersion;
	}

	public void setProtocolType(byte protocolType) {
		this.protocolType = protocolType;
	}

	public void setCb2aProtocolVersion(byte[] cb2aProtocolVersion) {
		this.cb2aProtocolVersion = cb2aProtocolVersion;
	}

	public byte getCbcomProtocolVersion() {
		return cbcomProtocolVersion;
	}

	public byte getProtocolType() {
		return protocolType;
	}

	public byte[] getCb2aProtocolVersion() {
		return cb2aProtocolVersion;
	}

	public IIdentificationProtocolValidator getIdProtValidator() {
		return idProtValidator;
	}

	public void setIdProtValidator(
			IIdentificationProtocolValidator idProtValidator) {
		this.idProtValidator = idProtValidator;
	}

	public IThreadPoolExecutorProvider getPseudoSessionTimerTasksExecutorProvider() {
		return pseudoSessionTimerTasksExecutorProvider;
	}

	public void setPseudoSessionTimerTasksExecutorProvider(
			IThreadPoolExecutorProvider pseudoSessionTimerTasksExecutorProvider) {
		this.pseudoSessionTimerTasksExecutorProvider = pseudoSessionTimerTasksExecutorProvider;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {

		PseudoSessionContext clone = new PseudoSessionContext();

		clone.setIpduFactory(this.getIpduFactory());
		clone.setChannelCallback(this.getChannelCallback());
		clone.setPseudoSessionTimerTasksExecutorProvider(this.getPseudoSessionTimerTasksExecutorProvider());
		clone.setProtocolIdentification(this.getProtocolIdentification());
		clone.setSessionState(this.getSessionState());
		clone.setStateFactory(this.getStateFactory());
		clone.setTimerConfig(this.getTimerConfig());
		clone.setCbcomProtocolVersion(this.cbcomProtocolVersion);
		clone.setProtocolType(this.protocolType);
		clone.setCb2aProtocolVersion(this.cb2aProtocolVersion);
		clone.setIdProtValidator(this.idProtValidator);

		clone.setId(this.getId());
		clone.setIpdu(this.getIpdu());
		clone.setApdu(this.getApdu());
		clone.setTaskFuture(this.getTaskFuture());

		return clone;
	}

}
