package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class RandomCodeResult extends BaseHttpResult {

    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"RandomCode":"4945"}}
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
         * Data : {"RandomCode":"4945"}
         */

        private String result_code;
        private String result_msg;
        private DataBean Data;

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

        public DataBean getData() {
            return Data;
        }

        public void setData(DataBean Data) {
            this.Data = Data;
        }

        public static class DataBean {
            /**
             * RandomCode : 4945
             */

            private String RandomCode;

            public String getRandomCode() {
                return RandomCode;
            }

            public void setRandomCode(String RandomCode) {
                this.RandomCode = RandomCode;
            }
        }
    }
}
