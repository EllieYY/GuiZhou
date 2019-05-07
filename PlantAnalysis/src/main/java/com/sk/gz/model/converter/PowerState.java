package com.sk.gz.model.converter;

public enum PowerState {
    /** 发电 */
    GEN(1),

    /** 待机 */
    WAIT(5),

    /** 故障 */
    ERR(2),

    /** 检修 */
    FIX(8),

    /** 停机 */
    STOP(4),

    /** 离线 */
    OFF_LINE(3);

    private int num;

    public int getValue() {
        return num;
    }

    PowerState(int num) {
        this.num = num;
    }
}
