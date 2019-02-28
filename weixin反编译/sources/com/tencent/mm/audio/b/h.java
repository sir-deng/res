package com.tencent.mm.audio.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class h implements com.tencent.mm.ad.h, com.tencent.mm.compatible.b.f.a {
    a flN = null;
    b flO;
    private a flP = null;
    private String flQ;
    private boolean flR = false;
    private boolean flS = false;
    long flT;
    long flU = 0;
    public int flV = 0;
    boolean flW = false;
    boolean flX = false;
    int flY = 0;
    private com.tencent.mm.compatible.b.b.a flZ = com.tencent.mm.compatible.b.b.a.UNKNOWN;
    protected com.tencent.mm.ad.h.b fma;
    protected com.tencent.mm.ad.h.a fmb = null;
    private boolean fmc = false;
    private al fmd = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            q.a(h.this.mFileName, h.this);
            m.UM().run();
            x.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.this.mFileName);
            return false;
        }
    }, true);
    String mFileName = "";

    private final class a implements Runnable {
        ag handler;

        public a() {
            this.handler = new ag(h.this) {
                public final void handleMessage(Message message) {
                    if (h.this.flY > 0) {
                        x.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (h.this.fma == null));
                        h.this.flY = 2;
                        if (h.this.fma != null) {
                            h.this.fma.Kg();
                        }
                    }
                }
            };
        }

        public final void run() {
            boolean z = true;
            synchronized (h.this) {
                if (h.this.flN == null) {
                    x.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                    return;
                }
                String str = h.this.mFileName;
                if (h.this.flX) {
                    z = false;
                }
                x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", q.M(str, z), Boolean.valueOf(h.this.flX));
                if (h.this.flN.cI(q.M(str, z))) {
                    h.this.flO.requestFocus();
                } else {
                    q.oc(h.this.mFileName);
                    h.this.mFileName = null;
                    h.this.flN = null;
                    x.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.this.mFileName + "]");
                }
                h.this.flU = bi.Wz();
                x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.this.mFileName + "] time:" + bi.bB(h.this.flT));
                this.handler.sendEmptyMessageDelayed(0, 1);
            }
        }
    }

    public h(Context context, boolean z) {
        this.flO = new b(context);
        this.flX = z;
        x.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
    }

    public final void reset() {
        if (this.flN != null) {
            this.flN.vj();
            this.flO.zk();
            x.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.flT = 0;
        this.flP = null;
        this.flZ = com.tencent.mm.compatible.b.b.a.UNKNOWN;
        this.flY = 0;
        this.flU = 0;
    }

    public final int vy() {
        return this.flV;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean isRecording() {
        if (this.flN != null && this.flN.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public final int getMaxAmplitude() {
        if (this.flN == null) {
            return 0;
        }
        return this.flN.getMaxAmplitude();
    }

    public final boolean cJ(String str) {
        x.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + str);
        reset();
        this.flQ = str;
        this.flT = bi.Wz();
        if (str == null) {
            x.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            return false;
        }
        this.flR = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((com.tencent.mm.y.q.Gc() & 16384) == 0) {
                this.flS = true;
            } else {
                this.flS = false;
            }
        }
        if (!this.flX) {
            if (this.flR) {
                this.mFileName = u.oi(com.tencent.mm.y.q.FY());
            } else if (this.flS) {
                this.mFileName = u.oi("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                return false;
            }
            f.xN().a((com.tencent.mm.compatible.b.f.a) this);
            this.flW = false;
            this.fmc = false;
            if (!f.xV() || f.xN().xS()) {
                vA();
            } else {
                this.fmc = true;
                f.xN().xP();
                ah.h(new Runnable() {
                    public final void run() {
                        if (!h.this.flW) {
                            x.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
                            h.this.vA();
                        }
                    }
                }, 1000);
            }
            return true;
        }
        this.mFileName = q.nZ(str);
        if (this.mFileName != null) {
        }
        x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        return false;
    }

    public final boolean cancel() {
        x.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            x.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
            if (this.flN != null) {
                this.flN.vj();
                this.flO.zk();
            }
        }
        f.xN().b((com.tencent.mm.compatible.b.f.a) this);
        if (this.fmc) {
            f.xN().xQ();
            this.fmc = false;
        }
        q.oa(this.mFileName);
        m.UM().run();
        if (!(this.flN == null || bi.oN(this.mFileName) || this.flX)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.gIR = this.mFileName;
            aVar.gIS = vz();
            aVar.gIT = 1;
            aVar.frq = this.flN.vk();
            g.pWK.k(10513, aVar.zi());
        }
        this.mFileName = "";
        return true;
    }

    public boolean vp() {
        boolean z = true;
        boolean z2 = false;
        if (this.fmd != null) {
            this.fmd.TN();
            this.fmd.removeCallbacksAndMessages(null);
        }
        f.xN().b((com.tencent.mm.compatible.b.f.a) this);
        if (this.fmc) {
            f.xN().xQ();
            this.fmc = false;
        }
        this.flV = (int) vz();
        x.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.flV));
        if (!(this.flN == null || bi.oN(this.mFileName) || this.flX)) {
            com.tencent.mm.compatible.h.a aVar = new com.tencent.mm.compatible.h.a();
            aVar.gIR = this.mFileName;
            aVar.gIS = (long) this.flV;
            aVar.gIT = 2;
            aVar.frq = this.flN.vk();
            g.pWK.k(10513, aVar.zi());
        }
        synchronized (this) {
            x.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", this.mFileName, this.flN);
            if (this.flN != null) {
                this.flN.vj();
                this.flO.zk();
            }
        }
        if (this.flY != 2) {
            q.oc(this.mFileName);
            this.mFileName = null;
            x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bi.bB(this.flT));
        } else {
            if (((long) this.flV) < 800 || (this.flR && ((long) this.flV) < 1000)) {
                x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.flV);
                q.oc(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                q.aa(this.mFileName, this.flV);
                m.UM().run();
                x.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.flY = -1;
        return z2;
    }

    public final long vz() {
        if (this.flU == 0) {
            return 0;
        }
        return bi.bB(this.flU);
    }

    public final void er(int i) {
        x.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + i);
        if (i == 1) {
            vA();
        }
    }

    final void vA() {
        if (!this.flW) {
            this.flW = true;
            if (this.flX) {
                this.flZ = com.tencent.mm.compatible.b.b.a.SPEEX;
                this.flN = new k();
            } else {
                boolean z;
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.cgf(), 0);
                if (com.tencent.mm.compatible.e.q.gHG.gEz == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
                    sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
                }
                x.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(com.tencent.mm.compatible.e.q.gHG.gEz), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
                this.flZ = sharedPreferences.getBoolean("settings_voicerecorder_mode", z) ? com.tencent.mm.compatible.b.b.a.PCM : com.tencent.mm.compatible.b.b.a.AMR;
                String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceFormat");
                String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceFormatToQQ");
                if (this.flZ == com.tencent.mm.compatible.b.b.a.PCM) {
                    if (4 == bi.getInt(value, 4) && g.b.vx()) {
                        this.flZ = com.tencent.mm.compatible.b.b.a.SILK;
                    }
                    if (this.flQ != null && this.flQ.endsWith("@qqim")) {
                        this.flZ = com.tencent.mm.compatible.b.b.a.AMR;
                    }
                }
                if (this.flZ == com.tencent.mm.compatible.b.b.a.PCM) {
                    x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                    this.flZ = com.tencent.mm.compatible.b.b.a.AMR;
                }
                x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.flZ, Boolean.valueOf(g.b.vx()));
                this.flN = new t(this.flZ);
            }
            com.tencent.mm.ad.h.a anonymousClass3 = new com.tencent.mm.ad.h.a() {
                public final void onError() {
                    h.this.flO.zk();
                    x.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.this.mFileName);
                    q.oc(h.this.mFileName);
                    if (h.this.fmb != null) {
                        h.this.fmb.onError();
                    }
                }
            };
            if (this.flN != null) {
                this.flN.a(anonymousClass3);
            }
            this.flP = new a();
            e.post(this.flP, "SceneVoiceRecorder_record");
            this.flY = 1;
            this.fmd.K(3000, 3000);
            x.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bi.bB(this.flT));
        }
    }

    public final void a(com.tencent.mm.ad.h.a aVar) {
        this.fmb = aVar;
    }

    public final void a(com.tencent.mm.ad.h.b bVar) {
        this.fma = bVar;
    }

    public final int vB() {
        if (this.flX) {
            return 1;
        }
        if (this.flZ == com.tencent.mm.compatible.b.b.a.PCM || this.flZ == com.tencent.mm.compatible.b.b.a.AMR) {
            return 0;
        }
        if (this.flZ == com.tencent.mm.compatible.b.b.a.SILK) {
            return 2;
        }
        return -1;
    }
}
