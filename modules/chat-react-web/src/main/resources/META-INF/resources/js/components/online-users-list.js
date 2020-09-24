import React from 'react';

import OnlineUser from './online-user';

export default class OnlineUsersList extends React.Component {

	render() {
		return(
			<div className="cmd-chat-list-container">
				<ul className="cmd-chat-list">
					{this.props.users.map(user =>
						<OnlineUser key={user.userId} user={user} openTopic={this.props.openTopic} />
					)}
				</ul>
			</div>
		);
	}

}