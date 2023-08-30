
import Card from "./Card";
import Slider from "./Slider";

function Home() {
    const myStyle = {
        backgroundImage:
            "url('https://images.unsplash.com/photo-1495107334309-fcf20504a5ab?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8ZmFybXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80g')",
        height: '130vh',
        marginTop: '-60px',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };


    return (
        <>
            <div style={myStyle} >

            </div>

            <div className="container-fluid d-flex justify-content-evenly" style={{backgroundColor:"rgb(194,178,128)"}}>

                 <Card />
               

            </div>

            <Slider />

        </>



    )
};

export default Home;