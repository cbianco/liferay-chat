import React from 'react';

export default class Topic extends React.Component {

	render() {
		let otherUsers = _.filter(this.props.topic.users, user => user.userId != this.props.ctxt.userId);
		// TODO Mange multiple users
		let otherUser = otherUsers[0];
		let otherUserIsOnline = otherUser.userId in this.props.onlineUsers;

		return(
			<a onClick={() => this.props.openTopic(this.props.topic)} className="cmd-chat-list-contact">
				<span className={otherUserIsOnline ? "user-icon online" : "user-icon"}>
					<img src={otherUser.portraitUrl} />
				</span>
				
				<span className="user-name">{otherUser.fullName}</span>
			</a>
		);
	}

}