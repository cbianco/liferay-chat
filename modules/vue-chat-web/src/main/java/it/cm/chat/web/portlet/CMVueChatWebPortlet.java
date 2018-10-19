package it.cm.chat.web.portlet;

import com.liferay.frontend.js.loader.modules.extender.npm.JSPackage;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portal.util.PropsValues;
import it.cm.chat.web.constants.CMVueChatWebPortletKeys;
import it.cm.chat.web.constants.CMVueChatWebWebKeys;
import org.osgi.service.component.annotations.*;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Cristian Bianco
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.chat",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CMVueChatWebPortletKeys.VueChatWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CMVueChatWebPortlet extends MVCPortlet {

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
			layoutStaticPortletsAll, CMVueChatWebPortletKeys.VueChatWeb);

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
			CMVueChatWebPortletKeys.VueChatWeb,
			false);
	}

	/**
	 * This method remove the portlet from static portlet pool
	 */
	protected void removePortletIdLayoutStaticPortletsAll() {
		String[] layoutStaticPortletsAll =
			PropsValues.LAYOUT_STATIC_PORTLETS_ALL;

		layoutStaticPortletsAll = ArrayUtil.remove(
			layoutStaticPortletsAll, CMVueChatWebPortletKeys.VueChatWeb);

		PropsUtil.set(
			PropsKeys.LAYOUT_STATIC_PORTLETS_ALL,
			StringUtil.merge(layoutStaticPortletsAll));

		PropsValues.LAYOUT_STATIC_PORTLETS_ALL = layoutStaticPortletsAll;
	}

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		JSPackage jsPackage = _npmResolver.getJSPackage();

		renderRequest.setAttribute(
			CMVueChatWebWebKeys.BOOTSTRAP_REQUIRE,
			jsPackage.getResolvedId() + " as bootstrapRequire");

		super.doView(renderRequest, renderResponse);
	}

	@Reference
	private NPMResolver _npmResolver;

}