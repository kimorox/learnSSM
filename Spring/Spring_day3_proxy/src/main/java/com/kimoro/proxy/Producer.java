package com.kimoro.proxy;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 14:45
 * 生产者
 **/
public class Producer implements IProducer {
    /**
     * 销售
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    public void afterService(float money) {
        System.out.println("售后服务，并拿到钱：" + money);
    }
}
