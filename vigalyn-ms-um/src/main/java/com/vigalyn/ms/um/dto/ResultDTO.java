package com.vigalyn.ms.um.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = -2420708289436691289L;
    private int resCode;
    private String resMsg;
    private T resData = null;
    
    public ResultDTO(){
        this.resCode = 0;
        this.resMsg = "操作成功！";
    }
    
    public ResultDTO(T obj){
        this.resCode = 0;
        this.resMsg = "操作成功！";
        this.resData = obj;
    }
    
    public ResultDTO(int resCode, String resMsg){
        this.resCode = resCode;
        this.resMsg = resMsg;
    }
}
