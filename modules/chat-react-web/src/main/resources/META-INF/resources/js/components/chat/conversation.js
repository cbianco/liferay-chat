import React from 'react';

import Message from './message';
import WriteBar from './write-bar';
import { sendWsMessage, setWsHandler } from '../websocket';

export default class Conversation extends React.Component {

	componentDidMount() {
		this.scrollToBottom('auto');
    }

	componentDidUpdate() {
		if (this.props.isOpen) {
			this.scrollToBottom('smooth');
		}
    }

    scrollToBottom(behavior) {
		let bottomPos = this.messageList.scrollHeight;

		this.messageList.scroll({
			top: bottomPos,
			behavior: behavior
		});

		this.sendReadTopic();
	}

	sendReadTopic() {
		let topic = this.props.topic;
		let userId = this.props.ctxt.userId;

        if (topic.unreads()) {
			sendWsMessage('{msgType: "READ_TOPIC", userId: ' + userId + ', topicId: ' + topic.topicId + '}');
		}
	}

	render() {

		let messages = _.sortBy(this.props.topic.messages, 'createDate');

		return(
			<div className="cmd-topic-conversation">
				<div
					className="cmd-conversation-message-list"
					ref={(ref) => this.messageList = ref}
				>
					{messages.map(message =>
						<Message ctxt={this.props.ctxt} key={message.messageId} message={message} />
					)}
				</div>
				<WriteBar ctxt={this.props.ctxt} topic={this.props.topic} />
			</div>
		);
	}

}