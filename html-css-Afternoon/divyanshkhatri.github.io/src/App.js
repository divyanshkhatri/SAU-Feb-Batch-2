import React, { Component } from 'react';
import Light from './mode/Light.js';
import Dark from './mode/Dark.js';

class App extends Component  {

	render() {

		return (

			<div className = "mainDiv">
				{localStorage.getItem("theme") == "true" ? <Dark /> : <Light />}
			</div>
			
		);
	}
}

export default App;
