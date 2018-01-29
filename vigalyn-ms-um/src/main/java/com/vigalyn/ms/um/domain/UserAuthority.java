package com.vigalyn.ms.um.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAuthority implements Serializable{
    
    private static final long serialVersionUID = 1246894676322658839L;
    private String userId;
}
