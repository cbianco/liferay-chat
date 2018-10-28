import React from 'react';

export default class ChatBar extends React.Component {

	render() {
		return(
			<a class="cm-chat-bar btn btn-default btn-sm">
				Liferay.Language.get('chat')
				<span>Lang.sub(Liferay.Language.get('online-users-x'), [otherIds.size()])</span>
			</a>
		);
	}

}