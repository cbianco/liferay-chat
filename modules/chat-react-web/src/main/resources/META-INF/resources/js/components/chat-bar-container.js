import React from 'react';

import ChatBar from './chat-bar';
import OnlineUsersList from './online-users-list';

export default class ChatBarContainer extends React.Component {

	render() {
		return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<ChatBar />
				<OnlineUsersList />
			</div>
		);
	}

}