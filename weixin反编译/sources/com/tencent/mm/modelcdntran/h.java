package com.tencent.mm.modelcdntran;

public final class h extends i {
    public int fXs;
    public int fileType;
    public String host;
    public String huY;
    public String[] huZ;
    public String[] hva;
    public int hvb;
    public int hvc;
    public int hvd;
    public boolean isColdSnsData;
    public String referer;
    public String signalQuality;
    public String snsCipherKey;
    public String snsScene;
    public String url;

    public h() {
        this.snsCipherKey = "";
        this.fXs = -1;
        this.hvd = -1;
        this.fileType = 0;
        this.hvn = true;
    }

    public final String toString() {
        return String.format("mediaId:%s, url:%s, host:%s, referer:%s, savepath:%s, iplist:%s, slaveIplist:%siplistSource:%d, dcSource:%d, isColdSnsData:%b, signalQuality:%s, snsScene:%s", new Object[]{this.field_mediaId, this.url, this.host, this.referer, this.huY, f(this.huZ), f(this.hva), Integer.valueOf(this.hvb), Integer.valueOf(this.hvc), Boolean.valueOf(this.isColdSnsData), this.signalQuality, this.snsScene});
    }

    private static String f(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int length = strArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            i++;
            str = str + strArr[i] + ",";
        }
        return str;
    }
}
