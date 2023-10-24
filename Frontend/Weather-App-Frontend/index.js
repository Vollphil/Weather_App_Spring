import SearchWeatherAfterLocation from "./Pages/SearchWeatherAfterLocation";
import ErrorPage from "./Pages/ErrorPage";

const { createBrowserRouter, RouterProvider } = require("react-router-dom");

const router = createBrowserRouter([
    {
        path:"/",
        element:<SearchWeatherAfterLocation/>,
        errorElement: <ErrorPage/>,
        children:[

        ]
    
    }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
);