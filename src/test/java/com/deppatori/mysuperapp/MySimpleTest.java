package com.deppatori.mysuperapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.deppatori.mysuperapp.exception.ExceptionName;

public class MySimpleTest {
	
	@Test
	public void test() {
		ExceptionName exceptionName = new ExceptionName("Error");
		assertEquals(exceptionName.updateCode(404).getMessage(),"Error");
	}
}
