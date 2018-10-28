import React from 'react';

export default class OnlineUsers extends React.Component {

	render() {
		return(
			<a href="<%= href %>" className="cm-chat-list-contact">
				this.state.user.portrait
				<span className="user-name">this.state.user.fullName</span>
			</a>
		);
	}

}