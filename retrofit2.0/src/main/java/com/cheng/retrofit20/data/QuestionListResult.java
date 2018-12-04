package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/14.
 */

public class QuestionListResult extends BaseHttpResult{

    private BaseResponseResultBean BaseResponseResult;

    public BaseResponseResultBean getBaseResponseResult() {
        return BaseResponseResult;
    }

    public void setBaseResponseResult(BaseResponseResultBean BaseResponseResult) {
        this.BaseResponseResult = BaseResponseResult;
    }

    public static class BaseResponseResultBean {

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

            private String QuestionCode;
            private String No;
            private String Title;
            private String SubjectTitle;
            private int TypeCode;
            private String SubjectContent;
            private int AbilityItemCode;
            private int QLevel;
            private String TextDescribe;
            private String AudioAccessoryCode;
            private String AudioPath;
            private List<QuestionOptionsBean> QuestionOptions;

            public String getSubjectTitle() {
                return SubjectTitle;
            }

            public void setSubjectTitle(String subjectTitle) {
                SubjectTitle = subjectTitle;
            }

            public String getQuestionCode() {
                return QuestionCode;
            }

            public void setQuestionCode(String QuestionCode) {
                this.QuestionCode = QuestionCode;
            }

            public String getNo() {
                return No;
            }

            public void setNo(String No) {
                this.No = No;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getTypeCode() {
                return TypeCode;
            }

            public void setTypeCode(int TypeCode) {
                this.TypeCode = TypeCode;
            }

            public String getSubjectContent() {
                return SubjectContent;
            }

            public void setSubjectContent(String SubjectContent) {
                this.SubjectContent = SubjectContent;
            }

            public int getAbilityItemCode() {
                return AbilityItemCode;
            }

            public void setAbilityItemCode(int AbilityItemCode) {
                this.AbilityItemCode = AbilityItemCode;
            }

            public int getQLevel() {
                return QLevel;
            }

            public void setQLevel(int QLevel) {
                this.QLevel = QLevel;
            }

            public String getTextDescribe() {
                return TextDescribe;
            }

            public void setTextDescribe(String TextDescribe) {
                this.TextDescribe = TextDescribe;
            }

            public String getAudioAccessoryCode() {
                return AudioAccessoryCode;
            }

            public void setAudioAccessoryCode(String AudioAccessoryCode) {
                this.AudioAccessoryCode = AudioAccessoryCode;
            }

            public String getAudioPath() {
                return AudioPath;
            }

            public void setAudioPath(String AudioPath) {
                this.AudioPath = AudioPath;
            }

            public List<QuestionOptionsBean> getQuestionOptions() {
                return QuestionOptions;
            }

            public void setQuestionOptions(List<QuestionOptionsBean> QuestionOptions) {
                this.QuestionOptions = QuestionOptions;
            }

            public static class QuestionOptionsBean {
                /**
                 * QuestionOptionCode : 9dddaec1-cb1b-4236-981d-03be6afa57d9
                 * No : C
                 * Content : Sympathy and information.
                 * Answer : null
                 * IsCorrect : true
                 */

                private String QuestionOptionCode;
                private String No;
                private String Content;
                private String Answer;
                private boolean IsCorrect;

                public String getQuestionOptionCode() {
                    return QuestionOptionCode;
                }

                public void setQuestionOptionCode(String QuestionOptionCode) {
                    this.QuestionOptionCode = QuestionOptionCode;
                }

                public String getNo() {
                    return No;
                }

                public void setNo(String No) {
                    this.No = No;
                }

                public String getContent() {
                    return Content;
                }

                public void setContent(String Content) {
                    this.Content = Content;
                }

                public String getAnswer() {
                    return Answer;
                }

                public void setAnswer(String Answer) {
                    this.Answer = Answer;
                }

                public boolean isIsCorrect() {
                    return IsCorrect;
                }

                public void setIsCorrect(boolean IsCorrect) {
                    this.IsCorrect = IsCorrect;
                }
            }
        }
    }
}
