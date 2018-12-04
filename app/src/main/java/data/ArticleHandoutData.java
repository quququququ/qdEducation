package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/11/13.
 */

public class ArticleHandoutData {
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
         * Videos : [{"PlayedLength":0,"LastStudyDate":"0001-01-01T00:00:00","Code":"31a77775-5cf4-485b-91eb-52ed1481a943","VideoAccessoryCode":"2dc4ff9e-465a-4e57-90de-cd205ae62658","VideoAccessoryPath":"video\\20181108\\1-1 00_14_38-00_19_00_2dc4ff9e-465a-4e57-90de-cd205ae62658.mp4","FileName":"1-1 00_14_38-00_19_00.mp4","Length":0,"Sort":2},{"PlayedLength":0,"LastStudyDate":"0001-01-01T00:00:00","Code":"e0ba7b60-6f81-4636-be10-633daf408873","VideoAccessoryCode":"7f3eaeea-6dd6-4477-aeb8-fc7c1b356cf7","VideoAccessoryPath":"video\\20181108\\1-1 00_11_22-00_14_38_7f3eaeea-6dd6-4477-aeb8-fc7c1b356cf7.mp4","FileName":"1-1 00_11_22-00_14_38.mp4","Length":0,"Sort":1},{"PlayedLength":0,"LastStudyDate":"0001-01-01T00:00:00","Code":"d045ef78-03b2-4178-9056-84601a087994","VideoAccessoryCode":"eea24962-ec80-4bcf-85dc-a7ef2b4c26f1","VideoAccessoryPath":"video\\20181108\\1-1 00_19_11-00_19_27_eea24962-ec80-4bcf-85dc-a7ef2b4c26f1.mp4","FileName":"1-1 00_19_11-00_19_27.mp4","Length":0,"Sort":3}]
         * Code : 5f0da6c9-c9db-4ae9-ac70-8369e19fcb81
         * Title : 第3测试讲义人教 七下 U1 19.3 Reading Instruction
         * Summary : 讲解阅读要点
         * PPTAccessoryCode : 7b06dbf5-7271-442f-abd6-26e15d4e07d1
         * IMGAccessoryCode : 705a5e1e-a5f0-4126-9e74-8c2473e27c3b
         * AbilityItemCode : 70
         * AbilityItemName : 阅读
         * Sort : 0
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
        private List<VideosBean> Videos;

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

        public List<VideosBean> getVideos() {
            return Videos;
        }

        public void setVideos(List<VideosBean> Videos) {
            this.Videos = Videos;
        }

        public static class VideosBean {
            /**
             * PlayedLength : 0
             * LastStudyDate : 0001-01-01T00:00:00
             * Code : 31a77775-5cf4-485b-91eb-52ed1481a943
             * VideoAccessoryCode : 2dc4ff9e-465a-4e57-90de-cd205ae62658
             * VideoAccessoryPath : video\20181108\1-1 00_14_38-00_19_00_2dc4ff9e-465a-4e57-90de-cd205ae62658.mp4
             * FileName : 1-1 00_14_38-00_19_00.mp4
             * Length : 0
             * Sort : 2
             */

            private String PlayedLength;
            private String LastStudyDate;
            private String Code;
            private String VideoAccessoryCode;
            private String VideoAccessoryPath;
            private String FileName;
            private String Length;
            private String Sort;
            private String pircturePath;

            public String getPircturePath() {
                return pircturePath;
            }

            public void setPircturePath(String pircturePath) {
                this.pircturePath = pircturePath;
            }

            public String getPlayedLength() {
                return PlayedLength;
            }

            public void setPlayedLength(String PlayedLength) {
                this.PlayedLength = PlayedLength;
            }

            public String getLastStudyDate() {
                return LastStudyDate;
            }

            public void setLastStudyDate(String LastStudyDate) {
                this.LastStudyDate = LastStudyDate;
            }

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
            }

            public String getVideoAccessoryCode() {
                return VideoAccessoryCode;
            }

            public void setVideoAccessoryCode(String VideoAccessoryCode) {
                this.VideoAccessoryCode = VideoAccessoryCode;
            }

            public String getVideoAccessoryPath() {
                return VideoAccessoryPath;
            }

            public void setVideoAccessoryPath(String VideoAccessoryPath) {
                this.VideoAccessoryPath = VideoAccessoryPath;
            }

            public String getFileName() {
                return FileName;
            }

            public void setFileName(String FileName) {
                this.FileName = FileName;
            }

            public String getLength() {
                return Length;
            }

            public void setLength(String Length) {
                this.Length = Length;
            }

            public String getSort() {
                return Sort;
            }

            public void setSort(String Sort) {
                this.Sort = Sort;
            }
        }
    }
}
