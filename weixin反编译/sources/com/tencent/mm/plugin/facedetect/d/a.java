package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.c.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static final String mmX = (o.aHw() + File.separator + "fdv_v_");
    public static final String mnc = (h.getExternalStorageDirectory().getAbsolutePath() + "/temp_debug_raw.spx");
    c fkr;
    private com.tencent.mm.audio.b.c.a fle = new com.tencent.mm.audio.b.c.a() {
        short[] iaq;

        public final void q(byte[] bArr, int i) {
            int i2;
            x.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", Integer.valueOf(i));
            if (this.iaq == null || this.iaq.length < i / 2) {
                this.iaq = new short[(i / 2)];
            }
            for (i2 = 0; i2 < i / 2; i2++) {
                this.iaq[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            }
            a.a(a.this, this.iaq, i / 2);
            if (a.this.iao != null) {
                a.this.iao.c(this.iaq, i / 2);
                if (a.this.iai != null) {
                    i2 = a.this.iai.a(new com.tencent.mm.audio.b.g.a(bArr, i), 0);
                } else {
                    i2 = -1;
                }
                if (-1 == i2 && a.this.mmY != null) {
                    a.this.mmY.onError(3);
                    a.this.aHz();
                    x.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                    return;
                }
                return;
            }
            if (a.this.mmY != null) {
                a.this.mmY.onError(1);
                a.this.aHz();
            }
            x.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
        }

        public final void aK(int i, int i2) {
            x.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
            a.this.aHz();
            if (a.this.mmY != null) {
                a.this.mmY.onError(2);
            }
        }
    };
    boolean iaK = true;
    private int iac = 0;
    int iad = 0;
    com.tencent.mm.audio.c.a iai;
    com.tencent.mm.bf.a.c iao;
    private com.tencent.mm.bf.a.c.a iap = new com.tencent.mm.bf.a.c.a() {
        public final void a(short[] sArr, int i) {
            x.d("MicroMsg.FaceVoiceRecordLogic", "onFilteredSpeakVoice data %s size %d", sArr, Integer.valueOf(i));
        }

        public final void Vc() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSpeakToSilent");
        }

        public final void Vd() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "hy: onSilentToSpeak");
            if (a.this.mmY != null) {
                a.this.mmY.aHA();
            }
        }

        public final void uZ() {
            x.d("MicroMsg.FaceVoiceRecordLogic", "Silent enough to finish");
            if (a.this.mmY != null) {
                a.this.mmY.onError(11);
            }
        }
    };
    b mmY = null;
    boolean mmZ = false;
    String mna = "";
    ArrayList<com.tencent.mm.audio.b.c.a> mnb = new ArrayList(5);
    public com.tencent.mm.audio.b.c.a mnd = new com.tencent.mm.audio.b.c.a() {
        public final void q(byte[] bArr, int i) {
            if (a.this.mnb != null) {
                Iterator it = a.this.mnb.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.audio.b.c.a aVar = (com.tencent.mm.audio.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.q(bArr, i);
                    }
                }
            }
        }

        public final void aK(int i, int i2) {
            if (a.this.mnb != null) {
                Iterator it = a.this.mnb.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.audio.b.c.a aVar = (com.tencent.mm.audio.b.c.a) it.next();
                    if (aVar != null) {
                        aVar.aK(i, i2);
                    }
                }
            }
        }
    };

    public interface b {
        void aHA();

        void onError(int i);
    }

    private class a implements Runnable {
        private Runnable mnf;

        /* synthetic */ a(a aVar, Runnable runnable, byte b) {
            this(runnable);
        }

        private a(Runnable runnable) {
            this.mnf = null;
            this.mnf = runnable;
        }

        public final void run() {
            synchronized (a.this) {
                if (a.this.mmZ) {
                    x.w("MicroMsg.FaceVoiceRecordLogic", "hy: already called stop. should not start record");
                } else {
                    x.i("MicroMsg.FaceVoiceRecordLogic", "hy: initDeviceInLock");
                    a.this.mna = a.mmX + bi.Wz() + ".spx";
                    try {
                        new File(a.this.mna).delete();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "hy: delete file failed", new Object[0]);
                    }
                    a.this.fkr = new c(16000, 1, 3);
                    a.this.fkr.fkT = -19;
                    a.this.fkr.aQ(false);
                    a.this.iai = new e();
                    if (a.this.iai.cL(a.this.mna)) {
                        if (q.gHP.gGB > 0) {
                            a.this.fkr.n(q.gHP.gGB, true);
                        } else {
                            a.this.fkr.n(5, false);
                        }
                        a.this.fkr.et(50);
                        a.this.fkr.aR(false);
                        try {
                            a.this.iao = new com.tencent.mm.bf.a.c(5000, 16000, com.tencent.mm.bf.a.c.hbz.getInt("sil_time", 200), com.tencent.mm.bf.a.c.hbz.getFloat("s_n_ration", 2.5f), com.tencent.mm.bf.a.c.hbz.getInt("s_window", 50), com.tencent.mm.bf.a.c.hbz.getInt("s_length", 35), com.tencent.mm.bf.a.c.hbz.getInt("s_delay_time", 20), false, false);
                            a.this.iao.iaT = a.this.iap;
                        } catch (Throwable e2) {
                            x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init VoiceDetectAPI failed :" + e2.getMessage());
                            if (a.this.mmY != null) {
                                a.this.mmY.onError(6);
                            }
                        }
                        a.this.fkr.fle = a.this.mnd;
                        a.this.a(a.this.fle);
                        if (!a.this.fkr.vs()) {
                            x.e("MicroMsg.FaceVoiceRecordLogic", "hy: start record failed");
                            if (a.this.mmY != null) {
                                a.this.mmY.onError(7);
                            }
                        } else if (this.mnf != null) {
                            this.mnf.run();
                        }
                    } else {
                        x.e("MicroMsg.FaceVoiceRecordLogic", "hy: init speex writer failed");
                        a.this.iai.vK();
                        a.this.iai = null;
                        if (a.this.mmY != null) {
                            a.this.mmY.onError(5);
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > aVar.iac) {
                aVar.iac = s;
            }
        }
    }

    public final void aHz() {
        com.tencent.mm.loader.stub.b.deleteFile(this.mna);
    }

    public final void a(com.tencent.mm.audio.b.c.a aVar) {
        this.mnb.add(aVar);
    }
}
