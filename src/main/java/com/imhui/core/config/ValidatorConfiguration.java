package com.imhui.core.config;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.cfg.ConstraintMapping;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author: zyixh
 * @date: 2020/5/20
 * @description:
 */
public class ValidatorConfiguration {

    /**
     *
     * https://www.cnblogs.com/54chensongxia/p/14016179.html
     * https://www.cnblogs.com/mr-yang-localhost/p/7812038.html
     */


    /**
     * https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-provider-specific-settings
     *
     * @return
     */
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .failFast( true )
                .addMapping( (ConstraintMapping) null )
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    public Validator validatorWithAddProperty(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
