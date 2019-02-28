package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public long kDv;
    public String kEc;
    public int kEd;

    public abstract byte[] arZ();

    public static a af(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "data input error");
            return null;
        }
        Object au = b.au(bArr);
        if (au != null && (au instanceof a)) {
            return (a) au;
        }
        x.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
