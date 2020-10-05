import React from 'react';

import Conversation from '../chat/conversation';
import OpenableTab from '../openable-tab';

export default class ActiveTopic extends React.Component {

	render() {
		let topic = this.props.topic;
		// TODO Mange multiple users
		let otherUsers = _.filter(topic.users, user => user.userId != this.props.ctxt.userId);
        let otherUser = otherUsers[0];

        return(
			<div className="cmd-topic-container">
				<OpenableTab
					head={<span className="position-relative">
						{topic.unreads > 0 && <span className="cmd-topic-container-unreads unreads">{topic.unreads}</span>}
						{otherUser.fullName}
					</span>}
					body={<Conversation ctxt={this.props.ctxt} topic={topic} />} />
			</div>
		);
	}

}