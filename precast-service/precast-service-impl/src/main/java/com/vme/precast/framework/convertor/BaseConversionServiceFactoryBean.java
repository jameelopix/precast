package com.vme.precast.framework.convertor;

import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BaseConversionServiceFactoryBean extends ConversionServiceFactoryBean {

	@Override
	public void afterPropertiesSet() {
		System.out.println("BaseConversionServiceFactoryBean.afterPropertiesSet()");
		super.afterPropertiesSet();
		ConversionService conversionService = getObject();
		ConverterRegistry registry = (ConverterRegistry) conversionService;
		// register converters that need a nested conversion service
//		registry.addConverter(new ElementGenericConvertor(conversionService));
//		registry.addConverter(new MixtureGenericConvertor(conversionService));
//		registry.addConverter(new MixtureItemGenericConvertor(conversionService));
		System.out.println("BaseConversionServiceFactoryBean.afterPropertiesSet()");
	}

}
