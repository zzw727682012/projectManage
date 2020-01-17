package com.producer.stockcheck;

public class Permission {
    private String inbound;
    private String putaway;
    private String moving;
    private String replenishment;
    private String picking;
    private String packing;
    private String loading;

    @Override
    public String toString() {
        return "Permission{" +
                "inbound='" + inbound + '\'' +
                ", putaway='" + putaway + '\'' +
                ", moving='" + moving + '\'' +
                ", replenishment='" + replenishment + '\'' +
                ", picking='" + picking + '\'' +
                ", packing='" + packing + '\'' +
                ", loading='" + loading + '\'' +
                ", shipment='" + shipment + '\'' +
                ", stocktaking='" + stocktaking + '\'' +
                ", mission='" + mission + '\'' +
                ", cycle_count='" + cycle_count + '\'' +
                '}';
    }

    public String getInbound() {
        return inbound;
    }

    public void setInbound(String inbound) {
        this.inbound = inbound;
    }

    public String getPutaway() {
        return putaway;
    }

    public void setPutaway(String putaway) {
        this.putaway = putaway;
    }

    public String getMoving() {
        return moving;
    }

    public void setMoving(String moving) {
        this.moving = moving;
    }

    public String getReplenishment() {
        return replenishment;
    }

    public void setReplenishment(String replenishment) {
        this.replenishment = replenishment;
    }

    public String getPicking() {
        return picking;
    }

    public void setPicking(String picking) {
        this.picking = picking;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getStocktaking() {
        return stocktaking;
    }

    public void setStocktaking(String stocktaking) {
        this.stocktaking = stocktaking;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getCycle_count() {
        return cycle_count;
    }

    public void setCycle_count(String cycle_count) {
        this.cycle_count = cycle_count;
    }

    private String shipment;
    private String stocktaking;
    private String mission;

    private String cycle_count;

}
