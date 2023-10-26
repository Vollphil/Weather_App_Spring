
const FavoriteCitySave = async(weatherData,callback) => {
    try{
        const response = await fetch('http://localhost:8080/api/weather/favoriteCity',{
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({cityName: weatherData.location.name, countryName: weatherData.location.country})
        });
        if(!response.ok){
            throw new Error(`HTTP error! Status: ${response.status}`);

        }
        const data = await response.json();
        callback(data);
    } catch(error){
        console.error("There was an error with the fetch operation:", error.message);
    }

}
export default FavoriteCitySave;