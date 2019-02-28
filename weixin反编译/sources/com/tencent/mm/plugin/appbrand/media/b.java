package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static com.tencent.mm.audio.b.b jEO = null;
    private static String jEP = null;
    private static a jEQ = null;
    private static al jER = null;

    public interface a {
        void kt(int i);
    }

    private static void TN() {
        if (jER != null) {
            jER.TN();
        }
        jER = null;
    }

    public static boolean a(String str, a aVar, int i, boolean z) {
        x.i("MicroMsg.AppBrand.AudioRecorder", JsApiStartRecordVoice.NAME);
        lk(1);
        if (bi.oN(str)) {
            x.e("MicroMsg.AppBrand.AudioRecorder", "startRecord, path is null or nil");
            return false;
        }
        com.tencent.mm.audio.b.b bVar = new com.tencent.mm.audio.b.b(com.tencent.mm.compatible.b.b.a.SILK);
        jEO = bVar;
        if (bVar.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            if (bVar.fkq != null) {
                bVar.fkq.reset();
            }
        } else if (bVar.fkt != com.tencent.mm.audio.b.b.b.ERROR) {
            bVar.release();
            bVar.vo();
        }
        jEO.vm();
        jEO.vn();
        jEO.vl();
        jEO.setOutputFile(str);
        jEO.fkv = z;
        jEO.a(new com.tencent.mm.audio.b.b.a() {
            public final void onError() {
                x.e("MicroMsg.AppBrand.AudioRecorder", "onError");
                b.lk(-1);
            }
        });
        try {
            jEO.prepare();
            jEO.start();
            jEQ = aVar;
            jEP = str;
            long j = (long) i;
            TN();
            al alVar = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    b.lk(1);
                    return false;
                }
            }, false);
            jER = alVar;
            alVar.K(j, j);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrand.AudioRecorder", "record prepare, exp = %s", bi.i(e));
            return false;
        }
    }

    public static void lk(int i) {
        x.i("MicroMsg.AppBrand.AudioRecorder", "stopRecord what:%d", Integer.valueOf(i));
        if (!bi.oN(jEP)) {
            if (jEO == null) {
                x.i("MicroMsg.AppBrand.AudioRecorder", "sRecorder is null,err");
                return;
            }
            jEO.vp();
            jEO.release();
            jEO = null;
            TN();
            jEP = null;
            if (jEQ != null) {
                jEQ.kt(i);
            }
            jEQ = null;
        }
    }
}
