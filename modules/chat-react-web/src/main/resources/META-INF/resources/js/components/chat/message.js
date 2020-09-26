import React from 'react';

export default class Message extends React.Component {

	render() {
		return(
			<div className={(this.props.message.userId == this.props.ctxt.userId) ? "cmd-conversation-message mine" : "cmd-conversation-message"}>
				<p className="cmd-message-username">{this.props.message.userName}</p>
				<p className="cmd-message-content">{this.props.message.content}</p>
				<p className="cmd-message-date">{this.props.message.date}</p>
			</div>
		);
	}

}