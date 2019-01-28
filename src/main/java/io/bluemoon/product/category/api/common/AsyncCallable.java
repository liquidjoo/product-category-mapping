package io.bluemoon.product.category.api.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncCallable implements Callable<String> {
    private ExecutorService executorService;

    public AsyncCallable(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public String call() throws Exception {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;
        int poolSize = threadPoolExecutor.getPoolSize();
        // todo
        return null;
    }
}
