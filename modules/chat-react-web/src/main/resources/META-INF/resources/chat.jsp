<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<div id="<portlet:namespace />-chat"></div>

	<aui:script require="chat-react-web@1.0.0">
		AUI().use(
			'aui-base',
			function(A) {
				var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
				chatReactWeb100.default(
					'chat',
					'<portlet:namespace />-chat',
					{
						AUI: A,
						userId: <%= userId %>,
						wsUrl: webSocketUrl
					}
				);
			}
		);
	</aui:script>

</c:if>