package it.cm.liferay.chat.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.PropsValues;
import it.cm.liferay.chat.web.constants.CMChatPortletKeys;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.Portlet;
import java.util.Map;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.css-class-wrapper=cm-chat",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.system=true",
		"com.liferay.portlet.use-default-template=false",
		"javax.portlet.display-name=CMChatWeb",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CMChatPortletKeys.CM_CHAT_PORTLET,
		"javax.portlet.portlet-info.keywords=CMChatWeb",
		"javax.portlet.portlet-info.short-title=CMChatWeb",
		"javax.portlet.portlet-info.title=CMChatWeb",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class CMChatPortlet extends MVCPortlet {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		if (!hasPortletId()) {
			addPortletIdLayoutStaticPortletsAll();
		}
	}

	/**
	 * This method add the portlet as a static portlet inside page
	 */
	protected void addPortletIdLayoutStaticPortletsAll() {
		String[] layoutStaticPortletsAll =
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL;

		layoutStaticPortletsAll = ArrayUtil.append(
			layoutStaticPortletsAll, CMChatPortletKeys.CM_CHAT_PORTLET);

		PropsUtil.set(
			PropsKeys.LAYOUT_STATIC_PORTLETS_ALL,
			StringUtil.merge(layoutStaticPortletsAll));

		PropsValues.LAYOUT_STATIC_PORTLETS_ALL = layoutStaticPortletsAll;
	}

	@Deactivate
	@Modified
	protected void deactivate(Map<String, Object> properties) {
		if (hasPortletId()) {
			removePortletIdLayoutStaticPortletsAll();
		}
	}

	/**
	 * This method check if the portlet is already inside static portlet pool
	 *
	 * @return if the portlet is already inside static portlet array
	 */
	protected boolean hasPortletId() {
		return ArrayUtil.contains(
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL,
			CMChatPortletKeys.CM_CHAT_PORTLET,
			false);
	}

	/**
	 * This method remove the portlet from static portlet pool
	 */
	protected void removePortletIdLayoutStaticPortletsAll() {
		String[] layoutStaticPortletsAll =
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL;

		layoutStaticPortletsAll = ArrayUtil.remove(
			layoutStaticPortletsAll, CMChatPortletKeys.CM_CHAT_PORTLET);

		PropsUtil.set(
			PropsKeys.LAYOUT_STATIC_PORTLETS_ALL,
			StringUtil.merge(layoutStaticPortletsAll));

		PropsValues.LAYOUT_STATIC_PORTLETS_ALL = layoutStaticPortletsAll;
	}

}