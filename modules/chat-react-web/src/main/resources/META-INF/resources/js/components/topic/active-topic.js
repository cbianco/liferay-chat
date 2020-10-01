import React from 'react';

import Conversation from '../chat/conversation';
import OpenableTab from '../openable-tab';

export default class ActiveTopic extends React.Component {

	render() {
		return(
			<div className="cmd-topic-container">
				<OpenableTab
					topperTitle={this.props.topic.otherUsers[0].fullName}
					body={<Conversation ctxt={this.props.ctxt} topic={this.props.topic} />} />
			</div>
		);
	}

}