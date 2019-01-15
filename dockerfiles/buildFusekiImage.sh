#/bin/bash

FUSEKI_VERSION=3.10.0
FUSEKI_NAME=apache-jena-fuseki
FUSEKI_DOWNLOAD_FILE=$FUSEKI_NAME-$FUSEKI_VERSION.tar.gz

# Download Fuseki if it isn't available
if [ ! -f $FUSEKI_DOWNLOAD_FILE ]; then
	wget https://www-us.apache.org/dist/jena/binaries/$FUSEKI_DOWNLOAD_FILE
fi

# Unpack the Fuseki files
tar -xzvf $FUSEKI_DOWNLOAD_FILE
mv $FUSEKI_NAME-$FUSEKI_VERSION $FUSEKI_NAME

# Build the Docker image
docker build -t fuseki:latest -f Dockerfile.fuseki .

# Remove the unused Fuseki dir
rm -rf $FUSEKI_NAME
