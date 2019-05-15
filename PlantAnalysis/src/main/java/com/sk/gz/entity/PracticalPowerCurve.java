package com.sk.gz.entity;

import java.io.Serializable;

/**
 * practical_power_curve
 * @author 
 */
public class PracticalPowerCurve implements Serializable {
    private Integer id;

    /**
     * 风速-区间（风速平均值）
     */
    private Float windspeed;

    /**
     * 对应风速区间的功率平均值
     */
    private Float power;

    /**
     * 风机类型 1-22MW
     */
    private Byte planttype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Float windspeed) {
        this.windspeed = windspeed;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Byte getPlanttype() {
        return planttype;
    }

    public void setPlanttype(Byte planttype) {
        this.planttype = planttype;
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
        PracticalPowerCurve other = (PracticalPowerCurve) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWindspeed() == null ? other.getWindspeed() == null : this.getWindspeed().equals(other.getWindspeed()))
            && (this.getPower() == null ? other.getPower() == null : this.getPower().equals(other.getPower()))
            && (this.getPlanttype() == null ? other.getPlanttype() == null : this.getPlanttype().equals(other.getPlanttype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWindspeed() == null) ? 0 : getWindspeed().hashCode());
        result = prime * result + ((getPower() == null) ? 0 : getPower().hashCode());
        result = prime * result + ((getPlanttype() == null) ? 0 : getPlanttype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", windspeed=").append(windspeed);
        sb.append(", power=").append(power);
        sb.append(", planttype=").append(planttype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}