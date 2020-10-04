<%@ include file="../init.jsp" %>

<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portlet.usersadmin.search.UserSearch" %>
<%@ page import="com.liferay.portlet.usersadmin.search.UserSearchTerms" %>

<%@ page import="it.cmd.liferay.chat.react.web.row.checker.UserTopicChecker" %>

<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.WindowState" %>
