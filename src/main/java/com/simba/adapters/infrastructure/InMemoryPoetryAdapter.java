package com.simba.adapters.infrastructure;

import com.simba.domain.IObtainPoems;

import java.util.LinkedHashSet;
import java.util.Set;

public class InMemoryPoetryAdapter implements IObtainPoems {

    private final Set<String> poetries = new LinkedHashSet<>();

    public void add(String poetry) {
        poetries.add(poetry);
    }

    public Set<String> all() {
        return poetries;
    }
}
