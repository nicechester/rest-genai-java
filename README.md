# rest-mistral-ai

RESTful API for interacting with the Mistral AI Model.

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

## Thanks
- kherud for [java-llama-cpp](https://github.com/kherud/java-llama.cpp)
