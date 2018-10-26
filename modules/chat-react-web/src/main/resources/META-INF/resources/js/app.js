import React from 'react';

import ChatBarContainer from './components/chat-bar-container';

export default class App extends React.Component {

	constructor(props) {
		super(props);
	}

	render() {

		this.props.namespace;

		return (
			<ChatBarContainer />
		);
	}
}