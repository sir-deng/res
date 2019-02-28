package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI extends MMActivity implements e {
    private String gCB = null;
    private String mTitle = null;
    private c nOi = new c<ii>() {
        {
            this.xmG = ii.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ah.y(new Runnable() {
                public final void run() {
                    as.Hm();
                    if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        IPCallShareCouponUI.this.nSk.setVisibility(0);
                    } else {
                        IPCallShareCouponUI.this.nSk.setVisibility(8);
                    }
                    as.Hm();
                    IPCallShareCouponUI.this.nSj.setText((String) com.tencent.mm.y.c.Db().get(a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
                    as.Hm();
                    IPCallShareCouponUI.this.nSm.setText((String) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
                }
            });
            return true;
        }
    };
    private ProgressDialog nOr;
    private String nRN = null;
    private String nRO = null;
    private String nRP = null;
    private String nRQ = null;
    private String nRR = null;
    private String nRS = null;
    private String nRT = null;
    private String nRU = null;
    private TextView nSA;
    private View nSB;
    private IPCallDynamicTextView nSC;
    private com.tencent.mm.plugin.ipcall.a.e.b nSD = new com.tencent.mm.plugin.ipcall.a.e.b();
    private LinkedList<byd> nSE = null;
    private boolean nSF = false;
    private RelativeLayout nSi;
    private TextView nSj;
    private ImageView nSk;
    private RelativeLayout nSl;
    private TextView nSm;
    private ImageView nSn;
    private LinearLayout nSo;
    private LinearLayout nSp;
    private LinearLayout nSq;
    private LinearLayout nSr;
    private ImageView nSs;
    private LinearLayout nSt;
    private ImageView nSu;
    private TextView nSv;
    private TextView nSw;
    private TextView nSx;
    private ImageView nSy;
    private TextView nSz;

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nSD;
        bVar.nLD++;
        g.pWK.a(257, 2, 1, true);
        String string = ad.getContext().getString(R.l.ere);
        try {
            com.tencent.mm.kernel.g.Do();
            int Cn = com.tencent.mm.kernel.a.Cn();
            String encode = URLEncoder.encode(d.vHj, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bi.che(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(q.yL(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.vHe, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.vHf, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.vHg, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(as.CI(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + d.vHl + "&lang=" + w.eM(ad.getContext()) + ("&uin=" + Cn + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bi.fb(ad.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", e.getMessage());
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.bl.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nSD;
        bVar.nLE++;
        g.pWK.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.eqI));
        intent.putExtra("showShare", false);
        com.tencent.mm.bl.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        com.tencent.mm.plugin.ipcall.a.e.b bVar = iPCallShareCouponUI.nSD;
        bVar.nLC++;
        g.pWK.a(257, 1, 1, true);
        as.Hm();
        com.tencent.mm.y.c.Db().a(a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
        iPCallShareCouponUI.nSy.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.eqT));
        intent.putExtra("showShare", false);
        com.tencent.mm.bl.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        aiq aVw = com.tencent.mm.plugin.ipcall.b.c.aVw();
        if (aVw != null && !bi.oN(aVw.wwL)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aVw.wwL);
            intent.putExtra("showShare", false);
            com.tencent.mm.bl.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        as.CN().a(257, (e) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.nOi);
        setMMTitle(R.l.erJ);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallShareCouponUI.this.finish();
                return true;
            }
        });
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                String[] strArr;
                aiq aVw = com.tencent.mm.plugin.ipcall.b.c.aVw();
                if (!(aVw == null || bi.oN(aVw.wwL))) {
                    if (com.tencent.mm.j.g.Af().getInt("WCOWebPayListSwitch", 0) > 0) {
                        z = true;
                        if (z) {
                            strArr = new String[]{IPCallShareCouponUI.this.getString(R.l.eqW), IPCallShareCouponUI.this.getString(R.l.eqH)};
                            IPCallShareCouponUI.this.nSF = false;
                        } else {
                            strArr = new String[]{IPCallShareCouponUI.this.getString(R.l.erI), IPCallShareCouponUI.this.getString(R.l.eqW), IPCallShareCouponUI.this.getString(R.l.eqH)};
                            IPCallShareCouponUI.this.nSF = true;
                        }
                        h.a(IPCallShareCouponUI.this.mController.xRr, null, strArr, null, false, new h.c() {
                            public final void jo(int i) {
                                if (!IPCallShareCouponUI.this.nSF) {
                                    i++;
                                }
                                switch (i) {
                                    case 0:
                                        IPCallShareCouponUI.i(IPCallShareCouponUI.this);
                                        return;
                                    case 1:
                                        IPCallShareCouponUI.d(IPCallShareCouponUI.this);
                                        return;
                                    case 2:
                                        IPCallShareCouponUI.e(IPCallShareCouponUI.this);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                }
                z = false;
                if (z) {
                    strArr = new String[]{IPCallShareCouponUI.this.getString(R.l.eqW), IPCallShareCouponUI.this.getString(R.l.eqH)};
                    IPCallShareCouponUI.this.nSF = false;
                } else {
                    strArr = new String[]{IPCallShareCouponUI.this.getString(R.l.erI), IPCallShareCouponUI.this.getString(R.l.eqW), IPCallShareCouponUI.this.getString(R.l.eqH)};
                    IPCallShareCouponUI.this.nSF = true;
                }
                h.a(IPCallShareCouponUI.this.mController.xRr, null, strArr, null, false, /* anonymous class already generated */);
                return true;
            }
        });
        this.nSC = (IPCallDynamicTextView) findViewById(R.h.bMF);
        this.nSi = (RelativeLayout) findViewById(R.h.cGv);
        this.nSj = (TextView) findViewById(R.h.cGy);
        this.nSk = (ImageView) findViewById(R.h.cGw);
        as.Hm();
        if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            this.nSk.setVisibility(0);
        }
        as.Hm();
        this.nSj.setText((String) com.tencent.mm.y.c.Db().get(a.USERFINO_IPCALL_RECHARGE_STRING, (Object) ""));
        this.nSl = (RelativeLayout) findViewById(R.h.cEq);
        this.nSm = (TextView) findViewById(R.h.cCn);
        this.nSn = (ImageView) findViewById(R.h.cCl);
        as.Hm();
        this.nSm.setText((String) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, (Object) ""));
        this.nSz = (TextView) findViewById(R.h.bZm);
        this.nSA = (TextView) findViewById(R.h.cCk);
        this.nSB = findViewById(R.h.cOO);
        this.nSo = (LinearLayout) findViewById(R.h.ceU);
        this.nSy = (ImageView) findViewById(R.h.czr);
        as.Hm();
        if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_EXCHANGE_RECORD_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            this.nSy.setVisibility(0);
        }
        this.nSv = (TextView) findViewById(R.h.cAI);
        this.nSw = (TextView) findViewById(R.h.bJH);
        this.nSx = (TextView) findViewById(R.h.cPF);
        this.nSp = (LinearLayout) findViewById(R.h.cNP);
        this.nSq = (LinearLayout) findViewById(R.h.cyC);
        this.nSt = (LinearLayout) findViewById(R.h.cKD);
        this.nSu = (ImageView) findViewById(R.h.cKE);
        this.nSr = (LinearLayout) findViewById(R.h.cxB);
        this.nSs = (ImageView) findViewById(R.h.cxC);
        as.Hm();
        if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            this.nSs.setVisibility(0);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aVv()) {
            z = true;
        } else {
            z = com.tencent.mm.j.g.Af().getInt("WCOPurchaseSwitch", 0) == 1;
        }
        if (z) {
            this.nSi.setVisibility(8);
        }
        z = (com.tencent.mm.plugin.ipcall.b.c.aVv() || com.tencent.mm.j.g.Af().getInt("WCOPackagePurchaseSwitch", 0) == 0) ? false : true;
        if (z) {
            this.nSl.setVisibility(0);
        }
        if (com.tencent.mm.j.g.Af().getInt("WCOAccountDetailSwitch", 0) == 1) {
            this.nSo.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aVv()) {
            z = true;
        } else {
            z = com.tencent.mm.j.g.Af().getInt("WCOInviteFriend", 0) == 1;
        }
        if (z) {
            this.nSp.setVisibility(8);
        }
        this.nSv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                IPCallShareCouponUI.d(IPCallShareCouponUI.this);
            }
        });
        this.nSw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                IPCallShareCouponUI.e(IPCallShareCouponUI.this);
            }
        });
        this.nSo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                IPCallShareCouponUI.f(IPCallShareCouponUI.this);
            }
        });
        this.nSp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(13340, Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.xRr, IPCallShareCouponCardUI.class);
                IPCallShareCouponUI.this.mController.xRr.startActivity(intent);
            }
        });
        this.nSr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    as.Hm();
                    i.N(4, -1, ((Integer) com.tencent.mm.y.c.Db().get(a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1))).intValue());
                }
                as.Hm();
                com.tencent.mm.y.c.Db().a(a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(-1));
                as.Hm();
                com.tencent.mm.y.c.Db().a(a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                IPCallShareCouponUI.this.nSs.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.xRr, IPCallMsgUI.class);
                IPCallShareCouponUI.this.mController.xRr.startActivity(intent);
            }
        });
        this.nSq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.xRr, IPCallMyGiftCardUI.class);
                IPCallShareCouponUI.this.mController.xRr.startActivity(intent);
            }
        });
        this.nSi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                if (((Boolean) com.tencent.mm.y.c.Db().get(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    i.N(3, -1, -1);
                }
                as.Hm();
                com.tencent.mm.y.c.Db().a(a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                IPCallShareCouponUI.this.nSk.setVisibility(8);
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.xRr, IPCallRechargeUI.class);
                IPCallShareCouponUI.this.startActivity(intent);
            }
        });
        this.nSl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(IPCallShareCouponUI.this.mController.xRr, IPCallPackageUI.class);
                IPCallShareCouponUI.this.startActivity(intent);
            }
        });
        this.nSt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                String str = IPCallShareCouponUI.this.getString(R.l.erp) + "&usedcc=";
                List aTT = com.tencent.mm.plugin.ipcall.a.c.aTQ().aTT();
                if (aTT == null || aTT.size() <= 0) {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.DJ(com.tencent.mm.plugin.ipcall.b.c.aVu());
                } else {
                    int size = aTT.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String DJ = com.tencent.mm.plugin.ipcall.b.a.DJ(((Integer) aTT.get(i)).toString());
                        if (bi.oN(DJ)) {
                            DJ = str;
                        } else {
                            DJ = str + DJ + "|";
                        }
                        i++;
                        str = DJ;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bl.d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        aiq aVw = com.tencent.mm.plugin.ipcall.b.c.aVw();
        if (aVw != null) {
            a(aVw);
            amN();
        } else {
            this.nSC.setText("0");
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.nOr = h.a(context, getString(R.l.erb), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        IPCallShareCouponUI.this.finish();
                    } catch (Exception e) {
                        x.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", e.getMessage());
                    }
                }
            });
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aVv()) {
            String string = getString(R.l.esx);
            CharSequence charSequence = string + getString(R.l.esw);
            AnonymousClass5 anonymousClass5 = new ClickableSpan() {
                public final void onClick(View view) {
                    ((TextView) view).setHighlightColor(IPCallShareCouponUI.this.getResources().getColor(R.e.transparent));
                    String str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=weixin_phone/notice";
                    String eM = w.eM(ad.getContext());
                    if (!bi.oN(eM)) {
                        str = str + "&wechat_real_lang=" + eM;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bl.d.b(IPCallShareCouponUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(IPCallShareCouponUI.this.getResources().getColor(R.e.btd));
                    textPaint.setUnderlineText(false);
                }
            };
            Spannable newSpannable = Factory.getInstance().newSpannable(charSequence);
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(anonymousClass5, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(anonymousClass5, length, length2, 33);
            }
            this.nSx.setText(newSpannable);
            this.nSx.setMovementMethod(LinkMovementMethod.getInstance());
            this.nSx.setVisibility(0);
        } else {
            this.nSx.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.csG);
        if (linearLayout != null && this.nSi.getVisibility() == 8 && this.nSl.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) findViewById(R.h.csH);
        if (linearLayout != null && this.nSp.getVisibility() == 8 && this.nSq.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        this.nSD.start();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.ipcall.a.f.b.aUJ().gf(false);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(257, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.nOi);
        this.nSD.nLB = System.currentTimeMillis();
        this.nSD.finish();
    }

    protected final int getLayoutId() {
        return R.i.dmg;
    }

    private void amN() {
        if (!bi.oN(this.nRS)) {
            if (this.nRR == null) {
                this.nSC.setValue(this.nRS, this.nRS);
            } else {
                this.nSC.setValue(this.nRR, this.nRS);
            }
            this.nRR = this.nRS;
        }
        this.nSz.getText();
        this.nSz.setText(this.nRT);
        if (bi.oN(this.nRT)) {
            this.nSz.setVisibility(8);
        } else {
            this.nSz.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.nSE != null && this.nSE.size() > 0) {
            Iterator it = this.nSE.iterator();
            while (it.hasNext()) {
                byd byd = (byd) it.next();
                if (!(byd == null || bi.oN(byd.xfB))) {
                    stringBuffer.append(byd.xfB).append(10);
                }
            }
        }
        if (bi.oN(stringBuffer.toString())) {
            this.nSA.setText("");
            this.nSA.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == 10) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.nSA.setText(stringBuffer.toString());
            this.nSA.setVisibility(0);
        }
        if (this.nSz.getVisibility() == 0 && this.nSA.getVisibility() == 0) {
            this.nSB.setVisibility(0);
        } else {
            this.nSB.setVisibility(8);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            a(((com.tencent.mm.plugin.ipcall.a.d.g) kVar).nLj);
            amN();
            if (this.nOr != null && this.nOr.isShowing()) {
                this.nOr.dismiss();
            }
        } else if (this.nOr != null && this.nOr.isShowing()) {
            this.nOr.dismiss();
            h.a(this.mController.xRr, getString(R.l.eqZ), getString(R.l.eqV), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    IPCallShareCouponUI.this.finish();
                }
            });
        }
    }

    private void a(aiq aiq) {
        this.nRN = aiq.wwB;
        this.gCB = aiq.nkL;
        this.nRO = aiq.wwC;
        this.mTitle = aiq.fpg;
        this.nRP = aiq.nMr;
        this.nRQ = aiq.wwD;
        this.nRS = aiq.wwE;
        this.nRT = aiq.wwF;
        this.nRU = aiq.wwG;
        this.nSE = aiq.wwp;
    }
}
