echo "===Starting Kind cluster==="

kind create cluster --name microservices --config kind-config.yaml

echo "Loading Docker images into Kind cluster"

chmod +x ./kind-load.sh
./kind-load.sh

echo "===Kind cluster started==="
