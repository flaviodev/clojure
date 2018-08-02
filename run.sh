#!/bin/bash

caminho=`pwd`

docker rm flaviodev-clojure -f
docker run -it --name flaviodev-clojure -v $caminho/forca:/usr/src/app/forca:rw flaviodev-clojure bash
