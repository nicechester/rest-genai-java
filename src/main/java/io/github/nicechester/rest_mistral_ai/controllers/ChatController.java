package io.github.nicechester.rest_mistral_ai.controllers;

import io.github.nicechester.rest_mistral_ai.services.LLMService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {
    private final LLMService llmService;

    @GetMapping("chat")
    public String chat(@RequestParam String prompt) {
        return llmService.infer(prompt);
    }
}
