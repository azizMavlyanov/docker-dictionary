package com.aziz.dictionary.service;

import com.aziz.dictionary.dao.WordDao;
import com.aziz.dictionary.domain.Word;
import com.aziz.dictionary.exception.ConflictException;
import com.aziz.dictionary.model.WordRequest;
import com.aziz.dictionary.model.WordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordDao wordDao;

    @Override
    @Transactional
    public void createWord(WordRequest wordRequest) {
        final Word word = wordDao.findByName(wordRequest.getName().trim());

        if (word != null) {
            throw new ConflictException("Resource already exists");
        }

        wordDao.save(new Word()
                .setName(wordRequest.getName().trim())
                .setDescription(wordRequest.getDescription()));

    }

    @Override
    @Transactional
    public WordResponse findByName(String name) {
        final Word word = wordDao.findByName(name.trim());

        if (word != null) {
            return new WordResponse()
                    .setId(word.getId())
                    .setName(word.getName())
                    .setDescription(word.getDescription());
        }

        throw new EntityNotFoundException("Resource not found");
    }
}
