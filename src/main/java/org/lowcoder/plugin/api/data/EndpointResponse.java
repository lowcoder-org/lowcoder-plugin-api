package org.lowcoder.plugin.api.data;

import java.util.List;
import java.util.Map;

/**
 * HTTP response data definition.
 */
public interface EndpointResponse 
{
	/**
	 * @return HTTP response code
	 */
	int statusCode();

	/**
	 * @return Response headers
	 */
	Map<String, List<String>> headers();

	/**
	 * @return Response cookies
	 */
	Map<String, List<Map.Entry<String, String>>> cookies();

	/**
	 * @return Response data
	 */
	byte[] body();
}
