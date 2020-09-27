import React from 'react';

export default class Users extends React.Component {

	render() {
		return(
			<a onClick={() => this.props.openTopic(this.props.user)} className="cmd-chat-list-contact">
				<span className="user-icon">
					<img src={this.props.user.portraitUrl} />
				</span>
				
				<span className="user-name">{this.props.user.fullName}</span>
			</a>
		);
	}

}