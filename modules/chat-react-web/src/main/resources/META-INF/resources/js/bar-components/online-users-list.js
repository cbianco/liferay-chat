import React from 'react';

import OnlineUser from './online-user';

export default class OnlineUsersList extends React.Component {

	constructor(props) {
        super(props);

    	this.openChatPopup = this.openChatPopup.bind(this);
    }

    openChatPopup(event) {
    	event.preventDefault();

		var otherId = event._dispatchInstances._currentElement.props.value;
		var uri = this.props.ctxt.openChatURL;

		console.log(otherId);

		if (otherId) {
			uri = Liferay.Util.addParams(
				this.props.ctxt.namespace + 'otherId=' + otherId, uri);
		}

		console.log(uri);

		Liferay.Util.openWindow({
			dialog: {
				modal: true,
				resizable: true,
				constrain: true,
				destroyOnHide: true
			},
			title: Liferay.Language.get('chat'),
			uri: uri
		});
	}

	render() {
		return(
			<div className="cmd-chat-list-container">
				<ul className="cmd-chat-list">
					{this.props.users.map(user =>
						<OnlineUser key={user.userId} user={user} handleClick={this.openChatPopup} />
					)}
					<a href="#" onClick={this.openChatPopup} value="0" className="cmd-chat-list-item cmd-chat-view-all">
						<span className="user-name">{Liferay.Language.get('view-all-topics')}</span>
					</a>
				</ul>
			</div>
		);
	}

}