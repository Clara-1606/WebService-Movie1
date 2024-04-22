# Utiliser l'image officielle OpenJDK 19
FROM adoptopenjdk/openjdk19:alpine-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le jar de votre application dans le conteneur
COPY target/movie-0.0.1-SNAPSHOT.jar /app/movie.jar

# Exposer le port sur lequel votre application Spring Boot écoute
EXPOSE 8080

# Commande pour démarrer votre application Spring Boot lorsque le conteneur démarre
CMD ["java", "-jar", "movie.jar"]