# Building the Docker Images

Each Docker image can be build individually by executing the build script for that image. Alternatively, users can manually invoke the docker build commands on their own and select the Dockerfile for the given package by using the -f option.

## Build Instructions

### Fuseki

To build the Fuseki image, execute the following from a shell

```bash
sh ./buildFusekiImage.sh
```

After the image is built, it can be executed with 

```bash
docker run -it -p 3030:3030 fuseki
```

In some cases, running on the host network instead of the network bridge is required. This can be accomplished with Docker's network flag as follows

```bash
docker run -it -p 3030:3030 --network=host fuseki
```

Either execution will result in a webserver executing automatically at http://localhost:3030. It is often useful to have a shell for debugging purposes. The image can be run with a shell by executing the following

```bash
docker run -it -p 3030:3030 --network=host fuseki /bin/bash
```
