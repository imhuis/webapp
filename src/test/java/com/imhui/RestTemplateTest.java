package com.imhui;

import com.google.gson.JsonObject;
import com.imhui.domain.Coffee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/servlet.xml"})
public class RestTemplateTest {

    private final Logger logger = LoggerFactory.getLogger(RestTemplateTest.class);

    /**
     * 构造uri
     */
//    URI uriA = UriComponentsBuilder
//            .fromUriString("http://example.com/hotels/{hotel}")
//            .queryParam("hotel", 1)
//            .encode()
//            .buildAndExpand()
//            .toUri();

//    URI uriB = UriComponentsBuilder
//            .fromUriString("http://example.com/hotels/{hotel}")
//            .build("hotel", 1);

    // 构造对于当前请求的url
//    ServletUriComponentsBuilder servletUriComponentsBuilder;

    // 构造指向controller的url
//    UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodCall(null).buildAndExpand();

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getTest(){
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:61261/coffee/{id}")
                .build(1);

        ResponseEntity<Coffee> responseEntity = restTemplate.getForEntity(uri, Coffee.class);
        logger.info("status: {}, headers: {}", responseEntity.getStatusCode(), responseEntity.getHeaders());

        String s = restTemplate.getForObject("http://localhost:61261/coffee/", String.class);
        logger.info("s: {}", s);

    }

    @Test
    public void postTest(){
        Coffee request = new Coffee("Americano1", BigDecimal.valueOf(25.00), new Date(), new Date());
        Coffee response = restTemplate.postForObject("http://localhost:61261/coffee/", request, Coffee.class);
        logger.info("new Coffee: {}", response);
    }

    /**
     * exchange只返回responseEntity类型
     */
    @Test
    public void exchangeTest(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        URI uri = UriComponentsBuilder.fromUriString("http://example.com/hotels/{hotel}").build(1);
        RequestEntity<Void> requestEntity = RequestEntity
                .get(uri)
                .header("Authorization","token")
                .accept(MediaType.APPLICATION_JSON)
                .build();
        // .exchange("url", HttpMethod.POST, httpEntity, String.class)
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

    }

    // StdDeserializer StdSerializer 类型转换

    public void exchangeListTest(){
        ParameterizedTypeReference<List<Coffee>> ptr = new ParameterizedTypeReference<List<Coffee>>() {};
        ResponseEntity<List<Coffee>> responseEntity = restTemplate.exchange("url", HttpMethod.GET, null, ptr);
        // 解决泛型擦除
        responseEntity.getBody();
    }

    @Test
    public void uploadFile(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        // load files
        FileSystemResource resource1 = new FileSystemResource("");
        FileSystemResource resource2 = new FileSystemResource("");
        MultiValueMap<String,Object> form = new LinkedMultiValueMap<>();
        form.add("file1", resource1);
        form.add("file2", resource2);
        HttpEntity<MultiValueMap<String,Object>> requestEntity = new HttpEntity<>(form, httpHeaders);
        restTemplate.postForObject("url", requestEntity, JsonObject.class);
    }

    @Test
    public void downloadFile(){
        byte[] file = restTemplate.getForObject("url", byte[].class);
        InputStream inputStream = new ByteArrayInputStream(file);
    }

    @Test
    public void buildUri(){
        List<String> stringList = new LinkedList<>();
        stringList.add("abc");
        URI uriA = UriComponentsBuilder
                .fromUriString("http://localhost/coffee/")
                .port(61261)
                .queryParam("name", "abc")
                .build()
                .toUri();
        logger.info("uriA: {}", uriA);

        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("name","NAME");
        multiValueMap.add("key","value");
        URI uriB = UriComponentsBuilder
                .fromUriString("http://localhost:61261/coffee/")
                .queryParams(multiValueMap)
                .build()
                .toUri();
        logger.info("uriA: {}", uriB);
    }

    public void buildHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

    }

    // map >> MultiValueMap

}
