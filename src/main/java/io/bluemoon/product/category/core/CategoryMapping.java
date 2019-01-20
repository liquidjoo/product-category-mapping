package io.bluemoon.product.category.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryMapping {
    @Autowired
    private ResourceLoader resourceLoader;

    public String mapping() {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();


        try {
            String jsonPath = resourceLoader.getResource("classpath:category_mapping.json").getURI().getPath();
            map = objectMapper.readValue(new File(jsonPath), new TypeReference<Map<String, Object>>(){});
            Map<String, Object> test = (Map<String, Object>) map.get("OUTER");

            System.out.println(test.get("패딩/점퍼"));
        } catch (JsonParseException e) {
            e.printStackTrace();

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return "";
    }
}
