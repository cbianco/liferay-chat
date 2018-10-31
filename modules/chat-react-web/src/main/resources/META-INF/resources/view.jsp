<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<portlet:renderURL var="openChatURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="mvcRenderCommandName" value="/chat/open" />
	</portlet:renderURL>

	<div id="<portlet:namespace />-bar"></div>

	<aui:script require="chat-react-web@1.0.0">
		AUI().use(
			'aui-base',
			function(A) {
				var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
				chatReactWeb100.default(
					'view',
					'<portlet:namespace />',
					{
						AUI: A,
						userId: <%= userId %>,
						wsUrl: webSocketUrl,
						openChatURL: '<%= openChatURL %>'
					}
				);
			}
		);
	</aui:script>

</c:if>
