package com.aziz.dictionary.web;

import com.aziz.dictionary.model.WordRequest;
import com.aziz.dictionary.model.WordResponse;
import com.aziz.dictionary.service.WordService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Word operations")
@RestController
@RequestMapping(value = "/api/v1/words", consumes = "application/json", produces = "application/json")
@RequiredArgsConstructor
public class WebController {
    private final WordService wordService;

    @ApiResponse(responseCode = "200", description = "Fetching word by name")
    @GetMapping(value = "/{name}")
    public WordResponse findByName(@PathVariable(value = "name") String name) {
        return wordService.findByName(name);
    }

    @ApiResponse(responseCode = "200", description = "Create new word")
    @PostMapping
    public ResponseEntity<Void> createWord(@RequestBody WordRequest wordRequest) {
        wordService.createWord(wordRequest);

        return ResponseEntity.ok().build();
    }
}
