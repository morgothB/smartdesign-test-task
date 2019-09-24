#!/usr/bin/env bash

timestamp=$(date +"%T")

createResponse=$(curl -s -X POST \
  http://localhost:8080/item \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"name": "Quite regular",
	"desc": "Nothing special, just testing app",
	"params": {"timestamp": "'$timestamp'"}
}')

echo 'Response of POST /item: '$createResponse

createId=$(echo $createResponse | sed 's/{"id":"//' | sed 's/"}//')

searchResponse=$(curl -s -X GET \
  'http://localhost:8080/item/find?timestamp='$timestamp \
  -H 'cache-control: no-cache')

echo 'Response of GET /item/search: '$searchResponse

idFromSearch=$(echo $searchResponse | sed 's/\[{"id":"\([^"]*\)".*/\1/')

getByIdResponse=$(curl -s -X GET \
  'http://localhost:8080/item?id='$idFromSearch \
  -H 'cache-control: no-cache')

echo 'Response of GET /item: '$getByIdResponse

getByIdId=$(echo $getByIdResponse | sed 's/{"id":"\([^"]*\)".*/\1/')


echo $createId
echo $idFromSearch
echo $getByIdId


if [ $createId == $idFromSearch ] && [ $createId == $getByIdId ] && [ $createId == $getByIdId ]; then
  echo "Tests passed"
else
  echo "Something went wrong, ids doesnt matches"
fi