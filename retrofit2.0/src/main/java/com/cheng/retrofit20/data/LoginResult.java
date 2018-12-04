package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

/**
 * Created by qupengcheng on 2018/11/22.
 */

public class LoginResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"SessionKey":"9fe1b7a93f07e4f41a82c9d8131d5a51","LogonUser":{"UserId":"07258030-cc81-4ed2-b199-c64f9a6f46e1","LoginName":"quququququ","Password":"","PhoneNumber":"17602192840","DisplayName":"","Sex":"f","IsActive":true}}}
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
         * Data : {"SessionKey":"9fe1b7a93f07e4f41a82c9d8131d5a51","LogonUser":{"UserId":"07258030-cc81-4ed2-b199-c64f9a6f46e1","LoginName":"quququququ","Password":"","PhoneNumber":"17602192840","DisplayName":"","Sex":"f","IsActive":true}}
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
             * SessionKey : 9fe1b7a93f07e4f41a82c9d8131d5a51
             * LogonUser : {"UserId":"07258030-cc81-4ed2-b199-c64f9a6f46e1","LoginName":"quququququ","Password":"","PhoneNumber":"17602192840","DisplayName":"","Sex":"f","IsActive":true}
             */

            private String SessionKey;
            private LogonUserBean LogonUser;

            public String getSessionKey() {
                return SessionKey;
            }

            public void setSessionKey(String SessionKey) {
                this.SessionKey = SessionKey;
            }

            public LogonUserBean getLogonUser() {
                return LogonUser;
            }

            public void setLogonUser(LogonUserBean LogonUser) {
                this.LogonUser = LogonUser;
            }

            public static class LogonUserBean {
                /**
                 * UserId : 07258030-cc81-4ed2-b199-c64f9a6f46e1
                 * LoginName : quququququ
                 * Password :
                 * PhoneNumber : 17602192840
                 * DisplayName :
                 * Sex : f
                 * IsActive : true
                 */

                private String UserId;
                private String LoginName;
                private String Password;
                private String PhoneNumber;
                private String DisplayName;
                private String Sex;
                private boolean IsActive;

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

                public String getSex() {
                    return Sex;
                }

                public void setSex(String Sex) {
                    this.Sex = Sex;
                }

                public boolean isIsActive() {
                    return IsActive;
                }

                public void setIsActive(boolean IsActive) {
                    this.IsActive = IsActive;
                }
            }
        }
    }
}
