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
				var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
				chatReactWeb100.default(
					'<portlet:namespace />-root',
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
