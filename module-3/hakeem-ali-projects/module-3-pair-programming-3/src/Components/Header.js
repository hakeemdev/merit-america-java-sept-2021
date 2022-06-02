import react from "react";

import{NavLink, Link} from "react-router-dom";


class Header extends react.Component{
    render(){
        return(
        <header>
            
            <img id="te-pops" src="images\te-pops.png" alt="Tech Elevator Logo"/>
            <h1>
                Tech Eleavtor Popsicles
            </h1>
            <nav>
                <ul>
                    <li><NavLink to = "/" > HOME </NavLink></li>
                    <li><a href="#">STORE</a></li>
                    <li><NavLink to = "/contact" > CONTACT US </NavLink></li>
                </ul>
            </nav>
        </header>
        )
    }
        
    
}
export default Header