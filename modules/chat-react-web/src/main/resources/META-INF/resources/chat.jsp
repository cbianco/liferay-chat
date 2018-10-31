<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<%
	long otherId = ParamUtil.getLong(request, "otherId");
	%>

	<div id="<portlet:namespace />-chat"></div>

	<aui:script require="chat-react-web@1.0.0">
		AUI().use(
			'aui-base',
			function(A) {
				var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
				chatReactWeb100.default(
					'chat',
					'<portlet:namespace />',
					{
						AUI: A,
						userId: <%= userId %>,
						otherId: <%= otherId %>,
						wsUrl: webSocketUrl
					}
				);
			}
		);
	</aui:script>

</c:if>