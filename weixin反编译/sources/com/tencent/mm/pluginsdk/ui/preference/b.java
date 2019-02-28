package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.be.f;
import com.tencent.mm.be.h;
import com.tencent.mm.be.j;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.fo;
import com.tencent.mm.f.b.cb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import junit.framework.Assert;

public final class b {
    public boolean fMC;
    public String fqG;
    public String hfQ;
    public long id;
    public String ppC;
    public int qxe;
    public String username;
    public String vzX;

    public static b a(Context context, f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        long j = fVar.xrR;
        boolean Tv = fVar.Tv();
        String str7 = fVar.field_talker;
        String str8 = fVar.field_msgContent;
        int i = fVar.field_type;
        int i2 = 0;
        if (i == 0) {
            a XY = a.XY(str8);
            str = XY.sfb;
            str2 = XY.fqG;
            str3 = XY.xHI;
            str4 = XY.xHJ;
            i2 = XY.scene;
            str5 = null;
        } else if (Tv) {
            d Yb = d.Yb(str8);
            str = Yb.sfb;
            str2 = Yb.fqG;
            str5 = Yb.content;
            if (Yb.xHY == 1) {
                str4 = null;
                str3 = null;
                str6 = Yb.xIa;
            } else {
                str4 = null;
                str3 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        b a = a(context, j, Tv, str7, str8, i, str, str2, str3, str4, str5, i2);
        a.vzX = str6;
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        b bVar = new b();
        bVar.id = j;
        bVar.fMC = !z;
        x.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i), str, Integer.valueOf(i2));
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.fqG = str4;
                switch (i2) {
                    case 4:
                        bVar.hfQ = context.getString(R.l.dRc);
                        break;
                    case 10:
                    case 11:
                        com.tencent.mm.sdk.b.b foVar = new fo();
                        foVar.fvM.fvJ = str5;
                        foVar.fvM.fvK = str6;
                        com.tencent.mm.sdk.b.a.xmy.m(foVar);
                        bVar.hfQ = context.getString(R.l.dRf, new Object[]{bi.aD(foVar.fvN.fvO, "")});
                        break;
                    case 31:
                        bVar.hfQ = context.getString(R.l.dRo);
                        break;
                    case 32:
                        bVar.hfQ = context.getString(R.l.dRi);
                        break;
                    case 58:
                    case 59:
                    case 60:
                        bVar.ppC = a.XY(str2).ppC;
                        bVar.hfQ = context.getString(R.l.dRd);
                        break;
                    default:
                        bVar.hfQ = context.getString(R.l.dRh);
                        break;
                }
            }
            x.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + str);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.fqG = str4;
            if (str7 == null || str7.trim().equals("")) {
                bVar.hfQ = context.getString(R.l.eit);
            } else {
                bVar.hfQ = str7;
            }
        } else {
            bVar.username = str;
            bVar.hfQ = str2;
        }
        return bVar;
    }

    public static b a(Context context, cb cbVar) {
        x.d("MicroMsg.FMessageProvider", "build lbs, talker = " + cbVar.field_sayhiuser + ", scene = " + cbVar.field_scene);
        b bVar = new b();
        bVar.id = cbVar.xrR;
        bVar.fMC = cbVar.field_isSend == 1;
        bVar.username = cbVar.field_sayhiuser;
        bVar.qxe = cbVar.field_scene;
        if (cbVar.field_isSend == 1) {
            bVar.hfQ = cbVar.field_content;
        } else {
            d Yb = d.Yb(cbVar.field_content);
            if (Yb.content == null || Yb.content.trim().equals("")) {
                bVar.hfQ = context.getString(R.l.dRq);
            } else {
                bVar.hfQ = Yb.content;
            }
            bVar.fqG = Yb.fqG;
        }
        return bVar;
    }

    public static b a(Context context, j jVar) {
        x.d("MicroMsg.FMessageProvider", "build shake, talker = " + jVar.field_talker + ", scene = " + jVar.field_scene);
        b bVar = new b();
        bVar.id = jVar.xrR;
        bVar.fMC = jVar.field_isSend == 1;
        bVar.username = jVar.field_sayhiuser;
        bVar.qxe = jVar.field_scene;
        if (jVar.field_isSend == 1) {
            bVar.hfQ = jVar.field_content;
        } else {
            d Yb = d.Yb(jVar.field_content);
            if (Yb.content == null || Yb.content.trim().equals("")) {
                bVar.hfQ = context.getString(R.l.dRq);
            } else {
                bVar.hfQ = Yb.content;
            }
            bVar.fqG = Yb.fqG;
        }
        return bVar;
    }

    public static b[] a(Context context, f[] fVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (fVarArr == null || fVarArr.length == 0 || fVarArr[0] == null) ? "null" : fVarArr[0].field_talker;
        x.d(str, stringBuilder.append(str2).toString());
        if (fVarArr == null || fVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            return null;
        }
        b[] bVarArr = new b[fVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, fVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, cb[] cbVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (cbVarArr == null || cbVarArr.length == 0 || cbVarArr[0] == null) ? "null" : cbVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (cbVarArr == null || cbVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            return null;
        }
        b[] bVarArr = new b[cbVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, cbVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, j[] jVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (jVarArr == null || jVarArr.length == 0 || jVarArr[0] == null) ? "null" : jVarArr[0].field_sayhiuser;
        x.d(str, stringBuilder.append(str2).toString());
        if (jVarArr == null || jVarArr.length == 0) {
            x.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            return null;
        }
        b[] bVarArr = new b[jVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, jVarArr[i]);
        }
        return bVarArr;
    }

    public static void aV(String str, int i) {
        f[] fVarArr;
        h[] hVarArr;
        b[] a;
        j[] jVarArr;
        if (i == 26 || i == 27 || i == 28 || i == 29) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is shake");
            j[] nj = l.TG().nj(str);
            fVarArr = null;
            hVarArr = null;
            a = a(ad.getContext(), nj);
            jVarArr = nj;
        } else if (i == 18) {
            x.d("MicroMsg.FMessageProvider", "initAddContent, scene is lbs");
            cb[] ne = l.TF().ne(str);
            fVarArr = null;
            cb[] hVarArr2 = ne;
            a = a(ad.getContext(), ne);
            jVarArr = null;
        } else {
            f[] mZ = l.TD().mZ(str);
            fVarArr = mZ;
            hVarArr2 = null;
            a = a(ad.getContext(), mZ);
            jVarArr = null;
        }
        if (a != null) {
            int i2 = 0;
            int length = a.length;
            int i3 = 0;
            while (i3 < length) {
                int i4;
                b bVar = a[i3];
                au auVar = new au();
                auVar.setContent(bVar.hfQ);
                int hs = s.hs(bVar.username);
                if (fVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(fVarArr[i2].field_createTime);
                } else if (hVarArr2 != null) {
                    i4 = i2 + 1;
                    auVar.aq(hVarArr2[i2].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i4 = i2 + 1;
                    auVar.aq(jVarArr[i2].field_createtime * 1000);
                } else {
                    i4 = i2;
                }
                auVar.dU(bVar.username);
                auVar.setType(hs);
                if (bVar.fMC) {
                    auVar.eR(2);
                    auVar.eS(1);
                } else {
                    auVar.eR(6);
                    auVar.eS(0);
                }
                as.Hm();
                long Q = c.Fh().Q(auVar);
                Assert.assertTrue(Q != -1);
                x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + Q);
                i3++;
                i2 = i4;
            }
            au auVar2 = new au();
            if (fVarArr != null) {
                auVar2.aq(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr2 != null) {
                auVar2.aq((hVarArr2[hVarArr2.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                auVar2.aq((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            auVar2.dU(str);
            auVar2.setContent(ad.getContext().getString(R.l.eRN));
            auVar2.setType(10000);
            auVar2.eR(6);
            auVar2.eS(0);
            as.Hm();
            x.i("MicroMsg.FMessageProvider", "new msg inserted to db , local id = " + c.Fh().Q(auVar2));
        }
    }

    public static com.tencent.mm.storage.x b(f fVar) {
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        if (fVar == null) {
            return xVar;
        }
        if (fVar.field_type == 0) {
            a XY = a.XY(fVar.field_msgContent);
            xVar = new com.tencent.mm.storage.x();
            xVar.setUsername(XY.sfb);
            xVar.cZ(XY.ggL);
            xVar.dc(XY.getDisplayName());
            xVar.dd(XY.hyF);
            xVar.de(XY.hyG);
            xVar.eD(XY.fXa);
            xVar.dq(XY.getProvince());
            xVar.dr(XY.getCity());
            xVar.dp(XY.signature);
            xVar.ez(XY.tth);
            xVar.du(XY.fXp);
            xVar.dD(XY.vzN);
            return xVar;
        }
        d Yb = d.Yb(fVar.field_msgContent);
        xVar = new com.tencent.mm.storage.x();
        xVar.setUsername(Yb.sfb);
        xVar.cZ(Yb.ggL);
        xVar.dc(Yb.fqG);
        xVar.dd(Yb.hyF);
        xVar.de(Yb.hyG);
        xVar.eD(Yb.fXa);
        xVar.dp(Yb.signature);
        xVar.dq(Yb.getProvince());
        xVar.dr(Yb.getCity());
        return xVar;
    }
}
