package com.sk.gz.model.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/5/9
 */
@Data
public class HisDataPrepareParam {
    @JsonProperty("sTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startTime;

    @JsonProperty("eTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;

    @JsonProperty("hisFlag")
    private boolean his;

    @JsonProperty("reTry")
    private boolean reTry;

    @JsonProperty("pathPrefix")
    private String pathPrefix;

    @JsonProperty("idBase")
    private int idBase;
}
