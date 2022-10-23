import React from "react";
import classes from "./Navbar.module.css";

export default function Navbar() {
    return (
        <div className={classes.navigation}>
            <nav className={classes.navMenu}>
                <a href="#">Day</a>
                <a href="#">Week</a>
                <a href="#">Month</a>
                <a href="#">About</a>
                <div className={classes.dot}></div>
            </nav>
        </div>
    );
}
