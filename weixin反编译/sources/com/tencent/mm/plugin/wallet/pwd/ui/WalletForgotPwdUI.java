package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.f.a.su;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private ListView ipH;
    private LinearLayout jTf;
    c sIU = new c<su>() {
        {
            this.xmG = su.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            WalletForgotPwdUI.this.finish();
            return false;
        }
    };
    private Button sIX;
    private ArrayList<Bankcard> sIw = new ArrayList();
    private List<ElementQuery> sMY = new LinkedList();
    private Bankcard sMZ;
    private a sNa;
    private WalletFormView sNb;
    private WalletFormView sNc;
    private int sNd = 1;
    private boolean sNe = false;
    c sNf = new c<oj>() {
        {
            this.xmG = oj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oj ojVar = (oj) bVar;
            if (ojVar instanceof oj) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletForgotPwdUI.a(WalletForgotPwdUI.this, encrypt.desedeEncode(ojVar.fHc.cardId, randomKey), randomKey, ojVar.fHc.fHd);
                return true;
            }
            x.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
            return false;
        }
    };

    public class a extends BaseAdapter {
        private Context context;
        List<Bankcard> hkf = new ArrayList();

        public final /* synthetic */ Object getItem(int i) {
            return zt(i);
        }

        public a(Context context) {
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = (WalletFormView) View.inflate(this.context, g.uKW, null);
            } else {
                WalletFormView walletFormView = (WalletFormView) view;
            }
            final Bankcard zt = zt(i);
            if (zt != null) {
                view.setText(((Bankcard) this.hkf.get(i)).field_desc);
            }
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WalletForgotPwdUI.this.sMZ = zt;
                    WalletForgotPwdUI.this.sNe = false;
                    WalletForgotPwdUI.this.bLk();
                }
            });
            return view;
        }

        public final int getCount() {
            return this.hkf.size();
        }

        private Bankcard zt(int i) {
            if (i < 0 || i > this.hkf.size() - 1) {
                return null;
            }
            return (Bankcard) this.hkf.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(walletForgotPwdUI);
        if (ag != null) {
            ag.a((Activity) walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        if (!"1".equals(o.bLY().bMZ().field_reset_passwd_flag)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
        } else if (bi.oN(o.bLY().bMZ().field_find_passwd_url)) {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(f.urj)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(f.umk)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    WalletForgotPwdUI.this.sNe = true;
                    WalletForgotPwdUI.this.bLk();
                }
            });
        } else {
            x.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(f.urk)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(f.urm);
            com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(walletForgotPwdUI);
            gVar.sZF = new com.tencent.mm.plugin.wallet_core.ui.g.a() {
                public final void onClick(View view) {
                    WalletForgotPwdUI.this.sNe = true;
                    WalletForgotPwdUI.this.bLk();
                }
            };
            String string = walletForgotPwdUI.getString(i.vav);
            CharSequence spannableString = new SpannableString(string);
            spannableString.setSpan(gVar, string.length() - 12, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.vaL);
        if (!this.vf.getBoolean("key_is_force_bind", false)) {
            l(new y(null, 6));
            uV(4);
        }
        initView();
        com.tencent.mm.sdk.b.a.xmy.b(this.sNf);
        com.tencent.mm.sdk.b.a.xmy.b(this.sIU);
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sNf);
        com.tencent.mm.sdk.b.a.xmy.c(this.sIU);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        update();
    }

    private void update() {
        p.bKx();
        this.sIw = p.bKy().bMJ();
        if (this.sIw == null || this.sIw.size() == 0 || this.vf.getBoolean("key_is_force_bind", false)) {
            x.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", Boolean.valueOf(this.vf.getBoolean("key_is_force_bind", false)));
            this.sIw = new ArrayList();
            this.jTf.setVisibility(0);
            this.ipH.setVisibility(8);
            setMMTitle(i.uXW);
            ((TextView) findViewById(f.uFv)).setText(getString(i.vax));
            WalletFormView walletFormView = this.sNc;
            p.bKx();
            walletFormView.setText(e.abm(p.bKy().azW()));
            return;
        }
        x.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.ag(this) != null) {
            r(new t());
        }
        this.jTf.setVisibility(8);
        this.sIX.setVisibility(8);
        findViewById(f.uyg).setVisibility(0);
        this.sNa = new a(this);
        this.ipH.setAdapter(this.sNa);
        this.sNa.hkf = this.sIw;
        this.sNa.notifyDataSetChanged();
    }

    public void initView() {
        this.ipH = (ListView) findViewById(f.uCU);
        this.jTf = (LinearLayout) findViewById(f.urh);
        this.sNc = (WalletFormView) findViewById(f.uyk);
        this.sNb = (WalletFormView) findViewById(f.unS);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sNb);
        if (this.vf.getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.sNc);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.sNc);
        }
        this.sNc.zST = this;
        this.sNb.zST = this;
        this.sIX = (Button) findViewById(f.cAl);
        this.sIX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(1), Integer.valueOf(0));
                WalletForgotPwdUI.this.bLk();
            }
        });
        this.sNe = false;
        p.bKx();
        this.sIw = p.bKy().bMJ();
        update();
        findViewById(f.uyg).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.l(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
            }
        });
        XT();
        a(this.sNb, 0, false, false);
        this.sNb.q(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11353, Integer.valueOf(2), Integer.valueOf(0));
                MMActivity mMActivity = WalletForgotPwdUI.this;
                p.bKx();
                e.e(mMActivity, p.bKy().azW());
            }
        });
        this.sNb.pJR.setImageResource(h.uNn);
        this.sNb.pJR.setVisibility(0);
    }

    private void bLj() {
        this.vf.remove("elemt_query");
        this.vf.remove("key_bankcard");
        this.vf.remove("bank_name");
        this.vf.remove("key_card_id");
    }

    private void bLk() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.vf.getBoolean("key_is_reset_with_new_card", false));
        bLj();
        if (this.sMZ == null && !this.sNe) {
            l(new t(null, this.sNb.getText(), null));
        } else if (this.sNe) {
            af bMZ = o.bLY().bMZ();
            if (bi.oN(bMZ.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (cCT() != null) {
                    cCT().a((Activity) this, 0, bundle);
                    return;
                }
                return;
            }
            x.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.l(this, bMZ.field_find_passwd_url, false);
        } else {
            com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
            bundle.putParcelable("key_bankcard", this.sMZ);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.sMY) {
                x.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.pff);
                if (!bi.oN(parcelable.pff) && !bi.oN(this.sMZ.field_bankcardType) && parcelable.pff.trim().equals(this.sMZ.field_bankcardType.trim())) {
                    break;
                }
            }
            Object parcelable2 = elementQuery;
            bundle.putParcelable("elemt_query", parcelable2);
            if (ag != null) {
                ag.a((Activity) this, 0, bundle);
            }
        }
    }

    protected final int getLayoutId() {
        return g.uLy;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", Integer.valueOf(i2), str, kVar);
        if (i == 0 && i2 == 0) {
            String str2;
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                Bundle bundle = new Bundle();
                if (bi.oN(tVar.kOh)) {
                    this.sMY = tVar.sOR;
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    return true;
                } else if (tVar.sOS == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.sNb.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.sOS.isError()) {
                    x.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    com.tencent.mm.ui.base.h.h(this, i.uWg, i.dGZ);
                    return true;
                } else {
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.sIw == null) {
                        i3 = 0;
                    } else {
                        i3 = this.sIw.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (this.sIw == null || this.sIw.size() == 0) {
                        bLj();
                        bundle.putString("bank_name", tVar.sOS.nHt);
                        bundle.putParcelable("elemt_query", tVar.sOS);
                        bundle.putString("key_card_id", this.sNb.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        com.tencent.mm.wallet_core.a.j(this, bundle);
                        return true;
                    }
                }
            } else if (kVar instanceof y) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.sNa == null);
                x.i(str4, str2, objArr2);
                if (this.sNa != null) {
                    ArrayList arrayList = null;
                    if (o.bMc() != null) {
                        arrayList = o.bMc().bMJ();
                    }
                    com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
                    if (ag != null) {
                        ag.cBZ();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.sIw = arrayList2;
                        } else {
                            this.sIw = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.sIw == null ? 0 : this.sIw.size());
                    x.i(str4, str2, objArr3);
                    this.sNa.hkf = this.sIw;
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            WalletForgotPwdUI.this.sNa.notifyDataSetChanged();
                            WalletForgotPwdUI.c(WalletForgotPwdUI.this);
                        }
                    });
                }
            }
        }
        return false;
    }

    public final boolean aYP() {
        return true;
    }

    private boolean XT() {
        if (this.ipH.getVisibility() == 0 || (this.sNc.XX() && this.sNb.XX())) {
            this.sIX.setEnabled(true);
            this.sIX.setClickable(true);
            return true;
        }
        this.sIX.setEnabled(false);
        this.sIX.setClickable(false);
        return false;
    }

    public final void hB(boolean z) {
        XT();
    }

    protected boolean bKK() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final boolean aYL() {
        if ((this.sIw == null || this.sIw.size() == 0) && !bi.oN(o.bLY().bMZ().field_find_passwd_url)) {
            return true;
        }
        return false;
    }

    protected final boolean aYO() {
        uV(aYL() ? 4 : 0);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i, intent);
        if (i2 == -1 && 1 == i) {
            this.sNb.abs(intent.getStringExtra("key_bankcard_id"));
            bLk();
        }
    }
}
