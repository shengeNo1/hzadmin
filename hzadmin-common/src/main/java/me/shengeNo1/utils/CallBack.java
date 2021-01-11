package me.shengeNo1.utils;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName CallBack.java
 * @Description TODO
 * @createTime 2021年01月02日 11:39:00
 */

public interface CallBack {
    /**
     * 回调执行方法
     */
    void executor();

    /**
     * 本回调任务名称
     * @return /
     */
    default String getCallBackName() {
        return Thread.currentThread().getId() + ":" + this.getClass().getName();
    }

}
