package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.jq;
import com.tencent.mm.plugin.webwx.a.c;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements e {
    private boolean fBk = false;
    private String fHr = null;
    private int hPf = 0;
    private ProgressDialog nRI = null;
    private boolean tUL = false;
    private String tUV = null;
    private int tUW;
    private int tUX;
    private boolean tUY = false;
    private Button tUZ;
    private TextView tVa;
    private int type = 0;

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final k cVar = new c(extDeviceWXLoginUI.fHr);
        as.CN().a(cVar, 0);
        extDeviceWXLoginUI.nRI = h.a(extDeviceWXLoginUI.mController.xRr, extDeviceWXLoginUI.getString(R.l.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(cVar);
                if (ExtDeviceWXLoginUI.this.nRI != null) {
                    ExtDeviceWXLoginUI.this.nRI.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        final k eVar = new com.tencent.mm.plugin.webwx.a.e(extDeviceWXLoginUI.fHr, extDeviceWXLoginUI.tUV, z);
        as.CN().a(eVar, 0);
        extDeviceWXLoginUI.nRI = h.a(extDeviceWXLoginUI.mController.xRr, extDeviceWXLoginUI.getString(R.l.ctG), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(eVar);
                if (ExtDeviceWXLoginUI.this.nRI != null) {
                    ExtDeviceWXLoginUI.this.nRI.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(R.h.cZh);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height));
        extDeviceWXLoginUI.findViewById(R.h.cPw).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        initView();
        overridePendingTransition(R.a.bqo, R.a.bpQ);
    }

    protected void onResume() {
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 8;
        r11 = 2;
        r2 = 1;
        r3 = 0;
        r0 = r14.getIntent();
        r1 = "intent.key.login.url";
        r0 = r0.getStringExtra(r1);
        r14.fHr = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.type";
        r0 = r0.getIntExtra(r1, r3);
        r14.type = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.title.string";
        r1 = r0.getStringExtra(r1);
        r0 = r14.getIntent();
        r4 = "intent.key.icon.type";
        r0 = r0.getIntExtra(r4, r3);
        r14.hPf = r0;
        r0 = r14.getIntent();
        r4 = "intent.key.ok.string";
        r4 = r0.getStringExtra(r4);
        r0 = r14.getIntent();
        r5 = "intent.key.cancel.string";
        r5 = r0.getStringExtra(r5);
        r0 = r14.getIntent();
        r6 = "intent.key.content.string";
        r6 = r0.getStringExtra(r6);
        r0 = r14.getIntent();
        r7 = "intent.key.ok.session.list";
        r0 = r0.getStringExtra(r7);
        r14.tUV = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.login.client.version";
        r0 = r0.getIntExtra(r7, r3);
        r14.tUW = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.function.control";
        r0 = r0.getIntExtra(r7, r3);
        r14.tUX = r0;
        r0 = "MicroMsg.ExtDeviceWXLoginUI";
        r7 = "type:%s title:%s ok:%s content:%s";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = r14.type;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r3] = r9;
        r8[r2] = r1;
        r8[r11] = r4;
        r8[r13] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r7, r8);
        r0 = "";
        r14.setMMTitle(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r0 != 0) goto L_0x00b1;
    L_0x00a6:
        r0 = com.tencent.mm.R.h.cPA;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r1);
    L_0x00b1:
        r0 = new com.tencent.mm.f.a.jp;
        r0.<init>();
        r1 = com.tencent.mm.sdk.b.a.xmy;
        r1.m(r0);
        r1 = r0.fBd;
        r1 = r1.fBe;
        r7 = r0.fBd;
        r7 = r7.fBf;
        r0 = r0.fBd;
        r0 = r0.fBg;
        r8 = r14.hPf;
        switch(r8) {
            case 1: goto L_0x0188;
            case 2: goto L_0x019a;
            default: goto L_0x00cc;
        };
    L_0x00cc:
        com.tencent.mm.y.as.Hm();
        r8 = com.tencent.mm.y.c.Db();
        r9 = com.tencent.mm.storage.w.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT;
        r10 = java.lang.Integer.valueOf(r3);
        r8.a(r9, r10);
    L_0x00dc:
        r8 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
        if (r8 != 0) goto L_0x01ad;
    L_0x00e2:
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cPt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cPt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r6);
    L_0x0103:
        r0 = com.tencent.mm.R.h.cPw;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1 = r14.hPf;
        if (r1 == r2) goto L_0x0292;
    L_0x010f:
        r1 = r14.hPf;
        if (r1 != r11) goto L_0x027b;
    L_0x0113:
        r1 = com.tencent.mm.R.k.dyg;
        r0.setImageResource(r1);
    L_0x0118:
        r0 = com.tencent.mm.R.h.cZj;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r14.tVa = r0;
        r0 = r14.tVa;
        r0.setText(r5);
        r0 = r14.tVa;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$1;
        r1.<init>();
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.R.h.cZg;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r14.tUZ = r0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r0 != 0) goto L_0x02bb;
    L_0x0141:
        r0 = r14.tUZ;
        r0.setText(r4);
        r0 = r14.type;
        if (r0 != 0) goto L_0x0299;
    L_0x014a:
        r0 = r14.tUZ;
        r0.setEnabled(r2);
    L_0x014f:
        r0 = r14.tUZ;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$2;
        r1.<init>();
        r0.setOnClickListener(r1);
        r0 = r14.mController;
        r0 = r0.contentView;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$3;
        r1.<init>();
        r0.post(r1);
        r0 = com.tencent.mm.R.h.cZi;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$4;
        r1.<init>();
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.y.as.CN();
        r1 = 972; // 0x3cc float:1.362E-42 double:4.8E-321;
        r0.a(r1, r14);
        r0 = com.tencent.mm.y.as.CN();
        r1 = 973; // 0x3cd float:1.363E-42 double:4.807E-321;
        r0.a(r1, r14);
        return;
    L_0x0188:
        com.tencent.mm.y.as.Hm();
        r8 = com.tencent.mm.y.c.Db();
        r9 = com.tencent.mm.storage.w.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT;
        r10 = java.lang.Integer.valueOf(r13);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x019a:
        com.tencent.mm.y.as.Hm();
        r8 = com.tencent.mm.y.c.Db();
        r9 = com.tencent.mm.storage.w.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT;
        r10 = 4;
        r10 = java.lang.Integer.valueOf(r10);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x01ad:
        if (r1 < 0) goto L_0x0103;
    L_0x01af:
        r1 = r14.tUX;
        r1 = r1 & 1;
        if (r1 <= 0) goto L_0x0224;
    L_0x01b5:
        r1 = r2;
    L_0x01b6:
        r6 = "MicroMsg.ExtDeviceWXLoginUI";
        r8 = "msgsynchronize needCheckedSync[%b], iconType[%d]";
        r9 = new java.lang.Object[r11];
        r10 = java.lang.Boolean.valueOf(r1);
        r9[r3] = r10;
        r10 = r14.hPf;
        r10 = java.lang.Integer.valueOf(r10);
        r9[r2] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r6, r8, r9);
        r6 = r14.hPf;
        if (r6 != r2) goto L_0x0226;
    L_0x01d3:
        r6 = r14.tUW;
        if (r6 < r7) goto L_0x0226;
    L_0x01d7:
        r14.tUL = r2;
        r0 = com.tencent.mm.R.h.cPt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.eXy;
        r0.setText(r6);
        if (r1 == 0) goto L_0x0217;
    L_0x01fe:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x0217:
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x0224:
        r1 = r3;
        goto L_0x01b6;
    L_0x0226:
        r6 = r14.hPf;
        if (r6 != r11) goto L_0x0103;
    L_0x022a:
        r6 = r14.tUW;
        if (r6 < r0) goto L_0x0103;
    L_0x022e:
        r14.tUL = r2;
        r0 = com.tencent.mm.R.h.cPt;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.eXx;
        r0.setText(r6);
        if (r1 == 0) goto L_0x026e;
    L_0x0255:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x026e:
        r0 = com.tencent.mm.R.h.cPu;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x027b:
        r1 = r14.hPf;
        if (r1 != r13) goto L_0x0286;
    L_0x027f:
        r1 = com.tencent.mm.R.k.dyf;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0286:
        r1 = r14.hPf;
        r6 = 5;
        if (r1 != r6) goto L_0x0292;
    L_0x028b:
        r1 = com.tencent.mm.R.k.dym;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0292:
        r1 = com.tencent.mm.R.k.dyk;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0299:
        r0 = r14.type;
        r1 = -1;
        if (r0 != r1) goto L_0x02af;
    L_0x029e:
        r0 = r14.tUZ;
        r0.setEnabled(r3);
        r0 = r14.hPf;
        r1 = 5;
        if (r0 != r1) goto L_0x014f;
    L_0x02a8:
        r0 = r14.tVa;
        r0.setVisibility(r12);
        goto L_0x014f;
    L_0x02af:
        r0 = r14.type;
        r1 = -2;
        if (r0 != r1) goto L_0x014f;
    L_0x02b4:
        r0 = r14.tUZ;
        r0.setEnabled(r2);
        goto L_0x014f;
    L_0x02bb:
        r0 = r14.tUZ;
        r1 = 4;
        r0.setVisibility(r1);
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.initView():void");
    }

    protected void onPause() {
        super.onPause();
        if (this.tUY && as.Hp()) {
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = 27;
            wuVar.wnQ = q.gM(q.Ge()) ? 1 : 2;
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, wuVar));
            this.tUY = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.dfz;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bqm);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(972, (e) this);
        as.CN().b(973, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.nRI != null) {
            this.nRI.dismiss();
            this.nRI = null;
        }
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i2), Integer.valueOf(i));
            as.CN().b(972, (e) this);
            if (kVar.getType() == 972) {
                com.tencent.mm.plugin.webwx.a.e eVar = (com.tencent.mm.plugin.webwx.a.e) kVar;
                if (eVar.tUL || this.fBk) {
                    ub ubVar = (ub) eVar.hGV.hnR.hnY;
                    byte[] toByteArray = (ubVar == null || ubVar.wiP == null) ? null : ubVar.wiP.toByteArray();
                    b jqVar = new jq();
                    jqVar.fBh.fBi = toByteArray;
                    jqVar.fBh.fBj = this.hPf;
                    jqVar.fBh.fBk = this.fBk;
                    com.tencent.mm.sdk.b.a.xmy.m(jqVar);
                }
            } else {
                kVar.getType();
            }
            this.type = 0;
            finish();
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!bi.oN(str)) {
            ((CheckBox) findViewById(R.h.cPu)).setVisibility(8);
            ((TextView) findViewById(R.h.cPt)).setVisibility(0);
            ((TextView) findViewById(R.h.cPt)).setText(str);
        }
        if (this.type == -1) {
            if (this.tUZ != null) {
                this.tUZ.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.tUZ != null) {
                this.tUZ.setEnabled(true);
                this.tUZ.setText(R.l.eXz);
            }
            if (this.tVa != null) {
                this.tVa.setVisibility(4);
            }
        }
        x.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }
}
