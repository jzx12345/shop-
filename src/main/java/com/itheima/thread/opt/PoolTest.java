package com.itheima.thread.opt;

import java.util.concurrent.*;

public class PoolTest {
    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3,
                5,
                20,
                TimeUnit.SECONDS,
                queue,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread();
                        t.setName("1231");
                        return t;
                    }
                },
        new RejectedExecutionHandler() {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("reject");
                    }
                }
        );


        while (true){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println(1);
        }


    }


}
