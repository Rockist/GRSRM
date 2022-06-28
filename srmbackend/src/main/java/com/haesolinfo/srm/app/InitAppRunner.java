package com.haesolinfo.srm.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class InitAppRunner implements ApplicationRunner {
    @Value("${file.path}")
    private String filePath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File file = new File(filePath);
        if(file.exists()) {
            Path path = Paths.get(filePath);
            Files.delete(path);
        }
        System.out.println("결과 : " + filePath);
        boolean result = file.mkdirs();
        System.out.println("결과 ? : " + result);
    }
}
