import React from 'react';

export default class OnlineUsersList extends React.Component {

	constructor(props) {
		super(props);

		this.state = {
			users: []
		}
	}

	/*getUsers() {
		var users = [];
		for (let user of this.state.users) {
			// note: we add a key prop here to allow react to uniquely identify each
			// element in this array. see: https://reactjs.org/docs/lists-and-keys.html
			users.push(<User userId={user.userId} />);
		}
		return users;
	}*/

	render() {
		return(
			<div className="cmd-chat-list-container">
				<ul className="cmd-chat-list">
					this.state.users
				</ul>
			</div>
		);
	}

}