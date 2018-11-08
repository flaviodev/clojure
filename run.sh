#!/bin/bash

app_path=`pwd`

docker rm flaviodev-clojure -f
docker run -it --name flaviodev-clojure -v $app_path/hangmangame:/usr/src/app:rw flaviodev-clojure bash
