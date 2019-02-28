package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.t.d.a {
    private static final int iWY = (-bi.getInt(r.ifI, 0));
    private byte[] iWZ;
    private String id;

    public a(String str, byte[] bArr) {
        this.id = str;
        this.iWZ = bArr;
    }

    public final boolean go(int i) {
        byte b;
        int i2 = iWY;
        if (i2 == -1) {
            x.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", this.id, Integer.valueOf(i));
            b = (byte) 1;
        } else if (i2 == -2) {
            x.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", this.id, Integer.valueOf(i));
            b = (byte) 0;
        } else {
            b = i == -2 ? (byte) 1 : i == -1 ? (byte) 0 : (this.iWZ == null || i < 0 || i >= this.iWZ.length) ? (byte) 0 : this.iWZ[i];
        }
        return b == (byte) 1;
    }
}
