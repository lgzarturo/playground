FROM ubuntu:20.04
RUN apt-get update && apt-get install -y software-properties-common gcc && add-apt-repository -y ppa:deadsnakes/ppa
RUN apt-get update && apt-get install -y python3.9 python3-distutils python3-pip python3-apt pkg-config libcairo2 libgirepository1.0-dev libcairo2-dev python-cairo
RUN apt-get update && apt-get install --no-install-recommends --no-install-suggests -y curl && rm -rf /var/lib/apt/lists/*
COPY requirements.txt requirements.txt
RUN pip3 install --upgrade pip
RUN pip3 install -r requirements.txt
RUN pip3 install html2text