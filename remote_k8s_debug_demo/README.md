# Remote debug a Spring Boot application on Kubernetes

### Requirements
-  [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - Oracle or Open JDK8 and newer
-  [Maven](https://maven.apache.org/download.cgi)


## Getting Started
- The easiest way to get started is to clone the repository and import it in your preferred IDE as an `existing Maven project`.
- `mvn install / package` - Create a runnable jar of the project (will also run tests)
- `docker build -t urosht/demo-remote-debug .`
- Create a run configuration for remote debugging
- `kubectl apply -f ./k8s`
- Either expose a port via `port-forward` or via service and run the debugging session from your IDE
- Call the `/hello` endpoint to trigger the debugging
