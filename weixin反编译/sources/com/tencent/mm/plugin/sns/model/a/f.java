package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.j.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class f extends c {
    protected boolean rfi = false;
    protected boolean rfj = false;
    protected boolean rfk = false;
    protected boolean rfl = false;

    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String Lp(String str) {
        Exception e;
        int i = 2;
        Object obj = null;
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = g.Af().getValue("SnsCloseDownloadWebp");
            if (bi.oN(value)) {
                i2 = 0;
            } else {
                i2 = bi.Wo(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (q.gHP.gHk == 2) {
                obj2 = null;
            } else if (bi.oN(r.igA)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!n.yD()) {
                obj3 = null;
            } else if (!ae.bwq()) {
                obj3 = null;
            } else if (bi.oN(r.igA)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (n.yD() && ae.bwp() && bi.oN(r.igA)) {
                obj4 = 1;
            }
            if (!bi.oN(r.igz) || !bi.oN(r.igA)) {
                if (!bi.oN(r.igz)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(r.igz);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
                }
                if (!bi.oN(r.igA)) {
                    str = l(str, "tp=" + r.igA);
                    x.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + str);
                }
            } else if (obj3 != null) {
                str = l(str, "tp=wxpc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj4 != null) {
                str = l(str, "tp=hevc");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj22 != null) {
                str = l(str, "tp=webp");
                x.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            }
            if (!(this.reJ == null || this.reJ.qZY.wFb == 0)) {
                str = l(str, "enc=1");
                x.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.reJ.qZY.wFc + " " + this.reJ.qZY.wFb + " " + str);
                b.qq(h.CTRL_INDEX);
                this.rfl = true;
            }
            str2 = str;
            try {
                if (this.reJ == null || this.reJ.qZY == null) {
                    return str2;
                }
                Object obj5;
                are are = this.reJ.qZY;
                if (this.reJ.reD) {
                    obj5 = are.wFh;
                } else {
                    String obj52 = are.wFe;
                }
                obj4 = this.reJ.reD ? are.wFi : are.wFf;
                if (TextUtils.isEmpty(obj52)) {
                    return str2;
                }
                return l(str2, "token=" + obj52, "idx=" + obj4);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    private static String l(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
