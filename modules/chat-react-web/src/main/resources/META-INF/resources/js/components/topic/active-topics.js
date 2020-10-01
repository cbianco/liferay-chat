import React from 'react';

import ActiveTopic from './active-topic';

export default class ActiveTopics extends React.Component {

	render() {
		return(
			<div className="cmd-topics-container">
				<ul className="cmd-topics-list">
					{this.props.activeTopics.map(topic =>
						<ActiveTopic ctxt={this.props.ctxt} key={topic.topicId} topic={topic} />
					)}
				</ul>
			</div>
		);
	}

}