import React, { useState } from 'react';
import SearchCity from '../Components/SearchCity';
import GetWeatherDetailsFromLoaction from '../Components/GetWeatherDetailsFromLocation';

const SearchWeatherAfterLocation = () => {
    const [autoComplete,setAutoComplete] = useState("");
    const [locationData,setLocationData] = useState([]);
    const [weatherData,setWeatherData] = useState([]);


    


    return(
        <div className="position-relative">
            <h1>Enter a City to get the Weather Details</h1>
            <input type="text"
                   onChange={e => {
                    const newValue = e.target.value;
                    setAutoComplete(newValue);
                    SearchCity(newValue, setLocationData);
                }}></input>
                  {autoComplete.length >= 3 && 
                <ul className='dropdown-menu show' style={{display: 'block'}}> 
                    {locationData.map((data, index) => (
                        <li key={index}>
                            <a className="dropdown-item" href="#" onClick={(e) => {
                                e.preventDefault();
                                GetWeatherDetailsFromLoaction(data.name, setWeatherData);
                                setAutoComplete(data.name);
                                }}>{data.name}, {data.country}</a>
                        </li>
                    ))}
                </ul>
            }
            {weatherData.length > 0 &&
            <div>
                {weatherData.map((data,index) =>(
                    <div key={index}>
                        <p>{data.temp_c}</p>
                        </div>
                ))}
                </div>
            }



        </div>
    )
}

export default SearchWeatherAfterLocation;