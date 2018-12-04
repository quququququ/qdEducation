package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/28.
 */

public class QuestionFiltersData {
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
