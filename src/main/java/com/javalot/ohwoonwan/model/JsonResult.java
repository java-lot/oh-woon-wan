package com.javalot.ohwoonwan.model;


/**
 * @Description:
 * 				200：Success
 * 				500：Server Error
 * @author hazel
 */

public class JsonResult {

    //Response Status
    private final Integer status;
    //Message
    private final String message;
    //Response data
    private final Object data;


    public JsonResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.message = "OK";
        this.data = data;
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }


    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }


}
