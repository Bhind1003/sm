package com.example.sm.controller;

import com.example.sm.model.Record;
import com.example.sm.service.RecordServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordServiceImp recordServiceImp;

    public RecordController(RecordServiceImp recordServiceImp) {
        this.recordServiceImp = recordServiceImp;
    }

    @PostMapping("/addRecord")
    public String addRecord(@RequestBody Record record) {
        try {
            return recordServiceImp.addRecord(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    @GetMapping("/listRecords")
    public List<Record> listRecord(@RequestParam(value = "num", defaultValue = "30") int num) {
        try {
            return recordServiceImp.listRecord(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
