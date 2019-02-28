package com.tencent.mm.y.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.m;
import com.tencent.mm.ay.j;
import com.tencent.mm.ay.n;
import com.tencent.mm.ay.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements e {
    private static c hld;
    private ArrayList<a> gNg = new ArrayList();
    private SharedPreferences hbz = ad.cgg();
    private final int hkZ = 21;
    private final String hla = "trace_config_last_update_time";
    private final long hlb = 86400000;
    private volatile boolean hlc = false;

    interface a {
        void IQ();
    }

    private c() {
    }

    public static c IX() {
        if (hld == null) {
            synchronized (c.class) {
                if (hld == null) {
                    hld = new c();
                }
            }
        }
        return hld;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(kVar instanceof m) || ((m) kVar).Kr() != 21) {
            x.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
        } else if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ay.m[] in = r.QO().in(21);
                if (in == null || in.length == 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                    release();
                    return;
                }
                com.tencent.mm.ay.m mVar = in[0];
                x.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.fwH);
                if (5 == mVar.status) {
                    as.CN().a(new j(mVar.id, 21), 0);
                    return;
                }
                x.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
                this.hbz.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
                release();
                return;
            }
            release();
        } else if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                hh(((j) kVar).hLs);
            }
            release();
        }
    }

    private void hh(int i) {
        r.QO();
        try {
            Map y = bj.y(com.tencent.mm.a.e.bT(new File(new File(n.QL()), r.QO().bg(i, 21)).getPath()), "TraceConfig");
            if (y == null) {
                x.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            Map hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
                String str3 = (String) y.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = bi.getLong((String) y.get(str2), -1);
                if (j >= 0) {
                    x.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.hbz.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            x.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.gNg.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.gNg.get(i3)).IQ();
            }
            com.tencent.mm.ay.m be = r.QO().be(i, 21);
            be.status = 2;
            r.QO().b(be);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TraceConfigUpdater", e, "", new Object[0]);
        }
    }

    private void release() {
        x.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.hlc = false;
        as.CN().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        as.CN().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.gNg.contains(aVar)) {
            return false;
        }
        return this.gNg.add(aVar);
    }
}
