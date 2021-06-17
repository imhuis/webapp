package com.imhui;

import com.imhui.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/servlet.xml"})
public class ValidateTest {

    @Autowired
    private Validator validator;

    @Test
    public void test(){
        User user = new User();
        // validate
        Set<ConstraintViolation<User>> constraintViolations1 = validator.validate(user);
        // validateProperty
        Set<ConstraintViolation<User>> constraintViolations2 = validator.validateProperty(user, "name");

        // validateValue
        Set<ConstraintViolation<User>> constraintViolations3 = validator
                .validateValue(User.class, "name", "");
    }

}
