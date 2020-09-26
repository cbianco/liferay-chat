import React from 'react';
import ReactDOM from 'react-dom';

import ChatBarContainer from './components/chat-bar-container';
import { initWs } from './components/websocket';

export default function(namespace, ctxt) {

	initWs(ctxt);

	ReactDOM.render(
		<ChatBarContainer ctxt={ctxt} />,
		document.getElementById(namespace));
}