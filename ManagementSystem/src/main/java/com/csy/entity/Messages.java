package com.csy.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Messages {
    //编号
    private int id;
    //身份标识
    private int content;
    //内容
    private int sender_id;
    //阅读状态
    private int receiver_id;
    //时间戳
    private Timestamp timestamp;
}
