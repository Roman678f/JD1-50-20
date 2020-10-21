/*
 * Сергей Шпаковский
 *
 * Это программное обеспечение является публичной и открытой
 * информацией.
 *
 * АВТОР НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО
 * НЕ ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ
 * ОПРЕДЕЛЁННОМУ НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ
 * ДАННОГО ФАЙЛА ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ
 * ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ
 * КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ, АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ
 * ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package homework6.service;

import java.util.Comparator;

/**
 * Класс компаратор для сравнения объектов Person только по длине
 * пароля.
 */
public class PersonPasswordComparator implements Comparator<Person> {

    /**
     * Компаратор для двух объектов типа Person сравнивающий только
     * по длине пароля.
     * Возвращает отрицательное значение, если длина пароля первого
     * объекта меньше длины пароля второго.
     * Возвращает ноль, если поля длина пароля у двух объектов равна.
     * Возвращает положительное значение, если длина пароля второго
     * объекта меньше длины пароля первого объекта.
     * @param o1 первый объект Person.
     * @param o2 второй объект Person.
     * @return целове число, знаковое.
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getPassword().length() - o2.getPassword().length();
    }
}