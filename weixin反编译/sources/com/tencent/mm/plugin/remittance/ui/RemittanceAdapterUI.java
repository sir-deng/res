package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.ak;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String gBJ = null;
    public int itU;
    protected int oli;
    public boolean pRx = false;
    protected com.tencent.mm.plugin.wallet.a pRy = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uV(8);
        this.itU = getIntent().getIntExtra("scene", 0);
        this.gBJ = getIntent().getStringExtra("receiver_name");
        this.oli = getIntent().getIntExtra("pay_channel", -1);
        this.pRy = com.tencent.mm.plugin.wallet.a.X(getIntent());
        if (this.oli == -1) {
            c cCT = cCT();
            if (cCT != null) {
                this.oli = cCT.mym.getInt("pay_channel", -1);
            }
        }
        if (this.itU == 1) {
            this.pRx = true;
            bon();
        } else if (this.itU == 3) {
            jl(580);
            if (getIntent() == null) {
                x.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                return;
            }
            k aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            aVar.gQd = "RemittanceProcess";
            r(aVar);
        } else if (this.itU == 2) {
            if (bi.oN(this.gBJ)) {
                x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.itU);
                finish();
                return;
            }
            c(this.gBJ, 31, null);
        } else if (this.itU != 5 && this.itU != 6) {
            c(null, 31, null);
        } else if (bi.oN(this.gBJ)) {
            x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.itU);
            finish();
        } else {
            String str = this.gBJ;
            x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.itU + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.pRy, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.itU);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.oli);
            startActivity(intent);
            setResult(-1);
            finish();
        }
    }

    public void bon() {
        k vVar = new v(this.gBJ, this.oli);
        vVar.gQd = "RemittanceProcess";
        b(vVar, false);
    }

    public void onDestroy() {
        if (this.itU == 3) {
            jm(580);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.pRx) {
            x.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof v) {
            this.pRx = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            h.bu(this, str);
            finish();
            return true;
        } else if (kVar instanceof v) {
            final v vVar = (v) kVar;
            String str2 = vVar.pQZ;
            this.gBJ = vVar.username;
            if (bi.oN(this.gBJ) && bi.oN(str2)) {
                x.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.itU);
                finish();
                return true;
            }
            if (this.itU == 1) {
                if (vVar.scene == 33) {
                    this.pRy = com.tencent.mm.plugin.wallet.a.cs(this.gBJ, 2);
                    this.pRy.aQ(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.pRy = com.tencent.mm.plugin.wallet.a.cs(this.gBJ, 3);
                    this.pRy.aQ(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", vVar.loS);
            intent.putExtra("desc", vVar.desc);
            intent.putExtra("scan_remittance_id", vVar.pQQ);
            intent.putExtra("receiver_true_name", e.abk(vVar.pQP));
            intent.putExtra("receiver_tips", vVar.pQR);
            intent.putExtra("rcvr_new_desc", vVar.pQS);
            intent.putExtra("payer_desc", vVar.pQT);
            intent.putExtra("rcvr_open_id", vVar.pQZ);
            if (vVar.pQV == 1) {
                intent.putExtra("busi_type", vVar.pQV);
                intent.putExtra("rcvr_ticket", vVar.pQU);
                intent.putExtra("mch_name", vVar.pQW);
                intent.putExtra("mch_photo", vVar.pQX);
                intent.putExtra("mch_type", vVar.pRa);
                intent.putExtra("mch_time", vVar.pQY);
                intent.putExtra("rcvr_open_id", vVar.pQZ);
                intent.putExtra("get_pay_wifi", vVar.pRb);
                if (vVar.pRc != null) {
                    intent.putExtra("BusiRemittanceResp", vVar.pRc);
                }
            }
            g.Dr();
            com.tencent.mm.storage.x Xu = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xu(this.gBJ);
            b.I(this.gBJ, 3);
            if (Xu != null || this.gBJ.equals("")) {
                c(this.gBJ, vVar.scene, intent);
            } else {
                x.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long Wy = bi.Wy();
                ak.a.hhv.a(this.gBJ, "", new ak.b.a() {
                    public final void v(String str, boolean z) {
                        if (z) {
                            x.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bi.Wy() - Wy) + " ms");
                            b.I(str, 3);
                            n.JY().jb(str);
                        } else {
                            x.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.gBJ, vVar.scene, intent);
                    }
                });
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.TF(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bLs());
            c(null, 31, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.itU + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.pRy, intent2);
        if (intent2.getIntExtra("busi_type", 0) == 1) {
            intent2.setClass(this, RemittanceBusiUI.class);
        } else {
            intent2.setClass(this, RemittanceUI.class);
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.itU);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.oli);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
