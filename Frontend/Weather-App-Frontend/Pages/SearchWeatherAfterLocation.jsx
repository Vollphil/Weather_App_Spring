import React, { useState } from 'react';


const SearchWeatherAfterLocation = () => {
    const [autoComplete,setAutoComplete] = useState("");

    return(
        <div>
            <h1>Enter a City to get the Weather Details</h1>
            <input type="text"></input>
        </div>
    )
}

export default SearchWeatherAfterLocation;