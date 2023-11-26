package org.lowcoder.plugin.api;

import java.util.List;
import java.util.function.Consumer;

import org.lowcoder.plugin.api.event.LowcoderEvent;

/**
 * Shared context which allows plugins to access services from Lowcoder main application
 * 
 * @author ludomikula
 *
 */
public interface LowcoderServices 
{
	/**
	 * Registers a listener method for events emitted by Lowcoder.
	 * 
	 * @param listener Listener method consuming events
	 */
	void registerEventListener(Consumer<LowcoderEvent> listener);
	
	/**
	 * Registers endpoints defined by plugins in Lowcoder.
	 * 
	 * @param urlPrefix Prefix used for endpoints (usually plugin Id)
	 * @param endpoints Collection of endpoints to register
	 */
	void registerEndpoints(String urlPrefix, List<PluginEndpoint> endpoints);
	
	/**
	 * Sets a configuration key/value pair in Lowcoder.
	 * 
	 * @param key Configuration key
	 * @param value Configuration value
	 */
	void setConfig(String key, Object value);

	/**
	 * Reads the value of a configuration property.
	 * 
	 * @param key Configuration key to read value for
	 * @return Configuration value or null if it does not exist
	 */
	Object getConfig(String key);
	
}
