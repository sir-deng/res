package com.tencent.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.c.c.b.d;
import com.tencent.c.d.a.b;
import com.tencent.c.d.a.c;
import com.tencent.c.d.a.e;
import com.tencent.c.d.a.f;
import com.tencent.c.d.a.g;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public b Abi;
    public Context mContext = null;

    public a(Context context) {
        this.mContext = context;
        this.Abi = new b(context);
    }

    public static d cEi() {
        d dVar = new d();
        try {
            int i;
            dVar.Acz = Build.FINGERPRINT;
            dVar.AcA = com.tencent.c.f.d.cED();
            dVar.hrN = Build.BRAND;
            dVar.model = Build.MODEL;
            dVar.AcB = VERSION.SDK_INT;
            dVar.AcC = Build.CPU_ABI;
            dVar.platform = com.tencent.c.f.d.abF("ro.board.platform");
            if (f.cEm()) {
                i = 2;
            } else {
                Object obj;
                Object<com.tencent.c.d.b.d.a> cEn = com.tencent.c.d.b.d.cEn();
                if ((cEn.isEmpty() ? 1 : null) == null) {
                    List<b> arrayList = new ArrayList(3);
                    arrayList.add(new g());
                    arrayList.add(new com.tencent.c.d.a.d());
                    if (com.tencent.c.d.b.f.cEo()) {
                        arrayList.add(new c());
                    }
                    for (com.tencent.c.d.b.d.a aVar : cEn) {
                        if (aVar != null) {
                            for (b a : arrayList) {
                                a.a(aVar);
                            }
                        }
                    }
                    for (b cEk : arrayList) {
                        if (cEk.cEk()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (e.cEl()) {
                    i = 1;
                } else {
                    if (!com.tencent.c.d.a.a.abA("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!com.tencent.c.d.a.a.abA("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.abA("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!com.tencent.c.d.a.a.abB("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (com.tencent.c.d.a.a.abB("/system/bin/install-recovery.sh")) {
                        h.abG("BootScriptChecker : everything seems ok");
                        obj = null;
                    } else {
                        i = 1;
                    }
                    i = obj != null ? 1 : 0;
                }
            }
            dVar.cIB = i;
        } catch (Exception e) {
        }
        return dVar;
    }

    public static com.tencent.c.c.b.b a(Context context, com.tencent.c.a.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        byte[] bArr;
        com.tencent.c.c.b.b bVar = new com.tencent.c.c.b.b();
        bVar.AbR = i;
        bVar.AbS = null;
        bVar.AbT = aVar.ffM;
        String str = aVar.Abd;
        if (str == null) {
            bArr = null;
        } else {
            int length = str.length() / 2;
            bArr = new byte[length];
            char[] toCharArray = str.toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3 + 1])) | (((byte) "0123456789ABCDEF".indexOf(toCharArray[i3])) << 4));
            }
        }
        bVar.AbU = bArr;
        List<byte[]> bD = com.tencent.c.f.a.bD(context, aVar.ffM);
        if (bD.size() > 1) {
            bVar.Acj = new ArrayList();
            for (byte[] bArr2 : bD) {
                bVar.Acj.add(bArr2);
            }
        }
        bVar.AbV = aVar.fileSize;
        bVar.AbW = aVar.Abc;
        bVar.AbX = aVar.versionCode;
        bVar.AbY = aVar.versionName;
        bVar.AbZ = 0;
        if (aVar.hvd == 1) {
            bVar.AbZ |= 1;
        }
        bVar.AbZ |= 2;
        if (!(aVar.Abe.startsWith("/data") || aVar.Abe.startsWith("/system"))) {
            bVar.AbZ |= 4;
        }
        bVar.Aca = com.tencent.c.f.a.abE(aVar.Abe);
        bVar.Acb = 0;
        bVar.Acc = 0;
        bVar.Acd = 0;
        bVar.Ace = null;
        bVar.Acf = 0;
        bVar.Acg = false;
        bVar.Ach = 0;
        bVar.Aci = 0;
        return bVar;
    }
}
