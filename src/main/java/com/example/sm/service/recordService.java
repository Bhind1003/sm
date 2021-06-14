package com.example.sm.service;

import com.example.sm.model.Record;

import java.util.List;

public interface recordService {
    String addRecord(Record record)throws Exception;
    List<Record> listRecord(int num)throws Exception;
}
