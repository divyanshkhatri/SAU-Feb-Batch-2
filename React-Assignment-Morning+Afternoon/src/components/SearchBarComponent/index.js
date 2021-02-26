import React, { Component } from "react";
import "./index.css";

class SearchBarComponent extends Component {

    state = { 
        title: ""
    };

    handleChange = event => {
    this.setState({ title: event.target.value });
    };
        
    search = () => {
        
        let booksArray = JSON.parse(localStorage.getItem("bookDetails"));
        console.log(booksArray);
        booksArray.forEach(book => {
            if(book.bookName === this.state.title) {
                this.props.history.push("/details", {details: book});
            }
        });
        
    }

    render() {
        return (
            <div className = "topnav">
                <div className = "title">Book Store &nbsp;&nbsp;&nbsp;| </div>
                <a className = "title" href = "/form">Add Books</a>
                <a className = "title" href = "/">Show Books</a>
                <div className = "search-container">
                <div>
                    <input 
                    type="text" 
                    placeholder="Search.." 
                    name="search" 
                    value={this.state.title}
                    onChange={this.handleChange}
                    ></input>
                    <button type="submit" onClick = {this.search}>Search</button>
                </div>
                </div>
            </div>
        );
    }
}

export default SearchBarComponent;
