package com.cheng.retrofit20.http;

import com.cheng.retrofit20.client.BaseHttpResult;

/**
 * Created by qupengcheng on 2018/10/28.
 */

public class CancelOrderResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"Flag":true,"Msg":"已取消!"}}
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
         * Data : {"Flag":true,"Msg":"已取消!"}
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
             * Flag : true
             * Msg : 已取消!
             */

            private boolean Flag;
            private String Msg;

            public boolean isFlag() {
                return Flag;
            }

            public void setFlag(boolean Flag) {
                this.Flag = Flag;
            }

            public String getMsg() {
                return Msg;
            }

            public void setMsg(String Msg) {
                this.Msg = Msg;
            }
        }
    }
}
