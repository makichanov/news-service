News service web server

Application retrieves news data periodically from public API (once every hour)

Setup:
1. Configure database properties as env variables:
   - DB_HOSTNAME: database host (e.g. localhost)
   - DB_USER: database user permitted to read/write to required database
   - DB_PASSWORD: database user password
   - DB_NAME: database name
   - DB_PORT: database port
2. Application configured to fetch news data from https://mediastack.com/. It requires API key to function. Configure your own key in application properties file under "secret.apiKey" key