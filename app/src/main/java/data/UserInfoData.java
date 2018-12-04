package data;

/**
 * Created by qupengcheng on 2018/10/18.
 */

public class UserInfoData {
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
         * UserId : f78adaa4-9108-4a0b-a641-0081ccc1ada6
         * LoginName : shou003
         * Password :
         * DisplayName : grace
         * IsActived : true
         * Sex : f
         * PhoneNumber : 12345678901
         */

        private String UserId;
        private String LoginName;
        private String Password;
        private String DisplayName;
        private boolean IsActived;
        private String Sex;
        private String PhoneNumber;

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

        public String getDisplayName() {
            return DisplayName;
        }

        public void setDisplayName(String DisplayName) {
            this.DisplayName = DisplayName;
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

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public void setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
        }
    }
}
