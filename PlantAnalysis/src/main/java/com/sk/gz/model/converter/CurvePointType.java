package com.sk.gz.model.converter;

public enum CurvePointType {
    /** 拟合功率曲线点 */
    FFIT_CURVE(0),

    /** 预设功率曲线点 */
    THEO_CURVE(1);

    private int num;

    public int getValue() {
        return num;
    }

    CurvePointType(int num) {
        this.num = num;
    }
}
