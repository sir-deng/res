package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class e extends c<f> {
    public static final String[] iHj = new String[]{i.a(f.iHk, "PredownloadIssueLaunchWxaAppResponse")};

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.iHk, "PredownloadIssueLaunchWxaAppResponse", f.fNF);
    }

    public final boolean a(byte[] bArr, String str, List<Integer> list, long j, long j2) {
        if (bi.by(bArr) || bi.oN(str)) {
            x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, invalid input %s", str);
            return false;
        } else if (bi.cC(list)) {
            x.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, empty sceneList", str);
            return false;
        } else {
            boolean z = true;
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                com.tencent.mm.sdk.e.c fVar = new f();
                fVar.field_appId = str;
                fVar.field_scene = intValue2;
                boolean b = b(fVar, new String[0]);
                fVar.field_launchProtoBlob = bArr;
                fVar.field_startTime = j;
                fVar.field_endTime = j2;
                z = (b ? c(fVar, new String[0]) : b(fVar)) & z;
            }
            x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "setLaunchData, appId %s, sceneList %d, setOk %b", str, Integer.valueOf(list.size()), Boolean.valueOf(z));
            return z;
        }
    }

    public final Pair<aon, Long> ak(String str, int i) {
        try {
            long Wx = bi.Wx();
            com.tencent.mm.sdk.e.c fVar = new f();
            fVar.field_appId = str;
            fVar.field_scene = i;
            if (b(fVar, new String[0])) {
                x.i("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found info with appId(%s) scene(%d), [%d, %d]", str, Integer.valueOf(i), Long.valueOf(fVar.field_startTime), Long.valueOf(fVar.field_endTime));
                if (fVar.field_startTime <= Wx && Wx <= fVar.field_endTime) {
                    aon aon = new aon();
                    aon.aH(fVar.field_launchProtoBlob);
                    if (aon.wCh.wcZ.oz.length > 0) {
                        return Pair.create(aon, Long.valueOf(fVar.field_reportId));
                    }
                    x.e("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", "found into with appId(%s) scene(%d), but jsapi_control_bytes invalid", str, Integer.valueOf(i));
                }
            }
            return Pair.create(null, Long.valueOf(-1));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.Predownload.DuplicateLaunchWxaAppCacheStorage", e, "get with appId(%s) scene(%d)", str, Integer.valueOf(i));
            return Pair.create(null, Long.valueOf(-1));
        }
    }

    public static void aaG() {
    }
}
