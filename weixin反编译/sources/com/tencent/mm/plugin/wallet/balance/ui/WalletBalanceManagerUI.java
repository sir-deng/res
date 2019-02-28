package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI extends WalletBaseUI implements j {
    protected int itU;
    protected TextView sFT;
    protected Button sFU;
    protected View sFV;
    protected View sFW;
    protected TextView sFX;
    protected Bankcard sFY;
    protected TextView sFu;

    private static class a {
        public int sGd;
        public String sGe;
        public String sGf;
        public String sGg;
        public String title;

        a() {
        }
    }

    static /* synthetic */ void c(WalletBalanceManagerUI walletBalanceManagerUI) {
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.vf.get("key_pay_info");
        Parcelable payInfo = new PayInfo();
        payInfo.fDQ = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", com.tencent.mm.plugin.wallet.balance.a.sEe);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, com.tencent.mm.plugin.wallet.balance.a.class, bundle, null);
    }

    protected final int getLayoutId() {
        return g.uKT;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((b) com.tencent.mm.kernel.g.h(b.class)).a(this, null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.uhR));
        }
        if (d.fN(21)) {
            getWindow().setStatusBarColor(getResources().getColor(c.uhT));
        }
        cnG();
        oj(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (WalletBalanceManagerUI.this.bKK()) {
                    WalletBalanceManagerUI.this.aWY();
                    WalletBalanceManagerUI.this.showDialog(1000);
                } else {
                    WalletBalanceManagerUI.this.finish();
                }
                return true;
            }
        }, h.uMN);
        this.itU = getIntent().getIntExtra("key_scene_balance_manager", 0);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("key_inc_bal_amt_flag");
        ECardInfo eCardInfo = (ECardInfo) intent.getParcelableExtra("key_ecard_info");
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(stringExtra)) {
            if (eCardInfo != null) {
                View inflate = LayoutInflater.from(this).inflate(g.uLD, null);
                ImageView imageView = (ImageView) inflate.findViewById(f.bWn);
                int b = BackwardSupportUtil.b.b((Context) this, 15.0f);
                bi.j(imageView, b, b, b, b);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.uwo);
                Button button = (Button) inflate.findViewById(f.uDQ);
                TextView textView = (TextView) inflate.findViewById(f.uwm);
                CheckBox checkBox = (CheckBox) inflate.findViewById(f.checkbox);
                TextView textView2 = (TextView) inflate.findViewById(f.uol);
                ((TextView) inflate.findViewById(f.euO)).setText(eCardInfo.title);
                linearLayout.removeAllViews();
                Iterator it = eCardInfo.sSu.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    View inflate2 = LayoutInflater.from(this).inflate(g.uLC, null);
                    ((TextView) inflate2.findViewById(f.uHj)).setText(str);
                    linearLayout.addView(inflate2);
                }
                b = eCardInfo.sSx.length();
                int length = (eCardInfo.sSx + eCardInfo.sSy).length();
                CharSequence spannableString = new SpannableString(eCardInfo.sSx + eCardInfo.sSy);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(c.uie)), b, length, 33);
                textView.setText(spannableString);
                textView.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass6(eCardInfo, this));
                Dialog dialog = new Dialog(this, com.tencent.mm.plugin.wxpay.a.j.eZl);
                dialog.setContentView(inflate);
                dialog.setTitle(null);
                dialog.setOnCancelListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass7(dialog));
                imageView.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass8(dialog));
                button.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass9(eCardInfo, this, dialog));
                if (eCardInfo.sSo == 1) {
                    checkBox.setOnCheckedChangeListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass10(button));
                    if (eCardInfo.sSp == 1) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                        button.setEnabled(false);
                        button.setClickable(false);
                    }
                } else {
                    checkBox.setVisibility(8);
                }
                int length2 = eCardInfo.sSq.length();
                length = (eCardInfo.sSq + eCardInfo.sSr).length();
                CharSequence spannableString2 = new SpannableString(eCardInfo.sSq + eCardInfo.sSr);
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(c.uie)), length2, length, 33);
                textView2.setText(spannableString2);
                textView2.setOnClickListener(new com.tencent.mm.plugin.wallet_core.ui.j.AnonymousClass2(eCardInfo, this));
                dialog.show();
            } else {
                x.w("MicroMsg.WalletBalanceManagerUI", "ecard info is null");
            }
        }
        jl(621);
        o.bMj();
        aa.a(this);
        initView();
        p.fw(2, 0);
        com.tencent.mm.plugin.report.service.g.pWK.h(11850, Integer.valueOf(6), Integer.valueOf(0));
        e.HX(10);
    }

    public void bKd() {
        com.tencent.mm.plugin.wallet.a.p.bKx();
        b(new y(null, 10), com.tencent.mm.plugin.wallet.a.p.bKy().sFY == null);
    }

    public void onDestroy() {
        jm(621);
        o.bMj();
        aa.b(this);
        super.onDestroy();
    }

    public void bKe() {
        G(WalletBalanceSaveUI.class);
    }

    protected final void initView() {
        setMMTitle(i.uVR);
        this.sFT = (TextView) findViewById(f.uEi);
        this.sFu = (TextView) findViewById(f.uDW);
        ((Button) findViewById(f.cAl)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBalanceManagerUI.this.bKe();
                e.HX(14);
            }
        });
        this.sFU = (Button) findViewById(f.uDX);
        this.sFU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.wallet.a.p.bKx();
                ArrayList bML = com.tencent.mm.plugin.wallet.a.p.bKy().bML();
                if (bML == null || bML.size() == 0) {
                    x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is empty, do bind card to fetch");
                    com.tencent.mm.ui.base.h.a((Context) WalletBalanceManagerUI.this, false, WalletBalanceManagerUI.this.getString(i.uVO), "", WalletBalanceManagerUI.this.getString(i.uVN), WalletBalanceManagerUI.this.getString(i.dEy), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            WalletBalanceManagerUI.c(WalletBalanceManagerUI.this);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                x.i("MicroMsg.WalletBalanceManagerUI", "mBankcardList is valid, to do fetch");
                com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
                e.HX(15);
            }
        });
        TextView textView = (TextView) findViewById(f.uDY);
        if (!w.cfV().equals("zh_CN") ? true : bi.PZ()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "https://kf.qq.com/touch/scene_product.html?scene_id=kf4");
                    intent.putExtra("showShare", false);
                    intent.putExtra("geta8key_username", q.FY());
                    com.tencent.mm.bl.d.b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    e.HX(17);
                }
            });
            textView.setVisibility(0);
        }
        ((TextView) findViewById(f.uGI)).setText(u.cCt());
        this.sFV = findViewById(f.usp);
        this.sFX = (TextView) findViewById(f.usq);
        this.sFW = findViewById(f.uso);
        final com.tencent.mm.sdk.b.b svVar = new sv();
        svVar.fLv.fLx = "2";
        svVar.frD = new Runnable() {
            public final void run() {
                if (!bi.oN(svVar.fLw.fLy)) {
                    e.a(WalletBalanceManagerUI.this.sFu, svVar.fLw.fLy, svVar.fLw.content, svVar.fLw.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(svVar);
    }

    public void onResume() {
        av();
        bKd();
        super.onResume();
        b bVar = (b) com.tencent.mm.kernel.g.h(b.class);
        bVar.a(this, bVar.bOm(), null);
    }

    public final void av() {
        boolean z;
        com.tencent.mm.plugin.wallet.a.p.bKx();
        this.sFY = com.tencent.mm.plugin.wallet.a.p.bKy().sFY;
        if (this.sFY != null) {
            if (this.sFY.sRo >= 0.0d) {
                this.sFT.setText(e.u(this.sFY.sRo));
            } else {
                this.sFT.setText(getString(i.uYw));
            }
            com.tencent.mm.plugin.wallet.a.p.bKx();
            if ((com.tencent.mm.plugin.wallet.a.p.bKy().bMC().sWf & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.plugin.wallet.a.p.bKy().bMC().sWf));
            int i = (!z || this.sFY.sRo <= 0.0d) ? 0 : 1;
            if (i != 0) {
                this.sFU.setVisibility(0);
            } else {
                this.sFU.setVisibility(8);
            }
            bKf();
        }
        View findViewById = findViewById(f.usR);
        com.tencent.mm.kernel.g.Dr();
        if (((Integer) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if ((new ae().sWf & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(new ae().sWf));
        if (z) {
            com.tencent.mm.kernel.g.Dr();
            String str = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_RELEAY_NAME_TIP_CONTENT_STRING_SYNC, getString(i.uTr));
            this.sFV.setVisibility(0);
            this.sFX.setTextColor(getResources().getColor(c.uhS));
            this.sFX.setText(str);
            this.sFW.setVisibility(8);
            this.sFV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                    Bundle bundle = new Bundle();
                    bundle.putInt("real_name_verify_mode", 0);
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
                    bundle.putInt("entry_scene", HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION);
                    com.tencent.mm.wallet_core.a.a(WalletBalanceManagerUI.this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                }
            });
            return;
        }
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (com.tencent.mm.plugin.wallet.a.p.bKy().bMI()) {
            this.sFV.setVisibility(0);
            this.sFV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                    Intent intent = new Intent(WalletBalanceManagerUI.this, WalletLqtDetailUI.class);
                    intent.putExtra("key_account_type", 1);
                    WalletBalanceManagerUI.this.startActivity(intent);
                }
            });
            TextView textView = this.sFX;
            com.tencent.mm.plugin.wallet.a.p.bKx();
            textView.setText(com.tencent.mm.plugin.wallet.a.p.bKy().bMF());
            this.sFW.setVisibility(0);
            return;
        }
        com.tencent.mm.plugin.wallet.a.p.bKx();
        final ag bKy = com.tencent.mm.plugin.wallet.a.p.bKy();
        if (bKy != null) {
            if ((bKy.bMC().sWf & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(bKy.bMC().sWf));
            if (!(!z || TextUtils.isEmpty(bKy.bMF()) || TextUtils.isEmpty(bKy.bMG()))) {
                this.sFV.setVisibility(0);
                this.sFX.setText(bKy.bMF());
                this.sFW.setVisibility(0);
                this.sFV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_LQT_LINK_RED_DOT_INT, Integer.valueOf(-1));
                        e.l(WalletBalanceManagerUI.this, bKy.bMG(), true);
                    }
                });
                return;
            }
        }
        this.sFV.setVisibility(8);
    }

    private void bKf() {
        String str;
        JSONObject jSONObject;
        Throwable e;
        this.mController.removeAllOptionMenu();
        JSONObject jSONObject2 = null;
        boolean z;
        try {
            str = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, (Object) "");
            if (bi.oN(str)) {
                z = false;
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(str);
                try {
                    z = jSONObject.optBoolean("is_show_menu", false);
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                }
            }
        } catch (JSONException e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
            z = false;
            jSONObject = jSONObject2;
            if (jSONObject == null) {
            }
            x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
            com.tencent.mm.plugin.wallet.a.p.bKx();
            com.tencent.mm.plugin.wallet.a.p.bKy();
            str = this.sFY.field_bindSerial;
            if (!bi.oN(this.sFY.sRr)) {
                a(getString(i.uVP), new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", WalletBalanceManagerUI.this.sFY.sRr);
                        intent.putExtra("showShare", false);
                        intent.putExtra("geta8key_username", q.FY());
                        intent.putExtra("KPublisherId", "pay_blance_list");
                        intent.putExtra("geta8key_scene", 33);
                        com.tencent.mm.bl.d.b(WalletBalanceManagerUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        e.HX(16);
                        return true;
                    }
                }, com.tencent.mm.ui.p.b.xSn);
            }
        }
        if (jSONObject == null && z) {
            x.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
            final List arrayList = new ArrayList();
            addIconOptionMenu(0, h.dvj, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(WalletBalanceManagerUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                        public final void a(n nVar) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("balance_menu_item");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                    if (optJSONObject != null) {
                                        a aVar = new a();
                                        aVar.title = optJSONObject.optString("title");
                                        aVar.sGd = optJSONObject.optInt("jump_type", 0);
                                        aVar.sGe = optJSONObject.optString("jump_h5_url");
                                        aVar.sGf = optJSONObject.optString("tinyapp_username");
                                        aVar.sGg = optJSONObject.optString("tinyapp_path");
                                        nVar.add(0, i, 0, aVar.title);
                                        arrayList.add(aVar);
                                    }
                                }
                            }
                        }
                    };
                    gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            a aVar = (a) arrayList.get(menuItem.getItemId());
                            if (aVar.sGd == 1) {
                                e.l(WalletBalanceManagerUI.this.mController.xRr, aVar.sGe, false);
                            } else if (aVar.sGd == 2) {
                                com.tencent.mm.sdk.b.b qrVar = new qr();
                                qrVar.fJd.userName = aVar.sGf;
                                qrVar.fJd.fJf = bi.aD(aVar.sGg, "");
                                qrVar.fJd.scene = 1061;
                                qrVar.fJd.fJg = 0;
                                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                            } else if (aVar.sGd == 7) {
                                Intent intent = new Intent();
                                com.tencent.mm.bl.d.y(WalletBalanceManagerUI.this.mController.xRr, "wallet_ecard", ".ui.WalletECardLogoutUI");
                            }
                        }
                    };
                    gVar.bUX();
                    return false;
                }
            });
            return;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
        com.tencent.mm.plugin.wallet.a.p.bKx();
        com.tencent.mm.plugin.wallet.a.p.bKy();
        str = this.sFY.field_bindSerial;
        if (!bi.oN(this.sFY.sRr)) {
            a(getString(i.uVP), /* anonymous class already generated */, com.tencent.mm.ui.p.b.xSn);
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && !(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (kVar instanceof y)) {
            av();
        }
        return false;
    }

    public final void sH(int i) {
        com.tencent.mm.plugin.wallet.a.p.bKx();
        this.sFY = com.tencent.mm.plugin.wallet.a.p.bKy().sFY;
        if (this.sFY != null) {
            if (this.sFY.sRo >= 0.0d) {
                this.sFT.setText(e.u(this.sFY.sRo));
            } else {
                this.sFT.setText(getString(i.uYw));
            }
            bKf();
        }
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == com.tencent.mm.plugin.wallet.balance.a.sEe) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
            e.HX(15);
        }
    }
}
