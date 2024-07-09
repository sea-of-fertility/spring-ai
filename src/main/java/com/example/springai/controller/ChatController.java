package com.example.springai.controller;

import com.example.springai.requset.Question;
import com.example.springai.response.Answer;
import com.example.springai.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {


    private final ChatService chatService;


    @PostMapping("/question")
    public Answer question(@RequestBody Question question) {
        log.info("{}",question.getMessage());
        return chatService.call(question.getMessage());
    }


    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Answer call = chatService.call(message);
        log.info("{}",call.getAnswer());
        return Map.of("generation", call.getAnswer());
    }


    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatService.stream(prompt);
    }


}
