package com.sk.gz.entity;

import java.io.Serializable;

/**
 * quota_month
 * @author 
 */
public class QuotaMonth extends QuotaMonthKey implements Serializable {
    /**
     * 实际发电量
     */
    private Double powergeneration;

    /**
     * 停机折减
     */
    private Double downtimereducation;

    /**
     * 限电折减
     */
    private Double powerreducation;

    /**
     * 其他折减
     */
    private Double otherreducation;

    /**
     * 停机时间 - 秒数
     */
    private Long downtime;

    private static final long serialVersionUID = 1L;

    public Double getPowergeneration() {
        return powergeneration;
    }

    public void setPowergeneration(Double powergeneration) {
        this.powergeneration = powergeneration;
    }

    public Double getDowntimereducation() {
        return downtimereducation;
    }

    public void setDowntimereducation(Double downtimereducation) {
        this.downtimereducation = downtimereducation;
    }

    public Double getPowerreducation() {
        return powerreducation;
    }

    public void setPowerreducation(Double powerreducation) {
        this.powerreducation = powerreducation;
    }

    public Double getOtherreducation() {
        return otherreducation;
    }

    public void setOtherreducation(Double otherreducation) {
        this.otherreducation = otherreducation;
    }

    public Long getDowntime() {
        return downtime;
    }

    public void setDowntime(Long downtime) {
        this.downtime = downtime;
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
            && (this.getPowergeneration() == null ? other.getPowergeneration() == null : this.getPowergeneration().equals(other.getPowergeneration()))
            && (this.getDowntimereducation() == null ? other.getDowntimereducation() == null : this.getDowntimereducation().equals(other.getDowntimereducation()))
            && (this.getPowerreducation() == null ? other.getPowerreducation() == null : this.getPowerreducation().equals(other.getPowerreducation()))
            && (this.getOtherreducation() == null ? other.getOtherreducation() == null : this.getOtherreducation().equals(other.getOtherreducation()))
            && (this.getDowntime() == null ? other.getDowntime() == null : this.getDowntime().equals(other.getDowntime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getPlantid() == null) ? 0 : getPlantid().hashCode());
        result = prime * result + ((getPowergeneration() == null) ? 0 : getPowergeneration().hashCode());
        result = prime * result + ((getDowntimereducation() == null) ? 0 : getDowntimereducation().hashCode());
        result = prime * result + ((getPowerreducation() == null) ? 0 : getPowerreducation().hashCode());
        result = prime * result + ((getOtherreducation() == null) ? 0 : getOtherreducation().hashCode());
        result = prime * result + ((getDowntime() == null) ? 0 : getDowntime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", powergeneration=").append(powergeneration);
        sb.append(", downtimereducation=").append(downtimereducation);
        sb.append(", powerreducation=").append(powerreducation);
        sb.append(", otherreducation=").append(otherreducation);
        sb.append(", downtime=").append(downtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}