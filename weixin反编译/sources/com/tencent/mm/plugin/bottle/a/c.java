package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.k;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;

public final class c {
    private static int kGu = 1;
    private static int kGv = 1;

    public static int asf() {
        return kGu;
    }

    public static int asg() {
        return kGv;
    }

    public static void ny(int i) {
        kGu = i;
    }

    public static void nz(int i) {
        kGv = i;
    }

    public static int ash() {
        return k.FU();
    }

    public static int nA(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 34;
            case 4:
                return 43;
            default:
                return -1;
        }
    }

    public static String wt(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static void wu(String str) {
        String[] strArr = null;
        a.ihO.un();
        as.Hm();
        if (com.tencent.mm.y.c.Fh().Fs(str) == 1) {
            as.Hm();
            cg Fd = com.tencent.mm.y.c.Fh().Fd(str);
            if (Fd != null && Fd.field_talker.equals(str)) {
                String wt = wt(str);
                if (!bi.oN(wt)) {
                    a aVar;
                    Cursor a = i.asn().hiZ.a("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bi.oL(wt) + "\"", null, 0);
                    if (a == null) {
                        aVar = null;
                    } else {
                        if (a.moveToFirst()) {
                            strArr = new a();
                            strArr.kGo = a.getString(0);
                            strArr.kGp = a.getInt(1);
                            strArr.kGq = a.getString(2);
                            strArr.kGr = a.getInt(3);
                            strArr.msgType = a.getInt(4);
                            strArr.kGs = a.getInt(5);
                            strArr.content = a.getString(6);
                            strArr.kGt = a.getLong(7);
                            strArr.hiV = a.getInt(8);
                            strArr.hxZ = a.getInt(9);
                            strArr.hiX = a.getString(10);
                            strArr.hiY = a.getString(11);
                        }
                        a.close();
                        aVar = strArr;
                    }
                    if (aVar != null && aVar.ase().equals(wt) && aVar.kGr == 1) {
                        au auVar = new au();
                        auVar.dU(str);
                        auVar.aq(Fd.field_createTime <= aVar.kGt ? Fd.field_createTime - 1 : aVar.kGt);
                        auVar.setType(nA(aVar.msgType));
                        auVar.eR(2);
                        auVar.eS(1);
                        if (auVar.getType() == 34) {
                            auVar.setContent(n.b(q.FY(), (long) aVar.kGs, false));
                            String str2 = aVar.wl() + bi.Wy();
                            if (com.tencent.mm.sdk.platformtools.k.fv(com.tencent.mm.modelvoice.q.getFullPath(aVar.wl()), com.tencent.mm.modelvoice.q.getFullPath(str2))) {
                                auVar.dV(str2);
                            } else {
                                x.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.wl());
                                return;
                            }
                        }
                        auVar.setContent(aVar.wl());
                        as.Hm();
                        com.tencent.mm.y.c.Fh().Q(auVar);
                    }
                }
            }
        }
    }

    public static void asi() {
        String[] strArr;
        b asn = i.asn();
        Cursor a = asn.hiZ.a("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + (bi.Wy() - 7776000000L), null, 0);
        int count = a.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                if (a.getInt(1) == 3) {
                    strArr[i] = a.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        a.close();
        if (count > 0) {
            asn.hiZ.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                x.d("MicroMsg.BottleLogic", "delete path:" + com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                if (!bi.oN(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]))) {
                    b.deleteFile(com.tencent.mm.modelvoice.q.getFullPath(strArr[i2]));
                }
            }
        }
    }

    public static String a(Context context, com.tencent.mm.storage.x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dNk);
        }
        if (!RegionCodeDecoder.Yl(xVar.getCountryCode())) {
            return context.getString(R.l.dNk);
        }
        String city = xVar.getCity();
        if (!bi.oN(city)) {
            return city;
        }
        city = r.gy(xVar.getProvince());
        if (!bi.oN(city)) {
            return city;
        }
        RegionCodeDecoder.ckE();
        return RegionCodeDecoder.getLocName(xVar.getCountryCode());
    }

    public static String b(Context context, com.tencent.mm.storage.x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dNk);
        }
        String gy = r.gy(xVar.getProvince());
        if (RegionCodeDecoder.Yl(xVar.getCountryCode())) {
            if (bi.oN(xVar.getCity())) {
                StringBuilder stringBuilder = new StringBuilder();
                RegionCodeDecoder.ckE();
                gy = stringBuilder.append(RegionCodeDecoder.getLocName(xVar.getCountryCode())).append(gy).toString();
            } else {
                gy = gy + xVar.getCity();
            }
        }
        return bi.oN(gy) ? context.getString(R.l.dNk) : gy;
    }
}
