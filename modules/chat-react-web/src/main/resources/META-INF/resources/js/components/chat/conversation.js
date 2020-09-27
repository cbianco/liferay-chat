import React from 'react';

import Message from './message';
import WriteBar from './write-bar';
import { setWsHandler } from '../websocket';

export default class Conversation extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
            messages: _.sortBy(props.topic.messages, 'createDate')
        };

        let setState = this.setState.bind(this);

		setWsHandler('NEW_MESSAGE', message => {
			setState(prevState => ({
				messages: prevState.messages.concat([message])
			}));
		});
	}

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
		return(
			<div className="cmd-topic-conversation">
				<div
					className="cmd-conversation-message-list"
					ref={(ref) => this.messageList = ref}
				>
					{this.state.messages.map(message =>
						<Message ctxt={this.props.ctxt} key={message.messageId} message={message} />
					)}
				</div>
				<WriteBar ctxt={this.props.ctxt} topic={this.props.topic} />
			</div>
		);
	}

}