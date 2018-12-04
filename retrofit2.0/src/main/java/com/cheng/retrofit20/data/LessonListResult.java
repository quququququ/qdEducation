package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/28.
 */

public class LessonListResult extends BaseHttpResult {

    /**
     * BaseResponseResult : {"result_code":null,"result_msg":"","Data":[{"Code":"6c7aaa1d-a6df-479e-883f-1b917a8e1678","Name":"213","No":"12331","Level":0,"LessonHour":31,"AbilityItemCode":68,"InstructionalOBJ":"12313","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"00000000-0000-0000-0000-000000000000","CreateDate":"2018-06-05T14:25:47.203"},{"Code":"86d2ac66-43fe-45ac-a0fc-27640429f06e","Name":"4234234","No":"r2432","Level":0,"LessonHour":0,"AbilityItemCode":68,"InstructionalOBJ":"2342342","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"00000000-0000-0000-0000-000000000000","CreateDate":"2018-06-05T14:30:32.383"},{"Code":"07f94ca0-92ac-42bf-be99-2c8ec3741182","Name":"11111111111111111111","No":"1","Level":0,"LessonHour":0,"AbilityItemCode":68,"InstructionalOBJ":"1","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"941a7d32-9da6-40ee-9248-c3c14f961a73","CreateDate":"2018-06-11T15:30:24.03"}]}
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
         * result_code : null
         * result_msg :
         * Data : [{"Code":"6c7aaa1d-a6df-479e-883f-1b917a8e1678","Name":"213","No":"12331","Level":0,"LessonHour":31,"AbilityItemCode":68,"InstructionalOBJ":"12313","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"00000000-0000-0000-0000-000000000000","CreateDate":"2018-06-05T14:25:47.203"},{"Code":"86d2ac66-43fe-45ac-a0fc-27640429f06e","Name":"4234234","No":"r2432","Level":0,"LessonHour":0,"AbilityItemCode":68,"InstructionalOBJ":"2342342","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"00000000-0000-0000-0000-000000000000","CreateDate":"2018-06-05T14:30:32.383"},{"Code":"07f94ca0-92ac-42bf-be99-2c8ec3741182","Name":"11111111111111111111","No":"1","Level":0,"LessonHour":0,"AbilityItemCode":68,"InstructionalOBJ":"1","Remark":null,"CategoryCode":1,"CategoryName":"雅思1","AbilityItemName":"听力","PictureCode":"941a7d32-9da6-40ee-9248-c3c14f961a73","CreateDate":"2018-06-11T15:30:24.03"}]
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
             * Code : 6c7aaa1d-a6df-479e-883f-1b917a8e1678
             * Name : 213
             * No : 12331
             * Level : 0
             * LessonHour : 31
             * AbilityItemCode : 68
             * InstructionalOBJ : 12313
             * Remark : null
             * CategoryCode : 1
             * CategoryName : 雅思1
             * AbilityItemName : 听力
             * PictureCode : 00000000-0000-0000-0000-000000000000
             * CreateDate : 2018-06-05T14:25:47.203
             */

            private String Code;
            private String Name;
            private String No;
            private int Level;
            private int LessonHour;
            private int AbilityItemCode;
            private String InstructionalOBJ;
            private String Remark;
            private int CategoryCode;
            private String CategoryName;
            private String AbilityItemName;
            private String PictureCode;
            private String CreateDate;
            private String PicturePath;

            public String getPicturePath() {
                return PicturePath;
            }

            public void setPicturePath(String picturePath) {
                PicturePath = picturePath;
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

            public String getNo() {
                return No;
            }

            public void setNo(String No) {
                this.No = No;
            }

            public int getLevel() {
                return Level;
            }

            public void setLevel(int Level) {
                this.Level = Level;
            }

            public int getLessonHour() {
                return LessonHour;
            }

            public void setLessonHour(int LessonHour) {
                this.LessonHour = LessonHour;
            }

            public int getAbilityItemCode() {
                return AbilityItemCode;
            }

            public void setAbilityItemCode(int AbilityItemCode) {
                this.AbilityItemCode = AbilityItemCode;
            }

            public String getInstructionalOBJ() {
                return InstructionalOBJ;
            }

            public void setInstructionalOBJ(String InstructionalOBJ) {
                this.InstructionalOBJ = InstructionalOBJ;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
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

            public String getAbilityItemName() {
                return AbilityItemName;
            }

            public void setAbilityItemName(String AbilityItemName) {
                this.AbilityItemName = AbilityItemName;
            }

            public String getPictureCode() {
                return PictureCode;
            }

            public void setPictureCode(String PictureCode) {
                this.PictureCode = PictureCode;
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
