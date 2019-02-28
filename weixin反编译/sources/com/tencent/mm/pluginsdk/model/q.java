package com.tencent.mm.pluginsdk.model;

public final class q {
    public String frQ;
    private int vkl;
    public String vkm;
    public String vkn;
    public String vko;
    public int vkp;

    q(int i, String str, String str2, String str3, String str4, int i2) {
        this.vkl = i;
        this.frQ = str;
        this.vkm = str2;
        this.vkp = i2;
        this.vkn = str3;
        this.vko = str4;
    }

    public final String toString() {
        return "id:" + this.vkl + ";productId:" + this.frQ + ";full:" + this.vkm + ";productState:" + this.vkp + ";priceCurrencyCode:" + this.vkn + ";priceAmountMicros:" + this.vko;
    }
}
