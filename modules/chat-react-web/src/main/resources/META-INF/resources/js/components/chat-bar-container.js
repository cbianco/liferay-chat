import React from 'react';

import OnlineUsersList from './user/online-users-list';
import OpenableTab from './openable-tab';
import Topics from './topic/topics';
import { setWsHandler } from './websocket';

export default class ChatBarContainer extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
            users: [],
			topics: []
        };

		this.openTopic = this.openTopic.bind(this);
		this.setState = this.setState.bind(this);

        let setState = this.setState;

        setWsHandler('NEW_USER', message => {
        	setState(prevState => ({
				users: prevState.users.concat([message.newUser])
			}));
        });

        setWsHandler('REMOVE_USER', message => {
        	setState(prevState => ({
				users: prevState.users.filter(user =>
					user.userId !== message.removeUser.userId
				)
			}));
        });

        setWsHandler('OTHERS', message => {
        	setState({
				users: message.others
			});
        });
    }

    openTopic(user) {

		let setState = this.setState;
		let Liferay = this.props.ctxt.Liferay;

		Liferay.Service('/conversation.topic/get-topic-by-user-ids', {
			companyId: Liferay.ThemeDisplay.getCompanyId(),
			userId1: this.props.ctxt.userId,
			userId2: user.userId
		},
		function(topic) {

			Liferay.Service('/conversation.message/get-topic-messages', {
				topicId: topic.topicId,
			},
			function(messages) {

				topic.messages = messages;
				topic.dest = user;

				setState(prevState => ({
					topics: prevState.topics.concat([topic])
				}));
			});
		});
	}

	render() {

		let A = this.props.ctxt.AUI;

        return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<Topics ctxt={this.props.ctxt} topics={this.state.topics} />
				<OpenableTab
					topperTitle={A.Lang.sub(Liferay.Language.get('online-users-x'), [this.state.users.length])}
					body={<OnlineUsersList ctxt={this.props.ctxt} users={this.state.users} openTopic={this.openTopic} />}
				/>
			</div>
		);
	}

}