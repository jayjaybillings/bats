#/bin/bash

# Download Fuseki
wget https://www-us.apache.org/dist/jena/binaries/apache-jena-3.10.0.tar.gz

# Build the Docker image
docker build -t fuseki:latest -f Dockerfile.fuseki .
