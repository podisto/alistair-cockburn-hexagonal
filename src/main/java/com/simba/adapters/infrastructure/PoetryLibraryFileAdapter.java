package com.simba.adapters.infrastructure;

import com.simba.domain.IObtainPoems;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PoetryLibraryFileAdapter implements IObtainPoems {

    public static final String PATH = "/Users/podisto/poetries.txt";

    public void add(String poetry) {
        try {
            Files.write(Paths.get(PATH), poetry.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Impossible d'écrire " + e);
        }
    }

    public Set<String> all() {
        Set<String> poetries = new HashSet<>();
        try (Stream<String> stream = Files.lines(Paths.get(PATH))) {
            stream.forEach(poetries::add);
        } catch (IOException e) {
            System.out.println("Impossible de lire " + e.getMessage());
        }
        return poetries;
    }
}
