package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/12/2.
 */

public class PracticeDetailData {
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

        private String Code;
        private String Title;
        private String StartTime;
        private String EndTime;
        private int QuestionCount;
        private int CorrectRate;
        private List<PracticeDetailBean> PracticeDetail;

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

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getQuestionCount() {
            return QuestionCount;
        }

        public void setQuestionCount(int QuestionCount) {
            this.QuestionCount = QuestionCount;
        }

        public int getCorrectRate() {
            return CorrectRate;
        }

        public void setCorrectRate(int CorrectRate) {
            this.CorrectRate = CorrectRate;
        }

        public List<PracticeDetailBean> getPracticeDetail() {
            return PracticeDetail;
        }

        public void setPracticeDetail(List<PracticeDetailBean> PracticeDetail) {
            this.PracticeDetail = PracticeDetail;
        }

        public static class PracticeDetailBean {

            private String QuestionCode;
            private String No;
            private String Title;
            private int TypeCode;
            private String SubjectTitle;
            private String SubjectContent;
            private int AbilityItemCode;
            private int QLevel;
            private String TextDescribe;
            private String AudioAccessoryCode;
            private String AudioPath;
            private List<UserOptionsBean> UserOptions;
            private List<QuestionOptionsBean> QuestionOptions;

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

            public String getSubjectTitle() {
                return SubjectTitle;
            }

            public void setSubjectTitle(String SubjectTitle) {
                this.SubjectTitle = SubjectTitle;
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

            public List<UserOptionsBean> getUserOptions() {
                return UserOptions;
            }

            public void setUserOptions(List<UserOptionsBean> UserOptions) {
                this.UserOptions = UserOptions;
            }

            public List<QuestionOptionsBean> getQuestionOptions() {
                return QuestionOptions;
            }

            public void setQuestionOptions(List<QuestionOptionsBean> QuestionOptions) {
                this.QuestionOptions = QuestionOptions;
            }

            public static class UserOptionsBean {
                /**
                 * QuestionOptionCode : 00000000-0000-0000-0000-000000000000
                 * Answer :
                 */

                private String QuestionOptionCode;
                private String Answer;

                public String getQuestionOptionCode() {
                    return QuestionOptionCode;
                }

                public void setQuestionOptionCode(String QuestionOptionCode) {
                    this.QuestionOptionCode = QuestionOptionCode;
                }

                public String getAnswer() {
                    return Answer;
                }

                public void setAnswer(String Answer) {
                    this.Answer = Answer;
                }
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
