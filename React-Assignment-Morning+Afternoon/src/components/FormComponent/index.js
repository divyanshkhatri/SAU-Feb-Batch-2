import React, { Component } from 'react';
import SearchBarComponent from '../SearchBarComponent';
import "./index.css";

export default class FormComponent extends Component {


    state = { 
        bookName: "",
        bookAuthor: "",
        bookImageUrl: "",
        bookBuyLink: "",
    };

    changeBookName = (event) => {
    this.setState({ bookName: event.target.value });
    };

    changeBookAuthor = (event) => {
        this.setState({ bookAuthor: event.target.value });
    };

    changeBookImageUrl = (event) => {
        this.setState({ bookImageUrl: event.target.value });
    };

    changeBookBuyLink = (event) => {
        this.setState({ bookBuyLink: event.target.value });
    };

    onAddBook = () => {

        let {bookName, bookAuthor, bookImageUrl, bookBuyLink} = this.state;

        if(bookName === "" || bookAuthor === "" || bookBuyLink === "" || bookImageUrl === ""){
            console.log("Please fill all the details!");
        }else {
            let bookObject = {
                bookName, 
                bookAuthor, 
                bookImageUrl,
                bookBuyLink
            };


            let bookArray = [];

            let bookDetails = JSON.parse(localStorage.getItem('bookDetails'));
            if(bookDetails == null) {

                console.log("empty");
                bookArray.push(bookObject);
                console.log(bookObject);
                localStorage.setItem("bookDetails", JSON.stringify(bookArray));
                console.log("Book added");
            } else {
                console.log("Not empty");
                bookArray = bookDetails;
                bookArray.push(bookObject);
                localStorage.setItem("bookDetails", JSON.stringify(bookArray));
                console.log("Book added");

            }

            
            console.log(bookDetails);
        }
    }

    render() {
        return (
            <div>
            <SearchBarComponent />
            <div>
            <h1 style = {{fontFamily: "Poppins-Black", color: "white"}}>Welcome to the Bookstore!</h1>
                <h1 style = {{fontFamily: "Poppins-Bold", color: 'rgb(58,180,250)', fontSize: 35}}>Enter the Book Details</h1>
                <div class = "form-div">
                    <input 
                        type="text" 
                        name="book-name" 
                        value = {this.state.bookName}
                        onChange = {this.changeBookName} 
                        className="formStyle" 
                        placeholder="Book Name (required)" 
                        required 
                    />
                    <input 
                        type="text" 
                        name="book-author" 
                        value = {this.state.bookAuthor}
                        onChange = {this.changeBookAuthor} 
                        className="formStyle" 
                        placeholder="Book Author (required)" 
                        required 
                    />
                    <input 
                        type="text" 
                        name="book-image-url" 
                        className="formStyle" 
                        value = {this.state.bookImageUrl}
                        onChange = {this.changeBookImageUrl} 
                        placeholder="Book Image URL (required)" 
                        required 
                    />
                    <input 
                        type="text" 
                        name="book-buy-link" 
                        className="formStyle" 
                        value = {this.state.bookBuyLink}
                        onChange = {this.changeBookBuyLink} 
                        placeholder="Book Buy Link (required)" 
                        required 
                    />
                    <button className="formButton" onClick = {() => this.onAddBook()}>Add Book</button>
                </div>
            </div>
            </div>
        )
    }
}