package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.f;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.q;
import java.io.File;
import java.util.Date;
import java.util.List;

public final class c implements b {
    public final void bDM() {
        a deviceStepManager = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager();
        x.i("MicroMsg.Sport.DeviceStepManager", "uploadDeviceStep");
        deviceStepManager.bDW();
        deviceStepManager.fc(deviceStepManager.bDV());
    }

    public final void a(String str, String str2, int i, int i2, int i3, String str3) {
        g.CN().a(new f(str, str2, i, i2, i3, str3, 1), 0);
    }

    public final boolean dA(Context context) {
        return n.dA(context);
    }

    public final boolean bDN() {
        return n.bDN();
    }

    public final void I(int i, long j) {
        i.M(i, j);
    }

    public final void bDO() {
        if (ad.cgj()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().reset();
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rZL;
            if (aVar != null) {
                try {
                    aVar.bDT();
                } catch (RemoteException e) {
                }
            }
            new File(com.tencent.mm.plugin.sport.b.a.rZF).delete();
        }
    }

    public final void d(final Activity activity, final String str) {
        ah.y(new Runnable() {
            public final void run() {
                Activity activity = activity;
                String str = str;
                if ((n.sao == null || !n.sao.isShowing()) && i.K(5, 1) != 0 && q.FY().equals(str) && !((b) g.h(b.class)).dA(ad.getContext())) {
                    n.sao = u.a(activity, b.a.gWs, com.tencent.mm.plugin.sport.b.c.dBt, ad.getContext().getString(d.rZD), b.b.rZC, new OnClickListener() {
                        public final void onClick(View view) {
                            i.L(5, 0);
                        }
                    });
                }
            }
        });
    }

    public final void bDP() {
        if (n.sao != null) {
            n.sao.dismiss();
            n.sao = null;
        }
    }

    public final List<e> D(long j, long j2) {
        l sportStepManager = ((PluginSport) g.k(PluginSport.class)).getSportStepManager();
        x.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", sportStepManager.saj.format(new Date(j)), sportStepManager.saj.format(new Date(j2)));
        ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
        return m.E(j, j2);
    }

    public final e bDQ() {
        ((PluginSport) g.k(PluginSport.class)).getSportStepManager();
        ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
        return m.bDQ();
    }

    public final void a(long j, long j2, com.tencent.mm.plugin.sport.b.c cVar) {
        x.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", r0.saj.format(new Date(j)), ((PluginSport) g.k(PluginSport.class)).getSportStepManager().saj.format(new Date(j2)));
        k dVar = new com.tencent.mm.plugin.sport.c.d(j, j2, cVar);
        g.CN().a(1734, r0.hpx);
        g.CN().a(dVar, 0);
    }
}
