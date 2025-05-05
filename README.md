# rest-mistral-ai

RESTful API for interacting with the Mistral AI Model.

## Model

- Download mistral-7b-instruct-v0.2.Q3_K_M.gguf
```
wget https://huggingface.co/TheBloke/Mistral-7B-Instruct-v0.2-GGUF/resolve/main/mistral-7b-instruct-v0.2.Q3_K_M.gguf
```
- Place the downloaded model in the `models` directory.

## Features

- Load and infer using the Mistral AI model.
- Configurable model path and GPU layers via `application.yml`.
- Built with Spring Boot and Java 23.

## Requirements

- Java 23
- Maven 3.8+
- Docker (optional for containerized deployment)


## Configuration

Update the `src/main/resources/application.yml` file to configure the model path and GPU layers:

```yaml
llm:
  model:
    path: models/mistral-7b-instruct-v0.2.Q3_K_M.gguf
    ngpu: 43
```

## Docker

To build and run the application in a Docker container, use the following commands:

```bash
# Build the Docker image
docker build -t rest-mistral-ai .
# Run the Docker container
docker run -p 8080:8080 rest-mistral-ai
```

`Dockerfile` assumes the model is in the `models` directory. If you want to use a different model, you can modify the `Dockerfile` to copy your model into the container.

## Thanks
- kherud for [java-llama-cpp](https://github.com/kherud/java-llama.cpp)
