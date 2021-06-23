package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.service.esClient.EsClientService;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EsClientTests {
    private static final Logger logger = LoggerFactory.getLogger(EsClientTests.class);
    @Resource
    private EsClientService esClientService;

    @Test
    public void indexExist(){
        Boolean result=esClientService.existIndex("book");
        logger.error(result+"");
    }

    @Test
    public void analyzeTest(){
        List<String> results=esClientService.analyzeSentence("这是一个分词测试");
        System.out.println(JSON.toJSONString(results));
    }
}
