<%@ include file="/init.jsp" %>

<%

long userId = themeDisplay.getUserId();

Collection<Long> others = UserSessionRegistryUtil.getOnlineUsers(userId);

%>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<liferay-util:html-top>
    	<link data-senna-track="temporary" href="<%= PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + PortalUtil.getPathContext(request) + "/css/main.css") %>" rel="stylesheet" type="text/css" />
    </liferay-util:html-top>

	<div class="cm-chat-bar-container container-fluid-1280 text-right">

		<a class="cm-chat-bar btn btn-default btn-sm"><liferay-ui:message key="chat" /></a>

		<div class="cm-chat-list-container" style="display: none;">
			<ul class="cm-chat-list">

				<c:forEach var="other" items="<%= others %>">

					<a href="#" class="cm-chat-list-contact btn btn-default">
						<h4 class="list-group-item-heading">Contatto <c:out value = "${other}"/></h4>
						<p class="list-group-item-text">Ultimo messaggio con contatto <c:out value = "${other}"/></p>
					</a>

				</c:forEach>

			</ul>
		</div>

	</div>

	<aui:script>

		$('.cm-chat-bar').click(function() {
			$('.cm-chat-list-container').toggle();
		});

		var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
		var ws = new WebSocket(webSocketUrl + '/o/chat');
		ws.onopen = function() {
			this.send('{userId: "<%= userId %>", online: true}');
		};

	</aui:script>

</c:if>