package com.aziz.dictionary.service;

import com.aziz.dictionary.model.WordRequest;
import com.aziz.dictionary.model.WordResponse;

public interface WordService {
    void createWord(WordRequest wordRequest);
    WordResponse findByName(String name);
}
