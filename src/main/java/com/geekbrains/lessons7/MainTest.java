package com.geekbrains.lessons7;
//Created by PugaevDenis

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*ЗАДАЧА
        1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с
        аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
        передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод с
        аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех
        тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1
        до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок
        не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
        иначе необходимо бросить RuntimeException при запуске «тестирования».*/

public class MainTest {
    private static List<Method> list = new ArrayList<>();

    public static void main(String[] args) {
        try {
            start(TestClass.class);
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private static void start(Class c) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class<?> cls = Class.forName(c.getName());
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            list.add(method);
        }

        list.sort((a, b) -> {
            return b.getAnnotation(Test.class).priority() - a.getAnnotation(Test.class).priority();
        });

        for (Method method : list) {
            method.invoke(cls.getDeclaredConstructor().newInstance());
        }
    }
}
