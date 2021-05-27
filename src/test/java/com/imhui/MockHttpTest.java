package com.imhui;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/servlet.xml"})
public class MockHttpTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    /**
     * 应用测试挡板（Test Doubles）
     * 被测系统（SUT）很少孤立存在，在测试中，SUT所需要的依赖称为协作者，协作者经常被被称为测试挡板的其他对象取代
     *
     * 模拟框架：
     *  Mockito
     *  EasyMock
     *  jMock
     *
     * https://www.cnblogs.com/zyly/p/10897894.html
     *  测试挡板的类型：
     *  dummy   stub    spy     fake    mock
     */


    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        assertNotNull(mockMvc);
        mockMvc.perform(get("/v1/test/hello"))
                .andExpect(status().is2xxSuccessful())
//                .andExpect(model().hasNoErrors())
                .andDo(print())
                .andReturn()
                .getResponse().getContentAsString();
    }
}
