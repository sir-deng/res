package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.xweb.m;
import java.io.Closeable;
import java.io.InputStream;

public final class c {
    private static final String[] iHD = af.iHD;

    private static m bd(String str, String str2) {
        Throwable e;
        Closeable agVar;
        Closeable qa;
        try {
            agVar = new ag(str);
            try {
                agVar.aai();
                qa = agVar.qa(str2);
                try {
                    bi.d(agVar);
                    return new m(s.TB(str2), "UTF-8", qa);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                qa = null;
            }
        } catch (Exception e4) {
            e = e4;
            qa = null;
            agVar = null;
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, bi.i(e));
            bi.d(agVar);
            bi.d(qa);
            return null;
        }
    }

    public static String be(String str, String str2) {
        if (bi.oN(str2)) {
            return "";
        }
        m bf = bf(str, str2);
        if (bf != null) {
            try {
                x.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", Integer.valueOf(bf.mInputStream.available()), str2);
            } catch (Exception e) {
                x.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", e, str, str2);
            }
            return com.tencent.mm.plugin.appbrand.q.c.convertStreamToString(bf.mInputStream);
        }
        x.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", str, str2);
        return "";
    }

    public static m bf(String str, String str2) {
        x.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", str, str2);
        if (bi.oN(str2) || s.eL(str2, "about:blank") || com.tencent.mm.plugin.appbrand.q.c.vf(str2)) {
            return null;
        }
        String pQ = a.pQ(str2);
        WxaWidgetContext rK;
        WxaPkgWrappingInfo acZ;
        if (com.tencent.mm.compatible.loader.a.a(iHD, pQ)) {
            rK = i.rK(str);
            acZ = rK != null ? rK.acZ() : null;
            if (acZ == null) {
                return null;
            }
            if (acZ.iJd) {
                InputStream openRead = af.openRead(pQ);
                if (openRead != null) {
                    return new m(s.TB(pQ), "UTF-8", openRead);
                }
                return null;
            } else if (bi.oN(acZ.iGz)) {
                x.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", acZ.iGz);
                return null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", str, pQ);
                return bd(acZ.iGz, pQ);
            }
        }
        m mVar;
        rK = i.rK(str);
        acZ = rK != null ? rK.acY() : null;
        if (acZ == null) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", str);
            mVar = null;
        } else if (bi.oN(acZ.iGz)) {
            x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", acZ.iGz, str);
            mVar = null;
        } else {
            String str3 = acZ.iGz;
            if (bi.oN(str3)) {
                x.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                mVar = null;
            } else {
                x.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", str, pQ);
                mVar = bd(str3, pQ);
            }
        }
        if (mVar == null) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        }
        return mVar;
    }
}
