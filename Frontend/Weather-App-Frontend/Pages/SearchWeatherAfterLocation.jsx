import React, { useState } from 'react';
import SearchCity from '../Components/SearchCity';

const SearchWeatherAfterLocation = () => {
    const [autoComplete,setAutoComplete] = useState("");
    const [weatherData,setWeatherData] = useState([]);


    


    return(
        <div className="position-relative">
            <h1>Enter a City to get the Weather Details</h1>
            <input type="text"
                   onChange={e => {
                    const newValue = e.target.value;
                    setAutoComplete(newValue);
                    SearchCity(newValue, setWeatherData);
                }}></input>
                  {autoComplete.length >= 3 && 
                <ul className='dropdown-menu show' style={{display: 'block'}}> 
                    {weatherData.map((data, index) => (
                        <li key={index}>
                            <a className="dropdown-item" href="#">{data.name}, {data.country}</a>
                        </li>
                    ))}
                </ul>
            }



        </div>
    )
}

export default SearchWeatherAfterLocation;