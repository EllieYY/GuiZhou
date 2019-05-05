package com.sk.gz.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.io.Serializable;
import java.util.Date;

/**
 * plant_data_initial
 * @author 
 */
public class PlantDataInitial implements Serializable {
    /**
     * 数据时间
     */
   @CsvBindByName(column = "datetime")
   @CsvDate("yyyy/MM/dd_hh:mm:ss")
   private Date datatime;

    /**
     * 风机id
     */
   @CsvBindByName(column = "FanNo")
   private Integer plantid;

    /**
     * 发电状态 0-发电 1-待机 2-故障 3-检修 4-停机 5-离线
     */
   @CsvBindByName(column = "Stat")
   private Integer state;

    /**
     * 累计发电量
     */
   @CsvBindByName(column = "TotalPower")
   private Double totalpower;

    /**
     * 有功功率
     */
   @CsvBindByName(column = "GriPower")
   private Float gripower;

    /**
     * 无功功率
     */
   @CsvBindByName(column = "GriReaPower")
   private Float grireapower;

    /**
     * 风速
     */
   @CsvBindByName(column = "AmbWindSpeed")
   private Float ambwindspeed;

    /**
     * PLC状态
     */
   @CsvBindByName(column = "OpeStaInt")
   private Integer opestaint;

    /**
     * 叶轮转速
     */
   @CsvBindByName(column = "RotRPM")
   private Float rotrpm;

    /**
     * 风向
     */
   @CsvBindByName(column = "AmbWindDir")
   private Float ambwinddir;

    /**
     * 机舱温度
     */
   @CsvBindByName(column = "NacTem")
   private Float nactem;

    /**
     * 环境温度
     */
   @CsvBindByName(column = "AmbTem")
   private Float ambtem;

    /**
     * 故障码
     */
   @CsvBindByName(column = "EAAlarmNo")
   private Integer eaalarmno;

    /**
     * 电网A相电压
     */
   @CsvBindByName(column = "GriVolA")
   private Float grivola;

    /**
     * 电网B相电压
     */
   @CsvBindByName(column = "GriVolB")
   private Float grivolb;

    /**
     * 电网C相电压
     */
   @CsvBindByName(column = "GriVolC")
   private Float grivolc;

    /**
     * 电网A相电流
     */
   @CsvBindByName(column = "GriCurA")
   private Float gricura;

    /**
     * 电网B相电流
     */
   @CsvBindByName(column = "GriCurB")
   private Float gricurb;

    /**
     * 电网C相电流
     */
   @CsvBindByName(column = "GriCurC")
   private Float gricurc;

    /**
     * 电网频率
     */
   @CsvBindByName(column = "GriFre")
   private Float grifre;

    /**
     * 功率因数
     */
   @CsvBindByName(column = "GriCosPhi")
   private Float gricosphi;

    /**
     * 发电机转速
     */
   @CsvBindByName(column = "GenRPM")
   private Float genrpm;

    /**
     * 发电机绕组1温度
     */
   @CsvBindByName(column = "GenCoil1Tmp")
   private Float gencoil1tmp;

    /**
     * 发电机绕组2温度
     */
   @CsvBindByName(column = "GenCoil2Tmp")
   private Float gencoil2tmp;

    /**
     * 发电机绕组3温度
     */
   @CsvBindByName(column = "GenCoil3Tmp")
   private Float gencoil3tmp;

    /**
     * 发电机轴承1温度
     */
   @CsvBindByName(column = "GenBearTem1")
   private Float genbeartem1;

    /**
     * 发电机轴承2温度
     */
   @CsvBindByName(column = "GenBearTem2")
   private Float genbeartem2;

    /**
     * 电机驱动侧轴温
     */
   @CsvBindByName(column = "GenBeaDriTem")
   private Float genbeadritem;

    /**
     * 电机非驱动侧轴温
     */
   @CsvBindByName(column = "GenBeaNonTem")
   private Float genbeanontem;

    /**
     * 齿轮箱油温
     */
   @CsvBindByName(column = "GearOilTem")
   private Float gearoiltem;

