import React from 'react';

export default class OpenableTab extends React.Component {

	constructor(props) {
        super(props);

        this.state = {
			isOpen: false
        };

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {

    	let willOpen = !this.state.isOpen;

    	if (willOpen && this.props.onOpen) {
			this.props.onOpen();
		}
		if (!willOpen && this.props.onClose) {
			this.props.onClose();
		}

		this.setState({
			isOpen: willOpen
		});
	}

	render() {
		return(
			<div className="cmd-chat-openable-tab">
				<a onClick={this.handleClick} className="cmd-chat-openable-tab-head btn btn-default btn-sm">{this.props.head}</a>
            	<div className="cmd-chat-openable-tab-body">{this.state.isOpen && this.props.body}</div>
            </div>
		);
	}

}