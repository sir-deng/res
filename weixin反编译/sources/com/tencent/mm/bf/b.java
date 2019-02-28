package com.tencent.mm.bf;

import android.os.Message;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.n;
import com.tencent.mm.ad.n.AnonymousClass4;
import com.tencent.mm.bf.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.buq;
import com.tencent.mm.protocal.c.bus;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b extends a implements k {
    private String filename = null;
    private e gLE;
    private int hQL = 0;
    private boolean hYm = false;
    private int hZI = 120;
    g hZJ;
    private boolean hZK = false;
    private boolean hZL = false;
    private int hZM = 0;
    private bet hZN = null;
    private String[] hZO = new String[0];
    private int hZP = 3960;
    private ag hZQ = new ag(g.Dt().oFY.getLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == JsApiCreateAudioInstance.CTRL_INDEX && b.this.UW()) {
                g.CN().a(b.this, 0);
            }
        }
    };
    private int retCode = 0;

    public final void US() {
        this.hYm = true;
    }

    public final String[] UT() {
        return this.hZO;
    }

    public final long UU() {
        return 0;
    }

    public final Set<String> UV() {
        g gVar = this.hZJ;
        Set<String> hashSet = new HashSet();
        gVar.iaw.readLock().lock();
        for (a aVar : gVar.iav.values()) {
            if (aVar.iaz) {
                hashSet.add(aVar.iay);
            }
        }
        gVar.iaw.readLock().unlock();
        return hashSet;
    }

    public b(String str, String str2, String str3) {
        this.filename = str;
        this.hZJ = new g(str2);
        this.hZN = new bet().Vf(str3);
        x.i("MicroMsg.NetSceneNewVoiceInput", "NetSceneNewVoiceInput filename:%s,session:%s,vadVersion:%s", str, str2, str3);
    }

    public final boolean UW() {
        x.d("MicroMsg.NetSceneNewVoiceInput", "preDoScene");
        this.hZQ.removeMessages(JsApiCreateAudioInstance.CTRL_INDEX);
        if ((this.hZJ.Vg() && this.hYm) || this.hZK) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "preDoScene return");
            return false;
        }
        a iR = this.hZJ.iR(this.hQL);
        if (iR != null) {
            int min = Math.min(com.tencent.mm.a.e.bN(this.filename), iR.iaB);
            x.d("MicroMsg.NetSceneNewVoiceInput", "fileLength %s info.voiceFileMark %s nowMarkLen %s", Integer.valueOf(r3), Integer.valueOf(iR.iaB), Integer.valueOf(min));
            if (min <= 0) {
                x.e("MicroMsg.NetSceneNewVoiceInput", "nowMarkLen <= 0 read failed :%s", this.filename);
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.hZM = 0;
                UX();
                this.gLE.a(3, -1, "ReadFileLengthError", null);
                return false;
            }
            this.hZM = min - this.hQL;
            if (this.hZM < 0) {
                x.i("MicroMsg.NetSceneNewVoiceInput", "canReadLen < 0 length:%s ", Integer.valueOf(this.hZM));
                this.retCode = com.tencent.mm.compatible.util.g.getLine() + 40000;
                this.hZQ.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hZI * 2));
                return false;
            }
            x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s,reqSeq:%s,interval:%s", Integer.valueOf(this.hZM), Integer.valueOf(iR.iaC), Integer.valueOf(this.hZI));
            if (this.hZM >= 500 || iR.iaC <= 5) {
                this.hZQ.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) this.hZI);
            } else {
                x.d("MicroMsg.NetSceneNewVoiceInput", "can read length : %s double interval", Integer.valueOf(this.hZM));
                this.hZQ.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hZI * 2));
            }
            return true;
        }
        this.hZQ.sendEmptyMessageDelayed(JsApiCreateAudioInstance.CTRL_INDEX, (long) (this.hZI * 2));
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new buq();
        aVar.hnU = new bus();
        aVar.uri = "/cgi-bin/micromsg-bin/voicetrans";
        aVar.hnS = 235;
        aVar.hnV = 381;
        aVar.hnW = 1000000381;
        q Kf = aVar.Kf();
        Kf.Kh().vHW = false;
        buq buq = (buq) Kf.hnQ.hnY;
        a iR = this.hZJ.iR(this.hQL);
        if (iR == null) {
            buq.weD = new bes();
            buq.vUN = this.hQL;
            buq.wZM = "0";
            buq.vSa = 1;
            buq.wZO = 2;
            buq.vVz = 0;
            buq.xcb = this.hZJ.Vf();
            buq.xca = buq.xcb == null ? 0 : buq.xcb.size();
            buq.wQB = this.hZN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            Iterator it = buq.xcb.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((bet) it.next()).wRo).append(", ");
            }
            stringBuilder.append("]");
            x.d("MicroMsg.NetSceneNewVoiceInput", "send empty packet fetch %s time %s", stringBuilder.toString(), Long.valueOf(System.currentTimeMillis()));
            return a(eVar, Kf, this);
        }
        int i;
        iR.iaz = true;
        if (this.hZL) {
            iR.iaA = true;
            buq.weD = new bes();
            x.i("MicroMsg.NetSceneNewVoiceInput", "send last packet");
        } else {
            if (this.hZM > this.hZP) {
                this.hZM = this.hZP;
                iR.iaA = false;
            } else if (this.hZM <= this.hZP && (iR.iaB != Integer.MAX_VALUE || this.hYm)) {
                iR.iaA = true;
            }
            buq.weD = new bes().bl(com.tencent.mm.a.e.d(this.filename, this.hQL, this.hZM));
        }
        buq.vUN = this.hQL;
        buq.wZM = iR.iay;
        if (iR.iaA) {
            i = 1;
        } else {
            i = 0;
        }
        buq.vSa = i;
        buq.wZO = 2;
        i = iR.iaC + 1;
        iR.iaC = i;
        buq.vVz = i;
        buq.xcb = this.hZJ.Vf();
        buq.xca = buq.xcb == null ? 0 : buq.xcb.size();
        buq.wQB = this.hZN;
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s, read filename: %s, voiceFileMarkEnd: %s, oldReadOffset: %s, canReadLen %s, getILen %s, isRequestEnd: %s, Seq %s, FetchVoiceIds %s, VadVersion %s", com.tencent.mm.compatible.util.g.zo(), this.filename, Integer.valueOf(iR.iaB), Integer.valueOf(this.hQL), Integer.valueOf(this.hZM), Integer.valueOf(buq.weD.wRk), Boolean.valueOf(iR.iaA), Integer.valueOf(buq.vVz), buq.xcb, buq.wQB);
        this.hQL = buq.weD.wRk + this.hQL;
        x.i("MicroMsg.NetSceneNewVoiceInput", "clientId %s oldReadOffset %s", iR.iay, Integer.valueOf(this.hQL));
        if (iR.iaC == 1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "time flee send seq 1 time = %s", Long.valueOf(System.currentTimeMillis()));
        }
        x.d("MicroMsg.NetSceneNewVoiceInput", "send dispatch packet time %s", Long.valueOf(System.currentTimeMillis()));
        return a(eVar, Kf, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    protected final void a(a aVar) {
        x.w("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zo() + " setSecurityCheckError e: %s", aVar);
        if (aVar == a.EReachMaxLimit) {
            UX();
            this.gLE.a(3, -1, "SecurityCheckError", this);
        }
    }

    protected final boolean Kl() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s time:%s errType: %s, errCode: %s, errMsg: %s", com.tencent.mm.compatible.util.g.zo(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 3 && i3 == -1) {
            x.i("MicroMsg.NetSceneNewVoiceInput", "getStack([ %s ]), ThreadID: %s", bi.chl(), Long.valueOf(Thread.currentThread().getId()));
        }
        buq buq = (buq) ((com.tencent.mm.ad.b) qVar).hnQ.hnY;
        bus bus = (bus) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd voiceId = %s, seq = %s, time = %s", buq.wZM, Integer.valueOf(buq.vVz), Long.valueOf(System.currentTimeMillis()));
            this.hZJ.X(bus.xcf);
            if (this.hZJ.Vg() && this.hYm) {
                x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd isAllRespEnd && isRecordFinish");
                UY();
            }
            this.hZO = new String[]{this.hZJ.getResult()};
            this.gLE.a(i2, i3, str, this);
            this.hZP = bus.xcg <= 0 ? this.hZP : bus.xcg;
            this.hZI = bus.wOD < 0 ? 120 : bus.wOD;
            x.d("MicroMsg.NetSceneNewVoiceInput", "onGYNetEnd max_send_byte_per_pack = %s, interval = %s", Integer.valueOf(this.hZP), Integer.valueOf(this.hZI));
            return;
        }
        x.i("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zo() + " onGYNetEnd file: %s errType:%s errCode:%s", this.filename, Integer.valueOf(i2), Integer.valueOf(i3));
        UX();
        this.gLE.a(i2, i3, str, this);
    }

    public final void UX() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zo());
        if (!this.hZL) {
            this.hZL = true;
            UY();
            n CN = g.CN();
            x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(hashCode()));
            CN.hoG.F(new AnonymousClass4(r1));
            final a iR = this.hZJ.iR(this.hQL);
            if (iR != null) {
                this.hZM = 0;
                g.Dt().F(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", iR.iay, Integer.valueOf(iR.iaB), Integer.valueOf(b.this.hashCode()));
                        g.CN().a(b.this, 0);
                    }
                });
            }
        }
    }

    private void UY() {
        x.d("MicroMsg.NetSceneNewVoiceInput", com.tencent.mm.compatible.util.g.zo());
        if (this.hZQ != null) {
            this.hZQ.removeMessages(JsApiCreateAudioInstance.CTRL_INDEX);
        }
        this.hZK = true;
    }

    public final int getType() {
        return 235;
    }

    public final void iQ(int i) {
        x.d("MicroMsg.NetSceneNewVoiceInput", "%s %s", com.tencent.mm.compatible.util.g.zo(), Integer.valueOf(i));
        if (i < 0) {
            throw new IllegalStateException();
        }
        this.hZJ.iQ(i);
    }
}
