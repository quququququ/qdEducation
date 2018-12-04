package com.cheng.retrofit20.data;

import com.cheng.retrofit20.client.BaseHttpResult;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/22.
 */

public class ExercisesResult extends BaseHttpResult {


    /**
     * BaseResponseResult : {"result_code":"SUCCESS","result_msg":"","Data":[{"options":[{"Code":"","QuestionCode":"","No":"1","Content":"","Answer":"send a messenger ","IsCorrect":false,"CreateBy":"管理员","CreateDate":"2018-06-07T14:54:40.077","ModifyBy":"","ModifyDate":"2018-06-07T14:54:40.077"}],"userOptions":"","FileName":"","FilePath":"","SubjectName":"标准题目素材 1","TypeName":"填空题","ExerciseTypeName":"课堂","TypeContentId":89995,"AbilityItemName":"听力","AbilityItemNameWithLang":"听力","TagTextContentId":0,"TagName":"阅读--文章主旨题","TagNameWithLang":"阅读--文章主旨题","AbilityItemTextContentId":0,"ExerciseTypeContentId":90130,"CourseTypeName":"阅读课程","QuestionTestTypeName":"雅思","AudioFileName":"麻枝准 - love song -piano-.mp3","AudioPath":"","Code":"ae496ea4-5325-4811-a64f-22bf28ccda9a","No":"标准填空题 1","Title":"","TypeCode":2,"TagCode":182,"TotalMinute":10,"SubNum":8,"QLevel":1,"AbilityItemCode":68,"Mark":10,"AccessoryCode":"","RelationType":2,"SubjectCode":"35383950-15ca-4a98-a012-e64e5cf02ff2","ExerciseTypeCode":2,"CourseTypeCode":6,"IsActived":true,"Status":3,"SchoolCode":"d8cbad87-63f2-464c-92f9-bdf64ebad529","DegreeOfDifficulty":1,"QuestionTestTypeCode":"8fad2fec-8fdd-40eb-8f1d-ea13e5c4b882","AudioAccessoryCode":"2b024aa6-a479-497b-b29a-c9b9396f50c3","TextDescribe":"仔细看题审题。","CreateBy":"管理员","CreateDate":"2018-06-07T14:54:39.337","ModifyBy":"","ModifyDate":"2018-06-07T14:54:39.337"}]}
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
         * Data : [{"options":[{"Code":"","QuestionCode":"","No":"1","Content":"","Answer":"send a messenger ","IsCorrect":false,"CreateBy":"管理员","CreateDate":"2018-06-07T14:54:40.077","ModifyBy":"","ModifyDate":"2018-06-07T14:54:40.077"}],"userOptions":"","FileName":"","FilePath":"","SubjectName":"标准题目素材 1","TypeName":"填空题","ExerciseTypeName":"课堂","TypeContentId":89995,"AbilityItemName":"听力","AbilityItemNameWithLang":"听力","TagTextContentId":0,"TagName":"阅读--文章主旨题","TagNameWithLang":"阅读--文章主旨题","AbilityItemTextContentId":0,"ExerciseTypeContentId":90130,"CourseTypeName":"阅读课程","QuestionTestTypeName":"雅思","AudioFileName":"麻枝准 - love song -piano-.mp3","AudioPath":"","Code":"ae496ea4-5325-4811-a64f-22bf28ccda9a","No":"标准填空题 1","Title":"","TypeCode":2,"TagCode":182,"TotalMinute":10,"SubNum":8,"QLevel":1,"AbilityItemCode":68,"Mark":10,"AccessoryCode":"","RelationType":2,"SubjectCode":"35383950-15ca-4a98-a012-e64e5cf02ff2","ExerciseTypeCode":2,"CourseTypeCode":6,"IsActived":true,"Status":3,"SchoolCode":"d8cbad87-63f2-464c-92f9-bdf64ebad529","DegreeOfDifficulty":1,"QuestionTestTypeCode":"8fad2fec-8fdd-40eb-8f1d-ea13e5c4b882","AudioAccessoryCode":"2b024aa6-a479-497b-b29a-c9b9396f50c3","TextDescribe":"仔细看题审题。","CreateBy":"管理员","CreateDate":"2018-06-07T14:54:39.337","ModifyBy":"","ModifyDate":"2018-06-07T14:54:39.337"}]
         */

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
             * options : [{"Code":"","QuestionCode":"","No":"1","Content":"","Answer":"send a messenger ","IsCorrect":false,"CreateBy":"管理员","CreateDate":"2018-06-07T14:54:40.077","ModifyBy":"","ModifyDate":"2018-06-07T14:54:40.077"}]
             * userOptions :
             * FileName :
             * FilePath :
             * SubjectName : 标准题目素材 1
             * TypeName : 填空题
             * ExerciseTypeName : 课堂
             * TypeContentId : 89995
             * AbilityItemName : 听力
             * AbilityItemNameWithLang : 听力
             * TagTextContentId : 0
             * TagName : 阅读--文章主旨题
             * TagNameWithLang : 阅读--文章主旨题
             * AbilityItemTextContentId : 0
             * ExerciseTypeContentId : 90130
             * CourseTypeName : 阅读课程
             * QuestionTestTypeName : 雅思
             * AudioFileName : 麻枝准 - love song -piano-.mp3
             * AudioPath :
             * Code : ae496ea4-5325-4811-a64f-22bf28ccda9a
             * No : 标准填空题 1
             * Title :
             * TypeCode : 2
             * TagCode : 182
             * TotalMinute : 10
             * SubNum : 8
             * QLevel : 1
             * AbilityItemCode : 68
             * Mark : 10
             * AccessoryCode :
             * RelationType : 2
             * SubjectCode : 35383950-15ca-4a98-a012-e64e5cf02ff2
             * ExerciseTypeCode : 2
             * CourseTypeCode : 6
             * IsActived : true
             * Status : 3
             * SchoolCode : d8cbad87-63f2-464c-92f9-bdf64ebad529
             * DegreeOfDifficulty : 1
             * QuestionTestTypeCode : 8fad2fec-8fdd-40eb-8f1d-ea13e5c4b882
             * AudioAccessoryCode : 2b024aa6-a479-497b-b29a-c9b9396f50c3
             * TextDescribe : 仔细看题审题。
             * CreateBy : 管理员
             * CreateDate : 2018-06-07T14:54:39.337
             * ModifyBy :
             * ModifyDate : 2018-06-07T14:54:39.337
             */

