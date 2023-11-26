package org.lowcoder.plugin.api;

/**
 * All classes implementing an endpoint for Lowcoder need to implement this interface.
 * 
 * @author ludomikula
 */
public interface PluginEndpoint
{
	/**
	 * Method used in {@link EndpointExtension} for specifying endpoint method.<br>
	 * For example:<br>
	 * {@code @EndpointExtension(uri = "/navigation", method = Method.GET) }
	 */
	enum Method 
	{
		GET,
		PUT,
		POST,
		PATCH,
		DELETE,
		OPTIONS
	}
}
