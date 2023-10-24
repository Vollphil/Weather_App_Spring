const GetWeatherDetailsFromLoaction = async (location,setWeatherData) =>{
    try{
        const response = await fetch(`http://localhost:8080/api/weather/current/${location}`,{
            method:'GET',
    });
    if(!response.ok){
        throw new Error(`HTTP error! Status ${response.status}`);
    
    }
    const data = await response.json();
    setWeatherData(data);
        }catch(error){
            console.error("There was a problem with the fetch operation:", error.message);
        }
        
}
export default GetWeatherDetailsFromLoaction;