import react from "react";
import { Link } from "react-router-dom";
import AuthenticateService from "./AuthenticateService";
import './header.css'

function Header()
{
    const myStyle={
  backgroundImage: 
 "url('https://img.freepik.com/free-photo/luxury-plain-green-gradient-abstract-studio-background-empty-room-with-space-your-text-picture_1258-63953.jpg')",
        height:'10vh',
        marginTop:'0px',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };
    
    return(
        <div>
            <head>
                <title>iacsd hub</title>
            </head>
            <nav className="navbar navbar-expand-lg shadow-5-strong " style={myStyle}>
                <div className="container  ">
                
                <a class="navbar-brand" href="/" onClick={AuthenticateService.logout}>
                <img src="https://serving.photos.photobox.com/19321776803c3fa67bd20b3bcfb6aac3a6efa75bc61a1dd738903ef78e000a60b23f6506.jpg"  alt="Loading..." width="60" height="50" class="rounded float-start d-inline-block align-text-top me-3"/>
            
                 </a>
 
                    <button className="navbar-toggler rounded-sm" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse " id="navbarNav" >
                        <ul className="navbar-nav  mb-2 mb-lg-0 ms-auto data-toggle-pill">
                        <li className="nav-item ">
                                <a className="nav-link active" aria-current="page" href="/terms-condition"><b>Terms & Condition</b></a>
                            </li>
                            <li className="nav-item ">
                                <a className="nav-link active" aria-current="page" href="/"><b>Home</b></a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="https://en.wikipedia.org/wiki/Farm"><b>Info</b></a>
                            </li>
                            <li className="nav-item">
                                <a
                                    className="nav-link"
                                     href="https://enam.gov.in/web/weather_forecast"
                                >
                                <strong>Weather Forecast</strong>
                                </a>
                                </li> 
                            { ! AuthenticateService.isUserLoggedIn() && <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <b>Sign-Up</b>
                                </a>
                                <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><Link className="dropdown-item" to="/farmer-reg"><b>Farmer</b></Link></li>
                                    <li><Link className="dropdown-item" to="/buyer-reg"><b>Buyer</b></Link></li>
                                </ul>
                            </li>}
                            { ! AuthenticateService.isUserLoggedIn() && 
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <b>Login</b>
                                </a>
                                <ul className="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <li><Link className="dropdown-item" to="/farmer-login"><b>Farmer Login</b></Link></li>
                                    <li><Link className="dropdown-item" to="/buyer-login"><b>Buyer Login</b></Link></li>
                                    <li><Link className="dropdown-item" to="/admin-login"><b>Admin Login</b></Link></li>
                                </ul>
                            </li>}

                            {  AuthenticateService.isUserLoggedIn() && 
                            <li className="nav-item">
                            <a className="nav-link" href="/" onClick={AuthenticateService.logout}><b>Logout</b></a>
                            
                            </li>
                            }

                            {           
                                (sessionStorage.getItem('userType') === 'buyer') && <li className="nav-item">
                                <a className="nav-link ms-3" href="/buyer-myCart" ><img src="https://cdn-icons-png.flaticon.com/512/3144/3144456.png" style={{width : "30px" ,height: "30px"}}></img><span>My Cart</span></a>
                                </li> 
                                     
                            }   

           
                               { AuthenticateService.isUserLoggedIn() &&
                                <li className="nav-item">
                                <a className="nav-link ms-3" href={"/"+sessionStorage.getItem('userType')+"/profile"} ><span>My Profile</span></a>
                                </li> 
                                }
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Header;