package org.lowcoder.plugin.api.event;

import java.util.Map;

/**
 * Interface for events transmitted by Lowcoder.
 */
public interface LowcoderEvent 
{
	/**
	 * @return IP address of user who generated the event, if available.
	 */
	default String getIpAddress() {
		return null;
	}
	
	/**
	 * @return Session hash of user who generated the event, if available.
	 */
	default String getSessionHash() {
		return null;
	}

	/**
	 * @return True if user who generated the event is not known yet, false otherwise.
	 */
	default Boolean getIsAnonymous()
	{
		return null;
	}
	
	/**
	 * @return Current Organization ID of the user who generated the event, if available.
	 */
	default String getOrgId()
	{
		return null;
	}
	
	/**
	 * @return User Id of the user who generated the event, if available.
	 */
	default String getUserId()
	{
		return null;
	}
	
	/**
	 * @return Map of additional event properties.
	 */
	Map<String, Object> details();
	
	/**
	 * Set additional property in the event.
	 * 
	 * @param name Event property name
	 * @param value Event property vaue
	 */
	default void detail(String name, String value)
	{		
		details().put(name, value);
	}
	
	/**
	 * @return Event type and action
	 */
	EventType getEventType();
	
	/**
	 * Events generated by Lowcoder.
	 */
	enum EventType {
		
		/* User events */
		USER_LOGIN(Type.USER, Action.LOGIN),
		USER_LOGOUT(Type.USER, Action.LOGOUT),
		
		/* Application events */
		APPLICATION_VIEW(Type.APPLICATION, Action.VIEW),
		APPLICATION_CREATE(Type.APPLICATION, Action.CREATE),
		APPLICATION_DELETE(Type.APPLICATION, Action.DELETE),
		APPLICATION_UPDATE(Type.APPLICATION, Action.UPDATE),
		APPLICATION_MOVE(Type.APPLICATION, Action.MOVE),
		APPLICATION_RECYCLED(Type.APPLICATION, Action.RECYCLE),
		APPLICATION_RESTORE(Type.APPLICATION, Action.RESTORE),
		
		/* Folder events */
		FOLDER_CREATE(Type.FOLDER, Action.CREATE),
		FOLDER_DELETE(Type.FOLDER, Action.DELETE),
		FOLDER_UPDATE(Type.FOLDER, Action.UPDATE),

		/* Query events */
		QUERY_EXECUTION(Type.QUERY, Action.EXECUTE),
		
		/* Group events */
		GROUP_CREATE(Type.GROUP, Action.CREATE),
		GROUP_UPDATE(Type.GROUP, Action.UPDATE),
		GROUP_DELETE(Type.GROUP, Action.DELETE),
		
		/* Group member events */
		GROUP_MEMBER_ADD(Type.GROUP, Type.MEMBER, Action.ADD),
		GROUP_MEMBER_ROLE_UPDATE(Type.GROUP, Type.MEMBER, Type.ROLE, Action.UPDATE),
		GROUP_MEMBER_LEAVE(Type.GROUP, Type.MEMBER, Action.LEAVE),
		GROUP_MEMBER_REMOVE(Type.GROUP, Type.MEMBER, Action.REMOVE),
		
		/* Server events */
		SERVER_START_UP(Type.SYSTEM, Action.STARTUP),
		SERVER_INFO(Type.SYSTEM, Action.VIEW),
		
		/* Datasource events */
		DATA_SOURCE_CREATE(Type.DATASOURCE, Action.CREATE),
		DATA_SOURCE_UPDATE(Type.DATASOURCE, Action.UPDATE),
		DATA_SOURCE_DELETE(Type.DATASOURCE, Action.DELETE),
	    DATA_SOURCE_PERMISSION_GRANT(Type.DATASOURCE, Type.PERMISSION, Action.GRANT),
	    DATA_SOURCE_PERMISSION_UPDATE(Type.DATASOURCE, Type.PERMISSION, Action.UPDATE),
	    DATA_SOURCE_PERMISSION_DELETE(Type.DATASOURCE, Type.PERMISSION, Action.DELETE),

	    /* Library query events */
	    LIBRARY_QUERY_CREATE(Type.LIBRARY_QUERY, Action.CREATE),
	    LIBRARY_QUERY_UPDATE(Type.LIBRARY_QUERY, Action.UPDATE),
	    LIBRARY_QUERY_DELETE(Type.LIBRARY_QUERY, Action.DELETE),
	    LIBRARY_QUERY_PUBLISH(Type.LIBRARY_QUERY, Action.PUBLISH),

		/* API call event */

		API_CALL_EVENT(Type.API_CALL, Action.NONE);
		
		
		private EventType(Type type, Action action)
		{
			this(type, Type.NONE, action);
		}

		private EventType(Type type, Type subType, Action action)
		{
			this(type, subType, Type.NONE, action);
		}
		
		private EventType(Type type, Type subType, Type subSubType, Action action)
		{
			this.type = type;
			this.subType = subType;
			this.subSubType = subSubType;
			this.action = action;			
		}
		
		private Type type;
		private Type subType;
		private Type subSubType;
		private Action action;

		public Type getType()
		{
			return this.type;
		}

		public Type getSubType()
		{
			return this.subType;
		}

		public Type getSubSubType()
		{
			return this.subSubType;
		}

		public Action getAction()
		{
			return this.action;
		}
	}
	
	/**
	 * Type of event.
	 */
	enum Type {
		NONE,
		SYSTEM,
		USER,
		APPLICATION,
		FOLDER,
		QUERY,
		GROUP,
		MEMBER,
		ROLE,
		PERMISSION,
		LIBRARY_QUERY,
		DATASOURCE,
		API_CALL
	}
	
	/**
	 * Type of event action.
	 */
	enum Action {
		NONE,
		STARTUP,
		SHUTDOWN,
		LOGIN,
		LOGOUT,
		CREATE,
		READ,
		UPDATE,
		DELETE,
		PUBLISH,
		VIEW,
		EXECUTE,
		MOVE,
		RECYCLE,
		RESTORE,
		ADD,
		REMOVE,
		LEAVE,
		GRANT,
		REVOKE
	}
}