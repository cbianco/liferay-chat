import React from 'react';

import { getWs, setWsHandler } from '../websocket';

export default class WriteBar extends React.Component {

	constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this)
	}

	//  function handler inside class declaration
    keyPress(event) {
        if (event.charCode == 13) {
            event.preventDefault();
            this.handleSubmit(new Event('submit'));
        }
    }

	handleSubmit(event) {
		event.preventDefault();

		let userId = this.props.ctxt.userId;
        let topicId = this.props.topic.topicId;
        let input = document.getElementById('message');
        let message = input.value;
        input.value = '';
		//console.log(message);

		if (!_.isEmpty(message)) {
			getWs().send('{userId: "' + userId + '", topicId: "' + topicId + '", content: "' + message + '"}');
		}
	}

	render() {
		let A = this.props.ctxt.AUI;

        return(
			<div className="cmd-topic-write-bar">
				<form
					onSubmit={this.handleSubmit}
					ref={ (ref) => { this.form = ref; } }
				>
					<input
						type="text"
						id="message"
						name="message"
						className="message"
						autoComplete="off"
						onKeyPress={this.keyPress.bind(this)}
						placeholder={Liferay.Language.get('message')}
						ref={ (ref) => { this.message = ref; } }
					/>
					<button type="submit">{Liferay.Language.get('send')}</button>
				</form>
			</div>
		);
	}

}