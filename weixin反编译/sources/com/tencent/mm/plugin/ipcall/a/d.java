package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ay.j;
import com.tencent.mm.ay.k;
import com.tencent.mm.ay.m;
import com.tencent.mm.ay.r;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import java.io.File;

public final class d implements e {
    private static d nIa = null;
    private boolean hlc = false;
    c nIb = new c<cl>() {
        {
            this.xmG = cl.class.getName().hashCode();
        }

        private boolean a(cl clVar) {
            if (clVar instanceof cl) {
                x.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                as.Hm();
                int intValue = ((Integer) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(0))).intValue();
                int i = g.Af().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                x.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", Integer.valueOf(intValue), Integer.valueOf(i));
                if (intValue != i) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(i));
                    r.QO().im(26);
                    c aTQ = c.aTQ();
                    x.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", com.tencent.mm.compatible.util.e.hbv + "ipcallCountryCodeConfig.cfg");
                    try {
                        File file = new File(com.tencent.mm.compatible.util.e.hbv + "ipcallCountryCodeConfig.cfg");
                        if (file.exists()) {
                            file.delete();
                        }
                        aTQ.isInit = false;
                        aTQ.nHZ.clear();
                    } catch (Exception e) {
                        x.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", e.getMessage());
                    }
                    d.this.fU(true);
                }
            }
            return false;
        }
    };
    private int retryCount = 0;

    private d() {
    }

    public static d aTU() {
        if (nIa == null) {
            nIa = new d();
        }
        return nIa;
    }

    public final void fU(boolean z) {
        if (!as.Hp()) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
        } else if (this.hlc) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
        } else {
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", Boolean.valueOf(z));
            if (!z) {
                as.Hm();
                long longValue = ((Long) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    return;
                }
            }
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.hlc = true;
            as.CN().a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
            as.CN().a((int) JsApiSetBackgroundAudioState.CTRL_INDEX, (e) this);
            aTV();
        }
    }

    private static void aTV() {
        boolean z;
        m[] in = r.QO().in(26);
        if (in == null || in.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        as.CN().a(new k(z), 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hlc));
        if (this.hlc) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", Boolean.valueOf(z));
            if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (z) {
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                    m[] in = r.QO().in(26);
                    if (in == null || in.length == 0) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                        aTW();
                        return;
                    }
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", Integer.valueOf(in.length));
                    m mVar = in[0];
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", Integer.valueOf(mVar.fwH), Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), mVar.QK());
                    if (mVar.status == 3) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    } else if (mVar.status != 5) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                        c.aTQ().fT(true);
                        aTW();
                    } else {
                        as.CN().a(new j(mVar.id, 26), 0);
                    }
                } else if (this.retryCount < 3) {
                    this.retryCount++;
                    aTV();
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", Integer.valueOf(this.retryCount));
                } else {
                    x.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                }
            } else if (kVar.getType() == JsApiSetBackgroundAudioState.CTRL_INDEX && z) {
                x.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.aTQ().fT(true);
                aTW();
            }
        }
    }

    private void aTW() {
        this.hlc = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
    }
}
