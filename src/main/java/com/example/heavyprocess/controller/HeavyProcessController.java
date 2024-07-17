package com.example.heavyprocess.controller;

import com.example.heavyprocess.service.HeavyProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HeavyProcessController {
    @Autowired
    private HeavyProcessService heavyProcessService;

    @GetMapping("/start-process")
    public String startProcess(){
        String processId = "process_" + System.currentTimeMillis();
        heavyProcessService.executeHeavyProcess(processId);
        return "Process started with ID: " + processId;
    }

    @GetMapping("/check-status")
    public String checkStatus(@RequestParam String processId){
        return heavyProcessService.getStatus(processId);
    }
}
