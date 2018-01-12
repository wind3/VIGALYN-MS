package com.vigalyn.hello.domain;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1096447457123783127L;
    
    private String name;
    private int age;
    
    public User() {
    }
 
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {        
        return "{ name = " + this.name +", age = " + this.age;
    }

}
