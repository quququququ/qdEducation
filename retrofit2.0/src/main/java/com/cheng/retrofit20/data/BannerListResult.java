package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/22.
 */

public class BannerListResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"PicturePath":"banner\\20181121\\newsad2_acee686d-9c8a-4239-bb12-ca8bfd082d6e.gif","Code":"7ed25f42-3afe-4487-96e9-5705854dd83c","Name":"促销活动","Descprition":"促销活动","Url":"555","PictureCode":"acee686d-9c8a-4239-bb12-ca8bfd082d6e","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T15:02:02.6","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\c5fa03d2ly1frrh0hxgb8j20l10buq9r_a4298caf-2ae7-4210-bd03-1c5f3777255a.jpg","Code":"4f576b36-c642-4f54-86db-511b4ec12557","Name":"广告","Descprition":"广告","Url":"4444","PictureCode":"a4298caf-2ae7-4210-bd03-1c5f3777255a","BannerCategoryId":2,"Status":10,"CreateDate":"2018-11-21T15:01:31.253","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\338A415C6CD728E1BA0F442ED5DACA4E_52233e95-d7b3-46f2-86ea-9c0e55ddc2f7.jpg","Code":"9e44821a-7c01-42fc-a514-26ce5669854f","Name":"雅思词汇","Descprition":"雅思词汇","Url":"222","PictureCode":"52233e95-d7b3-46f2-86ea-9c0e55ddc2f7","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T14:53:24.857","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\人教 初中英语 七下 U1 Reading_8da422d6-857f-4ce8-adbe-928a1f03768a.png","Code":"4e1d99a6-92b2-4a19-bdba-78855de7e6ff","Name":"人教 初中英语 ","Descprition":"人教 初中英语","Url":"111","PictureCode":"8da422d6-857f-4ce8-adbe-928a1f03768a","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T14:51:52.627","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\1511317428_d738f9a5-19c0-429f-8f23-d95fc6646bc0.jpg","Code":"c1660923-76c4-4ff6-a483-f3e4e7c00327","Name":"面对面活动","Descprition":"面对面活动","Url":"333","PictureCode":"d738f9a5-19c0-429f-8f23-d95fc6646bc0","BannerCategoryId":2,"Status":10,"CreateDate":"2018-11-21T11:25:51.81","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true}]}
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
         * Data : [{"PicturePath":"banner\\20181121\\newsad2_acee686d-9c8a-4239-bb12-ca8bfd082d6e.gif","Code":"7ed25f42-3afe-4487-96e9-5705854dd83c","Name":"促销活动","Descprition":"促销活动","Url":"555","PictureCode":"acee686d-9c8a-4239-bb12-ca8bfd082d6e","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T15:02:02.6","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\c5fa03d2ly1frrh0hxgb8j20l10buq9r_a4298caf-2ae7-4210-bd03-1c5f3777255a.jpg","Code":"4f576b36-c642-4f54-86db-511b4ec12557","Name":"广告","Descprition":"广告","Url":"4444","PictureCode":"a4298caf-2ae7-4210-bd03-1c5f3777255a","BannerCategoryId":2,"Status":10,"CreateDate":"2018-11-21T15:01:31.253","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\338A415C6CD728E1BA0F442ED5DACA4E_52233e95-d7b3-46f2-86ea-9c0e55ddc2f7.jpg","Code":"9e44821a-7c01-42fc-a514-26ce5669854f","Name":"雅思词汇","Descprition":"雅思词汇","Url":"222","PictureCode":"52233e95-d7b3-46f2-86ea-9c0e55ddc2f7","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T14:53:24.857","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\人教 初中英语 七下 U1 Reading_8da422d6-857f-4ce8-adbe-928a1f03768a.png","Code":"4e1d99a6-92b2-4a19-bdba-78855de7e6ff","Name":"人教 初中英语 ","Descprition":"人教 初中英语","Url":"111","PictureCode":"8da422d6-857f-4ce8-adbe-928a1f03768a","BannerCategoryId":1,"Status":10,"CreateDate":"2018-11-21T14:51:52.627","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true},{"PicturePath":"banner\\20181121\\1511317428_d738f9a5-19c0-429f-8f23-d95fc6646bc0.jpg","Code":"c1660923-76c4-4ff6-a483-f3e4e7c00327","Name":"面对面活动","Descprition":"面对面活动","Url":"333","PictureCode":"d738f9a5-19c0-429f-8f23-d95fc6646bc0","BannerCategoryId":2,"Status":10,"CreateDate":"2018-11-21T11:25:51.81","SubmiterCode":"4e95aefa-d577-49e1-91b1-0db65d714151","IsActived":true}]
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
}
