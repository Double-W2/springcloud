package com.wxr.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data//set get
@NoArgsConstructor//空参构造
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private long deptNo;
    private String dName;
    private String db_source;

    public Dept(String dName) {
        this.dName = dName;
    }
}
