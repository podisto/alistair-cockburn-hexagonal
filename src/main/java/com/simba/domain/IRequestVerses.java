package com.simba.domain;

import java.util.Set;

public interface IRequestVerses {

    void write(String poetry);

    Set<String> giveMeSomePoetry();
}
