# Intro

This is a WildFly Swarm microservice that represents inventory in a retail store. It uses the Fabric8 Maven Plugin to deploy to OpenShift.

# Running on OpenShift

You'll need to have access to an OpenShift cluster and the `oc` command line interface.

1. Login to OpenShift and create a new project

```
oc login
oc new-project demo
```

2. Use the Fabric8 Maven Plugin to launch the S2I process on the OpenShift Online machine & start the pod.

```
mvn clean fabric8:deploy -Popenshift  -DskipTests
```

This will build and deploy the microservice along with a Postgres database.

3. To test the service using curl:

```
curl http://inventory-<project>.<domain>/api/inventory/329299
```
For example:

```
$ curl http://inventory-lab3.apps.127.0.0.1.nip.io/api/inventory/329299
{"itemId":"329299","location":"Raleigh","quantity":736,"link":"http://maps.google.com/?q=Raleigh"}
```

