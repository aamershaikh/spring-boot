package com.aamer.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

// Model POJO
public class Person {

    private final UUID id;

    @NotBlank
    private final String name;

    // @JSON Property indicates property name in the incoming json request.
    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