    /**
     * 齿轮箱轴承1温度
     */
   @CsvBindByName(column = "GearBoxBTem1")
   private Float gearboxbtem1;

    /**
     * 齿轮箱轴承2温度
     */
   @CsvBindByName(column = "GearBoxBTem2")
   private Float gearboxbtem2;

    /**
     * 变桨角度
     */
   @CsvBindByName(column = "HubSpe")
   private Float hubspe;

    /**
     * 变桨角度2
     */
   @CsvBindByName(column = "HubPos2")
   private Float hubpos2;

    /**
     * 变桨角度3
     */
   @CsvBindByName(column = "HubPos3")
   private Float hubpos3;

    /**
     * 变浆电机1温度
     */
   @CsvBindByName(column = "HubMotTmp1")
   private Float hubmottmp1;

    /**
     * 变浆电机2温度
     */
   @CsvBindByName(column = "HubMotTmp2")
   private Float hubmottmp2;

    /**
     * 变浆电机3温度
     */
   @CsvBindByName(column = "HubMotTmp3")
   private Float hubmottmp3;

    /**
     * 偏航位置
     */
   @CsvBindByName(column = "YawPos")
   private Float yawpos;

    /**
     * 偏航状态
     */
   @CsvBindByName(column = "YawState")
   private Float yawstate;

    /**
     * 频器机侧IGBT温度
     */
   @CsvBindByName(column = "GenGbtTmp")
   private Float gengbttmp;

    /**
     * 频器网侧IGBT温度
     */
   @CsvBindByName(column = "GriTMP")
   private Float gritmp;

    private static final long serialVersionUID = 1L;

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

//    public String getDatatime() {
//        return datatime;
//    }
//
//    public void setDatatime(String datatime) {
//        this.datatime = datatime;
//    }

    public Integer getPlantid() {
        return plantid;
    }

