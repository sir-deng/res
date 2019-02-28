package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.a.sv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Date;

public class WalletBankcardManageUI extends WalletBaseUI {
    private ListView Fv = null;
    private OnItemClickListener SY = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i);
            e.HX(18);
            if (bankcard != null) {
                String str;
                a b = WalletBankcardManageUI.this.sIA;
                if (b.sHY != null && !b.sHY.isEmpty()) {
                    for (String str2 : b.sHY) {
                        if (str2.equals(bankcard.field_bindSerial)) {
                            x.d("MicroMsg.BankcardListAdapter", "remove new: %s", str2);
                            b.sHY.remove(str2);
                            g.Dr();
                            g.Dq().Db().a(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, bi.d(b.sHY, ","));
                            break;
                        }
                    }
                }
                if (bankcard.bLA()) {
                    Bundle bundle;
                    if (bankcard.field_wxcreditState == 0) {
                        if (b.a(bankcard) && bankcard != null) {
                            g.Dr();
                            str2 = (String) g.Dq().Db().get(196659, null);
                            StringBuilder stringBuilder = new StringBuilder();
                            if (TextUtils.isEmpty(str2)) {
                                stringBuilder.append(bankcard.field_bankcardType);
                            } else {
                                stringBuilder.append(str2);
                                stringBuilder.append("&");
                                stringBuilder.append(bankcard.field_bankcardType);
                            }
                            g.Dr();
                            g.Dq().Db().set(196659, stringBuilder.toString());
                        }
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        bundle.putString("key_bank_username", bankcard.field_bizUsername);
                        bundle.putString("key_bank_type", bankcard.field_bankcardType);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", bundle, null);
                    } else {
                        bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", bundle, null);
                    }
                } else if (bankcard.bLF()) {
                    x.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", bankcard.field_bindSerial);
                    d.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
                } else {
                    x.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf((o.bMc().bMC().sWf & Downloads.RECV_BUFFER_SIZE) > 0), Integer.valueOf(o.bMc().bMC().sWf));
                    if ((o.bMc().bMC().sWf & Downloads.RECV_BUFFER_SIZE) > 0) {
                        x.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                        g.Dr();
                        str2 = (String) g.Dq().Db().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
                        g.Dr();
                        long longValue = ((Long) g.Dq().Db().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(0))).longValue();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (bi.oN(str2) || currentTimeMillis - longValue >= 7200) {
                            x.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                            com.tencent.mm.sdk.b.a.xmy.b(new c<ac>() {
                                public final /* synthetic */ boolean a(b bVar) {
                                    com.tencent.mm.sdk.b.a.xmy.c(this);
                                    x.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                    WalletBankcardManageUI.this.b(bankcard);
                                    return true;
                                }
                            });
                        } else {
                            x.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                            WalletBankcardManageUI.this.b(bankcard);
                        }
                    } else {
                        WalletBankcardManageUI.this.c(bankcard);
                    }
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(1), bankcard.field_bankcardType);
                return;
            }
            WalletBankcardManageUI.this.bKr();
            com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(2));
        }
    };
    private OnClickListener iqi = new OnClickListener() {
        final int sIM = 1000;

        public final void onClick(View view) {
            Intent intent;
            if (view.getId() == f.uFl) {
                com.tencent.mm.plugin.wallet_core.model.g bLJ = com.tencent.mm.plugin.wallet_core.model.g.bLJ();
                if (bLJ.aHO()) {
                    h.b(WalletBankcardManageUI.this, bLJ.pfh, WalletBankcardManageUI.this.getString(i.dGZ), true);
                    return;
                }
                e.HX(19);
                WalletBankcardManageUI.this.bKr();
                com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(2));
            } else if (view.getId() == f.uFp) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", WalletBankcardManageUI.this.sII.field_loan_jump_url);
                    d.b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(WalletBankcardManageUI.this.sII.field_red_dot_index));
                    e.HX(6);
                }
            } else if (view.getId() == f.ulx) {
                intent = new Intent();
                intent.putExtra("rawUrl", "https://kf.qq.com/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                d.b(WalletBankcardManageUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(3));
            }
        }
    };
    private p osg = new p();
    private a sIA = null;
    private a sIB = null;
    private TextView sIC;
    private View sID;
    private View sIE;
    private View sIF;
    private CdnImageView sIG;
    private TextView sIH;
    private k sII;
    public ArrayList<Bankcard> sIw = new ArrayList();
    private ArrayList<Bankcard> sIx = new ArrayList();
    protected ag sIy = null;
    private ListView sIz = null;

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uLd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(4);
        x.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        com.tencent.mm.plugin.wallet.a.p.bKx();
        this.sIy = com.tencent.mm.plugin.wallet.a.p.bKy();
        setMMTitle(i.uYD);
        initView();
        com.tencent.mm.wallet_core.c.p.fw(5, 0);
        e.HX(27);
        this.sII = o.bMc().sWl;
        this.osg.tdo = new p.b() {
            public final int aYZ() {
                return 1;
            }

            public final Context getContext() {
                return WalletBankcardManageUI.this;
            }
        };
    }

    public void onResume() {
        if (this.sIy.bMx()) {
            jF(true);
        } else {
            this.sIy.d(this.sIw, this.sIx);
            if (this.sIy.sFY != null) {
                uV(0);
            }
            jF(false);
        }
        this.osg.onResume();
        av();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.osg.onPause();
    }

    public void jF(boolean z) {
        if (z) {
            r(new y(null, 12));
        } else {
            b(new y(null, 12), false);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.osg.aYX();
        } else {
            this.osg.cancel();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.sIA.sHX.destory();
        this.sIB.sHX.destory();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletBankcardManageUI.this.finish();
                com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(4));
                return true;
            }
        });
        this.sIC = (TextView) findViewById(f.uDV);
        this.sIC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletBankcardManageUI.this.bKr();
                e.HX(19);
                com.tencent.mm.plugin.report.service.g.pWK.h(14422, Integer.valueOf(2));
            }
        });
        this.Fv = (ListView) findViewById(f.ulO);
        this.sIA = bKq();
        this.Fv.setAdapter(this.sIA);
        this.Fv.setOnItemClickListener(this.SY);
        this.sIz = (ListView) findViewById(f.uDU);
        this.sIB = new a(this, this.sIx);
        this.sIz.setAdapter(this.sIB);
        this.sIz.setOnItemClickListener(this.SY);
        this.sID = findViewById(f.uFl);
        this.sID.setOnClickListener(this.iqi);
        this.sIE = findViewById(f.uFp);
        this.sIE.setOnClickListener(this.iqi);
        this.sIF = findViewById(f.uFn);
        this.sIG = (CdnImageView) findViewById(f.uFo);
        this.sIH = (TextView) findViewById(f.uFm);
        bKp();
        findViewById(f.ulx).setOnClickListener(this.iqi);
        final b svVar = new sv();
        svVar.fLv.fLx = "4";
        svVar.frD = new Runnable() {
            public final void run() {
                if (bi.oN(svVar.fLw.fLy)) {
                    x.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                } else {
                    e.a((TextView) WalletBankcardManageUI.this.findViewById(f.ulY), svVar.fLw.fLy, svVar.fLw.content, svVar.fLw.url);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(svVar);
    }

    private void bKp() {
        g.Dr();
        final com.tencent.mm.plugin.wallet_core.model.f Nv = com.tencent.mm.plugin.wallet_core.model.f.Nv((String) g.Dq().Db().get(a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, (Object) ""));
        if (!(Nv == null || bi.oN(Nv.sRN))) {
            if (!bi.oN(Nv.sRO)) {
                this.sIG.setUrl(Nv.sRO);
            }
            this.sIH.setText(Nv.sRN);
            if (Nv.sRJ == 1) {
                this.sIF.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (!bi.oN(Nv.sRK)) {
                            e.l(WalletBankcardManageUI.this.mController.xRr, Nv.sRK, false);
                        }
                    }
                });
                this.sIF.setVisibility(0);
                return;
            } else if (Nv.sRJ == 2) {
                this.sIF.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        b qrVar = new qr();
                        qrVar.fJd.userName = Nv.sRL;
                        qrVar.fJd.fJf = bi.aD(Nv.sRM, "");
                        qrVar.fJd.scene = 1071;
                        qrVar.fJd.fJg = 0;
                        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                    }
                });
                this.sIF.setVisibility(0);
                return;
            } else {
                x.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(Nv.sRJ));
            }
        }
        this.sIF.setVisibility(8);
    }

    public a bKq() {
        return new a(this, this.sIw);
    }

    public final void b(Bankcard bankcard) {
        g.Dr();
        String str = (String) g.Dq().Db().get(a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, (Object) "");
        if (bi.oN(str)) {
            x.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
            return;
        }
        x.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
        Intent intent = new Intent();
        String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", new Object[]{bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial});
        if (str.contains("?")) {
            str = str + "&" + format;
        } else {
            str = str + "?" + format;
        }
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("disable_bounce_scroll", true);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void c(Bankcard bankcard) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, null);
    }

    private void av() {
        if (this.sIy.bMx()) {
            this.sIC.setEnabled(false);
        } else {
            this.sIy.bMv();
            this.sIC.setEnabled(true);
        }
        if (this.sIw == null || this.sIw.size() <= 0) {
            this.Fv.setVisibility(8);
        } else {
            this.Fv.setVisibility(0);
        }
        if (this.sIx == null || this.sIx.size() <= 0) {
            this.sIz.setVisibility(8);
        } else {
            this.sIz.setVisibility(0);
        }
        if (this.sII == null || this.sII.field_is_show_entry != 1) {
            this.sIE.setVisibility(8);
        } else {
            boolean z;
            ((TextView) this.sIE.findViewById(f.uFr)).setText(this.sII.field_title);
            k kVar = this.sII;
            TextView textView = (TextView) findViewById(f.uFz);
            int i = kVar.field_red_dot_index;
            g.Dr();
            if (((Integer) g.Dq().Db().get(a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(-1))).intValue() >= i || i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                x.i("MicroMsg.WalletBankcardManageUI", "red point update");
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            textView = (TextView) findViewById(f.uFq);
            if (kVar.field_is_overdue == 1) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
                textView.setText(i.uWq);
                textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btC));
            } else if (!bi.oN(kVar.field_tips)) {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
                textView.setText(kVar.field_tips);
            } else if (bi.oN(kVar.field_available_otb)) {
                textView.setVisibility(8);
                this.sIE.setVisibility(0);
            } else {
                x.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
                i = kVar.field_available_otb.indexOf(".");
                String str = kVar.field_available_otb;
                if (i > 0) {
                    str = str.substring(0, i);
                }
                textView.setText(getString(i.uWp, new Object[]{str}));
            }
            textView.setVisibility(0);
            this.sIE.setVisibility(0);
        }
        this.sIA.R(this.sIw);
        this.sIA.notifyDataSetChanged();
        this.sIB.R(this.sIx);
        this.sIB.notifyDataSetChanged();
        this.sIC.setEnabled(true);
    }

    public void bKr() {
        final Bundle bundle = new Bundle();
        final Runnable anonymousClass10 = new Runnable() {
            public final void run() {
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
            }
        };
        this.osg.a(new p.a() {
            public final void aYX() {
                anonymousClass10.run();
            }

            public final void cancel() {
                WalletBankcardManageUI.this.osg.fpU = false;
            }

            public final void aYY() {
                anonymousClass10.run();
            }
        }, new ae().bMu());
    }

    public final void bKs() {
        uV(0);
        this.sIy.d(this.sIw, this.sIx);
        av();
        bKp();
    }

    public boolean d(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i != 0 || i2 != 0 || !(kVar instanceof y)) {
            return false;
        }
        this.sII = o.bMc().sWl;
        bKs();
        return true;
    }

    public final boolean aYP() {
        return false;
    }

    public void finish() {
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            d.b(this, "mall", ".ui.MallIndexUI", intent);
        }
        super.finish();
    }
}
