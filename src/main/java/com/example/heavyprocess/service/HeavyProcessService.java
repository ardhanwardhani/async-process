package com.example.heavyprocess.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class HeavyProcessService {

    private ConcurrentMap<String, String> processStatus = new ConcurrentHashMap<>();

    @Async
    public void executeHeavyProcess(String processId){
        processStatus.put(processId, "In Progress");
        try {
            Thread.sleep(300000);
            processStatus.put(processId, "Completed");
        }catch (InterruptedException e){
            processStatus.put(processId, "Failed");
        }
    }

    public String getStatus(String processId){
        return processStatus.getOrDefault(processId, "Process not found");
    }
}
