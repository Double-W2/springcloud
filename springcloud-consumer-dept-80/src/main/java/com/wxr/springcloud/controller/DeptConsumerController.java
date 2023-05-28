package com.wxr.springcloud.controller;

import com.wxr.springcloud.pojo.Dept;
import com.wxr.springcloud.service.DeptClientService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptConsumerController {

    /*这里是使用原生ribbon restTemplate调用*/

   /* @Resource//RestTemplate 注册到spring中,直接使用即可
    private RestTemplate restTemplate;

    //ribbon  地址应该是变量，通过服务名来访问
    //private static final String url = "http://127.0.0.1:8001";
    private static final String url = "http://SPRINGCLOUD-PROVIDER-DEPT";*/

    /*@RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(url+"/dept/add",dept,boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/get/list")
    public List<Dept> queryAll(){
        return restTemplate.getForObject(url+"/dept/list",List.class);
    }*/

    /*下面是使用feign*/
    @Resource
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id){
        return deptClientService.queryById(id);
    }
    @RequestMapping("/consumer/dept/get/list")
    public List<Dept> queryAll(){
        return deptClientService.queryAll();
    }
}
