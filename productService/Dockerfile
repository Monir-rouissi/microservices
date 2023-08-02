# Use a base image with Java (choose the appropriate version based on your Spring app requirements)
FROM openjdk:17-oracle

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file to the container
COPY build/libs/product.service-0.0.1-SNAPSHOT.jar /app/my_spring_app.jar

# Expose the port your Spring Boot app is listening on (change to the actual port number)
EXPOSE 8081

# Define environment variables for MongoDB connection (replace with your imaginary values)


# Command to run your Spring Boot app
CMD ["java", "-jar", "my_spring_app.jar"]
