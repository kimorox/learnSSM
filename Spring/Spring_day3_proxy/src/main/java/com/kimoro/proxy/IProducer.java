package com.kimoro.proxy;

/**
 * 对生产厂家的要求
 */
public interface IProducer {
    /**
     * 销售
     *
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     *
     * @param money
     */
    public void afterService(float money);
}
