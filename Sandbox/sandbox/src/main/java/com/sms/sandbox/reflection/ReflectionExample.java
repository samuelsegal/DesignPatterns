package com.sms.sandbox.reflection;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {

	public static void main(String[] args) {
		MyBean bean = new MyBean();
		bean.setBeanDesc("Nice Bean");
		bean.setBeanName("Mr. Nice");
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(MyBean.class);
			for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {

				String propertyName = propertyDesc.getName();

				Object value = propertyDesc.getReadMethod().invoke(bean);
				System.out.println("Property Name: " + propertyName);
				System.out.println("Value: " + value);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class MyBean {
	private String beanName;
	private String beanDesc;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanDesc() {
		return beanDesc;
	}

	public void setBeanDesc(String beanDesc) {
		this.beanDesc = beanDesc;
	}

}
