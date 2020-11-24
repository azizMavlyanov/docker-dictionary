package com.aziz.dictionary.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WordRequest {
    private String name;
    private String description;
}
