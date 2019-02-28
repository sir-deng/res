package com.tencent.mm.plugin.music.model;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.au.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.js;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.g.f;
import com.tencent.mm.plugin.music.model.g.k;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public final class e implements com.tencent.mm.ad.e {
    public int mode = 1;
    public int oPf;
    public List<String> oPg;
    public f oPh = new f();
    public k oPi = new k();
    com.tencent.mm.plugin.music.model.d.a oPj = new com.tencent.mm.plugin.music.model.d.a();
    com.tencent.mm.plugin.music.model.notification.b oPk = new com.tencent.mm.plugin.music.model.notification.b();
    public com.tencent.mm.plugin.music.model.e.b oPl;
    private com.tencent.mm.plugin.music.model.e.a oPm;
    private c oPn;
    public boolean oPo;
    Runnable oPp = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", Boolean.valueOf(e.this.bdT().Qy()), Boolean.valueOf(e.this.bdT().Qx()));
            if (e.this.bdT().Qy() && !r1) {
                e.this.bdT().stopPlay();
            }
        }
    };

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            List list;
            long currentTimeMillis = System.currentTimeMillis();
            e.this.oPo = true;
            ati bdV = e.this.bdV();
            List arrayList = new ArrayList();
            x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper.MusicType:%d", Integer.valueOf(bdV.wHt));
            com.tencent.mm.sdk.b.b jsVar;
            switch (bdV.wHt) {
                case 1:
                    jsVar = new js();
                    jsVar.fBo.action = -5;
                    com.tencent.mm.sdk.b.a.xmy.m(jsVar);
                    list = jsVar.fBp.fwA;
                    break;
                case 4:
                    jsVar = new js();
                    jsVar.fBo.action = -4;
                    com.tencent.mm.sdk.b.a.xmy.m(jsVar);
                    list = jsVar.fBp.fwA;
                    break;
                case 6:
                    jsVar = new fw();
                    jsVar.fwl.type = 18;
                    com.tencent.mm.sdk.b.a.xmy.m(jsVar);
                    list = jsVar.fwm.fwA;
                    break;
                case 8:
                    jsVar = new js();
                    jsVar.fBo.action = -6;
                    jsVar.fBo.fBq = bdV;
                    com.tencent.mm.sdk.b.a.xmy.m(jsVar);
                    list = jsVar.fBp.fwA;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ati ati = (ati) list.get(i);
                    if (ati == null) {
                        x.e("MicroMsg.Music.MusicPlayerManager", "wrapper is null, continue");
                    } else {
                        h.beg().x(ati);
                        arrayList.add(g.i(ati));
                    }
                }
            }
            x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask run time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            e.this.oPo = false;
            Runnable bVar = new b(e.this, (byte) 0);
            bVar.oPr = arrayList;
            ah.y(bVar);
        }
    }

    private class b implements Runnable {
        List<String> oPr;

        private b() {
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        public final void run() {
            String i = g.i(e.this.bdV());
            int i2 = e.this.oPf;
            int i3 = 0;
            for (int i4 = 0; i4 < this.oPr.size(); i4++) {
                if (((String) this.oPr.get(i4)).equals(i)) {
                    i2 = i4;
                    i3 = 1;
                }
            }
            if (i3 != 0) {
                int i5;
                for (i5 = i2 + 1; i5 < this.oPr.size(); i5++) {
                    e.this.oPg.add(this.oPr.get(i5));
                }
                for (i5 = 0; i5 < i2; i5++) {
                    e.this.oPg.add(this.oPr.get(i5));
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", Integer.valueOf(e.this.oPg.size()), Integer.valueOf(e.this.oPf));
                com.tencent.mm.sdk.b.b jtVar = new jt();
                jtVar.fBu.action = 5;
                com.tencent.mm.sdk.b.a.xmy.m(jtVar);
            }
        }
    }

    public e() {
        com.tencent.mm.plugin.music.model.notification.b bVar = this.oPk;
        x.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        bVar.jil = new com.tencent.mm.sdk.b.c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                jt jtVar = (jt) bVar;
                if (b.this.oRy == null) {
                    b.this.bfb();
                } else {
                    x.i("MicroMsg.Music.MMMusicNotificationHelper", "event.data.action:%d", Integer.valueOf(jtVar.fBu.action));
                    if (jtVar.fBu.fBq == null || !g.m(jtVar.fBu.fBq)) {
                        a bdU;
                        switch (jtVar.fBu.action) {
                            case 0:
                            case 1:
                            case 11:
                                if (b.this.oRy != null) {
                                    bdU = h.bef().bdU();
                                    if (bdU != null) {
                                        b.this.oRy.k(bdU);
                                        break;
                                    }
                                    x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                    break;
                                }
                                break;
                            case 2:
                                if (!(b.this.oRy == null || jtVar.fBu.fBx)) {
                                    b.this.oRy.stop();
                                    break;
                                }
                            case 3:
                                if (b.this.oRy != null) {
                                    bdU = h.bef().bdU();
                                    if (bdU != null) {
                                        b.this.oRy.l(bdU);
                                        break;
                                    }
                                    x.e("MicroMsg.Music.MMMusicNotificationHelper", "music is null, return");
                                    break;
                                }
                                break;
                            case 4:
                                if (b.this.oRy != null) {
                                    b.this.oRy.stop();
                                    break;
                                }
                                break;
                            case 7:
                                if (h.bef().mode == 1 && b.this.oRy != null) {
                                    MMMusicPlayerService mMMusicPlayerService = b.this.oRy;
                                    x.i("MicroMsg.Music.MMMusicPlayerService", "end");
                                    a aVar = mMMusicPlayerService.oRG;
                                    if (!aVar.isInit) {
                                        x.e("MicroMsg.Music.MMMusicNotification", "MMMusicNotification not init, close err");
                                    } else if (aVar.oRy == null) {
                                        x.e("MicroMsg.Music.MMMusicNotification", "mmMusicPlayerService is null, return");
                                    } else {
                                        x.i("MicroMsg.Music.MMMusicNotification", "end");
                                        ah.K(aVar.oRA);
                                        ah.h(aVar.oRA, 2000);
                                    }
                                    ah.K(mMMusicPlayerService.oRH);
                                    ah.h(mMMusicPlayerService.oRH, 60000);
                                    break;
                                }
                        }
                    }
                    x.e("MicroMsg.Music.MMMusicNotificationHelper", "livePlayer event, ingore");
                }
                return false;
            }
        };
        bVar.jil.cfB();
        as.CN().a(520, (com.tencent.mm.ad.e) this);
        as.CN().a(769, (com.tencent.mm.ad.e) this);
        this.oPg = new ArrayList();
    }

    public final void e(ati ati) {
        if (ati == null && this.oPg.size() == 0) {
            x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null && musicList's size is 0");
            return;
        }
        if (ati != null) {
            this.oPg.clear();
            this.oPg.add(g.i(ati));
            this.oPf = 0;
            h.beg().x(ati);
            if (this.mode == 2) {
                bdW();
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic, threadId:%d", Integer.valueOf(Process.myTid()));
        if (ati == null) {
            ati = bdV();
        }
        if (ati != null) {
            x.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", Integer.valueOf(ati.wHt));
        }
        com.tencent.mm.au.a bdU = bdU();
        if (bdU == null || !g.e(bdU)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "music or url is null, do not start music");
            f(ati);
        } else if (bdU.field_isBlock == 1) {
            x.i("MicroMsg.Music.MusicPlayerManager", "not play new music, music is block %s", bdU.field_musicId);
            f(ati);
            f.a(bdU, true);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "music protocol:%s", bdU.field_protocol);
            if (this.oPm != null) {
                as.CN().c(this.oPm);
            }
            as.CN().a(940, (com.tencent.mm.ad.e) this);
            this.oPm = new com.tencent.mm.plugin.music.model.e.a(bdU.field_musicType, bdU);
            as.CN().a(this.oPm, 0);
            d.f(bdU);
            if (d.g(bdU)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "get shake music new url to play");
                Gq(bdU.hJE);
                return;
            }
            b(bdU);
        }
    }

    final void f(ati ati) {
        if (g.m(ati)) {
            this.oPj.w(ati);
        } else if (ati == null || !g.tJ(ati.wHt)) {
            this.oPh.w(ati);
        } else {
            this.oPi.w(ati);
        }
    }

    final void b(com.tencent.mm.au.a aVar) {
        if (g.m(aVar.Qu())) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use exoMusicPlayer");
            bdS();
            this.oPj.j(aVar);
        } else if (g.tJ(aVar.field_musicType)) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use qqMusicPlayer");
            bdS();
            this.oPi.j(aVar);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "use musicPlayer");
            bdS();
            f fVar = this.oPh;
            x.i("MicroMsg.Music.MusicPlayer", "init and start download");
            fVar.stopPlay();
            f.a(aVar, false);
            x.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            fVar.oRZ = false;
            fVar.oSa = false;
            fVar.oSb = false;
            fVar.oSc = false;
            fVar.oSd = false;
            fVar.oSe = false;
            fVar.oSf = false;
            fVar.oSg = false;
            fVar.oSh = false;
            fVar.oSi = 0;
            fVar.d(aVar, false);
            if (aVar == null) {
                x.i("MicroMsg.Music.MusicPlayer", "music is null");
            } else {
                x.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s", aVar.field_songWifiUrl);
                fVar.oRX = new com.tencent.mm.plugin.music.model.c.a(aVar);
                fVar.oRX.oQX = fVar.oSk;
                fVar.oRX.start();
            }
        }
        if (aVar.field_musicType != 11) {
            bea();
        }
    }

    private void bdS() {
        if (this.oPh.Qx()) {
            this.oPh.stopPlay();
        }
        if (this.oPi.Qx()) {
            this.oPi.stopPlay();
        }
        if (this.oPj.Qx()) {
            this.oPj.stopPlay();
        }
    }

    public final com.tencent.mm.plugin.music.model.g.c bdT() {
        ati bdV = bdV();
        if (g.m(bdV)) {
            return this.oPj;
        }
        if (bdV == null || !g.tJ(bdV.wHt)) {
            return this.oPh;
        }
        return this.oPi;
    }

    public final synchronized void f(List<ati> list, boolean z) {
        if (list != null) {
            if (list.size() != 0) {
                if (z) {
                    this.oPg.clear();
                }
                for (ati ati : list) {
                    this.oPg.add(g.i(ati));
                    h.beg().x(ati);
                }
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "appendMusicList error");
    }

    public final com.tencent.mm.au.a bdU() {
        if (this.oPg.size() <= this.oPf) {
            return null;
        }
        return h.beg().Hc((String) this.oPg.get(this.oPf));
    }

    public final ati bdV() {
        if (this.oPg.size() <= this.oPf) {
            return null;
        }
        com.tencent.mm.au.a Hc = h.beg().Hc((String) this.oPg.get(this.oPf));
        return Hc != null ? Hc.Qu() : null;
    }

    public final void Qv() {
        this.oPh.stopPlay();
        if (this.oPi != null) {
            this.oPi.stopPlay();
        }
        if (this.oPj != null) {
            this.oPj.stopPlay();
        }
        ah.K(this.oPp);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        String str2;
        com.tencent.mm.au.a aVar;
        if (kVar instanceof com.tencent.mm.plugin.music.model.e.a) {
            x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd errCode:%d", Integer.valueOf(i2));
            as.CN().b(940, (com.tencent.mm.ad.e) this);
            if (i == 4 && i2 == -24) {
                nn nnVar = ((com.tencent.mm.plugin.music.model.e.a) kVar).oRr;
                if (bdU() != null && nnVar.wdd.equals(bdU().field_musicId)) {
                    Qv();
                }
                com.tencent.mm.plugin.music.model.h.a beg = h.beg();
                str2 = nnVar.wdd;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                beg.gLA.update("Music", contentValues, "musicId=?", new String[]{str2});
                aVar = (com.tencent.mm.au.a) beg.oSw.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd music is block %s", bdU().field_musicId);
            }
        } else if (kVar instanceof com.tencent.mm.plugin.music.model.e.b) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.e.b bVar = (com.tencent.mm.plugin.music.model.e.b) kVar;
                afo afo = bVar.oRs;
                String str3 = bVar.fBv.field_musicId;
                if (afo != null && str3 != null) {
                    for (String str22 : this.oPg) {
                        if (str22.equals(str3)) {
                            str3 = n.b(afo.wug);
                            String b = n.b(afo.wuh);
                            String b2 = n.b(afo.wuf);
                            com.tencent.mm.plugin.music.model.h.a beg2 = h.beg();
                            boolean z = bVar.oRt;
                            com.tencent.mm.sdk.e.c Hc = beg2.Hc(str22);
                            if (Hc == null) {
                                x.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", str22);
                            } else {
                                if (!bi.oN(str3)) {
                                    Hc.field_songAlbumUrl = str3;
                                }
                                Hc.field_songHAlbumUrl = b;
                                Hc.field_songLyric = b2;
                                beg2.c(Hc, "songAlbumUrl", "songHAlbumUrl", "songLyric");
                                beg2.oSw.put(str22, Hc);
                                beg2.g(Hc, z);
                            }
                            x.i("MicroMsg.Music.MusicPlayerManager", "get response %s %s %s", str3, b, b2);
                            if (!bi.oN(b)) {
                                com.tencent.mm.sdk.b.b jtVar = new jt();
                                jtVar.fBu.action = 6;
                                jtVar.fBu.fBv = bVar.fBv;
                                com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } else if (kVar instanceof c) {
            x.i("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            c cVar = (c) kVar;
            x.i("MicroMsg.Music.MusicPlayerManager", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", cVar.hJE, cVar.oRv);
            if (i == 0 && i2 == 0) {
                d.dD(cVar.hJE, cVar.oRv);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(558, 214, 1, true);
            }
            aVar = bdU();
            if (aVar != null && !TextUtils.isEmpty(aVar.hJE) && aVar.hJE.equalsIgnoreCase(cVar.hJE)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is same, start to play shake music");
                b(aVar);
            } else if (aVar != null) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", aVar.hJE, cVar.hJE);
            }
        }
    }

    final void Gq(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is null");
            return;
        }
        if (this.oPn != null) {
            as.CN().c(this.oPn);
            this.oPn = null;
        }
        x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is %s", str);
        this.oPn = new c(str);
        as.CN().a(this.oPn, 0);
        com.tencent.mm.plugin.report.service.g.pWK.a(558, 213, 1, true);
    }

    public final void bdW() {
        com.tencent.mm.sdk.f.e.post(new a(), "music_get_list_task");
    }

    public final void bdX() {
        if (this.mode != 1) {
            this.oPf++;
            this.oPf %= this.oPg.size();
            bdY();
            e(null);
        }
    }

    public final void bdY() {
        if (this.oPh.Qx()) {
            this.oPh.fBx = true;
        }
        if (this.oPi.Qx()) {
            this.oPi.fBx = true;
        }
        if (this.oPj.Qx()) {
            this.oPj.fBx = true;
        }
    }

    public final boolean bdZ() {
        return this.oPg.size() > 0 && this.mode == 2;
    }

    public static void bea() {
        x.i("MicroMsg.Music.MusicPlayerManager", "sendPreemptedEvent");
        com.tencent.mm.sdk.b.b jtVar = new jt();
        jtVar.fBu.action = 10;
        jtVar.fBu.state = "preempted";
        jtVar.fBu.appId = "not from app brand appid";
        jtVar.fBu.fBw = true;
        com.tencent.mm.sdk.b.a.xmy.a(jtVar, Looper.getMainLooper());
    }

    public final void beb() {
        x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayIfPaused, delay_ms:%d", Integer.valueOf(600000));
        ah.K(this.oPp);
        ah.h(this.oPp, 600000);
    }
}
