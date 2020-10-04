import React from 'react';

import ActiveTopics from './topic/active-topics';
import OpenableTab from './openable-tab';
import TopicsList from './topic/topics-list';
import { sendWsMessage, setWsHandler } from './websocket';

export default class ChatBarContainer extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
            topics: {},
			activeTopics: [],
			onlineUsers: {}
        };

		this.handleAdd = this.handleAdd.bind(this);
		this.openTopic = this.openTopic.bind(this);
		this.setState = this.setState.bind(this);

        let setState = this.setState;

        setWsHandler('ACTIVE_USER', ({ activeUser }) => {
        	setState(prevState => {
        		let onlineUsers = Object.assign({}, prevState.onlineUsers);
				onlineUsers[activeUser.userId] = activeUser;
				return { onlineUsers };
			});
        });

        setWsHandler('INACTIVE_USER', ({ inactiveUser }) => {
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

        setWsHandler('ADD_TOPIC', ({ addTopic }) => {
			setState(prevState => {
				let topics = Object.assign({}, prevState.topics);
				topics[addTopic.topicId] = addTopic;
				return { topics };
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

	handleAdd(event) {
		event.stopPropagation();

		let A = this.props.ctxt.AUI;

		A.use(
			'liferay-portlet-url',
			'liferay-item-selector-dialog', A => {

			let Liferay = this.props.ctxt.Liferay;
			let namespace = this.props.ctxt.namespace;

			let selectUserUrl = Liferay.PortletURL.createRenderURL();
			selectUserUrl.setPortletId(Liferay.PortletKeys.CHAT_REACT_PORTLET);
			selectUserUrl.setWindowState('POP_UP');
			selectUserUrl.setParameter('mvcPath', '/user/select_user.jsp');

    		let itemSelectorDialog = new A.LiferayItemSelectorDialog({
				eventName: namespace + 'selectUsers',
				on: {
					selectedItemChange: e => {
						let selectedItem = e.newVal;

						if (selectedItem) {
							console.log(selectedItem);

							if (selectedItem.length == 1) {
								let userId1 = this.props.ctxt.userId;
                                let userId2 = selectedItem[0].value;

								sendWsMessage('{msgType: "ADD_TOPIC", userId1: ' + userId1 + ', userId2: ' + userId2 + '}');
							}
						}
					}
				},
				'strings.add': Liferay.Language.get('done'),
				title: Liferay.Language.get('select-user'),
				url: selectUserUrl.toString()
			});

			itemSelectorDialog.open();
		});
	}

	render() {

		let A = this.props.ctxt.AUI;
		let Liferay = this.props.ctxt.Liferay;
        let onlineUsersSize = _.size(this.state.onlineUsers);
		let onlineUsersCount = (onlineUsersSize > 0) ? onlineUsersSize - 1 : onlineUsersSize;
		let unreads = _.reduce(this.state.topics, (memo, { unreads }) => { return memo + unreads }, 0);

        return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<ActiveTopics ctxt={this.props.ctxt} activeTopics={this.state.activeTopics} />
				<OpenableTab
					head={
						<div className="cmd-chat-bar-main-topper">
							{unreads > 0 && (<span className="cmd-chat-unread-message">
								<span dangerouslySetInnerHTML={{__html: Liferay.Util.getLexiconIconTpl('envelope-closed')}}></span> {unreads}
							</span>)}
							<span>{A.Lang.sub(
								Liferay.Language.get('online-users-x'),
								[onlineUsersCount]
							)}</span>
							<button className="add-user" onClick={this.handleAdd}>+</button>
						</div>
					}
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