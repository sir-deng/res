package com.tencent.mm.permission;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.m;
import com.tencent.mm.ay.j;
import com.tencent.mm.ay.k;
import com.tencent.mm.ay.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a implements e {
    private static a ieb;
    private boolean iec = false;
    private int mRetryTimes = 3;

    public static a Wi() {
        if (ieb == null) {
            ieb = new a();
        }
        return ieb;
    }

    public final void Wj() {
        if (as.Hp()) {
            if (!this.iec) {
                as.Hm();
                if (c.isSDCardAvailable()) {
                    as.Hm();
                    if (bi.Wy() - ((Long) c.Db().get(327944, Long.valueOf(0))).longValue() >= 86400000) {
                        release();
                        this.iec = true;
                        as.CN().a(new k(23), 0);
                        as.CN().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
                        as.CN().a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
                        return;
                    }
                    return;
                }
            }
            x.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", Boolean.valueOf(this.iec));
        }
    }

    private void release() {
        this.iec = false;
        as.CN().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
        as.CN().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if ((kVar instanceof m) && ((m) kVar).Kr() == 23) {
            int type = kVar.getType();
            if (JsApiGetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    QJ();
                    com.tencent.mm.ay.m[] in = r.QO().in(23);
                    if (in == null || in.length == 0) {
                        x.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    com.tencent.mm.ay.m mVar = in[0];
                    x.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), Integer.valueOf(mVar.fwH));
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    as.CN().a(new j(mVar.id, 23), 0);
                    return;
                }
                type = this.mRetryTimes - 1;
                this.mRetryTimes = type;
                if (type <= 0) {
                    if (as.Hp()) {
                        as.Hm();
                        c.Db().set(327944, Long.valueOf((bi.Wy() - 86400000) + 3600000));
                    }
                    this.mRetryTimes = 3;
                }
                release();
                return;
            } else if (JsApiSetBackgroundAudioState.CTRL_INDEX == type) {
                if (i == 0 && i2 == 0) {
                    QJ();
                }
                release();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.PermissionConfigUpdater", "another scene");
    }

    private static void QJ() {
        if (as.Hp()) {
            as.Hm();
            c.Db().set(327944, Long.valueOf(bi.Wy()));
        }
    }
}
