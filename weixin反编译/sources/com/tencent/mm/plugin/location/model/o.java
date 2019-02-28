package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.p;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements e, p {
    private int cRQ;
    public boolean fBn = false;
    public boolean fid = false;
    public com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            x.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d));
            if (o.this.nXC) {
                o.this.nXC = false;
                o.this.nXE = System.currentTimeMillis();
                long j = o.this.nXE - o.this.nXD;
                x.d("MicorMsg.TrackRefreshManager", "locate time:%d", Long.valueOf(j));
                g.pWK.h(10997, PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", Integer.valueOf(0), Long.valueOf(j));
            }
            if (!(o.this.nXt == null || o.this.nXt.xbj == null)) {
                o.this.nXt.xbj.vUG = (double) f2;
                o.this.nXt.xbj.vUF = (double) f;
            }
            return true;
        }
    };
    public c hry;
    ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                o oVar = o.this;
                switch (message.what) {
                    case 1:
                        oVar.aWk();
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private String nWc;
    public double nWe = -1000.0d;
    public double nWf = -1000.0d;
    public a nXA = null;
    public int nXB = -1;
    public boolean nXC = true;
    public long nXD = 0;
    long nXE = 0;
    public com.tencent.mm.plugin.location.model.i.a nXF = new com.tencent.mm.plugin.location.model.i.a() {
        public final void n(double d) {
            if (o.this.nXt != null) {
                o.this.nXt.xbj.wMf = d;
            }
        }
    };
    private int nXo = 0;
    private int nXp = 1000;
    public i nXq;
    public HashSet<WeakReference<b>> nXr = new HashSet();
    public int nXs = 1;
    public bte nXt;
    public LocationInfo nXu = new LocationInfo((byte) 0);
    public boolean nXv = false;
    public boolean nXw = false;
    public int nXx = this.nXs;
    public String nXy = "";
    boolean nXz = false;
    public int zoom = -1;

    public interface a {
        void aWm();
    }

    public interface b {
        void a(bcu bcu);

        void aWn();

        void aWo();

        void onError(int i, String str);
    }

    public final void stop() {
        x.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
        if (this.nXq != null) {
            this.nXq.b(this.nXF);
        }
        as.CN().b(492, (e) this);
        as.CN().b(490, (e) this);
        as.CN().b(491, (e) this);
        this.nXs = 1;
        this.fBn = false;
        this.nXB = -1;
        m aWd = l.aWd();
        x.d("MicroMsg.TrackAvatarCacheService", "clearCache");
        for (String str : aWd.nXn.snapshot().keySet()) {
            Bitmap bitmap = (Bitmap) aWd.nXn.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        aWd.nXn.trimToSize(-1);
    }

    public final boolean aWf() {
        return aWl() && this.nXv;
    }

    public final void se(int i) {
        x.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (aWl()) {
            String str = this.nWc;
            x.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", Integer.valueOf(i));
            k aVar = new com.tencent.mm.plugin.location.model.a.a(str);
            ((tm) aVar.gLB.hnQ.hnY).sfa = i;
            as.CN().a(aVar, 0);
            this.nWc = "";
        }
        if (!bi.oN(this.nXy)) {
            com.tencent.mm.plugin.location.a.a Eh = l.aWb().Eh(this.nXy);
            if (Eh != null) {
                Eh.fBS.remove(q.FY());
                l.aWb().a(this.nXy, Eh.fBS, Eh.latitude, Eh.longitude, Eh.nWa, null, null);
            }
        }
        l.aWb().Ej("");
        this.nWc = "";
        this.nXy = "";
        this.nXv = false;
        this.nXw = false;
        this.nWe = -1000.0d;
        this.nWf = -1000.0d;
        this.zoom = -1;
        this.nXB = -1;
    }

    public final void aWg() {
        x.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.nXz = false;
        x.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (aWl()) {
            x.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.hry = c.OV();
            this.hry.b(this.gAn, true);
            if (this.nXq == null) {
                this.nXq = l.aWc();
            }
            this.nXq.a(this.nXF);
            aWk();
        }
    }

    public final String aWh() {
        return this.nXy;
    }

    public final List<String> aWi() {
        return l.aWb().Eg(this.nXy);
    }

    public final void aWj() {
        if (this.nXs == 1) {
            this.nXs = 3;
        } else if (this.nXs == 3) {
            this.nXs = 2;
        }
    }

    public final void aWk() {
        boolean z = true;
        String str;
        if (!this.fBn || !this.nXv || this.nXu == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.fBn).append(" isShared: ").append(this.nXv).append(" ");
            if (this.nXu != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
        } else if (this.nXt == null || this.nXt.xbj.vUG == -1000.0d || this.nXt.xbj.vUF == -1000.0d) {
            x.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.nXp);
        } else {
            String FY = q.FY();
            bpq bpq = new bpq();
            bpq.wKq = this.nXu.nWg;
            bpq.vUG = this.nXu.nWe;
            bpq.vUF = this.nXu.nWf;
            bpq.nkW = FY;
            this.nXt.vPp = FY;
            this.nXt.xbj.wMf = l.aWc().aVT();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.nWc + "]");
            switch (this.nXs) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + bpq.vUG + " " + bpq.vUF + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.nXt.xbj.vUG + " " + this.nXt.xbj.vUF + " " + this.nXt.xbj.wMf + " ]");
            x.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.nWc;
            int i = this.nXs;
            bte bte = this.nXt;
            int i2 = this.cRQ + 1;
            this.cRQ = i2;
            as.CN().a(new com.tencent.mm.plugin.location.model.a.c(str, i, bte, i2, bpq), 0);
        }
    }

    public final boolean aWl() {
        return !bi.oN(this.nWc);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        WeakReference weakReference;
        bcu bcu;
        if (kVar.getType() == 490) {
            Iterator it;
            if (i2 == 0 || i2 >= 1000) {
                this.nWc = ((com.tencent.mm.plugin.location.model.a.b) kVar).nWc;
                l.aWb().Ej(this.nWc);
                if (aWl()) {
                    x.i("MicorMsg.TrackRefreshManager", "join sucess %s", this.nWc);
                    LinkedList Eg = com.tencent.mm.pluginsdk.q.a.vje.Eg(this.nXy);
                    Eg.add(q.FY());
                    if (this.nXu != null) {
                        com.tencent.mm.pluginsdk.q.a.vje.a(this.nXy, Eg, this.nXu.nWe, this.nXu.nWf, this.nXu.nWg, "", "");
                    } else {
                        com.tencent.mm.pluginsdk.q.a.vje.a(this.nXy, Eg, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.nXr != null) {
                        it = this.nXr.iterator();
                        while (it.hasNext()) {
                            weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).aWn();
                            }
                        }
                    }
                    aWk();
                    return;
                }
                return;
            }
            if (i2 == 17 && this.nXr != null) {
                it = this.nXr.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).aWo();
                    }
                }
            }
            if (this.nXr != null) {
                Iterator it2 = this.nXr.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b) kVar).jgc);
                    }
                }
            }
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 492) {
                bcu = ((com.tencent.mm.plugin.location.model.a.c) kVar).nXP;
                if (!(bcu == null || bcu.wRa == null)) {
                    if (bcu.wRa.vQL == 12) {
                        this.fid = true;
                        if (this.nXA != null) {
                            this.nXA.aWm();
                        }
                    } else {
                        this.fid = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", Boolean.valueOf(this.fid), Integer.valueOf(bcu.wRa.vQL));
                }
                if (this.nXo > 0) {
                    g.pWK.h(10997, "9", "", Integer.valueOf(this.nXo), Integer.valueOf(0));
                }
                this.nXo = 0;
                this.nXp = ((com.tencent.mm.plugin.location.model.a.c) kVar).nXM;
                int i3 = ((com.tencent.mm.plugin.location.model.a.c) kVar).nXQ;
                if (this.nXr != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    Iterator it3 = this.nXr.iterator();
                    while (it3.hasNext()) {
                        weakReference = (WeakReference) it3.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c) kVar).nXP);
                        }
                    }
                }
                if (!(this.nXs == 1)) {
                    aWj();
                }
                this.mHandler.removeMessages(1);
                if (aWl() && !this.nXz && !this.fid) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nXp);
                }
            } else if (kVar.getType() == 491) {
                l.aWb().Ej("");
            }
        } else if (kVar.getType() == 492) {
            this.nXo++;
            this.mHandler.removeMessages(1);
            if (this.nXo >= 10) {
                this.mHandler.removeMessages(1);
                if (this.nXr != null) {
                    Iterator it4 = this.nXr.iterator();
                    while (it4.hasNext()) {
                        weakReference = (WeakReference) it4.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c) kVar).jgc);
                        }
                    }
                }
            } else if (aWl() && !this.nXz) {
                bcu = ((com.tencent.mm.plugin.location.model.a.c) kVar).nXP;
                if (!(bcu == null || bcu.wRa == null)) {
                    if (bcu.wRa.vQL == 12) {
                        this.fid = true;
                        if (this.nXA != null) {
                            this.nXA.aWm();
                        }
                    } else {
                        this.fid = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", Boolean.valueOf(this.fid), Integer.valueOf(bcu.wRa.vQL));
                }
                if (!this.fid) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nXp);
                }
            }
        }
    }
}
