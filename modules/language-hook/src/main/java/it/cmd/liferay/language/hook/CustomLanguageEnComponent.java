package it.cmd.liferay.language.hook;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author maucel89
 *
 *	http://www.javasavvy.com/liferay-7-language-properties-hook/
 *
 */

@Component(
	property = { "language.id=en_US" }, 
	service = ResourceBundle.class
)
public class CustomLanguageEnComponent extends ResourceBundle {

	ResourceBundle bundle = ResourceBundle.getBundle(
		"content.Language_en", UTF8Control.INSTANCE);
	
	@Override
	protected Object handleGetObject(String key) {
		_log.trace("Getting language key: " + key);
		return bundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}
	
	private Log _log = LogFactoryUtil.getLog(CustomLanguageEnComponent.class);

}
