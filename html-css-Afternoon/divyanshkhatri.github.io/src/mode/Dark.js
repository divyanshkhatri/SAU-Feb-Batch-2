import React, { Component } from 'react';
import './dark.css';
import {Spring} from 'react-spring/renderprops';
import back from '../imgs/abc.png';
import sun from '../imgs/sun.png';
import Light from './Light';

class Dark extends Component  {

	componentDidMount = () => {
		setTimeout(() => { this.setState({intro: false}) }, 1300);
	}


	state = {
		intro : true,
		intro1 : null,
		bgColor: '#1a1a1a',
	}


	switchColors = () => {
		localStorage.setItem("theme", "false");
		this.setState({intro1: <Light />})
	}

	render() {

		
		let intro = this.state.intro1;
		if(this.state.intro) {
				intro = (
					<div className="overflowD">
						<Spring
							from={{ opacity: 0 }}
							to={{ opacity: 1 }}>
							{props => <div style={props}><p className="introD">Please Wait</p></div>}
						</Spring>
						<Spring
							from={{ number: 0 }}
							to={{ number: 1 }}
							duration = {2000}>
							{props => <div className="intro1D">{Math.floor(props.number*100)}%</div>}
						</Spring>
					</div>
				);
		} else {
			intro = (
				<Spring
					from={{ opacity: 0 }}
					to={{ opacity: 1 }}>
					{props =>
						<div style = {props} >
							<div className="bgD">
                            </div>
							<img src = {back} className="backD" alt = "shapes"/>
							<div className="mainContentD">
							<img onClick = {this.switchColors} src= {sun} className = "themeD" alt = "theme" />
								<div className="madeD">Made with <img alt = "love" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAABmJLR0QA/wD/AP+gvaeTAAABFklEQVQ4jcWPvUoDQRRGz927SARbfQUt1T6gAbG0mn7BylbEwgew8B30BcYsgTRWPoAW2giChkhABBEhlUV2dizM/rCJslv5NTNzZ865d+C/I9nGG7OMc2fALhAC14ic/Fz6U6ADJMAVk8mx9PsfucAbs0iS3CGyWmnwPl1XKvVHVDfF2q8AgDTdnwNnYBUGWCNNDwAywUatD5fj/XohCILPxgJ4KwTO2ab9gctcIL3eDd5fNBCcSxzfFhMAhOEhMKgBD1A9yg65QKwdo9oBRn/Ar6juiLXjGcFUMkJ1C3ieA78gsi3WDsvFoPpKrB2i2kbkvlR+ANrS7T7NvP9tVm/MEs7FwAKqe+Wxa8dHUctHUasx2CTfjkJQ1NseBtMAAAAASUVORK5CYII=" /> and React</div>
								<div className="reachOuterD">
								<div className="reachD">
									<p>
										<a className = "aD" href = "mailto: khatri.divyansh98@gmail.com">MAIL</a>
										<span className="tabD"></span>
										<a className = "aD" href = "https://www.facebook.com/divyansh43/">FACEBOOK</a>
										<span className="tabD"></span>
										<a className = "aD" href = "https://www.instagram.com/_divyanshkhatri_/?hl=bn">INSTAGRAM</a>
										<span className="tabD"></span>
										<a className = "aD" href = "https://www.linkedin.com/in/divyansh-khatri">LINKEDIN</a>
									</p>
								</div>
								
								</div>

									<p className="backTextUpD">DEVE</p>
									<p className="backTextDownD">LOP</p>
		
								<div className="pointsOuterD">
									<div className="pointsD">
										<div>Designer</div>
										<div>App Deveoper</div>
										<div>Full-stack Web Developer</div>	
									</div>
								</div>
								<div className = "outParaD">
									<div className= "paragraphD">
										<p className = "innerTextD" >Hello<span className="imageCrD" >.</span><br />I am<br /><span className="nameD">Divyansh </span></p>	
									</div>
								</div>
							</div>

						</div>
					}
				</Spring>
				
			)
		}

		return (
			<div>
				{
					this.state.intro1 != null ? this.state.intro1 : intro
				}
				{/* {
					this.state.honey != null ? this.state.honey : null
				}	 */}
			</div>
			
		);
	}
}

export default Dark;
