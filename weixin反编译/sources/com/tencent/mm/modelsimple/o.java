package com.tencent.mm.modelsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.a;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class o extends k implements com.tencent.mm.network.k {
    private static Map<String, Long> hOK = new HashMap();
    private static Map<String, String> hOL;
    private boolean fyj = false;
    private e gLE;
    private final b hOJ;
    private c<a> hOM;

    static /* synthetic */ void av(String str, String str2) {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!bi.oN(string)) {
            string = string + ";";
        }
        string = string + str + "," + bi.Wx();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        hOL.put(str, str2);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, ""));
    }

    public o(int i, boolean z) {
        b.a aVar = new b.a();
        aVar.hnT = new abv();
        aVar.hnU = new abw();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.hnS = 775;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hOJ = aVar.Kf();
        this.hOJ.fKU = 1;
        ((abv) this.hOJ.hnQ.hnY).fyi = i;
        this.fyj = z;
        RV();
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", Integer.valueOf(i), Boolean.valueOf(this.fyj), bi.chl());
    }

    public final int getType() {
        return 775;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        abv abv = (abv) this.hOJ.hnQ.hnY;
        long a = bi.a((Long) hOK.get(abv.fyi), 0);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", Integer.valueOf(abv.fyi), Long.valueOf(a), hOK);
        if (a == 0 || bi.bB(a) >= 1800000) {
            String aD = bi.aD((String) hOL.get(abv.fyi), "");
            if (bi.oN(aD)) {
                this.gLE = eVar2;
                return a(eVar, this.hOJ, this);
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", Integer.valueOf(abv.fyi), aD);
            H(aD, false);
            return -1;
        }
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", Integer.valueOf(abv.fyi));
        return -1;
    }

    private void H(final String str, final boolean z) {
        as.Dt().F(new Runnable() {
            public final void run() {
                int i;
                String str = "MicroMsg.NetSceneGetDisasterInfo";
                String str2 = "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]";
                Object[] objArr = new Object[2];
                if (str == null) {
                    i = -1;
                } else {
                    i = str.length();
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                com.tencent.mm.sdk.b.b ahVar = new ah();
                ahVar.fpb.type = 5;
                ahVar.fpb.fpd = str;
                com.tencent.mm.sdk.b.a.xmy.m(ahVar);
                str = ahVar.fpc.fpi;
                int i2 = ahVar.fpc.position;
                int i3 = ahVar.fpc.fpf;
                x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(o.this.fyj), o.hOK);
                if (i2 == 1 && i3 == 6) {
                    if (z) {
                        o.av(str, str);
                    }
                    if (o.this.fyj) {
                        str2 = ahVar.fpc.desc;
                        final String str3 = ahVar.fpc.url;
                        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", Boolean.valueOf(ad.cgc()));
                        if (o.this.hOM == null) {
                            o.this.hOM = new c<a>() {
                                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                    com.tencent.mm.sdk.b.a.xmy.c(o.this.hOM);
                                    o.this.hOM = null;
                                    x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(ad.cgc()));
                                    com.tencent.mm.sdk.platformtools.ah.h(new Runnable() {
                                        public final void run() {
                                            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", Boolean.valueOf(ad.cgc()));
                                            Intent intent = new Intent();
                                            intent.putExtra("key_disaster_content", str2);
                                            intent.putExtra("key_disaster_url", str3);
                                            intent.setClass(ad.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                            ad.getContext().startActivity(intent);
                                        }
                                    }, 5000);
                                    return true;
                                }
                            };
                        }
                        com.tencent.mm.sdk.b.a.xmy.b(o.this.hOM);
                    } else {
                        com.tencent.mm.sdk.b.b izVar = new iz();
                        izVar.fAw.content = ahVar.fpc.desc;
                        izVar.fAw.url = ahVar.fpc.url;
                        com.tencent.mm.sdk.b.a.xmy.m(izVar);
                    }
                    o.hOK.put(str, Long.valueOf(bi.Wz()));
                } else if (i3 == 2) {
                    if (z) {
                        o.av(str, str);
                    }
                    o.hOK.put(str, Long.valueOf(bi.Wz()));
                }
            }
        });
    }

    private synchronized void RV() {
        if (hOL == null) {
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            hOL = new HashMap();
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!bi.oN(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    String str = "";
                    for (String string2 : split) {
                        String[] split2 = string2.split(",");
                        try {
                            if (bi.getLong(split2[0], 0) > 0) {
                                if (bi.bz(bi.getLong(split2[1], 0)) < 86400) {
                                    String string3 = sharedPreferences.getString(split2[0], "");
                                    if (!bi.oN(string3)) {
                                        str = str + split2[0] + "," + split2[1] + ";";
                                        hOL.put(split2[0], string3);
                                    }
                                } else {
                                    edit.remove(split2[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", e.getMessage());
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", str).commit();
                    x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", str, hOK);
                }
            }
            x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", hOL);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            H(((abw) this.hOJ.hnR.hnY).content, true);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
