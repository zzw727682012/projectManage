package com.producer.internalmovement;
import java.util.Date;
import java.util.List;

public class InternalMovementContent {

    private String docType;
    private String uom;
    private String locationId;
    private String transactionTypeId;
    private Date creationDate;
    private String whsCode;
    private List<InternalMovementDocuments> documents;
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public String getDocType() {
        return docType;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
    public String getUom() {
        return uom;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    public String getLocationId() {
        return locationId;
    }

    public void setTransactionTypeId(String transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }
    public String getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }
    public String getWhsCode() {
        return whsCode;
    }

    public void setDocuments(List<InternalMovementDocuments> documents) {
        this.documents = documents;
    }
    public List<InternalMovementDocuments> getDocuments() {
        return documents;
    }

}