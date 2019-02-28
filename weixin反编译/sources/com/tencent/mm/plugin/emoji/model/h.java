package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import java.util.ArrayList;

public final class h {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public Context kgx;
    public long lDA = 0;
    public String lDB = "";
    public b lDC;
    private String lDD;
    private com.tencent.mm.plugin.emoji.h.b lDE = new com.tencent.mm.plugin.emoji.h.b(2003);
    public String lDF;
    public com.tencent.mm.plugin.emoji.a.a.a lDw;
    public boolean lDx = false;
    public Fragment lDy;
    public int lDz;
    private Context tI = ad.getContext();

    public interface a {
        void a(com.tencent.mm.plugin.emoji.a.a aVar);
    }

    public interface b {
        void J(String str, String str2, String str3);

        void aCd();
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar != null && aVar.lyW != null && this.lDw != null && this.lDw.lAm != null) {
            sx sxVar = aVar.lyW.lAy;
            if (sxVar != null) {
                String str;
                String str2 = sxVar.vPI;
                String str3 = sxVar.whv;
                String str4 = sxVar.whG;
                String str5 = sxVar.whH;
                int aBb = aVar.aBb();
                (aVar.lyW == null ? null : Integer.valueOf(aVar.lyW.lAA)).intValue();
                c cVar = this.lDw.lAm;
                boolean z = cVar.lAv;
                boolean z2 = aVar.lyW.lAC;
                String str6 = "MicroMsg.emoji.PayOrDownloadComponent";
                String str7 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = str4;
                }
                objArr[1] = str;
                objArr[2] = Integer.valueOf(aBb);
                x.i(str6, str7, objArr);
                this.lDD = str2;
                int i;
                ak yD;
                switch (aBb) {
                    case -1:
                        if (e.a(sxVar)) {
                            i = 3;
                        } else if (e.b(sxVar) || (!z && TextUtils.isEmpty(sxVar.why))) {
                            i = 3;
                        } else if (z) {
                            yD = cVar.yD(str2);
                            if (TextUtils.isEmpty(yD.xHe)) {
                                i = yD.xHc;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 4;
                        }
                        this.lDw.be(str2, i);
                        return;
                    case 0:
                        if (this.lDw != null) {
                            this.lDw.be(str2, 3);
                            return;
                        }
                        return;
                    case 3:
                    case 5:
                        if (com.tencent.mm.plugin.emoji.h.a.d(sxVar)) {
                            com.tencent.mm.plugin.emoji.f.a.aCq();
                            com.tencent.mm.plugin.emoji.f.a.aCr();
                            return;
                        }
                        J(str2, null, str3);
                        if (this.lDw != null) {
                            this.lDw.bf(str2, 0);
                        }
                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str2);
                        g.pWK.h(12066, Integer.valueOf(0), Integer.valueOf(this.lDz), "", str2, Long.valueOf(this.lDA), this.lDB);
                        return;
                    case 4:
                    case 12:
                        if (!this.lDx) {
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", str2);
                            if (z) {
                                intent.putExtra("key_currency_type", "");
                                intent.putExtra("key_price", str4);
                            } else {
                                intent.putExtra("key_currency_type", str5);
                                intent.putExtra("key_price", str4);
                            }
                            d.b(this.kgx, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                            this.lDx = true;
                            g.pWK.h(12066, Integer.valueOf(2), Integer.valueOf(this.lDz), "", str2, Long.valueOf(this.lDA), this.lDB);
                            return;
                        }
                        return;
                    case 7:
                        if (z2) {
                            if ((this.lDy != null ? 1 : null) != null) {
                                com.tencent.mm.plugin.emoji.h.b bVar = this.lDE;
                                Fragment fragment = this.lDy;
                                x.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                                Intent intent2 = new Intent();
                                intent2.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                                intent2.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                                d.a(fragment, ".ui.transmit.SelectConversationUI", intent2, bVar.jQy);
                                fragment.getActivity().overridePendingTransition(R.a.bqo, R.a.bqa);
                            } else {
                                this.lDE.n((Activity) this.kgx);
                            }
                            this.lDE.lOs = str2;
                            g.pWK.h(12069, Integer.valueOf(1), str2);
                            return;
                        } else if (aVar.lyW.lAE) {
                            str4 = aVar.lyW.lAy.vPI;
                            String str8 = aVar.lyW.lAy.whv;
                            str2 = this.lDF;
                            if (this.kgx != null) {
                                i = this.lDz == 9 ? 3 : 4;
                                Intent intent3 = new Intent();
                                intent3.setClass(this.kgx, EmojiStoreV2RewardUI.class);
                                intent3.putExtra("extra_id", str4);
                                intent3.putExtra("extra_name", str8);
                                intent3.putExtra("name", str2);
                                intent3.putExtra("scene", this.lDz);
                                intent3.putExtra("pageType", i);
                                intent3.putExtra("searchID", this.lDA);
                                this.kgx.startActivity(intent3);
                                g.pWK.h(12738, str4, Integer.valueOf(i), Integer.valueOf(this.lDz), Integer.valueOf(0));
                                return;
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                            return;
                        } else {
                            return;
                        }
                    case 9:
                        as.CN().a(new q(str2, 2), 0);
                        return;
                    case 10:
                        yD = cVar.yD(str2);
                        if (yD != null) {
                            switch (yD.xHd) {
                                case 10233:
                                    str = getString(R.l.eai);
                                    break;
                                case 10234:
                                    str = getString(R.l.ead);
                                    break;
                                case 10235:
                                    str = getString(R.l.ebG);
                                    break;
                                default:
                                    str = getString(R.l.ebK);
                                    break;
                            }
                            com.tencent.mm.ui.base.h.b(this.kgx, str, null, true);
                            return;
                        }
                        return;
                    case 11:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                        return;
                    default:
                        x.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                        return;
                }
            }
        }
    }

