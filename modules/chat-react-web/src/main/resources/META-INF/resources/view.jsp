<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<%
	long userId = themeDisplay.getUserId();
	%>

	<div id="<portlet:namespace />-root"></div>

	<aui:script require="chat-react-web@1.0.0">
		AUI().use(
			'aui-base',
			function(A) {
				var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>';
				Liferay.PortletKeys.CHAT_REACT_PORTLET = '<%= ChatReactPortletKeys.CHAT_REACT_PORTLET %>';
				chatReactWeb100.default(
					'<portlet:namespace />-root',
					{
						AUI: A,
						Liferay: Liferay,
						namespace: '<portlet:namespace />',
						userId: <%= userId %>,
						wsUrl: webSocketUrl
					}
				);
			}
		);
	</aui:script>

</c:if>
