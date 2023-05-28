package com.wxr.springcloud.service;

import com.wxr.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptNo(id).setDName("没有对应的信息").setDb_source("没有对应的数据库信息");
            }

            @Override
            public List<Dept> queryAll() {
                List<Dept> list = new ArrayList<>();
                Dept dept = new Dept().setDeptNo(0).setDName("没有对应的信息").setDb_source("没有对应的数据库信息，数据库表中信息为空！");
                list.add(dept);
                return list;
            }
        };
    }
}
