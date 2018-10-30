import React from 'react';

import ChatBar from './chat-bar';
import OnlineUsersList from './online-users-list';

export default class ChatBarContainer extends React.Component {
	constructor(props, context) {
        super(props, context);

        this.state = {
            active: false,
        };

        this.handleClick = this.handleClick.bind(this);
    }

	handleClick() {
        this.setState({
            active: !this.state.active
        });
    }

	render() {
		return(
			<div className="cmd-chat-bar-container container-fluid-1280">
				<ChatBar AUI={this.props.AUI} handleClick={this.handleClick} />
				{this.state.active && <OnlineUsersList />}
			</div>
		);
	}

}