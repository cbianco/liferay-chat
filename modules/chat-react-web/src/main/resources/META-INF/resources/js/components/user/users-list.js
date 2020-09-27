import React from 'react';

import User from './user';

export default class UsersList extends React.Component {

	render() {
		return(
			<div className="cmd-chat-list-container">
				<ul className="cmd-chat-list">
					{this.props.users.map(user =>
						<User key={user.userId} user={user} openTopic={this.props.openTopic} />
					)}
				</ul>
			</div>
		);
	}

}