            private String userOptions;
            private String FileName;
            private String FilePath;
            private String SubjectName;
            private String TypeName;
            private String ExerciseTypeName;
            private int TypeContentId;
            private String AbilityItemName;
            private String AbilityItemNameWithLang;
            private int TagTextContentId;
            private String TagName;
            private String TagNameWithLang;
            private int AbilityItemTextContentId;
            private int ExerciseTypeContentId;
            private String CourseTypeName;
            private String QuestionTestTypeName;
            private String AudioFileName;
            private String AudioPath;
            private String Code;
            private String No;
            private String Title;
            private int TypeCode;
            private int TagCode;
            private int TotalMinute;
            private int SubNum;
            private int QLevel;
            private int AbilityItemCode;
            private int Mark;
            private String AccessoryCode;
            private int RelationType;
            private String SubjectCode;
            private int ExerciseTypeCode;
            private int CourseTypeCode;
            private boolean IsActived;
            private int Status;
            private String SchoolCode;
            private int DegreeOfDifficulty;
            private String QuestionTestTypeCode;
            private String AudioAccessoryCode;
            private String TextDescribe;
            private String CreateBy;
            private String CreateDate;
            private String ModifyBy;
            private String ModifyDate;
            private List<OptionsBean> options;

            public String getUserOptions() {
                return userOptions;
            }

            public void setUserOptions(String userOptions) {
                this.userOptions = userOptions;
            }

            public String getFileName() {
                return FileName;
            }

            public void setFileName(String FileName) {
                this.FileName = FileName;
            }

            public String getFilePath() {
                return FilePath;
            }

