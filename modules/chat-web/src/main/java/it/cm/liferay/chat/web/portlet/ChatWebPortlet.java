package it.cm.liferay.chat.web.portlet;

import it.cm.liferay.chat.web.constants.ChatWebPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author maucel89
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ChatWeb",
		"javax.portlet.name=" + ChatWebPortletKeys.ChatWeb,
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ChatWebPortlet extends GenericPortlet {

	@Override
	protected void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PrintWriter printWriter = renderResponse.getWriter();

		printWriter.print("Hello from ChatWeb!");
	}

}