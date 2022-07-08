package com.firsttask;

import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author Denis Taztdinov
 */
public class ReverseString {


    public static void main(String[] args) throws IOException {

        System.out.print("Введите строку: ");

        Scanner reader=new Scanner(System.in);
        String str = reader.nextLine();


        System.out.println("Прямой вывод строки: " + str );

        long time1 = timer(() -> {
            for (int i = 0; i < 1000; i++) {
                reverse(str);
            }
        }, TimeUnit.NANOSECONDS);


        long time2 = timer(() -> {

            for (int i = 0; i < 10000; i++) {
                reverse(str);
            }
        }, TimeUnit.NANOSECONDS);



        long time3 = timer(() -> {
            String result = "";
            for (int i = 0; i < 100000; i++) {
                result = reverse(str);
            }
            System.out.println("Развернутая строка: " + result);
        }, TimeUnit.NANOSECONDS);

        reader.close();

        System.out.println("Время работы при 1000/10000/100000 циклах повторений: " + time1 + "/" + time2 + "/" + time3 + " ns.");


    }
    private static String reverse(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.reverse().toString();

    }

    private static long timer(Runnable method, TimeUnit timeUnit) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, timeUnit);
    }

}