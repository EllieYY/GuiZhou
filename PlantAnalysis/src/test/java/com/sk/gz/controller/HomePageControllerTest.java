package com.sk.gz.controller;

import com.sk.gz.model.power.StationIndicators;
import com.sk.gz.model.result.ResultBean;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPlantQuotas() {
        ResultBean<List<StationIndicators>> response = restTemplate.postForObject("/station/indicators", null, ResultBean.class);
        System.out.println(response);
        Assertions.assertThat(response.getData().size()).isEqualTo(5);
    }
}