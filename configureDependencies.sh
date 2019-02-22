#/bin/bash

#----- Configure Fuseki -----#

FUSEKI_VERSION=3.10.0
FUSEKI_NAME=apache-jena-fuseki
FUSEKI_DOWNLOAD_FILE=$FUSEKI_NAME-$FUSEKI_VERSION.tar.gz

# Download Fuseki if it isn't available
if [ ! -f dockerfiles/$FUSEKI_DOWNLOAD_FILE ]; then
	wget https://www-us.apache.org/dist/jena/binaries/$FUSEKI_DOWNLOAD_FILE
	mv $FUSEKI_DOWNLOAD_FILE dockerfiles/
fi

# Unpack the Fuseki files
cd dockerfiles
tar -xzvf $FUSEKI_DOWNLOAD_FILE
mv $FUSEKI_NAME-$FUSEKI_VERSION $FUSEKI_NAME

# Make the configuration directory an add the default dataset configuration
#mkdir -p $FUSEKI_NAME/run/configuration
#cp dataset.ttl $FUSEKI_NAME/run/configuration/
cd ..
