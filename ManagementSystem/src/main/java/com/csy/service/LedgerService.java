package com.csy.service;

import com.csy.utils.Result;

import java.sql.Date;
import java.util.List;

public interface LedgerService {


    Result shipOut(int id, String specification, int sid,int type);

    Result queryjilu(List<Integer> ids, Date date, int page, int limit);
}
