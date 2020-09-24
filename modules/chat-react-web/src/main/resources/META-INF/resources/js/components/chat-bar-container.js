import React from 'react';

import Topics from './topics';
import ChatBar from './chat-bar';
import OnlineUsersList from './online-users-list';

export default class ChatBarContainer extends React.Component {
	constructor(props) {
        super(props);

        this.state = {
            users: [],
			topics: [],
			showUsers: false,
            ws: new WebSocket(props.ctxt.wsUrl + '/o/chat')
        };

        this.state.ws.onopen = function() {
            this.send('{userId: "' + props.ctxt.userId + '"}');
        };

        this.handleClick = this.handleClick.bind(this);
		this.openTopic = this.openTopic.bind(this);
		this.setState = this.setState.bind(this);

        let setState = this.setState;
        this.state.ws.onmessage = function (event) {
            let message = JSON.parse(event.data);
            console.log(message);
            switch(message.msgType) {

                case "NEW_USER":
                    setState(prevState => ({
                        users: prevState.users.concat([message.newUser])
                    }));
                    break;
                    
                case "REMOVE_USER":
                    setState(prevState => ({
                        users: prevState.users.filter(user =>
                            user.userId !== message.removeUser.userId
                        )
                    }));
                    break;
                    
                case "OTHERS":
                    setState({
                        users: message.others
                    });
                    break;
            }
        };
    }

	handleClick() {
        this.setState({
            showUsers: !this.state.showUsers
        });
    }

    openTopic(user) {
		console.log(user);

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

				setState(prevState => ({
					topics: prevState.topics.concat([topic])
				}));
			});
		});
	}

	render() {
		return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<Topics ctxt={this.props.ctxt} topics={this.state.topics} />
				<div>
					<ChatBar ctxt={this.props.ctxt} handleClick={this.handleClick} usersCount={this.state.users.length} />
					{this.state.showUsers && <OnlineUsersList ctxt={this.props.ctxt} users={this.state.users} openTopic={this.openTopic} />}
				</div>
			</div>
		);
	}

}