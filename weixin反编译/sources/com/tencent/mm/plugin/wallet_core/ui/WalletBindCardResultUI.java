package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.io;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.plugin.wallet_core.c.m;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;

@a(3)
public class WalletBindCardResultUI extends WalletBaseUI {
    private String pUC;
    private TextView pVl;
    private c peh = new c<sy>() {
        {
            this.xmG = sy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sy syVar = (sy) bVar;
            if (!(syVar instanceof sy)) {
                return false;
            }
            if (!syVar.fMg.fMh.pcZ) {
                x.i("MicroMsg.WalletBindCardResultUI", "block pass");
                return true;
            } else if (!"1".equals(syVar.fMg.fMh.fLK) && !"2".equals(syVar.fMg.fMh.fLK)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(syVar.fMg.fMh.fLK, syVar.fMg.fMh.fLL, syVar.fMg.fMh.fLM, syVar.fMg.fMh.fLN, syVar.fMg.fMh.fLO, WalletBindCardResultUI.this.sKT == null ? 0 : WalletBindCardResultUI.this.sKT.fDQ);
                x.i("MicroMsg.WalletBindCardResultUI", "receive guide");
                WalletBindCardResultUI.this.vf.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    private String phx = null;
    private PayInfo sKT;
    private int sTM;
    private BindCardOrder sXD;
    private boolean sXE = false;
    private String sXF;
    private String sXG;
    private n.b sXH;
    private b sXI;
    private HashMap<String, a> sXJ = new HashMap();
    private String sXK;
    private BindCardOrder sXL = null;
    private String sXM = "-1";
    private Button sXN;
    private ImageView sXO;
    private ViewGroup sXP;
    private CdnImageView sXQ;
    private TextView sXR;
    private TextView sXS;
    private View sXT;
    private Button sXU;
    private ViewGroup sXV;
    private boolean sXW = false;
    private boolean sXX = false;
    private boolean sXY = false;
    private com.tencent.mm.wallet_core.c sXZ;

    static /* synthetic */ void b(WalletBindCardResultUI walletBindCardResultUI) {
        String str = "MicroMsg.WalletBindCardResultUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletBindCardResultUI.sXL != null ? walletBindCardResultUI.sXL.sSb.sOB : 0);
        x.i(str, str2, objArr);
        if (walletBindCardResultUI.sXL != null && walletBindCardResultUI.sXL.sSb.sOB > 0) {
            walletBindCardResultUI.gJ(2);
            walletBindCardResultUI.sXX = true;
            if (!walletBindCardResultUI.sXM.equals("-1") && !walletBindCardResultUI.sXM.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                return;
            }
            if (walletBindCardResultUI.sXD.bLI()) {
                BindCardOrder bindCardOrder = walletBindCardResultUI.sXL;
                walletBindCardResultUI.r(new m(bindCardOrder, bindCardOrder.sSb.sOB, bindCardOrder.sSb.sTC, bindCardOrder.sSb.sTD, bindCardOrder.sSb.sTE, bindCardOrder.sSb.sTF, bindCardOrder.sSb.sTB, walletBindCardResultUI.sXD.pff, walletBindCardResultUI.sXD.sRY, walletBindCardResultUI.sXD.sRZ, walletBindCardResultUI.sXD.sSa));
            } else if (!walletBindCardResultUI.sXD.bLH() || bi.oN(walletBindCardResultUI.sXL.sSc.url)) {
                x.e("MicroMsg.WalletBindCardResultUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
            } else if (walletBindCardResultUI.sXJ.containsKey(walletBindCardResultUI.sXL.sSb.sOB)) {
                a aVar = (a) walletBindCardResultUI.sXJ.get(walletBindCardResultUI.sXL.sSb.sOB);
                x.i("MicroMsg.WalletBindCardResultUI", "go to new url %s", aVar.url);
                if (bi.oN(aVar.url)) {
                    walletBindCardResultUI.NS(walletBindCardResultUI.sXL.sSc.url);
                } else {
                    walletBindCardResultUI.NS(aVar.url);
                }
            } else {
                walletBindCardResultUI.sXK = walletBindCardResultUI.sXL.sSc.url;
                String str3 = walletBindCardResultUI.sXL.sSc.url;
                b bVar = new b(walletBindCardResultUI.sXL.sSb.sOB, walletBindCardResultUI.sXL.sSb.sTC, walletBindCardResultUI.sXL.sSb.sTD, walletBindCardResultUI.sXL.sSb.sTE, walletBindCardResultUI.bKA(), walletBindCardResultUI.pUC, walletBindCardResultUI.sXL.sSb.sTF, walletBindCardResultUI.sXL.sSb.sTB);
                walletBindCardResultUI.bNg();
                walletBindCardResultUI.sXI = bVar;
                e.s(walletBindCardResultUI, str3, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.fN(21)) {
            if (d.fN(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        uV(4);
        com.tencent.mm.wallet_core.a.ag(this);
        this.sKT = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.vf.getInt("key_pay_type", -1);
        BindCardOrder bindCardOrder = (BindCardOrder) this.vf.getParcelable("key_bindcard_value_result");
        if (bindCardOrder == null) {
            bindCardOrder = new BindCardOrder();
        }
        this.sXD = bindCardOrder;
        uV(0);
        initView();
        this.sXZ = cCT();
        bNe();
        gJ(1);
        jl(1979);
        com.tencent.mm.sdk.b.a.xmy.b(this.peh);
        this.sXY = true;
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletBindCardResultUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", Boolean.valueOf(this.sXY), this.sXL, Boolean.valueOf(this.sXW), Boolean.valueOf(this.sXX), this.sXH);
        if (this.sXY) {
            this.sXY = false;
        } else if (this.sXL != null && this.sXX) {
            l(new com.tencent.mm.plugin.wallet_core.c.x(this.sXL.sSb.sOB, this.sXL.sSb.sTC, this.sXL.sSb.sTD, this.sXL.sSb.sTE, this.sXL.sSb.sTB, this.sXL.sSb.sTF, this.sXD.pff, this.sXD.sRY, this.sXD.sRZ, this.sXD.sRZ));
        } else if (this.sXW && this.sXH != null) {
            l(new com.tencent.mm.plugin.wallet_core.c.x(this.sXD.sSb.sOB, this.sXD.sSb.sTC, this.sXD.sSb.sTD, this.sXD.sSb.sTE, this.sXD.sSb.sTF, this.sXD.sSb.sTB, this.sXD.pff, this.sXD.sRY, this.sXD.sRZ, this.sXD.sRZ));
        }
    }

    protected final void initView() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.sXO = (ImageView) findViewById(f.uHo);
        this.pVl = (TextView) findViewById(f.uzq);
        this.sXN = (Button) findViewById(f.uzn);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(i.dFw);
        if (this.sXD == null || bi.oN(this.sXD.sRU)) {
            this.sXN.setText(string);
        } else {
            this.sXN.setText(this.sXD.sRU);
        }
        this.sXN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBindCardResultUI.this.done();
            }
        });
        this.sXV = (ViewGroup) findViewById(f.uFJ);
        this.sXP = (ViewGroup) findViewById(f.uDy);
        this.sXQ = (CdnImageView) findViewById(f.uDA);
        this.sXQ.vtO = true;
        this.sXR = (TextView) findViewById(f.uDx);
        this.sXS = (TextView) findViewById(f.uDC);
        this.sXU = (Button) findViewById(f.uDv);
        this.sXT = findViewById(f.uDz);
        this.sXV.setVisibility(4);
        bNe();
        bNf();
        bNd();
        if (!bi.oN(this.sXD.sRW) && !bi.oN(this.sXD.sRX)) {
            ((TextView) findViewById(f.uzr)).setText(getString(i.uWr, new Object[]{this.sXD.sRW, this.sXD.sRX}));
        }
    }

    private void bNd() {
        this.sXV.setVisibility(0);
    }

    private void bNe() {
        this.pVl.setText(this.sXD.sRV);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bNf() {
        /*
        r10 = this;
        r9 = 15;
        r8 = 9;
        r7 = 8;
        r2 = 1;
        r3 = 0;
        r0 = r10.sXP;
        r1 = 4;
        r0.setVisibility(r1);
        r10.sXX = r3;
        r10.sXW = r3;
        r0 = r10.sXD;
        if (r0 == 0) goto L_0x016d;
    L_0x0016:
        r0 = r10.sXD;
        r0 = r0.sSb;
        if (r0 == 0) goto L_0x015b;
    L_0x001c:
        r0 = "MicroMsg.WalletBindCardResultUI";
        r1 = "activityPromotions: %s";
        r4 = new java.lang.Object[r2];
        r5 = r10.sXL;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = r10.sXD;
        if (r0 == 0) goto L_0x0223;
    L_0x002f:
        r0 = r10.sXD;
        r0 = r0.bLH();
        if (r0 != 0) goto L_0x003f;
    L_0x0037:
        r0 = r10.sXD;
        r0 = r0.bLI();
        if (r0 == 0) goto L_0x0223;
    L_0x003f:
        r0 = r10.sXD;
        r0 = r0.sSb;
        r0 = r0.sOB;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0223;
    L_0x004b:
        r0 = r10.sXD;
        r0 = r0.sSc;
        r0 = r0.sTG;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0223;
    L_0x0057:
        r0 = r10.sXD;
        r10.sXL = r0;
        r0 = r10.sXT;
        r0.setVisibility(r7);
        r0 = r10.sXQ;
        r0.vtN = r2;
        r0 = r10.sXU;
        r0.setEnabled(r2);
        r0 = r10.sXU;
        r1 = com.tencent.mm.plugin.wxpay.a.e.bAc;
        r0.setBackgroundResource(r1);
        r0 = r10.sXS;
        r1 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r0.setCompoundDrawables(r1, r4, r5, r6);
        r0 = r10.sXJ;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = r10.sXL;
        r4 = r4.sSb;
        r4 = r4.sOB;
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a) r0;
        if (r0 == 0) goto L_0x018b;
    L_0x0096:
        r1 = r0.fED;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x00a5;
    L_0x009e:
        r1 = r10.sXQ;
        r4 = r0.fED;
        r1.setUrl(r4);
    L_0x00a5:
        r1 = r0.fzT;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x00b4;
    L_0x00ad:
        r1 = r10.sXR;
        r4 = r0.fzT;
        r1.setText(r4);
    L_0x00b4:
        r1 = r0.taB;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x00ca;
    L_0x00bc:
        r1 = r10.sXU;
        r4 = r0.taB;
        r1.setText(r4);
        r1 = r10.sXU;
        r4 = com.tencent.mm.plugin.wxpay.a.e.ukt;
        r1.setBackgroundResource(r4);
    L_0x00ca:
        r1 = r10.sXS;
        r1 = r1.getLayoutParams();
        r1 = (android.widget.RelativeLayout.LayoutParams) r1;
        if (r0 == 0) goto L_0x01ae;
    L_0x00d4:
        r4 = r0.title;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r4 != 0) goto L_0x01ae;
    L_0x00dc:
        r4 = r10.sXS;
        r0 = r0.title;
        r4.setText(r0);
        r1.addRule(r9, r3);
    L_0x00e6:
        r0 = r10.sXS;
        r0.setLayoutParams(r1);
        r0 = r10.sXU;
        r0.setVisibility(r3);
        r0 = r10.sXU;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$3;
        r1.<init>();
        r0.setOnClickListener(r1);
        r0 = r10.sXL;
        r0 = r0.sSb;
        r0 = r0.sTB;
        r4 = 1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x0110;
    L_0x0106:
        r0 = r10.sXP;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$4;
        r1.<init>();
        r0.setOnClickListener(r1);
    L_0x0110:
        r1 = r10.sXM;
        r0 = -1;
        r4 = r1.hashCode();
        switch(r4) {
            case 48: goto L_0x01d5;
            case 49: goto L_0x0210;
            case 50: goto L_0x0204;
            case 51: goto L_0x01ec;
            case 52: goto L_0x01f8;
            case 1444: goto L_0x01e1;
            default: goto L_0x011a;
        };
    L_0x011a:
        r2 = r0;
    L_0x011b:
        switch(r2) {
            case 0: goto L_0x021c;
            default: goto L_0x011e;
        };
    L_0x011e:
        r0 = r10.sXR;
        r0 = r0.getText();
        r1 = com.tencent.mm.sdk.platformtools.bi.N(r0);
        if (r1 != 0) goto L_0x0141;
    L_0x012a:
        r1 = r0.length();
        if (r1 <= r8) goto L_0x0141;
    L_0x0130:
        r1 = r10.sXR;
        r0 = r0.subSequence(r3, r8);
        r1.setText(r0);
        r0 = r10.sXR;
        r1 = "...";
        r0.append(r1);
    L_0x0141:
        r0 = r10.sXP;
        r0 = r0.getLayoutParams();
        r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        r1 = 50;
        r1 = com.tencent.mm.bu.a.fromDPToPix(r10, r1);
        r0.topMargin = r1;
        r1 = r10.sXP;
        r1.setLayoutParams(r0);
    L_0x0156:
        r0 = r10.sXP;
        r0.setVisibility(r3);
    L_0x015b:
        r0 = r10.sXR;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x016d;
    L_0x0163:
        r0 = r10.sXR;
        r1 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$6;
        r1.<init>();
        r0.post(r1);
    L_0x016d:
        r0 = r10.sXP;
        r0 = r0.getVisibility();
        if (r0 != r7) goto L_0x018a;
    L_0x0175:
        r0 = r10.sXO;
        r0 = r0.getLayoutParams();
        r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        r1 = 91;
        r1 = com.tencent.mm.bu.a.fromDPToPix(r10, r1);
        r0.topMargin = r1;
        r1 = r10.sXO;
        r1.setLayoutParams(r0);
    L_0x018a:
        return;
    L_0x018b:
        r1 = r10.sXQ;
        r4 = r10.sXD;
        r4 = r4.sSc;
        r4 = r4.pkG;
        r1.setUrl(r4);
        r1 = r10.sXR;
        r4 = r10.sXD;
        r4 = r4.sSc;
        r4 = r4.name;
        r1.setText(r4);
        r1 = r10.sXU;
        r4 = r10.sXD;
        r4 = r4.sSc;
        r4 = r4.sTG;
        r1.setText(r4);
        goto L_0x00ca;
    L_0x01ae:
        r0 = r10.sXD;
        r0 = r0.sSc;
        r0 = r0.title;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x01ca;
    L_0x01ba:
        r0 = r10.sXS;
        r4 = r10.sXD;
        r4 = r4.sSc;
        r4 = r4.title;
        r0.setText(r4);
        r1.addRule(r9, r3);
        goto L_0x00e6;
    L_0x01ca:
        r0 = r10.sXS;
        r0.setVisibility(r7);
        r0 = -1;
        r1.addRule(r9, r0);
        goto L_0x00e6;
    L_0x01d5:
        r2 = "0";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011a;
    L_0x01de:
        r2 = r3;
        goto L_0x011b;
    L_0x01e1:
        r4 = "-1";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x011a;
    L_0x01ea:
        goto L_0x011b;
    L_0x01ec:
        r2 = "3";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011a;
    L_0x01f5:
        r2 = 2;
        goto L_0x011b;
    L_0x01f8:
        r2 = "4";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011a;
    L_0x0201:
        r2 = 3;
        goto L_0x011b;
    L_0x0204:
        r2 = "2";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011a;
    L_0x020d:
        r2 = 4;
        goto L_0x011b;
    L_0x0210:
        r2 = "1";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x011a;
    L_0x0219:
        r2 = 5;
        goto L_0x011b;
    L_0x021c:
        r0 = r10.sXU;
        r0.setEnabled(r3);
        goto L_0x011e;
    L_0x0223:
        r0 = r10.sXD;
        r0 = r0.sSd;
        if (r0 == 0) goto L_0x015b;
    L_0x0229:
        r0 = r10.sXD;
        r0 = r0.sSd;
        r0 = r0.sGf;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x015b;
    L_0x0235:
        r0 = r10.sXD;
        r1 = r0.jumpType;
        r4 = com.tencent.mm.plugin.wallet_core.model.BindCardOrder.sRR;
        if (r1 != r4) goto L_0x0372;
    L_0x023d:
        r0 = r0.sSd;
        if (r0 == 0) goto L_0x0372;
    L_0x0241:
        r0 = r2;
    L_0x0242:
        if (r0 == 0) goto L_0x015b;
    L_0x0244:
        r0 = r10.sXD;
        r0 = r0.sSd;
        r0 = r0.sGf;
        r10.sXF = r0;
        r0 = r10.sXD;
        r0 = r0.sSd;
        r0 = r0.sGg;
        r10.sXG = r0;
        r0 = r10.sXD;
        r0 = r0.sSd;
        r0 = r0.sTM;
        r10.sTM = r0;
        r0 = r10.sXD;
        r0 = r0.sSd;
        r10.sXH = r0;
        r0 = r10.sXQ;
        r1 = r10.sXD;
        r1 = r1.sSd;
        r1 = r1.sTJ;
        r0.setUrl(r1);
        r0 = r10.sXR;
        r1 = r10.sXD;
        r1 = r1.sSd;
        r1 = r1.sTK;
        r0.setText(r1);
        r0 = r10.sXS;
        r1 = com.tencent.mm.plugin.wxpay.a.i.uVq;
        r1 = r10.getString(r1);
        r0.setText(r1);
        r0 = r10.sXS;
        r0.setVisibility(r3);
        r0 = r10.sXQ;
        r0.vtN = r2;
        r0 = r10.sXU;
        r0.setEnabled(r2);
        r0 = r10.sXU;
        r1 = com.tencent.mm.plugin.wxpay.a.e.bAc;
        r0.setBackgroundResource(r1);
        r0 = r10.sXS;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.RelativeLayout.LayoutParams) r0;
        r0.addRule(r9, r3);
        r1 = r10.sXS;
        r1.setLayoutParams(r0);
        r0 = r10.sXD;
        r0 = r0.sSb;
        r0 = r0.sOB;
        r4 = 0;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0375;
    L_0x02b4:
        r0 = r10.sXD;
        r0 = r0.sSd;
        r0 = r0.sTL;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x02d5;
    L_0x02c0:
        r0 = r10.sXU;
        r0.setVisibility(r3);
        r0 = r10.sXU;
        r1 = r10.sXD;
        r1 = r1.sSd;
        r1 = r1.sTL;
        r0.setText(r1);
        r0 = r10.sXT;
        r0.setVisibility(r7);
    L_0x02d5:
        r0 = r10.sXJ;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r10.sXD;
        r2 = r2.sSb;
        r4 = r2.sOB;
        r1 = r1.append(r4);
        r1 = r1.toString();
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.a) r0;
        if (r0 == 0) goto L_0x033e;
    L_0x02f2:
        r1 = r0.sTJ;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0301;
    L_0x02fa:
        r1 = r10.sXQ;
        r2 = r0.sTJ;
        r1.setUrl(r2);
    L_0x0301:
        r1 = r0.sTK;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0310;
    L_0x0309:
        r1 = r10.sXR;
        r2 = r0.sTK;
        r1.setText(r2);
    L_0x0310:
        r1 = r0.sTL;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0326;
    L_0x0318:
        r1 = r10.sXU;
        r2 = r0.sTL;
        r1.setText(r2);
        r1 = r10.sXU;
        r2 = com.tencent.mm.plugin.wxpay.a.e.ukt;
        r1.setBackgroundResource(r2);
    L_0x0326:
        r1 = r0.sGf;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0332;
    L_0x032e:
        r1 = r0.sGf;
        r10.sXF = r1;
    L_0x0332:
        r1 = r0.sGg;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x033e;
    L_0x033a:
        r0 = r0.sGg;
        r10.sXG = r0;
    L_0x033e:
        r0 = new com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI$5;
        r0.<init>();
        r1 = r10.sXP;
        r1.setOnClickListener(r0);
        r1 = r10.sXU;
        r1.setOnClickListener(r0);
        r0 = r10.sXR;
        r0 = r0.getText();
        r1 = com.tencent.mm.sdk.platformtools.bi.N(r0);
        if (r1 != 0) goto L_0x0156;
    L_0x0359:
        r1 = r0.length();
        if (r1 <= r8) goto L_0x0156;
    L_0x035f:
        r1 = r10.sXR;
        r0 = r0.subSequence(r3, r8);
        r1.setText(r0);
        r0 = r10.sXR;
        r1 = "...";
        r0.append(r1);
        goto L_0x0156;
    L_0x0372:
        r0 = r3;
        goto L_0x0242;
    L_0x0375:
        r0 = r10.sXU;
        r0.setVisibility(r7);
        r0 = r10.sXT;
        r0.setVisibility(r7);
        goto L_0x033e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.bNf():void");
    }

    private void NS(String str) {
        bNg();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletBindCardResultUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            x.i("MicroMsg.WalletBindCardResultUI", "do query pay arawrd");
            l(new com.tencent.mm.plugin.wallet_core.c.x(this.sXI.sOY, this.sXI.taD, this.sXI.taE, this.sXI.taF, this.sXI.sUY, this.sXI.taG, this.sXD.pff, this.sXD.sRY, this.sXD.sRZ, this.sXD.sRZ));
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return h.a(this.mController.xRr, getString(i.vae), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.ugS), "", new h.c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletBindCardResultUI.this.phx).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        WalletBindCardResultUI.this.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return g.uLi;
    }

    public final void done() {
        Bundle bundle = new Bundle();
        if (this.sXZ != null) {
            this.sXZ.a((Activity) this, 0, bundle);
        } else {
            finish();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.peh);
        jm(1979);
    }

    private void bNg() {
        int i = 0;
        if (!this.sXE) {
            b ioVar = new io();
            ioVar.fzP.fzQ = 4;
            io.a aVar = ioVar.fzP;
            if (this.vf.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            com.tencent.mm.sdk.b.a.xmy.m(ioVar);
            this.sXE = true;
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.c.x xVar = (com.tencent.mm.plugin.wallet_core.c.x) kVar;
                a aVar = new a(xVar.oxl);
                if (this.sXI != null) {
                    this.sXJ.put(xVar.sOY, aVar);
                    bNf();
                    bNd();
                } else if (this.sXW) {
                    this.sXJ.put(xVar.sOY, aVar);
                    bNf();
                    bNd();
                }
            }
        } else if (kVar instanceof m) {
            if (i == 0 && i2 == 0) {
                m mVar = (m) kVar;
                String str2 = mVar.sOI;
                if (this.sXL != null && this.sXL.sSb.sOB == mVar.sOK.sSb.sOB) {
                    x.i("MicroMsg.WalletBindCardResultUI", "activityAwardState: %s", this.sXL);
                    this.sXM = str2;
                    bNf();
                    bNd();
                    if (!(bi.oN(mVar.lfa) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.sXU.setText(mVar.lfa);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oN(mVar.sOJ)) {
                    h.b(this, mVar.sOJ, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bi.oN(mVar.sOJ)) {
                        string = getString(i.vaU);
                    } else {
                        string = mVar.sOJ;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                return true;
            }
            if (bi.oN(str)) {
                str = getString(i.vdG);
            }
            h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
        return false;
    }

    public final void uV(int i) {
        this.mController.contentView.setVisibility(i);
    }

    public final void gJ(int i) {
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[4];
        objArr[0] = this.sXD.sSb == null ? "" : bi.aD(this.sXD.sSb.sOB, "");
        objArr[1] = this.sXD.sRY;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = this.sXD.pff;
        gVar.h(14877, objArr);
    }
}
