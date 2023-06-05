function fn() {
    karate.configure('ssl', true);
    var env = karate.env;
    var baseURL = ''
    karate.log('Se realiza la ejecución en ambiente: ', env);


    if (!env) {
        env = 'dev';
    }
    if (env === 'dev') {
        baseURL = 'https://api.countrylayer.com'
    } else if (env === 'cert') {
        baseURL = 'https://api.countrylayer.com'
    }

    var config = {
        env: env,
        baseURL: baseURL
    }
    return config;
}


