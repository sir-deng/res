package com.tencent.mm.plugin.sns.data;

public final class h {
    public String desc = "";
    public int fileSize = 0;
    public String fwx = "";
    public int height = -1;
    public String path = "";
    public int qWY = 0;
    public int qWZ;
    public int qXa;
    public int qXb;
    public String qXc = "";
    public String qXd = "";
    public String qXe = "";
    public boolean qXf = false;
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.qXb = -1;
    }

    public h(int i, int i2) {
        this.qXb = i;
        this.type = i2;
        this.path = "";
    }
}
