package com.tencent.mm.plugin.wallet_index.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.a.lo;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class h extends c<tb> implements e {
    int tgS;
    int tgT;
    gx tgU;
    lo tgV;
    long tgW;
    public c tgX;
    public c<lo> tgY;

    public h() {
        this.tgT = 0;
        this.tgX = new c<gx>() {
            {
                this.xmG = gx.class.getName().hashCode();
            }

            private boolean a(gx gxVar) {
                int i = 0;
                h.this.tgU = gxVar;
                String str = h.this.tgU.fxW.result;
                if (h.this.tgU.fxW.fxY != null) {
                    h.this.tgT = h.this.tgU.fxW.fxY.getInt("pay_channel", 0);
                }
                switch (h.this.tgU.fxW.actionCode) {
                    case 10:
                    case 11:
                        a.xmy.b(h.this);
                        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "ReqKey = " + str);
                        if (str == null) {
                            return true;
                        }
                        if (str.startsWith("weixin://wxpay")) {
                            h.this.tgS = 4;
                            g.Dr();
                            g.Dp().gRu.a(233, h.this);
                            k lVar = new l(str, h.this.tgU.fxW.username, 4, (int) System.currentTimeMillis(), new byte[0]);
                            g.Dr();
                            g.Dp().gRu.a(lVar, 0);
                            h.this.tgW = System.currentTimeMillis();
                        } else {
                            h.this.tgS = 1;
                            h.this.cv(str, h.this.tgT);
                        }
                        return true;
                    case 12:
                        h hVar = h.this;
                        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startBind reqKey = " + str);
                        String[] split = str.replace("http://p.weixin.qq.com?", "").split("&");
                        int length = split.length;
                        String str2 = null;
                        str = null;
                        Object obj = null;
                        while (i < length) {
                            String str3 = split[i];
                            if (str3.startsWith("errcode=")) {
                                obj = str3.replace("errcode=", "");
                            } else if (str3.startsWith("errmsg=")) {
                                str = str3.replace("errmsg=", "");
                            } else if (str3.startsWith("importkey=")) {
                                str2 = str3.replace("importkey=", "");
                            }
                            i++;
                        }
                        if (!"0".equals(obj) || bi.oN(str2)) {
                            if (bi.oN(str)) {
                                str = hVar.tgU.fxW.context.getString(i.vdG);
                            }
                            com.tencent.mm.ui.base.h.a(hVar.tgU.fxW.context, str, "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (h.this.tgU.frD != null) {
                                        h.this.tgU.fxX.ret = 1;
                                        h.this.tgU.frD.run();
                                    }
                                }
                            });
                        } else {
                            Context context = hVar.tgU.fxW.context;
                            Intent intent = new Intent();
                            intent.putExtra("key_import_key", str2);
                            intent.putExtra("key_bind_scene", 2);
                            intent.putExtra("key_custom_bind_tips", null);
                            d.b(context, "wallet", ".bind.ui.WalletBindUI", intent);
                            if (hVar.tgU.frD != null) {
                                hVar.tgU.fxX.ret = 1;
                                hVar.tgU.frD.run();
                            }
                        }
                        return true;
                    default:
                        return false;
                }
            }
        };
        this.tgY = new c<lo>() {
            {
                this.xmG = lo.class.getName().hashCode();
            }

            private boolean a(lo loVar) {
                h.this.tgV = loVar;
                String str = loVar.fDK.url;
                int i = loVar.fDK.scene;
                int i2 = loVar.fDK.fDM;
                int i3 = loVar.fDK.fqY;
                String str2 = loVar.fDK.bhd == null ? "" : loVar.fDK.bhd;
                h.this.tgS = 1;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "auth native, url: %s, a8key_scene: %d, channel: %d, sourceType: %d, source: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2);
                k kVar = new com.tencent.mm.wallet_core.tenpay.model.k(str, i, h.this.tgS, i2, i3, str2);
                g.Dr();
                g.Dp().gRu.a(385, h.this);
                g.Dr();
                g.Dp().gRu.a(kVar, 0);
                return false;
            }
        };
        this.xmG = tb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tb tbVar = (tb) bVar;
        p.cCn();
        if (tbVar instanceof tb) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (tbVar.fMn.result == -1));
            a.xmy.c(this);
            if (tbVar.fMn.result != -1) {
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (tbVar.fMn.intent == null || tbVar.fMn.intent.getIntExtra("pay_channel", 0) != 13) {
                d.a(ad.getContext(), ".ui.LauncherUI", intent);
                return true;
            }
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
            return true;
        }
        x.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            long currentTimeMillis = System.currentTimeMillis() - this.tgW;
            com.tencent.mm.plugin.report.service.g.pWK.h(11170, Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ao.getNetType(ad.getContext())), "");
            h(i, i2, currentTimeMillis);
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            g.Dr();
            g.Dp().gRu.b(233, (e) this);
            if (i == 0 && i2 == 0) {
                cv(((l) kVar).RL(), this.tgT);
                return;
            }
            if (bi.oN(str)) {
                str = this.tgU.fxW.context.getString(i.vdG);
            }
            com.tencent.mm.ui.base.h.a(this.tgU.fxW.context, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (h.this.tgU.frD != null) {
                        h.this.tgU.fxX.ret = 1;
                        h.this.tgU.frD.run();
                    }
                }
            });
        } else if (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.k) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            if (i == 0 && i2 == 0 && "0".equals(((com.tencent.mm.wallet_core.tenpay.model.k) kVar).zRF)) {
                t.j(this.tgS, ((com.tencent.mm.wallet_core.tenpay.model.k) kVar).fvC, i2);
                com.tencent.mm.wallet_core.tenpay.model.k kVar2 = (com.tencent.mm.wallet_core.tenpay.model.k) kVar;
                PayInfo payInfo = new PayInfo();
                payInfo.fDQ = this.tgS;
                payInfo.fvC = kVar2.fvC;
                payInfo.appId = kVar2.appId;
                payInfo.tgP = kVar2.tgP;
                payInfo.frQ = kVar2.frQ;
                payInfo.fDM = kVar2.fDM;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", payInfo.toString());
                com.tencent.mm.pluginsdk.wallet.h.a(this.tgV.fDK.context, payInfo, 0);
                if (this.tgV.frD != null) {
                    this.tgV.fDL.ret = 1;
                    this.tgV.frD.run();
                    return;
                }
                return;
            }
            if (bi.oN(str)) {
                if (bi.oN(((com.tencent.mm.wallet_core.tenpay.model.k) kVar).jgc)) {
                    str = this.tgV.fDK.context.getString(i.vdG);
                } else {
                    str = ((com.tencent.mm.wallet_core.tenpay.model.k) kVar).jgc;
                }
            }
            t.j(this.tgS, "", i2);
            com.tencent.mm.ui.base.h.a(this.tgV.fDK.context, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (h.this.tgV.frD != null) {
                        h.this.tgV.fDL.ret = 1;
                        h.this.tgV.frD.run();
                    }
                }
            });
        } else {
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
        }
    }

    private void cv(String str, int i) {
        String str2 = null;
        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + str);
        PayInfo payInfo = new PayInfo();
        payInfo.fDQ = this.tgS;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.fvC = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.njL = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.tgP = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.frQ = str3.replace("productid=", "");
            }
        }
        payInfo.fDM = i;
        if ("0".equals(obj)) {
            com.tencent.mm.pluginsdk.wallet.h.a(this.tgU.fxW.context, payInfo, 0);
            if (this.tgU.frD != null) {
                this.tgU.fxX.ret = 1;
                this.tgU.frD.run();
            }
        } else {
            if (bi.oN(str2)) {
                str2 = this.tgU.fxW.context.getString(i.vdG);
            }
            com.tencent.mm.ui.base.h.a(this.tgU.fxW.context, str2, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (h.this.tgU.frD != null) {
                        h.this.tgU.fxX.ret = 1;
                        h.this.tgU.frD.run();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            h(0, Integer.valueOf(obj).intValue(), 0);
        }
    }

    private void h(int i, int i2, long j) {
        IDKey iDKey;
        int i3 = 132;
        if (this.tgS == 1) {
            i3 = 163;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.tgS == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((long) ((int) j));
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
    }
}
