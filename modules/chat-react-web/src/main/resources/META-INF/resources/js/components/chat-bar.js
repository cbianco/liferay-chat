import React from 'react';

export default class ChatBar extends React.Component {

	render() {
		return(
			<a class="cm-chat-bar btn btn-default btn-sm">
				<liferay-ui:message key="chat" />
				<span><liferay-ui:message key="online-users-x" arguments="<%= otherIds.size() %>" translateArguments="<%= false %>" /></span>
			</a>
		);
	}

}