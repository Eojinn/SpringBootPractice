package com.rookies5.myspringbootlab.runner;

import com.rookies5.myspringbootlab.prop.MyEnvironment;
import com.rookies5.myspringbootlab.prop.MyPropProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyPropRunner implements ApplicationRunner {

    @Value("${myprop.username}")
    private String username;

    @Autowired
    private MyPropProperties myPropProperties;

    @Autowired(required = false)
    private MyEnvironment myEnvironment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 1-7) logger.debug()와 logger.info() 사용
        log.debug("DEBUG 로그: MyPropRunner가 실행되었습니다.");

        // 1-4) @Value 값 출력
        log.info("--- @Value Load ---");
        log.info("Username: {}", username);

        // 1-5) MyPropProperties 객체 주입 출력
        log.info("--- MyPropProperties Injection ---");
        log.info("Get Username: {}", myPropProperties.getUsername());
        log.info("Get Port: {}", myPropProperties.getPort());

        if (myEnvironment != null) {
            log.info("현재 환경 모드: {}", myEnvironment.getMode());
        }
    }
}