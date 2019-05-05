package com.sk.gz.model.param;

public enum ParamType {
    /** 无效值 */
    INVALID(-1),

    /** 有功功率 */
    ACTIVE_POWER(2),

    /** 风速 */
    WIND_SPEED(1),

    /** 发电机转速 */
    ROTATE(3),

    /** 平均桨叶角度 */
    PADDLE(4);

    private int num;

    ParamType(int num) {
        this.num = num;
    }
}
