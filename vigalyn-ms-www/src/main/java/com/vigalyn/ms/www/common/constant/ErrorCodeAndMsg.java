package com.vigalyn.ms.www.common.constant;

/**
 * 错误代码和错误提示
 * @author wind3
 *
 */
public enum ErrorCodeAndMsg {
    
    /**
     * 1--199
     * 系统异常
     */
    SYS_ERR(-1,"系统异常"),
    
    /**
     * 101--299
     * service异常
     */
    BUILD_EMAIL_ERR(-101,"邮件参数设置异常"),
    SEND_EMAIL_ERR(-102,"邮件发送异常");
    
  
    private int errCode;
    private String errMsg;
    
    ErrorCodeAndMsg(int errCode,String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    public int getErrCode() {
        return this.errCode;
    }
    public String getErrMsg() {
        return this.errMsg;
    }
}
