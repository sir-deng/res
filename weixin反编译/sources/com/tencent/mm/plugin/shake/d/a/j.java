package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.d.a.m.f;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean oCT = false;
    public static j qvX;
    private boolean fob = false;
    public a qvW = new a();
    private long qvY;

    static /* synthetic */ boolean a(j jVar, String str) {
        List arrayList = new ArrayList();
        e JQ = e.JQ(str);
        if (JQ == null || JQ.hPT == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse url fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parse url: link=" + JQ.hPT + ", title=" + JQ.title + ", thumburl=" + JQ.thumbUrl);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        f JR = f.JR(str);
        List arrayList = new ArrayList();
        if (JR == null || JR.userName == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parse user: username=" + JR.userName + ", nickname=" + JR.bgo + ", showchat=" + JR.qwe);
        d dVar = new d();
        dVar.field_username = JR.userName;
        dVar.field_nickname = JR.bgo;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = JR.qwe;
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(j jVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeMusicMgr";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            jVar.e(arrayList, 2);
            return false;
        }
        a JT = c.JT(str);
        if (JT == null) {
            x.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
            jVar.e(arrayList, 4);
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
            x.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + bsc.field_reserved2);
            m.bsm().wr(bsc.field_shakeItemID);
        }
        m.bsm().a(dVar, true);
        jVar.e(arrayList, 1);
        x.d("Micromsg.ShakeMusicMgr", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        List arrayList = new ArrayList();
        m.b JN = m.b.JN(str);
        if (JN == null || JN.qwc == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + JN.qwc + ", title=" + JN.title + ", thumbUrl=" + JN.thumbUrl);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(j jVar, String str) {
        List arrayList = new ArrayList();
        m.c JO = m.c.JO(str);
        if (JO == null || JO.id == null) {
            x.w("Micromsg.ShakeMusicMgr", "parse product fail");
            jVar.e(arrayList, 4);
            return false;
        }
        x.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + JO.id + ", title=" + JO.title + ", thumbUrl=" + JO.thumbUrl);
        d dVar = new d();
        dVar.field_username = JO.id;
        dVar.field_nickname = JO.title;
        dVar.field_sns_bgurl = JO.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        m.bsm().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    public static j a(l.a aVar) {
        if (qvX == null || qvX.qtT == null) {
            qvX = new j(aVar);
        }
        return qvX;
    }

    private j(l.a aVar) {
        super(aVar);
    }

    public final void start() {
        if (this.qtT == null) {
            x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        this.qvY = System.currentTimeMillis();
        this.qvW.a(367, new a.a() {
            public final void b(bek bek, long j, boolean z) {
                if (j.this.qtT == null) {
                    x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                    return;
                }
                bjd bjd = (bjd) bek;
                if (bjd == null) {
                    x.w("Micromsg.ShakeMusicMgr", "resp null & return");
                    j.this.e(new ArrayList(), 4);
                } else if (bjd.wTl == 1) {
                    long currentTimeMillis;
                    if (j > j.this.qvY) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - j.this.qvY;
                    }
                    if (bjd != null && !bi.oN(bjd.wTn)) {
                        boolean a;
                        x.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", Integer.valueOf(bjd.wTm), bjd.wTn);
                        String str = bjd.wTn;
                        if (str != null) {
                            str = str.trim();
                        }
                        switch (bjd.wTm) {
                            case 0:
                                a = j.a(j.this, str);
                                break;
                            case 1:
                                a = j.b(j.this, str);
                                break;
                            case 2:
                                a = j.c(j.this, str);
                                break;
                            case 3:
                                a = j.d(j.this, str);
                                break;
                            case 4:
                                a = j.e(j.this, str);
                                break;
                            default:
                                x.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + bjd.wTm);
                                j.this.e(new ArrayList(), 4);
                                a = false;
                                break;
                        }
                        if (a) {
                            g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - j.this.qvY)));
                            g.pWK.h(835, 0);
                            return;
                        }
                        g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis));
                        g.pWK.h(835, 4);
                    } else if (z) {
                        j.this.e(new ArrayList(), 4);
                        g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis));
                        g.pWK.h(835, 3);
                    } else {
                        j.this.e(new ArrayList(), 4);
                        g.pWK.h(10987, Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis));
                        g.pWK.h(835, 2);
                    }
                } else {
                    List arrayList = new ArrayList();
                    if (bjd != null) {
                        d dVar = new d();
                        if (!(bjd.wTh == null || bjd.wTh.wRm == null)) {
                            dVar.field_username = bjd.wTh.wRm.cec();
                        }
                        if (!(bjd.wTg == null || bjd.wTg.wRm == null)) {
                            dVar.field_nickname = bjd.wTg.wRm.cec();
                        }
                        if (!(bjd.wTh == null || bjd.wTh.wRm == null)) {
                            dVar.field_distance = bjd.wTh.wRm.cec();
                        }
                        if (!(bjd.wuh == null || bjd.wuh.wRm == null)) {
                            dVar.field_sns_bgurl = bjd.wuh.wRm.cec();
                        }
                        dVar.field_type = 4;
                        dVar.field_insertBatch = 1;
                        try {
                            dVar.field_lvbuffer = bjd.toByteArray();
                        } catch (IOException e) {
                            x.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", e.getLocalizedMessage());
                        }
                        m.bsm().a(dVar, true);
                        arrayList.add(dVar);
                    }
                    j.this.qtT.d(arrayList, j);
                }
            }
        });
    }

    public final void init() {
        if (!oCT) {
            if (this.qvW.bsM()) {
                oCT = true;
            } else {
                x.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void brZ() {
        this.qvW.vj();
        super.brZ();
    }

    public final void resume() {
    }

    private void e(List<d> list, long j) {
        if (this.qtT != null) {
            this.qtT.d(list, j);
        }
    }
}
