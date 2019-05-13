package com.sk.gz.model.power;

public enum BAType {
    /** 时间可利用率 */
    TBA(1),

    /** 能量可利用率 */
    PBA(2);

    private int num;

    public int getValue() {
        return num;
    }

    BAType(int num) {
        this.num = num;
    }
}
