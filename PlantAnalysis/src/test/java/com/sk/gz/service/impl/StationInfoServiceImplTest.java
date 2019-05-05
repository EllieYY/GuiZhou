package com.sk.gz.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StationInfoServiceImplTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPowerInfoPerMonth() {
    }

    @Test
    public void getPreviewInfo() {
    }

    @Test
    public void getIndcators() {
    }

    @Test
    public void getPowerCurveById() {
    }

    @Test
    public void doCrossAnaysis() {
    }

    @Test
    public void powerCurveAnalysis() {
    }
}