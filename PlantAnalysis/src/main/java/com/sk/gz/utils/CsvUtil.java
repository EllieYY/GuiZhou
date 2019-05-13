package com.sk.gz.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.sk.gz.aop.excption.ServiceException;

import java.beans.PropertyEditorManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : Ellie
 * @Date : 2019/4/28
 */
public class CsvUtil {
    /**
     * 解析csv文件并转成bean
     * @param filePath csv文件
     * @param clazz 类
     * @param <T> 泛型
     * @return 泛型bean集合
     */
    public static <T> List<T> getCsvData(String filePath, Class<T> clazz) {
        InputStreamReader in;
        try {
            InputStream inputStream = new FileInputStream(filePath);
            in = new InputStreamReader(inputStream, "utf-8");
        } catch (Exception e) {
            throw new ServiceException(e.toString());
        }

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(clazz);

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in)
                .withSeparator(',')
                .withQuoteChar('\'')
                .withMappingStrategy(strategy).build();
        return csvToBean.parse();
    }
}
