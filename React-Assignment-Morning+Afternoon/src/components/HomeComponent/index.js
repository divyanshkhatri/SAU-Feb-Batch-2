import React, {Component} from 'react';
import SearchBarComponent from '../SearchBarComponent';
import {withRouter} from 'react-router-dom';
import "./index.css";

class HomeComponent extends Component {

    componentDidMount() {
        console.log(this.props);
        let bookDetails = JSON.parse(localStorage.getItem("bookDetails"));
        this.setState({bookDetails}, () => {
            console.log(this.state.bookDetails);    
        })
    }

    state = {
        bookDetails: [],
    }

    render() {
        return (
            <div>    
                <SearchBarComponent history = {this.props.history} />
                    <div className = "heading">
                        <p>Trending Books!</p> 
                    </div>
                    <div style = {{marginLeft: 80, marginTop: 40}}>
                        <div className="grid grid-cols-1 gap-10 px-5 sm:grid-cols-4"> 
                        {
                            this.state.bookDetails ? 
                                this.state.bookDetails.map((book) => (
                                    <div>
                                        <img  alt = "Book URL" onClick = {() => this.props.history.push("/details", {details: book})} src = {book.bookImageUrl} style = {{ width: 243.2, height: 400 }}/>
                                    </div>
                                ))
                            : null
                        }
                        </div>
                    </div> 
            </div>
        )
    }

}

export default withRouter(HomeComponent);