import React from 'react';

export default class Message extends React.Component {

	render() {
		let Liferay = this.props.ctxt.Liferay;
		let locale = Liferay.ThemeDisplay.getLanguageId().split('_')[0];
		let date = new Date(this.props.message.createDate);

		return(
			<div className={(this.props.message.userId == this.props.ctxt.userId) ? "cmd-conversation-message mine" : "cmd-conversation-message"}>
				<p className="cmd-message-username">{this.props.message.userName}</p>
				<p className="cmd-message-content">{this.props.message.content}</p>
				<p className="cmd-message-date">{date.toLocaleString(locale)}</p>
			</div>
		);
	}

}