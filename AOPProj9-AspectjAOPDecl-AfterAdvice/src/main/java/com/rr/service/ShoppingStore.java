package com.rr.service;

import java.util.stream.DoubleStream;

public class ShoppingStore {
	
	public double shopping(String[] items,double[] prices) {
		double billAmt=0.0f;
		billAmt=DoubleStream.of(prices).sum();
		return billAmt;
	}
}
