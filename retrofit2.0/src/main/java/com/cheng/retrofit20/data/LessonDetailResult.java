package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/3.
 */

public class LessonDetailResult extends BaseHttpResult{


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"Articles":[{"IsPurchased":false,"Code":"223249aa-5cb4-4525-a6b7-f82848279888","Title":null,"Content":"Crossing the River to School\r\nHow do you get to school? Do you walk or ride a bike? Do you go by bus or by train? For many students, it is easy to get to school. But for the students in one small village in China, it is difficult. There is a very big river between their school and the village. There is no bridge and the river runs too quickly for boats. So these students go on a ropeway to cross the river to school.\r\nOne 11-year-old boy, Liangliang, crosses the river every school day. But he is not afraid because he loves school. \u201cI love to play with my classmates. And I love my teacher. He's like a father to me.\"\r\nMany of the students and villagers never leave the village. It is their dream to have a bridge. Can their dream come true?\r\n","Level":3,"AboutHoursLong":0,"Price":0.1,"Analysis":"无","Remark":null,"ArticleSummary":"\"A. How students in a small village get to school  B. Liangliang's feeling about going to school  C. The villagers' dream\"","Sort":0}],"IsPurchased":false,"IsCollected":false,"Code":"e0740ad1-358f-441a-9083-04ded3c262e4","Name":"测试课程3人教 初中英语 七下 U3 Reading","No":"19.3","Level":3,"LessonHour":1,"AbilityItemCode":70,"InstructionalOBJ":"\"1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕\u201c交通\u201d的话题展开讨论\"","Remark":null,"CategoryCode":3,"CategoryName":"阅读","AbilityItemName":"阅读","Price":0.1,"PictureCode":"e11bdc0b-9bfb-4a2b-9e36-871c76e19edf","CreateDate":"2018-11-08T17:55:34.787","PicturePath":"lesson\\20181108\\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png"}}
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
         * Data : {"Articles":[{"IsPurchased":false,"Code":"223249aa-5cb4-4525-a6b7-f82848279888","Title":null,"Content":"Crossing the River to School\r\nHow do you get to school? Do you walk or ride a bike? Do you go by bus or by train? For many students, it is easy to get to school. But for the students in one small village in China, it is difficult. There is a very big river between their school and the village. There is no bridge and the river runs too quickly for boats. So these students go on a ropeway to cross the river to school.\r\nOne 11-year-old boy, Liangliang, crosses the river every school day. But he is not afraid because he loves school. \u201cI love to play with my classmates. And I love my teacher. He's like a father to me.\"\r\nMany of the students and villagers never leave the village. It is their dream to have a bridge. Can their dream come true?\r\n","Level":3,"AboutHoursLong":0,"Price":0.1,"Analysis":"无","Remark":null,"ArticleSummary":"\"A. How students in a small village get to school  B. Liangliang's feeling about going to school  C. The villagers' dream\"","Sort":0}],"IsPurchased":false,"IsCollected":false,"Code":"e0740ad1-358f-441a-9083-04ded3c262e4","Name":"测试课程3人教 初中英语 七下 U3 Reading","No":"19.3","Level":3,"LessonHour":1,"AbilityItemCode":70,"InstructionalOBJ":"\"1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕\u201c交通\u201d的话题展开讨论\"","Remark":null,"CategoryCode":3,"CategoryName":"阅读","AbilityItemName":"阅读","Price":0.1,"PictureCode":"e11bdc0b-9bfb-4a2b-9e36-871c76e19edf","CreateDate":"2018-11-08T17:55:34.787","PicturePath":"lesson\\20181108\\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png"}
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
             * Articles : [{"IsPurchased":false,"Code":"223249aa-5cb4-4525-a6b7-f82848279888","Title":null,"Content":"Crossing the River to School\r\nHow do you get to school? Do you walk or ride a bike? Do you go by bus or by train? For many students, it is easy to get to school. But for the students in one small village in China, it is difficult. There is a very big river between their school and the village. There is no bridge and the river runs too quickly for boats. So these students go on a ropeway to cross the river to school.\r\nOne 11-year-old boy, Liangliang, crosses the river every school day. But he is not afraid because he loves school. \u201cI love to play with my classmates. And I love my teacher. He's like a father to me.\"\r\nMany of the students and villagers never leave the village. It is their dream to have a bridge. Can their dream come true?\r\n","Level":3,"AboutHoursLong":0,"Price":0.1,"Analysis":"无","Remark":null,"ArticleSummary":"\"A. How students in a small village get to school  B. Liangliang's feeling about going to school  C. The villagers' dream\"","Sort":0}]
             * IsPurchased : false
             * IsCollected : false
             * Code : e0740ad1-358f-441a-9083-04ded3c262e4
             * Name : 测试课程3人教 初中英语 七下 U3 Reading
             * No : 19.3
             * Level : 3
             * LessonHour : 1.0
             * AbilityItemCode : 70
             * InstructionalOBJ : "1.能捕捉文章细节信息 2.能总结文章段落大意 3.掌握重点单词与短语 4.理解重难句 5.能围绕“交通”的话题展开讨论"
             * Remark : null
             * CategoryCode : 3
             * CategoryName : 阅读
             * AbilityItemName : 阅读
             * Price : 0.1
             * PictureCode : e11bdc0b-9bfb-4a2b-9e36-871c76e19edf
             * CreateDate : 2018-11-08T17:55:34.787
             * PicturePath : lesson\20181108\人教 初中英语 七下 U3 Reading_e11bdc0b-9bfb-4a2b-9e36-871c76e19edf.png
             */

            private boolean IsPurchased;
            private boolean IsCollected;
            private String Code;
            private String Name;
            private String No;
            private int Level;
            private double LessonHour;
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
            private List<ArticlesBean> Articles;

            public boolean isIsPurchased() {
                return IsPurchased;
            }

            public void setIsPurchased(boolean IsPurchased) {
                this.IsPurchased = IsPurchased;
            }

            public boolean isIsCollected() {
                return IsCollected;
            }

            public void setIsCollected(boolean IsCollected) {
                this.IsCollected = IsCollected;
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

            public double getLessonHour() {
                return LessonHour;
            }

            public void setLessonHour(double LessonHour) {
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

            public List<ArticlesBean> getArticles() {
                return Articles;
            }

            public void setArticles(List<ArticlesBean> Articles) {
                this.Articles = Articles;
            }

            public static class ArticlesBean {
                /**
                 * IsPurchased : false
                 * Code : 223249aa-5cb4-4525-a6b7-f82848279888
                 * Title : null
                 * Content : Crossing the River to School
                 How do you get to school? Do you walk or ride a bike? Do you go by bus or by train? For many students, it is easy to get to school. But for the students in one small village in China, it is difficult. There is a very big river between their school and the village. There is no bridge and the river runs too quickly for boats. So these students go on a ropeway to cross the river to school.
                 One 11-year-old boy, Liangliang, crosses the river every school day. But he is not afraid because he loves school. “I love to play with my classmates. And I love my teacher. He's like a father to me."
                 Many of the students and villagers never leave the village. It is their dream to have a bridge. Can their dream come true?

                 * Level : 3
                 * AboutHoursLong : 0.0
                 * Price : 0.1
                 * Analysis : 无
                 * Remark : null
                 * ArticleSummary : "A. How students in a small village get to school  B. Liangliang's feeling about going to school  C. The villagers' dream"
                 * Sort : 0
                 */

                private boolean IsPurchased;
                private String Code;
                private Object Title;
                private String Content;
                private int Level;
                private double AboutHoursLong;
                private double Price;
                private String Analysis;
                private Object Remark;
                private String ArticleSummary;
                private int Sort;

                public boolean isIsPurchased() {
                    return IsPurchased;
                }

                public void setIsPurchased(boolean IsPurchased) {
                    this.IsPurchased = IsPurchased;
                }

                public String getCode() {
                    return Code;
                }

                public void setCode(String Code) {
                    this.Code = Code;
                }

                public Object getTitle() {
                    return Title;
                }

                public void setTitle(Object Title) {
                    this.Title = Title;
                }

                public String getContent() {
                    return Content;
                }

                public void setContent(String Content) {
                    this.Content = Content;
                }

                public int getLevel() {
                    return Level;
                }

                public void setLevel(int Level) {
                    this.Level = Level;
                }

                public double getAboutHoursLong() {
                    return AboutHoursLong;
                }

                public void setAboutHoursLong(double AboutHoursLong) {
                    this.AboutHoursLong = AboutHoursLong;
                }

                public double getPrice() {
                    return Price;
                }

                public void setPrice(double Price) {
                    this.Price = Price;
                }

                public String getAnalysis() {
                    return Analysis;
                }

                public void setAnalysis(String Analysis) {
                    this.Analysis = Analysis;
                }

                public Object getRemark() {
                    return Remark;
                }

                public void setRemark(Object Remark) {
                    this.Remark = Remark;
                }

                public String getArticleSummary() {
                    return ArticleSummary;
                }

                public void setArticleSummary(String ArticleSummary) {
                    this.ArticleSummary = ArticleSummary;
                }

                public int getSort() {
                    return Sort;
                }

                public void setSort(int Sort) {
                    this.Sort = Sort;
                }
            }
        }
    }
}
