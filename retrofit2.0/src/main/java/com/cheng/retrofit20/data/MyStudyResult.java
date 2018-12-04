package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/15.
 */

public class MyStudyResult extends BaseHttpResult {

    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"UserCode":"4e95aefa-d577-49e1-91b1-0db65d714151","NickName":"管理员","LessonCode":"d381dc76-ef43-41c7-893f-677679a4cbea","Name":"雅思语法","No":"11","PictureCode":"47f74663-f910-4ee3-a15e-c6be06d0b180","PicturePath":"lesson\\20181113\\4BE6617BDCE200E311976FA3A1391DA2_47f74663-f910-4ee3-a15e-c6be06d0b180.jpg","TotalVideoAmount":30,"PlayedVideoAmount":1,"TotalVideoLength":240,"PlayedVideoLength":1,"LastStudyTime":"2018-10-24T13:36:45.293"}]}
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
         * Data : [{"UserCode":"4e95aefa-d577-49e1-91b1-0db65d714151","NickName":"管理员","LessonCode":"d381dc76-ef43-41c7-893f-677679a4cbea","Name":"雅思语法","No":"11","PictureCode":"47f74663-f910-4ee3-a15e-c6be06d0b180","PicturePath":"lesson\\20181113\\4BE6617BDCE200E311976FA3A1391DA2_47f74663-f910-4ee3-a15e-c6be06d0b180.jpg","TotalVideoAmount":30,"PlayedVideoAmount":1,"TotalVideoLength":240,"PlayedVideoLength":1,"LastStudyTime":"2018-10-24T13:36:45.293"}]
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
             * UserCode : 4e95aefa-d577-49e1-91b1-0db65d714151
             * NickName : 管理员
             * LessonCode : d381dc76-ef43-41c7-893f-677679a4cbea
             * Name : 雅思语法
             * No : 11
             * PictureCode : 47f74663-f910-4ee3-a15e-c6be06d0b180
             * PicturePath : lesson\20181113\4BE6617BDCE200E311976FA3A1391DA2_47f74663-f910-4ee3-a15e-c6be06d0b180.jpg
             * TotalVideoAmount : 30
             * PlayedVideoAmount : 1
             * TotalVideoLength : 240
             * PlayedVideoLength : 1
             * LastStudyTime : 2018-10-24T13:36:45.293
             */

            private String UserCode;
            private String NickName;
            private String LessonCode;
            private String Name;
            private String No;
            private String PictureCode;
            private String PicturePath;
            private int TotalVideoAmount;
            private int PlayedVideoAmount;
            private int TotalVideoLength;
            private int PlayedVideoLength;
            private String LastStudyTime;

            public String getUserCode() {
                return UserCode;
            }

            public void setUserCode(String UserCode) {
                this.UserCode = UserCode;
            }

            public String getNickName() {
                return NickName;
            }

            public void setNickName(String NickName) {
                this.NickName = NickName;
            }

            public String getLessonCode() {
                return LessonCode;
            }

            public void setLessonCode(String LessonCode) {
                this.LessonCode = LessonCode;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getNo() {
                return No;
            }

            public void setNo(String No) {
                this.No = No;
            }

            public String getPictureCode() {
                return PictureCode;
            }

            public void setPictureCode(String PictureCode) {
                this.PictureCode = PictureCode;
            }

            public String getPicturePath() {
                return PicturePath;
            }

            public void setPicturePath(String PicturePath) {
                this.PicturePath = PicturePath;
            }

            public int getTotalVideoAmount() {
                return TotalVideoAmount;
            }

            public void setTotalVideoAmount(int TotalVideoAmount) {
                this.TotalVideoAmount = TotalVideoAmount;
            }

            public int getPlayedVideoAmount() {
                return PlayedVideoAmount;
            }

            public void setPlayedVideoAmount(int PlayedVideoAmount) {
                this.PlayedVideoAmount = PlayedVideoAmount;
            }

            public int getTotalVideoLength() {
                return TotalVideoLength;
            }

            public void setTotalVideoLength(int TotalVideoLength) {
                this.TotalVideoLength = TotalVideoLength;
            }

            public int getPlayedVideoLength() {
                return PlayedVideoLength;
            }

            public void setPlayedVideoLength(int PlayedVideoLength) {
                this.PlayedVideoLength = PlayedVideoLength;
            }

            public String getLastStudyTime() {
                return LastStudyTime;
            }

            public void setLastStudyTime(String LastStudyTime) {
                this.LastStudyTime = LastStudyTime;
            }
        }
    }
}
