#!/usr/bin/env bash

mvn install dockerfile:build

docker run -d --network=host --name eprestservice_mongodb mongo

docker run --network=host -t --name=eprestservice eprestservice/restservice

