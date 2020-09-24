import React from 'react';

import Topic from './topic';

export default class Topics extends React.Component {

	render() {
		return(
			<div className="cmd-topics-container">
				<ul className="cmd-topics-list">
					{this.props.topics.map(topic =>
						<Topic key={topic.topicId} />
					)}
				</ul>
			</div>
		);
	}

}