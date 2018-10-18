<%@ include file="/init.jsp" %>

<%

long userId = themeDisplay.getUserId();

Collection<Long> otherIds = UserSessionRegistryUtil.getOnlineUsers(userId);

%>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<liferay-util:html-top>
    	<link data-senna-track="temporary" href="<%= PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + PortalUtil.getPathContext(request) + "/css/main.css") %>" rel="stylesheet" type="text/css" />
    </liferay-util:html-top>

	<div class="cm-chat-bar-container container-fluid-1280">

		<a class="cm-chat-bar btn btn-default btn-sm">
			<liferay-ui:message key="chat" />
			<span><liferay-ui:message key="online-users-x" arguments="<%= otherIds.size() %>" translateArguments="<%= false %>" /></span>
		</a>

		<div class="cm-chat-list-container" style="display: none;">
            <ul class="cm-chat-list">

                <% for (long otherId : otherIds) {

                    User userDisplay = UserLocalServiceUtil.fetchUserById(otherId);
                %>
                    <a href="#" class="cm-chat-list-contact">
                        <liferay-ui:user-portrait
                            user="<%= userDisplay %>"
                        />
                        <span class="user-name"><%= userDisplay.getFullName() %></span>
                    </a>

                <% } %>
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