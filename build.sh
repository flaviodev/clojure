#!/bin/bash
	
docker rmi flaviodev-clojure -f

docker build -t flaviodev-clojure .

