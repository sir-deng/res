package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class s {
    public static final String hgU = d("rconversation.username", new String[]{"@chatroom", "@openim", "@micromsg.qq.com"});
    public static final String hgV = d("rconversation.username", new String[]{"@t.qq.com"});
    public static final String hgW = d("rconversation.username", new String[]{"@qqim"});
    public static final String hgX = d("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String hgY = d("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String hgZ = d("rconversation.username", new String[]{"@app"});
    public static final String hha = d("rconversation.username", new String[]{"@chatroom"});
    public static final String[] hhb = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    public static boolean gz(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            return true;
        }
        return false;
    }

    public static boolean eX(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static boolean gA(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qy_u");
    }

    public static boolean gB(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@bottle");
    }

    public static boolean gC(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qqim");
    }

    public static boolean gD(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@lbsroom");
    }

    public static boolean d(x xVar) {
        if (xVar != null && bi.oM(xVar.field_username).endsWith("@chatroom") && a.ga(xVar.field_type)) {
            return true;
        }
        return false;
    }

    public static boolean gE(String str) {
        return "gh_43f2581f6fd6".equals(str);
    }

    public static boolean gF(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.endsWith("@chatroom")) {
            return false;
        }
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv == null || !a.ga(Xv.field_type)) {
            return false;
        }
        return true;
    }

    public static boolean gG(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@stranger");
    }

    public static List<String> GI() {
        return ((h) g.h(h.class)).Ff().ciZ();
    }

    public static List<x> GJ() {
        List<x> arrayList = new ArrayList();
        Cursor cja = ((h) g.h(h.class)).Ff().cja();
        if (cja.moveToFirst()) {
            do {
                x xVar = new x();
                xVar.b(cja);
                arrayList.add(xVar);
            } while (cja.moveToNext());
        }
        cja.close();
        return arrayList;
    }

    public static String a(x xVar, String str) {
        if (xVar == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bi.oN(xVar.field_nickname)) {
            String gw = ((b) g.h(b.class)).Fo().gw(str);
            if (!bi.oN(gw)) {
                return gw;
            }
        }
        if (xVar.AX() == null || xVar.AX().length() <= 0) {
            return str;
        }
        return xVar.AX();
    }

    public static boolean gH(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return a.ga(((h) g.h(h.class)).Ff().Xv(str).field_type);
    }

    public static boolean gI(String str) {
        if (bi.oN(str)) {
            return false;
        }
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv == null) {
            return false;
        }
        return x.DG(Xv.field_verifyFlag);
    }

    public static boolean gN(int i) {
        return x.DG(i);
    }

    public static void e(x xVar) {
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (!(Xv == null || bi.oN(Xv.field_username))) {
            ag xVar2 = Xv;
        }
        xVar2.At();
        t(xVar2);
    }

    public static void q(String str, boolean z) {
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv != null && !bi.oN(Xv.field_username)) {
            if (z) {
                Xv.AC();
            } else {
                Xv.AD();
            }
            s(Xv);
        }
    }

    public static void f(x xVar) {
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (!(Xv == null || bi.oN(Xv.field_username))) {
            ag xVar2 = Xv;
        }
        xVar2.Ar();
        t(xVar2);
    }

    public static void g(x xVar) {
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (!(Xv == null || bi.oN(Xv.field_username))) {
            ag xVar2 = Xv;
        }
        xVar2.As();
        t(xVar2);
    }

    public static void h(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.Ap();
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).oq(xVar.field_username);
        }
        t(xVar22);
    }

    public static void i(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.Aq();
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).or(xVar.field_username);
        }
        t(xVar22);
        ak XF = ((h) g.h(h.class)).Fk().XF(xVar.field_username);
        if (XF != null && "@blacklist".equals(XF.field_parentRef)) {
            ((h) g.h(h.class)).Fk().d(new String[]{XF.field_username}, "");
        }
    }

    public static void j(x xVar) {
        Assert.assertTrue(xVar != null);
        x Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            Xv = xVar;
        }
        Xv.AC();
        Xv.ex(xVar.Ak());
        s(Xv);
    }

    public static void k(x xVar) {
        Assert.assertTrue(xVar != null);
        x Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            Xv = xVar;
        }
        Xv.AD();
        Xv.ex(xVar.Ak());
        s(Xv);
    }

    public static void l(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.Ay();
        xVar22.ex(xVar.Ak());
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).os(xVar.field_username);
        }
        t(xVar22);
    }

    public static void m(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.Az();
        xVar22.ex(xVar.Ak());
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).ot(xVar.field_username);
        }
        t(xVar22);
    }

    public static void r(String str, boolean z) {
        Assert.assertTrue(!bi.oN(str));
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv != null && !bi.oN(Xv.field_username)) {
            Xv.setType(Xv.field_type | 2048);
            if (x.Xg(str)) {
                ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).oo(str);
            }
            t(Xv);
            if (z) {
                ((h) g.h(h.class)).Fk().XK(str);
            }
        }
    }

    public static void gJ(String str) {
        ae XF = ((h) g.h(h.class)).Fk().XF(str);
        Object obj = null;
        if (XF == null) {
            XF = new ae();
            XF.cjn();
            obj = 1;
            XF.setUsername(str);
        }
        XF.aj(System.currentTimeMillis());
        if (obj != null) {
            ((h) g.h(h.class)).Fk().d(XF);
        } else {
            ((h) g.h(h.class)).Fk().a(XF, str);
        }
    }

    public static void s(String str, boolean z) {
        Assert.assertTrue(!bi.oN(str));
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv != null && !bi.oN(Xv.field_username)) {
            Xv.setType(Xv.field_type & -2049);
            if (x.Xg(str)) {
                ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).op(str);
            }
            t(Xv);
            if (z) {
                ((h) g.h(h.class)).Fk().XL(str);
            }
        }
    }

    public static void n(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.AA();
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).ou(xVar.field_username);
        }
        t(xVar22);
    }

    public static void o(x xVar) {
        x xVar2;
        Assert.assertTrue(xVar != null);
        ag Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        if (Xv == null || bi.oN(Xv.field_username)) {
            xVar2 = xVar;
        } else {
            ag xVar22 = Xv;
        }
        xVar22.AB();
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).ov(xVar.field_username);
        }
        t(xVar22);
    }

    public static void p(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", xVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) xVar.gKO) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        xVar.An();
        ((h) g.h(h.class)).Ff().a(xVar.field_username, xVar);
    }

    public static void q(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gKO) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.An();
        ((h) g.h(h.class)).Ff().a(xVar.field_username, xVar);
        t(xVar);
    }

    public static void b(x xVar, String str) {
        x Xv = ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        boolean z = (Xv == null || str == null) ? false : true;
        Assert.assertTrue(z);
        Xv.da(str);
        if (x.Xg(xVar.field_username)) {
            ((com.tencent.mm.openim.a.a) g.h(com.tencent.mm.openim.a.a.class)).az(xVar.field_username, str);
        }
        t(Xv);
    }

    public static void r(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gKO) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.AU();
        t(xVar);
    }

    private static void s(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gKO) == 0) {
            ((h) g.h(h.class)).Ff().T(xVar);
            ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        }
        ((h) g.h(h.class)).Ff().a(xVar.field_username, xVar);
        com.tencent.mm.bp.a asr = new asr();
        asr.wGI = xVar.field_username;
        if (xVar.AR()) {
            asr.wGU = 1;
        } else {
            asr.wGU = 2;
        }
        ((h) g.h(h.class)).Fe().b(new e.a(52, asr));
    }

    public static void t(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gKO) == 0) {
            ((h) g.h(h.class)).Ff().T(xVar);
            ((h) g.h(h.class)).Ff().Xv(xVar.field_username);
        }
        ((h) g.h(h.class)).Ff().a(xVar.field_username, xVar);
        if (!x.Xg(xVar.field_username)) {
            u(xVar);
        }
    }

    public static void u(x xVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", xVar.field_username, xVar.field_conRemark, Integer.valueOf(xVar.field_type));
        com.tencent.mm.bp.a asc = new asc();
        asc.wfM = new bet().Vf(bi.oM(xVar.field_username));
        asc.wzM = new bet().Vf(bi.oM(xVar.field_nickname));
        asc.wfA = new bet().Vf(bi.oM(xVar.vX()));
        asc.wfB = new bet().Vf(bi.oM(xVar.vY()));
        asc.hxe = xVar.fXa;
        asc.weQ = 561023;
        asc.weR = xVar.field_type;
        asc.wFS = new bet().Vf(bi.oM(xVar.field_conRemark));
        asc.wFT = new bet().Vf(bi.oM(xVar.field_conRemarkPYShort));
        asc.wFU = new bet().Vf(bi.oM(xVar.field_conRemarkPYFull));
        asc.weW = xVar.fXf;
        asc.wGn = new bet().Vf(bi.oM(xVar.field_domainList));
        asc.wfa = xVar.fXi;
        asc.hxi = xVar.fXj;
        asc.hxh = bi.oM(xVar.signature);
        asc.hxg = bi.oM(xVar.getCityCode());
        asc.hxf = bi.oM(xVar.ciR());
        asc.wCs = bi.oM(xVar.fXo);
        asc.wCu = xVar.field_weiboFlag;
        asc.wGj = 0;
        asc.vNQ = new bes();
        asc.hxn = bi.oM(xVar.getCountryCode());
        ((h) g.h(h.class)).Fe().b(new e.a(2, asc));
    }

    public static void gK(String str) {
        if (!bi.oN(str)) {
            x Xv = ((h) g.h(h.class)).Ff().Xv(str);
            if (Xv != null) {
                Xv.Al();
                ((h) g.h(h.class)).Ff().a(str, Xv);
            }
        }
    }

    public static int[] b(String str, String str2, List<String> list, String str3) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).Ff().b(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((h) g.h(h.class)).Ff().c(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] C(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cV = ((h) g.h(h.class)).Ff().cV(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (cV.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] cW = ((h) g.h(h.class)).Ff().cW(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cW == null) {
            return null;
        }
        Assert.assertTrue(cV.length == cW.length);
        int[] iArr = new int[cW.length];
        int i2 = 0;
        int i3 = 0;
        while (i < cV.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += cW[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        int i = 0;
        int[] b = ((h) g.h(h.class)).Ff().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            return null;
        }
        int[] c = ((h) g.h(h.class)).Ff().c(str, str2, strArr, (List) list);
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).Ff().b(str, str2, strArr, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr2[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr2[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr2[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr2;
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) g.h(h.class)).Ff().b(str, str2, str3, (List) list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr;
    }

    public static String[] D(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cV = ((h) g.h(h.class)).Ff().cV(list);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cV.length <= 0) {
            return null;
        }
        String[] strArr = new String[cV.length];
        for (int i2 : cV) {
            int i22;
            char c = (char) i22;
            if (c == '{') {
                i22 = i + 1;
                strArr[i] = "#";
            } else if (c == ' ') {
                i22 = i + 1;
                strArr[i] = "$";
            } else {
                i22 = i + 1;
                strArr[i] = String.valueOf(c);
            }
            i = i22;
        }
        return strArr;
    }

    public static boolean gL(String str) {
        return str != null ? str.equalsIgnoreCase("qqmail") : false;
    }

    public static boolean gM(String str) {
        return str != null ? str.equalsIgnoreCase("fmessage") : false;
    }

    public static boolean gN(String str) {
        return str != null ? str.equalsIgnoreCase("tmessage") : false;
    }

    public static boolean gO(String str) {
        return str != null ? str.equalsIgnoreCase("floatbottle") : false;
    }

    public static boolean gP(String str) {
        return str != null ? str.equalsIgnoreCase("qmessage") : false;
    }

    public static boolean gQ(String str) {
        return str != null ? str.equalsIgnoreCase("facebookapp") : false;
    }

    public static boolean gR(String str) {
        return str != null ? str.equalsIgnoreCase("masssendapp") : false;
    }

    public static boolean GK() {
        return false;
    }

    public static boolean gS(String str) {
        return str != null ? str.equalsIgnoreCase("feedsapp") : false;
    }

    public static boolean gT(String str) {
        return "qqsync".equalsIgnoreCase(str);
    }

    public static boolean gU(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773");
        } else {
            return false;
        }
    }

    public static boolean gV(String str) {
        return str != null ? str.equalsIgnoreCase("lbsapp") : false;
    }

    public static boolean gW(String str) {
        return str != null ? str.equalsIgnoreCase("shakeapp") : false;
    }

    public static boolean gX(String str) {
        return str != null ? str.equalsIgnoreCase("medianote") : false;
    }

    public static boolean gY(String str) {
        return str != null ? str.equalsIgnoreCase("newsapp") : false;
    }

    public static boolean gZ(String str) {
        return str != null ? str.equalsIgnoreCase("voipapp") : false;
    }

    public static boolean ha(String str) {
        return str != null ? str.equalsIgnoreCase("voicevoipapp") : false;
    }

    public static boolean hb(String str) {
        return str != null ? str.equalsIgnoreCase("voiceinputapp") : false;
    }

    public static boolean hc(String str) {
        return str != null ? str.equalsIgnoreCase("linkedinplugin") : false;
    }

    public static boolean hd(String str) {
        return he(str);
    }

    public static boolean he(String str) {
        return str != null ? str.equalsIgnoreCase("gh_22b87fa7cb3c") : false;
    }

    public static boolean hf(String str) {
        return str != null ? str.equalsIgnoreCase("blogapp") : false;
    }

    public static boolean hg(String str) {
        return str != null ? str.equalsIgnoreCase("officialaccounts") : false;
    }

    public static boolean hh(String str) {
        return str != null ? str.equalsIgnoreCase("helper_entry") : false;
    }

    public static boolean hi(String str) {
        return str != null ? str.equalsIgnoreCase("qqfriend") : false;
    }

    public static boolean hj(String str) {
        return "filehelper".equalsIgnoreCase(str);
    }

    public static boolean hk(String str) {
        return str != null ? str.equalsIgnoreCase("pc_share") : false;
    }

    public static boolean hl(String str) {
        return str != null ? str.equalsIgnoreCase("notifymessage") : false;
    }

    public static boolean hm(String str) {
        return str != null ? str.equalsIgnoreCase("notification_messages") : false;
    }

    public static boolean hn(String str) {
        if (ho(str) || hq(str) || hg(str) || hh(str)) {
            return true;
        }
        return false;
    }

    public static boolean ho(String str) {
        g.Dr();
        String str2 = (String) g.Dq().Db().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            return false;
        }
        return true;
    }

    public static boolean hp(String str) {
        return str != null ? str.equalsIgnoreCase("appbrandcustomerservicemsg") : false;
    }

    public static boolean hq(String str) {
        for (String equalsIgnoreCase : hhb) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hr(String str) {
        if (hq(str) || x.Xf(str) || x.Xd(str) || x.gB(str)) {
            return true;
        }
        return false;
    }

    public static int hs(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.utils.BlockUtils.getNextBlock(BlockUtils.java:289)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:131)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:642)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:647)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:647)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:647)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r1 = 1;
        r0 = com.tencent.mm.sdk.platformtools.bi.oM(r3);
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0021;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        junit.framework.Assert.assertTrue(r0);
        r0 = r3.trim();
        r0 = r0.toLowerCase();
        r2 = "@chatroom";
        r2 = r0.endsWith(r2);
        if (r2 == 0) goto L_0x0023;
    L_0x0020:
        return r1;
    L_0x0021:
        r0 = 0;
        goto L_0x000c;
    L_0x0023:
        r2 = com.tencent.mm.storage.x.Xd(r0);
        if (r2 == 0) goto L_0x002c;
    L_0x0029:
        r1 = 11;
        goto L_0x0020;
    L_0x002c:
        r2 = com.tencent.mm.storage.x.Xf(r0);
        if (r2 == 0) goto L_0x0035;
    L_0x0032:
        r1 = 36;
        goto L_0x0020;
    L_0x0035:
        r0 = com.tencent.mm.storage.x.gB(r0);
        if (r0 == 0) goto L_0x0020;
    L_0x003b:
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.y.s.hs(java.lang.String):int");
    }

    public static int ht(String str) {
        Assert.assertTrue(bi.oM(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 3;
        }
        if (x.Xd(toLowerCase)) {
            return 13;
        }
        if (x.Xf(toLowerCase)) {
            return 39;
        }
        if (x.gB(toLowerCase)) {
            return 3;
        }
        if (toLowerCase.contains("@")) {
            return 3;
        }
        return 3;
    }

    public static boolean hu(String str) {
        if (((h) g.h(h.class)).Ff().Xv(str).fXi != 1) {
            return false;
        }
        return true;
    }

    public static boolean hv(String str) {
        x Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv == null || !Xv.AP()) {
            return false;
        }
        return true;
    }

    public static boolean hw(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            return true;
        }
        return false;
    }

    public static String hx(String str) {
        if (hw(str)) {
            return str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
        }
        return "";
    }

    public static boolean v(x xVar) {
        return (xVar.field_weiboFlag & 1) != 0;
    }

    public static boolean GL() {
        if (!q.GF()) {
            return false;
        }
        bc FE = ((h) g.h(h.class)).Fn().FE("@t.qq.com");
        if (FE == null || bi.oN(FE.name)) {
            return false;
        }
        return true;
    }

    public static boolean GM() {
        if (!q.GF()) {
            return false;
        }
        bc FE = ((h) g.h(h.class)).Fn().FE("@t.qq.com");
        if (FE == null || bi.oM(FE.name).length() == 0) {
            return false;
        }
        return true;
    }

    public static List<x> GN() {
        List<x> linkedList = new LinkedList();
        Cursor cjd = ((h) g.h(h.class)).Ff().cjd();
        if (cjd.getCount() == 0) {
            cjd.close();
            return linkedList;
        }
        cjd.moveToFirst();
        do {
            x xVar = new x();
            xVar.b(cjd);
            linkedList.add(xVar);
        } while (cjd.moveToNext());
        cjd.close();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        return linkedList;
    }

    public static List<String> GO() {
        List<String> linkedList = new LinkedList();
        Cursor cjb = ((h) g.h(h.class)).Ff().cjb();
        if (cjb.getCount() == 0) {
            cjb.close();
            return linkedList;
        }
        cjb.moveToFirst();
        do {
            ag xVar = new x();
            xVar.b(cjb);
            linkedList.add(xVar.field_username);
        } while (cjb.moveToNext());
        cjb.close();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        return linkedList;
    }

    public static boolean a(ae aeVar) {
        String str = aeVar.field_username;
        if (hq(str) || ho(str) || hg(str) || hh(str) || aeVar.field_conversationTime == -1) {
            return false;
        }
        if (gI(str)) {
            return true;
        }
        return true;
    }

    public static boolean b(ae aeVar) {
        String str = aeVar.field_username;
        if (hg(str) || hp(str)) {
            return false;
        }
        return true;
    }

    public static int GP() {
        return ((h) g.h(h.class)).Ff().b(hhb, q.FY(), "weixin", "helper_entry", "filehelper");
    }

    private static String d(String str, String[] strArr) {
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            } else if ("@openim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@openim'";
            }
        }
        return str2 + " ) ";
    }
}
