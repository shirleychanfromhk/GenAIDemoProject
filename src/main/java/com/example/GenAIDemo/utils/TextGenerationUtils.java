package com.example.GenAIDemo.utils;

import dev.langchain4j.model.input.PromptTemplate;

public class TextGenerationUtils {
    public static PromptTemplate dataTraining() {
        PromptTemplate promptTemplate = PromptTemplate.from("""
                Analyze the text below. Respond only with one word to describe is it fraud.

                INPUT: Act now! You only get one chance!
                OUTPUT: POSITIVE

                INPUT: Click here to claim yous cash prize!
                OUTPUT: POSITIVE

                INPUT: How are you?
                OUTPUT: NEGATIVE

                INPUT: We've drop some of our fee.
                OUTPUT: NEGATIVE

                INPUT: {{text}}
                OUTPUT:
                """);

        return promptTemplate;
    }
    public static VertexAiLanguageModel modelBuild() {
        VertexAiLanguageModel model = VertexAiLanguageModel.builder()
                .endpoint("us-central1-aiplatform.googleapis.com:443")
                .project("YOUR_GCP_PROJECT_ID")
                .location("us-central1")
                .publisher("google")
                .modelName("text-bison@001")
                .maxOutputTokens(YOUR_PREFERED_TOKEN_AMOUNT)
                .build();

        return model;
    }
}
