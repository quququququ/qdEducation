package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

/**
 * Created by qupengcheng on 2018/10/15.
 */

public class RegisterResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"Code":"07258030-cc81-4ed2-b199-c64f9a6f46e1","UserName":"quququququ","NickName":"","UserType":0,"Password":"","IsActived":true,"Sex":"f","Age":0,"PhoneNumber":"17602192840","Remark":null,"CreateBy":"android client","CreateDate":"0001-01-01T00:00:00","ModifyBy":null,"ModifyDate":"0001-01-01T00:00:00"}}
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
         * Data : {"Code":"07258030-cc81-4ed2-b199-c64f9a6f46e1","UserName":"quququququ","NickName":"","UserType":0,"Password":"","IsActived":true,"Sex":"f","Age":0,"PhoneNumber":"17602192840","Remark":null,"CreateBy":"android client","CreateDate":"0001-01-01T00:00:00","ModifyBy":null,"ModifyDate":"0001-01-01T00:00:00"}
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
             * Code : 07258030-cc81-4ed2-b199-c64f9a6f46e1
             * UserName : quququququ
             * NickName :
             * UserType : 0
             * Password :
             * IsActived : true
             * Sex : f
             * Age : 0
             * PhoneNumber : 17602192840
             * Remark : null
             * CreateBy : android client
             * CreateDate : 0001-01-01T00:00:00
             * ModifyBy : null
             * ModifyDate : 0001-01-01T00:00:00
             */

            private String Code;
            private String UserName;
            private String NickName;
            private int UserType;
            private String Password;
            private boolean IsActived;
            private String Sex;
            private int Age;
            private String PhoneNumber;
            private Object Remark;
            private String CreateBy;
            private String CreateDate;
            private Object ModifyBy;
            private String ModifyDate;

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String NickName) {
                this.NickName = NickName;
            }

            public int getUserType() {
                return UserType;
            }

            public void setUserType(int UserType) {
                this.UserType = UserType;
            }

            public String getPassword() {
                return Password;
            }

            public void setPassword(String Password) {
                this.Password = Password;
            }

            public boolean isIsActived() {
                return IsActived;
            }

            public void setIsActived(boolean IsActived) {
                this.IsActived = IsActived;
            }

            public String getSex() {
                return Sex;
            }

            public void setSex(String Sex) {
                this.Sex = Sex;
            }

            public int getAge() {
                return Age;
            }

            public void setAge(int Age) {
                this.Age = Age;
            }

            public String getPhoneNumber() {
                return PhoneNumber;
            }

            public void setPhoneNumber(String PhoneNumber) {
                this.PhoneNumber = PhoneNumber;
            }

            public Object getRemark() {
                return Remark;
            }

            public void setRemark(Object Remark) {
                this.Remark = Remark;
            }

            public String getCreateBy() {
                return CreateBy;
            }

            public void setCreateBy(String CreateBy) {
                this.CreateBy = CreateBy;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public Object getModifyBy() {
                return ModifyBy;
            }

            public void setModifyBy(Object ModifyBy) {
                this.ModifyBy = ModifyBy;
            }

            public String getModifyDate() {
                return ModifyDate;
            }

            public void setModifyDate(String ModifyDate) {
                this.ModifyDate = ModifyDate;
            }
        }
    }
}
