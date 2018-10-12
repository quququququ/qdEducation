package com.cheng.retrofit20.client;

import java.io.Serializable;

/**
 * Created by wumengmeng on 2016/7/16/0016.
 */
public class BaseHttpResult implements Serializable {
    private String return_code;
    private String return_msg;

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }


    @Override
    public String toString() {
        return "BaseHttpResult{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                '}';
    }
}
