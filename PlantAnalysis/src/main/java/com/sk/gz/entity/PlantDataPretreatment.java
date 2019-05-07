package com.sk.gz.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * plant_data_pretreatment
 * @author 
 */
@AllArgsConstructor
@NoArgsConstructor
public class PlantDataPretreatment extends PlantDataPretreatmentKey implements Serializable {
    /**
     * 时间区间秒数
     */
    private Long duration;

    /**
     * 数据状态。0-正常 1-无效 2-停机 3-限电 4-欠发 5-超发
     */
    private Integer state;

    /**
     * 发电状态 0-发电 1-待机 2-故障 3-检修 4-停机 5-离线
     */
    private Integer powerstate;

    /**
     * 应发电量
     */
    private Float estimatepower;

    /**
     * 折减电量
     */
    private Float reductivepower;

    /**
     * 实际发电量
     */
    private Float actualpower;

    /**
     * 风速
     */
    private Float ambwindspeed;

    /**
     * 有功功率
     */
    private Float gripower;

    /**
     * 发电机转速
     */
    private Float genrpm;

    /**
     * 风向
     */
    private Float ambwinddir;

    /**
     * 平均桨叶角度
     */
    private Float bladeangle;

    private static final long serialVersionUID = 1L;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPowerstate() {
        return powerstate;
    }

    public void setPowerstate(Integer powerstate) {
        this.powerstate = powerstate;
    }

    public Float getEstimatepower() {
        return estimatepower;
    }

    public void setEstimatepower(Float estimatepower) {
        this.estimatepower = estimatepower;
    }

    public Float getReductivepower() {
        return reductivepower;
    }

    public void setReductivepower(Float reductivepower) {
        this.reductivepower = reductivepower;
    }

    public Float getActualpower() {
        return actualpower;
    }

    public void setActualpower(Float actualpower) {
        this.actualpower = actualpower;
    }

    public Float getAmbwindspeed() {
        return ambwindspeed;
    }

    public void setAmbwindspeed(Float ambwindspeed) {
        this.ambwindspeed = ambwindspeed;
    }

    public Float getGripower() {
        return gripower;
    }

    public void setGripower(Float gripower) {
        this.gripower = gripower;
    }

    public Float getGenrpm() {
        return genrpm;
    }

    public void setGenrpm(Float genrpm) {
        this.genrpm = genrpm;
    }

    public Float getAmbwinddir() {
        return ambwinddir;
    }

    public void setAmbwinddir(Float ambwinddir) {
        this.ambwinddir = ambwinddir;
    }

    public Float getBladeangle() {
        return bladeangle;
    }

    public void setBladeangle(Float bladeangle) {
        this.bladeangle = bladeangle;
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
        PlantDataPretreatment other = (PlantDataPretreatment) that;
        return (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getPlantid() == null ? other.getPlantid() == null : this.getPlantid().equals(other.getPlantid()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getPowerstate() == null ? other.getPowerstate() == null : this.getPowerstate().equals(other.getPowerstate()))
            && (this.getEstimatepower() == null ? other.getEstimatepower() == null : this.getEstimatepower().equals(other.getEstimatepower()))
            && (this.getReductivepower() == null ? other.getReductivepower() == null : this.getReductivepower().equals(other.getReductivepower()))
            && (this.getActualpower() == null ? other.getActualpower() == null : this.getActualpower().equals(other.getActualpower()))
            && (this.getAmbwindspeed() == null ? other.getAmbwindspeed() == null : this.getAmbwindspeed().equals(other.getAmbwindspeed()))
            && (this.getGripower() == null ? other.getGripower() == null : this.getGripower().equals(other.getGripower()))
            && (this.getGenrpm() == null ? other.getGenrpm() == null : this.getGenrpm().equals(other.getGenrpm()))
            && (this.getAmbwinddir() == null ? other.getAmbwinddir() == null : this.getAmbwinddir().equals(other.getAmbwinddir()))
            && (this.getBladeangle() == null ? other.getBladeangle() == null : this.getBladeangle().equals(other.getBladeangle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getPlantid() == null) ? 0 : getPlantid().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getPowerstate() == null) ? 0 : getPowerstate().hashCode());
        result = prime * result + ((getEstimatepower() == null) ? 0 : getEstimatepower().hashCode());
        result = prime * result + ((getReductivepower() == null) ? 0 : getReductivepower().hashCode());
        result = prime * result + ((getActualpower() == null) ? 0 : getActualpower().hashCode());
        result = prime * result + ((getAmbwindspeed() == null) ? 0 : getAmbwindspeed().hashCode());
        result = prime * result + ((getGripower() == null) ? 0 : getGripower().hashCode());
        result = prime * result + ((getGenrpm() == null) ? 0 : getGenrpm().hashCode());
        result = prime * result + ((getAmbwinddir() == null) ? 0 : getAmbwinddir().hashCode());
        result = prime * result + ((getBladeangle() == null) ? 0 : getBladeangle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", time=").append(super.getTime());
        sb.append(", plantid=").append(super.getPlantid());
        sb.append(", duration=").append(duration);
        sb.append(", state=").append(state);
        sb.append(", powerstate=").append(powerstate);
        sb.append(", estimatepower=").append(estimatepower);
        sb.append(", reductivepower=").append(reductivepower);
        sb.append(", actualpower=").append(actualpower);
        sb.append(", ambwindspeed=").append(ambwindspeed);
        sb.append(", gripower=").append(gripower);
        sb.append(", genrpm=").append(genrpm);
        sb.append(", ambwinddir=").append(ambwinddir);
        sb.append(", bladeangle=").append(bladeangle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}