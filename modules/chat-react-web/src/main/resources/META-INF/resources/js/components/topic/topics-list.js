import React from 'react';

import Topic from './topic';

export default class TopicsList extends React.Component {

	render() {
		return(
			<div className="cmd-chat-list-container">
				<ul className="cmd-chat-list">
					{_.map(this.props.topics, (topic, topicId) =>
						<Topic
							ctxt={this.props.ctxt}
							key={topicId}
							topic={topic}
                            onlineUsers={this.props.onlineUsers}
							openTopic={this.props.openTopic}
						/>
					)}
				</ul>
			</div>
		);
	}

}