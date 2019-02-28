package com.tencent.mm.plugin.hp.tinker;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tinkerboots.sdk.a.a.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f extends a {
    public final boolean aTm() {
        return super.aTm();
    }

    public final void C(Map<String, String> map) {
        super.C(map);
        b.rz(2);
        String str = "tinker_id_" + BaseBuildInfo.baseRevision();
        String str2 = BaseBuildInfo.PATCH_REV == null ? "" : "tinker_id_" + BaseBuildInfo.PATCH_REV;
        List linkedList = new LinkedList();
        for (String str3 : map.keySet()) {
            bpd bpd = new bpd();
            bpd.aAM = str3;
            bpd.value = (String) map.get(str3);
            linkedList.add(bpd);
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bpd bpd2 = (bpd) it.next();
            stringBuilder.append(bpd2.aAM).append(":").append(bpd2.value).append("\n");
        }
        x.i("Tinker.TinkerPatchRequestCallback", "checkAvailableUpdate BaseID:%s PatchID:%s config:%s", str, str2, stringBuilder.toString());
        as.CN().a(new com.tencent.mm.plugin.hp.c.a(str, str2, linkedList), 0);
    }

    public final void aTn() {
        super.aTn();
        com.tinkerboots.sdk.a.cKg().go(OpenSDKTool4Assistant.EXTRA_UIN, String.valueOf(((long) com.tencent.mm.kernel.a.CH()) & 4294967295L)).go(TencentLocation.NETWORK_PROVIDER, String.valueOf(ao.isWifi(ad.getContext()) ? 3 : 2));
    }
}
