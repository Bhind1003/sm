package com.example.sm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record {
    private String time;
    private String email;
    private String name;
    private String score;
}
