package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        PrintEveryOneSecondThread thread = new PrintEveryOneSecondThread();
//        PrintEveryFiveSecondsThread thread1 = new PrintEveryFiveSecondsThread();
//        thread1.start();
//        thread.start();

        ExecutorService service = Executors.newFixedThreadPool(5);
        FizzBuzz fizzBuzz = new FizzBuzz();
        service.submit(fizzBuzz::fizz);
        service.submit(fizzBuzz::buzz);
        service.submit(fizzBuzz::fizzbuzz);
        service.submit(fizzBuzz::number);
        service.submit(fizzBuzz::print);

    }

    public static class PrintEveryOneSecondThread extends Thread {
        public void run(){
            int i = 0;
            System.out.println(i);

            while(true){
                try {
                   Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                i++;
                if(i % 5 == 0){
                    continue;
                }

                System.out.println(i + " " +System.currentTimeMillis());
            }
        }
    }

    public static class PrintEveryFiveSecondsThread extends Thread {
        public void run(){
            int i = 0;

            while(true){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                i+=5;
                System.out.println(i + " seconds left" + " " +System.currentTimeMillis());
            }
        }
    }
}