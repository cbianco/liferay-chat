import React from 'react';

export default class OnlineUsers extends React.Component {

	render() {
		return(
			<a href="#" onClick={this.props.handleClick} value={this.props.user.userId} className="cmd-chat-list-item">
				<span className="user-icon">
					<img src={this.props.user.portraitUrl} />
				</span>
				
				<span className="user-name">{this.props.user.fullName}</span>
			</a>
		);
	}

}