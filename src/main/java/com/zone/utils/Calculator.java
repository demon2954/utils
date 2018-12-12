package com.zone.utils;

import java.math.BigDecimal;

/**
 *
 * @auth zone
 * @date 2018-12-12
 */
public class Calculator {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		// 优惠折扣
		double discountRate = 0.6;
		// 平台折扣
		double discount = 1;
		// VIP折扣
		double vipDiscountRate = 0.95;
		// 订单原价
		long totalAmount = 5000L;
		// 结算价
		long receiceAmount = new BigDecimal(totalAmount).multiply(new BigDecimal(discount + "")).longValue();
		// 最大红包
		long maxRedPack = 200L;

		long minPayAmount = new BigDecimal(receiceAmount).divide(new BigDecimal("1.9"), 6, BigDecimal.ROUND_HALF_UP).longValue();
		long maxPayAmount = new BigDecimal(receiceAmount).divide(new BigDecimal("0.6"), 6, BigDecimal.ROUND_HALF_UP).longValue();
		System.out.println("订单原价\t" + AmountUtils.fenToYuan(totalAmount));
		System.out.println("结算价\t" + AmountUtils.fenToYuan(receiceAmount));
		minPayAmount = new BigDecimal(minPayAmount).divide(new BigDecimal(vipDiscountRate + ""), 6, BigDecimal.ROUND_HALF_UP).add(new BigDecimal(maxRedPack)).longValue();
		maxPayAmount = new BigDecimal(maxPayAmount).divide(new BigDecimal(vipDiscountRate + ""), 6, BigDecimal.ROUND_HALF_UP).add(new BigDecimal(maxRedPack)).longValue();
		System.out.println("支付金额范围\t" + AmountUtils.fenToYuan(minPayAmount) + " -- " + AmountUtils.fenToYuan(maxPayAmount));

		System.out.println("优惠折扣 " + discountRate * 10 + "折");

		long minTotalAmount = new BigDecimal(minPayAmount).divide(new BigDecimal(discountRate + ""), 6, BigDecimal.ROUND_HALF_UP).longValue();
		long maxTotalAmount = new BigDecimal(maxPayAmount).divide(new BigDecimal(discountRate + ""), 6, BigDecimal.ROUND_HALF_UP).longValue();

		System.out.println("订单原价范围\t" + AmountUtils.fenToYuan(minTotalAmount) + " -- " + AmountUtils.fenToYuan(maxTotalAmount));
	}
}
