package com.example.springai.service;

import com.example.springai.response.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final OllamaChatClient chatClient;

    public Answer call(String message) {

        String call = chatClient.call(message);
        return Answer.builder()
                .answer(call)
                .build();
    }

    public Flux<ChatResponse> stream(Prompt prompt) {
        return chatClient.stream(prompt);
    }
}
