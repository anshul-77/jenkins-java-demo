package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InfoController {

    @Value("${app.version:dev}")
    private String appVersion;

    @Value("${app.commit:local}")
    private String appCommit;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/version")
    public Map<String, Object> version() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("status", "UP");
        m.put("version", appVersion);
        m.put("commit", appCommit);
        m.put("time", Instant.now().toString());
        return m;
    }
}
