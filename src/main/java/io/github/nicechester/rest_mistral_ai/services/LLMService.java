package io.github.nicechester.rest_mistral_ai.services;

import de.kherud.llama.InferenceParameters;
import de.kherud.llama.LlamaModel;
import de.kherud.llama.LlamaOutput;
import de.kherud.llama.ModelParameters;
import de.kherud.llama.args.MiroStat;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class LLMService {
    private final LlamaModel model;
    private final float temperature;

    public LLMService(@Value("${llm.model.path}") String modelPath,
                      @Value("${llm.model.ngpu}") int ngpuLayers,
                      @Value("${llm.model.temperature}") float temperature) {

        log.info("Loading model from path: {}", modelPath);
        ModelParameters modelParams = new ModelParameters()
                .setModelFilePath(modelPath)
                .setNGpuLayers(ngpuLayers);
        this.temperature = temperature;
        this.model = new LlamaModel(modelParams);
    }

    public String infer(String prompt) {
        InferenceParameters inferParams = new InferenceParameters(prompt)
                .setTemperature(temperature)
                .setPenalizeNl(true)
                .setMiroStat(MiroStat.V2);
        String response = "";
        for (LlamaOutput output : model.generate(inferParams)) {
            response += output;
        }
        return response;
    }
}