            public void setFilePath(String FilePath) {
                this.FilePath = FilePath;
            }

            public String getSubjectName() {
                return SubjectName;
            }

            public void setSubjectName(String SubjectName) {
                this.SubjectName = SubjectName;
            }

            public String getTypeName() {
                return TypeName;
            }

            public void setTypeName(String TypeName) {
                this.TypeName = TypeName;
            }

            public String getExerciseTypeName() {
                return ExerciseTypeName;
            }

            public void setExerciseTypeName(String ExerciseTypeName) {
                this.ExerciseTypeName = ExerciseTypeName;
            }

            public int getTypeContentId() {
                return TypeContentId;
            }

            public void setTypeContentId(int TypeContentId) {
                this.TypeContentId = TypeContentId;
            }

            public String getAbilityItemName() {
                return AbilityItemName;
            }

            public void setAbilityItemName(String AbilityItemName) {
                this.AbilityItemName = AbilityItemName;
            }

            public String getAbilityItemNameWithLang() {
                return AbilityItemNameWithLang;
            }

            public void setAbilityItemNameWithLang(String AbilityItemNameWithLang) {
                this.AbilityItemNameWithLang = AbilityItemNameWithLang;
            }

            public int getTagTextContentId() {
                return TagTextContentId;
            }

            public void setTagTextContentId(int TagTextContentId) {
                this.TagTextContentId = TagTextContentId;
            }

            public String getTagName() {
                return TagName;
            }

            public void setTagName(String TagName) {
                this.TagName = TagName;
            }

            public String getTagNameWithLang() {
                return TagNameWithLang;
            }

            public void setTagNameWithLang(String TagNameWithLang) {
                this.TagNameWithLang = TagNameWithLang;
            }

            public int getAbilityItemTextContentId() {
                return AbilityItemTextContentId;
            }

            public void setAbilityItemTextContentId(int AbilityItemTextContentId) {
                this.AbilityItemTextContentId = AbilityItemTextContentId;
            }

            public int getExerciseTypeContentId() {
                return ExerciseTypeContentId;
            }

            public void setExerciseTypeContentId(int ExerciseTypeContentId) {
                this.ExerciseTypeContentId = ExerciseTypeContentId;
            }

            public String getCourseTypeName() {
                return CourseTypeName;
            }

            public void setCourseTypeName(String CourseTypeName) {
                this.CourseTypeName = CourseTypeName;
            }

            public String getQuestionTestTypeName() {
                return QuestionTestTypeName;
            }

            public void setQuestionTestTypeName(String QuestionTestTypeName) {
                this.QuestionTestTypeName = QuestionTestTypeName;
            }

            public String getAudioFileName() {
                return AudioFileName;
            }

            public void setAudioFileName(String AudioFileName) {
                this.AudioFileName = AudioFileName;
            }

            public String getAudioPath() {
                return AudioPath;
            }

            public void setAudioPath(String AudioPath) {
                this.AudioPath = AudioPath;
            }

            public String getCode() {
                return Code;
            }

