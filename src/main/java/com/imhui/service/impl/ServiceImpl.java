package com.imhui.service.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
// 一个单例的 Bean，使用 autowired 注解标记其属性时，一定要注意这个属性值会被固定下来
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceImpl {

}
