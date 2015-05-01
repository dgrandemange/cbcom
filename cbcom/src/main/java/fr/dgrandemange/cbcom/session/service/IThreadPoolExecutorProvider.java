package fr.dgrandemange.cbcom.session.service;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Describes an thread pool executor provider
 * 
 * @author dgrandemange
 *
 */
public interface IThreadPoolExecutorProvider {
	
	/**
	 * Executor service instance provider passing the expected class of thread pool executor 
	 * 
	 * @return thread pool executor instance if one matches name and class 
	 */
	<T extends ThreadPoolExecutor> T provide(Class<T> clazz);
}
