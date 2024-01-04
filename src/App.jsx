import logo from "./logo.svg";
import "./App.css";
//import Home from './components/home/Home'
import HeaderPage from "./components/header/HeaderPage";
import FlightSearch from "./components/home/FlightSearch";
import FlightSearchRoundtrip from "./components/home/FlightSearchRoundtrip";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function App() {
  return (
    <Router>
      <HeaderPage />
      <Switch>
        <Route exact path="/">
          <FlightSearch />
        </Route>
        <Route exact path="/round-trip">
          <FlightSearchRoundtrip />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
