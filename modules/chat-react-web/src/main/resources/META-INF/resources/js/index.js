import React from 'react';
import ReactDOM from 'react-dom';

import ChatBarContainer from './components/chat-bar-container';

export default function(AUI, namespace) {
	ReactDOM.render(
		<ChatBarContainer AUI={AUI} />,
		document.getElementById(namespace));
}