import React from 'react';

export default class OnlineUsers extends React.Component {

	render() {
		return(
			<a href="<%= href %>" class="cm-chat-list-contact">
				this.state.user.portrait
				<span class="user-name"><%= userDisplay.getFullName() %></span>
			</a>
		);
	}

}