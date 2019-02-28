package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f {
    private static long xlr = 125829120;
    private static long xls = 314572800;
    al fia = new al(new a() {
        public final boolean uG() {
            f.this.lD(true);
            return true;
        }
    }, true);
    private boolean initialized = false;
    boolean mwN = false;
    private long xlt = 0;
    private long xlu = 0;
    private String xlv = null;
    private j xlw;

    /* renamed from: com.tencent.mm.sandbox.updater.f$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long xly;

        AnonymousClass2(long j) {
            this.xly = j;
        }

        public final void run() {
            x.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.xly));
            f.this.xlt = f.this.xlt + Math.max(0, this.xly);
            f.this.lD(false);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.f$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ long xlz;

        AnonymousClass3(long j) {
            this.xlz = j;
        }

        public final void run() {
            x.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", Long.valueOf(this.xlz));
            f.this.xlu = f.this.xlu + Math.max(0, this.xlz);
            f.this.lD(false);
        }
    }

    public f(j jVar) {
        this.xlw = jVar;
    }

    public final void cW(String str, int i) {
        if (!bi.oN(str)) {
            if (!str.equals(this.xlv)) {
                stop();
            }
            x.i("MicroMsg.TrafficStatistic", "pack size: " + i);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE before : %s", Long.valueOf(xlr));
            xlr = Math.max((long) (i * 4), xlr);
            xlr = Math.min(xls, xlr);
            x.i("MicroMsg.TrafficStatistic", "TRAFFIC_ALERT_LINE after : %s", Long.valueOf(xlr));
            if (!this.initialized) {
                if (this.xlw.mContext != null) {
                    this.mwN = ao.isWifi(this.xlw.mContext);
                }
                this.fia.K(30000, 30000);
                this.initialized = true;
                this.xlv = str;
            }
        }
    }

    public final void stop() {
        lD(true);
        this.fia.TN();
        this.initialized = false;
    }

    final void lD(boolean z) {
        long j = 0;
        if (z || this.xlt + this.xlu >= 524288) {
            if (this.xlt + this.xlu > 0) {
                Intent intent = new Intent();
                intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
                intent.putExtra("intent_extra_flow_stat_upstream", this.xlt);
                intent.putExtra("intent_extra_flow_stat_downstream", this.xlu);
                if (this.xlw.mContext != null) {
                    this.mwN = ao.isWifi(this.xlw.mContext);
                }
                intent.putExtra("intent_extra_flow_stat_is_wifi", this.mwN);
                if (this.xlw.mContext != null) {
                    this.xlw.mContext.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
            if (bi.oN(this.xlv)) {
                x.e("MicroMsg.TrafficStatistic", "traffic is null!");
            } else {
                long s = i.s(this.xlv, this.xlt, this.xlu);
                this.xlt = 0;
                this.xlu = 0;
                j = s;
            }
            if (j >= xlr && this.xlw.rAU == 2) {
                x.e("MicroMsg.TrafficStatistic", "checkIfTrafficAlert reach traffic alert line!");
                this.xlw.cancel();
            }
        }
    }

    public static boolean Vj(String str) {
        if (i.Vl(str) <= xlr) {
            return false;
        }
        x.e("MicroMsg.TrafficStatistic", "overTrafficAlertLine reach traffic alert line!");
        return true;
    }
}
