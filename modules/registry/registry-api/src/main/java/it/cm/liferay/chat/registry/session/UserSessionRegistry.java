package it.cm.liferay.chat.registry.session;

import com.liferay.portal.kernel.exception.PortalException;
import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.Session;
import java.util.Collection;

/**
 * @author Mauro Celani
 */
public interface UserSessionRegistry {

	public void addUserTopic(ClientMessage message);

	public long openTopic(
			long currentUserId, long targetUserId, long companyId, long groupId)
		throws PortalException;

	public void addUserSession(long userId, boolean online, Session session);

	public UserSession clearUserSession(long userId);

	public Collection<Long> getOnlineUsers(long userId);

	public void notifyOthers(long userId);

	public UserSession getUserSession(long userId);
}
