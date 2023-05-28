package com.wxr.springcloud.service;

import com.wxr.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    Dept queryById(Long id);
    List<Dept> queryAll();
    boolean addDept(Dept dept);
}
