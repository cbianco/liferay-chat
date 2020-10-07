import React from 'react';

import Conversation from '../chat/conversation';
import OpenableTab from '../openable-tab';

export default class ActiveTopic extends React.Component {

	constructor(props) {
		super(props);

		this.state = {
			isOpen: false
		};

	    this.onOpen = this.onOpen.bind(this);
		this.onClose = this.onClose.bind(this);
	}

	onOpen() {
		this.setState({
			isOpen: true
		});
	}
	onClose() {
		this.setState({
			isOpen: false
		});
	}

	render() {
		let topic = this.props.topic;
		// TODO Mange multiple users
		let otherUsers = _.filter(topic.users, user => user.userId != this.props.ctxt.userId);
        let otherUser = otherUsers[0];
        let unreads = topic.unreads();

        return(
			<div className="cmd-topic-container">
				<OpenableTab
					head={<span className="position-relative">
						{unreads > 0 && <span className="cmd-topic-container-unreads unreads">{unreads}</span>}
						{otherUser.fullName}
					</span>}
					body={<Conversation ctxt={this.props.ctxt} topic={topic} isOpen={this.state.isOpen} />}
					onOpen={this.onOpen}
					onClose={this.onClose}
				/>
			</div>
		);
	}

}