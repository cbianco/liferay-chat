package it.cm.liferay.chat.web.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import it.cm.liferay.chat.web.constants.CMChatPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Mauro Celani
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + CMChatPortletKeys.CM_CHAT_PORTLET,
        "mvc.command.name=/chat/open"
    },
    service = MVCRenderCommand.class
)
public class OpenChatRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {

        return "/chat.jsp";
    }

}
