package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.protocal.c.cbb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public final class p implements e {
    public static final String tpv = (w.hbv + "tmp_wearvoicetotext.spx");
    public boolean fMC = false;
    public LinkedList<Integer> iUs = new LinkedList();
    public int tpA;
    public int tpB;
    public c tpw;
    public com.tencent.qqpinyin.voicerecoapi.c tpx;
    public com.tencent.mm.audio.c.e tpy;
    private int tpz = 0;

    class a extends com.tencent.mm.plugin.wear.model.f.c {
        public int pYL;
        public int toR = 2;
        public int toS;
        public cbb tpD;

        public a(int i, cbb cbb) {
            this.pYL = i;
            this.toS = CdnLogic.kMediaLittleAppPacket;
            this.tpD = cbb;
        }

        protected final void send() {
            try {
                byte[] aZ = com.tencent.mm.plugin.wear.model.a.bPh().tok.aZ(this.tpD.toByteArray());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(this.toR);
                    dataOutputStream.writeInt(this.pYL);
                    dataOutputStream.writeInt(this.toS);
                    if (aZ == null || aZ.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(aZ.length);
                        dataOutputStream.write(aZ);
                    }
                    aZ = byteArrayOutputStream.toByteArray();
                    x.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.toS), Integer.valueOf(aZ.length));
                    com.tencent.mm.plugin.wear.model.a.bPh().tok.aX(byteArrayOutputStream.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.toR), Integer.valueOf(this.pYL), Integer.valueOf(this.toS));
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
            }
        }

        public final String getName() {
            return "WearVoiceToTextTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e.p$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String gKi;

        public AnonymousClass1(String str) {
            this.gKi = str;
        }

        public final void run() {
            p.this.tpw = new c(p.tpv, this.gKi, p.this.tpA);
            as.CN().a(349, p.this);
            x.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
        }
    }

    public final void reset() {
        x.i("MicroMsg.Wear.VoiceToTextServer", "reset: sessionId=%s", Integer.valueOf(this.tpA));
        if (this.tpy != null) {
            this.tpy.vK();
            this.tpy = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset speexWriter");
        }
        if (this.tpx != null) {
            this.tpx.stop();
            this.tpx = null;
            x.i("MicroMsg.Wear.VoiceToTextServer", "reset voiceDetectAPI");
        }
        if (this.tpw != null) {
            this.tpw.hYm = true;
            as.CN().b(349, (e) this);
            as.CN().c(this.tpw);
            this.tpw = null;
        }
        this.tpB = 0;
        this.fMC = false;
        this.tpz = 0;
        this.tpA = -1;
        this.iUs.clear();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            cbb cbb;
            if (i != 0 || i2 != 0) {
                as.CN().b(349, (e) this);
                cbb = new cbb();
                cbb.xgB = cVar.talker;
                cbb.wmc = "";
                cbb.vKQ = -1;
                cbb.xhf = false;
                com.tencent.mm.plugin.wear.model.a.bPh().tor.a(new a(cVar.pYL, cbb));
            } else if (cVar.tpm) {
                as.CN().b(349, (e) this);
                cbb = new cbb();
                cbb.xgB = cVar.talker;
                if (bi.oN(cVar.tpl)) {
                    cbb.wmc = "";
                    cbb.vKQ = -1;
                    cbb.xhf = false;
                } else {
                    x.i("MicroMsg.Wear.VoiceToTextServer", "receive text: %s", cVar.tpl);
                    cbb.wmc = cVar.tpl;
                    cbb.vKQ = 0;
                    cbb.xhf = true;
                }
                com.tencent.mm.plugin.wear.model.a.bPh().tor.a(new a(cVar.pYL, cbb));
            }
        }
    }

    public final void a(int i, cba cba) {
        if (cba.vPr == null) {
            x.i("MicroMsg.Wear.VoiceToTextServer", "voice data is null");
            return;
        }
        byte[] toByteArray = cba.vPr.toByteArray();
        this.tpz += this.tpy.a(new com.tencent.mm.audio.b.g.a(toByteArray, cba.wgA), 0, false);
        x.i("MicroMsg.Wear.VoiceToTextServer", "write bytes: %d", Integer.valueOf(this.tpz));
        short[] sArr = new short[(cba.wgA / 2)];
        for (int i2 = 0; i2 < cba.wgA / 2; i2++) {
            sArr[i2] = (short) ((toByteArray[i2 * 2] & 255) | (toByteArray[(i2 * 2) + 1] << 8));
        }
        com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
        this.tpx.a(sArr, cba.wgA / 2, aVar);
        x.i("MicroMsg.Wear.VoiceToTextServer", "state.vad_flag: " + aVar.Aad);
        if (aVar.Aad == 2) {
            this.tpB = 1;
        } else if (aVar.Aad == 3) {
            this.tpB = 2;
        }
        if (this.tpB != 0) {
            if (this.tpB < 0) {
                if (this.iUs.size() > 10) {
                    this.iUs.removeLast();
                }
                this.iUs.addFirst(Integer.valueOf(i));
            }
            if (this.tpB == 1) {
                cbb cbb = new cbb();
                cbb.xgB = this.tpw.talker;
                cbb.wmc = "";
                cbb.vKQ = this.tpB;
                cbb.xhf = true;
                com.tencent.mm.plugin.wear.model.a.bPh().tor.a(new a(this.tpw.pYL, cbb));
                this.tpB = 0;
            }
        }
        if (!this.fMC && this.tpz > 3300) {
            this.fMC = true;
            as.CN().a(this.tpw, 0);
        }
    }
}
