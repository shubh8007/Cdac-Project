import React from 'react'

function Slider() {
  return (
    <div className='d-flex justify-content-center' >
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
            <img src="https://images.unsplash.com/photo-1625246333195-78d9c38ad449?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmFybWluZ3xlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80" class="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
            <div class="carousel-item">
            <img src="https://e1.pxfuel.com/desktop-wallpaper/963/64/desktop-wallpaper-graph-of-a-farmer-ploughing-his-land-taken-on-a-walk-in-a-village-near-madhurandhagam-ta%E2%80%A6-indian-agriculture-thumbnail.jpg" class="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
            <div class="carousel-item">
            <img src="https://images.pexels.com/photos/2933243/pexels-photo-2933243.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block " alt="..." style={{height :"100vh" ,width:"98vw"}}/>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
        </div>
    </div>
  )
}

export default Slider