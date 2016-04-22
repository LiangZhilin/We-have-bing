package com.example.mathsapp;
import junit.framework.TestCase;
public class Test_cal extends TestCase 
{
	/* 
	 * 1、普通数值计算和阶乘计算写在一个方法内，无法拆分所以无法进行测试
	 * 2、以下是分数计算以及带括号的计算的测试
	 */
	Calculator cal = new Calculator();
	KuohaoCalc kuohao = new KuohaoCalc();
	private String result;
	//分数加减乘除
	public void test_calculate_fenshu_add()
	{
		cal.compute("5/6", "+", "1/9");
		result = cal.final_result;
		assertEquals("17/18", result);
	}
	public void test_calculate_fenshu_sub()
	{
		cal.compute("5/6", "-", "1/9");
		result = cal.final_result;
		assertEquals("13/18", result);
	}
	public void test_calculate_fenshu_muti()
	{
		cal.compute("5/6", "*", "1/9");
		result = cal.final_result;
		assertEquals("5/54", result);
	}
	public void test_calculate_fenshu_div()
	{
		cal.compute("5/6", "÷", "1/9");
		result = cal.final_result;
		assertEquals("15/2", result);
	}
	//带括号运算
	public void test_calculate_daikuohao()
	{
		kuohao.interceResult("(3+40)*0-5");
		result = kuohao.finalresult_1;
		assertEquals("-5", result);
	}
}
