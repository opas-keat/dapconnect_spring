build_docker:
	echo "build docker by buildx"
	docker buildx build --platform linux/amd64,linux/arm64 -t opas/dapconnectapi:$(version) --push .