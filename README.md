# cloud-movies

Spring Boot app used as an example for cloud deployment.

## Running

### Environment variables
You need to have these variables set before running the app:

- DB_URL - PostgresDB URL
- DB_USERNAME - PostgresDB login username
- DB_PASSWORD - PostgresDB login password
- DB_TABLE_NAME - The name of the table that is already created withing the provided database, with the following columns (Long id, String title, String genre, Long year)

After those are set you can run the following command:

```bash
./mvnw spring-boot:run
```

## Building a Docker image

```bash
docker build -t cloud-movies .
```

### Running the image

```bash
sudo docker run -e DB_URL=jdbc:postgresql://172.17.0.1:5432/movies \
 -e DB_USERNAME=postgres \
 -e DB_PASSWORD=admin \
 -e DB_TABLE_NAME=movie \
 -p 8080:8080 -d cloud-movies
```