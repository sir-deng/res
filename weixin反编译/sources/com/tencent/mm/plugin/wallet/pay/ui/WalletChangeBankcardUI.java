package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.f.a.sz;
import com.tencent.mm.f.a.th;
import com.tencent.mm.f.a.ti;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(3)
public class WalletChangeBankcardUI extends WalletBaseUI implements a.a {
    public static int sKP = 1;
    protected int fDQ = 0;
    protected TextView kZc;
    public String mFy;
    private c pTY = new c<th>() {
        {
            this.xmG = th.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final th thVar = (th) bVar;
            x.i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", Integer.valueOf(thVar.fMD.result));
            b swVar = new sw();
            if (thVar.fMD.result == -1) {
                swVar.fLz.scene = 17;
            } else if (thVar.fMD.result == 0) {
                swVar.fLz.scene = 18;
            } else {
                swVar.fLz.scene = 0;
            }
            swVar.fLA.fLu = new Runnable() {
                public final void run() {
                    if (-1 == thVar.fMD.result) {
                        WalletChangeBankcardUI.this.zv(-1);
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xmy.m(swVar);
            return false;
        }
    };
    protected Button pTn;
    public Orders pVi = null;
    public n sFl;
    public ArrayList<Bankcard> sFo;
    public Bankcard sFp = null;
    public Authen sJc = null;
    protected ListView sKQ;
    public int sKR;
    public f sKS = null;
    public PayInfo sKT = null;
    protected String sKU = null;
    public FavorPayInfo sKV;
    private a sKW;
    com.tencent.mm.plugin.wallet_core.ui.c sKX = null;

    private void zv(int i) {
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            ag.d(this, 1);
        } else {
            finish();
        }
        b tiVar = new ti();
        tiVar.fME.result = -1;
        com.tencent.mm.sdk.b.a.xmy.m(tiVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == sKP) {
            zv(-1);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.vdk);
        Bundle bundle2 = this.vf;
        bundle2.putInt("key_err_code", 0);
        this.sKR = bundle2.getInt("key_support_bankcard", 1);
        this.sJc = (Authen) bundle2.getParcelable("key_authen");
        this.pVi = (Orders) bundle2.getParcelable("key_orders");
        this.sKT = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.sKV = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.fDQ = this.sKT == null ? 0 : this.sKT.fDQ;
        x.i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", Integer.valueOf(this.fDQ));
        if (this.vf.getBoolean("key_is_filter_bank_type")) {
            jH(true);
        } else {
            this.sFo = jG(bKG());
        }
        if (!(this.pVi == null || this.pVi.sUf == null || this.pVi.sUf.size() <= 0)) {
            this.sKU = getString(i.uXn, new Object[]{e.d(this.pVi.pTQ, this.pVi.pgf), ((Commodity) this.pVi.sUf.get(0)).desc});
        }
        bKH();
        initView();
        p.fw(7, 0);
        com.tencent.mm.sdk.b.a.xmy.b(this.pTY);
        if (this.vf.getBoolean("key_is_filter_bank_type") && this.sKS != null) {
            this.sKS.sZj = false;
        }
    }

    private ArrayList<Bankcard> jG(boolean z) {
        if (this.fDQ == 8) {
            com.tencent.mm.plugin.wallet.a.p.bKx();
            return com.tencent.mm.plugin.wallet.a.p.bKy().jO(z);
        }
        com.tencent.mm.plugin.wallet.a.p.bKx();
        return com.tencent.mm.plugin.wallet.a.p.bKy().jG(z);
    }

    public void onDestroy() {
        if (this.sKW != null) {
            this.sKW.bKF();
            this.sKW.release();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.pTY);
        this.sKX = null;
        super.onDestroy();
    }

    private boolean bKG() {
        return (this.sKT == null || this.sKT.fDQ == 11) ? false : true;
    }

    protected final void bKH() {
        if (this.sFo != null) {
            Collections.sort(this.sFo, new Comparator<Bankcard>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    Bankcard bankcard = (Bankcard) obj;
                    Bankcard bankcard2 = (Bankcard) obj2;
                    if (bankcard.bLB()) {
                        return -1;
                    }
                    if (bankcard.bLC()) {
                        return bankcard2.bLB() ? 1 : -1;
                    } else {
                        if (bi.Wd(bankcard.field_forbidWord) >= bi.Wd(bankcard2.field_forbidWord)) {
                            return bi.Wd(bankcard.field_forbidWord) > bi.Wd(bankcard2.field_forbidWord) ? 1 : 0;
                        } else {
                            return -1;
                        }
                    }
                }
            });
        }
    }

