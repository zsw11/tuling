package com.zsw.spring.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author zsw
 * @date 2022/1/17 15:38
 * @Company: 广州市两棵树网络科技有限公司
 */
@Data
@Component
public class user {
    private Integer id;
    private String name;

    public user() {
        System.out.println("执行了构造方法");
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
