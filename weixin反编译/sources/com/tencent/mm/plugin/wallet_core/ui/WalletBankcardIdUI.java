package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.f.a.su;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private int itU = -1;
    c sIU = new c<su>() {
        {
            this.xmG = su.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            WalletBankcardIdUI.this.finish();
            return false;
        }
    };
    private Button sIX;
    c sNf = new c<oj>() {
        {
            this.xmG = oj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oj ojVar = (oj) bVar;
            if (ojVar instanceof oj) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletBankcardIdUI.a(WalletBankcardIdUI.this, encrypt.desedeEncode(ojVar.fHc.cardId, randomKey), randomKey, ojVar.fHc.fHd);
                WalletBankcardIdUI.this.finish();
                return true;
            }
            x.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };
    protected WalletFormView sXr;
    protected WalletFormView sXs;
    private Bankcard sXt;
    private a sXu;
    private boolean sXv = false;
    private boolean sXw;

    private static class a extends BaseAdapter {
        private LayoutInflater DF = null;
        private Context mContext = null;
        List<q> sXy = new LinkedList();

        class a {
            TextView pNs;
            TextView sXA;
            TextView sXB;
            ImageView sXz;

            a() {
            }
        }

        public a(Context context, List<q> list) {
            this.DF = LayoutInflater.from(context);
            this.sXy = list;
            this.mContext = context;
        }

        public final int getCount() {
            if (this.sXy == null) {
                return 0;
            }
            return this.sXy.size();
        }

        public final Object getItem(int i) {
            return this.sXy.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.DF.inflate(g.uLh, viewGroup, false);
                aVar = new a();
                aVar.sXz = (ImageView) view.findViewById(f.uED);
                aVar.pNs = (TextView) view.findViewById(f.uEC);
                aVar.sXA = (TextView) view.findViewById(f.uEF);
                aVar.sXB = (TextView) view.findViewById(f.uEE);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            q qVar = (q) getItem(i);
            if (bi.oN(qVar.pgd)) {
                aVar.pNs.setVisibility(8);
            } else {
                aVar.pNs.setText(qVar.pgd);
                aVar.pNs.setVisibility(0);
            }
            if (bi.oN(qVar.sKh)) {
                aVar.sXA.setVisibility(8);
            } else {
                aVar.sXA.setText(qVar.sKh);
                aVar.sXA.setVisibility(0);
            }
            if (bi.oN(qVar.sJp)) {
                aVar.sXB.setVisibility(8);
            } else {
                aVar.sXB.setText(qVar.sJp);
                aVar.sXB.setVisibility(0);
            }
            String str = qVar.sKn;
            x.v("Micromsg.WalletInputCardIDUI", "bankType:" + qVar.sKm + ", logurl:" + str);
            aVar.sXz.setImageBitmap(null);
            if (!bi.oN(str)) {
                com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
                o.PH();
                aVar2.hFH = null;
                aVar2.hFo = e.bnF;
                aVar2.hFn = com.tencent.mm.plugin.wallet_core.d.b.HZ(str);
                aVar2.hFl = true;
                aVar2.hFI = true;
                o.PG().a(str, aVar.sXz, aVar2.PQ());
            }
            return view;
        }
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.mController.xRr.getSystemService("layout_inflater");
        View view = (TextView) layoutInflater.inflate(g.uIB, null);
        view.setText(walletBankcardIdUI.getString(i.uXf));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(d.bvw);
        view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(walletBankcardIdUI.mController.xRr, walletBankcardIdUI.getString(i.uXe), walletBankcardIdUI.getString(i.uYs), view, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletBankcardIdUI);
        if (ag != null) {
            ag.c(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
    }

    protected final int getLayoutId() {
        return g.uLb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uYM);
        initView();
        com.tencent.mm.sdk.b.a.xmy.b(this.sIU);
        com.tencent.mm.sdk.b.a.xmy.b(this.sNf);
        this.itU = this.vf.getInt("key_bind_scene");
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sIU);
        com.tencent.mm.sdk.b.a.xmy.c(this.sNf);
        super.onDestroy();
    }

    protected final void initView() {
        this.sIX = (Button) findViewById(f.cAl);
        this.sXr = (WalletFormView) findViewById(f.unU);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sXr);
        this.sXs = (WalletFormView) findViewById(f.uyk);
        if (this.vf.getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.sXs);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sXs);
        }
        this.sXr.zST = this;
        this.sIX.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(1), Integer.valueOf(0));
                WalletBankcardIdUI.this.bLk();
            }
        });
        com.tencent.mm.wallet_core.c cCT = cCT();
        if (cCT != null) {
            this.sXw = cCT.mym.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.sXw = false;
        }
        if (this.sXw) {
            setMMTitle(i.vce);
        } else {
            setMMTitle(i.uYM);
        }
        TextView textView = (TextView) findViewById(f.urA);
        if (com.tencent.mm.plugin.wallet_core.model.o.bMc().bMv() || com.tencent.mm.plugin.wallet_core.model.o.bMc().bMz()) {
            g gVar = new g(this);
            gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                public final void onClick(View view) {
                    x.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
                    WalletBankcardIdUI.a(WalletBankcardIdUI.this);
                }
            };
            String string = getString(i.uYK);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            CharSequence string2 = this.vf.getString("key_custom_bind_tips");
            if (!bi.oN(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.vf.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.vf.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            a a = b.sXj.a(orders);
            TextView textView2 = (TextView) findViewById(f.uEQ);
            if (a != null) {
                List NM = a.NM(a.NP(favorPayInfo.sTc));
                if (NM.size() > 0) {
                    this.sXu = new a(this.mController.xRr, NM);
                    textView2.setText(i.uYI);
                    textView2.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            WalletBankcardIdUI.this.showDialog(1);
                        }
                    });
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                x.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        ag bMc = com.tencent.mm.plugin.wallet_core.model.o.bMc();
        if (!bMc.bMy() || bMc.azW() == null || bi.oN(bMc.azW().trim()) || !bMc.bMD()) {
            this.sXs.setVisibility(8);
            this.sXr.setHint(getString(i.uYL));
        } else {
            this.sXs.setVisibility(0);
            this.sXs.setText(bMc.azW());
            this.sXr.setHint(getString(i.uXc));
            this.sXs.setClickable(false);
            this.sXs.setEnabled(false);
        }
        com.tencent.mm.kernel.g.Dr();
        String str = (String) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, null);
        if (!bi.oN(str)) {
            this.sXr.setHint(str);
        }
        this.sXt = (Bankcard) this.vf.getParcelable("key_history_bankcard");
        if (this.sXt != null) {
            this.sXr.setText(this.sXt.sRk);
            this.sXr.a(new TextWatcher() {
                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (WalletBankcardIdUI.this.sXr.XX() && !WalletBankcardIdUI.this.sXv) {
                        WalletBankcardIdUI.this.sXv = true;
                        WalletBankcardIdUI.this.sXr.bnq();
                    }
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        XT();
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.vf, 2);
        e(this.sXr, 0, false);
        this.sXr.q(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(2), Integer.valueOf(0));
                com.tencent.mm.wallet_core.ui.e.e(WalletBankcardIdUI.this, com.tencent.mm.plugin.wallet_core.model.o.bMc().azW());
            }
        });
        if (com.tencent.mm.plugin.wallet_core.model.o.bMc().bMC().bMq()) {
            this.sXr.pJR.setVisibility(0);
            this.sXr.pJR.setImageResource(com.tencent.mm.plugin.wxpay.a.h.uNn);
        }
    }

    protected final void bLk() {
        if (cCT() == null) {
            x.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            return;
        }
        String string = cCT().mym.getString("kreq_token");
        int i = this.vf.getInt("entry_scene", -1);
        if (this.sXt != null) {
            k tVar = new t(bKA(), null, (PayInfo) this.vf.getParcelable("key_pay_info"), string, this.itU, i);
            tVar.pOY = this.sXt.field_bankcardType;
            this.vf.putParcelable("key_history_bankcard", this.sXt);
            l(tVar);
        } else if (XT()) {
            l(new t(bKA(), this.sXr.getText(), (PayInfo) this.vf.getParcelable("key_pay_info"), string, this.itU, i));
        } else {
            h.h(this, i.uZF, i.dGZ);
        }
    }

    protected Dialog onCreateDialog(int i) {
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(g.uLF, null);
            ((ListViewInScrollView) inflate.findViewById(f.bJf)).setAdapter(this.sXu);
            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
            aVar.ES(i.uYH);
            aVar.dk(inflate);
            aVar.d(null);
            aVar.EV(i.uYs);
            return aVar.ale();
        } else if (!this.sXw || i != 1000) {
            return super.onCreateDialog(i);
        } else {
            int b;
            String string = getString(i.uYJ);
            com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
            if (ag != null) {
                b = ag.b((MMActivity) this, 1);
            } else {
                b = -1;
            }
            if (b != -1) {
                string = getString(b);
            }
            return h.a((Context) this, true, string, "", getString(i.dHo), getString(i.dGc), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((com.tencent.mm.plugin.wallet_core.id_verify.a) WalletBankcardIdUI.this.cCT()).d(WalletBankcardIdUI.this, 0);
                    WalletBankcardIdUI.this.finish();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    View findFocus = WalletBankcardIdUI.this.mController.contentView == null ? null : WalletBankcardIdUI.this.mController.contentView.findFocus();
                    if (findFocus != null && (findFocus instanceof EditText)) {
                        WalletBankcardIdUI.this.showVKB();
                    }
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                bundle.putBoolean("key_need_area", tVar.bLu());
                bundle.putBoolean("key_need_profession", tVar.bLv());
                bundle.putParcelableArray("key_profession_list", tVar.sOW);
                if (tVar.sOS == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sXr.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.sOS.sSG && tVar.sOS.isError()) {
                    h.h(this, i.uWg, i.dGZ);
                    return true;
                } else {
                    bundle.putString("bank_name", tVar.sOS.nHt);
                    bundle.putParcelable("elemt_query", tVar.sOS);
                    bundle.putString("key_card_id", this.sXr.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                    return true;
                }
            }
        } else if (i2 == 1 && (kVar instanceof t)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.sXr.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            return true;
        }
        return false;
    }

    private boolean XT() {
        if (this.sXr.dQ(null)) {
            this.sIX.setEnabled(true);
            this.sIX.setClickable(true);
            return true;
        }
        this.sIX.setEnabled(false);
        this.sIX.setClickable(false);
        return false;
    }

    public final void hB(boolean z) {
        if (!z) {
            this.sXt = null;
            this.vf.putParcelable("key_history_bankcard", null);
        }
        XT();
    }

    protected final boolean bKK() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
