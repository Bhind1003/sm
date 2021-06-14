package com.example.sm.service;

import com.example.sm.dao.recordsMapper;
import com.example.sm.dao.userMapper;
import com.example.sm.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImp implements recordService {
    private final recordsMapper recordsMapper;
    private final userMapper userMapper;

    public RecordServiceImp(recordsMapper recordsMapper, userMapper userMapper) {
        this.recordsMapper = recordsMapper;
        this.userMapper = userMapper;
    }

    @Override
    public String addRecord(Record record) throws Exception {
        String ans = null;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd=hh:mm:ss");
        try {
            ans = String.valueOf(recordsMapper.record(ft.format(new Date()), record.getEmail(),
                    userMapper.FindUserName(record.getEmail()), record.getScore()));
            if (ans.compareTo("1") == 0) {
                System.out.println("插入记录的行数" + ans + ":" + record);
            } else {
                ans = "0";//插入失败返回0无法插入
            }
        } catch (Exception e) {
            e.printStackTrace();
            ans = "-1";
        } finally {
            System.out.println("Service:RecordServiceImp->addRecord");
        }
        return ans;
    }

    @Override
    public List<Record> listRecord(int num) throws Exception {
        try {
            return recordsMapper.listRecords(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Service:RecordServiceImp->listRecord");
        }
        return null;
    }
}
