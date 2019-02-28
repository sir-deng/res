package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    private static boolean bgH = false;
    private static boolean oCT = false;
    private Context context;
    private boolean fob = false;
    private a qvW = new a();
    private long qvY;

    static /* synthetic */ void JL(String str) {
        c cVar;
        String[] strArr = null;
        if (bi.oN(str)) {
            cVar = null;
        } else {
            c cVar2;
            Map y = bj.y(str, "tvinfo");
            if (y != null) {
                String str2 = (String) y.get(".tvinfo.username");
                if (bi.oN(str2)) {
                    cVar = null;
                } else {
                    c nVar = new n();
                    nVar.field_username = str2;
                    nVar.field_iconurl = bi.oM((String) y.get(".tvinfo.iconurl"));
                    nVar.field_title = bi.oM((String) y.get(".tvinfo.title"));
                    nVar.field_deeplink = bi.oM((String) y.get(".tvinfo.deeplinkjumpurl"));
                    nVar.field_createtime = bi.getLong((String) y.get(".tvinfo.createtime"), 0);
                    cVar2 = nVar;
                }
            } else {
                cVar2 = null;
            }
            cVar = cVar2;
        }
        if (cVar != null) {
            o bso = m.bso();
            Cursor a = bso.gLA.a("shaketvhistory", null, "username=?", new String[]{cVar.field_username}, null, null, null, 2);
            if (a.moveToFirst()) {
                strArr = new n();
                strArr.b(a);
                a.close();
            } else {
                x.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:" + r10);
                a.close();
            }
            if (strArr != null) {
                x.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                bso = m.bso();
                if (bi.oN(cVar.field_username)) {
                    x.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    return;
                }
                bso.gLA.update("shaketvhistory", cVar.vP(), "username=?", new String[]{cVar.field_username});
                return;
            }
            x.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.bso().b(cVar);
        }
    }

    static /* synthetic */ boolean a(l lVar, String str) {
        List arrayList = new ArrayList();
        e JQ = e.JQ(str);
        if (JQ == null || JQ.hPT == null) {
            x.w("Micromsg.ShakeTVService", "parse url fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parse url: link=" + JQ.hPT + ", title=" + JQ.title + ", thumburl=" + JQ.thumbUrl);
        d dVar = new d();
        dVar.field_username = JQ.hPT;
        dVar.field_nickname = JQ.title;
        dVar.field_distance = JQ.fDP;
        dVar.field_sns_bgurl = JQ.thumbUrl;
        dVar.field_type = 7;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        f JR = f.JR(str);
        List arrayList = new ArrayList();
        if (JR == null || JR.userName == null) {
            x.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parse user: username=" + JR.userName + ", nickname=" + JR.bgo + ", showchat=" + JR.qwe);
        d dVar = new d();
        dVar.field_username = JR.userName;
        dVar.field_nickname = JR.bgo;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = JR.qwe;
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(l lVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeTVService";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            lVar.e(arrayList, 2);
            return false;
        }
        a JT = com.tencent.mm.plugin.shake.e.c.JT(str);
        if (JT == null) {
            x.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
            bgH = false;
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = bi.oM(JT.field_subtitle);
        dVar.field_nickname = bi.oM(JT.field_topic);
        dVar.field_distance = bi.oM(JT.field_title);
        if (JT.field_thumburl != null) {
            dVar.field_sns_bgurl = JT.field_thumburl;
        }
        dVar.field_type = 8;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        dVar.field_reserved2 = (int) bi.Wx();
        arrayList.add(dVar);
        d bsc = m.bsm().bsc();
        if (bsc.field_type == 8 && dVar.field_distance.equals(bsc.field_distance) && dVar.field_nickname.equals(bsc.field_nickname) && dVar.field_reserved2 - bsc.field_reserved2 < 1800) {
            x.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + bsc.field_reserved2);
            m.bsm().wr(bsc.field_shakeItemID);
        }
        m.bsm().a(dVar, true);
        lVar.e(arrayList, 1);
        x.d("Micromsg.ShakeTVService", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        List arrayList = new ArrayList();
        m.b JN = m.b.JN(str);
        if (JN == null || JN.qwc == null) {
            x.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + JN.qwc + ", title=" + JN.title + ", thumbUrl=" + JN.thumbUrl);
        d dVar = new d();
        dVar.field_username = JN.qwc;
        dVar.field_nickname = JN.title;
        dVar.field_sns_bgurl = JN.thumbUrl;
        dVar.field_distance = JN.pht;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(l lVar, String str) {
        List arrayList = new ArrayList();
        m.c JO = m.c.JO(str);
        if (JO == null || JO.id == null) {
            x.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + JO.id + ", title=" + JO.title + ", thumbUrl=" + JO.thumbUrl);
        d dVar = new d();
        dVar.field_username = JO.id;
        dVar.field_nickname = JO.title;
        dVar.field_sns_bgurl = JO.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        List arrayList = new ArrayList();
        m.d JP = m.d.JP(str);
        if (JP == null || bi.oN(JP.qwd)) {
            x.w("Micromsg.ShakeTVService", "parse TempSession fail");
            lVar.e(arrayList, 4);
            return false;
        }
        d dVar = new d();
        dVar.field_username = JP.qwd;
        dVar.field_nickname = JP.title;
        dVar.field_distance = JP.username;
        dVar.field_sns_bgurl = JP.thumbUrl;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean g(l lVar, String str) {
        List arrayList = new ArrayList();
        m.a JM = m.a.JM(str);
        if (JM != null) {
            d dVar = new d();
            dVar.field_username = JM.username;
            dVar.field_nickname = JM.title;
            dVar.field_reserved3 = JM.path;
            dVar.field_sns_bgurl = JM.thumbUrl;
            dVar.field_reserved2 = JM.version;
            dVar.field_type = 13;
            dVar.field_insertBatch = 1;
            dVar.field_lvbuffer = str.getBytes();
            m.bsm().a(dVar, true);
            arrayList.add(dVar);
            lVar.e(arrayList, 1);
            return true;
        }
        x.w("Micromsg.ShakeTVService", "parse appBrand fail");
        lVar.e(arrayList, 4);
        return false;
    }

    public l(Context context, com.tencent.mm.plugin.shake.b.l.a aVar) {
        super(aVar);
        this.context = context;
        bgH = false;
    }

    public final void start() {
        x.v("Micromsg.ShakeTVService", "hy: start shake tv!");
        if (this.qtT == null) {
            x.w("Micromsg.ShakeTVService", "shakeGetListener == null");
        } else if (this.context instanceof Activity) {
            bgH = true;
            this.qvY = System.currentTimeMillis();
            this.qvW.a(av.CTRL_INDEX, new a.a() {
                public final void b(bek bek, long j, boolean z) {
                    long currentTimeMillis;
                    x.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", Boolean.valueOf(z));
                    if (j > l.this.qvY) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - l.this.qvY;
                    }
                    if (bek != null && !bi.oN(((bjh) bek).vUQ)) {
                        boolean a;
                        bjh bjh = (bjh) bek;
                        x.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", Integer.valueOf(bjh.kzz), bjh.vUQ);
                        String str = null;
                        String str2 = null;
                        if (bjh.vUQ != null) {
                            bjh.vUQ = bjh.vUQ.trim();
                            int indexOf = bjh.vUQ.indexOf("<tvinfo>");
                            if (indexOf > 0) {
                                str = bjh.vUQ.substring(0, indexOf);
                                str2 = bjh.vUQ.substring(indexOf);
                            } else if (indexOf == 0) {
                                str2 = bjh.vUQ;
                            } else {
                                str = bjh.vUQ;
                            }
                        }
                        l.JL(str2);
                        switch (bjh.kzz) {
                            case 0:
                                a = l.a(l.this, str);
                                break;
                            case 1:
                                a = l.b(l.this, str);
                                break;
                            case 2:
                                a = l.c(l.this, str);
                                break;
                            case 3:
                                a = l.d(l.this, str);
                                break;
                            case 4:
                                a = l.e(l.this, str);
                                break;
                            case 5:
                                a = l.f(l.this, str);
                                break;
                            case 6:
                                a = l.g(l.this, str);
                                break;
                            default:
                                x.w("Micromsg.ShakeTVService", "parse unknown type:" + bjh.kzz);
                                l.this.e(new ArrayList(), 4);
                                a = false;
                                break;
                        }
                        if (a) {
                            g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - l.this.qvY)));
                            g.pWK.h(835, 0);
                        } else {
                            g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                            g.pWK.h(835, 4);
                        }
                    } else if (z) {
                        l.this.e(new ArrayList(), 4);
                        g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                        g.pWK.h(835, 3);
                    } else {
                        l.this.e(new ArrayList(), 4);
                        g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                        g.pWK.h(835, 2);
                    }
                    l.bgH = false;
                }
            });
            g.pWK.h(835, 5);
        } else {
            x.e("Micromsg.ShakeTVService", "context not an Activity");
            this.qtT.d(new ArrayList(), 0);
        }
    }

    public final void init() {
        if (!oCT) {
            if (this.qvW.bsM()) {
                oCT = true;
            } else {
                x.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void brZ() {
        super.brZ();
        this.qvW.vj();
        if (bgH) {
            long currentTimeMillis = System.currentTimeMillis() - this.qvY;
            x.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", Long.valueOf(currentTimeMillis), Boolean.valueOf(bgH));
            g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis));
            g.pWK.h(835, 1);
            bgH = false;
        }
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.qtT != null) {
            this.qtT.d(list, j);
        }
    }
}
