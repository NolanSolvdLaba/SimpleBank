package org.example;

import static java.lang.Thread.sleep;

public class ThreadMain {
    public static void main(String[] args){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                    System.out.println("This thread's ID is: " + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
    }
}
