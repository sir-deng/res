package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.exdevice.ExDeviceMessageService", "onScenend, errType = %d, errCode = %d, errMsg = ", Integer.valueOf(i), Integer.valueOf(i2), str);
    }
}
