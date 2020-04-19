package dev.urosht.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    private List<LocalDateTime> helloList;

    public HelloService() {
        this.helloList = new ArrayList<>();
    }

    public String hello() {
        final LocalDateTime helloTime = LocalDateTime.now();
        helloList.add(helloTime);
        final String result = "Hello at " + helloTime.toString();
        return result;
    }

    public int count() {
        return helloList.size();
    }
}
