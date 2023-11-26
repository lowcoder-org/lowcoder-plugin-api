package org.lowcoder.plugin.api.data;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.lowcoder.plugin.api.PluginEndpoint.Method;

/**
 * HTTP request data definition
 * 
 * @author ludomikula
 */
public interface EndpointRequest 
{
	/**
	 * @return Requested URI
	 */
	URI uri();
	
	/**
	 * @return HTTP request method
	 */
	Method method();
	
	/**
	 * @return Request body
	 */
	public CompletableFuture<byte[]> body();

	/**
	 * @return Request headers
	 */
	Map<String, List<String>> headers();
	
	/**
	 * @param header Request header to retrieve
	 * @return Requested header values or null if not found
	 */
	default List<String> header(String header)
	{
		return headers().getOrDefault(header, null);
	}

	/**
	 * @return Cookies as found in request
	 */
	Map<String, List<Map.Entry<String, String>>> cookies();
	
	/**
	 * @param cookie Request cookie to retrieve
	 * @return Requested cookie values or null if not found
	 */
	default List<Map.Entry<String, String>> cookie(String cookie)
	{
		return cookies().getOrDefault(cookie, null);
	}
	
	/**
	 * @return Request attributes
	 */
	Map<String, Object> attributes();
	
	/**
	 * @param name Request attribute to retrieve
	 * @return Requested attribute value
	 */
	default Optional<Object> attribute(String name) 
	{
		return Optional.ofNullable(attributes().get(name));
	}
	
	/**
	 * @return Request path variables
	 */
	Map<String, String> pathVariables();
	
	/**
	 * Get the path variable with the given name, if present.
	 * @param name the variable name
	 * @return the variable value
	 * @throws IllegalArgumentException if there is no path variable with the given name
	 */
	default String pathVariable(String name) 
	{
		Map<String, String> pathVariables = pathVariables();
		if (pathVariables.containsKey(name)) 
		{
			return pathVariables().get(name);
		}
		else {
			throw new IllegalArgumentException("No path variable with name \"" + name + "\" available");
		}
	}

	/**
	 * @return Request query parameters
	 */
	Map<String, List<String>> queryParams();

	/**
	 * Get the path variable with the given name, if present.
	 * @param name the variable name
	 * @return the variable value
	 * @throws IllegalArgumentException if there is no path variable with the given name
	 */
	default List<String> queryParam(String name)
	{
		Map<String, List<String>> queryParams = queryParams();
		if (queryParams.containsKey(name))
		{
			return queryParams().get(name);
		}
		else {
			throw new IllegalArgumentException("No query param with name \"" + name + "\" available");
		}
	}

	/**
	 * @return Security principal
	 */
	CompletableFuture<? extends Principal> principal();	
}
