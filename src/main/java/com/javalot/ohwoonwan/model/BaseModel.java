package com.javalot.ohwoonwan.model;

import lombok.Data;

/**
 * @author hazel
 */
@Data
public class BaseModel {

    private int status = 200;
    private String code = "0";
    private String message = "OK";
}
