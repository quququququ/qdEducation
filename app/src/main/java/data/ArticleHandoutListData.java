package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleHandoutListData {
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
         * AbilityItemCode : 70
         * AbilityItemName : 阅读
         * ArticleHandouts : [{"Code":"5f0da6c9-c9db-4ae9-ac70-8369e19fcb81","Title":"第3测试讲义人教 七下 U1 19.3 Reading Instruction","Summary":"讲解阅读要点","PPTAccessoryCode":"7b06dbf5-7271-442f-abd6-26e15d4e07d1","IMGAccessoryCode":"705a5e1e-a5f0-4126-9e74-8c2473e27c3b","AbilityItemCode":70,"AbilityItemName":"阅读","Sort":1,"IMGPath":"photo\\20181108\\人教 七下 U3 Reading_705a5e1e-a5f0-4126-9e74-8c2473e27c3b.png"}]
         */

        private int AbilityItemCode;
        private String AbilityItemName;
        private List<ArticleHandoutsBean> ArticleHandouts;

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

        public List<ArticleHandoutsBean> getArticleHandouts() {
            return ArticleHandouts;
        }

        public void setArticleHandouts(List<ArticleHandoutsBean> ArticleHandouts) {
            this.ArticleHandouts = ArticleHandouts;
        }

        public static class ArticleHandoutsBean {
            /**
             * Code : 5f0da6c9-c9db-4ae9-ac70-8369e19fcb81
             * Title : 第3测试讲义人教 七下 U1 19.3 Reading Instruction
             * Summary : 讲解阅读要点
             * PPTAccessoryCode : 7b06dbf5-7271-442f-abd6-26e15d4e07d1
             * IMGAccessoryCode : 705a5e1e-a5f0-4126-9e74-8c2473e27c3b
             * AbilityItemCode : 70
             * AbilityItemName : 阅读
             * Sort : 1
             * IMGPath : photo\20181108\人教 七下 U3 Reading_705a5e1e-a5f0-4126-9e74-8c2473e27c3b.png
             */

            private String Code;
            private String Title;
            private String Summary;
            private String PPTAccessoryCode;
            private String IMGAccessoryCode;
            private int AbilityItemCode;
            private String AbilityItemName;
            private int Sort;
            private String IMGPath;

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

            public String getSummary() {
                return Summary;
            }

            public void setSummary(String Summary) {
                this.Summary = Summary;
            }

            public String getPPTAccessoryCode() {
                return PPTAccessoryCode;
            }

            public void setPPTAccessoryCode(String PPTAccessoryCode) {
                this.PPTAccessoryCode = PPTAccessoryCode;
            }

            public String getIMGAccessoryCode() {
                return IMGAccessoryCode;
            }

            public void setIMGAccessoryCode(String IMGAccessoryCode) {
                this.IMGAccessoryCode = IMGAccessoryCode;
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

            public int getSort() {
                return Sort;
            }

            public void setSort(int Sort) {
                this.Sort = Sort;
            }

            public String getIMGPath() {
                return IMGPath;
            }

            public void setIMGPath(String IMGPath) {
                this.IMGPath = IMGPath;
            }
        }
    }
}
