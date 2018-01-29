package com.vigalyn.ms.www.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 8792388176193675343L;
    
    private int resCode;
    private String resMsg;
    private T resData;
    
    public ResultDTO() {
        this(0,"操作成功",null);
    }

    public ResultDTO(int resCode, String resMsg) {
        this(resCode,resMsg,null);       
    }
    
    public ResultDTO(T resData) {
        this(0,"操作成功",resData);
    }
    
    public ResultDTO(int resCode, String resMsg,T resData) {
        this.resCode = resCode;
        this.resMsg = resMsg;  
        this.resData = resData;
    }

}
