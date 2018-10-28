import React from 'react';
import ReactDOM from 'react-dom';

import App from './app';

export default function(namespace) {
	ReactDOM.render(
		<App namespace="{namespace}" />,
		document.getElementById(namespace));
}