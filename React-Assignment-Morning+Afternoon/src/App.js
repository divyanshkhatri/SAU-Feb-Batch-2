import './App.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import HomeComponent from './components/HomeComponent';
import DetailsComponent from './components/DetailsComponent';
import FormComponent from './components/FormComponent';

function App() {
    return (
        <Router>
            <Switch>
                <Route path = "/form" component = {FormComponent} />
                <Route path = "/" exact component = { HomeComponent }/>
                <Route path = "/details" exact component = {DetailsComponent} />
            </Switch>
        </Router>
    );
}

export default App;
