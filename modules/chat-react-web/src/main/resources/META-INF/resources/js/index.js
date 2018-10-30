import React from 'react';
import ReactDOM from 'react-dom';

import ChatBarContainer from './components/chat-bar-container';

export default function(namespace, ctxt) {

	ReactDOM.render(
		<ChatBarContainer ctxt={ctxt} />,
		document.getElementById(namespace));
}