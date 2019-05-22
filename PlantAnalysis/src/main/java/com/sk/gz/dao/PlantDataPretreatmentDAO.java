package com.sk.gz.dao;

import com.sk.gz.entity.PlantDataPretreatment;
import com.sk.gz.entity.PlantDataPretreatmentKey;
import com.sk.gz.model.converter.DataTypeParam;
import com.sk.gz.model.converter.MonthQuotaParam;
import com.sk.gz.model.converter.RangeParam;
import com.sk.gz.model.curve.CrossPoint;
import com.sk.gz.model.curve.CurvePoint;
import com.sk.gz.model.curve.HistogramPoint;
import com.sk.gz.model.curve.SourcePoint;
import com.sk.gz.model.curve.StateStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * PlantDataPretreatmentDAO继承基类
 */
@Repository
public interface PlantDataPretreatmentDAO extends MyBatisBaseDao<PlantDataPretreatment, PlantDataPretreatmentKey> {
    int batchInsert(List<PlantDataPretreatment> data);

    float findMaxByColumn(@Param("column") String column, @Param("plantId") int plantId);
    float findMinByColumn(@Param("column") String column, @Param("plantId") int plantId);

    List<Float> findByColumnAndRange(RangeParam param);

    void updateStateByRange(RangeParam param);

    CurvePoint findAvgByColumnAndRange(RangeParam param);

    void updatePower(@Param("plantId") int plantId,
                     @Param("sTime") Date sTime,
                     @Param("eTime") Date eTime,
                     @Param("maxThre") float maxThreshold);

    void powerStatistic(MonthQuotaParam param);

    StateStatistics findStateStatisticsByPlantId(@Param("plantId") int id, @Param("dataType") DataTypeParam param);

    List<SourcePoint> findSourceData(@Param("plantId") int plantId);

    List<CrossPoint> findSourceDataByColumn(@Param("plantId") int plantId,
                                            @Param("xColumn") String xColumn,
                                            @Param("yColumn") String yColumn);

    List<HistogramPoint> findHistogramByColumn(@Param("plantId") int plantId,
                                               @Param("xColumn") String column,
                                               @Param("scaleV") double scale,
                                               @Param("validState") int valideState);

    List<CurvePoint> findCurvePointByTime(@Param("plantId") int plantId,
                                          @Param("scaleV") float scale,
                                          @Param("sTime") Date sTime,
                                          @Param("eTime") Date eTime,
                                          @Param("validState") int valideState);
}