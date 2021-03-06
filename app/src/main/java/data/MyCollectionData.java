package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionData {
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

    public void setData(List<DataBean> data) {
        Data = data;
    }

    public static class DataBean {
        /**
         * DocumentCode :
         * DocumentType : 2
         * Title : 我是文章
         * Picture : 我是文章
         * Remark : null
         * AbilityItemCode : 80
         * AbilityItemName : 语法
         * CategoryCode : 1
         * CategoryName : yasi
         * Level : 1
         * Price : 10.7
         */

        private String DocumentCode;
        private int DocumentType;
        private String Title;
        private String Picture;
        private Object Remark;
        private int AbilityItemCode;
        private String AbilityItemName;
        private int CategoryCode;
        private String CategoryName;
        private int Level;
        private double Price;
        private int type;
        private String Summary;
        private String PicturePath;

        public String getPicturePath() {
            return PicturePath;
        }

        public void setPicturePath(String picturePath) {
            PicturePath = picturePath;
        }

        public String getSummary() {
            return Summary;
        }

        public void setSummary(String summary) {
            Summary = summary;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getDocumentCode() {
            return DocumentCode;
        }

        public void setDocumentCode(String DocumentCode) {
            this.DocumentCode = DocumentCode;
        }

        public int getDocumentType() {
            return DocumentType;
        }

        public void setDocumentType(int DocumentType) {
            this.DocumentType = DocumentType;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getPicture() {
            return Picture;
        }

        public void setPicture(String Picture) {
            this.Picture = Picture;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }

        public int getAbilityItemCode() {
            return AbilityItemCode;
        }

        public void setAbilityItemCode(int AbilityItemCode) {
            this.AbilityItemCode = AbilityItemCode;
        }

        public String getAbilityItemName() {
            return AbilityItemName;
        }

        public void setAbilityItemName(String AbilityItemName) {
            this.AbilityItemName = AbilityItemName;
        }

        public int getCategoryCode() {
            return CategoryCode;
        }

        public void setCategoryCode(int CategoryCode) {
            this.CategoryCode = CategoryCode;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public int getLevel() {
            return Level;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double Price) {
            this.Price = Price;
        }
    }

}
