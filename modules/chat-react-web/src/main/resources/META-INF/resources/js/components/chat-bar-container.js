import React from 'react';

import ActiveTopics from './topic/active-topics';
import OpenableTab from './openable-tab';
import TopicsList from './topic/topics-list';
import { setWsHandler } from './websocket';

export default class ChatBarContainer extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
            topics: {},
			activeTopics: [],
			onlineUsers: {}
        };

		this.openTopic = this.openTopic.bind(this);
		this.setState = this.setState.bind(this);

        let setState = this.setState;

        setWsHandler('ACTIVE_USER', ({activeUser}) => {
        	setState(prevState => {
        		let onlineUsers = Object.assign({}, prevState.onlineUsers);
				onlineUsers[activeUser.userId] = activeUser;
				return { onlineUsers };
			});
        });

        setWsHandler('INACTIVE_USER', ({inactiveUser}) => {
        	setState(prevState => ({
				onlineUsers: _.pick(prevState.onlineUsers, (user, userId) =>
					userId !== inactiveUser.userId
				)
			}));
        });

        setWsHandler('TOPICS', message => {
        	setState({
				topics: message.topics,
				onlineUsers: message.onlineUsers
			});
        });
    }

    openTopic(topic) {

		let setState = this.setState;
		let Liferay = this.props.ctxt.Liferay;

		Liferay.Service('/conversation.message/get-topic-messages', {
			topicId: topic.topicId,
		},
		function(messages) {

			topic.messages = messages;

			setState(prevState => ({
				activeTopics: prevState.activeTopics.concat([topic])
			}));
		});
	}

	render() {

		let A = this.props.ctxt.AUI;
		let onlineUsersSize = _.size(this.state.onlineUsers);
		let onlineUsersCount = (onlineUsersSize > 0) ? onlineUsersSize - 1 : onlineUsersSize;

        return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<ActiveTopics ctxt={this.props.ctxt} activeTopics={this.state.activeTopics} />
				<OpenableTab
					topperTitle={A.Lang.sub(
						Liferay.Language.get('online-users-x'),
						[onlineUsersCount]
					)}
					body={
						<TopicsList
							ctxt={this.props.ctxt}
							topics={this.state.topics}
							onlineUsers={this.state.onlineUsers}
							openTopic={this.openTopic}
						/>
					}
				/>
			</div>
		);
	}

}