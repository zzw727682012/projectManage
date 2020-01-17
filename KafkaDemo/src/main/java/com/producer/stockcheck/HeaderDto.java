package com.producer.stockcheck;



import lombok.Data;

/**
 * Author: Simple Zhou
 * <p>
 * Date: 2019/11/18
 * <p>
 * Description: ${DESCRIPTION}
 */

@Data
public class HeaderDto {
    private String status;

    private String expected;

    private String serviceName;

    @Override
    public String toString() {
        return "HeaderDto{" +
                "status='" + status + '\'' +
                ", expected='" + expected + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", handlerName='" + handlerName + '\'' +
                '}';
    }

    private String handlerName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }
}
