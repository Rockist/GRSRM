package com.haesolinfo.srm.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.io.File;

@Component
public class InitAppRunner implements ApplicationRunner {
    @Value("${file.path}")
    private String filePath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
        }
        System.out.println("결과 : " + filePath);
        boolean result = file.mkdirs();
        System.out.println("결과 ? : " + result);
    }
}
