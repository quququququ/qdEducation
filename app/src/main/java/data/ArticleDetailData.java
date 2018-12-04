package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleDetailData {
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
         * AbilityItemList : [{"Code":68,"Name":"听力"},{"Code":69,"Name":"口语"},{"Code":70,"Name":"阅读"},{"Code":80,"Name":"语法"}]
         * IsPurchased : false
         * Code : 541a2312-aa5e-49ed-af36-fa4b3e7d0e4c
         * Title : null
         * Content : 22222
         * Level : 1
         * AboutHoursLong : 0
         * Price : 10.7
         * Analysis : THE LITTLE ICE AGETHE LITTLE ICE AGETHE LITTLE ICE AGETHE LITTLE ICE AGE
         * Remark : null
         * ArticleSummary : 我是文章概述。
         * Sort : 0
         */

        private boolean IsPurchased;
        private String Code;
        private String Title;
        private String Content;
        private int Level;
        private int AboutHoursLong;
        private double Price;
        private String Analysis;
        private String Remark;
        private String ArticleSummary;
        private int Sort;
        private List<AbilityItemListBean> AbilityItemList;

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

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
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

        public int getAboutHoursLong() {
            return AboutHoursLong;
        }

        public void setAboutHoursLong(int AboutHoursLong) {
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

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
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

        public List<AbilityItemListBean> getAbilityItemList() {
            return AbilityItemList;
        }

        public void setAbilityItemList(List<AbilityItemListBean> AbilityItemList) {
            this.AbilityItemList = AbilityItemList;
        }

        public static class AbilityItemListBean {
            /**
             * Code : 68
             * Name : 听力
             */

            private int Code;
            private String Name;

            public int getCode() {
                return Code;
            }

            public void setCode(int Code) {
                this.Code = Code;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }
        }
    }
}
