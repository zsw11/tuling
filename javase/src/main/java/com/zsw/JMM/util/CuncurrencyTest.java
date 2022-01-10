package com.zsw.JMM.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author zsw
 * @date 2022/1/7 17:17
 * @Company: 广州市两棵树网络科技有限公司
 */
@Slf4j
public class CuncurrencyTest {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程总数
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 定义信号量 最大的线程数量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);

    }

    private static void  add() {
        count++;
    }
}

