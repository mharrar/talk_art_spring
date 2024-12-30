# Utiliser une image de base avec JDK
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR dans le conteneur depuis le répertoire target
COPY target/talkart-0.0.1-SNAPSHOT.jar.original /app/talkart.jar

# Exposer le port de l'application (par défaut 8092 pour Spring Boot)
EXPOSE 8092

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app/talkart.jar"]
