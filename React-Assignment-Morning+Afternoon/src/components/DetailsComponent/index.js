import React, {Component} from 'react';
import {withRouter} from 'react-router-dom';
import './index.css';

class DetailsComponent extends Component {

    componentDidMount() {
        console.log(this.props.location.state.details);
       this.setState({details: this.props.location.state.details}, () => {
           console.log(this.state.details);
       });
    }

    openInNewTab = (url) => {
        console.log("Pressed");
        const newWindow = window.open(url, '_blank', 'noopener,noreferrer')
        if (newWindow) newWindow.opener = null
    }

    state = {
        details: null,
    }

    onSubmit = () => {
        console.log("Pressed");
        this.props.location.href = "www.google.com"
    }

    render() {
        const {details} = this.state;
        return (
            <div>
                <h1 style = {{fontSize: 40, fontFamily: "Poppins-Black"}}>Book Detail</h1>
                <div className = "container">
                    <div className = "child">
                        {
                            this.state.details ? 
                                <div>
                                    <div>
                                        <img src = {details.bookImageUrl} alt = "Book URL" />
                                        <p style = {{color: "#4ACDF4"}}>{details.bookName}</p>
                                        <p style = {{fontSize: 25, fontFamily: "Poppins-SemiBold"}}>By {details.bookAuthor}</p>
                                        <input className = "button" type = "submit" onClick = {() => this.openInNewTab(details.bookBuyLink)} value = "Buy Link"></input>
                                    </div>
                                </div>
                            : null
                        }
                    </div>
                </div>
            </div>
        )
    }

}

export default withRouter(DetailsComponent);