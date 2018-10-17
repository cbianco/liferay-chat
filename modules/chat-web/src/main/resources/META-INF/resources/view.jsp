<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<liferay-util:html-top>
    	<link data-senna-track="temporary" href="<%= PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + PortalUtil.getPathContext(request) + "/css/main.css") %>" rel="stylesheet" type="text/css" />
    </liferay-util:html-top>

	<div class="cm-chat-bar-container container-fluid-1280 text-right">

		<a class="cm-chat-bar btn btn-default btn-sm"><liferay-ui:message key="chat" /></a>

		<div class="cm-chat-list-container">
			<ul class="cm-chat-list list-group">

				 <a href="#" class="cm-chat-list-contact btn btn-default">
                 	<h4 class="list-group-item-heading">Contatto 1</h4>
                 	<p class="list-group-item-text">Ultimo messaggio con contatto 1</p>
                 </a>

            	 <a href="#" class="cm-chat-list-contact btn btn-default">
					<h4 class="list-group-item-heading">Contatto 2</h4>
					<p class="list-group-item-text">Ultimo messaggio con contatto 2</p>
				 </a>

			</ul>
		</div>

	</div>

</c:if>