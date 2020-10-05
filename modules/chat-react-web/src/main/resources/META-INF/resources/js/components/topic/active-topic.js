import React from 'react';

import Conversation from '../chat/conversation';
import OpenableTab from '../openable-tab';
import { sendWsMessage } from '../websocket';

export default class ActiveTopic extends React.Component {

	constructor(props) {
		super(props);

		this.handleOpen = this.handleOpen.bind(this);
	}

	handleOpen() {
		let topic = this.props.topic;

        if (topic.unreads > 0) {
			sendWsMessage('{msgType: "READ_TOPIC", userId: ' + this.props.ctxt.userId + ', topicId: ' + topic.topicId + '}');
		}
	}

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
					body={<Conversation ctxt={this.props.ctxt} topic={topic} />}
					onOpen={this.handleOpen}
				/>
			</div>
		);
	}

}