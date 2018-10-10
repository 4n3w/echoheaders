#!/usr/bin/env bash

HOSTNAME=http://localhost:8080

function generate_random(){
  cat /dev/urandom | env LC_CTYPE=C tr -dc 'a-zA-Z0-9' | fold -w $1 | head -n 1
}

HEADER4K=$(generate_random 4000)
HEADER8K=$(generate_random 8000)
HEADER16K=$(generate_random 16000)
HEADER32K=$(generate_random 32000)
HEADER64K=$(generate_random 65000)

curl -X GET ${HOSTNAME} -H "4K-Header: $HEADER4K"
curl -X GET ${HOSTNAME} -H "8K-Header: $HEADER8K"
curl -X GET ${HOSTNAME} -H "16K-Header: $HEADER16K"
curl -X GET ${HOSTNAME} -H "32K-Header: $HEADER32K"
curl -X GET ${HOSTNAME} -H "64K-Header: $HEADER64K"

#http GET ${HOSTNAME} "4K-Header: $HEADER4K" --print=h
