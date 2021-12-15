# BATS

BATS, the Basic Artifact Tracking System (BATS), is a simple data management service for managing scientific data.

## Build Instructions

### Prerequisites

BATS requires a full installation of Docker for building, executing, and storing images.
See below section "Running BATS with Docker" for how to use BATS with Docker.

### Detailed Build Instructions

See each subfolder for build instructions.


### Running BATS with Docker

The following are available Docker utilities for BATS

####  Quickstart w/ docker-compose

You can spin up BATS with a Fuseki backend service using [docker-compose](https://docs.docker.com/compose/) via:

```
docker-compose build
docker-compose up
```

Spin down the containers via:

```
docker-compose down
```

#### Running Tests w/ docker-compose

To run the test suite, run:

```
docker-compose -f docker-compose.test.yml build
docker-compose -f docker-compose.test.yml run bats mvn test
docker-compose -f docker-compose.test.yml down
```

## How BATS got its name

I had a discussion with my daughter, 17 months old at the time, about her favorite animal. She picked the moose, but since that is already taken by several projects we settled on her second favorite animal, the bat. I then back-ronymed a name out of it.
