package com.consumer;

import java.util.List;

public class Temp {

    /**
     * timestamp : 2020-03-31T10:28:05Z
     * messageId : D5BDB25E-01944C1E-70B1F6CD-30220C8A
     * sender : D1M-Shanghai
     * senderCountry : CN
     * schema : kering.toolkit.ReleaseOrder
     * schemaVersion : V2R1.17
     * brandCode : MQ
     * brand : AMQ
     * intendedReceiver : Cargo-Shanghai
     * content : {"orderType":"E","whsCode":"54176","purchaseOrder":"10000000922","capturedDate":"2020-03-31T10:28:05Z","carrierCode":"SF","confirmedDate":"2020-03-31T10:22:50Z","currencyCode":"CNY","customerEmail":"green_1234@qq.com","customerFirstName":"ff","customerLastName":"fd","customerPhone":"13333333333","deliveryNo":"20033100000002","orderId":10815,"orderSubTotal":"0.02","totalDiscounts":"0.00","IsCanceled":false,"note":[],"releaseId":"20033100000002","address":{"address1":"雅乐居酒店","address2":"","address3":"","city":"上海市","country":"","county":"黄浦区","email":"green_1234@qq.com","firstName":"ff","lastName":"fd","phone":"13333333333","postalCode":"","state":"上海市"},"releaseLine":[{"skuCode":"808594255","orderLineId":1,"releaseLineId":1,"quantity":"1","isDangerous":"false"}],"salesMomeType":"false"}
     */

    private String timestamp;
    private String messageId;
    private String sender;
    private String senderCountry;
    private String schema;
    private String schemaVersion;
    private String brandCode;
    private String brand;
    private String intendedReceiver;
    private ContentBean content;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIntendedReceiver() {
        return intendedReceiver;
    }

    public void setIntendedReceiver(String intendedReceiver) {
        this.intendedReceiver = intendedReceiver;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * orderType : E
         * whsCode : 54176
         * purchaseOrder : 10000000922
         * capturedDate : 2020-03-31T10:28:05Z
         * carrierCode : SF
         * confirmedDate : 2020-03-31T10:22:50Z
         * currencyCode : CNY
         * customerEmail : green_1234@qq.com
         * customerFirstName : ff
         * customerLastName : fd
         * customerPhone : 13333333333
         * deliveryNo : 20033100000002
         * orderId : 10815
         * orderSubTotal : 0.02
         * totalDiscounts : 0.00
         * IsCanceled : false
         * note : []
         * releaseId : 20033100000002
         * address : {"address1":"雅乐居酒店","address2":"","address3":"","city":"上海市","country":"","county":"黄浦区","email":"green_1234@qq.com","firstName":"ff","lastName":"fd","phone":"13333333333","postalCode":"","state":"上海市"}
         * releaseLine : [{"skuCode":"808594255","orderLineId":1,"releaseLineId":1,"quantity":"1","isDangerous":"false"}]
         * salesMomeType : false
         */

        private String orderType;
        private String whsCode;
        private String purchaseOrder;
        private String capturedDate;
        private String carrierCode;
        private String confirmedDate;
        private String currencyCode;
        private String customerEmail;
        private String customerFirstName;
        private String customerLastName;
        private String customerPhone;
        private String deliveryNo;
        private int orderId;
        private String orderSubTotal;
        private String totalDiscounts;
        private boolean IsCanceled;
        private String releaseId;
        private AddressBean address;
        private String salesMomeType;
        private List<?> note;
        private List<ReleaseLineBean> releaseLine;

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getWhsCode() {
            return whsCode;
        }

        public void setWhsCode(String whsCode) {
            this.whsCode = whsCode;
        }

        public String getPurchaseOrder() {
            return purchaseOrder;
        }

        public void setPurchaseOrder(String purchaseOrder) {
            this.purchaseOrder = purchaseOrder;
        }

        public String getCapturedDate() {
            return capturedDate;
        }

        public void setCapturedDate(String capturedDate) {
            this.capturedDate = capturedDate;
        }

        public String getCarrierCode() {
            return carrierCode;
        }

        public void setCarrierCode(String carrierCode) {
            this.carrierCode = carrierCode;
        }

        public String getConfirmedDate() {
            return confirmedDate;
        }

        public void setConfirmedDate(String confirmedDate) {
            this.confirmedDate = confirmedDate;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerFirstName() {
            return customerFirstName;
        }

        public void setCustomerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
        }

        public String getCustomerLastName() {
            return customerLastName;
        }

        public void setCustomerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getDeliveryNo() {
            return deliveryNo;
        }

        public void setDeliveryNo(String deliveryNo) {
            this.deliveryNo = deliveryNo;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getOrderSubTotal() {
            return orderSubTotal;
        }

        public void setOrderSubTotal(String orderSubTotal) {
            this.orderSubTotal = orderSubTotal;
        }

        public String getTotalDiscounts() {
            return totalDiscounts;
        }

        public void setTotalDiscounts(String totalDiscounts) {
            this.totalDiscounts = totalDiscounts;
        }

        public boolean isIsCanceled() {
            return IsCanceled;
        }

        public void setIsCanceled(boolean IsCanceled) {
            this.IsCanceled = IsCanceled;
        }

        public String getReleaseId() {
            return releaseId;
        }

        public void setReleaseId(String releaseId) {
            this.releaseId = releaseId;
        }

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public String getSalesMomeType() {
            return salesMomeType;
        }

        public void setSalesMomeType(String salesMomeType) {
            this.salesMomeType = salesMomeType;
        }

        public List<?> getNote() {
            return note;
        }

        public void setNote(List<?> note) {
            this.note = note;
        }

        public List<ReleaseLineBean> getReleaseLine() {
            return releaseLine;
        }

        public void setReleaseLine(List<ReleaseLineBean> releaseLine) {
            this.releaseLine = releaseLine;
        }

        public static class AddressBean {
            /**
             * address1 : 雅乐居酒店
             * address2 :
             * address3 :
             * city : 上海市
             * country :
             * county : 黄浦区
             * email : green_1234@qq.com
             * firstName : ff
             * lastName : fd
             * phone : 13333333333
             * postalCode :
             * state : 上海市
             */

            private String address1;
            private String address2;
            private String address3;
            private String city;
            private String country;
            private String county;
            private String email;
            private String firstName;
            private String lastName;
            private String phone;
            private String postalCode;
            private String state;

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getAddress2() {
                return address2;
            }

            public void setAddress2(String address2) {
                this.address2 = address2;
            }

            public String getAddress3() {
                return address3;
            }

            public void setAddress3(String address3) {
                this.address3 = address3;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPostalCode() {
                return postalCode;
            }

            public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }
        }

        public static class ReleaseLineBean {
            /**
             * skuCode : 808594255
             * orderLineId : 1
             * releaseLineId : 1
             * quantity : 1
             * isDangerous : false
             */

            private String skuCode;
            private int orderLineId;
            private int releaseLineId;
            private String quantity;
            private String isDangerous;

            public String getSkuCode() {
                return skuCode;
            }

            public void setSkuCode(String skuCode) {
                this.skuCode = skuCode;
            }

            public int getOrderLineId() {
                return orderLineId;
            }

            public void setOrderLineId(int orderLineId) {
                this.orderLineId = orderLineId;
            }

            public int getReleaseLineId() {
                return releaseLineId;
            }

            public void setReleaseLineId(int releaseLineId) {
                this.releaseLineId = releaseLineId;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }

            public String getIsDangerous() {
                return isDangerous;
            }

            public void setIsDangerous(String isDangerous) {
                this.isDangerous = isDangerous;
            }
        }
    }
}
