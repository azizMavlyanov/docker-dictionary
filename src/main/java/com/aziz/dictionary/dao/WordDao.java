package com.aziz.dictionary.dao;

import com.aziz.dictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordDao extends JpaRepository<Word, Integer> {
    Word findByName(String name);
}
