package com.wxr.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxr.springcloud.pojo.Dept;
import com.wxr.springcloud.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;

    @PostMapping("/dept/add")
    //@HystrixCommand(fallbackMethod = "getFallBack")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    //@HystrixCommand(fallbackMethod = "getFallBack")
    public Dept queryById(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    //@HystrixCommand(fallbackMethod = "getFallBack")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

   /* public Dept getFallBack(@PathVariable("id") Long id){
        return new Dept().setDeptNo(id).setDName("没有对应的信息").setDb_source("没有对应的数据库信息!");
    }*/

}
