package com.sk.gz.service;

import java.util.Date;
import java.util.List;

public interface ScheduledService {
    void dataTransform(Date startTime, Date endTime, boolean isHis, String pathPrefix, int idBase);
    void scheduleTask();
}
