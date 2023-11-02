const DeleteCityFetch = async (cityId, setFavoriteCity) => {
    try {
        const response = await fetch(`http://localhost:8080/api/weather/${cityId}`, {
            method: 'DELETE',
        });
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        setFavoriteCity((prevCities) => prevCities.filter((city) => city.id !== cityId));
    } catch (error) {
        console.error("There was a problem with the fetch operation:", error.message);
    }
}
export default DeleteCityFetch;
