package com.aziz.dictionary.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WordResponse {
    private Integer id;
    private String name;
    private String description;
}
