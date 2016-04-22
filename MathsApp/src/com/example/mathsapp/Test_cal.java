package com.example.mathsapp;
import junit.framework.TestCase;
public class Test_cal extends TestCase 
{
	/* 
	 * 1����ͨ��ֵ����ͽ׳˼���д��һ�������ڣ��޷���������޷����в���
	 * 2�������Ƿ��������Լ������ŵļ���Ĳ���
	 */
	Calculator cal = new Calculator();
	KuohaoCalc kuohao = new KuohaoCalc();
	private String result;
	//�����Ӽ��˳�
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
		cal.compute("5/6", "��", "1/9");
		result = cal.final_result;
		assertEquals("15/2", result);
	}
	//����������
	public void test_calculate_daikuohao()
	{
		kuohao.interceResult("(3+40)*0-5");
		result = kuohao.finalresult_1;
		assertEquals("-5", result);
	}
}
