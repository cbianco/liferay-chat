import React from 'react';

export default class Message extends React.Component {

	render() {
		let Liferay = this.props.ctxt.Liferay;
		let locale = Liferay.ThemeDisplay.getLanguageId().split('_')[0];
		let date = new Date(this.props.message.createDate);

		let className = 'cmd-conversation-message';

		if (this.props.message.userId == this.props.ctxt.userId) {
			className += ' mine';
		}
		if (!this.props.message.read) {
			className += ' unread';
		}

		return(
			<div className={className}>
				<p className="cmd-message-username">{this.props.message.userName}</p>
				<p className="cmd-message-content">{this.props.message.content}</p>
				<p className="cmd-message-date">{date.toLocaleString(locale)}</p>
			</div>
		);
	}

}