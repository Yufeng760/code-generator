var base_url = "http://localhost:8001/"

const service = axios.create({
    baseURL:base_url,
    timeout:20000
});

service.interceptors.request.use(
    function(config){
        return config;
    },
    function(error){
        Promise.reject(error);
    }
);

service.interceptors.response.use(
    function(response){
        return response;
    },
    function(error){
        Promise.reject(error);
    }
);