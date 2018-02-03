package com.vigalyn.ms.www.common.exception;

/**
 * mapper映射异常
 * @author wind3
 *
 */
public class MapperException extends BaseException {

    private static final long serialVersionUID = 4914358240764140837L;

    public MapperException(String errorMsg) {  
        super(errorMsg);  
    }  
  
    public MapperException(int errorCode, String errorMsg) {  
        super(errorCode, errorMsg);  
    }  
  
    public MapperException(Throwable cause, int errorCode, String errorMsg,  
            String traceId) {  
        super(cause, errorCode, errorMsg, traceId);  
    }  
  
    public MapperException(Throwable cause, int errorCode, String errorMsg) {  
        super(cause, errorCode, errorMsg);  
    }  
  
    public MapperException(Throwable cause, String errorMsg) {  
        super(cause, errorMsg);  
    }  
  
    public MapperException(Throwable cause) {  
        super(cause);  
    }  
}
