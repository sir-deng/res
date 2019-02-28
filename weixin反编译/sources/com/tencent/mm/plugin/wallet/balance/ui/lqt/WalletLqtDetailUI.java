package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet.balance.a.a.j;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bar;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private ag handler = new ag(Looper.getMainLooper());
    private Dialog ikw;
    private TextView sGA;
    private TextView sGB;
    private TextView sGC;
    private WalletTextView sGD;
    private Button sGE;
    private Button sGF;
    private LinearLayout sGG;
    private TextView sGH;
    private View sGI;
    private TextView sGJ;
    private View sGK;
    private View sGL;
    private CdnImageView sGM;
    private TextView sGN;
    private TextView sGO;
    private boolean sGP = true;
    private j sGu = ((j) t(j.class));
    private k sGv = ((k) q(k.class));
    private bar sGw;
    private ViewGroup sGx;
    private TextView sGy;
    private WalletTextView sGz;

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        if (walletLqtDetailUI.sGw != null) {
            walletLqtDetailUI.sGz.setText(e.t(((double) walletLqtDetailUI.sGw.bMF) / 100.0d));
            walletLqtDetailUI.sGA.setText(walletLqtDetailUI.sGw.wOd);
            walletLqtDetailUI.sGB.setText(walletLqtDetailUI.sGw.wOe);
            walletLqtDetailUI.sGC.setText(walletLqtDetailUI.sGw.wOf);
            walletLqtDetailUI.sGD.setText(e.t(((double) walletLqtDetailUI.sGw.wOg) / 100.0d));
            walletLqtDetailUI.sGG.removeAllViews();
            if (walletLqtDetailUI.sGw.wOh != null && walletLqtDetailUI.sGw.wOh.size() > 0) {
                Iterator it = walletLqtDetailUI.sGw.wOh.iterator();
                while (it.hasNext()) {
                    ro roVar = (ro) it.next();
                    final LinearLayout linearLayout = (LinearLayout) walletLqtDetailUI.getLayoutInflater().inflate(g.usD, walletLqtDetailUI.sGG, false);
                    TextView textView = (TextView) linearLayout.findViewById(f.usC);
                    ((TextView) linearLayout.findViewById(f.usE)).setText(roVar.title);
                    textView.setText(roVar.desc);
                    if (!bi.oN(roVar.wgp)) {
                        linearLayout.setTag(roVar.wgp);
                        linearLayout.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                e.l(WalletLqtDetailUI.this, (String) linearLayout.getTag(), false);
                            }
                        });
                    }
                    walletLqtDetailUI.sGG.addView(linearLayout, new LayoutParams(-1, -2, -1.0f));
                }
            }
            walletLqtDetailUI.sGx.setVisibility(0);
            if (walletLqtDetailUI.sGw.bMF <= 0) {
                walletLqtDetailUI.sGF.setEnabled(false);
            } else {
                walletLqtDetailUI.sGF.setEnabled(true);
            }
            if (b.cfx()) {
                walletLqtDetailUI.sGF.setEnabled(true);
            }
            if (walletLqtDetailUI.sGw.wOk != null) {
                walletLqtDetailUI.sGH.setText(walletLqtDetailUI.sGw.wOk.title);
                walletLqtDetailUI.sGH.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        e.l(WalletLqtDetailUI.this, WalletLqtDetailUI.this.sGw.wOk.wgp, false);
                    }
                });
            }
            walletLqtDetailUI.sGI.setVisibility(8);
            if (!(walletLqtDetailUI.sGw.wOm == null || bi.oN(walletLqtDetailUI.sGw.wOm.title))) {
                walletLqtDetailUI.sGI.setVisibility(0);
                walletLqtDetailUI.sGJ.setText(walletLqtDetailUI.sGw.wOm.title);
                if (!bi.oN(walletLqtDetailUI.sGw.wOm.wgp)) {
                    walletLqtDetailUI.sGI.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            e.l(WalletLqtDetailUI.this, WalletLqtDetailUI.this.sGw.wOm.wgp, false);
                        }
                    });
                }
            }
            walletLqtDetailUI.sGL.setVisibility(8);
            walletLqtDetailUI.sGK.setVisibility(8);
            if (!(walletLqtDetailUI.sGw.wOn == null || bi.oN(walletLqtDetailUI.sGw.wOn.username))) {
                walletLqtDetailUI.sGM.setUrl(walletLqtDetailUI.sGw.wOn.kPA);
                walletLqtDetailUI.sGN.setText(walletLqtDetailUI.sGw.wOn.title);
                walletLqtDetailUI.sGO.setText(walletLqtDetailUI.sGw.wOn.desc);
                walletLqtDetailUI.sGL.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        com.tencent.mm.sdk.b.b qrVar = new qr();
                        qrVar.fJd.userName = WalletLqtDetailUI.this.sGw.wOn.username;
                        qrVar.fJd.fJf = bi.aD(WalletLqtDetailUI.this.sGw.wOn.path, "");
                        qrVar.fJd.scene = 1061;
                        qrVar.fJd.fJg = 0;
                        a.xmy.m(qrVar);
                    }
                });
                walletLqtDetailUI.sGK.setVisibility(0);
                walletLqtDetailUI.sGL.setVisibility(0);
            }
            walletLqtDetailUI.sGH.setVisibility(4);
            walletLqtDetailUI.sGH.post(new Runnable() {
                public final void run() {
                    LayoutParams layoutParams = (LayoutParams) WalletLqtDetailUI.this.sGH.getLayoutParams();
                    layoutParams.topMargin = Math.max(((WalletLqtDetailUI.this.findViewById(f.usK).getHeight() - WalletLqtDetailUI.this.findViewById(f.usJ).getBottom()) - com.tencent.mm.bu.a.fromDPToPix(WalletLqtDetailUI.this, 20)) - com.tencent.mm.bu.a.fromDPToPix(WalletLqtDetailUI.this, 20), com.tencent.mm.bu.a.fromDPToPix(WalletLqtDetailUI.this, 50));
                    layoutParams.bottomMargin = com.tencent.mm.bu.a.fromDPToPix(WalletLqtDetailUI.this, 20);
                    WalletLqtDetailUI.this.sGH.setLayoutParams(layoutParams);
                    WalletLqtDetailUI.this.sGH.setVisibility(0);
                }
            });
            walletLqtDetailUI.sGE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    String str = null;
                    boolean z = true;
                    Intent intent;
                    String str2;
                    if (r.igJ) {
                        intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                        str2 = "lqt_save_fund_code";
                        if (WalletLqtDetailUI.this.sGw != null) {
                            str = WalletLqtDetailUI.this.sGw.wNw;
                        }
                        intent.putExtra(str2, str);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.this.sGw.fLQ == 1);
                        str = "lqt_is_agree_protocol";
                        if (WalletLqtDetailUI.this.sGw.wOi != 1) {
                            z = false;
                        }
                        intent.putExtra(str, z);
                        intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(WalletLqtDetailUI.this));
                        intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.this.sGw.wOc);
                        WalletLqtDetailUI.this.startActivity(intent);
                        return;
                    }
                    com.tencent.mm.vending.g.g.cq(Integer.valueOf(WalletLqtDetailUI.this.sGw.wer)).b(WalletLqtDetailUI.this.sGv.sEF);
                    if (bi.oN(WalletLqtDetailUI.this.sGw.wOo)) {
                        intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                        str2 = "lqt_save_fund_code";
                        if (WalletLqtDetailUI.this.sGw != null) {
                            str = WalletLqtDetailUI.this.sGw.wNw;
                        }
                        intent.putExtra(str2, str);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        intent.putExtra("lqt_is_show_protocol", WalletLqtDetailUI.this.sGw.fLQ == 1);
                        str = "lqt_is_agree_protocol";
                        if (WalletLqtDetailUI.this.sGw.wOi != 1) {
                            z = false;
                        }
                        intent.putExtra(str, z);
                        intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(WalletLqtDetailUI.this));
                        intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.this.sGw.wOc);
                        intent.putExtra("lqt_account_type", WalletLqtDetailUI.this.sGw.wer);
                        WalletLqtDetailUI.this.startActivity(intent);
                        return;
                    }
                    x.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", WalletLqtDetailUI.this.sGw.wOo);
                    e.l(WalletLqtDetailUI.this, WalletLqtDetailUI.this.sGw.wOo, false);
                }
            });
            walletLqtDetailUI.sGF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.vending.g.g.cq(Integer.valueOf(WalletLqtDetailUI.this.sGw.wer)).b(WalletLqtDetailUI.this.sGv.sEE);
                    Intent intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                    intent.putExtra("lqt_save_fetch_mode", 2);
                    intent.putExtra("lqt_balance", WalletLqtDetailUI.this.sGw.bMF);
                    intent.putExtra("lqt_max_redeem_amount", WalletLqtDetailUI.this.sGw.wOp);
                    intent.putExtra("lqt_redeem_invalid_amount_hint", WalletLqtDetailUI.this.sGw.wOq);
                    intent.putExtra("lqt_account_type", WalletLqtDetailUI.this.sGw.wer);
                    WalletLqtDetailUI.this.startActivity(intent);
                }
            });
        }
        walletLqtDetailUI.mController.removeAllOptionMenu();
        if (walletLqtDetailUI.sGw != null) {
            walletLqtDetailUI.addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(WalletLqtDetailUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new c() {
                        public final void a(n nVar) {
                            if (WalletLqtDetailUI.this.sGw.wOl != null && WalletLqtDetailUI.this.sGw.wOl.size() > 0) {
                                Iterator it = WalletLqtDetailUI.this.sGw.wOl.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    ro roVar = (ro) it.next();
                                    if (!(bi.oN(roVar.title) || bi.oN(roVar.wgp))) {
                                        nVar.add(0, i, 0, roVar.title);
                                    }
                                    i++;
                                }
                            }
                            if (!WalletLqtDetailUI.this.sGw.wOs) {
                                nVar.add(0, -1, 0, i.uYT);
                            }
                        }
                    };
                    gVar.rQG = new d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == -1 && !WalletLqtDetailUI.this.sGw.wOs) {
                                h.a(WalletLqtDetailUI.this, WalletLqtDetailUI.this.getString(i.uYV), "", WalletLqtDetailUI.this.getString(i.bWm), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        WalletLqtDetailUI.this.sGP = false;
                                        WalletLqtDetailUI.this.startActivityForResult(new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class), 123);
                                    }
                                });
                            } else if (WalletLqtDetailUI.this.sGw.wOl != null && WalletLqtDetailUI.this.sGw.wOl.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.this.sGw.wOl.size()) {
                                e.l(WalletLqtDetailUI.this, ((ro) WalletLqtDetailUI.this.sGw.wOl.get(menuItem.getItemId())).wgp, false);
                            }
                        }
                    };
                    gVar.bUX();
                    return false;
                }
            });
        }
    }

    static /* synthetic */ ArrayList e(WalletLqtDetailUI walletLqtDetailUI) {
        ArrayList arrayList = new ArrayList();
        if (walletLqtDetailUI.sGw.wOj != null && walletLqtDetailUI.sGw.wOj.size() > 0) {
            Iterator it = walletLqtDetailUI.sGw.wOj.iterator();
            while (it.hasNext()) {
                ro roVar = (ro) it.next();
                if (!(bi.oN(roVar.title) || bi.oN(roVar.wgp))) {
                    arrayList.add(String.format("%s||%s", new Object[]{roVar.title, roVar.wgp}));
                }
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.c.uhZ));
        }
        if (com.tencent.mm.compatible.util.d.fN(21)) {
            getWindow().setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhZ));
        }
        setMMTitle(getString(i.uZD));
        int intExtra = getIntent().getIntExtra("key_account_type", 1);
        x.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", Integer.valueOf(intExtra));
        this.sGx = (ViewGroup) findViewById(f.upJ);
        this.sGy = (TextView) findViewById(f.usO);
        this.sGz = (WalletTextView) findViewById(f.usx);
        this.sGA = (TextView) findViewById(f.usy);
        this.sGB = (TextView) findViewById(f.usz);
        this.sGC = (TextView) findViewById(f.usH);
        this.sGD = (WalletTextView) findViewById(f.usI);
        this.sGE = (Button) findViewById(f.usL);
        this.sGF = (Button) findViewById(f.usG);
        this.sGG = (LinearLayout) findViewById(f.usD);
        this.sGH = (TextView) findViewById(f.usF);
        this.sGI = findViewById(f.usA);
        this.sGJ = (TextView) findViewById(f.usB);
        this.sGL = findViewById(f.usN);
        this.sGM = (CdnImageView) findViewById(f.uDt);
        this.sGN = (TextView) findViewById(f.uDu);
        this.sGO = (TextView) findViewById(f.uDs);
        this.sGK = findViewById(f.usM);
        this.sGH.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        if (this.sGP) {
            this.sGx.setVisibility(8);
            this.ikw = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.cAN().b(this.sGv.sEC).e(new com.tencent.mm.vending.c.a<Void, bar>() {
                public final /* synthetic */ Object call(Object obj) {
                    bar bar = (bar) obj;
                    if (bar != null) {
                        x.i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(bar.wer), Boolean.valueOf(bar.wOs));
                        WalletLqtDetailUI.this.sGw = bar;
                        WalletLqtDetailUI.b(WalletLqtDetailUI.this);
                    } else {
                        x.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
                    }
                    if (WalletLqtDetailUI.this.ikw != null) {
                        WalletLqtDetailUI.this.ikw.dismiss();
                    }
                    return zLb;
                }
            }).a(new com.tencent.mm.vending.g.d.a() {
                public final void aW(Object obj) {
                    if (WalletLqtDetailUI.this.ikw != null) {
                        WalletLqtDetailUI.this.ikw.dismiss();
                    }
                    x.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", obj);
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = WalletLqtDetailUI.this.getString(i.uZq);
                        }
                        Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
                    }
                }
            });
        }
        this.sGP = true;
    }

    protected final int getLayoutId() {
        return g.uLH;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.sGP = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.ikw == null) {
                this.ikw = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            } else {
                this.ikw.show();
            }
            com.tencent.mm.vending.g.g.t(stringExtra, Integer.valueOf(this.sGw.wer)).b(this.sGv.sED).e(new com.tencent.mm.vending.c.a<Void, or>() {
                public final /* synthetic */ Object call(Object obj) {
                    WalletLqtDetailUI.this.handler.postDelayed(new Runnable() {
                        public final void run() {
                            if (WalletLqtDetailUI.this.ikw != null) {
                                WalletLqtDetailUI.this.ikw.dismiss();
                            }
                            Toast.makeText(WalletLqtDetailUI.this, WalletLqtDetailUI.this.getString(i.uYU), 1).show();
                            WalletLqtDetailUI.this.finish();
                        }
                    }, 1000);
                    return zLb;
                }
            }).a(new com.tencent.mm.vending.g.d.a() {
                public final void aW(Object obj) {
                    if (WalletLqtDetailUI.this.ikw != null) {
                        WalletLqtDetailUI.this.ikw.dismiss();
                    }
                    x.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", obj);
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = WalletLqtDetailUI.this.getString(i.uZq);
                        }
                        Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.sGu = null;
        this.sGv = null;
    }
}
