package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.g.a;
import com.tencent.mm.ad.g.b;
import com.tencent.mm.ad.g.c;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.b.ae;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.ad;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class d implements a, b, c, com.tencent.mm.ad.g.d, f.a, com.tencent.mm.modelvoice.c, SensorController.a, ad {
    private static SensorController kIB;
    p fhH;
    private int fjM;
    private boolean fjO = false;
    public boolean kIE;
    private az kIF;
    long kIG = -1;
    private boolean kIL = false;
    boolean kKi = false;
    public g mvW;
    private List<au> yyS;
    public long yyT = -1;
    private q yyU;
    public u yyV;
    ae yyW;
    public q yyX;
    public boolean yyY;
    public boolean yyZ = true;
    public boolean yza = false;
    private long yzb = 0;
    private long yzc = 0;
    public boolean yzd = false;
    private boolean yze = false;
    public com.tencent.mm.sdk.b.c yzf = new com.tencent.mm.sdk.b.c<ob>() {
        {
            this.xmG = ob.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            long j = ((ob) bVar).fGN.frh;
            x.d("MicroMsg.AutoPlay", "playingVoiceId: %s", d.this.yyT);
            x.d("MicroMsg.AutoPlay", "msg id is: %s", r11.fGN.frh);
            if (d.this.yyT == j) {
                ah.y(new Runnable() {
                    public final void run() {
                        d.this.crV();
                        d.this.crQ();
                    }
                });
            }
            return false;
        }
    };
    private ag yzg = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            boolean z = true;
            super.handleMessage(message);
            try {
                x.i("MicroMsg.AutoPlay", "reset speaker");
                d.this.yyV.setScreenEnable(true);
                d dVar = d.this;
                if (d.this.yyW.kIH) {
                    z = false;
                }
                dVar.kIE = z;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            }
        }
    };
    private ag yzh = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                x.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
                d.this.crT();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            }
        }
    };

    public d(p pVar, ae aeVar, String str) {
        this.yyV = pVar.cte();
        this.fhH = pVar;
        this.yyW = aeVar;
        if (kIB == null) {
            kIB = new SensorController(this.yyV.thisActivity().getApplicationContext());
        }
        if (this.kIF == null) {
            this.kIF = new az(this.yyV.thisActivity().getApplicationContext());
        }
        ZG(str);
        com.tencent.mm.sdk.b.a.xmy.b(this.yzf);
        as.uy().a(this);
    }

    public final void ZG(String str) {
        x.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.yza));
        if (!this.yza && this.yyV != null) {
            this.yyS = new LinkedList();
            this.kKi = false;
            this.yyT = -1;
            this.kIE = false;
            this.kIG = -1;
            this.yyY = false;
            this.fjM = 0;
            if (s.hd(str)) {
                this.fjM = 1;
                this.mvW = new com.tencent.mm.audio.a.a(this.yyV.thisActivity(), 1);
                return;
            }
            this.fjM = 0;
            this.mvW = new com.tencent.mm.audio.a.a(this.yyV.thisActivity(), 0);
        }
    }

    public final void crQ() {
        x.d("MicroMsg.AutoPlay", "clear play list, stack: %s", bi.chl());
        if (this.yyU != null) {
            this.yyU.dismiss();
        }
        this.yyS.clear();
    }

    public final void FH(int i) {
        while (this.yyV != null) {
            q ctm = this.fhH.ctm();
            if (ctm == null) {
                x.e("MicroMsg.AutoPlay", "add next failed: null adapter");
                return;
            }
            x.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + ctm.getCount());
            if (i >= 0 && i < ctm.getCount()) {
                au auVar = (au) ctm.getItem(i);
                if (auVar != null) {
                    if (auVar.cjL() && auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar) && !com.tencent.mm.modelvoice.q.D(auVar)) {
                        ah(auVar);
                    }
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
        x.e("MicroMsg.AutoPlay", "context is null");
    }

    public final void ah(au auVar) {
        if (auVar != null) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                int size = this.yyS.size();
                int i = 0;
                while (i < size) {
                    if (((au) this.yyS.get(i)).field_msgId != auVar.field_msgId) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.yyY || this.yyS.size() == 0) {
                    this.yyS.add(auVar);
                }
                x.d("MicroMsg.AutoPlay", "add voice msg :" + this.yyS.size());
            } else if (this.yyS.size() > 0) {
                this.yyS.clear();
                com.tencent.mm.ui.base.u.fJ(this.yyV.thisActivity());
            }
        }
    }

    public final void a(int i, au auVar) {
        if (auVar != null) {
            crQ();
            as.Hm();
            Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(4115, Boolean.valueOf(true));
                crW();
                this.yyX = com.tencent.mm.ui.base.u.a(this.yyV.thisActivity(), this.yyV.getString(R.l.dSu), 4000);
            }
            if (this.mvW.isPlaying() && auVar.field_msgId == this.yyT) {
                crV();
                return;
            }
            ah(auVar);
            if (auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar)) {
                FH(i + 1);
            }
            bdX();
        }
    }

    public final void b(int i, au auVar) {
        if (auVar != null) {
            crQ();
            as.Hm();
            Boolean bool = (Boolean) com.tencent.mm.y.c.Db().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(4115, Boolean.valueOf(true));
                crW();
                this.yyX = com.tencent.mm.ui.base.u.a(this.yyV.thisActivity(), this.yyV.getString(R.l.dSu), 4000);
            }
            if (this.mvW.isPlaying() && auVar.field_msgId == this.yyT) {
                crV();
                return;
            }
            ah(auVar);
            if (auVar.field_isSend == 0 && !com.tencent.mm.modelvoice.q.C(auVar)) {
                FH(i + 1);
            }
            bdX();
        }
    }

    public final void A(au auVar) {
        if ((!this.yyZ || !this.yyS.isEmpty()) && auVar != null && auVar.cjL() && auVar.field_isSend != 1 && auVar.field_talker != null && auVar.field_talker.equals(this.fhH.csn()) && as.CN().foreground && !this.yyV.isFinishing()) {
            if (com.tencent.mm.modelvoice.q.D(auVar)) {
                x.e("MicroMsg.AutoPlay", "should not in this route");
                return;
            }
            ah(auVar);
            if (!this.kKi && !this.mvW.isPlaying() && bi.bF(this.yyV.thisActivity())) {
                bdX();
            }
        }
    }

    public final void crR() {
        this.kKi = false;
        bdX();
    }

    private void crS() {
        int size = this.yyS.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((au) this.yyS.get(i)).field_msgId == this.yyT) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.yyS.remove(i2);
        }
        x.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.yyS.size());
    }

    public final void bdX() {
        x.d("MicroMsg.AutoPlay", "play next: size = " + this.yyS.size());
        if (this.yyS.size() <= 0) {
            this.yzg.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        if (!f.xN().xY()) {
            f.xN();
            if (f.xV()) {
                f.xN().a((f.a) this);
                int xP = f.xN().xP();
                this.fjO = true;
                if (!(xP == -1 || xP == 0)) {
                    x.i("MicroMsg.AutoPlay", "play next: ret = " + xP);
                    this.yzh.sendEmptyMessageDelayed(0, 1000);
                    return;
                }
            }
        }
        crT();
    }

    public final void crT() {
        try {
            x.d("MicroMsg.AutoPlay", "realPlayNext play next: size = " + this.yyS.size());
            if (this.yyS.size() <= 0) {
                this.yzg.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            long j = ((au) this.yyS.get(0)).field_createTime;
            int size = this.yyS.size();
            int i = 1;
            int i2 = 0;
            while (i < size) {
                long j2;
                int i3;
                if (j > ((au) this.yyS.get(i)).field_createTime) {
                    j2 = ((au) this.yyS.get(i)).field_createTime;
                    i3 = i;
                } else {
                    long j3 = j;
                    i3 = i2;
                    j2 = j3;
                }
                i++;
                i2 = i3;
                j = j2;
            }
            au auVar = (au) this.yyS.get(i2);
            if (auVar != null) {
                boolean z;
                if (auVar == null || !(auVar.cjL() || auVar.ckc() || auVar.ckd() || auVar.cke())) {
                    z = false;
                } else {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.AutoPlay", "start play msg: %d", Long.valueOf(auVar.field_msgId));
                if (!kIB.xqv) {
                    kIB.a(this);
                    if (this.kIF.O(new Runnable() {
                        public final void run() {
                            d.this.kIG = bi.Wz();
                        }
                    })) {
                        this.kIG = 0;
                    } else {
                        this.kIG = -1;
                    }
                }
                as.Hm();
                if (com.tencent.mm.y.c.isSDCardAvailable() || bi.oN(auVar.field_imgPath)) {
                    as.Hm();
                    if (com.tencent.mm.y.c.isSDCardAvailable() && this.yyW.kIH) {
                        if (this.yyU != null) {
                            this.yyU.dismiss();
                        }
                        x.i("MicroMsg.AutoPlay", "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b", Boolean.valueOf(f.xN().xY()), Boolean.valueOf(f.xN().xS()));
                        if (f.xN().xY() || !r2) {
                            this.yyU = com.tencent.mm.ui.base.u.a(this.yyV.thisActivity(), R.k.dBu, this.yyV.getString(R.l.dQn));
                        } else {
                            this.yyU = com.tencent.mm.ui.base.u.a(this.yyV.thisActivity(), R.k.dBo, this.yyV.getString(R.l.dQm));
                        }
                    }
                    af.VI("keep_app_silent");
                    com.tencent.mm.modelvoice.q.E(auVar);
                    this.mvW.aN(true);
                    this.yyW.fhH.ctl().setKeepScreenOn(true);
                    if (f.xN().xY() || f.xN().xS()) {
                        x.i("MicroMsg.AutoPlay", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xN().xY()), Boolean.valueOf(f.xN().xS()));
                        this.kIE = false;
                    }
                    String str = auVar.field_imgPath;
                    String aJ = this.fjM == 1 ? h.aJ(str, false) : com.tencent.mm.modelvoice.q.getFullPath(str);
                    x.i("MicroMsg.AutoPlay", "startplay");
                    boolean oe = com.tencent.mm.modelvoice.q.oe(auVar.field_imgPath);
                    if (!oe) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(111, 175, 1, false);
                    }
                    if (oe && this.mvW.a(aJ, this.kIE, true, -1)) {
                        this.mvW.aP(this.yyS.size() > 1);
                        this.mvW.a((a) this);
                        this.mvW.a((b) this);
                        this.mvW.a((c) this);
                        this.mvW.a((com.tencent.mm.ad.g.d) this);
                        this.yyT = auVar.field_msgId;
                        this.yzc = new n(auVar.field_content).time;
                        this.yzb = System.currentTimeMillis();
                    } else {
                        this.yyT = -1;
                        if (this.fjO) {
                            f.xN().xQ();
                            this.fjO = false;
                        }
                        f.xN().b((f.a) this);
                        crQ();
                        Toast.makeText(this.yyV.thisActivity(), this.yyV.getString(R.l.dSM), 0).show();
                    }
                    cpZ();
                    this.yza = false;
                    return;
                }
                this.yyS.clear();
                com.tencent.mm.ui.base.u.fJ(this.yyV.thisActivity());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
        }
    }

    public final void crU() {
        if (this.mvW != null && this.mvW.isPlaying()) {
            x.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.kIE), Boolean.valueOf(this.mvW.isPlaying()));
            this.mvW.aO(this.kIE);
        }
    }

    public final void release() {
        x.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.kIF != null) {
            this.kIF.cgT();
        }
    }

    public final void crV() {
        x.i("MicroMsg.AutoPlay", "stop play");
        af.VJ("keep_app_silent");
        this.mvW.stop();
    }

    private void cpZ() {
        ah.y(new Runnable() {
            public final void run() {
                if (d.this.yyV != null && d.this.fhH.ctm() != null) {
                    x.i("MicroMsg.AutoPlay", "resetAutoPlay notifyDataSetChanged");
                    d.this.fhH.ctm().notifyDataSetChanged();
                }
            }
        });
    }

    public final boolean isPlaying() {
        return this.mvW.isPlaying();
    }

    public final void vi() {
        x.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn %b, %d, %d", Boolean.valueOf(this.kIE), Long.valueOf(this.yyT), Long.valueOf(this.yzc));
        com.tencent.mm.plugin.report.service.g.pWK.h(15160, Long.valueOf(this.yyT), Long.valueOf(this.yzc), Long.valueOf(this.yzc), Integer.valueOf(0));
        if (this.yyV != null) {
            x.i("MicroMsg.AutoPlay", "stop play complete");
            af.VJ("keep_app_silent");
            this.yyW.releaseWakeLock();
            crS();
            if (this.yyS.isEmpty() && this.fjO) {
                f.xN().xQ();
                this.fjO = false;
            }
            f.xN().b((f.a) this);
            if (this.yyS.isEmpty()) {
                kIB.cgS();
                this.kIF.cgT();
            }
            cpZ();
            this.yyT = -1;
            crW();
            this.yyW.releaseWakeLock();
            bdX();
        }
    }

    public final void onError() {
        x.e("MicroMsg.AutoPlay", "voice play error");
        crV();
        bdX();
    }

    public final void bD(boolean z) {
        x.w("MicroMsg.AutoPlay", "voice play pause. %b", Boolean.valueOf(z));
        onStop();
    }

    public final void onStop() {
        int i = 1;
        x.w("MicroMsg.AutoPlay", "voice play stop. %d, %d, %d, %b, %b, %s", Long.valueOf(this.yyT), Long.valueOf(this.yzc), Long.valueOf(bi.bA(this.yzb)), Boolean.valueOf(this.yze), Boolean.valueOf(this.yzd), bi.chl());
        if (this.yyT > 0) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[4];
            objArr[0] = Long.valueOf(this.yyT);
            objArr[1] = Long.valueOf(this.yzc);
            objArr[2] = Long.valueOf(bi.bA(this.yzb));
            if (this.yze) {
                i = 3;
            } else if (!this.yzd) {
                i = 2;
            }
            objArr[3] = Integer.valueOf(i);
            gVar.h(15160, objArr);
        }
        this.yze = false;
        this.yzd = false;
        this.yyW.releaseWakeLock();
        crS();
        if (this.fjO) {
            f.xN().xQ();
            this.fjO = false;
        }
        f.xN().b((f.a) this);
        if (this.yyS.isEmpty()) {
            kIB.cgS();
            this.kIF.cgT();
        }
        cpZ();
        this.yyT = -1;
        crW();
        this.yza = false;
    }

    public final void dX(final boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.kIL + " tick:" + bi.bB(this.kIG) + "  lt:" + this.kIG);
        if (this.kIL) {
            if (z) {
                z2 = false;
            }
            this.kIL = z2;
        } else if (this.yyV == null) {
            kIB.cgS();
        } else {
            x.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(this.yyV.isScreenEnable()));
            if (z || this.kIG == -1 || bi.bB(this.kIG) <= 400) {
                this.kIL = false;
                if (!this.mvW.ve()) {
                    if (as.Hn().xS()) {
                        crW();
                        x.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                        return;
                    } else if (this.yyW.kIH) {
                        this.kIE = false;
                        if (this.yyT != -1) {
                            this.yyV.setScreenEnable(z);
                            this.yza = z;
                        } else {
                            this.yyV.setScreenEnable(true);
                            this.yza = true;
                        }
                        crU();
                        return;
                    } else {
                        if (this.yyT != -1) {
                            if (this.yyV.isScreenEnable() != z) {
                                this.yyV.setScreenEnable(z);
                                this.yza = z;
                                new al(new al.a() {
                                    public final boolean uG() {
                                        if (z) {
                                            x.i("MicroMsg.AutoPlay", "speaker true");
                                            d.this.crW();
                                            if (d.this.yyV != null) {
                                                d.this.yyX = com.tencent.mm.ui.base.u.a(d.this.yyV.thisActivity(), d.this.yyV.getString(R.l.ejp), 2000);
                                            }
                                            d.this.kIE = true;
                                            d.this.crU();
                                        } else {
                                            x.i("MicroMsg.AutoPlay", "speaker off");
                                            d.this.kIE = false;
                                            d dVar = d.this;
                                            if (dVar.mvW.isPlaying()) {
                                                x.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                                dVar.bdX();
                                            }
                                        }
                                        return false;
                                    }
                                }, false).K(50, 50);
                            } else {
                                return;
                            }
                        }
                        x.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.yza));
                        return;
                    }
                }
                return;
            }
            this.kIL = true;
        }
    }

    public final void crW() {
        if (this.yyX != null) {
            this.yyX.dismiss();
        }
    }

    public final void GU() {
        x.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
        this.yze = false;
    }

    public final void GV() {
        x.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        this.yze = true;
        crV();
        crQ();
        try {
            if (kIB != null) {
                kIB.cgS();
            }
            if (this.kIF != null) {
                this.kIF.cgT();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AutoPlay", e, "reset sensor error: %s", e.getMessage());
        }
    }

    public final void er(int i) {
        x.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fjO));
        switch (i) {
            case 1:
                if (this.yzh.hasMessages(0)) {
                    this.yzh.removeMessages(0);
                    this.yzh.sendEmptyMessage(0);
                    return;
                }
                return;
            case 2:
            case 4:
                if (this.yzh.hasMessages(0)) {
                    this.yzh.removeMessages(0);
                }
                if (this.fjO) {
                    f.xN().xQ();
                    this.fjO = false;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
