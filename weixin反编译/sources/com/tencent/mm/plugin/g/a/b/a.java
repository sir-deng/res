package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a {
    private int kCr = 20;
    private byte[] kCs = null;
    private int kCt = 0;
    private int kCu = 0;
    BluetoothGattCharacteristic kCv = null;

    public final void setData(byte[] bArr) {
        if (bArr == null) {
            this.kCs = null;
            this.kCu = 0;
            this.kCt = 0;
            return;
        }
        this.kCs = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.kCs, 0, bArr.length);
        this.kCu = bArr.length;
        this.kCt = 0;
    }

    public final byte[] arP() {
        int i = this.kCu - this.kCt;
        if (i == 0) {
            return null;
        }
        if (i >= this.kCr) {
            i = this.kCr;
        }
        Object obj = new byte[i];
        System.arraycopy(this.kCs, this.kCt, obj, 0, i);
        this.kCt = i + this.kCt;
        return obj;
    }
}