    public final void initView() {
        this.pTn = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzl);
        this.pTn.setEnabled(false);
        this.pTn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletChangeBankcardUI.this.bKJ();
            }
        });
        if (bi.oN(this.vf.getString("key_pwd1"))) {
            this.pTn.setText(i.dGf);
        } else {
            this.pTn.setText(i.vbV);
        }
        this.sKQ = (ListView) findViewById(com.tencent.mm.plugin.wxpay.a.f.cMA);
        this.sKS = bKI();
        this.sKQ.setAdapter(this.sKS);
        this.sKQ.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WalletChangeBankcardUI.this.zw(i);
            }
        });
        av();
    }

    public f bKI() {
        bKH();
        return new f(this, this.sFo, this.sKR, this.pVi);
    }

    public final void av() {
        this.kZc = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.urA);
        if (this.sKV != null && !bi.oN(this.sKV.sTg)) {
            this.kZc.setVisibility(0);
            this.kZc.setText(this.sKV.sTg);
        } else if (this.vf.getInt("key_main_bankcard_state", 0) != 0) {
            this.kZc.setVisibility(0);
            this.kZc.setText(this.sKU);
        } else {
            this.kZc.setVisibility(8);
        }
    }

    protected void zw(int i) {
        int i2 = 0;
        int size = this.sFo != null ? this.sFo.size() : 0;
        if (this.sFo != null && i < size) {
            Bankcard bankcard = (Bankcard) this.sFo.get(i);
            this.sFp = bankcard;
            if (this.sKT != null) {
                i2 = this.sKT.fDQ;
            }
            t.d(i2, this.sKT == null ? "" : this.sKT.fvC, 13, this.sFp.field_bindSerial);
            this.sKS.sZi = bankcard.field_bindSerial;
            this.pTn.setEnabled(true);
            this.sKS.notifyDataSetChanged();
            bKJ();
        } else if (size == i) {
            g bLJ = g.bLJ();
            if (bLJ.aHO()) {
                h.b(this, bLJ.pfh, getString(i.dGZ), true);
                return;
            }
            if (this.sKT != null) {
                i2 = this.sKT.fDQ;
            }
            t.d(i2, this.sKT == null ? "" : this.sKT.fvC, 14, "");
            this.vf.putInt("key_err_code", -1003);
            com.tencent.mm.wallet_core.a.j(this, this.vf);
        }
    }

    public void onResume() {
        this.vf.putInt("key_err_code", 0);
        super.onResume();
        if (this.sKX != null) {
            this.sKX.bNb();
        }
    }

    public final boolean aYL() {
        if (super.aYL()) {
            return true;
        }
        if (this.sKT == null || !this.sKT.niF) {
            return false;
        }
        if (this.sKT.niF) {
            return true;
        }
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (com.tencent.mm.plugin.wallet.a.p.bKy().bMy()) {
            return false;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uLn;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = 0;
        if (i == 4 && this.sKV != null && this.sFo.size() == 0) {
            FavorPayInfo favorPayInfo = this.sKV;
            boolean z = (favorPayInfo == null || favorPayInfo.sTd == 0) ? false : true;
            if (z) {
                x.i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.vf.getString("key_is_cur_bankcard_bind_serial");
                if (bi.oN(string)) {
                    x.e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    return super.onKeyUp(i, keyEvent);
                }
                List jG = jG(true);
                if (jG != null && this.sFp == null) {
                    while (true) {
                        int i3 = i2;
                        if (i3 >= jG.size()) {
                            break;
                        } else if (string.equals(((Bankcard) jG.get(i3)).field_bindSerial)) {
                            x.i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:" + string);
                            this.sFp = (Bankcard) jG.get(i3);
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                    if (this.sFp == null) {
                        x.e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        return super.onKeyUp(i, keyEvent);
                    }
                }
                bKJ();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            Bundle bundle = new Bundle();
            bundle.putString("pwd", this.mFy);
            this.vf.putBoolean("key_need_verify_sms", false);
            ((l) com.tencent.mm.kernel.g.h(l.class)).a(this.sJc.pHW.tcd == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.sKT.vGm = i2;
                    bKJ();
                    return true;
                case 100100:
                case 100101:
                    this.sKT.vGm = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.sKW == null) {
                        this.sKW = new a(this, this);
                    }
                    this.sKW.a(z, this.sKT.fxS, this.sKT.fvC);
                    x.i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is " + z);
                    return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) {
            return true;
        } else {
            if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                Bundle bundle2 = this.vf;
                com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                if (!bi.oN(this.mFy)) {
                    bundle2.putString("key_pwd1", this.mFy);
                }
                bundle2.putString("kreq_token", bVar.token);
                bundle2.putParcelable("key_authen", bVar.sKx);
                bundle2.putBoolean("key_need_verify_sms", !bVar.sKv);
                bundle2.putParcelable("key_pay_info", this.sKT);
                bundle2.putInt("key_pay_flag", 3);
                Parcelable parcelable = bVar.pbX;
                if (parcelable != null) {
                    bundle2.putParcelable("key_realname_guide_helper", parcelable);
                }
                Bundle bundle3 = new Bundle();
                bundle3.putString("pwd", this.mFy);
                ((l) com.tencent.mm.kernel.g.h(l.class)).a(bVar.bKC(), true, bundle3);
                if (bVar.sLK) {
                    bundle2.putParcelable("key_orders", bVar.sKw);
                    if (this.sKT != null && this.sKT.fDQ == 8) {
                        b szVar = new sz();
                        szVar.fMi.fMj = this.sJc.pfg;
                        com.tencent.mm.sdk.b.a.xmy.m(szVar);
                    }
                }
                com.tencent.mm.wallet_core.a.j(this, bundle2);
                return true;
            }
        }
        return false;
    }

    public void bKJ() {
        x.d("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        String string = this.vf.getString("key_pwd1");
        if (bi.oN(string)) {
            uV(4);
            this.sFl = n.a((Context) this, this.pVi, this.sKV, this.sFp, this.sKT, new n.c() {
                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    WalletChangeBankcardUI.this.sKV = favorPayInfo;
                    WalletChangeBankcardUI.this.vf.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.sKV);
                    if (WalletChangeBankcardUI.this.sKV == null || !z) {
                        WalletChangeBankcardUI.this.mFy = str;
                        WalletChangeBankcardUI.this.aWY();
                        WalletChangeBankcardUI.this.Nr(str);
                        WalletChangeBankcardUI.this.sKX = null;
                        return;
                    }
                    if (WalletChangeBankcardUI.this.sKV != null) {
                        WalletChangeBankcardUI.this.jH(true);
                        WalletChangeBankcardUI.this.sKS.d(WalletChangeBankcardUI.this.sFo, false);
                    }
                    if (WalletChangeBankcardUI.this.sFl != null) {
                        WalletChangeBankcardUI.this.sFl.dismiss();
                    }
                    WalletChangeBankcardUI.this.av();
                    WalletChangeBankcardUI.this.uV(0);
                }
            }, new OnClickListener() {
                public final void onClick(View view) {
                    if (WalletChangeBankcardUI.this.sFl != null) {
                        WalletChangeBankcardUI.this.sFl.dismiss();
                    }
                    WalletChangeBankcardUI.this.jH(false);
                    WalletChangeBankcardUI.this.sKS.d(WalletChangeBankcardUI.this.sFo, true);
                    WalletChangeBankcardUI.this.sKV = (FavorPayInfo) view.getTag();
                    if (WalletChangeBankcardUI.this.sKV != null) {
                        WalletChangeBankcardUI.this.sKV.sTg = "";
                    }
                    WalletChangeBankcardUI.this.vf.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.sKV);
                    WalletChangeBankcardUI.this.av();
                    WalletChangeBankcardUI.this.uV(0);
                    WalletChangeBankcardUI.this.sKX = null;
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    WalletChangeBankcardUI.this.mFy = null;
                    if (WalletChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                        WalletChangeBankcardUI.this.bKL();
                    }
                    WalletChangeBankcardUI.this.sKX = null;
                }
            });
            this.sKX = this.sFl;
            return;
        }
        Nr(string);
    }

    public void Nr(String str) {
        this.sJc.sQC = str;
        if (this.sFp != null) {
            this.vf.putString("key_mobile", this.sFp.field_mobile);
            this.vf.putParcelable("key_bankcard", this.sFp);
            this.sJc.pfg = this.sFp.field_bindSerial;
            this.sJc.pff = this.sFp.field_bankcardType;
            if (this.sKV != null) {
                this.sJc.sQO = this.sKV.sTc;
            } else {
                this.sJc.sQO = null;
            }
            if (this.pVi.sUg != null) {
                this.sJc.sQN = this.pVi.sUg.sJu;
            }
            if (this.pVi != null && this.pVi.sOT == 3) {
                boolean z;
                if (this.sFp.bLE()) {
                    this.sJc.fEo = 3;
                } else {
                    this.sJc.fEo = 6;
                }
                Bundle bundle = this.vf;
                String str2 = "key_is_oversea";
                if (this.sFp.bLE()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.vf.putString("key_pwd1", str);
        this.vf.putParcelable("key_authen", this.sJc);
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.sJc, this.pVi, false);
        if (a != null) {
            a.gQd = "PayProcess";
            a.vf = this.vf;
            if (this.sKT.fDQ == 6 && this.sKT.vGi == 100) {
                a.itU = 100;
            } else {
                a.itU = this.sKT.fDQ;
            }
            l(a);
        }
    }

    protected final boolean bKK() {
        return true;
    }

    public final void uO(int i) {
        if (i == 0) {
            bKL();
        } else if (i == 1) {
            this.vf.putString("key_pwd1", "");
            bKJ();
        } else {
            x.w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
        }
    }

    public final void bKL() {
        cCQ();
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            ag.b((Activity) this, this.vf);
        } else {
            finish();
        }
    }

    protected int getForceOrientation() {
        return 1;
    }

    protected final void jH(boolean z) {
        int i = 0;
        this.sFo = jG(bKG());
        if (this.sKV != null) {
            int i2;
            if (this.sKV.sTd != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0 && z) {
                String str = this.sKV.sTe;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    i2 = i;
                    if (i2 < this.sFo.size()) {
                        Bankcard bankcard = (Bankcard) this.sFo.get(i2);
                        if (bi.oN(str)) {
                            if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                                arrayList.add(bankcard);
                            }
                        } else if (bankcard.field_bankcardType.equals(str)) {
                            arrayList.add(bankcard);
                        }
                        i = i2 + 1;
                    } else {
                        this.sFo = arrayList;
                        bKH();
                        return;
                    }
                }
            }
        }
    }

    protected final boolean aYO() {
        return true;
    }

    public final void c(boolean z, String str, String str2) {
        x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            x.i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.sKT.fxU = str;
            this.sKT.fxV = str2;
            Nr(this.mFy);
            return;
        }
        x.e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        Nr(this.mFy);
    }

    public void onPause() {
        super.onPause();
        if (this.sKX != null) {
            this.sKX.bNc();
        }
    }
}
