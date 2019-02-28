package com.tencent.mm.sandbox.monitor;

import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public abstract class c implements b {
    public static final String xkt = e.bnF;
    public int xku;
    public int xkv;
    public int xkw;
    public String xkx;
    private boolean xky = false;

    public c(int i, String str, int i2, boolean z) {
        this.xkv = i;
        this.xkx = str;
        this.xku = i2;
        this.xky = z;
        this.xkw = com.tencent.mm.a.e.bN(bbC());
        File file = new File(xkt);
        if (!file.exists()) {
            file.mkdirs();
        }
        x.d("MM.GetUpdatePack", "NetSceneGetUpdatePack : temp path = " + bbC() + " packOffset = " + this.xkw);
    }

    public String bbC() {
        return xkt + this.xkx + ".temp";
    }

    public String ceT() {
        return xkt + this.xkx + ".apk";
    }

    public final void deleteTempFile() {
        try {
            x.d("MM.GetUpdatePack", "deleteTempFile");
            File file = new File(bbC());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            x.e("MM.GetUpdatePack", "error in deleteTempFile");
        }
    }

    public static boolean Vh(String str) {
        if (com.tencent.mm.a.e.bO(xkt + str + ".temp")) {
            return true;
        }
        return false;
    }

    public static String Vi(String str) {
        String str2 = xkt + str + ".apk";
        return (com.tencent.mm.a.e.bO(str2) && a.ch(str2)) ? str2 : null;
    }

    public static String Jg(String str) {
        return bf(str, false);
    }

    public static String bf(String str, boolean z) {
        Exception exception;
        g gVar;
        Object[] objArr;
        String str2 = xkt + str + ".temp";
        String str3 = xkt + str + ".apk";
        if (com.tencent.mm.a.e.bO(str2) && !z && (a.ch(str2) || str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str2)))) {
            com.tencent.mm.a.e.g(xkt, str + ".temp", str + ".apk");
            return str3;
        }
        if (com.tencent.mm.a.e.bO(str3)) {
            if (a.ch(str3)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack checkApkMd5 update pack ok");
                return str3;
            }
            try {
                str2 = com.tencent.mm.c.c.k(new File(str3));
                try {
                    if (bi.oN(str2)) {
                        g.pWK.a(322, 10, 1, false);
                        g.pWK.h(11098, Integer.valueOf(4010));
                    }
                } catch (Exception e) {
                    exception = e;
                    x.w("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode e:" + exception.getMessage());
                    g.pWK.a(322, 9, 1, false);
                    g.pWK.h(11098, Integer.valueOf(4009), exception.getMessage());
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
                    if (bi.oN(str2)) {
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.cff());
                        if (str2.equals(i.cff())) {
                            x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                            return str3;
                        }
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                        g.pWK.a(322, 11, 1, false);
                        gVar = g.pWK;
                        objArr = new Object[2];
                        objArr[0] = Integer.valueOf(4011);
                        objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                        gVar.h(11098, objArr);
                    } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str3))) {
                        x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                        return str3;
                    }
                    x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
                    com.tencent.mm.loader.stub.b.deleteFile(str3);
                    return null;
                }
            } catch (Exception e2) {
                exception = e2;
                str2 = null;
            }
            x.i("MM.GetUpdatePack", "summertoken getReadyPack getSecurityCode pkgsig[%s]", str2);
            if (bi.oN(str2)) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig[%s], downloadedSig[%s]", str2, i.cff());
                if (str2.equals(i.cff())) {
                    x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check update pack ok");
                    return str3;
                }
                x.i("MM.GetUpdatePack", "summertoken getReadyPack pkgsig check invalid");
                g.pWK.a(322, 11, 1, false);
                gVar = g.pWK;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(4011);
                objArr[1] = String.format("%s,%s", new Object[]{r10, str2});
                gVar.h(11098, objArr);
            } else if (str.equalsIgnoreCase(com.tencent.mm.a.g.bV(str3))) {
                x.i("MM.GetUpdatePack", "summertoken getReadyPack no pkgsig getMD5 update pack ok");
                return str3;
            }
            x.e("MM.GetUpdatePack", "summertoken getReadyPack: update pack MD5 not same");
            com.tencent.mm.loader.stub.b.deleteFile(str3);
        }
        return null;
    }

    public final boolean ceU() {
        if (!this.xky || ao.isWifi(ad.getContext())) {
            return false;
        }
        return true;
    }
}
