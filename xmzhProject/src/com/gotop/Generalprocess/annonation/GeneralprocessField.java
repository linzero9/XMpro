package com.gotop.Generalprocess.annonation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Target;


/**
 * 
 * @author wujiajun
 * @desc    流程的 基本属性定义
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface GeneralprocessField {
	public String name() default "";  //字段名称
	public String  description() default ""; //描述
	
	public boolean  hidden() default true; //是否显示在页面（有些id不需要显示），true 表示显示（默认），false不显示
	

	public String  type() default "text";//参数类型，是隐藏还是 弹窗(默认是text  暂定3种类型！！！！text，hidden，alert)
	public String  handle() default "";//特殊处理时候 传递的 信息，用于做业务处理
	
	public String  url() default "";//特殊处理时候 传递的 信息，用于做业务处理
	
}