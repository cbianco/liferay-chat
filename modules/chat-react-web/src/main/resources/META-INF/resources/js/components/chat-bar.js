import React from 'react';

export default class ChatBar extends React.Component {

	render() {
		let A = this.props.ctxt.AUI;
		return(
			<a onClick={this.props.handleClick} className="cmd-chat-bar btn btn-default btn-sm">
				<span>{A.Lang.sub(Liferay.Language.get('online-users-x'), [this.props.usersCount])}</span>
			</a>
		);
	}

}