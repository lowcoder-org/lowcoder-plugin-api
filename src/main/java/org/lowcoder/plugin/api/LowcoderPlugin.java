package org.lowcoder.plugin.api;

import java.util.List;
import java.util.Map;

/**
 * Interface to be implemented by all Lowcoder plugins.
 * 
 * @author ludomikula
 *
 */
public interface LowcoderPlugin 
{
	/**
	 * Load the plugin.
	 * 
	 * @param environment Environment properties propagated from Lowcoder
	 * @param lowcoderServices services shared from Lowcoder main application
	 * @return true if we successfully loaded the plugin, false otherwise
	 */
	boolean load(Map<String, Object> environment, LowcoderServices lowcoderServices);
	
	/**
	 * Unload the plugin - this method is called on API server shutdown.
	 * Free all resources, close all files etc in this method.
	 */
	void unload();
	
	/**
	 * Plugin Id must match following regex: {@code ^[a-zA-Z0-9-_]{5+}$ }.
	 * 
	 * @return Unique plugin ID
	 */
    String pluginId();
    
    /**
     * @return Plugin information serialized as part of /plugins listing.
     */
    Object pluginInfo();
    
    /**
     * @return Plugin description
     */
    String description();
    
    /**
     * @return Order in which to load the plugin. Lower number gets loaded first.
     */
    int loadOrder();

    /**
     * @return All endpoints defined by this plugin.
     */
    List<PluginEndpoint> endpoints();
}
