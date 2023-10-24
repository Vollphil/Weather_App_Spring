import React, { useState } from 'react';
import SearchCity from '../Components/SearchCity';

const SearchWeatherAfterLocation = () => {
    const [autoComplete,setAutoComplete] = useState("");
    const [weatherData,setWeatherData] = useState([]);


    


    return(
        <div>
            <h1>Enter a City to get the Weather Details</h1>
            <input type="text"
                   onChange={e => {
                    const newValue = e.target.value;
                    setAutoComplete(newValue);
                    SearchCity(newValue, setWeatherData);
                }}></input>
                    <div>
    {weatherData.map((data, index) => (
        <div key={index}>
            <div>Name: {data.name},{data.country}</div>
            
        </div>
    ))}
</div>


        </div>
    )
}

export default SearchWeatherAfterLocation;