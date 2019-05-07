package com.sk.gz.model.converter;

public enum DataState {
    /** 正常 */
    NORMAL(0),

    /** 无效 */
    INVALID(1),

    /** 停机 */
    STOP(2),

    /** 限电 */
    CURTAILMENT(3),

    /** 欠发 */
    UNDER(4),

    /** 超发 */
    OVER(5);

    private int num;

    public int getValue() {
        return num;
    }

    DataState(int num) {
        this.num = num;
    }
}
