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
            event.preventDefault()
            this.form.dispatchEvent(new Event('submit'));
        }
    }

	handleSubmit(event) {
		event.preventDefault();

		let userId = this.props.ctxt.userId;
        let topicId = this.props.topic.topicId;
        let message = event.target.getElementsByClassName('message')[0].value;
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
						name="message"
						className="message"
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