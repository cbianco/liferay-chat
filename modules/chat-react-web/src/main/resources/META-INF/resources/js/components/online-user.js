import React from 'react';

export default class OnlineUsers extends React.Component {

	render() {
		return(
			<a href="<%= href %>" className="cmd-chat-list-contact">
				<span className="user-icon">
					<img src={this.props.user.portraitUrl} />
				</span>
				
				<span className="user-name">{this.props.user.fullName}</span>
			</a>
		);
	}

}