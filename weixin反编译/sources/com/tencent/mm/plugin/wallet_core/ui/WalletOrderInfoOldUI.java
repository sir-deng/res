package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.al;
import com.tencent.mm.f.a.am;
import com.tencent.mm.f.a.io;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wallet_core.c.aa;
import com.tencent.mm.plugin.wallet_core.c.n;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean fpw = true;
    protected boolean fpx = false;
    protected boolean fpy = false;
    protected String jPV = null;
    protected String mAppId = "";
    private String pUC;
    protected String pbT;
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
                x.i("MicroMsg.WalletOrderInfoOldUI", "block pass");
                return true;
            } else if (!"1".equals(syVar.fMg.fMh.fLK) && !"2".equals(syVar.fMg.fMh.fLK)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(syVar.fMg.fMh.fLK, syVar.fMg.fMh.fLL, syVar.fMg.fMh.fLM, syVar.fMg.fMh.fLN, syVar.fMg.fMh.fLO, WalletOrderInfoOldUI.this.sKT == null ? 0 : WalletOrderInfoOldUI.this.sKT.fDQ);
                x.i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
                WalletOrderInfoOldUI.this.vf.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    protected String phx = null;
    protected PayInfo sKT;
    public Orders sKw;
    protected boolean sXE = false;
    private HashMap<String, b> sXJ = new HashMap();
    protected String sXK;
    protected LinearLayout taI = null;
    protected TextView taJ = null;
    protected TextView taK = null;
    public a taL = null;
    protected String taM = null;
    protected HashMap<String, TextView> taN = new HashMap();
    protected c taO;
    protected Map<Long, String> taP = new HashMap();
    private d taQ;
    private boolean taR = false;
    public com.tencent.mm.y.ak.b.a taS = new com.tencent.mm.y.ak.b.a() {
        public final void v(String str, boolean z) {
            com.tencent.mm.storage.x Xv = ((h) g.h(h.class)).Ff().Xv(str);
            x.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoOldUI.this.L(Xv);
        }
    };
    private OnLongClickListener taT = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            if (view.getId() == f.uFM || view.getId() == f.uGk) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(WalletOrderInfoOldUI.this, i.uZO, 0).show();
                    com.tencent.mm.pluginsdk.h.c.a(WalletOrderInfoOldUI.this.mController.xRr, str, str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    };
    public Set<String> tad = null;
    public List<Commodity> tae = null;
    private com.tencent.mm.sdk.b.c tay = new com.tencent.mm.sdk.b.c<am>() {
        {
            this.xmG = am.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            am amVar = (am) bVar;
            if (amVar instanceof am) {
                WalletOrderInfoOldUI.this.taM = amVar.fpt.fpv;
                WalletOrderInfoOldUI.this.fpw = amVar.fpt.fpw;
                WalletOrderInfoOldUI.this.fpx = amVar.fpt.fpx;
                WalletOrderInfoOldUI.this.fpy = amVar.fpt.fpy;
                if (WalletOrderInfoOldUI.this.fpy && !bi.oN(WalletOrderInfoOldUI.this.sXK)) {
                    for (int i = 0; i < WalletOrderInfoOldUI.this.tae.size(); i++) {
                        int i2;
                        Commodity commodity = (Commodity) WalletOrderInfoOldUI.this.tae.get(i);
                        int i3 = -1;
                        int i4 = 0;
                        while (true) {
                            i2 = i3;
                            if (i4 >= commodity.sUB.size()) {
                                break;
                            }
                            Promotions promotions = (Promotions) commodity.sUB.get(i4);
                            if (promotions.type == Orders.sUs && !bi.oN(promotions.url) && promotions.url.equals(WalletOrderInfoOldUI.this.sXK)) {
                                i2 = i4;
                            }
                            i3 = i4 + 1;
                        }
                        if (i2 >= 0) {
                            commodity.sUB.remove(i2);
                        }
                    }
                }
                WalletOrderInfoOldUI.this.taL.notifyDataSetChanged();
                if (!bi.oN(WalletOrderInfoOldUI.this.sXK)) {
                    TextView textView = (TextView) WalletOrderInfoOldUI.this.taN.get(WalletOrderInfoOldUI.this.sXK);
                    if (textView != null) {
                        textView.setClickable(WalletOrderInfoOldUI.this.fpw);
                        textView.setEnabled(WalletOrderInfoOldUI.this.fpw);
                        textView.setOnClickListener(null);
                        if (WalletOrderInfoOldUI.this.fpx) {
                            textView.setVisibility(8);
                        }
                    }
                }
                amVar.fpu.foB = true;
            }
            return false;
        }
    };

    public class a extends BaseAdapter {

        class a {
            TextView ikM;
            CdnImageView sXQ;
            TextView sXR;
            TextView sXS;
            TextView taX;
            TextView taY;
            TextView taZ;
            TextView tba;
            TextView tbb;
            TextView tbc;
            TextView tbd;
            View tbe;
            MaxListView tbf;
            View tbg;
            TextView tbh;
            TextView tbi;
            TextView tbj;
            TextView tbk;
            View tbl;
            ViewGroup tbm;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return zH(i);
        }

        public final int getCount() {
            return WalletOrderInfoOldUI.this.tae != null ? WalletOrderInfoOldUI.this.tae.size() : 0;
        }

        private Commodity zH(int i) {
            return (Commodity) WalletOrderInfoOldUI.this.tae.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uLX, null);
                a aVar2 = new a();
                aVar2.taX = (TextView) view.findViewById(f.uFI);
                aVar2.ikM = (TextView) view.findViewById(f.uFM);
                aVar2.tba = (TextView) view.findViewById(f.uGe);
                aVar2.taY = (TextView) view.findViewById(f.uGj);
                aVar2.taZ = (TextView) view.findViewById(f.uFX);
                aVar2.taZ.getPaint().setFlags(16);
                aVar2.tbb = (TextView) view.findViewById(f.uGk);
                aVar2.tbc = (TextView) view.findViewById(f.uFL);
                aVar2.tbd = (TextView) view.findViewById(f.uFH);
                aVar2.tbf = (MaxListView) view.findViewById(f.uFZ);
                aVar2.tbg = view.findViewById(f.uFP);
                aVar2.tbe = view.findViewById(f.uGc);
                aVar2.tbi = (TextView) view.findViewById(f.uGl);
                aVar2.tbh = (TextView) view.findViewById(f.uGm);
                aVar2.tbj = (TextView) view.findViewById(f.uGn);
                aVar2.tbk = (TextView) view.findViewById(f.uGo);
                aVar2.tbm = (ViewGroup) view.findViewById(f.uGg);
                aVar2.sXQ = (CdnImageView) view.findViewById(f.uDA);
                aVar2.sXR = (TextView) view.findViewById(f.uDw);
                aVar2.sXS = (TextView) view.findViewById(f.uDB);
                aVar2.tbl = view.findViewById(f.uGd);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final Commodity zH = zH(i);
            if (!(zH == null || aVar == null)) {
                CharSequence string;
                WalletOrderInfoOldUI.this.pUC = zH.fvD;
                aVar.taY.setText(e.d(zH.loS, zH.pgf));
                if (zH.sUt < 0.0d || zH.loS >= zH.sUt) {
                    aVar.taZ.setVisibility(8);
                } else {
                    aVar.taZ.setText(e.d(zH.sUt, zH.pgf));
                    aVar.taZ.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) aVar.tbg;
                List list = zH.sUw;
                linearLayout.removeAllViews();
                if (list != null && list.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= list.size()) {
                            break;
                        }
                        DiscountInfo discountInfo = (DiscountInfo) list.get(i3);
                        View textView = new TextView(WalletOrderInfoOldUI.this.mController.xRr);
                        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.bottomMargin = WalletOrderInfoOldUI.this.mController.xRr.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.bup);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(WalletOrderInfoOldUI.this.mController.xRr, j.vfg);
                        if (discountInfo.sUI > 0.0d) {
                            textView.setText(discountInfo.pPL + e.d(discountInfo.sUI / 100.0d, WalletOrderInfoOldUI.this.sKw.pgf));
                        } else {
                            textView.setText(discountInfo.pPL);
                        }
                        linearLayout.addView(textView);
                        textView.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhW));
                        i2 = i3 + 1;
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = aVar.taX;
                Context context = WalletOrderInfoOldUI.this;
                if (q.Gl()) {
                    string = context.getString(i.vad);
                } else {
                    string = context.getString(i.vac);
                }
                textView2.setText(string);
                aVar.tba.setText(zH.pfU);
                aVar.ikM.setText(zH.desc);
                aVar.ikM.setTag(zH.desc);
                aVar.ikM.setOnLongClickListener(WalletOrderInfoOldUI.this.taT);
                aVar.ikM.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.uku);
                aVar.tbb.setText(zH.fvD);
                aVar.tbb.setTag(zH.fvD);
                aVar.tbb.setOnLongClickListener(WalletOrderInfoOldUI.this.taT);
                aVar.tbb.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.uku);
                aVar.tbc.setText(e.gT(zH.pgb));
                aVar.tbd.setText(zH.pgd);
                string = zH.sUx;
                if (aVar.tbj != null) {
                    if (bi.oN(string)) {
                        aVar.tbk.setVisibility(8);
                        aVar.tbj.setVisibility(8);
                    } else {
                        aVar.tbj.setText(string);
                        aVar.tbj.setVisibility(0);
                        aVar.tbk.setVisibility(0);
                    }
                }
                string = zH.sUz;
                if (aVar.tbi != null) {
                    if (bi.oN(string)) {
                        aVar.tbh.setVisibility(8);
                        aVar.tbi.setVisibility(8);
                    } else {
                        aVar.tbi.setText(string);
                        aVar.tbi.setVisibility(0);
                        aVar.tbh.setVisibility(0);
                    }
                }
                if (zH.sUB.size() > 0) {
                    Promotions promotions = (Promotions) zH.sUB.get(0);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13033, Integer.valueOf(1), promotions.pgg, promotions.url, promotions.name, WalletOrderInfoOldUI.this.pUC);
                    WalletOrderInfoOldUI.this.taO = new c(zH.sUB);
                    aVar.tbf.setAdapter(WalletOrderInfoOldUI.this.taO);
                    aVar.tbf.setOnItemClickListener(new OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            Promotions zI = WalletOrderInfoOldUI.this.taO.zI(i);
                            if (bi.oN(zI.pgg)) {
                                String fh = WalletOrderInfoOldUI.this.fh(zI.sOB);
                                if ("-1".equals(fh) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(fh)) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13472, WalletOrderInfoOldUI.this.pUC, Integer.valueOf(zI.sUK), Integer.valueOf(1), Long.valueOf(zI.sOB), Long.valueOf(zI.sTF));
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13033, Integer.valueOf(2), "", zI.url, zI.name, "");
                                    if (!bi.oN(zI.sUN) && !bi.oN(zI.sUO)) {
                                        x.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", zI.sUN, zI.sUO);
                                        com.tencent.mm.sdk.b.b qrVar = new qr();
                                        qrVar.fJd.userName = zI.sUN;
                                        qrVar.fJd.fJf = bi.aD(zI.sUO, "");
                                        qrVar.fJd.scene = 1060;
                                        qrVar.fJd.foi = WalletOrderInfoOldUI.this.pbT;
                                        qrVar.fJd.fJg = 0;
                                        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                        com.tencent.mm.plugin.report.service.g.pWK.h(14118, WalletOrderInfoOldUI.this.pbT, WalletOrderInfoOldUI.this.bKA(), Integer.valueOf(2));
                                        WalletOrderInfoOldUI.this.taQ = new d(zI.sOB, zI.sUL, zI.sTD, zI.sTE, WalletOrderInfoOldUI.this.bKA(), WalletOrderInfoOldUI.this.pUC, zI.sTF);
                                        WalletOrderInfoOldUI.this.taR = true;
                                        return;
                                    } else if (zI.sUK == 1) {
                                        WalletOrderInfoOldUI.this.a(zI);
                                        return;
                                    } else if (zI.sUK != 2 || bi.oN(zI.url)) {
                                        x.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                                        return;
                                    } else if (WalletOrderInfoOldUI.this.sXJ.containsKey(zI.sOB)) {
                                        x.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", ((b) WalletOrderInfoOldUI.this.sXJ.get(zI.sOB)).url);
                                        WalletOrderInfoOldUI.this.NS(r0.url);
                                        return;
                                    } else {
                                        WalletOrderInfoOldUI.this.sXK = zI.url;
                                        WalletOrderInfoOldUI.this.a(zI.url, new d(zI.sOB, zI.sUL, zI.sTD, zI.sTE, WalletOrderInfoOldUI.this.bKA(), WalletOrderInfoOldUI.this.pUC, zI.sTF));
                                        return;
                                    }
                                }
                                return;
                            }
                            if (WalletOrderInfoOldUI.this.tad.contains(zI.pgg)) {
                                WalletOrderInfoOldUI.this.tad.remove(zI.pgg);
                            } else {
                                WalletOrderInfoOldUI.this.tad.add(zI.pgg);
                            }
                            WalletOrderInfoOldUI.this.taL.notifyDataSetChanged();
                        }
                    });
                    WalletOrderInfoOldUI.this.taO.notifyDataSetChanged();
                    aVar.tbf.setVisibility(0);
                    aVar.tbe.setVisibility(0);
                } else {
                    aVar.tbf.setVisibility(8);
                    aVar.tbm.setVisibility(8);
                    aVar.tbe.setVisibility(8);
                }
                if (zH.sUA == null || bi.oN(zH.sUA.sGf)) {
                    aVar.tbm.setVisibility(8);
                    aVar.tbl.setVisibility(8);
                } else {
                    aVar.sXQ.setUrl(zH.sUA.sTJ);
                    aVar.sXR.setText(zH.sUA.sTK);
                    aVar.sXS.setText(zH.sUA.sTI);
                    aVar.tbm.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.sdk.b.b qrVar = new qr();
                            qrVar.fJd.userName = zH.sUA.sGf;
                            qrVar.fJd.fJf = bi.aD(zH.sUA.sGg, "");
                            qrVar.fJd.scene = 1034;
                            qrVar.fJd.fJg = 0;
                            com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                            com.tencent.mm.plugin.report.service.g.pWK.h(14118, WalletOrderInfoOldUI.this.pbT, WalletOrderInfoOldUI.this.bKA(), Integer.valueOf(1));
                        }
                    });
                    aVar.tbl.setVisibility(0);
                }
            }
            return view;
        }
    }

    class b {
        public String fED;
        public String fzT;
        public String taB;
        public String title;
        public String url;

        public b(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.fzT = optJSONObject.optString("wording");
                    this.fED = optJSONObject.optString("icon");
                    this.taB = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                }
            }
        }

        public final String toString() {
            return this.url + " , " + this.fzT + " , " + this.fED + " , " + this.taB + " , " + this.title;
        }
    }

    class c extends BaseAdapter {
        protected List<Promotions> sUB;

        class a {
            TextView ikn;
            TextView ipR;
            int sUJ;
            CdnImageView tbn;
            TextView tbo;
            CheckBox tbp;
            int type;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return zI(i);
        }

        public c(List<Promotions> list) {
            this.sUB = null;
            this.sUB = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Promotions promotions = (Promotions) list.get(i);
                if (promotions != null && (!bi.oN(promotions.pgg) || promotions.sUK == 2 || promotions.sUK == 1)) {
                    this.sUB.add(list.get(i));
                }
            }
        }

        public final int getCount() {
            return this.sUB != null ? this.sUB.size() : 0;
        }

        public final Promotions zI(int i) {
            return (Promotions) this.sUB.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String fh;
            a aVar;
            Promotions zI = zI(i);
            if (bi.oN(zI.pgg) && zI.sOB > 0) {
                fh = WalletOrderInfoOldUI.this.fh(zI.sOB);
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[6];
                objArr[0] = WalletOrderInfoOldUI.this.pUC;
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Integer.valueOf(zI.sUK);
                if ("-1".equals(fh)) {
                    fh = Integer.valueOf(5);
                }
                objArr[3] = fh;
                objArr[4] = Long.valueOf(zI.sOB);
                objArr[5] = Long.valueOf(zI.sTF);
                gVar.h(13471, objArr);
            }
            a aVar2;
            View inflate;
            View view2;
            if (view == null) {
                aVar2 = new a();
                aVar2.type = zI.type;
                if (zI.type == Orders.sUs) {
                    if (zI.sUJ == 1) {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uLY, null);
                        aVar2.tbn = (CdnImageView) inflate.findViewById(f.uFU);
                        aVar2.ikn = (TextView) inflate.findViewById(f.uGh);
                        aVar2.tbo = (TextView) inflate.findViewById(f.uFK);
                        aVar2.ipR = (TextView) inflate.findViewById(f.uFW);
                        if (!TextUtils.isEmpty(zI.url)) {
                            WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uLZ, null);
                        aVar2.tbn = (CdnImageView) inflate.findViewById(f.uFU);
                        aVar2.tbo = (TextView) inflate.findViewById(f.uFK);
                        aVar2.ipR = (TextView) inflate.findViewById(f.uFW);
                        aVar2.ikn = (TextView) inflate.findViewById(f.uGh);
                        if (!TextUtils.isEmpty(zI.url)) {
                            WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.sUJ = zI.sUJ;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uMa, null);
                    aVar2.tbn = (CdnImageView) view.findViewById(f.uFU);
                    aVar2.tbo = (TextView) view.findViewById(f.uFK);
                    aVar2.ipR = (TextView) view.findViewById(f.uFW);
                    aVar2.tbp = (CheckBox) view.findViewById(f.ukX);
                    if (!TextUtils.isEmpty(zI.url)) {
                        WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                a aVar3 = (a) view.getTag();
                Object obj = null;
                if (zI.type == aVar3.type && (zI.type != Orders.sUs || zI.sUJ == aVar3.sUJ)) {
                    obj = 1;
                }
                if (obj == null) {
                    aVar2 = new a();
                    aVar2.type = zI.type;
                    if (zI.type == Orders.sUs) {
                        if (zI.sUJ == 1) {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uLY, null);
                            aVar2.tbn = (CdnImageView) inflate.findViewById(f.uFU);
                            aVar2.ikn = (TextView) inflate.findViewById(f.uGh);
                            aVar2.tbo = (TextView) inflate.findViewById(f.uFK);
                            aVar2.ipR = (TextView) inflate.findViewById(f.uFW);
                            if (!TextUtils.isEmpty(zI.url)) {
                                WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        } else {
                            inflate = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uLZ, null);
                            aVar2.tbn = (CdnImageView) inflate.findViewById(f.uFU);
                            aVar2.tbo = (TextView) inflate.findViewById(f.uFK);
                            aVar2.ipR = (TextView) inflate.findViewById(f.uFW);
                            aVar2.ikn = (TextView) inflate.findViewById(f.uGh);
                            if (!TextUtils.isEmpty(zI.url)) {
                                WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        }
                        aVar2.sUJ = zI.sUJ;
                        view = view2;
                        aVar = aVar2;
                    } else {
                        view = View.inflate(WalletOrderInfoOldUI.this, com.tencent.mm.plugin.wxpay.a.g.uMa, null);
                        aVar2.tbn = (CdnImageView) view.findViewById(f.uFU);
                        aVar2.tbo = (TextView) view.findViewById(f.uFK);
                        aVar2.ipR = (TextView) view.findViewById(f.uFW);
                        aVar2.tbp = (CheckBox) view.findViewById(f.ukX);
                        if (!TextUtils.isEmpty(zI.url)) {
                            WalletOrderInfoOldUI.this.taN.put(zI.url, aVar2.tbo);
                        }
                        view.setTag(aVar2);
                        aVar = aVar2;
                    }
                } else {
                    aVar = aVar3;
                }
            }
            if (zI != null) {
                b bVar = (b) WalletOrderInfoOldUI.this.sXJ.get(zI.sOB);
                x.i("MicroMsg.WalletOrderInfoOldUI", "try get result " + bVar);
                if (bVar != null) {
                    aVar.tbn.setUrl(bVar.fED);
                    aVar.ipR.setText(bVar.fzT);
                    aVar.tbo.setText(bVar.taB);
                } else {
                    aVar.tbn.setUrl(zI.pkG);
                    aVar.ipR.setText(zI.name);
                    aVar.tbo.setText(zI.sTG);
                }
                if (bi.oN(zI.pgg)) {
                    aVar.tbo.setVisibility(0);
                    if (aVar.tbp != null) {
                        aVar.tbp.setVisibility(8);
                    }
                } else {
                    aVar.tbo.setVisibility(8);
                    if (aVar.tbp != null) {
                        aVar.tbp.setVisibility(0);
                        if (WalletOrderInfoOldUI.this.tad.contains(zI.pgg)) {
                            aVar.tbp.setChecked(true);
                        } else {
                            aVar.tbp.setChecked(false);
                        }
                    }
                }
                if (aVar.ikn != null && bVar != null && !bi.oN(bVar.title)) {
                    aVar.ikn.setText(bVar.title);
                } else if (aVar.ikn != null && !bi.oN(zI.title)) {
                    aVar.ikn.setText(zI.title);
                } else if (aVar.ikn != null) {
                    aVar.ikn.setVisibility(8);
                }
                if (!(bi.oN(WalletOrderInfoOldUI.this.sXK) || aVar.tbo == null)) {
                    aVar.tbo.setClickable(WalletOrderInfoOldUI.this.fpw);
                    aVar.tbo.setEnabled(WalletOrderInfoOldUI.this.fpw);
                    aVar.tbo.setOnClickListener(null);
                    if (WalletOrderInfoOldUI.this.fpx) {
                        aVar.tbo.setVisibility(8);
                    }
                }
                fh = WalletOrderInfoOldUI.this.fh(zI.sOB);
                if (fh.equals("0")) {
                    aVar.tbo.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.transparent));
                    aVar.tbo.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.buj));
                } else if (fh.equals("-1") || fh.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    aVar.tbo.setBackgroundDrawable(WalletOrderInfoOldUI.this.getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.uiY));
                    aVar.tbo.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.buj));
                } else if (fh.equals("4") || fh.equals("2") || fh.equals("1")) {
                    aVar.tbo.setBackgroundColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.transparent));
                    aVar.tbo.setTextColor(WalletOrderInfoOldUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.bsO));
                } else {
                    x.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
                }
            }
            if (aVar.tbo != null) {
                int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(WalletOrderInfoOldUI.this.mController.xRr, 15.0f);
                int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(WalletOrderInfoOldUI.this.mController.xRr, 5.0f);
                aVar.tbo.setPadding(b, b2, b, b2);
            }
            return view;
        }
    }

    class d {
        public String fxT;
        public String pRd;
        public String sOY;
        public long sUY;
        public String taD;
        public String taE;
        public String taF;

        public d(String str, String str2, String str3, String str4, String str5, String str6, long j) {
            this.sOY = str;
            this.taD = str2;
            this.taE = str3;
            this.taF = str4;
            this.fxT = str5;
            this.pRd = str6;
            this.sUY = j;
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFG;
    }

    private void Xc() {
        int i = 1;
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        this.sKT = (PayInfo) this.vf.getParcelable("key_pay_info");
        this.pbT = this.vf.getString("key_trans_id");
        this.vf.getInt("key_pay_type", -1);
        x.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", this.pbT);
        this.sKw = bNr();
        if (this.sKw != null) {
            uV(0);
            c(this.sKw);
            if (!(ag == null || this.sKw == null || this.sKT == null)) {
                boolean z;
                this.mAppId = this.sKT.appId;
                boolean cCb = ag.cCb();
                com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 7);
                int i2 = this.vf.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.sKT.fDQ);
                if (this.sKT.fDQ == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!cCb) {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
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
                x.k("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.h.a(this.mController.xRr, i.uZS, 0, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletOrderInfoOldUI.this.done();
                    }
                });
            } else {
                this.tae = this.sKw.sUf;
                this.pbT = ((Commodity) this.tae.get(0)).fvD;
                if (!(this.sKT == null || ag == null || (!ag.cCa() && !ag.cCb()))) {
                    bNs();
                }
            }
            if (this.pbT == null) {
                boolean booleanValue;
                Object obj = g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_FINGER_PRINT_SHOW_OPEN_GUIDE_IN_TRANSPARENT_NEW_BOOLEAN_SYNC, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "has show the finger print auth guide!");
                    return;
                }
                com.tencent.mm.wallet_core.c ag2 = com.tencent.mm.wallet_core.a.ag(this);
                Bundle bundle = new Bundle();
                if (ag2 != null) {
                    bundle = ag2.mym;
                }
                if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
                    x.i("MicroMsg.WalletOrderInfoOldUI", "pwd is empty, not show the finger print auth guide!");
                    return;
                }
                this.taR = false;
                if (ag2 != null) {
                    ag2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
                    return;
                }
                return;
            }
            return;
        }
        x.k("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.h.a(this.mController.xRr, i.uZS, 0, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                WalletOrderInfoOldUI.this.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(4);
        this.tad = new HashSet();
        Xc();
        initView();
        jl(1979);
        com.tencent.mm.sdk.b.a.xmy.b(this.tay);
        com.tencent.mm.sdk.b.a.xmy.b(this.peh);
        this.taR = false;
    }

    protected final boolean boI() {
        return false;
    }

    public Orders bNr() {
        return (Orders) this.vf.getParcelable("key_orders");
    }

    public void bNs() {
        l(new y(bKA(), 21));
    }

    public void NT(String str) {
        l(new z(str));
    }

    protected final void cu(String str, int i) {
        l(new z(str, i));
    }

    protected final void a(Promotions promotions) {
        r(new n(promotions, bKA(), this.pbT, promotions.sTF));
    }

    private void c(Orders orders) {
        this.tad.clear();
        if (orders == null || orders.sUf == null) {
            x.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.sUf) {
            if (commodity.sTW == 2 && !bi.oN(commodity.sUu)) {
                x.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.tad.add(commodity.sUu);
            }
        }
    }

    protected final void initView() {
        setMMTitle(i.vas);
        showHomeBtn(false);
        enableBackMenu(false);
        String string = getString(i.dFw);
        if (this.sKT == null || this.sKT.fDQ != 2) {
            if (!(this.sKw == null || bi.oN(this.sKw.sUq))) {
                string = this.sKw.sUq;
            }
        } else if (!bi.oN(this.sKT.tgP)) {
            string = getString(i.dDZ) + this.sKT.tgP;
        } else if (!(bi.oN(this.sKT.appId) || bi.oN(com.tencent.mm.pluginsdk.model.app.g.l(this, this.sKT.appId)))) {
            string = getString(i.dDZ) + com.tencent.mm.pluginsdk.model.app.g.l(this, this.sKT.appId);
        }
        addTextOptionMenu(0, string, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletOrderInfoOldUI.this.done();
                return true;
            }
        });
        this.taI = (LinearLayout) findViewById(f.uGb);
        this.taJ = (TextView) findViewById(f.uGa);
        this.taK = (TextView) findViewById(f.uFT);
        MaxListView maxListView = (MaxListView) findViewById(f.uFG);
        this.taL = new a();
        maxListView.setAdapter(this.taL);
        bNt();
        bNu();
        ((ScrollView) findViewById(f.cYF)).pageScroll(33);
    }

    public final void bNt() {
        if (this.sKw != null) {
            int i;
            this.tae = this.sKw.sUf;
            for (Commodity commodity : this.tae) {
                if ("1".equals(commodity.pfY)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.taI.setVisibility(0);
            this.taJ.setVisibility(0);
            if (i == 0) {
                this.taJ.setText(i.vai);
            } else if (!bi.oN(this.sKw.sTY) && !bi.oN(this.sKw.sTY.trim())) {
                this.taJ.setText(this.sKw.sTY);
            } else if (this.sKw.sOT != 1) {
                this.taJ.setText(i.vah);
            } else {
                this.taJ.setText(i.vag);
            }
        }
    }

    protected final void a(String str, d dVar) {
        bNg();
        this.taQ = dVar;
        e.s(this, str, 1);
        this.taR = false;
    }

    protected final void NS(String str) {
        bNg();
        e.l(this, str, false);
        this.taR = false;
    }

    public final void bNg() {
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

    public final void L(com.tencent.mm.storage.x xVar) {
        if (xVar != null && ((int) xVar.gKO) != 0) {
            String AW = xVar.AW();
            x.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + AW + " username: " + xVar.field_username);
            if (this.tae != null && this.tae.size() > 0) {
                for (Commodity commodity : this.tae) {
                    commodity.pgg = AW;
                }
                this.taL.notifyDataSetChanged();
            }
            this.jPV = xVar.field_username;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.tay);
        com.tencent.mm.sdk.b.a.xmy.c(this.peh);
        jm(1979);
    }

    public void done() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WalletOrderInfoOldUI.this.bNq();
                    }
                });
                this.vf.remove("key_realname_guide_helper");
                if (!b) {
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
        this.taR = false;
        com.tencent.mm.sdk.b.b alVar = new al();
        alVar.fpq.fpr = true;
        com.tencent.mm.sdk.b.a.xmy.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.vf.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.vf.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.vf.getBoolean("intent_pay_end"));
        x.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.vf.getInt("intent_pay_end_errcode"));
        for (String str : this.tad) {
            if (!bi.oN(str)) {
                x.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                if (this.sKw == null || this.sKT == null) {
                    g.Dp().gRu.a(new com.tencent.mm.wallet_core.c.i(str), 0);
                } else {
                    g.Dp().gRu.a(new com.tencent.mm.wallet_core.c.i(str, this.sKw.fvC, this.sKw.sUf.size() > 0 ? ((Commodity) this.sKw.sUf.get(0)).fvD : "", this.sKT.fDQ, this.sKT.fDM, this.sKw.sTW), 0);
                }
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13033, Integer.valueOf(2), str, "", "", "");
        }
        com.tencent.mm.wallet_core.a.j(this, bundle);
        if (this.sKw != null && !bi.oN(this.sKw.lUI)) {
            String d = WalletOrderInfoUI.d(this.sKw.lUI, this.sKw.fvC, this.sKw.sUf.size() > 0 ? ((Commodity) this.sKw.sUf.get(0)).fvD : "", this.sKT.kPP, this.sKT.iLo);
            x.d("MicroMsg.WalletOrderInfoOldUI", "url = " + d);
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

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(i.vae), getResources().getStringArray(com.tencent.mm.plugin.wxpay.a.b.ugS), "", new com.tencent.mm.ui.base.h.c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        WalletOrderInfoOldUI.this.taR = false;
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoOldUI.this.phx).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        WalletOrderInfoOldUI.this.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", Boolean.valueOf(this.taR));
        if (this.taR) {
            l(new aa(this.taQ.sOY, this.taQ.taD, this.taQ.taE, this.taQ.taF, this.taQ.fxT, this.taQ.pRd, this.taQ.sUY));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            l(new aa(this.taQ.sOY, this.taQ.taD, this.taQ.taE, this.taQ.taF, this.taQ.fxT, this.taQ.pRd, this.taQ.sUY));
        }
    }

    private void bNu() {
        if (this.sKw == null || this.sKw.sUf == null || this.sKw.sUf.size() <= 0 || ((Commodity) this.sKw.sUf.get(0)).sUD == null || bi.oN(((Commodity) this.sKw.sUf.get(0)).sUD.text) || bi.oN(((Commodity) this.sKw.sUf.get(0)).sUD.url)) {
            x.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.taK.setVisibility(8);
            return;
        }
        this.taK.setVisibility(0);
        this.taK.setText(((Commodity) this.sKw.sUf.get(0)).sUD.text);
        this.taK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.l(WalletOrderInfoOldUI.this, ((Commodity) WalletOrderInfoOldUI.this.sKw.sUf.get(0)).sUD.url, false);
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof aa) && i == 0 && i2 == 0) {
            aa aaVar = (aa) kVar;
            b bVar = new b(aaVar.oxl);
            boolean z = (bi.oN(bVar.url) || bi.oN(bVar.fzT)) ? false : true;
            if (z) {
                this.sXJ.put(aaVar.sOY, bVar);
            }
            this.taL.notifyDataSetChanged();
        }
        if (kVar instanceof z) {
            if (i == 0 && i2 == 0) {
                uV(0);
                this.sKw = ((z) kVar).sOZ;
                if (this.sKw != null) {
                    this.tae = this.sKw.sUf;
                }
                c(this.sKw);
                x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.tae);
                if (!(this.tae == null || this.tae.size() == 0)) {
                    Commodity commodity = (Commodity) this.tae.get(0);
                    this.pbT = commodity.fvD;
                    x.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    com.tencent.mm.k.a Xv = ((h) g.h(h.class)).Ff().Xv(commodity.pgg);
                    if (Xv == null || ((int) Xv.gKO) == 0) {
                        com.tencent.mm.y.ak.a.hhv.a(commodity.pgg, "", this.taS);
                    } else {
                        L(Xv);
                    }
                    this.taL.notifyDataSetChanged();
                    bNt();
                }
            }
            if (this.taL != null) {
                this.taL.notifyDataSetChanged();
            }
            bNu();
            return true;
        }
        if (kVar instanceof n) {
            if (i == 0 && i2 == 0) {
                n nVar = (n) kVar;
                String str2 = nVar.sOI;
                this.taP.put(Long.valueOf(nVar.sOL.sOB), str2);
                nVar.sOL.sTG = nVar.lfa;
                if (!"-1".equals(str2) && !"0".equals(str2) && !bi.oN(nVar.sOJ)) {
                    com.tencent.mm.ui.base.h.b(this, nVar.sOJ, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bi.oN(nVar.sOJ)) {
                        string = getString(i.vaU);
                    } else {
                        string = nVar.sOJ;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.taL.notifyDataSetChanged();
                return true;
            } else if (kVar instanceof n) {
                if (bi.oN(str)) {
                    str = getString(i.vdG);
                }
                com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        }
        return false;
    }

    public final String fh(long j) {
        if (this.taP.containsKey(Long.valueOf(j))) {
            return (String) this.taP.get(Long.valueOf(j));
        }
        return "-1";
    }
}
