import React from 'react';

export default class Topic extends React.Component {

	render() {
		return(
			<div className="cmd-conversation-message">
				<p className="cmd-message-username">{this.props.message.userName}</p>
				<p className="cmd-message-content">{this.props.message.content}</p>
				<p className="cmd-message-date">{this.props.message.date}</p>
			</div>
		);
	}

}