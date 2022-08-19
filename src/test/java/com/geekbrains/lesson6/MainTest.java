package com.geekbrains.lesson6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ActionsOnArraysTest {
    public ActionsOnArrays actionsOnArrays;

    @BeforeAll
    static void start() {
        System.out.println("Старт тестов!");
    }

    @AfterAll
    static void finish() {
        System.out.println("Завершение тестов!");
    }

    @BeforeEach
    void initialization() {
        actionsOnArrays = new ActionsOnArrays();
    }

    @DisplayName("Tест метода  arrCopy на исключение ")
    @Test
    void arrCopyTest() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            actionsOnArrays.arrCopy(new int[]{3, 5, 6, 7});
        });
        System.out.println("Ожидаемый результат - " + RuntimeException.class.getName() + " | Факт - " + Assertions.assertThrows(RuntimeException.class, () -> {
            actionsOnArrays.arrCopy(new int[]{3, 5, 6, 7});
        }));
    }

    @DisplayName("Параметризованный  тест метода arrCopy")
    @ParameterizedTest
    @MethodSource("data1")
    void arrCopyParamTest(int[] arrA, int[] arrB) {
        Assertions.assertArrayEquals(arrA, actionsOnArrays.arrCopy(arrB));
        System.out.println("Ожидаемый результат - " + Arrays.toString(arrA) + " | Факт - " + Arrays.toString(actionsOnArrays.arrCopy(arrB)));
    }

    @DisplayName("Параметризованный тест метода  arrFound (true)")
    @ParameterizedTest
    @MethodSource("data2")
    void arrFoundTest1(int[] arrA) {
        Assertions.assertTrue(actionsOnArrays.arrFound(arrA));
        System.out.println("Ожидаемый результат - true" + " | Факт - " + actionsOnArrays.arrFound(arrA));

    }

    @DisplayName("Параметризованный тест метода  arrFound (false)")
    @ParameterizedTest
    @MethodSource("data3")
    void arrFoundTest2(int[] arrA) {
        Assertions.assertFalse(actionsOnArrays.arrFound(arrA));
        System.out.println("Ожидаемый результат - false" + " | Факт - " + actionsOnArrays.arrFound(arrA));

    }

    static Stream<Arguments> data1() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 5, 6}, new int[]{7, 4, 3, 5, 6}),
                Arguments.arguments(new int[]{1, 6, 3, 5}, new int[]{0, 3, 4, 1, 6, 3, 5}),
                Arguments.arguments(new int[]{1, 5, 6, 1}, new int[]{1, 9, 4, 1, 5, 6, 1}),
                Arguments.arguments(new int[]{7, 7, 7}, new int[]{7, 4, 7, 7, 7}),
                Arguments.arguments(new int[]{3, 5, 6}, new int[]{7, 4, 3, 5, 6})
        );
    }

    static Stream<Arguments> data2() {
        return Stream.of(
                Arguments.arguments(new int[]{7, 4, 3, 1, 6}),
                Arguments.arguments(new int[]{0, 3, 4, 1, 6, 3, 5}),
                Arguments.arguments(new int[]{1, 9, 4, 1, 5, 6, 1}),
                Arguments.arguments(new int[]{7, 1, 7, 7, 4}),
                Arguments.arguments(new int[]{7, 4, 3, 1, 6})
        );
    }

    static Stream<Arguments> data3() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 4, 3, 0, 6}),
                Arguments.arguments(new int[]{0, 3, 0, 1, 6, 3, 5}),
                Arguments.arguments(new int[]{1, 9, 0, 6, 5, 6, 5}),
                Arguments.arguments(new int[]{7, 6, 7, 7, 4}),
                Arguments.arguments(new int[]{7, 6, 3, 6, 6})
        );
    }

}