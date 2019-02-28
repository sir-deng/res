package com.tencent.mm.plugin.exdevice.g;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void l(long j, int i) {
        b zL = ad.aER().zL(String.valueOf(j));
        if (zL == null) {
            x.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zL.field_deviceType).append(',');
        stringBuilder.append(zL.field_deviceID).append(',');
        stringBuilder.append(i);
        g.pWK.k(11232, stringBuilder.toString());
    }
}
