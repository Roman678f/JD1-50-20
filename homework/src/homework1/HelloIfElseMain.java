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
package homework1;

import java.util.Objects;
import java.util.Scanner;

/**
 * Класс - пример использования if-else if и ввода строки с консоли.
 *
 * @version   1.00 29.08.2020
 * @author    Сергей Шпаковский
 */
public class HelloIfElseMain {
    
    /**
     * Точка входа и пример использования if-else if,
     * ввода строки с консоли, сравнения двух строк.
     *
     * @param args массив строк, ввод
     */
    public static void main(String[] args) {
        String girlFriend = "Анастасия";
        String friend = "Вася";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.next();
        Boolean checkFriend = Objects.equals(name, friend);
        Boolean checkGirlFriend = Objects.equals(name, girlFriend);
        if (checkGirlFriend) {
            System.out.println("Я тебя так долго ждал");
        } else if (checkFriend) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        } else {
            System.out.println("Добрый день, а вы кто?");
        }
    }
}