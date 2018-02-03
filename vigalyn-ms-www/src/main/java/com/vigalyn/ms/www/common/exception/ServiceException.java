package com.vigalyn.ms.www.common.exception;

/**
 * service异常
 * @author wind3
 *
 */
public class ServiceException extends BaseException {

    private static final long serialVersionUID = 4914358240764140837L;

    public ServiceException(String errorMsg) {  
        super(errorMsg);  
    }  
  
    public ServiceException(int errorCode, String errorMsg) {  
        super(errorCode, errorMsg);  
    }  
  
    public ServiceException(Throwable cause, int errorCode, String errorMsg,  
            String traceId) {  
        super(cause, errorCode, errorMsg, traceId);  
    }  
  
    public ServiceException(Throwable cause, int errorCode, String errorMsg) {  
        super(cause, errorCode, errorMsg);  
    }  
  
    public ServiceException(Throwable cause, String errorMsg) {  
        super(cause, errorMsg);  
    }  
  
    public ServiceException(Throwable cause) {  
        super(cause);  
    }  
}
