package com.sk.gz.entity;

import java.io.Serializable;

/**
 * quota_month
 * @author 
 */
public class QuotaMonth extends QuotaMonthKey implements Serializable {
    /**
     * 理论发电量
     */
    private Double academicpower;

    /**
     * 实际发电量
     */
    private Double actualpower;

    /**
     * 停机折减
     */
    private Double downtimereduction;

    /**
     * 限电折减
     */
    private Double limitreduction;

    /**
     * 其他折减
     */
    private Double otherreduction;

    /**
     * 停机时间 - 秒数
     */
    private Long downtime;

    /**
     * 当月有效天数
     */
    private Integer validdays;

    /**
     * 平均风速
     */
    private Float avgwindspeed;

    private static final long serialVersionUID = 1L;

    public Double getAcademicpower() {
        return academicpower;
    }

    public void setAcademicpower(Double academicpower) {
        this.academicpower = academicpower;
    }

    public Double getActualpower() {
        return actualpower;
    }

    public void setActualpower(Double actualpower) {
        this.actualpower = actualpower;
    }

    public Double getDowntimereduction() {
        return downtimereduction;
    }

    public void setDowntimereduction(Double downtimereduction) {
        this.downtimereduction = downtimereduction;
    }

    public Double getLimitreduction() {
        return limitreduction;
    }

    public void setLimitreduction(Double limitreduction) {
        this.limitreduction = limitreduction;
    }

    public Double getOtherreduction() {
        return otherreduction;
    }

    public void setOtherreduction(Double otherreduction) {
        this.otherreduction = otherreduction;
    }

    public Long getDowntime() {
        return downtime;
    }

    public void setDowntime(Long downtime) {
        this.downtime = downtime;
    }

    public Integer getValiddays() {
        return validdays;
    }

    public void setValiddays(Integer validdays) {
        this.validdays = validdays;
    }

    public Float getAvgwindspeed() {
        return avgwindspeed;
    }

    public void setAvgwindspeed(Float avgwindspeed) {
        this.avgwindspeed = avgwindspeed;
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
        QuotaMonth other = (QuotaMonth) that;
        return (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getPlantid() == null ? other.getPlantid() == null : this.getPlantid().equals(other.getPlantid()))
            && (this.getAcademicpower() == null ? other.getAcademicpower() == null : this.getAcademicpower().equals(other.getAcademicpower()))
            && (this.getActualpower() == null ? other.getActualpower() == null : this.getActualpower().equals(other.getActualpower()))
            && (this.getDowntimereduction() == null ? other.getDowntimereduction() == null : this.getDowntimereduction().equals(other.getDowntimereduction()))
            && (this.getLimitreduction() == null ? other.getLimitreduction() == null : this.getLimitreduction().equals(other.getLimitreduction()))
            && (this.getOtherreduction() == null ? other.getOtherreduction() == null : this.getOtherreduction().equals(other.getOtherreduction()))
            && (this.getDowntime() == null ? other.getDowntime() == null : this.getDowntime().equals(other.getDowntime()))
            && (this.getValiddays() == null ? other.getValiddays() == null : this.getValiddays().equals(other.getValiddays()))
            && (this.getAvgwindspeed() == null ? other.getAvgwindspeed() == null : this.getAvgwindspeed().equals(other.getAvgwindspeed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getPlantid() == null) ? 0 : getPlantid().hashCode());
        result = prime * result + ((getAcademicpower() == null) ? 0 : getAcademicpower().hashCode());
        result = prime * result + ((getActualpower() == null) ? 0 : getActualpower().hashCode());
        result = prime * result + ((getDowntimereduction() == null) ? 0 : getDowntimereduction().hashCode());
        result = prime * result + ((getLimitreduction() == null) ? 0 : getLimitreduction().hashCode());
        result = prime * result + ((getOtherreduction() == null) ? 0 : getOtherreduction().hashCode());
        result = prime * result + ((getDowntime() == null) ? 0 : getDowntime().hashCode());
        result = prime * result + ((getValiddays() == null) ? 0 : getValiddays().hashCode());
        result = prime * result + ((getAvgwindspeed() == null) ? 0 : getAvgwindspeed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", academicpower=").append(academicpower);
        sb.append(", actualpower=").append(actualpower);
        sb.append(", downtimereduction=").append(downtimereduction);
        sb.append(", limitreduction=").append(limitreduction);
        sb.append(", otherreduction=").append(otherreduction);
        sb.append(", downtime=").append(downtime);
        sb.append(", validdays=").append(validdays);
        sb.append(", avgwindspeed=").append(avgwindspeed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}