package com.tencent.mm.a;

final class i {
    public byte[] fdb;
    public int fdc;

    public i() {
        this.fdc = 0;
        this.fdb = new byte[256];
    }

    public i(byte b) {
        this.fdc = 0;
        this.fdb = new byte[]{b};
    }

    public i(byte[] bArr) {
        this.fdc = 0;
        this.fdb = bArr;
    }
}
