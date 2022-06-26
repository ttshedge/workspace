package com.test.test;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class EvenOddCompletableFuture {

    private static Object object = new Object();

    static IntPredicate evenPredicate  = e-> e % 2==0;
    static IntPredicate oddPredicate  = e-> e % 2!=0;

    public static void printNumber(IntPredicate condition) {
        IntStream.rangeClosed(1,10).filter(condition).forEach(EvenOddCompletableFuture::execute);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->EvenOddCompletableFuture.printNumber(evenPredicate));
        CompletableFuture.runAsync(()->EvenOddCompletableFuture.printNumber(oddPredicate));
        Thread.sleep(1000);
    }

    public static void execute(int no) {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " : " + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
