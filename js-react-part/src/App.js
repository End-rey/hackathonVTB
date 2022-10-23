import React from "react";
import { BrowserRouter } from "react-router-dom";
import Navbar from "./Components/UI/NavBar/Navbar";
import MainPage from "./pages/MainPage";
import Routes from "./router/Routes";
import "./styles/App.css";

function App() {
    return (
        <div>
            <div
                className="image"
                style={{
                    backgroundImage:
                        "url(https://static.tildacdn.com/tild6532-6337-4264-b463-353866353135/Group_5.svg)",
                }}
            ></div>
            <div className="page">
                <BrowserRouter>
                    <Routes />
                </BrowserRouter>
            </div>
        </div>
    );
}

export default App;
