package data;

import java.util.List;

/**
 * Created by qupengcheng on 2018/10/18.
 */

public class MyOrderData {
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

        private String Code;
        private String UserCode;
        private int OrderStatusId;
        private int PaymentStatusId;
        private String OrderTotal;
        private String PayDate;
        private String CreateBy;
        private String CreateDate;
        private String ModifyBy;
        private String ModifyDate;
        private List<DetialsBean> Detials;

        public String getCode() {
            return Code;
        }

        public void setCode(String Code) {
            this.Code = Code;
        }

        public String getUserCode() {
            return UserCode;
        }

        public void setUserCode(String UserCode) {
            this.UserCode = UserCode;
        }

        public int getOrderStatusId() {
            return OrderStatusId;
        }

        public void setOrderStatusId(int OrderStatusId) {
            this.OrderStatusId = OrderStatusId;
        }

        public int getPaymentStatusId() {
            return PaymentStatusId;
        }

        public void setPaymentStatusId(int PaymentStatusId) {
            this.PaymentStatusId = PaymentStatusId;
        }

        public String getOrderTotal() {
            return OrderTotal;
        }

        public void setOrderTotal(String OrderTotal) {
            this.OrderTotal = OrderTotal;
        }

        public String getPayDate() {
            return PayDate;
        }

        public void setPayDate(String PayDate) {
            this.PayDate = PayDate;
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

        public List<DetialsBean> getDetials() {
            return Detials;
        }

        public void setDetials(List<DetialsBean> Detials) {
            this.Detials = Detials;
        }

        public static class DetialsBean {

            private String OrderCode;
            private String BuyDocumentCode;
            private int BuyDocumentCodeType;
            private String Summary;
            private String title;
            private String Price;
            private String Picture;

            public String getOrderCode() {
                return OrderCode;
            }

            public void setOrderCode(String OrderCode) {
                this.OrderCode = OrderCode;
            }

            public String getBuyDocumentCode() {
                return BuyDocumentCode;
            }

            public void setBuyDocumentCode(String BuyDocumentCode) {
                this.BuyDocumentCode = BuyDocumentCode;
            }

            public int getBuyDocumentCodeType() {
                return BuyDocumentCodeType;
            }

            public void setBuyDocumentCodeType(int BuyDocumentCodeType) {
                this.BuyDocumentCodeType = BuyDocumentCodeType;
            }

            public String getSummary() {
                return Summary;
            }

            public void setSummary(String Summary) {
                this.Summary = Summary;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return Price;
            }

            public void setPrice(String Price) {
                this.Price = Price;
            }

            public String getPicture() {
                return Picture;
            }

            public void setPicture(String Picture) {
                this.Picture = Picture;
            }
        }
    }
}
