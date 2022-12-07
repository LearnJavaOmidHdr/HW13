package org.example.panels;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Space {

    public static void space(){
        IntStream.range(0, 8).mapToObj(i -> "\n").forEach(System.out::println);
    }
}
