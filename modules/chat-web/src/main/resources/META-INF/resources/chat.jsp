<%@ include file="/init.jsp" %>

<c:if test="<%= themeDisplay.isSignedIn() %>">

	<aui:row>

		<aui:col span="3">
			CONTACT LIST
		</aui:col>

		<aui:col span="9">

        	<%
			long otherId = ParamUtil.getLong(request, "otherId");
			%>

			<c:choose>
				<c:when test="<%= otherId != 0 %>">

					<%
					User otherUser = UserServiceUtil.getUserById(otherId);
					TopicServiceUtil.
					%>

					<div class="container-fluid">

						<div class="msg-list">
							<%= user.getFullName() %> chatter&agrave; con <%= otherUser.getFullName() %>
						</div>

						<div class="input-group">
							<input type="text" class="form-control" placeholder="<%= LanguageUtil.get(request, "digit-a-msg") %>...">
							<span class="input-group-btn">
								<button class="btn btn-default btn-send" type="button"><liferay-ui:message key="send" /></button>
							</span>
						</div>
					</div>

				</c:when>
			</c:choose>

		</aui:col>

	</aui:row>

	<aui:script>

		var webSocketUrl = '<%= themeDisplay.getPortalURL().replaceAll("http[s]?", "ws") %>'
		var ws = new WebSocket(webSocketUrl + '/o/chat');

		$('.btn-send').click(function() {
			ws.send({
				userId: <%= userId %>,
				topicId:
			});
		});

	</aui:script>

</c:if>