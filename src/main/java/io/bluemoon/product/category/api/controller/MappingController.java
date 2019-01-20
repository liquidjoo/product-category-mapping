package io.bluemoon.product.category.api.controller;

import io.bluemoon.product.category.core.CategoryMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    @Autowired
    private CategoryMapping categoryMapping;

    @GetMapping(path = "/mapping")
    public String getMapping() {
        categoryMapping.mapping();
        return "test";
    }
}
