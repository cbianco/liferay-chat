package it.cmd.liferay.chat.react.web.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import it.cmd.liferay.chat.react.web.constants.ChatReactPortletKeys;
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
        "javax.portlet.name=" + ChatReactPortletKeys.CHAT_REACT_PORTLET,
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
