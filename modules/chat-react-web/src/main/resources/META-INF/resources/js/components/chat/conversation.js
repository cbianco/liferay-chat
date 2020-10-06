import React from 'react';

import Message from './message';
import WriteBar from './write-bar';
import { setWsHandler } from '../websocket';

export default class Conversation extends React.Component {

	componentDidMount() {
		this.scrollToBottom('auto');
    }

	componentDidUpdate() {
		this.scrollToBottom('smooth');
    }

    scrollToBottom(behavior) {
		let bottomPos = this.messageList.scrollHeight;
		this.messageList.scroll({
			top: bottomPos,
			behavior: behavior
		});
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