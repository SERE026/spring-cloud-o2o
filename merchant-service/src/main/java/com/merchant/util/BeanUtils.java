package com.merchant.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
//一个类的属性描述器 已数组形式返回 PropertyDescriptor[]
//用处 判断 属性的方法是否为公开
//Arrays 将String[]字符串转成list

/**
 * 扩展spring的BeanUtils，增加拷贝属性排除null值的功能(注：String为null不考虑)
 * 
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

	public static void copyNotNullProperties(Object source, Object target, String[] ignoreProperties) throws BeansException {
		copyNotNullProperties(source, target, null, ignoreProperties);
	}

	public static void copyNotNullProperties(Object source, Object target, Class<?> editable) throws BeansException {
		copyNotNullProperties(source, target, editable, null);
	}

	public static void copyNotNullProperties(Object source, Object target) throws BeansException {
		copyNotNullProperties(source, target, null, null);
	}

	private static void copyNotNullProperties(Object source, Object target, Class<?> editable, String[] ignoreProperties) throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass(); 
		if (editable != null) {      
			if (!editable.isInstance(target)) {  // editable 也要是目标对象的实例
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);  // 获取 目标实例  的 类 描述器  
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;  //将不包含的属性 String[]转成 list

		for (PropertyDescriptor targetPd : targetPds) {   //循环描述器
			//set方法不为null --  不包含属性为空   -- 不包含集合  里没有  该属性名称
			if (targetPd.getWriteMethod() != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());//原对象 获取 对应目标对象属性 的描述器
				if (sourcePd != null && sourcePd.getReadMethod() != null) { //原对象有 改描述器，并且有读取改属性的方法
					try {
						Method readMethod = sourcePd.getReadMethod(); // 原描述器拿到读的方法
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {//如果改方法不公开，就设置true公开
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);  //原对象调用该方法
						
						// 原实例  的 属性 不为 null 或者返回类型为String 就进行处理
						if (value != null /*|| readMethod.getReturnType().getName().equals("java.lang.String")*/) {// 这里判断以下value是否为空，当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等，如果是String类型，则不需要验证是否为空
							boolean isEmpty = false;
							
							//对不为null  但不存在意思的集合判断为无值
							if (value instanceof Set) {
								Set s = (Set) value;
								if (s == null || s.isEmpty()) { //set、map被实例话  集合里没有 值是empty的
									isEmpty = true;
								}
							} else if (value instanceof Map) {
								Map m = (Map) value;
								if (m == null || m.isEmpty()) {
									isEmpty = true;
								}
							} else if (value instanceof List) {
								List l = (List) value;
								if (l == null || l.size() < 1) {  
									isEmpty = true;
								}
							} else if (value instanceof Collection) {
								Collection c = (Collection) value;
								if (c == null || c.size() < 1) {   
									isEmpty = true;
								}
							}
							if (!isEmpty) {
								Method writeMethod = targetPd.getWriteMethod(); // 目标的实例 获取 当前属性 的写 方法 对象
								if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
									writeMethod.setAccessible(true);
								}
								writeMethod.invoke(target, value);  // 给 目标实例 赋值
							}
						}
					} catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}

}


 

