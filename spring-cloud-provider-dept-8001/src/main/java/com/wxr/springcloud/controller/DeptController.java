package com.wxr.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxr.springcloud.pojo.Dept;
import com.wxr.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Resource
    private DeptService deptService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    //@HystrixCommand(fallbackMethod = "getFallBack")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    //@HystrixCommand(fallbackMethod = "getFallBack")
    public Dept queryById(@PathVariable Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("不存在该用户，信息无法找到");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    //@HystrixCommand(fallbackMethod = "getFallback")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }


    /*注册进来的微服务，获取一些消息   属于扩展  不用掌握*/
    @GetMapping("/dept/discovery")
    public Object discovery(){
        /*获取微服务列表的清单集合，微服务id*/
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        //遍历微服务清单
        for (String service : services) {
            /*通过微服务id，获取获取具体的微服务信息*/
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getHost()+instance.getInstanceId()+instance.getServiceId()+instance.getPort()+instance.getUri());
            }
        }
        return this.discoveryClient;
    }

    /*服务熔断后的反馈方法*/
  /*  public Dept getFallBack(@PathVariable("id") Long id){
        return new Dept().setDeptNo(id).setDName("没有对应的信息").setDb_source("没有对应的数据库信息!");
    }*/

}
