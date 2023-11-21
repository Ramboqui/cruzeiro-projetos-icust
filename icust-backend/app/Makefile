# TODO: fix date logic; avoid regen
#TAG = `date "+%Y%m%d-%H%M"`-`git rev-parse --short HEAD`
TAG = `git rev-parse --short HEAD`

build:
	docker build -t icust-backend:$(TAG) .
	docker tag icust-backend:$(TAG) ericdahl/icust-backend:latest
	docker tag icust-backend:$(TAG) ericdahl/icust-backend:$(TAG)
	echo "Built icust-backend:$(TAG)"

deploy: build
	docker push ericdahl/icust-backend:$(TAG)
	echo "Pushed ericdahl/icust-backend:$(TAG)"

test:
	echo $(C)