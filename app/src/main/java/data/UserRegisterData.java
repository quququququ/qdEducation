package data;


/**
 * Created by qupengcheng on 2018/10/16.
 */

public class UserRegisterData {
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

    public void setData(DataBean data) {
        Data = data;
    }


    public static class DataBean {

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

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getLoginName() {
            return LoginName;
        }

        public void setLoginName(String loginName) {
            LoginName = loginName;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            PhoneNumber = phoneNumber;
        }

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String displayName) {
            DisplayName = displayName;
        }

        public boolean isActive() {
            return IsActive;
        }

        public void setActive(boolean active) {
            IsActive = active;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String sex) {
            Sex = sex;
        }
    }


}
