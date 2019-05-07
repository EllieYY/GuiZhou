package com.sk.gz.entity;

import java.io.Serializable;

/**
 * plant
 * @author 
 */
public class Plant implements Serializable {
    /**
     * 风机id
     */
    private Integer id;

    /**
     * 风机名称
     */
    private String name;

    /**
     * 风电厂id
     */
    private Integer stationid;

    /**
     * 额定功率
     */
    private Float powerrating;

    /**
     * 切入风速
     */
    private Float cutinwindspeed;

    /**
     * 切出风速
     */
    private Float cutoffwindspeed;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public Float getPowerrating() {
        return powerrating;
    }

    public void setPowerrating(Float powerrating) {
        this.powerrating = powerrating;
    }

    public Float getCutinwindspeed() {
        return cutinwindspeed;
    }

    public void setCutinwindspeed(Float cutinwindspeed) {
        this.cutinwindspeed = cutinwindspeed;
    }

    public Float getCutoffwindspeed() {
        return cutoffwindspeed;
    }

    public void setCutoffwindspeed(Float cutoffwindspeed) {
        this.cutoffwindspeed = cutoffwindspeed;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Plant other = (Plant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStationid() == null ? other.getStationid() == null : this.getStationid().equals(other.getStationid()))
            && (this.getPowerrating() == null ? other.getPowerrating() == null : this.getPowerrating().equals(other.getPowerrating()))
            && (this.getCutinwindspeed() == null ? other.getCutinwindspeed() == null : this.getCutinwindspeed().equals(other.getCutinwindspeed()))
            && (this.getCutoffwindspeed() == null ? other.getCutoffwindspeed() == null : this.getCutoffwindspeed().equals(other.getCutoffwindspeed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStationid() == null) ? 0 : getStationid().hashCode());
        result = prime * result + ((getPowerrating() == null) ? 0 : getPowerrating().hashCode());
        result = prime * result + ((getCutinwindspeed() == null) ? 0 : getCutinwindspeed().hashCode());
        result = prime * result + ((getCutoffwindspeed() == null) ? 0 : getCutoffwindspeed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", stationid=").append(stationid);
        sb.append(", powerrating=").append(powerrating);
        sb.append(", cutinwindspeed=").append(cutinwindspeed);
        sb.append(", cutoffwindspeed=").append(cutoffwindspeed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Plant(Integer id, String name, Integer stationid, Float powerrating, Float cutinwindspeed, Float cutoffwindspeed) {
        this.id = id;
        this.name = name;
        this.stationid = stationid;
        this.powerrating = powerrating;
        this.cutinwindspeed = cutinwindspeed;
        this.cutoffwindspeed = cutoffwindspeed;
    }
}