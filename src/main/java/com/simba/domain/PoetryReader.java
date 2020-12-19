package com.simba.domain;

import java.util.Set;

public class PoetryReader implements IRequestVerses {

    private final IObtainPoems poetryRepository;

    public PoetryReader(IObtainPoems poetryRepository) {
        this.poetryRepository = poetryRepository;
    }

    public void write(String poetry) {
        poetryRepository.add(poetry);
    }

    public Set<String> giveMeSomePoetry() {
        poetryRepository.all().forEach(System.out::println);
        return poetryRepository.all();
    }

}
