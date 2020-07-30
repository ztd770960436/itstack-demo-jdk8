package org.itstack.demo;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalTest {
    @Test
    public void of() {
        String name = "name";
        assertThat(Optional.of(name).get()).isEqualTo("name");
    }

    @Test(expected = NullPointerException.class)
    public void ofThrowException() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void ofNullable() {
        String name = null;
        String orElse = Optional.ofNullable(name).orElse("123");
        assertThat(orElse).isEqualTo("123");
    }

    @Test
    public void ifPresent() {
        String name = null;
        if(name != null) {
            System.out.println("hello " + name+ ".");
        }
        Optional.ofNullable(name).ifPresent(s-> System.out.println("hello " + name));
        Optional.ofNullable(name).ifPresent(System.out::println);
        Optional.ofNullable(name).orElse("897");
    }

    @Test
    public void map() {
        String name = "dada";
        Optional.ofNullable(name).map(str-> "hello " + str).ifPresent(System.out::println);
    }

    @Test
    public void map_orElse() {
        String name = null;
        String result = Optional.ofNullable(name).map(str -> "123").orElse("456");
        assertThat(result).isEqualTo("456");
    }

    @Test
    public void map_orElseGet() {
        String name = null;
        String orElseGet = Optional.ofNullable(name).map((s) -> s + "hell").orElseGet(() -> "789");
        assertThat(orElseGet).isEqualTo("789");
    }

    @Test(expected = RuntimeException.class)
    public void map_orElseThrow() {
        String name = null;
        Optional.ofNullable(name).map((s) -> s + "hell").orElseThrow(() -> new RuntimeException("haha"));
    }

    @Test
    public void orElse() {
        Object orElse = Optional.ofNullable(null).orElse("123");
        assertThat(orElse).isEqualTo("123");
    }

    @Test
    public void orElseGet() {
        Object orElse = Optional.ofNullable(null).orElseGet(() -> "123");
        assertThat(orElse).isEqualTo("123");
    }

    @Test(expected = RuntimeException.class)
    public void orElseThrow() {
        Optional.ofNullable(null).orElseThrow(() -> new RuntimeException("出错了"));
    }


}
