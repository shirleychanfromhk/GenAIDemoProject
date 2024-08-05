package com.example.GenAIDemo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GenAIDemo.utils.TextGenerationUtils;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.vertexai.VertexAiLanguageModel;

@Service
public class TextGenerationService {
    VertexAiLanguageModel model = TextGenerationUtils.modelBuild();

    public String interctResponse(String questionString) {
        Response<String> response = model.generate(questionString);

        return response.content();
    }

    public String analyzSentiment(String input) {
        PromptTemplate promptTemplate = TextGenerationUtils.dataTraining();

        Prompt prompt = promptTemplate.apply(
                Map.of("text", input));

        Response<String> response = model.generate(prompt);

        return response.content();

    }
}
