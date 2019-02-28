package com.tencent.mm.plugin.wallet_ecard.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aym;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class b {

    public interface a {
        boolean bNX();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.a.b$1 */
    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ aym tfV;
        final /* synthetic */ WalletBaseUI tfW;
        final /* synthetic */ a tfX = null;

        AnonymousClass1(aym aym, WalletBaseUI walletBaseUI, a aVar) {
            this.tfV = aym;
            this.tfW = walletBaseUI;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.content.DialogInterface r9, int r10) {
            /*
            r8 = this;
            r7 = 1;
            r6 = 0;
            r0 = r8.tfV;
            r0 = r0.wgp;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 != 0) goto L_0x0065;
        L_0x000c:
            r0 = r8.tfW;
            r1 = r8.tfV;
            r1 = r1.wgp;
            r2 = r8.tfX;
            r3 = "MicroMsg.ECardUtil";
            r4 = "url: %s";
            r5 = new java.lang.Object[r7];
            r5[r6] = r1;
            com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
            r3 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
            if (r3 != 0) goto L_0x0065;
        L_0x0027:
            r3 = "native.";
            r3 = r1.startsWith(r3);
            if (r3 == 0) goto L_0x0069;
        L_0x0030:
            r0 = "MicroMsg.ECardUtil";
            r3 = "goto native";
            com.tencent.mm.sdk.platformtools.x.i(r0, r3);
            if (r2 == 0) goto L_0x0041;
        L_0x003b:
            r0 = r2.bNX();
            if (r0 != 0) goto L_0x0065;
        L_0x0041:
            r0 = "native.qryacctdesc";
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0065;
        L_0x004a:
            r0 = "native.openecardauth";
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0065;
        L_0x0053:
            r0 = "native.cancloseecard";
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0065;
        L_0x005c:
            r0 = "native.withdraw";
            r0 = r1.equals(r0);
            if (r0 == 0) goto L_0x0065;
        L_0x0065:
            r9.dismiss();
            return;
        L_0x0069:
            r2 = "MicroMsg.ECardUtil";
            r3 = "url: %s";
            r4 = new java.lang.Object[r7];
            r4[r6] = r1;
            com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = "rawUrl";
            r2.putExtra(r3, r1);
            r1 = "showShare";
            r2.putExtra(r1, r6);
            r1 = "webview";
            r3 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r0, r1, r3, r2);
            goto L_0x0065;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_ecard.a.b.1.onClick(android.content.DialogInterface, int):void");
        }
    }

    public static boolean a(final WalletBaseUI walletBaseUI, final aym aym) {
        if (aym == null) {
            x.i("MicroMsg.ECardUtil", "no popItem");
            return false;
        } else if (bi.oN(aym.wMd)) {
            return false;
        } else {
            if (!bi.oN(aym.sKt) && !bi.oN(aym.wMe)) {
                x.i("MicroMsg.ECardUtil", "show guide info 1");
                h.a((Context) walletBaseUI, aym.wMd, "", aym.sKt, aym.wMe, false, new AnonymousClass1(aym, walletBaseUI, null), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c cCT;
                        if (aym.wxv == a.tfw) {
                            x.i("MicroMsg.ECardUtil", "do end process");
                            cCT = walletBaseUI.cCT();
                            if (cCT != null) {
                                cCT.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (aym.wxv == a.tfz) {
                            x.i("MicroMsg.ECardUtil", "back bank list");
                            cCT = walletBaseUI.cCT();
                            if (cCT != null) {
                                cCT.d(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                return true;
            } else if (bi.oN(aym.wMe)) {
                return false;
            } else {
                x.i("MicroMsg.ECardUtil", "show guide info 2");
                h.a((Context) walletBaseUI, aym.wMd, "", aym.wMe, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        c cCT;
                        if (aym.wxv == a.tfw) {
                            x.i("MicroMsg.ECardUtil", "do end process");
                            cCT = walletBaseUI.cCT();
                            if (cCT != null) {
                                cCT.b(walletBaseUI, new Bundle());
                            } else {
                                walletBaseUI.finish();
                            }
                        } else if (aym.wxv == a.tfz) {
                            x.i("MicroMsg.ECardUtil", "back bank list");
                            cCT = walletBaseUI.cCT();
                            if (cCT != null) {
                                cCT.d(walletBaseUI, 100);
                            } else {
                                walletBaseUI.finish();
                            }
                        }
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        }
    }

    public static String d(Context context, String... strArr) {
        String string = context.getString(i.vdG);
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!bi.oN(str)) {
                    return str;
                }
            }
        }
        return string;
    }

    public static boolean a(WalletBaseUI walletBaseUI, k kVar, int i, String str, int i2, String str2) {
        if (i2 != 0) {
            i = i2;
            str = str2;
        }
        x.i("MicroMsg.ECardUtil", "finalRetCode: %s, finalRetMsg: %s", Integer.valueOf(i), str);
        return com.tencent.mm.wallet_core.d.h.a(walletBaseUI, kVar, 1000, i, str);
    }

    public static void a(int i, String str, String str2, String str3, Context context, com.tencent.mm.wallet_core.c.a aVar) {
        x.i("MicroMsg.ECardUtil", "start open ecard process, scene: %s, token==null%s, eCardType: %s, extraData: %s", Integer.valueOf(i), Boolean.valueOf(bi.oN(str)), str2, str3);
        Bundle bundle = new Bundle();
        bundle.putInt(a.tfA, i);
        bundle.putString(a.tfB, str);
        bundle.putString(a.tfF, str2);
        bundle.putString(a.tfG, str3);
        com.tencent.mm.wallet_core.a.a((Activity) context, com.tencent.mm.plugin.wallet_ecard.b.a.class, bundle, aVar);
    }
}
