package com.tts.first;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    void testGroupBy() {
        List<Integer> lst = List.of(1,2,3,4,5,6,3,4,5,2,3,3,5,4);

        lst.stream().collect(Collectors.groupingBy())
    }
}
