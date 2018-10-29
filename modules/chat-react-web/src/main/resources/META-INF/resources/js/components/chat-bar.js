import React from 'react';

export default class ChatBar extends React.Component {

	render() {
		let A = this.props.AUI;
		return(
			<button
				onClick={this.props.handleClick}
				className="cmd-chat-bar btn btn-default btn-sm">
				{Liferay.Language.get('chat')}
				<span>{A.Lang.sub(Liferay.Language.get('online-users-x'), ['otherIds.size()'])}</span>
			</button>
		);
	}

}