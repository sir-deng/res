package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.al;
import com.tencent.mm.f.a.am;
import com.tencent.mm.f.a.gj;
import com.tencent.mm.f.a.io;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.h;
import com.tencent.mm.plugin.wallet_core.c.k;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import d.a.a.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import org.xwalk.core.R;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String jPV = null;
    private String mAppId = "";
    private c pSQ;
    private WalletSuccPageAwardWidget pSR;
    private ViewGroup pSW;
    private ViewGroup pSX;
    private ViewGroup pSY;
    private TextView pSZ;
    private String pUC;
    private TextView pVl;
    private String pbT;
    private com.tencent.mm.sdk.b.c peh = new com.tencent.mm.sdk.b.c<sy>() {
        {
            this.xmG = sy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            sy syVar = (sy) bVar;
            if (!(syVar instanceof sy)) {
                return false;
            }
            if (!syVar.fMg.fMh.pcZ) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                return true;
            } else if (!"1".equals(syVar.fMg.fMh.fLK) && !"2".equals(syVar.fMg.fMh.fLK)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(syVar.fMg.fMh.fLK, syVar.fMg.fMh.fLL, syVar.fMg.fMh.fLM, syVar.fMg.fMh.fLN, syVar.fMg.fMh.fLO, WalletOrderInfoNewUI.this.sKT == null ? 0 : WalletOrderInfoNewUI.this.sKT.fDQ);
                x.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                WalletOrderInfoNewUI.this.vf.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    private String phx = null;
    private PayInfo sKT;
    private Orders sKw;
    private int sTM;
    private boolean sXE = false;
    private String sXF;
    private String sXG;
    private b sXI;
    private HashMap<String, a> sXJ = new HashMap();
    private String sXK;
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
    public Set<String> tad = null;
    private List<Commodity> tae = null;
    private RecommendTinyAppInfo taf;
    private String tah;
    private Promotions tai = null;
    private TextView taj;
    private TextView tak;
    private WalletTextView tal;
    private ViewGroup tam;
    private ViewGroup tan;
    private ViewGroup tao;
    private ViewGroup tap;
    private TextView taq;
    private CheckBox tar;
    private ViewGroup tas;
    private CdnImageView tat;
    private TextView tau;
    private TextView tav;
    private Button taw;
    private boolean tax = false;
    private com.tencent.mm.sdk.b.c tay = new com.tencent.mm.sdk.b.c<am>() {
        {
            this.xmG = am.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            am amVar = (am) bVar;
            String str = amVar.fpt.fpv;
            boolean z = amVar.fpt.fpw;
            x.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", str, Boolean.valueOf(z), Boolean.valueOf(amVar.fpt.fpx), Boolean.valueOf(amVar.fpt.fpy));
            if (amVar.fpt.fpy && !bi.oN(WalletOrderInfoNewUI.this.sXK)) {
                WalletOrderInfoNewUI.this.tas.setVisibility(8);
            }
            if (!bi.oN(WalletOrderInfoNewUI.this.sXK)) {
                WalletOrderInfoNewUI.this.taw.setClickable(z);
                WalletOrderInfoNewUI.this.taw.setEnabled(z);
                WalletOrderInfoNewUI.this.taw.setOnClickListener(null);
                if (r2) {
                    WalletOrderInfoNewUI.this.taw.setVisibility(8);
                }
            }
            amVar.fpu.foB = true;
            return false;
        }
    };

    static class a {
        public String fED;
        public String fzT;
        public String sGf;
        public String sGg;
        public String sTI;
        public String sTJ;
        public String sTK;
        public String sTL;
        public String taB;
        public int taC;
        public String title;
        public String url;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.fzT = optJSONObject.optString("wording");
                    this.fED = optJSONObject.optString("icon");
                    this.taB = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                    this.sTI = optJSONObject.optString("tinyapp_name");
                    this.sTJ = optJSONObject.optString("tinyapp_logo");
                    this.sTK = optJSONObject.optString("tinyapp_desc");
                    this.sGf = optJSONObject.optString("tinyapp_username");
                    this.sGg = optJSONObject.optString("tinyapp_path");
                    this.sTL = optJSONObject.optString("activity_tinyapp_btn_text");
                }
            }
        }

        public a(bau bau) {
            if (bau != null && bau.wOu != null) {
                ay ayVar = bau.wOu;
                this.url = ayVar.url;
                this.fzT = ayVar.fzT;
                this.fED = ayVar.fED;
                this.taB = ayVar.taB;
                this.title = ayVar.title;
                this.sGf = ayVar.sGf;
                this.sGg = ayVar.sGg;
                this.taC = ayVar.taC;
                this.sTI = this.title;
                this.sTJ = this.fED;
                this.sTK = this.fzT;
                this.sTL = this.taB;
            }
        }

        public final String toString() {
            return this.url + " , " + this.fzT + " , " + this.fED + " , " + this.taB + " , " + this.title;
        }
    }

    static class b {
        public String fxT;
        public String pRd;
        public String sOY;
        public long sUY;
        public String taD;
        public String taE;
        public String taF;
        public long taG;
        public String taH;

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7) {
            this.sOY = str;
            this.taD = str2;
            this.taE = str3;
            this.taF = str4;
            this.fxT = str5;
            this.pRd = str6;
            this.sUY = j;
            this.taH = str7;
        }

        public b(String str, String str2, String str3, String str4, String str5, String str6, long j, long j2) {
            this.sOY = str;
            this.taD = str2;
            this.taE = str3;
            this.taF = str4;
            this.fxT = str5;
            this.pRd = str6;
            this.sUY = j;
            this.taG = j2;
            this.taH = null;
        }
    }

    static /* synthetic */ void p(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.tai != null ? walletOrderInfoNewUI.tai.sOB : 0);
        x.i(str, str2, objArr);
        if (walletOrderInfoNewUI.tai != null && walletOrderInfoNewUI.tai.sOB > 0) {
            walletOrderInfoNewUI.sXX = true;
            if (walletOrderInfoNewUI.sXM.equals("-1") || walletOrderInfoNewUI.sXM.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                g.pWK.h(13472, walletOrderInfoNewUI.pUC, Integer.valueOf(walletOrderInfoNewUI.tai.sUK), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.tai.sOB), Long.valueOf(walletOrderInfoNewUI.tai.sTF));
                g.pWK.h(13033, Integer.valueOf(2), "", walletOrderInfoNewUI.tai.url, walletOrderInfoNewUI.tai.name, "");
                if (!bi.oN(walletOrderInfoNewUI.tai.sUN) && !bi.oN(walletOrderInfoNewUI.tai.sUO)) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s, version: %s", walletOrderInfoNewUI.tai.sUN, walletOrderInfoNewUI.tai.sUO, Integer.valueOf(walletOrderInfoNewUI.tai.sUP));
                    walletOrderInfoNewUI.sXI = new b(walletOrderInfoNewUI.tai.sOB, walletOrderInfoNewUI.tai.sUL, walletOrderInfoNewUI.tai.sTD, walletOrderInfoNewUI.tai.sTE, walletOrderInfoNewUI.bKA(), walletOrderInfoNewUI.pUC, walletOrderInfoNewUI.tai.sTF, walletOrderInfoNewUI.tai.sUR);
                    com.tencent.mm.sdk.b.b qrVar = new qr();
                    qrVar.fJd.userName = walletOrderInfoNewUI.tai.sUN;
                    qrVar.fJd.fJf = bi.aD(walletOrderInfoNewUI.tai.sUO, "");
                    qrVar.fJd.scene = 1060;
                    qrVar.fJd.foi = walletOrderInfoNewUI.pbT;
                    qrVar.fJd.fJg = 0;
                    if (walletOrderInfoNewUI.tai.sUP > 0) {
                        qrVar.fJd.fJh = walletOrderInfoNewUI.tai.sUP;
                    }
                    qrVar.fJd.context = walletOrderInfoNewUI;
                    com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                    g.pWK.h(14118, walletOrderInfoNewUI.pbT, walletOrderInfoNewUI.bKA(), Integer.valueOf(2));
                } else if (walletOrderInfoNewUI.tai.sUK == 1) {
                    Promotions promotions = walletOrderInfoNewUI.tai;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "doSceneSendPayAward, getAwardParams==null: %s, %s", Boolean.valueOf(bi.oN(promotions.sUQ)), promotions.sUQ);
                    if (bi.oN(promotions.sUQ)) {
                        walletOrderInfoNewUI.r(new n(promotions, walletOrderInfoNewUI.bKA(), walletOrderInfoNewUI.pbT, promotions.sTF));
                    } else {
                        walletOrderInfoNewUI.r(new h(promotions.sUQ, promotions.sOB));
                    }
                } else if (walletOrderInfoNewUI.tai.sUK != 2 || bi.oN(walletOrderInfoNewUI.tai.url)) {
                    x.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.sXJ.containsKey(walletOrderInfoNewUI.tai.sOB)) {
                    a aVar = (a) walletOrderInfoNewUI.sXJ.get(walletOrderInfoNewUI.tai.sOB);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", aVar.url);
                    if (bi.oN(aVar.url)) {
                        walletOrderInfoNewUI.NS(walletOrderInfoNewUI.tai.url);
                    } else {
                        walletOrderInfoNewUI.NS(aVar.url);
                    }
                } else {
                    walletOrderInfoNewUI.sXK = walletOrderInfoNewUI.tai.url;
                    String str3 = walletOrderInfoNewUI.tai.url;
                    b bVar = new b(walletOrderInfoNewUI.tai.sOB, walletOrderInfoNewUI.tai.sUL, walletOrderInfoNewUI.tai.sTD, walletOrderInfoNewUI.tai.sTE, walletOrderInfoNewUI.bKA(), walletOrderInfoNewUI.pUC, walletOrderInfoNewUI.tai.sTF, walletOrderInfoNewUI.tai.sUR);
                    x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str3);
                    walletOrderInfoNewUI.bNg();
                    walletOrderInfoNewUI.sXI = bVar;
                    e.s(walletOrderInfoNewUI, str3, 1);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
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
        this.tad = new HashSet();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        this.sKT = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.pbT = this.vf.getString("key_trans_id");
        this.vf.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", this.pbT);
        this.sKw = bNr();
        if (this.sKw != null) {
            uV(0);
            b(this.sKw);
            if (!(ag == null || this.sKw == null || this.sKT == null)) {
                int i2;
                boolean z;
                int i3;
                this.mAppId = this.sKT.appId;
                boolean cCb = ag.cCb();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 7);
                if (this.vf.getInt("key_support_bankcard", 1) == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                g gVar = g.pWK;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.sKT.fDQ);
                if (this.sKT.fDQ == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (cCb) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                objArr[2] = Integer.valueOf(i3);
                objArr[3] = Integer.valueOf(p.cCo());
                objArr[4] = Integer.valueOf((int) (this.sKw.pTQ * 100.0d));
                objArr[5] = this.sKw.pgf;
                objArr[6] = Integer.valueOf(i2);
                gVar.h(10691, objArr);
            }
            if (!((o.bMc().bMy() || ag == null || !ag.cCb()) && q.Gh())) {
                q.Gi();
            }
            if (this.sKw == null || this.sKw.sUf == null || this.sKw.sUf.size() <= 0) {
                x.k("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.xRr, i.uZS, 0, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletOrderInfoNewUI.this.done();
                    }
                });
            } else {
                this.tae = this.sKw.sUf;
                x.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", Integer.valueOf(this.tae.size()));
                this.pbT = ((Commodity) this.tae.get(0)).fvD;
                this.pUC = ((Commodity) this.tae.get(0)).fvD;
                if (!(this.sKT == null || ag == null || (!ag.cCa() && !ag.cCb()))) {
                    l(new y(bKA(), 21));
                }
            }
            if (this.pbT == null) {
                boolean booleanValue;
                Object obj = com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "has show the finger print auth guide!");
                } else {
                    com.tencent.mm.wallet_core.c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                    Bundle bundle2 = new Bundle();
                    if (ag2 != null) {
                        bundle2 = ag2.mym;
                    }
                    if (TextUtils.isEmpty(bundle2.getString("key_pwd1"))) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "pwd is empty, not show the finger print auth guide!");
                    } else if (ag2 != null) {
                        ag2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle2);
                    }
                }
            }
        } else {
            x.k("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.h.a(this.mController.xRr, i.uZS, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WalletOrderInfoNewUI.this.finish();
                }
            });
        }
        initView();
        this.sXZ = cCT();
        bNe();
        jl(1979);
        jl(2948);
        jl(2710);
        com.tencent.mm.sdk.b.a.xmy.b(this.tay);
        com.tencent.mm.sdk.b.a.xmy.b(this.peh);
        this.sXY = true;
        if (this.sKT != null) {
            i = this.sKT.fDQ;
        }
        t.d(i, this.sKT == null ? "" : this.sKT.fvC, 16, "");
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s, exposureInfo: %s", Boolean.valueOf(this.sXY), this.tai, Boolean.valueOf(this.sXW), Boolean.valueOf(this.sXX), this.taf, this.pSQ);
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            this.pSR.onResume();
        } else if (this.sXY) {
            this.sXY = false;
        } else if (this.tai != null && this.sXX) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query payAward, queryAwardStatusParams==null: %s %s, isCallQueryPayAward: %s", Boolean.valueOf(bi.oN(this.tai.sUR)), this.tai.sUR, Boolean.valueOf(this.tax));
            if (!this.tax) {
                this.tax = true;
                if (bi.oN(this.tai.sUR)) {
                    l(new aa(this.tai.sOB, this.tai.sUL, this.tai.sTD, this.tai.sTE, bKA(), this.pUC, this.tai.sTF));
                } else {
                    l(new k(this.tai.sUR, this.tai.sOB));
                }
            }
        } else if (this.sXW && this.taf != null) {
            l(new aa(this.taf.sUT, this.taf.sUV, this.taf.sUW, this.taf.sUX, bKA(), this.pUC, this.taf.sUY));
        }
    }

    protected final void initView() {
        Commodity commodity;
        Commodity commodity2;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.sXO = (ImageView) findViewById(f.uHo);
        this.pVl = (TextView) findViewById(f.uzq);
        this.taj = (TextView) findViewById(f.umr);
        this.tak = (TextView) findViewById(f.uqT);
        this.tal = (WalletTextView) findViewById(f.uDM);
        this.pSZ = (TextView) findViewById(f.uzj);
        this.sXN = (Button) findViewById(f.uzn);
        showHomeBtn(false);
        enableBackMenu(false);
        CharSequence string = getString(i.dFw);
        if (this.sKT == null || this.sKT.fDQ != 2) {
            if (!(this.sKw == null || bi.oN(this.sKw.sUq))) {
                string = this.sKw.sUq;
            }
        } else if (this.sKw != null && !bi.oN(this.sKw.sUq)) {
            string = this.sKw.sUq;
        } else if (!bi.oN(this.sKT.tgP)) {
            string = getString(i.dDZ) + this.sKT.tgP;
        } else if (!(bi.oN(this.sKT.appId) || bi.oN(com.tencent.mm.pluginsdk.model.app.g.l(this, this.sKT.appId)))) {
            string = getString(i.dDZ) + com.tencent.mm.pluginsdk.model.app.g.l(this, this.sKT.appId);
        }
        this.sXN.setText(string);
        this.sXN.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletOrderInfoNewUI.this.done();
            }
        });
        this.tam = (ViewGroup) findViewById(f.uqa);
        this.pSX = (ViewGroup) findViewById(f.upZ);
        this.sXV = (ViewGroup) findViewById(f.uFJ);
        this.pSW = (ViewGroup) findViewById(f.uqb);
        this.pSY = (ViewGroup) findViewById(f.uzk);
        this.tan = (ViewGroup) findViewById(f.uss);
        this.tao = (ViewGroup) findViewById(f.uqc);
        this.sXP = (ViewGroup) findViewById(f.uDy);
        this.sXQ = (CdnImageView) findViewById(f.uDA);
        this.sXQ.vtO = true;
        this.sXR = (TextView) findViewById(f.uDx);
        this.sXS = (TextView) findViewById(f.uDC);
        this.sXU = (Button) findViewById(f.uDv);
        this.sXT = findViewById(f.uDz);
        this.tap = (ViewGroup) findViewById(f.uDe);
        this.taq = (TextView) findViewById(f.umo);
        this.tar = (CheckBox) findViewById(f.uDd);
        this.tas = (ViewGroup) findViewById(f.ukN);
        this.tat = (CdnImageView) findViewById(f.ukO);
        this.tat.vtO = true;
        this.tav = (TextView) findViewById(f.ukP);
        this.tau = (TextView) findViewById(f.ukM);
        this.taw = (Button) findViewById(f.ukL);
        this.sXV.setVisibility(4);
        this.pSR = (WalletSuccPageAwardWidget) findViewById(f.uli);
        bNe();
        if (!(this.sKw == null || this.tae == null || this.tae.size() <= 0)) {
            commodity = (Commodity) this.tae.get(0);
            this.taj.setText(commodity.pfU);
            this.tak.setText(e.abh(commodity.pgf));
            this.tal.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity.loS)}));
        }
        bNo();
        bNp();
        this.tao.setVisibility(8);
        this.tan.setVisibility(8);
        if (!(this.sKw == null || this.tae == null || this.tae.size() <= 0)) {
            commodity = (Commodity) this.tae.get(0);
            if (!bi.oN(commodity.sUz)) {
                ((TextView) findViewById(f.ust)).setText(commodity.sUz);
                this.tan.setVisibility(0);
                this.tam.setVisibility(0);
            }
            if (!bi.oN(commodity.sUx)) {
                ((TextView) findViewById(f.uqd)).setText(commodity.sUx);
                this.tao.setVisibility(0);
                this.tam.setVisibility(0);
            }
        }
        if (this.tae == null || this.tae.size() <= 0) {
            commodity2 = null;
        } else {
            commodity = (Commodity) this.tae.get(0);
            if (!(commodity == null || commodity.sUB == null || commodity.sUB.size() <= 0)) {
                for (Promotions promotions : commodity.sUB) {
                    if (promotions.sUS != null && promotions.sUK == 5) {
                        this.pSQ = promotions.sUS;
                        x.i("MicroMsg.WalletOrderInfoNewUI", "get exposureInfo: %s, from promotion: %s", this.pSQ, Integer.valueOf(promotions.sUK));
                        commodity2 = commodity;
                        break;
                    }
                }
            }
            commodity2 = commodity;
        }
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            if (commodity2 != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.pSR.getLayoutParams();
                List list = commodity2.sUw;
                if ((commodity2.sUt < 0.0d || commodity2.loS >= commodity2.sUt) && (list == null || list.size() <= 0)) {
                    marginLayoutParams.topMargin = com.tencent.mm.bu.a.fromDPToPix(this, 50);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
                this.pSR.setLayoutParams(marginLayoutParams);
            }
            this.pSR.a(this, this.pSQ, this.pbT, false, (ImageView) findViewById(f.background));
            this.pSR.init();
            this.pSR.setVisibility(0);
            final ImageView imageView = (ImageView) findViewById(f.background);
            imageView.post(new Runnable() {
                public final void run() {
                    ViewGroup viewGroup = (ViewGroup) WalletOrderInfoNewUI.this.findViewById(f.uCI);
                    LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.width = viewGroup.getWidth();
                    layoutParams.height = viewGroup.getHeight();
                    imageView.setLayoutParams(layoutParams);
                }
            });
        } else {
            jS(true);
            this.pSR.setVisibility(8);
        }
        bNd();
    }

    private void bNd() {
        int i;
        int i2 = 0;
        if (this.sXP.getVisibility() == 0) {
            i2 = 1;
        }
        if (this.tam.getVisibility() == 0) {
            i2++;
        }
        if (this.tap.getVisibility() == 0) {
            i2++;
        }
        if (this.tas.getVisibility() == 0) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.sXO.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.taj.getLayoutParams();
        if (i >= 3) {
            i = com.tencent.mm.bu.a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = com.tencent.mm.bu.a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.sXO.setLayoutParams(marginLayoutParams);
        this.taj.setLayoutParams(marginLayoutParams2);
        this.sXV.post(new Runnable() {
            public final void run() {
                int i;
                int i2;
                int height = WalletOrderInfoNewUI.this.sXV.getHeight();
                int height2 = WalletOrderInfoNewUI.this.findViewById(f.uCI).getHeight();
                int i3 = WalletOrderInfoNewUI.this.sXP.getVisibility() == 0 ? 1 : 0;
                if (WalletOrderInfoNewUI.this.tam.getVisibility() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (WalletOrderInfoNewUI.this.pSR.getVisibility() == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i != 0) {
                    i = WalletOrderInfoNewUI.this.tam.getBottom();
                } else {
                    i = -1;
                }
                if (i3 != 0) {
                    i3 = WalletOrderInfoNewUI.this.sXP.getBottom();
                } else {
                    i3 = i;
                }
                if (i2 != 0) {
                    i3 = WalletOrderInfoNewUI.this.pSR.getBottom();
                }
                if (i3 <= 0) {
                    i3 = WalletOrderInfoNewUI.this.findViewById(f.uzp).getBottom();
                }
                if (WalletOrderInfoNewUI.this.tap.getVisibility() == 0 || WalletOrderInfoNewUI.this.tas.getVisibility() == 0) {
                    i = height;
                } else {
                    i = com.tencent.mm.bu.a.fromDPToPix(WalletOrderInfoNewUI.this, 70) + height;
                }
                height = (height2 - i3) - i;
                int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(WalletOrderInfoNewUI.this, 50);
                x.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(height2), Integer.valueOf(height), Integer.valueOf(fromDPToPix));
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WalletOrderInfoNewUI.this.sXV.getLayoutParams();
                if (height > fromDPToPix) {
                    marginLayoutParams.topMargin = height;
                } else {
                    marginLayoutParams.topMargin = fromDPToPix;
                }
                WalletOrderInfoNewUI.this.sXV.setLayoutParams(marginLayoutParams);
                WalletOrderInfoNewUI.this.sXV.setVisibility(0);
            }
        });
    }

    private void bNe() {
        if (this.sKw != null && this.tae != null && this.tae.size() > 0) {
            int i;
            for (Commodity commodity : this.tae) {
                if ("1".equals(commodity.pfY)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.pVl.setVisibility(0);
            if (i == 0) {
                this.pVl.setText(i.vai);
            } else if (!bi.oN(this.sKw.sTY) && !bi.oN(this.sKw.sTY.trim())) {
                this.pVl.setText(this.sKw.sTY);
            } else if (this.sKw.sOT != 1) {
                this.pVl.setText(i.vah);
            } else {
                this.pVl.setText(i.vag);
            }
        }
    }

    private void bNo() {
        this.tam.setVisibility(8);
        this.pSX.setVisibility(8);
        this.pSW.setVisibility(8);
        this.pSY.setVisibility(8);
        if (this.sKw != null && this.tae != null && this.tae.size() > 0) {
            Commodity commodity = (Commodity) this.tae.get(0);
            List list = commodity.sUw;
            String str = "MicroMsg.WalletOrderInfoNewUI";
            String str2 = "discountInfoList: %s, size: %s";
            Object[] objArr = new Object[2];
            objArr[0] = list;
            objArr[1] = Integer.valueOf(list != null ? list.size() : 0);
            x.i(str, str2, objArr);
            if (list != null && list.size() > 0) {
                this.pSX.removeAllViews();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                    View textView = new TextView(this.mController.xRr);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView.setTextSize(1, 12.0f);
                    textView.setTextColor(Color.parseColor("#FA962A"));
                    if (discountInfo.sUI > 0.0d) {
                        textView.setText(discountInfo.pPL + e.d(discountInfo.sUI / 100.0d, this.sKw.pgf));
                    } else {
                        textView.setText(discountInfo.pPL);
                    }
                    this.pSX.addView(textView);
                    i = i2 + 1;
                }
                this.pSX.setVisibility(0);
                this.tam.setVisibility(0);
                this.pSW.setVisibility(0);
            }
            if (commodity.sUt >= 0.0d && commodity.loS < commodity.sUt) {
                this.pSZ.setText(e.d(commodity.sUt, commodity.pgf));
                this.pSZ.getPaint().setFlags(16);
                this.pSY.setVisibility(0);
                this.tam.setVisibility(0);
            }
        }
    }

    private void bNp() {
        this.tap.setVisibility(8);
        if (this.sKw != null) {
            b(this.sKw);
            if (this.tae != null && this.tae.size() > 0) {
                Commodity commodity = (Commodity) this.tae.get(0);
                x.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.sUC));
                if (commodity.sUC && commodity.sUB != null && commodity.sUB.size() > 0) {
                    for (Promotions promotions : commodity.sUB) {
                        if (promotions.type == Orders.sUr) {
                            break;
                        }
                    }
                    Promotions promotions2 = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", promotions2);
                    if (promotions2 != null && !bi.oN(promotions2.pgg)) {
                        this.pUC = commodity.fvD;
                        g.pWK.h(13033, Integer.valueOf(1), promotions2.pgg, promotions2.url, promotions2.name, this.pUC);
                        this.taq.setText(promotions2.name);
                        this.tah = promotions2.pgg;
                        this.tar.setVisibility(0);
                        if (this.tad.contains(promotions2.pgg)) {
                            this.tar.setChecked(true);
                        } else {
                            this.tar.setChecked(false);
                        }
                        this.tap.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                if (!bi.oN(WalletOrderInfoNewUI.this.tah)) {
                                    if (WalletOrderInfoNewUI.this.tad.contains(WalletOrderInfoNewUI.this.tah)) {
                                        WalletOrderInfoNewUI.this.tad.remove(WalletOrderInfoNewUI.this.tah);
                                        WalletOrderInfoNewUI.this.tar.setChecked(false);
                                        return;
                                    }
                                    WalletOrderInfoNewUI.this.tad.add(WalletOrderInfoNewUI.this.tah);
                                    WalletOrderInfoNewUI.this.tar.setChecked(true);
                                }
                            }
                        });
                        this.tap.setVisibility(0);
                    }
                }
            }
        }
    }

    private void jS(boolean z) {
        this.sXP.setVisibility(8);
        this.sXX = false;
        this.sXW = false;
        if (this.sKw != null) {
            if (this.tae != null && this.tae.size() > 0) {
                final Commodity commodity = (Commodity) this.tae.get(0);
                if (commodity != null) {
                    Promotions promotions;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", Boolean.valueOf(commodity.sUC));
                    if (commodity.sUB != null && commodity.sUB.size() > 0) {
                        for (Promotions promotions2 : commodity.sUB) {
                            if (promotions2.type == Orders.sUs) {
                                promotions = promotions2;
                                break;
                            }
                        }
                    }
                    promotions = null;
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", promotions);
                    a aVar;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (promotions != null && promotions.sOB > 0 && !bi.oN(promotions.sTG)) {
                        this.tai = promotions;
                        this.sXT.setVisibility(8);
                        this.sXQ.vtN = true;
                        this.sXU.setEnabled(true);
                        this.sXU.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAc);
                        this.sXS.setCompoundDrawables(null, null, null, null);
                        aVar = (a) this.sXJ.get(promotions.sOB);
                        if (aVar != null) {
                            if (!bi.oN(aVar.fED)) {
                                this.sXQ.setUrl(aVar.fED);
                            }
                            if (!bi.oN(aVar.fzT)) {
                                this.sXR.setText(aVar.fzT);
                            }
                            if (!bi.oN(aVar.taB)) {
                                this.sXU.setText(aVar.taB);
                                this.sXU.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ukt);
                            }
                            if (!bi.oN(aVar.sGf)) {
                                this.tai.sUN = aVar.sGf;
                            }
                            if (!bi.oN(aVar.sGg)) {
                                this.tai.sUO = aVar.sGg;
                            }
                            if (aVar.taC > 0) {
                                this.tai.sUP = aVar.taC;
                            }
                        } else {
                            this.sXQ.setUrl(promotions.pkG);
                            this.sXR.setText(promotions.name);
                            this.sXU.setText(promotions.sTG);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.sXS.getLayoutParams();
                        if (aVar != null && !bi.oN(aVar.title)) {
                            this.sXS.setText(aVar.title);
                            layoutParams.addRule(15, 0);
                        } else if (bi.oN(promotions.title)) {
                            this.sXS.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.sXS.setText(promotions.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.sXS.setLayoutParams(layoutParams);
                        this.sXU.setVisibility(0);
                        this.sXU.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
                                WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this);
                            }
                        });
                        if (promotions.sUK != 1) {
                            this.sXP.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    x.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                                    WalletOrderInfoNewUI.p(WalletOrderInfoNewUI.this);
                                }
                            });
                        }
                        String str = this.sXM;
                        boolean z2 = true;
                        switch (str.hashCode()) {
                            case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                                if (str.equals("0")) {
                                    z2 = false;
                                    break;
                                }
                                break;
                            case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                                if (str.equals("1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                this.sXU.setEnabled(false);
                                break;
                        }
                        marginLayoutParams = (MarginLayoutParams) this.sXP.getLayoutParams();
                        list = commodity.sUw;
                        if ((commodity.sUt < 0.0d || commodity.loS >= commodity.sUt) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bu.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.sXP.setLayoutParams(marginLayoutParams);
                        this.sXP.setVisibility(0);
                        if (z) {
                            g gVar = g.pWK;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.pUC;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(promotions.sUK);
                            objArr[3] = this.sXM.equals("-1") ? Integer.valueOf(5) : this.sXM;
                            objArr[4] = Long.valueOf(promotions.sOB);
                            objArr[5] = Long.valueOf(promotions.sTF);
                            gVar.h(13471, objArr);
                        }
                    } else if (!(commodity.sUA == null || bi.oN(commodity.sUA.sGf))) {
                        this.sXF = commodity.sUA.sGf;
                        this.sXG = commodity.sUA.sGg;
                        this.sTM = commodity.sUA.sTM;
                        this.taf = commodity.sUA;
                        this.sXQ.setUrl(commodity.sUA.sTJ);
                        this.sXR.setText(commodity.sUA.sTK);
                        this.sXS.setText(getString(i.uVq));
                        this.sXS.setVisibility(0);
                        this.sXQ.vtN = true;
                        this.sXU.setEnabled(true);
                        this.sXU.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.bAc);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.sXS.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.sXS.setLayoutParams(layoutParams2);
                        if (commodity.sUA.sUT > 0) {
                            if (!bi.oN(commodity.sUA.sTL)) {
                                this.sXU.setVisibility(0);
                                this.sXU.setText(commodity.sUA.sTL);
                                this.sXT.setVisibility(8);
                            }
                            aVar = (a) this.sXJ.get(commodity.sUA.sUT);
                            if (aVar != null) {
                                if (!bi.oN(aVar.sTJ)) {
                                    this.sXQ.setUrl(aVar.sTJ);
                                }
                                if (!bi.oN(aVar.sTK)) {
                                    this.sXR.setText(aVar.sTK);
                                }
                                if (!bi.oN(aVar.sTL)) {
                                    this.sXU.setText(aVar.sTL);
                                    this.sXU.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ukt);
                                }
                                if (!bi.oN(aVar.sGf)) {
                                    this.sXF = aVar.sGf;
                                }
                                if (!bi.oN(aVar.sGg)) {
                                    this.sXG = aVar.sGg;
                                }
                                if (aVar.taC > 0) {
                                    this.sTM = aVar.taC;
                                }
                            }
                        } else {
                            this.sXU.setVisibility(8);
                            this.sXT.setVisibility(8);
                        }
                        View.OnClickListener anonymousClass4 = new View.OnClickListener() {
                            public final void onClick(View view) {
                                x.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app, userName: %s, path: %s, version: %s", WalletOrderInfoNewUI.this.sXF, WalletOrderInfoNewUI.this.sXG, Integer.valueOf(WalletOrderInfoNewUI.this.sTM));
                                com.tencent.mm.sdk.b.b qrVar = new qr();
                                qrVar.fJd.userName = WalletOrderInfoNewUI.this.sXF;
                                qrVar.fJd.fJf = bi.aD(WalletOrderInfoNewUI.this.sXG, "");
                                qrVar.fJd.scene = 1034;
                                qrVar.fJd.fJg = 0;
                                if (WalletOrderInfoNewUI.this.sTM > 0) {
                                    qrVar.fJd.fJh = WalletOrderInfoNewUI.this.sTM;
                                }
                                qrVar.fJd.context = WalletOrderInfoNewUI.this;
                                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                WalletOrderInfoNewUI walletOrderInfoNewUI = WalletOrderInfoNewUI.this;
                                boolean z = !bi.oN(commodity.sUA.sTL) && commodity.sUA.sUT > 0;
                                walletOrderInfoNewUI.sXW = z;
                                if (WalletOrderInfoNewUI.this.sXW) {
                                    g.pWK.h(14118, WalletOrderInfoNewUI.this.pbT, WalletOrderInfoNewUI.this.bKA(), Integer.valueOf(3));
                                } else {
                                    g.pWK.h(14118, WalletOrderInfoNewUI.this.pbT, WalletOrderInfoNewUI.this.bKA(), Integer.valueOf(1));
                                }
                            }
                        };
                        this.sXP.setOnClickListener(anonymousClass4);
                        this.sXU.setOnClickListener(anonymousClass4);
                        marginLayoutParams = (MarginLayoutParams) this.sXP.getLayoutParams();
                        list = commodity.sUw;
                        if ((commodity.sUt < 0.0d || commodity.loS >= commodity.sUt) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bu.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.sXP.setLayoutParams(marginLayoutParams);
                        this.sXP.setVisibility(0);
                    }
                }
            }
            if (this.sXR.getVisibility() == 0) {
                this.sXR.setSingleLine();
                this.sXR.post(new Runnable() {
                    public final void run() {
                        try {
                            if (WalletOrderInfoNewUI.this.sXU.getVisibility() == 0 && WalletOrderInfoNewUI.this.sXR.getRight() > 0 && WalletOrderInfoNewUI.this.sXU.getLeft() > 0 && WalletOrderInfoNewUI.this.sXR.getRight() >= WalletOrderInfoNewUI.this.sXU.getLeft() && !bi.N(WalletOrderInfoNewUI.this.sXR.getText())) {
                                float textSize = WalletOrderInfoNewUI.this.sXR.getTextSize();
                                x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletOrderInfoNewUI.this.sXR.getRight()), Integer.valueOf(WalletOrderInfoNewUI.this.sXU.getLeft()));
                                Paint paint = new Paint();
                                paint.setTextSize(textSize);
                                String charSequence = WalletOrderInfoNewUI.this.sXR.getText().toString();
                                float left = (float) (WalletOrderInfoNewUI.this.sXU.getLeft() - WalletOrderInfoNewUI.this.sXR.getLeft());
                                int i = 1;
                                while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > left && i <= charSequence.length() - 1) {
                                    i++;
                                }
                                x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
                                CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                                if (charSequence.length() > 9 && substring.length() < 9) {
                                    substring = charSequence.substring(0, 9);
                                }
                                WalletOrderInfoNewUI.this.sXR.setText(substring);
                                WalletOrderInfoNewUI.this.sXR.append("...");
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.WalletOrderInfoNewUI", e, "calc tinyapp name error: %s", e.getMessage());
                        }
                    }
                });
            }
        }
    }

    private void NS(String str) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "jumpToH5: %s", str);
        bNg();
        e.l(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            x.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd, query_award_status_params==null: %s, isCallQueryPayAward: %s", Boolean.valueOf(bi.oN(this.sXI.taH)), Boolean.valueOf(this.tax));
            if (!this.tax) {
                this.tax = true;
                if (bi.oN(this.sXI.taH)) {
                    l(new aa(this.sXI.sOY, this.sXI.taD, this.sXI.taE, this.sXI.taF, this.sXI.fxT, this.sXI.pRd, this.sXI.sUY));
                } else {
                    l(new k(this.sXI.taH, this.sXI.sOY));
                }
            }
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(i.vae), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.ugS), "", new com.tencent.mm.ui.base.h.c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoNewUI.this.phx).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        WalletOrderInfoNewUI.this.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final boolean boI() {
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uMb;
    }

    private void b(Orders orders) {
        this.tad.clear();
        if (orders == null || orders.sUf == null) {
            x.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.sUf) {
            if (commodity.sTW == 2 && !bi.oN(commodity.sUu)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.tad.add(commodity.sUu);
            }
        }
    }

    public void done() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletOrderInfoNewUI.this.bNq();
                    }
                });
                boolean a = realnameGuideHelper.a(this, bundle, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletOrderInfoNewUI.this.bNq();
                    }
                });
                this.vf.remove("key_realname_guide_helper");
                if (!b && !a) {
                    bNq();
                    return;
                }
                return;
            }
            return;
        }
        bNq();
    }

    public final void bNq() {
        bNg();
        com.tencent.mm.sdk.b.b alVar = new al();
        alVar.fpq.fpr = true;
        com.tencent.mm.sdk.b.a.xmy.m(alVar);
        alVar = new gj();
        alVar.fxp.fxq = "ok";
        com.tencent.mm.sdk.b.a.xmy.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.vf.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.vf.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.vf.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.vf.getInt("intent_pay_end_errcode"));
        for (String str : this.tad) {
            if (!bi.oN(str)) {
                x.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str);
                if (this.sKw == null || this.sKT == null) {
                    com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.wallet_core.c.i(str), 0);
                } else {
                    com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.wallet_core.c.i(str, this.sKw.fvC, this.sKw.sUf.size() > 0 ? ((Commodity) this.sKw.sUf.get(0)).fvD : "", this.sKT.fDQ, this.sKT.fDM, this.sKw.sTW), 0);
                }
            }
            g.pWK.h(13033, Integer.valueOf(2), str, "", "", "");
        }
        if (this.sXZ != null) {
            this.sXZ.a((Activity) this, 0, bundle);
        }
        if (this.sKw != null && !bi.oN(this.sKw.lUI)) {
            String d = WalletOrderInfoUI.d(this.sKw.lUI, this.sKw.fvC, this.sKw.sUf.size() > 0 ? ((Commodity) this.sKw.sUf.get(0)).fvD : "", this.sKT.kPP, this.sKT.iLo);
            x.d("MicroMsg.WalletOrderInfoNewUI", "url = " + d);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", q.FY());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bl.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
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
        com.tencent.mm.sdk.b.a.xmy.c(this.tay);
        com.tencent.mm.sdk.b.a.xmy.c(this.peh);
        jm(1979);
        jm(2948);
        jm(2710);
        if (WalletSuccPageAwardWidget.a(this.pSQ)) {
            this.pSR.onDestroy();
        }
    }

    private void bNg() {
        int i = 0;
        if (!this.sXE) {
            com.tencent.mm.sdk.b.b ioVar = new io();
            ioVar.fzP.fzQ = 4;
            com.tencent.mm.f.a.io.a aVar = ioVar.fzP;
            if (this.vf.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.bjW = i;
            com.tencent.mm.sdk.b.a.xmy.m(ioVar);
            this.sXE = true;
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.WalletOrderInfoNewUI", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), kVar);
        if (WalletSuccPageAwardWidget.a(this.pSQ) && this.pSR.d(i, i2, str, kVar)) {
            return true;
        }
        CharSequence string;
        if (kVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                aa aaVar = (aa) kVar;
                a aVar = new a(aaVar.oxl);
                if (this.sXI != null) {
                    this.sXJ.put(aaVar.sOY, aVar);
                    jS(false);
                    bNd();
                } else if (this.sXW) {
                    this.sXJ.put(aaVar.sOY, aVar);
                    jS(false);
                    bNd();
                }
            }
            this.tax = false;
        } else if (kVar instanceof k) {
            if (i == 0 && i2 == 0) {
                k kVar2 = (k) kVar;
                bau bau = kVar2.sOH;
                if (bau.kRz == 0) {
                    a aVar2 = new a(bau);
                    if (this.sXI != null) {
                        this.sXJ.put(kVar2.sbN, aVar2);
                        jS(false);
                        bNd();
                    } else if (this.sXW) {
                        this.sXJ.put(kVar2.sbN, aVar2);
                        jS(false);
                        bNd();
                    }
                }
            }
            this.tax = false;
        } else if (kVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) kVar;
                String str2 = nVar.sOI;
                if (this.tai != null && this.tai.sOB == nVar.sOL.sOB) {
                    x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tai);
                    this.sXM = str2;
                    x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", nVar.sOL.sTG);
                    jS(false);
                    bNd();
                    if (!(bi.oN(nVar.lfa) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.sXU.setText(nVar.lfa);
                    }
                }
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oN(nVar.sOJ)) {
                    com.tencent.mm.ui.base.h.b(this, nVar.sOJ, "", true);
                } else if ("0".equals(str2)) {
                    if (bi.oN(nVar.sOJ)) {
                        string = getString(i.vaU);
                    } else {
                        string = nVar.sOJ;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                return true;
            }
            if (bi.oN(str)) {
                str = getString(i.vdG);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (kVar instanceof h) {
            if (i == 0 && i2 == 0) {
                h hVar = (h) kVar;
                yt ytVar = hVar.sOA;
                if (ytVar.kRz == 0) {
                    String str3 = ytVar.wpJ;
                    if (this.tai != null && this.tai.sOB == hVar.sOB) {
                        x.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", this.tai);
                        this.sXM = str3;
                        x.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", ytVar.wpL);
                        jS(false);
                        bNd();
                        if (!(bi.oN(ytVar.wpL) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str3))) {
                            this.sXU.setText(ytVar.wpL);
                        }
                    }
                    if (!"-1".equals(str3) && !"0".equals(str3) && !bi.oN(ytVar.wpK)) {
                        com.tencent.mm.ui.base.h.b(this, ytVar.wpK, "", true);
                    } else if ("0".equals(str3)) {
                        if (bi.oN(ytVar.wpK)) {
                            string = getString(i.vaU);
                        } else {
                            string = ytVar.wpK;
                        }
                        Toast.makeText(this, string, 0).show();
                    }
                }
                return true;
            }
            if (bi.oN(str)) {
                str = getString(i.vdG);
            }
            com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
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
}