            public void setCode(String Code) {
                this.Code = Code;
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

            public int getTagCode() {
                return TagCode;
            }

            public void setTagCode(int TagCode) {
                this.TagCode = TagCode;
            }

            public int getTotalMinute() {
                return TotalMinute;
            }

            public void setTotalMinute(int TotalMinute) {
                this.TotalMinute = TotalMinute;
            }

            public int getSubNum() {
                return SubNum;
            }

            public void setSubNum(int SubNum) {
                this.SubNum = SubNum;
            }

            public int getQLevel() {
                return QLevel;
            }

            public void setQLevel(int QLevel) {
                this.QLevel = QLevel;
            }

            public int getAbilityItemCode() {
                return AbilityItemCode;
            }

            public void setAbilityItemCode(int AbilityItemCode) {
                this.AbilityItemCode = AbilityItemCode;
            }

            public int getMark() {
                return Mark;
            }

            public void setMark(int Mark) {
                this.Mark = Mark;
            }

            public String getAccessoryCode() {
                return AccessoryCode;
            }

            public void setAccessoryCode(String AccessoryCode) {
                this.AccessoryCode = AccessoryCode;
            }

            public int getRelationType() {
                return RelationType;
            }

            public void setRelationType(int RelationType) {
                this.RelationType = RelationType;
            }

            public String getSubjectCode() {
                return SubjectCode;
            }

            public void setSubjectCode(String SubjectCode) {
                this.SubjectCode = SubjectCode;
            }

            public int getExerciseTypeCode() {
                return ExerciseTypeCode;
            }

            public void setExerciseTypeCode(int ExerciseTypeCode) {
                this.ExerciseTypeCode = ExerciseTypeCode;
            }

            public int getCourseTypeCode() {
                return CourseTypeCode;
            }

            public void setCourseTypeCode(int CourseTypeCode) {
                this.CourseTypeCode = CourseTypeCode;
            }

            public boolean isIsActived() {
                return IsActived;
            }

            public void setIsActived(boolean IsActived) {
                this.IsActived = IsActived;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public String getSchoolCode() {
                return SchoolCode;
            }

            public void setSchoolCode(String SchoolCode) {
                this.SchoolCode = SchoolCode;
            }

            public int getDegreeOfDifficulty() {
                return DegreeOfDifficulty;
            }

            public void setDegreeOfDifficulty(int DegreeOfDifficulty) {
                this.DegreeOfDifficulty = DegreeOfDifficulty;
            }

            public String getQuestionTestTypeCode() {
                return QuestionTestTypeCode;
            }

            public void setQuestionTestTypeCode(String QuestionTestTypeCode) {
                this.QuestionTestTypeCode = QuestionTestTypeCode;
            }

            public String getAudioAccessoryCode() {
                return AudioAccessoryCode;
            }

            public void setAudioAccessoryCode(String AudioAccessoryCode) {
                this.AudioAccessoryCode = AudioAccessoryCode;
            }

            public String getTextDescribe() {
                return TextDescribe;
            }

            public void setTextDescribe(String TextDescribe) {
                this.TextDescribe = TextDescribe;
            }

            public String getCreateBy() {
                return CreateBy;
            }

            public void setCreateBy(String CreateBy) {
                this.CreateBy = CreateBy;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public String getModifyBy() {
                return ModifyBy;
            }

            public void setModifyBy(String ModifyBy) {
                this.ModifyBy = ModifyBy;
            }

            public String getModifyDate() {
                return ModifyDate;
            }

            public void setModifyDate(String ModifyDate) {
                this.ModifyDate = ModifyDate;
            }

            public List<OptionsBean> getOptions() {
                return options;
            }

            public void setOptions(List<OptionsBean> options) {
                this.options = options;
            }

            public static class OptionsBean {
                /**
                 * Code :
                 * QuestionCode :
                 * No : 1
                 * Content :
                 * Answer : send a messenger
                 * IsCorrect : false
                 * CreateBy : 管理员
                 * CreateDate : 2018-06-07T14:54:40.077
                 * ModifyBy :
                 * ModifyDate : 2018-06-07T14:54:40.077
                 */

                private String Code;
                private String QuestionCode;
                private String No;
                private String Content;
                private String Answer;
                private boolean IsCorrect;
                private String CreateBy;
                private String CreateDate;
                private String ModifyBy;
                private String ModifyDate;

                public String getCode() {
                    return Code;
                }

                public void setCode(String Code) {
                    this.Code = Code;
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

                public String getCreateBy() {
                    return CreateBy;
                }

                public void setCreateBy(String CreateBy) {
                    this.CreateBy = CreateBy;
                }

                public String getCreateDate() {
                    return CreateDate;
                }

                public void setCreateDate(String CreateDate) {
                    this.CreateDate = CreateDate;
                }

                public String getModifyBy() {
                    return ModifyBy;
                }

                public void setModifyBy(String ModifyBy) {
                    this.ModifyBy = ModifyBy;
                }

                public String getModifyDate() {
                    return ModifyDate;
                }

                public void setModifyDate(String ModifyDate) {
                    this.ModifyDate = ModifyDate;
                }
            }
        }
    }
}
