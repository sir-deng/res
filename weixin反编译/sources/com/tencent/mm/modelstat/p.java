package com.tencent.mm.modelstat;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class p {

    public enum a {
        Chat(1),
        TalkChat(2),
        Sns(3);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(String str, d dVar) {
        if (dVar != null) {
            b(str, dVar);
        }
    }

    public static void b(String str, d dVar) {
        if (!bi.oN(str) && dVar != null) {
            bne mR = mR(str);
            dVar.q("Source", (mR == null ? -1 : mR.cPf) + ",");
            dVar.q("SnsStatExt", a(mR));
        }
    }

    public static bne mR(String str) {
        if (bi.oN(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        bnd bnd = new bnd();
        try {
            bnd.aH(decode);
        } catch (Exception e) {
            x.e("MicroMsg.SnsStatExtUtil", "", e);
        }
        return bnd.wXc;
    }

    public static String a(String str, PString pString) {
        if (bi.oN(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bnd bnd = new bnd();
        try {
            bnd.aH(decode);
            String str2 = bnd.wXc.wXg;
            String str3 = bnd.wXc.wXf;
            str2 = String.format("snsId=%s&uxInfo=%s&source=%d&snsStatExt=%s", new Object[]{URLEncoder.encode(str2, "UTF-8"), URLEncoder.encode(str3, "UTF-8"), Integer.valueOf(bnd.wXc.cPf), URLEncoder.encode(a(bnd.wXc), "UTF-8")});
            pString.value = bnd.wXe == null ? "" : bnd.wXe.nhB;
            return str2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String a(bne bne) {
        if (bne != null) {
            String str = bne.wXg;
            String str2 = "";
            if (!bi.oN(str)) {
                String[] split = str.split("\\|");
                if (split != null && split.length > 0) {
                    str2 = split[0];
                }
            }
            try {
                return String.format("expId=%d&adgroup_id=%s&snsId=%s", new Object[]{Integer.valueOf(bne.wXh), URLEncoder.encode(str2, "UTF-8"), bne.wXf});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.SnsStatExtUtil", "", e);
            }
        }
        return "";
    }

    public static String z(au auVar) {
        if (auVar == null) {
            return "";
        }
        String str = null;
        if (auVar.aNJ()) {
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
            if (fV == null || bi.oN(fV.fHB)) {
                return "";
            }
            str = fV.fHB;
        }
        if (!auVar.cjX()) {
            return str;
        }
        r nJ = t.nJ(auVar.field_imgPath);
        if (nJ == null || bi.oN(nJ.fHB)) {
            return "";
        }
        return nJ.fHB;
    }
}
