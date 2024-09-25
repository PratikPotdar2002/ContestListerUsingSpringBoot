package com.example.contestdata.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DataController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> getAllData() throws IOException {
        Path path = Paths.get(new ClassPathResource("/data/data.json").getURI());
        String jsonContent = new String(Files.readAllBytes(path));
        return new ResponseEntity<>(jsonContent, HttpStatus.OK);
    }
}
