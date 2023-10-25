const SearchCity = async (query,setLocationData) => {
    try{
    const response = await fetch(`http://localhost:8080/api/weather/search/${query}`,{
        method:'GET',
});
if(!response.ok){
    throw new Error(`HTTP error! Status ${response.status}`);

}
const data = await response.json();
setLocationData(data);
    }catch(error){
        console.error("There was a problem with the fetch operation:", error.message);
    }
    
}

export default SearchCity;