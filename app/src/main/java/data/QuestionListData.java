package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/14.
 */

public class QuestionListData {
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
         * QuestionCode : 92c0eb57-a162-44f0-a78e-1bedd5769801
         * No : 阅读理解第一篇小题3
         * Title :
         * TypeCode : 1
         * SubjectContent : When I was quite young, I discovered that somewhere inside the telephone lived an amazingperson - "Information Please" and there was nothing she did not know.　
         One day while my mother was out, I hit my finger with a hammer. The pain was terrible, but there was no one home to give me any sympathy. I walked around the house, finally arriving at the telephone! Quickly, I called “Information Please" and told her what happened.  She told me to open the icebox and hold a little piece of ice to my finger.
         After that, I called "Information Please" for everything. When my pet bird died, I told "Information Please" the sad story. She tried to comfort me, she said quietly, "Paul, always remember that there are other worlds to sing in." Somehow I felt better. Another day I was on the telephone, “How do you spell ‘grateful’? ". All this took place in a small town in the Pacific Northwest. When I was 9, we moved to Boston.
         A few years later, on my way to college, my plane put down in Seattle. I had about half an hour or so between planes. Without thinking, I dialed my hometown operator and said, "Information, please."    　　
         Surprisingly, I heard the small, clear voice I knew so well, "Information." I hadn’t planned on this but I heard myself saying, "Could you please tell me how to spell ‘grateful’?"
         There was a long pause. Then came the soft-spoken answer, "I guess your finger must have healed by now."   I laughed. "So it’s really still you," I said, "I wonder if you have any idea how much you meant to me during that time."  I told her how often I had thought of her over the years and asked if I could call her again. "Please do," she said, "Just ask for Sally."　　
         Three months later I was back in Seattle. A different voice answered me. I was told that Sally passed away five weeks before.   　　
         Before I could hang up she told me that Sally left a message for me—“Tell him I still say there are other worlds to sing in. He’ll know what I mean.”  I thanked her and hung up. I knew what Sally meant.
         Never underestimate the impression you may make on others. Whose life have you touched today?

         * AbilityItemCode : 80
         * QLevel : 1
         * TextDescribe : 细节题：从第二段的句子：可知information please给了作者信息和同情。选C
         * AudioAccessoryCode : 0fe3bf3d-5eb7-434b-9171-66b7531c9740
         * AudioPath : question_aduio\20180619\测试音频_0fe3bf3d-5eb7-434b-9171-66b7531c9740.mp3
         * QuestionOptions : [{"QuestionOptionCode":"9dddaec1-cb1b-4236-981d-03be6afa57d9","No":"C","Content":"Sympathy and information.","Answer":null,"IsCorrect":true}]
         */

        private String QuestionCode;
        private String SubjectTitle;
        private String No;
        private String Title;
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
            private String UserAnswer;
            private boolean IsCorrect;
            private boolean isCheck;

            public String getUserAnswer() {
                return UserAnswer;
            }

            public void setUserAnswer(String userAnswer) {
                UserAnswer = userAnswer;
            }

            public boolean isCorrect() {
                return IsCorrect;
            }

            public void setCorrect(boolean correct) {
                IsCorrect = correct;
            }

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

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

        }
    }
}
