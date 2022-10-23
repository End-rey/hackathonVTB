import React from "react";
import classes from './ArrowBtn.module.css'

export default function ArrowBtn({...props}) {
    
    return (
        <div {...props} className={classes.arrow} >
            <div class={classes.arrow_top}></div>
            <div class={classes.arrow_bottom}></div>
        </div>
    );
}
