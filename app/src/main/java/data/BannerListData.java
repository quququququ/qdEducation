package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/22.
 */

public class BannerListData {
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
         * PicturePath : banner\20181121\newsad2_acee686d-9c8a-4239-bb12-ca8bfd082d6e.gif
         * Code : 7ed25f42-3afe-4487-96e9-5705854dd83c
         * Name : 促销活动
         * Descprition : 促销活动
         * Url : 555
         * PictureCode : acee686d-9c8a-4239-bb12-ca8bfd082d6e
         * BannerCategoryId : 1
         * Status : 10
         * CreateDate : 2018-11-21T15:02:02.6
         * SubmiterCode : 4e95aefa-d577-49e1-91b1-0db65d714151
         * IsActived : true
         */

        private String PicturePath;
        private String Code;
        private String Name;
        private String Descprition;
        private String Url;
        private String PictureCode;
        private int BannerCategoryId;
        private int Status;
        private String CreateDate;
        private String SubmiterCode;
        private boolean IsActived;

        public String getPicturePath() {
            return PicturePath;
        }

        public void setPicturePath(String PicturePath) {
            this.PicturePath = PicturePath;
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getDescprition() {
            return Descprition;
        }

        public void setDescprition(String Descprition) {
            this.Descprition = Descprition;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getPictureCode() {
            return PictureCode;
        }

        public void setPictureCode(String PictureCode) {
            this.PictureCode = PictureCode;
        }

        public int getBannerCategoryId() {
            return BannerCategoryId;
        }

        public void setBannerCategoryId(int BannerCategoryId) {
            this.BannerCategoryId = BannerCategoryId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getSubmiterCode() {
            return SubmiterCode;
        }

        public void setSubmiterCode(String SubmiterCode) {
            this.SubmiterCode = SubmiterCode;
        }

        public boolean isIsActived() {
            return IsActived;
        }

        public void setIsActived(boolean IsActived) {
            this.IsActived = IsActived;
        }
    }
}
