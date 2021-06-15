package com.imhui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Collections.emptyList();
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        arrayList.toArray();
        Arrays.asList();

        Queue queue = new LinkedList();
        queue.poll();
        queue.remove();

        ApplicationContext context = new ClassPathXmlApplicationContext();
    }
}
