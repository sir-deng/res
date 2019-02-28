package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int qeS = bp.CTRL_INDEX;
    private static int qeT = 158;
    private static boolean vvX = false;
    Context context;
    private SharedPreferences hbz;
    private List<f> idy = new LinkedList();
    private boolean isInit = false;
    private boolean qfd = false;
    private int qfe;
    private int qff;
    public MMFlipper qfg;
    private MMDotView qfh;
    private final boolean[] vvB = new boolean[17];
    a vvC;
    b vvD;
    private List<AppGrid> vvE;
    int vvF = this.vvr;
    int vvG;
    public a vvH;
    private int vvI = 0;
    private int vvJ = 0;
    int vvK = 0;
    private boolean vvL = false;
    private boolean vvM = false;
    private boolean vvN = false;
    private boolean vvO = false;
    boolean vvP = false;
    boolean vvQ = false;
    boolean vvR = false;
    public boolean vvS = false;
    private Map<String, f> vvT = null;
    private boolean vvU = true;
    private final int vvV = 2;
    private com.tencent.mm.pluginsdk.ui.chat.AppGrid.b vvW = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.b() {
        public final int Cw(int i) {
            int i2 = 0;
            if (i < AppPanel.this.vvr) {
                int length = AppPanel.this.vvB.length;
                int i3 = 0;
                while (i2 < length) {
                    if (AppPanel.this.vvB[i2]) {
                        if (i3 == i) {
                            return i2;
                        }
                        i3++;
                    }
                    i2++;
                }
            } else if (i >= AppPanel.this.vvr && i < AppPanel.this.vvF) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        public final void Cx(int i) {
            if (i != 0) {
                return;
            }
            if (AppPanel.this.vvH.vwe.value) {
                AppPanel.a(AppPanel.this, true);
            } else {
                Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
            }
        }

        public final void a(int i, f fVar) {
            int i2 = 0;
            String str = "MicroMsg.AppPanel";
            String str2 = "pos=%d, has appInfo = %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(fVar != null);
            x.d(str, str2, objArr);
            if (fVar != null && g.j(fVar)) {
                Map hashMap = new HashMap();
                q.b(327682, hashMap);
                hashMap.put(fVar.field_appId, "1");
                q.a(327682, hashMap);
            }
            com.tencent.mm.sdk.b.b rkVar;
            String str3;
            f fVar2;
            int intValue;
            List F;
            switch (i) {
                case Integer.MIN_VALUE:
                    if (!AppPanel.this.vvH.vwl.value) {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                        return;
                    } else if (fVar == null) {
                        x.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                        return;
                    } else {
                        if (fVar.bZq() || fVar.bZs()) {
                            if (AppPanel.this.hbz == null) {
                                AppPanel.this.hbz = AppPanel.this.context.getSharedPreferences(ad.cgf(), 0);
                            }
                            if (AppPanel.this.hbz.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                                AppPanel.this.hbz.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                            }
                            if (fVar.bZs()) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0));
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0));
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(11), fVar.field_appId);
                        }
                        AppPanel.this.vvC.b(fVar);
                        return;
                    }
                case 0:
                    if (AppPanel.this.vvH.vwe.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(1));
                        AppPanel.a(AppPanel.this, false);
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 1:
                    com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(14));
                    a k = AppPanel.this.vvC;
                    if (!AppPanel.this.vvH.vwu.value) {
                        i2 = 2;
                    }
                    k.sJ(i2);
                    return;
                case 2:
                    if (AppPanel.this.vvH.vwh.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(8));
                        as.Hm();
                        c.Db().set(54, Boolean.valueOf(false));
                        if (AppPanel.this.vvC != null) {
                            rkVar = new rk();
                            rkVar.fJX.fJZ = true;
                            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                            str3 = rkVar.fJY.fKb;
                            if (bi.oN(str3)) {
                                AppPanel.this.vvC.aZt();
                                return;
                            }
                            x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                            h.a(AppPanel.this.context, AppPanel.this.context.getString(R.l.eQN), "", AppPanel.this.context.getString(R.l.dGf), AppPanel.this.context.getString(R.l.dEy), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.sdk.b.b rkVar = new rk();
                                    rkVar.fJX.fKa = true;
                                    com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                                    AppPanel.this.vvC.aZt();
                                    dialogInterface.dismiss();
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 3:
                    if (AppPanel.this.vvC != null) {
                        AppPanel.this.vvC.aZD();
                        return;
                    }
                    return;
                case 4:
                    if (AppPanel.this.vvH.vwn.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(7));
                        as.Hm();
                        c.Db().set(62, Boolean.valueOf(false));
                        rkVar = new rk();
                        rkVar.fJX.fJZ = true;
                        com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                        str3 = rkVar.fJY.fKb;
                        if (bi.oN(str3)) {
                            AppPanel.this.vvC.aZu();
                            return;
                        }
                        x.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                        h.a(AppPanel.this.context, AppPanel.this.context.getString(R.l.eQN), "", AppPanel.this.context.getString(R.l.dGf), AppPanel.this.context.getString(R.l.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.b rkVar = new rk();
                                rkVar.fJX.fKa = true;
                                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                                AppPanel.this.vvC.aZu();
                                dialogInterface.dismiss();
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 5:
                    if (AppPanel.this.vvC != null) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(6));
                        as.Hm();
                        c.Db().set(67, Boolean.valueOf(false));
                        AppPanel.this.vvC.aZv();
                        return;
                    }
                    return;
                case 6:
                    if (AppPanel.this.vvH.vwr.value && AppPanel.this.vvH.vws.value) {
                        as.Hm();
                        if (((Boolean) c.Db().get(290817, Boolean.valueOf(true))).booleanValue()) {
                            as.Hm();
                            c.Db().set(290817, Boolean.valueOf(false));
                            AppPanel.this.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(3));
                        AppPanel.this.vvC.aZw();
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 7:
                    if (AppPanel.this.vvH.vwv.value) {
                        if (fVar == null) {
                            fVar2 = (f) AppPanel.this.vvT.get(f.vkP);
                            if (fVar2 == null) {
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bZq() || fVar2.bZs()) {
                            if (AppPanel.this.hbz == null) {
                                AppPanel.this.hbz = AppPanel.this.context.getSharedPreferences(ad.cgf(), 0);
                            }
                            if (AppPanel.this.hbz.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                AppPanel.this.hbz.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0));
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(11), fVar2.field_appId);
                        }
                        as.Hm();
                        intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                        as.Hm();
                        F = bi.F(((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";"));
                        if (!F.contains(String.valueOf(intValue))) {
                            F.add(String.valueOf(intValue));
                            as.Hm();
                            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, bi.d(F, ";"));
                            AppPanel.this.refresh();
                        }
                        AppPanel.this.vvC.aZC();
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 8:
                    if (fVar == null) {
                        fVar = (f) AppPanel.this.vvT.get(f.vkN);
                    }
                    as.Hm();
                    intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    as.Hm();
                    F = bi.F(((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";"));
                    if (!F.contains(String.valueOf(intValue))) {
                        F.add(String.valueOf(intValue));
                        as.Hm();
                        c.Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, bi.d(F, ";"));
                        AppPanel.this.refresh();
                    }
                    as.Hm();
                    c.Db().set(80, Boolean.valueOf(false));
                    AppPanel.this.vvC.b(fVar);
                    return;
                case 9:
                    if (AppPanel.this.vvC != null) {
                        if (fVar == null) {
                            fVar2 = (f) AppPanel.this.vvT.get(f.vkQ);
                            if (fVar2 == null) {
                                x.i("MicroMsg.AppPanel", "empty info");
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bZq() || fVar2.bZs()) {
                            if (AppPanel.this.hbz == null) {
                                AppPanel.this.hbz = AppPanel.this.context.getSharedPreferences(ad.cgf(), 0);
                            }
                            if (AppPanel.this.hbz.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                AppPanel.this.hbz.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                        }
                        AppPanel.this.vvC.aZF();
                        return;
                    }
                    return;
                case 10:
                    com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(9));
                    as.Hm();
                    c.Db().set(73, Boolean.valueOf(false));
                    AppPanel.this.vvD.cbY();
                    return;
                case 11:
                    if (AppPanel.this.vvH.vwf.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(4));
                        AppPanel.this.vvC.aZx();
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 12:
                    if (AppPanel.this.vvH.vwg.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(5));
                        if (AppPanel.this.vvC != null) {
                            AppPanel.this.vvC.aZz();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 13:
                    if (AppPanel.this.vvH.vwt.value) {
                        if (AppPanel.this.vvC != null) {
                            AppPanel.this.vvC.aZB();
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(15));
                        as.Hm();
                        boolean booleanValue = ((Boolean) c.Db().get(208899, Boolean.valueOf(false))).booleanValue();
                        as.Hm();
                        boolean booleanValue2 = ((Boolean) c.Db().get(208913, Boolean.valueOf(false))).booleanValue();
                        if (booleanValue) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11594, Integer.valueOf(3));
                            return;
                        } else if (booleanValue2) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11594, Integer.valueOf(4));
                            return;
                        } else {
                            return;
                        }
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 14:
                    if (AppPanel.this.vvH.vwj.value) {
                        as.Hm();
                        if (((Boolean) c.Db().get(327744, Boolean.valueOf(true))).booleanValue()) {
                            as.Hm();
                            c.Db().set(327744, Boolean.valueOf(false));
                            AppPanel.this.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(12));
                        AppPanel.this.vvC.aZA();
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case 15:
                    if (AppPanel.this.vvH.vwx.value) {
                        AppPanel.this.vvC.aZE();
                        return;
                    } else {
                        Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                        return;
                    }
                case 16:
                    if (AppPanel.this.vvH.vwz.value) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(17));
                        if (AppPanel.this.vvC != null) {
                            AppPanel.this.vvC.aZG();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(AppPanel.this.context, AppPanel.this.context.getString(R.l.dSt), 0).show();
                    return;
                case Integer.MAX_VALUE:
                    if (AppPanel.this.idy == null) {
                        x.e("MicroMsg.AppPanel", "infoList == null");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.k(10305, String.valueOf(AppPanel.this.idy.size()));
                    com.tencent.mm.plugin.report.service.g.pWK.h(10923, Integer.valueOf(10));
                    com.tencent.mm.kernel.g.Dq().Db().set(69121, "");
                    AppPanel.this.vvC.aZy();
                    return;
                default:
                    return;
            }
        }
    };
    boolean vvY = true;
    private int vvZ = -1;
    private int vvr = 17;

    public interface a {
        void aZA();

        void aZB();

        void aZC();

        void aZD();

        void aZE();

        void aZF();

        void aZG();

        void aZt();

        void aZu();

        void aZv();

        void aZw();

        void aZx();

        void aZy();

        void aZz();

        void b(f fVar);

        void sI(int i);

        void sJ(int i);
    }

    public interface b {
        void cbY();
    }

    static /* synthetic */ void a(AppPanel appPanel, boolean z) {
        as.Hm();
        if (c.isSDCardAvailable()) {
            if (!vvX) {
                vvX = true;
                e.post(new Runnable() {
                    public final void run() {
                        com.tencent.mm.modelcdntran.g.MQ();
                        x.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", Integer.valueOf(0));
                        AppPanel.vvX = false;
                    }
                }, "AppPanel_preMakeConnection");
            }
            if (z) {
                appPanel.vvC.sI(0);
                return;
            } else {
                appPanel.vvC.sI(1);
                return;
            }
        }
        u.fJ(appPanel.context);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void init(int i) {
        this.vvH = new a();
        this.vvK = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.vvI = defaultDisplay.getWidth();
            this.vvJ = defaultDisplay.getHeight();
        } else {
            this.vvI = defaultDisplay.getHeight();
            this.vvJ = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.i.daA, this);
        this.qfh = (MMDotView) findViewById(R.h.bKH);
        this.qfg = (MMFlipper) findViewById(R.h.bKI);
        try {
            String value = com.tencent.mm.j.g.Af().getValue("ShowAPPSuggestion");
            if (bi.oN(value) || Integer.valueOf(value).intValue() != 1) {
                this.idy = g.a(this.context, false, this.vvK);
                if (!cbW()) {
                    cz(this.idy);
                }
                cy(this.idy);
                cbT();
                cbP();
            }
            this.idy = g.a(this.context, true, this.vvK);
            if (cbW()) {
                cz(this.idy);
            }
            cy(this.idy);
            cbT();
            cbP();
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.idy = g.a(this.context, false, this.vvK);
        }
    }

    private void cy(List<f> list) {
        boolean z = this.vvL;
        this.vvL = false;
        boolean z2 = this.vvM;
        boolean z3 = this.vvN;
        boolean z4 = this.vvO;
        this.vvM = false;
        this.vvN = false;
        this.vvO = false;
        int i = this.vvK;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.plugin.y.a.a.a.biY() == null) {
            x.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            i = 0;
        } else {
            Cursor dj = com.tencent.mm.plugin.y.a.a.a.biY().dj(0, i);
            if (dj == null) {
                i = 0;
            } else {
                i = dj.getCount();
                dj.close();
            }
        }
        x.d("MicroMsg.AppPanel", "serviceCount, %d", Integer.valueOf(i));
        this.vvT = new HashMap();
        if (i > 0 && list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (!(fVar == null || fVar.field_appId == null || !fVar.bZq())) {
                    boolean z5;
                    int i3;
                    if ((fVar.field_serviceAppInfoFlag & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        this.vvL = true;
                    }
                    if (f.vkN.equals(fVar.field_appId)) {
                        this.vvT.put(f.vkN, fVar);
                        if (!this.vvQ) {
                            this.vvM = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.vkP.equals(fVar.field_appId)) {
                        this.vvT.put(f.vkP, fVar);
                        if (!this.vvP) {
                            this.vvN = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.vkQ.equals(fVar.field_appId)) {
                        this.vvT.put(f.vkQ, fVar);
                        if (!this.vvR) {
                            this.vvO = true;
                        }
                        i = i2 - 1;
                        list.remove(i2);
                        i2 = i;
                    }
                }
                i2++;
            }
        }
        x.d("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(this.vvL));
        if (z != this.vvL || z2 != this.vvM || z3 != this.vvN || z4 != this.vvO) {
            this.vvH.lk(this.vvL);
            this.vvH.ll(this.vvM);
            this.vvH.lm(this.vvN);
            this.vvH.ln(this.vvO);
            cbR();
        }
    }

    public final void cbP() {
        a aVar = this.vvH;
        aVar.vwc.value = true;
        aVar.vwd.value = true;
        aVar.vwe.value = true;
        aVar.vwf.value = true;
        aVar.vwg.value = true;
        aVar.vwh.value = true;
        aVar.vwi.value = true;
        aVar.vwr.value = true;
        aVar.vwp.value = true;
        aVar.vwj.value = true;
        aVar.vwk.value = true;
        aVar.vwl.value = true;
        aVar.vwm.value = true;
        aVar.vwn.value = true;
        aVar.vwo.value = true;
        aVar.vwq.value = true;
        aVar.vws.value = true;
        aVar.vwt.value = false;
        aVar.vwu.value = true;
        aVar.vwv.value = true;
        aVar.vwx.value = true;
        aVar.vwy.value = true;
        aVar.vwx.value = false;
        aVar.vwz.value = true;
        this.vvP = false;
        this.vvQ = false;
        this.vvR = false;
        this.vvS = false;
        cbQ();
        this.vvH.lk(this.vvL);
        this.vvH.ll(this.vvM);
        this.vvH.lm(this.vvN);
        this.vvH.ln(this.vvO);
        cbR();
    }

    public final void cbQ() {
        boolean z = true;
        com.tencent.mm.j.g.Ag();
        boolean z2 = com.tencent.mm.j.c.zQ() == 2;
        this.vvH.vwi.value = true;
        this.vvH.vwo.value = z2;
        this.vvH.vws.value = d.Pu("location");
        if ((q.Gj() & 33554432) != 0) {
            z = false;
        }
        this.vvH.vwq.value = z;
    }

    public final void lj(boolean z) {
        this.vvH.vwn.value = false;
        cbR();
        x.d("MicroMsg.AppPanel", "enable " + this.vvH.vwo.value + " isVoipAudioEnable false");
    }

    public final void cbR() {
        int i;
        int length = this.vvB.length;
        for (i = 0; i < length; i++) {
            this.vvB[i] = true;
        }
        if (this.vvH.vwe.value) {
            i = 0;
        } else {
            this.vvB[0] = false;
            i = 1;
        }
        if (!this.vvH.vwd.value) {
            this.vvB[1] = false;
            i++;
        }
        if (!this.vvH.vwz.value) {
            this.vvB[16] = false;
            i++;
        }
        if (!(this.vvH.vwr.value && this.vvH.vws.value)) {
            this.vvB[6] = false;
            i++;
        }
        if (!this.vvH.vwj.value) {
            this.vvB[14] = false;
            i++;
        }
        if (!this.vvH.vwk.value) {
            this.vvB[8] = false;
            i++;
        }
        if (!this.vvH.vwf.value) {
            this.vvB[11] = false;
            i++;
        }
        if (!this.vvH.vwt.value) {
            this.vvB[13] = false;
            i++;
        }
        if (!this.vvH.vww.value) {
            this.vvB[3] = false;
            i++;
        }
        if (!this.vvH.vwg.value) {
            this.vvB[12] = false;
            i++;
        }
        if (!this.vvH.vwm.value) {
            this.vvB[5] = false;
            i++;
        }
        if (!(this.vvH.vwo.value && this.vvH.vwn.value)) {
            this.vvB[4] = false;
            i++;
        }
        if (!(this.vvH.vwi.value && this.vvH.vwh.value)) {
            this.vvB[2] = false;
            i++;
        }
        if (!(this.vvH.vwq.value && this.vvH.vwp.value)) {
            this.vvB[10] = false;
            i++;
        }
        if (!this.vvH.vwv.value) {
            this.vvB[7] = false;
            i++;
        }
        if (!this.vvH.vwx.value) {
            this.vvB[15] = false;
            i++;
        }
        this.vvB[9] = false;
        this.vvr = 17 - (i + 1);
    }

    private int cbS() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void cbT() {
        x.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.qfg.removeAllViews();
        this.qfg.yiR = new com.tencent.mm.ui.base.MMFlipper.a() {
            public final void dq(int i, int i2) {
                x.d("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + AppPanel.this.qfd);
                if (!AppPanel.this.qfd && i2 != 0 && i != 0) {
                    if (AppPanel.this.cbS() == 2) {
                        x.d("MicroMsg.AppPanel", "landspace");
                    } else {
                        x.d("MicroMsg.AppPanel", "portrait");
                    }
                    AppPanel.this.qfd = true;
                    AppPanel.this.qff = i2;
                    AppPanel.this.qfe = i;
                    AppPanel.this.cbU();
                } else if (i2 == 0 || i == 0) {
                    x.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                }
            }
        };
        this.qfg.yiQ = new com.tencent.mm.ui.base.MMFlipper.b() {
            public final void wb(int i) {
                AppPanel.this.qfh.Fb(i);
            }
        };
        cbV();
    }

    public final void refresh() {
        x.v("MicroMsg.AppPanel", "app panel refleshed");
        try {
            String value = com.tencent.mm.j.g.Af().getValue("ShowAPPSuggestion");
            int cpM;
            if (bi.oN(value) || Integer.valueOf(value).intValue() != 1) {
                this.idy = g.a(this.context, false, this.vvK);
                x.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!cbW()) {
                    cz(this.idy);
                }
                cy(this.idy);
                if (this.vvH != null) {
                    this.vvH.lk(this.vvL);
                    this.vvH.ll(this.vvM);
                    this.vvH.lm(this.vvN);
                    this.vvH.ln(this.vvO);
                }
                cpM = this.qfg.cpM();
                cbU();
                this.qfg.Fe(cpM);
                this.qfh.Fb(cpM);
            }
            x.d("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.idy = g.a(this.context, true, this.vvK);
            if (cbW()) {
                cz(this.idy);
            }
            cy(this.idy);
            if (this.vvH != null) {
                this.vvH.lk(this.vvL);
                this.vvH.ll(this.vvM);
                this.vvH.lm(this.vvN);
                this.vvH.ln(this.vvO);
            }
            cpM = this.qfg.cpM();
            cbU();
            this.qfg.Fe(cpM);
            this.qfh.Fb(cpM);
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.idy = g.a(this.context, false, this.vvK);
        }
    }

    private void cbU() {
        if (this.qfe != 0 && this.qff != 0) {
            AppGrid appGrid;
            this.vvE = new ArrayList();
            this.qfg.removeAllViews();
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 82.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 90.0f);
            requestLayout();
            cbR();
            if (this.vvU) {
                b = 4;
            } else {
                b = this.qfe / b;
            }
            int i = this.qff / b2;
            if (i > 2) {
                i = 2;
            }
            int i2 = (this.qff - (b2 * i)) / (i + 1);
            x.d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf(i2));
            x.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(this.qfe), Integer.valueOf(this.qff));
            if (b == 0) {
                b2 = 1;
            } else {
                b2 = b;
            }
            if (i == 0) {
                i = 1;
            }
            this.vvG = i;
            int i3 = b2 * i;
            if (this.vvH.vwl.value) {
                this.vvF = this.vvr + this.idy.size();
            } else {
                this.vvF = this.vvr;
            }
            int ceil = (int) Math.ceil(((double) this.vvF) / ((double) i3));
            x.d("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d", Integer.valueOf(this.vvF), Integer.valueOf(i3), Integer.valueOf(ceil));
            for (i = 0; i < ceil; i++) {
                appGrid = (AppGrid) inflate(this.context, R.i.daw, null);
                appGrid.vvs = new a(appGrid.context, this.idy, this.vvT);
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter(appGrid.vvs);
                appGrid.setOnItemClickListener(appGrid.kMo);
                appGrid.setOnItemLongClickListener(appGrid.mzB);
                appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(appGrid.context, 16.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(appGrid.context, 6.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(appGrid.context, 16.0f), 0);
                int i4 = this.vvF;
                int i5 = this.vvr;
                appGrid.vvq = i;
                appGrid.vvn = i4;
                appGrid.vvo = i3;
                appGrid.vvp = ceil;
                appGrid.vvr = i5;
                appGrid.setNumColumns(b2);
                if (i2 > 0) {
                    appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(appGrid.context, 16.0f), i2, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i2 / 2);
                }
                this.qfg.addView(appGrid, new LayoutParams(-1, -2));
                this.vvE.add(appGrid);
            }
            if (this.vvE != null) {
                for (AppGrid appGrid2 : this.vvE) {
                    appGrid2.vvm = this.vvW;
                }
            }
            if (this.vvE.size() <= 1) {
                this.qfh.setVisibility(4);
                return;
            }
            this.qfh.setVisibility(0);
            this.qfh.Fa(this.vvE.size());
            b = this.qfg.cpM();
            this.qfg.Fe(b);
            this.qfh.Fb(b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.vvU = true;
            } else {
                this.vvU = false;
            }
            this.vvY = true;
            ti();
        }
    }

    public final void ti() {
        this.qfd = false;
        this.qfg.Fe(0);
        cbT();
        requestLayout();
    }

    public final void Cy(int i) {
        if (this.vvZ != i) {
            this.vvZ = i;
            this.vvY = true;
        }
    }

    public final void cbV() {
        if (this.vvY) {
            LayoutParams layoutParams;
            int b;
            View view;
            ViewGroup.LayoutParams layoutParams2;
            View findViewById;
            if (cbS() == 2) {
                x.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(R.h.bKG);
                layoutParams = new LayoutParams(-1, 0);
                b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, (float) qeT);
                view = findViewById;
                layoutParams2 = layoutParams;
            } else {
                x.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(qeS));
                findViewById = findViewById(R.h.bKG);
                ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, 0);
                if (this.vvZ > 0) {
                    b = this.vvZ;
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                } else {
                    b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, (float) qeS);
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                }
            }
            layoutParams3.height = b;
            view.setLayoutParams(layoutParams2);
            this.vvY = false;
        }
    }

    private static void cz(List<f> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    f fVar = (f) list.get(i2);
                    if (fVar == null || !f.vkO.equals(fVar.field_appId)) {
                        i = i2 + 1;
                    } else {
                        list.remove(fVar);
                        return;
                    }
                }
                return;
            }
        }
    }

    private boolean cbW() {
        if (this.vvS) {
            return false;
        }
        com.tencent.mm.pluginsdk.q.c cVar = com.tencent.mm.pluginsdk.q.a.vjb;
        if (cVar == null || !cVar.auQ() || cVar.auT() <= 0) {
            return false;
        }
        return true;
    }
}