    public void setPlantid(Integer plantid) {
        this.plantid = plantid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getTotalpower() {
        return totalpower;
    }

    public void setTotalpower(Double totalpower) {
        this.totalpower = totalpower;
    }

    public Float getGripower() {
        return gripower;
    }

    public void setGripower(Float gripower) {
        this.gripower = gripower;
    }

    public Float getGrireapower() {
        return grireapower;
    }

    public void setGrireapower(Float grireapower) {
        this.grireapower = grireapower;
    }

    public Float getAmbwindspeed() {
        return ambwindspeed;
    }

    public void setAmbwindspeed(Float ambwindspeed) {
        this.ambwindspeed = ambwindspeed;
    }

    public Integer getOpestaint() {
        return opestaint;
    }

    public void setOpestaint(Integer opestaint) {
        this.opestaint = opestaint;
    }

    public Float getRotrpm() {
        return rotrpm;
    }

    public void setRotrpm(Float rotrpm) {
        this.rotrpm = rotrpm;
    }

    public Float getAmbwinddir() {
        return ambwinddir;
    }

    public void setAmbwinddir(Float ambwinddir) {
        this.ambwinddir = ambwinddir;
    }

    public Float getNactem() {
        return nactem;
    }

    public void setNactem(Float nactem) {
        this.nactem = nactem;
    }

    public Float getAmbtem() {
        return ambtem;
    }

    public void setAmbtem(Float ambtem) {
        this.ambtem = ambtem;
    }

    public Integer getEaalarmno() {
        return eaalarmno;
    }

    public void setEaalarmno(Integer eaalarmno) {
        this.eaalarmno = eaalarmno;
    }

    public Float getGrivola() {
        return grivola;
    }

    public void setGrivola(Float grivola) {
        this.grivola = grivola;
    }

    public Float getGrivolb() {
        return grivolb;
    }

    public void setGrivolb(Float grivolb) {
        this.grivolb = grivolb;
    }

    public Float getGrivolc() {
        return grivolc;
    }

    public void setGrivolc(Float grivolc) {
        this.grivolc = grivolc;
    }

    public Float getGricura() {
        return gricura;
    }

    public void setGricura(Float gricura) {
        this.gricura = gricura;
    }

    public Float getGricurb() {
        return gricurb;
    }

    public void setGricurb(Float gricurb) {
        this.gricurb = gricurb;
    }

    public Float getGricurc() {
        return gricurc;
    }

    public void setGricurc(Float gricurc) {
        this.gricurc = gricurc;
    }

    public Float getGrifre() {
        return grifre;
    }

    public void setGrifre(Float grifre) {
        this.grifre = grifre;
    }

    public Float getGricosphi() {
        return gricosphi;
    }

    public void setGricosphi(Float gricosphi) {
        this.gricosphi = gricosphi;
    }

    public Float getGenrpm() {
        return genrpm;
    }

    public void setGenrpm(Float genrpm) {
        this.genrpm = genrpm;
    }

    public Float getGencoil1tmp() {
        return gencoil1tmp;
    }

    public void setGencoil1tmp(Float gencoil1tmp) {
        this.gencoil1tmp = gencoil1tmp;
    }

    public Float getGencoil2tmp() {
        return gencoil2tmp;
    }

    public void setGencoil2tmp(Float gencoil2tmp) {
        this.gencoil2tmp = gencoil2tmp;
    }

    public Float getGencoil3tmp() {
        return gencoil3tmp;
    }

    public void setGencoil3tmp(Float gencoil3tmp) {
        this.gencoil3tmp = gencoil3tmp;
    }

    public Float getGenbeartem1() {
        return genbeartem1;
    }

    public void setGenbeartem1(Float genbeartem1) {
        this.genbeartem1 = genbeartem1;
    }

    public Float getGenbeartem2() {
        return genbeartem2;
    }

    public void setGenbeartem2(Float genbeartem2) {
        this.genbeartem2 = genbeartem2;
    }

    public Float getGenbeadritem() {
        return genbeadritem;
    }

    public void setGenbeadritem(Float genbeadritem) {
        this.genbeadritem = genbeadritem;
    }

    public Float getGenbeanontem() {
        return genbeanontem;
    }

    public void setGenbeanontem(Float genbeanontem) {
        this.genbeanontem = genbeanontem;
    }

    public Float getGearoiltem() {
        return gearoiltem;
    }

    public void setGearoiltem(Float gearoiltem) {
        this.gearoiltem = gearoiltem;
    }

    public Float getGearboxbtem1() {
        return gearboxbtem1;
    }

    public void setGearboxbtem1(Float gearboxbtem1) {
        this.gearboxbtem1 = gearboxbtem1;
    }

    public Float getGearboxbtem2() {
        return gearboxbtem2;
    }

    public void setGearboxbtem2(Float gearboxbtem2) {
        this.gearboxbtem2 = gearboxbtem2;
    }

    public Float getHubspe() {
        return hubspe;
    }

    public void setHubspe(Float hubspe) {
        this.hubspe = hubspe;
    }

    public Float getHubpos2() {
        return hubpos2;
    }

    public void setHubpos2(Float hubpos2) {
        this.hubpos2 = hubpos2;
    }

    public Float getHubpos3() {
        return hubpos3;
    }

    public void setHubpos3(Float hubpos3) {
        this.hubpos3 = hubpos3;
    }

    public Float getHubmottmp1() {
        return hubmottmp1;
    }

    public void setHubmottmp1(Float hubmottmp1) {
        this.hubmottmp1 = hubmottmp1;
    }

    public Float getHubmottmp2() {
        return hubmottmp2;
    }

    public void setHubmottmp2(Float hubmottmp2) {
        this.hubmottmp2 = hubmottmp2;
    }

    public Float getHubmottmp3() {
        return hubmottmp3;
    }

    public void setHubmottmp3(Float hubmottmp3) {
        this.hubmottmp3 = hubmottmp3;
    }

    public Float getYawpos() {
        return yawpos;
    }

    public void setYawpos(Float yawpos) {
        this.yawpos = yawpos;
    }

    public Float getYawstate() {
        return yawstate;
    }

    public void setYawstate(Float yawstate) {
        this.yawstate = yawstate;
    }

    public Float getGengbttmp() {
        return gengbttmp;
    }

    public void setGengbttmp(Float gengbttmp) {
        this.gengbttmp = gengbttmp;
    }

    public Float getGritmp() {
        return gritmp;
    }

    public void setGritmp(Float gritmp) {
        this.gritmp = gritmp;
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
        PlantDataInitial other = (PlantDataInitial) that;
        return (this.getDatatime() == null ? other.getDatatime() == null : this.getDatatime().equals(other.getDatatime()))
            && (this.getPlantid() == null ? other.getPlantid() == null : this.getPlantid().equals(other.getPlantid()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getTotalpower() == null ? other.getTotalpower() == null : this.getTotalpower().equals(other.getTotalpower()))
            && (this.getGripower() == null ? other.getGripower() == null : this.getGripower().equals(other.getGripower()))
            && (this.getGrireapower() == null ? other.getGrireapower() == null : this.getGrireapower().equals(other.getGrireapower()))
            && (this.getAmbwindspeed() == null ? other.getAmbwindspeed() == null : this.getAmbwindspeed().equals(other.getAmbwindspeed()))
            && (this.getOpestaint() == null ? other.getOpestaint() == null : this.getOpestaint().equals(other.getOpestaint()))
            && (this.getRotrpm() == null ? other.getRotrpm() == null : this.getRotrpm().equals(other.getRotrpm()))
            && (this.getAmbwinddir() == null ? other.getAmbwinddir() == null : this.getAmbwinddir().equals(other.getAmbwinddir()))
            && (this.getNactem() == null ? other.getNactem() == null : this.getNactem().equals(other.getNactem()))
            && (this.getAmbtem() == null ? other.getAmbtem() == null : this.getAmbtem().equals(other.getAmbtem()))
            && (this.getEaalarmno() == null ? other.getEaalarmno() == null : this.getEaalarmno().equals(other.getEaalarmno()))
            && (this.getGrivola() == null ? other.getGrivola() == null : this.getGrivola().equals(other.getGrivola()))
            && (this.getGrivolb() == null ? other.getGrivolb() == null : this.getGrivolb().equals(other.getGrivolb()))
            && (this.getGrivolc() == null ? other.getGrivolc() == null : this.getGrivolc().equals(other.getGrivolc()))
            && (this.getGricura() == null ? other.getGricura() == null : this.getGricura().equals(other.getGricura()))
            && (this.getGricurb() == null ? other.getGricurb() == null : this.getGricurb().equals(other.getGricurb()))
            && (this.getGricurc() == null ? other.getGricurc() == null : this.getGricurc().equals(other.getGricurc()))
            && (this.getGrifre() == null ? other.getGrifre() == null : this.getGrifre().equals(other.getGrifre()))
            && (this.getGricosphi() == null ? other.getGricosphi() == null : this.getGricosphi().equals(other.getGricosphi()))
            && (this.getGenrpm() == null ? other.getGenrpm() == null : this.getGenrpm().equals(other.getGenrpm()))
            && (this.getGencoil1tmp() == null ? other.getGencoil1tmp() == null : this.getGencoil1tmp().equals(other.getGencoil1tmp()))
            && (this.getGencoil2tmp() == null ? other.getGencoil2tmp() == null : this.getGencoil2tmp().equals(other.getGencoil2tmp()))
            && (this.getGencoil3tmp() == null ? other.getGencoil3tmp() == null : this.getGencoil3tmp().equals(other.getGencoil3tmp()))
            && (this.getGenbeartem1() == null ? other.getGenbeartem1() == null : this.getGenbeartem1().equals(other.getGenbeartem1()))
            && (this.getGenbeartem2() == null ? other.getGenbeartem2() == null : this.getGenbeartem2().equals(other.getGenbeartem2()))
            && (this.getGenbeadritem() == null ? other.getGenbeadritem() == null : this.getGenbeadritem().equals(other.getGenbeadritem()))
            && (this.getGenbeanontem() == null ? other.getGenbeanontem() == null : this.getGenbeanontem().equals(other.getGenbeanontem()))
            && (this.getGearoiltem() == null ? other.getGearoiltem() == null : this.getGearoiltem().equals(other.getGearoiltem()))
            && (this.getGearboxbtem1() == null ? other.getGearboxbtem1() == null : this.getGearboxbtem1().equals(other.getGearboxbtem1()))
            && (this.getGearboxbtem2() == null ? other.getGearboxbtem2() == null : this.getGearboxbtem2().equals(other.getGearboxbtem2()))
            && (this.getHubspe() == null ? other.getHubspe() == null : this.getHubspe().equals(other.getHubspe()))
            && (this.getHubpos2() == null ? other.getHubpos2() == null : this.getHubpos2().equals(other.getHubpos2()))
            && (this.getHubpos3() == null ? other.getHubpos3() == null : this.getHubpos3().equals(other.getHubpos3()))
            && (this.getHubmottmp1() == null ? other.getHubmottmp1() == null : this.getHubmottmp1().equals(other.getHubmottmp1()))
            && (this.getHubmottmp2() == null ? other.getHubmottmp2() == null : this.getHubmottmp2().equals(other.getHubmottmp2()))
            && (this.getHubmottmp3() == null ? other.getHubmottmp3() == null : this.getHubmottmp3().equals(other.getHubmottmp3()))
            && (this.getYawpos() == null ? other.getYawpos() == null : this.getYawpos().equals(other.getYawpos()))
            && (this.getYawstate() == null ? other.getYawstate() == null : this.getYawstate().equals(other.getYawstate()))
            && (this.getGengbttmp() == null ? other.getGengbttmp() == null : this.getGengbttmp().equals(other.getGengbttmp()))
            && (this.getGritmp() == null ? other.getGritmp() == null : this.getGritmp().equals(other.getGritmp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDatatime() == null) ? 0 : getDatatime().hashCode());
        result = prime * result + ((getPlantid() == null) ? 0 : getPlantid().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getTotalpower() == null) ? 0 : getTotalpower().hashCode());
        result = prime * result + ((getGripower() == null) ? 0 : getGripower().hashCode());
        result = prime * result + ((getGrireapower() == null) ? 0 : getGrireapower().hashCode());
        result = prime * result + ((getAmbwindspeed() == null) ? 0 : getAmbwindspeed().hashCode());
        result = prime * result + ((getOpestaint() == null) ? 0 : getOpestaint().hashCode());
        result = prime * result + ((getRotrpm() == null) ? 0 : getRotrpm().hashCode());
        result = prime * result + ((getAmbwinddir() == null) ? 0 : getAmbwinddir().hashCode());
        result = prime * result + ((getNactem() == null) ? 0 : getNactem().hashCode());
        result = prime * result + ((getAmbtem() == null) ? 0 : getAmbtem().hashCode());
        result = prime * result + ((getEaalarmno() == null) ? 0 : getEaalarmno().hashCode());
        result = prime * result + ((getGrivola() == null) ? 0 : getGrivola().hashCode());
        result = prime * result + ((getGrivolb() == null) ? 0 : getGrivolb().hashCode());
        result = prime * result + ((getGrivolc() == null) ? 0 : getGrivolc().hashCode());
        result = prime * result + ((getGricura() == null) ? 0 : getGricura().hashCode());
        result = prime * result + ((getGricurb() == null) ? 0 : getGricurb().hashCode());
        result = prime * result + ((getGricurc() == null) ? 0 : getGricurc().hashCode());
        result = prime * result + ((getGrifre() == null) ? 0 : getGrifre().hashCode());
        result = prime * result + ((getGricosphi() == null) ? 0 : getGricosphi().hashCode());
        result = prime * result + ((getGenrpm() == null) ? 0 : getGenrpm().hashCode());
        result = prime * result + ((getGencoil1tmp() == null) ? 0 : getGencoil1tmp().hashCode());
        result = prime * result + ((getGencoil2tmp() == null) ? 0 : getGencoil2tmp().hashCode());
        result = prime * result + ((getGencoil3tmp() == null) ? 0 : getGencoil3tmp().hashCode());
        result = prime * result + ((getGenbeartem1() == null) ? 0 : getGenbeartem1().hashCode());
        result = prime * result + ((getGenbeartem2() == null) ? 0 : getGenbeartem2().hashCode());
        result = prime * result + ((getGenbeadritem() == null) ? 0 : getGenbeadritem().hashCode());
        result = prime * result + ((getGenbeanontem() == null) ? 0 : getGenbeanontem().hashCode());
        result = prime * result + ((getGearoiltem() == null) ? 0 : getGearoiltem().hashCode());
        result = prime * result + ((getGearboxbtem1() == null) ? 0 : getGearboxbtem1().hashCode());
        result = prime * result + ((getGearboxbtem2() == null) ? 0 : getGearboxbtem2().hashCode());
        result = prime * result + ((getHubspe() == null) ? 0 : getHubspe().hashCode());
        result = prime * result + ((getHubpos2() == null) ? 0 : getHubpos2().hashCode());
        result = prime * result + ((getHubpos3() == null) ? 0 : getHubpos3().hashCode());
        result = prime * result + ((getHubmottmp1() == null) ? 0 : getHubmottmp1().hashCode());
        result = prime * result + ((getHubmottmp2() == null) ? 0 : getHubmottmp2().hashCode());
        result = prime * result + ((getHubmottmp3() == null) ? 0 : getHubmottmp3().hashCode());
        result = prime * result + ((getYawpos() == null) ? 0 : getYawpos().hashCode());
        result = prime * result + ((getYawstate() == null) ? 0 : getYawstate().hashCode());
        result = prime * result + ((getGengbttmp() == null) ? 0 : getGengbttmp().hashCode());
        result = prime * result + ((getGritmp() == null) ? 0 : getGritmp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("datatime=").append(datatime);
        sb.append(", plantid=").append(plantid);
        sb.append(", state=").append(state);
        sb.append(", totalpower=").append(totalpower);
        sb.append(", gripower=").append(gripower);
        sb.append(", grireapower=").append(grireapower);
        sb.append(", ambwindspeed=").append(ambwindspeed);
        sb.append(", opestaint=").append(opestaint);
        sb.append(", rotrpm=").append(rotrpm);
        sb.append(", ambwinddir=").append(ambwinddir);
        sb.append(", nactem=").append(nactem);
        sb.append(", ambtem=").append(ambtem);
        sb.append(", eaalarmno=").append(eaalarmno);
        sb.append(", grivola=").append(grivola);
        sb.append(", grivolb=").append(grivolb);
        sb.append(", grivolc=").append(grivolc);
        sb.append(", gricura=").append(gricura);
        sb.append(", gricurb=").append(gricurb);
        sb.append(", gricurc=").append(gricurc);
        sb.append(", grifre=").append(grifre);
        sb.append(", gricosphi=").append(gricosphi);
        sb.append(", genrpm=").append(genrpm);
        sb.append(", gencoil1tmp=").append(gencoil1tmp);
        sb.append(", gencoil2tmp=").append(gencoil2tmp);
        sb.append(", gencoil3tmp=").append(gencoil3tmp);
        sb.append(", genbeartem1=").append(genbeartem1);
        sb.append(", genbeartem2=").append(genbeartem2);
        sb.append(", genbeadritem=").append(genbeadritem);
        sb.append(", genbeanontem=").append(genbeanontem);
        sb.append(", gearoiltem=").append(gearoiltem);
        sb.append(", gearboxbtem1=").append(gearboxbtem1);
        sb.append(", gearboxbtem2=").append(gearboxbtem2);
        sb.append(", hubspe=").append(hubspe);
        sb.append(", hubpos2=").append(hubpos2);
        sb.append(", hubpos3=").append(hubpos3);
        sb.append(", hubmottmp1=").append(hubmottmp1);
        sb.append(", hubmottmp2=").append(hubmottmp2);
        sb.append(", hubmottmp3=").append(hubmottmp3);
        sb.append(", yawpos=").append(yawpos);
        sb.append(", yawstate=").append(yawstate);
        sb.append(", gengbttmp=").append(gengbttmp);
        sb.append(", gritmp=").append(gritmp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}