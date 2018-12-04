package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/10.
 */

public class AbilityItemListResult extends BaseHttpResult {

    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"Code":68,"Name":"听力"},{"Code":69,"Name":"口语"},{"Code":70,"Name":"阅读"},{"Code":71,"Name":"写作"},{"Code":80,"Name":"语法"}]}
     */

    private BaseResponseResultBean BaseResponseResult;

    public BaseResponseResultBean getBaseResponseResult() {
        return BaseResponseResult;
    }

    public void setBaseResponseResult(BaseResponseResultBean BaseResponseResult) {
        this.BaseResponseResult = BaseResponseResult;
    }

    public static class BaseResponseResultBean {
        /**
         * result_code : SUCCESS
         * result_msg :
         * Data : [{"Code":68,"Name":"听力"},{"Code":69,"Name":"口语"},{"Code":70,"Name":"阅读"},{"Code":71,"Name":"写作"},{"Code":80,"Name":"语法"}]
         */

        private String result_code;
        private String result_msg;
        private List<DataBean> Data;

        public String getResult_code() {
            return result_code;
        }

        public void setResult_code(String result_code) {
            this.result_code = result_code;
        }

        public String getResult_msg() {
            return result_msg;
        }

        public void setResult_msg(String result_msg) {
            this.result_msg = result_msg;
        }

        public List<DataBean> getData() {
            return Data;
        }

        public void setData(List<DataBean> Data) {
            this.Data = Data;
        }

        public static class DataBean {
            /**
             * Code : 68
             * Name : 听力
             */

            private int Code;
            private String Name;

            public int getCode() {
                return Code;
            }

            public void setCode(int Code) {
                this.Code = Code;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }
}