    private void J(String str, String str2, String str3) {
        if (this.lDC != null) {
            this.lDC.J(str, str2, str3);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i3);
            str = intent.getStringExtra("key_err_msg");
            x.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str);
        }
        String str2 = str;
        this.lDx = false;
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    if (this.lDw != null && this.lDw.lAm != null) {
                        if (intent != null && i3 == 0) {
                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                            Object obj = null;
                            int size = stringArrayListExtra.size();
                            int i4 = 0;
                            while (i4 < size) {
                                String str3 = (String) stringArrayListExtra.get(i4);
                                str = (String) stringArrayListExtra2.get(i4);
                                ak yD = this.lDw.lAm.yD(str3);
                                if (this.lDD.equals(str3)) {
                                    obj = 1;
                                    J(str3, str, yD.lKx);
                                    this.lDw.bf(this.lDD, 0);
                                    com.tencent.mm.ui.base.h.bu(this.kgx, str2);
                                    x.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", str3);
                                    if (stringArrayListExtra.size() > 1) {
                                        x.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                        if (this.lDC != null) {
                                            this.lDC.aCd();
                                        }
                                    }
                                } else {
                                    this.lDw.be(this.lDD, 5);
                                }
                                i4++;
                                obj = obj;
                            }
                            if (obj == null) {
                                ze(str2);
                            }
                            if (com.tencent.mm.y.q.Gk()) {
                                g.pWK.a(166, 4, 1, false);
                                return;
                            } else {
                                g.pWK.a(166, 0, 1, false);
                                return;
                            }
                        } else if (intent != null && i3 == 100000002) {
                            J(this.lDD, null, this.lDw.lAm.yD(this.lDD).lKx);
                            this.lDw.bf(this.lDD, 0);
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", this.lDD);
                            ze(str2);
                            if (com.tencent.mm.y.q.Gk()) {
                                g.pWK.a(166, 7, 1, false);
                                return;
                            } else {
                                g.pWK.a(166, 3, 1, false);
                                return;
                            }
                        } else if (intent == null || i3 != 1) {
                            if (!(this.lDD == null || this.lDw == null || this.lDw.lAm == null)) {
                                this.lDw.lAm.yB(this.lDD);
                                com.tencent.mm.plugin.emoji.a.a yz = this.lDw.yz(this.lDD);
                                if (yz != null) {
                                    yz.aBg();
                                }
                            }
                            ze(str2);
                            if (com.tencent.mm.y.q.Gk()) {
                                g.pWK.a(166, 5, 1, false);
                            } else {
                                g.pWK.a(166, 1, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", str2);
                            return;
                        } else {
                            if (com.tencent.mm.y.q.Gk()) {
                                g.pWK.a(166, 6, 1, false);
                            } else {
                                g.pWK.a(166, 2, 1, false);
                            }
                            x.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                            return;
                        }
                    }
                    return;
                case 2003:
                    str = this.lDE.lOs;
                    if (!bi.oN(str)) {
                        com.tencent.mm.plugin.emoji.h.b.a(intent, str, (Activity) this.kgx);
                        g.pWK.h(12069, Integer.valueOf(3), str);
                        return;
                    }
                    return;
                default:
                    x.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                    return;
            }
        } else if (i != 2001) {
        } else {
            if (com.tencent.mm.y.q.Gk()) {
                g.pWK.a(166, 6, 1, false);
            } else {
                g.pWK.a(166, 2, 1, false);
            }
        }
    }

    private void ze(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.eal);
        }
        com.tencent.mm.ui.base.h.a(this.kgx, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String getString(int i) {
        return this.tI.getString(i);
    }
}
