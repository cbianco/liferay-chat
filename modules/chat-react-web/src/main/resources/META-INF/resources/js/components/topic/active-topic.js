import React from 'react';

import Conversation from '../chat/conversation';
import OpenableTab from '../openable-tab';

export default class ActiveTopic extends React.Component {

	render() {
		// TODO Mange multiple users
		let otherUsers = _.filter(this.props.topic.users, user => user.userId != this.props.ctxt.userId);
        let otherUser = otherUsers[0];

        return(
			<div className="cmd-topic-container">
				<OpenableTab
					head={<span>{otherUser.fullName}</span>}
					body={<Conversation ctxt={this.props.ctxt} topic={this.props.topic} />} />
			</div>
		);
	}

}