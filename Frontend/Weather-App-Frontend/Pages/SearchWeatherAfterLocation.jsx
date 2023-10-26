import React, { useState } from 'react';
import SearchCity from '../Components/SearchCity';
import GetWeatherDetailsFromLoaction from '../Components/GetWeatherDetailsFromLocation';
import FavoriteCitySave from '../Components/FacoriteCitySave';

const SearchWeatherAfterLocation = () => {
    const [autoComplete,setAutoComplete] = useState("");
    const [locationData,setLocationData] = useState([]);
    const [weatherData,setWeatherData] = useState([]);
    const [favoriteCity,setFavoriteCity] = useState([]);

    const handleCitySave = (newCity) => {
        setFavoriteCity(prevCities => [...prevCities,newCity]);
    }
    

    console.log(weatherData)
    return(
        <div className="d-flex flex-column justify-content-center align-items-center" style={{ height: '100vh' }}>
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
                                setAutoComplete("");
                                }}>{data.name}, {data.country}</a>
                        </li>
                    ))}
                </ul>
            }
            {(weatherData.length === undefined) &&
            <div >
              
    <div>
     <p>Temperature C : {weatherData.current.temp_c}</p>
     <p>Temperature F : {weatherData.current.temp_f}</p>
     <p>City : {weatherData.location.name}</p>
     <p>Country : {weatherData.location.country}</p>
     <p>Weather Condition : {weatherData.current.condition.text}</p>
     <button type="button"
             onClick={() => {FavoriteCitySave(weatherData,handleCitySave)}}>Save</button>
    </div>


               
                </div>
            }

            {favoriteCity.length > 0 &&
            <div>
                <h1>Your Saved Cities</h1>
               {favoriteCity.map((index,city) =>(
                <div key={index}>
                    <p><a href='#' onClick={()=> console.log("test")}>{city.cityName}</a></p>
                    </div>
               ))}
                </div>
            }




        </div>
    )
}

export default SearchWeatherAfterLocation;