package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class RegisterResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"SessionKey":"","LoginUser":{"UserId":"4e95aefa-d577-49e1-91b1-0db65d714151","LoginName":"admin","Password":"","PhoneNumber":"111","DisplayName":"管理员","IsActive":true,"Sex":"f"}}}
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
         * Data : {"SessionKey":"","LoginUser":{"UserId":"4e95aefa-d577-49e1-91b1-0db65d714151","LoginName":"admin","Password":"","PhoneNumber":"111","DisplayName":"管理员","IsActive":true,"Sex":"f"}}
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
             * SessionKey :
             * LoginUser : {"UserId":"4e95aefa-d577-49e1-91b1-0db65d714151","LoginName":"admin","Password":"","PhoneNumber":"111","DisplayName":"管理员","IsActive":true,"Sex":"f"}
             */

            private String SessionKey;
            private LoginUserBean LoginUser;

            public String getSessionKey() {
                return SessionKey;
            }

            public void setSessionKey(String SessionKey) {
                this.SessionKey = SessionKey;
            }

            public LoginUserBean getLoginUser() {
                return LoginUser;
            }

            public void setLoginUser(LoginUserBean LoginUser) {
                this.LoginUser = LoginUser;
            }

            public static class LoginUserBean {
                /**
                 * UserId : 4e95aefa-d577-49e1-91b1-0db65d714151
                 * LoginName : admin
                 * Password :
                 * PhoneNumber : 111
                 * DisplayName : 管理员
                 * IsActive : true
                 * Sex : f
                 */

                private String UserId;
                private String LoginName;
                private String Password;
                private String PhoneNumber;
                private String DisplayName;
                private boolean IsActive;
                private String Sex;

                public String getUserId() {
                    return UserId;
                }

                public void setUserId(String UserId) {
                    this.UserId = UserId;
                }

                public String getLoginName() {
                    return LoginName;
                }

                public void setLoginName(String LoginName) {
                    this.LoginName = LoginName;
                }

                public String getPassword() {
                    return Password;
                }

                public void setPassword(String Password) {
                    this.Password = Password;
                }

                public String getPhoneNumber() {
                    return PhoneNumber;
                }

                public void setPhoneNumber(String PhoneNumber) {
                    this.PhoneNumber = PhoneNumber;
                }

                public String getDisplayName() {
                    return DisplayName;
                }

                public void setDisplayName(String DisplayName) {
                    this.DisplayName = DisplayName;
                }

                public boolean isIsActive() {
                    return IsActive;
                }

                public void setIsActive(boolean IsActive) {
                    this.IsActive = IsActive;
                }

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }
            }
        }
    }
}
