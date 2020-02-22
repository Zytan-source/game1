# Dockerfile References: https://docs.docker.com/engine/reference/builder/

FROM openjdk:8

COPY target/replay-1.0-SNAPSHOT.jar ./

COPY websocketd-0.3.1_amd64.deb ./

RUN apt-get install /websocketd-0.3.1_amd64.deb 

RUN mkdir /docs

# Sample page for load balancer health checks
RUN echo '<h1>test</h1>' > docs/index.html

# Remove HIGH vulnerable curl
RUN apt-get -y remove --purge curl

EXPOSE 80

# Command to run the executable
CMD websocketd --port=80 --staticdir docs java -cp replay-1.0-SNAPSHOT.jar johnc.App
