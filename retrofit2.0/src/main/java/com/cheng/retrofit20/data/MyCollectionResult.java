package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/11.
 */

public class MyCollectionResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"DocumentCode":"541a2312-aa5e-49ed-af36-fa4b3e7d0e4c","DocumentType":1,"Title":"THE LITTLE ICE AGE","Summary":"我是文章概述。","Picture":null,"Remark":null,"AbilityItemCode":0,"AbilityItemName":null,"CategoryCode":0,"CategoryName":null,"Level":1,"Price":10.699999809265137,"CreateDate":"2018-10-09T13:48:32.34"},{"DocumentCode":"e737109c-81de-4a6d-bf7d-58443cea2e00","DocumentType":1,"Title":"阅读理解第一篇","Summary":"当我还很小的时候","Picture":null,"Remark":null,"AbilityItemCode":0,"AbilityItemName":null,"CategoryCode":0,"CategoryName":null,"Level":1,"Price":0,"CreateDate":"2018-10-09T13:57:15.713"}]}
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
         * Data : [{"DocumentCode":"541a2312-aa5e-49ed-af36-fa4b3e7d0e4c","DocumentType":1,"Title":"THE LITTLE ICE AGE","Summary":"我是文章概述。","Picture":null,"Remark":null,"AbilityItemCode":0,"AbilityItemName":null,"CategoryCode":0,"CategoryName":null,"Level":1,"Price":10.699999809265137,"CreateDate":"2018-10-09T13:48:32.34"},{"DocumentCode":"e737109c-81de-4a6d-bf7d-58443cea2e00","DocumentType":1,"Title":"阅读理解第一篇","Summary":"当我还很小的时候","Picture":null,"Remark":null,"AbilityItemCode":0,"AbilityItemName":null,"CategoryCode":0,"CategoryName":null,"Level":1,"Price":0,"CreateDate":"2018-10-09T13:57:15.713"}]
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
             * DocumentCode : 541a2312-aa5e-49ed-af36-fa4b3e7d0e4c
             * DocumentType : 1
             * Title : THE LITTLE ICE AGE
             * Summary : 我是文章概述。
             * Picture : null
             * Remark : null
             * AbilityItemCode : 0
             * AbilityItemName : null
             * CategoryCode : 0
             * CategoryName : null
             * Level : 1
             * Price : 10.699999809265137
             * CreateDate : 2018-10-09T13:48:32.34
             */

            private String DocumentCode;
            private int DocumentType;
            private String Title;
            private String Summary;
            private String Picture;
            private String Remark;
            private int AbilityItemCode;
            private String AbilityItemName;
            private int CategoryCode;
            private String CategoryName;
            private int Level;
            private double Price;
            private String CreateDate;
            private String PicturePath;

            public String getPicturePath() {
                return PicturePath;
            }

            public void setPicturePath(String picturePath) {
                PicturePath = picturePath;
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

            public String getSummary() {
                return Summary;
            }

            public void setSummary(String Summary) {
                this.Summary = Summary;
            }

            public String getPicture() {
                return Picture;
            }

            public void setPicture(String Picture) {
                this.Picture = Picture;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
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

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }
        }
    }
}
