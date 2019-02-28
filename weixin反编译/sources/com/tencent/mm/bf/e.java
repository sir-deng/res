package com.tencent.mm.bf;

import android.os.Message;
import com.tencent.mm.ad.k;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;

public final class e implements com.tencent.mm.ad.e {
    public static int fmB = 100;
    private static final String iaa = (w.hbv + "tmp_voiceaddr.spx");
    private static final String iab = (w.hbv + "tmp_voiceaddr.amr");
    c fkr;
    private com.tencent.mm.audio.b.c.a fle = new com.tencent.mm.audio.b.c.a() {
        public final void q(byte[] bArr, int i) {
            int i2;
            x.d("MicroMsg.SceneVoiceAddr", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            com.tencent.qqpinyin.voicerecoapi.c.a aVar = new com.tencent.qqpinyin.voicerecoapi.c.a();
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            if (e.this.iaj != null) {
                e.this.iaj.a(sArr, i / 2, aVar);
            }
            e.a(e.this, sArr, i / 2);
            if (e.this.iai != null) {
                i2 = e.this.iai.a(new com.tencent.mm.audio.b.g.a(bArr, i), 0);
            } else {
                i2 = -1;
            }
            if (-1 == i2) {
                e.this.finish();
                x.e("MicroMsg.SceneVoiceAddr", "write to file failed");
                return;
            }
            e eVar = e.this;
            eVar.iad = i2 + eVar.iad;
            if (e.this.iad > 3300 && !e.this.iae) {
                x.d("MicroMsg.SceneVoiceAddr", "sendEmptyMessage(0)");
                e.this.handler.sendEmptyMessage(0);
                e.this.iae = true;
            }
            if (aVar.Aad == 2 || aVar.Aad == 3) {
                x.i("MicroMsg.SceneVoiceAddr", "state.vad_flag: " + aVar.Aad);
                e.this.finish();
            }
        }

        public final void aK(int i, int i2) {
        }
    };
    public int hZV = 1;
    ag handler = new ag() {
        public final void handleMessage(Message message) {
            if (message.what == 2) {
                if (e.this.iah != null) {
                    e.this.iah.Va();
                }
            } else if (message.what == 0) {
                if (e.this.hZV == 0) {
                    x.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                    g.CN().a(349, e.this);
                } else {
                    g.CN().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, e.this);
                }
                if (e.this.hZV != 0) {
                    e.this.iak = new c(e.d(e.this), e.this.hZV);
                } else if (e.this.iag) {
                    e.this.iak = new d(e.d(e.this), 1);
                } else {
                    e.this.iak = new d(e.d(e.this), 0);
                }
                g.CN().a(e.this.iak, 0);
            } else if (message.what == 3 && e.this.iah != null) {
                e.this.iah.a(new String[0], -1);
            }
        }
    };
    public int iac = 0;
    int iad = 0;
    boolean iae = false;
    private int iaf = 500000;
    public boolean iag = false;
    b iah = null;
    com.tencent.mm.audio.c.a iai;
    com.tencent.qqpinyin.voicerecoapi.c iaj = null;
    private a iak = null;

    class a implements Runnable {
        public final void run() {
            synchronized (e.this) {
                x.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(e.d(e.this)).delete();
                } catch (Exception e) {
                    x.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + e.d(e.this), e);
                }
                e.this.fkr = new c(e.this.iag ? 8000 : 16000, 1, 3);
                e.this.fkr.fkT = -19;
                e.this.fkr.aQ(false);
                if (!e.this.iag) {
                    e.this.iai = new com.tencent.mm.audio.c.e();
                    if (!e.this.iai.cL(e.d(e.this))) {
                        x.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        e.this.iai.vK();
                        e.this.iai = null;
                    }
                }
                if (e.this.iag || q.gHP.gGB <= 0) {
                    e.this.fkr.n(5, false);
                } else {
                    e.this.fkr.n(q.gHP.gGB, true);
                }
                e.this.fkr.aR(false);
                e.this.iaj = new com.tencent.qqpinyin.voicerecoapi.c(e.this.iaf);
                int start = e.this.iaj.start();
                if (start != 0) {
                    x.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + start);
                    e.this.reset();
                } else {
                    e.this.fkr.fle = e.this.fle;
                    if (!e.this.fkr.vs()) {
                        x.e("MicroMsg.SceneVoiceAddr", "start record failed");
                        e.this.reset();
                    }
                }
            }
        }
    }

    public interface b {
        void UZ();

        void Va();

        void a(String[] strArr, long j);
    }

    static /* synthetic */ void a(e eVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > eVar.iac) {
                eVar.iac = s;
            }
        }
    }

    static /* synthetic */ String d(e eVar) {
        return !eVar.iag ? iaa : iab;
    }

    public e(b bVar, int i) {
        int i2 = 500000;
        this.iah = bVar;
        this.hZV = i;
        if (this.hZV != 1) {
            i2 = 1500000;
        }
        this.iaf = i2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hZV == 0) {
            x.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            g.CN().b(349, (com.tencent.mm.ad.e) this);
        } else {
            g.CN().b((int) com.tencent.mm.plugin.appbrand.jsapi.a.b.CTRL_INDEX, (com.tencent.mm.ad.e) this);
        }
        String[] UT = ((a) kVar).UT();
        long UU = ((a) kVar).UU();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(UT == null ? -1 : UT.length);
        x.i(str2, str3, objArr);
        if (this.iah == null) {
            return;
        }
        if (i2 == 0 && i == 0) {
            this.iah.a(UT, UU);
            return;
        }
        this.iah.UZ();
        cancel();
    }

    private void finish() {
        x.i("MicroMsg.SceneVoiceAddr", "finish");
        x.k("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.iak != null) {
            this.iak.US();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.iae) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
    }

    public final void cancel() {
        this.iah = null;
        finish();
    }

    private void reset() {
        x.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            if (this.fkr != null) {
                this.fkr.vj();
                this.fkr = null;
            }
            if (this.iai != null) {
                this.iai.vK();
                this.iai = null;
            }
            if (this.iaj != null) {
                this.iaj.stop();
            }
            this.iaj = null;
            if (this.iak != null) {
                this.iak.US();
                this.iak = null;
            }
            this.iad = 0;
            this.iae = false;
        }
    }
}
