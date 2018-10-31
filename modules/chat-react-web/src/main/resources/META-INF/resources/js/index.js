import React from 'react';
import ReactDOM from 'react-dom';

import ChatContainer from './chat-components/chat-container';
import ChatBarContainer from './bar-components/chat-bar-container';

export default function(opener, namespace, ctxt) {

	ctxt.namespace = namespace;

	switch (opener) {

		case 'chat' :
			ReactDOM.render(
				<ChatContainer ctxt={ctxt} />,
				document.getElementById(namespace + '-chat'));
			break;

		case 'view' :
			ReactDOM.render(
				<ChatBarContainer ctxt={ctxt} />,
				document.getElementById(namespace + '-bar'));
			break;
	}
}