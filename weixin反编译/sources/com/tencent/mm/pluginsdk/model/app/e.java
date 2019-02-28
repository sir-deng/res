package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.f.b.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {
    private ag handler;
    public Map<String, Integer> iYc;
    public List<r> qqZ;
    public List<r> vkK;
    private al vkL;

    public e() {
        this.vkK = null;
        this.qqZ = null;
        this.iYc = null;
        this.vkL = new al(new a() {
            public final boolean uG() {
                e.this.iYc.clear();
                return false;
            }
        }, false);
        this.handler = new ag(g.Dt().oFY.getLooper()) {
            public final void handleMessage(Message message) {
                u uVar = (u) message.obj;
                r rVar = new r(uVar.appId, uVar.hPf);
                if (e.this.vkK.contains(rVar)) {
                    e.this.vkK.remove(rVar);
                    if (!com.tencent.mm.plugin.y.a.biT().e(uVar.appId, uVar.data, uVar.hPf)) {
                        x.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (e.this.qqZ.size() > 0) {
                    r rVar2 = (r) e.this.qqZ.remove(0);
                    if (e.this.a(rVar2)) {
                        e.this.vkK.add(rVar2);
                        return;
                    }
                }
            }
        };
        this.vkK = new ArrayList();
        this.qqZ = new ArrayList();
        this.iYc = new HashMap();
        this.vkL.K(600000, 600000);
    }

    public final void cS(String str, int i) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.AppIconService", "push fail, appId is null");
            return;
        }
        r rVar = new r(str, i);
        if (this.vkK.contains(rVar)) {
            x.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i + " already in running list");
        } else if (this.vkK.size() >= 5) {
            x.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.qqZ.contains(rVar)) {
                this.qqZ.add(rVar);
            }
        } else if (a(rVar)) {
            this.vkK.add(rVar);
        }
    }

    final boolean a(r rVar) {
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            return false;
        }
        int i;
        if (rVar == null) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            i = 0;
        } else {
            Integer valueOf = Integer.valueOf(bi.a((Integer) this.iYc.get(rVar.toString()), 0));
            if (valueOf.intValue() >= 5) {
                x.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
                i = 0;
            } else {
                this.iYc.put(rVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
                i = 1;
            }
        }
        if (i == 0) {
            x.e("MicroMsg.AppIconService", "increaseCounter fail");
            return false;
        }
        o Sk = com.tencent.mm.plugin.y.a.biT().Sk(rVar.appId);
        if (Sk == null) {
            x.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + rVar.appId);
            return false;
        }
        String str;
        switch (rVar.hPf) {
            case 1:
                if (Sk.field_appIconUrl != null && Sk.field_appIconUrl.length() != 0) {
                    str = Sk.field_appIconUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + rVar.appId);
                return false;
            case 2:
                if (Sk.field_appWatermarkUrl != null && Sk.field_appWatermarkUrl.length() != 0) {
                    str = Sk.field_appWatermarkUrl;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + rVar.appId);
                return false;
            case 3:
                if (Sk.fRE != null && Sk.fRE.length() != 0) {
                    str = Sk.fRE;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 4:
                if (Sk.fRP != null && Sk.fRP.length() != 0) {
                    str = Sk.fRP;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + rVar.appId);
                return false;
                break;
            case 5:
                if (Sk.fRQ != null && Sk.fRQ.length() != 0) {
                    str = Sk.fRQ;
                    break;
                }
                x.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + rVar.appId);
                return false;
            default:
                x.e("MicroMsg.AppIconService", "push, unknown iconType = " + rVar.hPf);
                return false;
        }
        x.i("MicroMsg.AppIconService", "appIconUrl = " + str);
        com.tencent.mm.sdk.f.e.post(new s(this.handler, rVar.appId, rVar.hPf, str), "AppIconService_getIcon");
        return true;
    }
}
