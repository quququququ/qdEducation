package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/18.
 */

public class PracticeListData {
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
         * Code : a0b1ef6e-1407-4404-87d8-892af5885c6d
         * Title : 2018-10-15
         * StartTime : 2018-10-15T04:03:20
         * EndTime : 2018-10-15T14:05:20
         * QuestionCount : 2
         * CorrectRate : 0
         */

        private String Code;
        private String Title;
        private String StartTime;
        private String EndTime;
        private String QuestionCount;
        private String CorrectRate;

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

        public String getQuestionCount() {
            return QuestionCount;
        }

        public void setQuestionCount(String QuestionCount) {
            this.QuestionCount = QuestionCount;
        }

        public String getCorrectRate() {
            return CorrectRate;
        }

        public void setCorrectRate(String CorrectRate) {
            this.CorrectRate = CorrectRate;
        }
    }
}
