package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/28.
 */

public class QuestionFiltersResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":{"QuestionTypes":[{"Code":1,"Name":"选择题"},{"Code":2,"Name":"填空题"},{"Code":3,"Name":"写作题"}],"AbilityItems":[{"Code":68,"Name":"听力"},{"Code":69,"Name":"口语"},{"Code":70,"Name":"阅读"},{"Code":71,"Name":"写作"},{"Code":80,"Name":"语法"},{"Code":82,"Name":"雅思听力"},{"Code":83,"Name":"雅思口语"},{"Code":84,"Name":"雅思阅读"},{"Code":85,"Name":"雅思写作"},{"Code":86,"Name":"托福听力"},{"Code":87,"Name":"托福口语"},{"Code":88,"Name":"托福阅读"},{"Code":89,"Name":"托福写作"},{"Code":90,"Name":"词汇"}],"QuestionLevels":[0,1,2,3,4,33]}}
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
         * Data : {"QuestionTypes":[{"Code":1,"Name":"选择题"},{"Code":2,"Name":"填空题"},{"Code":3,"Name":"写作题"}],"AbilityItems":[{"Code":68,"Name":"听力"},{"Code":69,"Name":"口语"},{"Code":70,"Name":"阅读"},{"Code":71,"Name":"写作"},{"Code":80,"Name":"语法"},{"Code":82,"Name":"雅思听力"},{"Code":83,"Name":"雅思口语"},{"Code":84,"Name":"雅思阅读"},{"Code":85,"Name":"雅思写作"},{"Code":86,"Name":"托福听力"},{"Code":87,"Name":"托福口语"},{"Code":88,"Name":"托福阅读"},{"Code":89,"Name":"托福写作"},{"Code":90,"Name":"词汇"}],"QuestionLevels":[0,1,2,3,4,33]}
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
            private List<QuestionTypesBean> QuestionTypes;
            private List<AbilityItemsBean> AbilityItems;
            private List<Integer> QuestionLevels;

            public List<QuestionTypesBean> getQuestionTypes() {
                return QuestionTypes;
            }

            public void setQuestionTypes(List<QuestionTypesBean> QuestionTypes) {
                this.QuestionTypes = QuestionTypes;
            }

            public List<AbilityItemsBean> getAbilityItems() {
                return AbilityItems;
            }

            public void setAbilityItems(List<AbilityItemsBean> AbilityItems) {
                this.AbilityItems = AbilityItems;
            }

            public List<Integer> getQuestionLevels() {
                return QuestionLevels;
            }

            public void setQuestionLevels(List<Integer> QuestionLevels) {
                this.QuestionLevels = QuestionLevels;
            }

            public static class QuestionTypesBean {
                /**
                 * Code : 1
                 * Name : 选择题
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

            public static class AbilityItemsBean {
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
}
