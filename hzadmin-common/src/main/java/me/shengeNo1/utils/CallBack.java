package me.shengeNo1.utils;

/**
 * @author LYS liuyua776@gmail.com
 * @version 1.0.0
 * @ClassName CallBack.java
 * @Description TODO
 * @createTime 2020年12月25日 11:24:00
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
