package io.bluemoon.product.category.api.controller;

import io.bluemoon.product.category.api.common.AsyncCallable;
import io.bluemoon.product.category.core.CategoryMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class MappingController {

    @Autowired
    private CategoryMapping categoryMapping;

    @GetMapping(path = "/mapping")
    public String getMapping() {
        categoryMapping.mapping();
        return "test";
    }

    @GetMapping(path = "/aync/mapping")
    public String asyncGetMapping() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<String> task = new AsyncCallable(executorService);
        // todo
        // executoreService에 대해서도 알아보


        executorService.shutdown();
        return "test..";
    }
}
