package org.lowcoder.plugin.api;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.lowcoder.plugin.api.PluginEndpoint.Method;


/**
 * Annotation used for marking Lowcoder endpoints.<br>
 * Provides basic information required for registering an endpoint in Lowcoder.
 * 
 * @author ludomikula
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface EndpointExtension 
{
	/**
	 * @return URI to which to bind annotated method to
	 */
	String uri();
	
	/**
	 * @return HTTP method for this annotated endpoint
	 */
	Method method() default Method.GET;
	
	/**
	 * @return Endpoint will be secured by this SPeL expression. Empty expression means not secured.
	 */
	String authorize() default "";
}
