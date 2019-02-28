package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.talkroom.b.f;
import com.tencent.mm.plugin.talkroom.component.TalkRoomService;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.plugin.talkroom.component.b;
import com.tencent.mm.plugin.talkroom.component.d;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass10;
import com.tencent.mm.plugin.talkroom.model.i.AnonymousClass11;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.q.n;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.ad;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.smtt.sdk.QbSdk;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e, l, n, ad {
    public static final int[] sih = new int[]{80, 8080, 16285};
    public static final byte[][] sii = new byte[][]{new byte[]{(byte) 101, (byte) -30, (byte) 76, (byte) 27}, new byte[]{(byte) 112, (byte) 64, (byte) -19, (byte) -29}, new byte[]{(byte) 120, (byte) -52, (byte) -55, (byte) -58}};
    private final ServiceConnection lwY = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
            if (iBinder == null) {
                g.this.sig.M("enterTalkRoom bindServie or protocalInit failed", 3, -1);
                return;
            }
            g.this.sia = a.T(iBinder);
            if (g.this.state >= 2) {
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        g.this.ja(true);
                    }
                });
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
        }
    };
    private int nJe;
    private long nJf;
    private int shS = 0;
    private int shT = 0;
    private boolean shU = false;
    public String shV;
    private int shW;
    private int shX;
    private int shY;
    private LinkedList<bos> shZ = new LinkedList();
    private com.tencent.mm.plugin.talkroom.component.a sia;
    private b sib;
    private com.tencent.mm.plugin.talkroom.component.e sic;
    private d sid;
    private ab sie;
    private al sif;
    private i sig = new i();
    public boolean sij = false;
    private int state = 0;

    public g() {
        TalkRoomReceiver.init();
    }

    public final int bFv() {
        if (this.shS != 1) {
            return (q.a.vje == null || !q.a.vje.Ei(this.shV)) ? 0 : 1;
        } else {
            return 1;
        }
    }

    public final List<bot> aWi() {
        return b.bFn().MX(this.shV);
    }

    public final String bFw() {
        Iterator it = b.bFn().MX(this.shV).iterator();
        while (it.hasNext()) {
            bot bot = (bot) it.next();
            if (bot.wXZ == this.shY) {
                return bot.kyG;
            }
        }
        return null;
    }

    public final void a(o oVar) {
        i iVar = this.sig;
        synchronized (oVar) {
            if (iVar.gzt.contains(oVar)) {
            } else {
                iVar.gzt.add(oVar);
            }
        }
        this.sig.Es(bFw());
    }

    public final void b(o oVar) {
        i iVar = this.sig;
        synchronized (oVar) {
            iVar.gzt.remove(oVar);
        }
    }

    private boolean bFx() {
        if (bFv() == 1) {
            b(b.bFl().sha);
        } else {
            a(b.bFl().sha);
        }
        if (this.shT > 0) {
            x.i("MicroMsg.TalkRoomServer", "addListener has init before");
        } else {
            as.CN().a(332, (e) this);
            as.CN().a(334, (e) this);
            as.CN().a(336, (e) this);
            as.CN().a(335, (e) this);
            b.bFn().a(this);
            as.uy().a(this);
            this.shT = 1;
            if (this.sia != null) {
                try {
                    this.sia.Close();
                    this.sia.uninitLive();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
            }
            com.tencent.mm.sdk.platformtools.ad.getContext().bindService(new Intent(com.tencent.mm.sdk.platformtools.ad.getContext(), TalkRoomService.class), this.lwY, 1);
            this.sib = new b.a() {
                public final void keep_OnOpenSuccess() {
                    x.i("MicroMsg.TalkRoomServer", "OnOpenSuccess");
                    if (g.this.state != 1) {
                        x.w("MicroMsg.TalkRoomServer", "has exit the talkroom state:%d", Integer.valueOf(g.this.state));
                        return;
                    }
                    b.bFp().bFu();
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            g.this.iZ(true);
                        }
                    });
                    g.this.bFB();
                    g.this.sig.aWH();
                }

                public final void keep_OnError(int i) {
                    x.e("MicroMsg.TalkRoomServer", "engineCallback OnError: %d", Integer.valueOf(i));
                    b.bFp().bFu();
                    b.bFp().shp = 1;
                    g.this.sig.M("component OnError " + i, 99, i);
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            g.this.aWG();
                        }
                    });
                }
            };
        }
        return true;
    }

    public final void co(String str, int i) {
        x.i("MicroMsg.TalkRoomServer", "enterTalkRoom %s scene %d", str, Integer.valueOf(i));
        this.shS = i;
        bFx();
        if (str.equals(this.shV)) {
            x.d("MicroMsg.TalkRoomServer", "enterTalkRoom %s has enter the talkroom", str);
            if (this.state == 2) {
                this.sig.aWH();
                return;
            }
            return;
        }
        x.d("MicroMsg.TalkRoomServer", "%s enter the talkroom", str);
        this.shV = str;
        as.CN().a(new com.tencent.mm.plugin.talkroom.b.a(this.shV, bFv()), 0);
        b.bFl().shc = new f();
        b.bFp().shM = bi.Wz();
        b.bFp().shJ = str;
        if (bFv() == 0) {
            b.bFl().sha.oad = true;
        }
        i iVar = this.sig;
        Runnable anonymousClass11 = new AnonymousClass11(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass11.run();
        } else {
            iVar.handler.post(anonymousClass11);
        }
    }

    public final void aWG() {
        x.i("MicroMsg.TalkRoomServer", "exitTalkRoom");
        iZ(false);
        if (bi.oN(this.shV)) {
            x.i("MicroMsg.TalkRoomServer", "exitTalkRoom: has exited");
            return;
        }
        int Close;
        f bFp = b.bFp();
        if (bFp.shM != 0) {
            bFp.shq = (int) (bi.bB(bFp.shM) / 1000);
        }
        this.state = 0;
        this.shU = false;
        as.CN().a(new com.tencent.mm.plugin.talkroom.b.b(this.nJe, this.nJf, this.nJe != 0 ? this.shV : "", bFv()), 0);
        if (this.sia != null) {
            try {
                Close = this.sia.Close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                Close = QbSdk.EXTENSION_INIT_FAILURE;
            }
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.Close error %d", Integer.valueOf(Close));
            }
            PByteArray pByteArray = new PByteArray();
            if (a(pByteArray, r.gw(this.shV)) == 0) {
                x.i("MicroMsg.TalkRoomServer", "getStatis==> pba.len %d, info: %s", Integer.valueOf(pByteArray.value.length), new String(pByteArray.value));
                LinkedList linkedList = new LinkedList();
                bou bou = new bou();
                bou.wBF = 10402;
                bou.wYa = new bet().Vf(r1);
                bou bou2 = new bou();
                bou2.wBF = 10404;
                bou2.wYa = new bet().Vf(b.bFp().toString());
                linkedList.add(bou);
                linkedList.add(bou2);
                as.CN().a(new com.tencent.mm.plugin.talkroom.b.g(linkedList, bFv()), 0);
            }
        }
        this.shV = "";
        this.nJe = 0;
        this.nJf = 0;
        this.shW = 0;
        this.shX = 0;
        this.shY = 0;
        this.shZ.clear();
        bFy();
        i iVar = this.sig;
        Runnable anonymousClass12 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o aWJ : i.this.gzt) {
                        aWJ.aWJ();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass12.run();
        } else {
            iVar.handler.post(anonymousClass12);
        }
        c cVar = b.bFl().sha;
        cVar.mHandler.post(new Runnable() {
            public final void run() {
                b.bFl();
                x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
                b.bFl();
                c.bFs();
            }
        });
        this.shT = 0;
        as.CN().b(332, (e) this);
        as.CN().b(334, (e) this);
        as.CN().b(336, (e) this);
        as.CN().b(335, (e) this);
        b.bFn().b(this);
        as.uy().b(this);
        b(b.bFl().sha);
        if (this.sia != null) {
            try {
                Close = this.sia.uninitLive();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            com.tencent.mm.sdk.platformtools.ad.getContext().unbindService(this.lwY);
            com.tencent.mm.sdk.platformtools.ad.getContext().stopService(new Intent(com.tencent.mm.sdk.platformtools.ad.getContext(), TalkRoomService.class));
            this.sia = null;
            if (Close < 0) {
                x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", Integer.valueOf(Close));
            }
        }
        Close = QbSdk.EXTENSION_INIT_FAILURE;
        com.tencent.mm.sdk.platformtools.ad.getContext().unbindService(this.lwY);
        com.tencent.mm.sdk.platformtools.ad.getContext().stopService(new Intent(com.tencent.mm.sdk.platformtools.ad.getContext(), TalkRoomService.class));
        this.sia = null;
        if (Close < 0) {
            x.e("MicroMsg.TalkRoomServer", "engine.uninitLive error %d", Integer.valueOf(Close));
        }
    }

    private void bFy() {
        if (this.sic != null) {
            try {
                this.sic.release();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
            this.sic = null;
        }
        if (this.sid != null) {
            try {
                this.sid.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            this.sid = null;
        }
        if (this.sie != null) {
            this.sie.TN();
            this.sie = null;
        }
        if (this.sif != null) {
            this.sif.TN();
            this.sif = null;
        }
    }

    private void iZ(boolean z) {
        if (!bi.oN(this.shV)) {
            as.Hm();
            ae XF = c.Fk().XF(this.shV);
            if (XF != null) {
                XF.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(XF, z ? 5 : 6, XF.field_conversationTime));
                as.Hm();
                c.Fk().a(XF, this.shV);
            }
        }
    }

    public final boolean bFz() {
        x.i("MicroMsg.TalkRoomServer", "seizeMic");
        if (this.state != 2) {
            x.i("MicroMsg.TalkRoomServer", "seizeMic  not int the appropriate state");
            if (this.state == 0) {
                this.sig.j(3, -1, "seizeMic in outside room state");
            }
            return false;
        }
        if (this.sic != null) {
            try {
                this.sic.byf();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
        this.state = 3;
        as.CN().a(new com.tencent.mm.plugin.talkroom.b.d(this.nJe, this.nJf, 1, this.shV, bFv()), 0);
        b.bFp().shO = bi.Wz();
        b.bFp().shR = true;
        return true;
    }

    public final void bFA() {
        x.i("MicroMsg.TalkRoomServer", "putAwayMic");
        f bFp = b.bFp();
        if (bFp.shR && !bFp.shQ) {
            bFp.shL++;
        }
        bFp.shQ = false;
        bFp.shR = false;
        if (this.state < 3) {
            x.w("MicroMsg.TalkRoomServer", "putAwayMic  err, isnot getting or has not got mic");
            return;
        }
        if (this.sif != null) {
            this.sif.TN();
            this.sif = null;
        }
        bFB();
        as.CN().a(new com.tencent.mm.plugin.talkroom.b.d(this.nJe, this.nJf, 2, this.shV, bFv()), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.TalkRoomServer", "type:%d  errType:%d  errCode:%d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        f fVar = (f) kVar;
        if (fVar.bFI() == null || !fVar.bFI().equals(this.shV)) {
            x.w("MicroMsg.TalkRoomServer", "%s, now :%s this is the old sceneEnd, abandon it!!", fVar.bFI(), this.shV);
            return;
        }
        f bFp;
        if (!(i == 0 && i2 == 0)) {
            if (kVar.getType() == 332) {
                b.bFp().yB(2);
                if (i == 4) {
                    b.bFp().shK = i2;
                }
                this.sig.M("cgi enter failed : errType:" + i + " errCode:" + i2, i, i2);
                aWG();
                return;
            } else if (kVar.getType() == 334) {
                if (((com.tencent.mm.plugin.talkroom.b.d) kVar).actionType == 1) {
                    bFp = b.bFp();
                    bFp.sht++;
                    bFp.shO = 0;
                    bFB();
                    x.w("MicroMsg.TalkRoomServer", "onSceneEnd SeizeMicFailed");
                    if (i == 4 && (i2 == 311 || i2 == 340)) {
                        this.sig.sf(i2);
                        return;
                    } else {
                        this.sig.j(i, i2, "TalkMicAction failed!!");
                        return;
                    }
                }
                return;
            } else if (kVar.getType() == 336) {
                this.shU = false;
                this.sig.j(i, i2, "TalkGetMember failed!!");
                aWG();
                return;
            } else if (kVar.getType() == 335) {
                this.sig.j(i, i2, "TalkNoop failed!!");
                aWG();
                return;
            }
        }
        if (kVar.getType() == 332) {
            b.bFp().yB(1);
            com.tencent.mm.plugin.talkroom.b.a aVar = (com.tencent.mm.plugin.talkroom.b.a) kVar;
            this.nJe = aVar.nJe;
            this.nJf = aVar.nJf;
            this.shW = aVar.shW;
            this.shX = aVar.shX;
            this.shZ = aVar.shZ;
            bFp = b.bFp();
            int i3 = this.nJe;
            long j = this.nJf;
            bFp.nJe = i3;
            bFp.nJf = j;
            b.bFn().a(this.shV, aVar.sis, null, null, fVar.bFJ());
            yC(100);
        } else if (kVar.getType() == 334) {
            com.tencent.mm.plugin.talkroom.b.d dVar = (com.tencent.mm.plugin.talkroom.b.d) kVar;
            if (dVar.actionType == 1) {
                bFp = b.bFp();
                if (bFp.shO != 0) {
                    bFp.shr = (bi.bB(bFp.shO) + (bFp.shr * ((long) bFp.shN))) / ((long) (bFp.shN + 1));
                    bFp.shN++;
                    bFp.shs++;
                    bFp.shO = 0;
                }
                x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic seize Mic successFul");
                if (dVar.shW < this.shW) {
                    x.w("MicroMsg.TalkRoomServer", "micSeq is smaller seizeSeq %d, now %d", Integer.valueOf(dVar.shW), Integer.valueOf(this.shW));
                    bFB();
                    this.sig.sf(311);
                    return;
                }
                this.shW = dVar.shW;
                int i4 = QbSdk.EXTENSION_INIT_FAILURE;
                try {
                    i4 = this.sia.SetCurrentMicId(this.shW);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                }
                if (this.state != 3) {
                    x.i("MicroMsg.TalkRoomServer", "dealWithSeizeMic not in getting mic state");
                    return;
                }
                i iVar = this.sig;
                Runnable anonymousClass6 = new Runnable() {
                    public final void run() {
                        synchronized (i.this.gzt) {
                            for (o aWI : i.this.gzt) {
                                aWI.aWI();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass6.run();
                } else {
                    iVar.handler.post(anonymousClass6);
                }
                this.state = 4;
                if (i4 < 0) {
                    x.e("MicroMsg.TalkRoomServer", "SetCurrentMicId err: %d ", Integer.valueOf(i4));
                }
                if (this.sif == null) {
                    this.sif = new al(new al.a() {
                        public final boolean uG() {
                            int e = g.this.nJe;
                            long f = g.this.nJf;
                            String g = g.this.shV;
                            g gVar = g.this;
                            g.this.shV;
                            as.CN().a(new com.tencent.mm.plugin.talkroom.b.d(e, f, 1, g, gVar.bFv()), 0);
                            return true;
                        }
                    }, true);
                    this.sif.K(5000, 5000);
                    return;
                }
                return;
            }
            x.i("MicroMsg.TalkRoomServer", "putaway Mic successFul");
        } else {
            if (kVar.getType() == 336) {
                com.tencent.mm.plugin.talkroom.b.c cVar = (com.tencent.mm.plugin.talkroom.b.c) kVar;
                b.bFn().a(this.shV, cVar.sis, null, null, fVar.bFJ());
                yD(cVar.shW);
                this.shU = false;
                this.sig.Es(bFw());
            }
            if (kVar.getType() == 335 && this.state == 0) {
                this.sig.j(3, -1, "talknoop success but in outside room state");
            }
        }
    }

    private void bFB() {
        try {
            f bFp = b.bFp();
            if (bFp.shP != 0) {
                long bB = bi.bB(bFp.shP) / 1000;
                if (bB < 2) {
                    bFp.shA++;
                } else if (bB < 6) {
                    bFp.shB++;
                } else if (bB < 11) {
                    bFp.shC++;
                } else if (bB < 21) {
                    bFp.shD++;
                } else if (bB < 31) {
                    bFp.shE++;
                } else if (bB < 41) {
                    bFp.shF++;
                } else if (bB < 51) {
                    bFp.shG++;
                } else if (bB < 61) {
                    bFp.shH++;
                } else {
                    bFp.shI++;
                }
                bFp.shP = 0;
            }
            if (this.sid != null) {
                this.sid.bFh();
            }
            if (this.sic != null) {
                this.sic.bFk();
            }
            this.state = 2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
    }

    public final void bFi() {
        x.i("MicroMsg.TalkRoomServer", "resumeRecord in state %d", Integer.valueOf(this.state));
        if (this.state == 4) {
            f bFp = b.bFp();
            bFp.shQ = true;
            bFp.shP = bi.Wz();
            try {
                this.sid.bFi();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        }
    }

    private void yC(final int i) {
        if (this.sia != null) {
            try {
                this.state = 1;
                this.shU = false;
                if (bFC()) {
                    bFy();
                    bFE();
                    bFD();
                    if (this.sie != null) {
                        x.w("MicroMsg.TalkRoomServer", "enter talkroom not first time");
                        return;
                    }
                    this.sie = new ab(new ab.a() {
                        public final boolean uG() {
                            if (g.this.nJe == 0 || bi.oN(g.this.shV)) {
                                x.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", Integer.valueOf(g.this.nJe), g.this.shV);
                                g.this.sie = null;
                                return false;
                            }
                            String g = g.this.shV;
                            int e = g.this.nJe;
                            long f = g.this.nJf;
                            g gVar = g.this;
                            g.this.shV;
                            as.CN().a(new com.tencent.mm.plugin.talkroom.b.e(g, e, f, gVar.bFv()), 0);
                            return true;
                        }
                    });
                    ab abVar = this.sie;
                    ab.xnG = true;
                    abVar.sAT = 50000;
                    abVar.hlm = bi.Wz();
                    boolean fH = ab.fH(abVar.sAT);
                    abVar.TN();
                    ab.xnD.put(Integer.valueOf(abVar.xnC), abVar);
                    if (ab.gzz != null && fH) {
                        x.v("MicroMsg.MAlarmHandler", "prepare bumper");
                        ab.gzz.prepare();
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            }
        } else if (i == 0) {
            this.sig.M("bind talkroomService timeout", 3, -1);
        } else {
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    g.this.yC(i - 1);
                }
            }, 50);
        }
    }

    private boolean bFC() {
        int i = QbSdk.EXTENSION_INIT_FAILURE;
        try {
            i = this.sia.bFf();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        x.i("MicroMsg.TalkRoomServer", "engine.protocalInit");
        if (i >= 0 || i == -3) {
            return true;
        }
        this.sia = null;
        x.f("MicroMsg.TalkRoomServer", "engine.protocalInit error %d", Integer.valueOf(i));
        this.sig.M("enterTalkRoom protocalInit failed", 3, -1);
        return false;
    }

    private void yD(int i) {
        if (i > this.shW) {
            this.shW = i;
            if (this.state >= 3) {
                this.sig.sf(311);
            }
            bFB();
        }
    }

    public final void ja(boolean z) {
        x.i("MicroMsg.TalkRoomServer", "reConnect talkRoomUsername: %s", this.shV);
        if (!bi.oN(this.shV) && this.state >= 2) {
            f bFp = b.bFp();
            bFp.shw++;
            if (z) {
                if (bFC()) {
                    try {
                        bFD();
                    } catch (Throwable e) {
                        x.e("MicroMsg.TalkRoomServer", e.toString());
                        x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
                    }
                } else {
                    return;
                }
            }
            bFB();
            this.state = 1;
            try {
                if (this.sia != null) {
                    this.sia.Close();
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.TalkRoomServer", e2, "", new Object[0]);
            }
            if (this.nJe != 0) {
                bFE();
            }
            if (!z) {
                i iVar = this.sig;
                Runnable anonymousClass4 = new Runnable() {
                    public final void run() {
                        synchronized (i.this.gzt) {
                            for (o aWM : i.this.gzt) {
                                aWM.aWM();
                            }
                        }
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    anonymousClass4.run();
                } else {
                    iVar.handler.post(anonymousClass4);
                }
            }
        }
    }

    private void bFD() {
        if (this.sia == null) {
            x.e("MicroMsg.TalkRoomServer", "the engine should not be null.");
            return;
        }
        this.sic = this.sia.a(new com.tencent.mm.plugin.talkroom.component.c.a() {
            public final void j(int i, int i2, boolean z) {
                if (z) {
                    g.this.shY = 0;
                    g.this.sig.Es("");
                    return;
                }
                g.this.yD(i2);
                if (g.this.shY != i) {
                    g.this.shY = i;
                    String bFw = g.this.bFw();
                    if (!g.this.shU && bFw == null) {
                        g.this.shU = true;
                        int e = g.this.nJe;
                        long f = g.this.nJf;
                        String g = g.this.shV;
                        g gVar = g.this;
                        g.this.shV;
                        as.CN().a(new com.tencent.mm.plugin.talkroom.b.c(e, f, g, gVar.bFv()), 0);
                        f bFp = b.bFp();
                        bFp.shx++;
                        bFp = b.bFp();
                        bFp.shy++;
                    }
                    g.this.sig.Es(bFw);
                    com.tencent.mm.sdk.platformtools.as.H(com.tencent.mm.sdk.platformtools.ad.getContext(), R.l.eRi);
                }
            }
        });
        this.sic.start();
        this.sid = this.sia.bFg();
        this.sid.start();
    }

    private static String yE(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            return null;
        }
    }

    private void bFE() {
        if (this.shZ.size() == 0) {
            x.e("MicroMsg.TalkRoomServer", "engine. talk relay addr list is empty");
            this.sig.j(3, -1, "engine.talk relay addr list empty");
            return;
        }
        int a;
        int[] iArr = new int[this.shZ.size()];
        int[] iArr2 = new int[this.shZ.size()];
        x.i("MicroMsg.TalkRoomServer", "talk relay addr cnt %d", Integer.valueOf(this.shZ.size()));
        for (int i = 0; i < this.shZ.size(); i++) {
            iArr[i] = ((bos) this.shZ.get(i)).wXY;
            iArr2[i] = ((bos) this.shZ.get(i)).wMQ;
            x.i("MicroMsg.TalkRoomServer", "add talk relay addr %s %d", yE(((bos) this.shZ.get(i)).wXY), Integer.valueOf(((bos) this.shZ.get(i)).wMQ));
        }
        x.i("MicroMsg.TalkRoomServer", "engine.Open myRoomMemId %d, roomId %d, roomKey %d", Integer.valueOf(this.shX), Integer.valueOf(this.nJe), Long.valueOf(this.nJf));
        try {
            com.tencent.mm.plugin.talkroom.component.a aVar = this.sia;
            b bVar = this.sib;
            as.Hm();
            a = aVar.a(bVar, c.Cn(), this.shX, this.nJe, this.nJf, iArr, iArr2, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
            a = QbSdk.EXTENSION_INIT_FAILURE;
        }
        if (a < 0 && a != -3) {
            x.e("MicroMsg.TalkRoomServer", "engine.Open error %d", Integer.valueOf(a));
            this.sig.j(3, a, "engine.Open error");
        }
    }

    public final short bFF() {
        short s = (short) 0;
        if (this.sid == null) {
            return s;
        }
        try {
            return (short) this.sid.bFj();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    public final short bFG() {
        short s = (short) 0;
        if (this.sic == null) {
            return s;
        }
        try {
            return (short) this.sic.bFj();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[s]);
            return s;
        }
    }

    private int a(PByteArray pByteArray, String str) {
        if (this.sia == null) {
            return -99;
        }
        int[] iArr = new int[1];
        try {
            pByteArray.value = this.sia.d(iArr, str);
        } catch (Throwable e) {
            iArr[0] = QbSdk.EXTENSION_INIT_FAILURE;
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        return iArr[0];
    }

    public final void G(String str, String str2, String str3) {
        if (str.equals(this.shV)) {
            i iVar = this.sig;
            Runnable anonymousClass10 = new AnonymousClass10(str2, str3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                anonymousClass10.run();
            } else {
                iVar.handler.post(anonymousClass10);
            }
        }
    }

    public final boolean bFH() {
        return this.sij;
    }

    public final void GU() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onResume");
        if (bi.oN(this.shV)) {
            x.d("MicroMsg.TalkRoomServer", "pause");
        } else {
            bFB();
        }
        this.sij = false;
        i iVar = this.sig;
        Runnable anonymousClass3 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o aWL : i.this.gzt) {
                        aWL.aWL();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass3.run();
        } else {
            iVar.handler.post(anonymousClass3);
        }
    }

    public final void GV() {
        x.v("MicroMsg.TalkRoomServer", "yy talkroom onPause");
        try {
            if (bi.oN(this.shV)) {
                x.d("MicroMsg.TalkRoomServer", "pause");
            } else {
                if (this.sid != null) {
                    this.sid.bFh();
                }
                if (this.sic != null) {
                    this.sic.byf();
                }
                this.state = 2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomServer", e, "", new Object[0]);
        }
        this.sij = true;
        i iVar = this.sig;
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                synchronized (i.this.gzt) {
                    for (o aWK : i.this.gzt) {
                        aWK.aWK();
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass2.run();
        } else {
            iVar.handler.post(anonymousClass2);
        }
    }
}
