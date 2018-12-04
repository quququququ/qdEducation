package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/28.
 */

public class MyLessonListResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"Code":"e0740ad1-358f-441a-9083-04ded3c262e4","Name":"测试课程3人教 初中英语 七下 U3 Reading","No":"19.3","Level":3,"LessonHour":1,"AbilityItemCode":70,"InstructionalOBJ":"\"1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕\u201c交通\u201d的话题展开讨论\"","Remark":null,"CategoryCode":3,"CategoryName":"阅读","AbilityItemName":"阅读","Price":1,"PictureCode":"e11bdc0b-9bfb-4a2b-9e36-871c76e19edf","CreateDate":"2018-11-08T17:55:34.787","PicturePath":"lesson\\20181108\\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png"}]}
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
         * Data : [{"Code":"e0740ad1-358f-441a-9083-04ded3c262e4","Name":"测试课程3人教 初中英语 七下 U3 Reading","No":"19.3","Level":3,"LessonHour":1,"AbilityItemCode":70,"InstructionalOBJ":"\"1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕\u201c交通\u201d的话题展开讨论\"","Remark":null,"CategoryCode":3,"CategoryName":"阅读","AbilityItemName":"阅读","Price":1,"PictureCode":"e11bdc0b-9bfb-4a2b-9e36-871c76e19edf","CreateDate":"2018-11-08T17:55:34.787","PicturePath":"lesson\\20181108\\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png"}]
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
             * Code : e0740ad1-358f-441a-9083-04ded3c262e4
             * Name : 测试课程3人教 初中英语 七下 U3 Reading
             * No : 19.3
             * Level : 3
             * LessonHour : 1
             * AbilityItemCode : 70
             * InstructionalOBJ : "1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕“交通”的话题展开讨论"
             * Remark : null
             * CategoryCode : 3
             * CategoryName : 阅读
             * AbilityItemName : 阅读
             * Price : 1
             * PictureCode : e11bdc0b-9bfb-4a2b-9e36-871c76e19edf
             * CreateDate : 2018-11-08T17:55:34.787
             * PicturePath : lesson\20181108\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png
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
            private double Price;
            private String PictureCode;
            private String CreateDate;
            private String PicturePath;

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

            public double getPrice() {
                return Price;
            }

            public void setPrice(double Price) {
                this.Price = Price;
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

            public String getPicturePath() {
                return PicturePath;
            }

            public void setPicturePath(String PicturePath) {
                this.PicturePath = PicturePath;
            }
        }
    }
}
