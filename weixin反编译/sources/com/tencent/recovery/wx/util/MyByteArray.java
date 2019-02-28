package com.tencent.recovery.wx.util;

class MyByteArray {
    public byte[] fdb;
    public int fdc;

    public MyByteArray() {
        this.fdc = 0;
        this.fdb = new byte[256];
    }

    public MyByteArray(byte b) {
        this.fdc = 0;
        this.fdb = new byte[]{b};
    }

    public MyByteArray(byte[] bArr) {
        this.fdc = 0;
        this.fdb = bArr;
    }
}
