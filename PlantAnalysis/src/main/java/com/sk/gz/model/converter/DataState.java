package com.sk.gz.model.converter;

public enum DataState {
    /** 正常 */
    NORMAL(1),

    /** 限电/弃风 */
    CURTAILMENT(2),

    /** 停机 */
    STOP(3),

    /** 欠发 */
    UNDER(4),

    /** 超发 */
    OVER(5),

    /** 无效 */
    INVALID(6);

    private int num;

    public int getValue() {
        return num;
    }

    DataState(int num) {
        this.num = num;
    }
}
