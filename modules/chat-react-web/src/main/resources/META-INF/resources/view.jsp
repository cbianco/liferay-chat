<%@ include file="/init.jsp" %>

<div id="<portlet:namespace />-root"></div>

<aui:script require="chat-react-web@1.0.0">
	AUI().use(
		'aui-base',
		function(A) {
			chatReactWeb100.default(A, '<portlet:namespace />-root');
		}
	);
</aui:script>