# rest-jenai-java

Java based RESTful API using a LLM Model loaded locally based on java-llama-cpp and Spring framework.
There's no other service needed and it's self contained as long as you have downloaded a model in gguf format which supported by llama.cpp.

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

## Build java application

Run following command on top of source directory and `targets` directory will be created with binaries.
```sh
mvn clean package
```

## Configuration

Update the `src/main/resources/application.yml` file to configure the model path and GPU layers:

```yaml
llm:
  model:
    path: models/mistral-7b-instruct-v0.2.Q3_K_M.gguf
    ngpu: 43
```

## Run example

```
$ curl -X GET -G http://localhost:8080/api/chat --data-urlencode 'prompt="Explain me the word spring with 3 examples"'


Spring is a season that marks the transition from winter to summer. It is a time when the weather begins to warm up, and nature starts to awaken from its winter slumber. Here are three examples that illustrate the concept of spring:

1. Botanical example: In the botanical world, spring is the time when many plants begin to grow and bloom. For instance, the cherry blossoms are a famous symbol of spring in Japan. These beautiful pink flowers bloom in early spring, signaling the end of winter and the beginning of new life.
2. Geological example: Geologically, spring refers to the rise of groundwater to the surface. The meltwater from the snow and ice in the mountains eventually forms streams and rivers. The springs provide water for both irrigation and human consumption. For example, Hot Springs National Park in Arkansas is famous for its hot springs that have been used for therapeutic purposes since ancient times.
3. Cultural example: In many cultures, spring is a time for festivals and celebrations. For instance, the Chinese New Year, which falls between late January and mid-February, marks the beginning of a new year. This is a time for family reunions, feasting, and gift-giving. Another example is the Indian festival of Holi, also known as the Festival of Colors, which celebrates the arrival of spring and the victory of good over evil. During Holi, people smear each other with colored powders and throw water balloons, creating a vibrant and joyful atmosphere.
```


## Docker

To build and run the application in a Docker container, use the following commands:

```bash
# Build the Docker image
docker build -t rest-genai-java .
# Run the Docker container
docker run -p 8080:8080 rest-genai-java
```

`Dockerfile` assumes the model is in the `models` directory. If you want to use a different model, you can modify the `Dockerfile` to copy your model into the container.

## Thanks
- kherud for [java-llama-cpp](https://github.com/kherud/java-llama.cpp)
