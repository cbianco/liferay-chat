import React from 'react';

export default class OnlineUsers extends React.Component {

	render() {
		return(
			<a href="<%= href %>" class="cmd-chat-list-contact">
				this.state.user.portrait
				<span class="user-name">this.state.user.fullName</span>
			</a>
		);
	}

}