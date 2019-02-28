package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import org.xwalk.core.XWalkUpdater;

public final class j implements d {
    AudioTrack afZ;
    private int fDM;
    String fileName;
    b fmy;
    String hYE;
    String hYF;
    OnCompletionListener hYO;
    OnErrorListener hYP;
    a hYS;
    d.b hYT;
    private int hYU;
    private int hYV;
    private int hYW;
    private Runnable hYX;
    com.tencent.qqpinyin.voicerecoapi.a hYY;
    private int hYZ;
    int hZa;
    boolean hZb;
    byte[] hZc;
    int hZd;
    FileInputStream hZe;
    int hZf;
    int status;

    static /* synthetic */ void a(j jVar) {
        if (jVar.hYX != null) {
            e.S(jVar.hYX);
            jVar.hYX = null;
        }
    }

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        this.fileName = "";
        this.hYS = null;
        this.hYT = null;
        this.status = 0;
        this.hYU = 2;
        this.hYV = 16000;
        this.fDM = 1;
        this.hYW = 20;
        this.hYY = null;
        this.hZa = 0;
        this.hZb = false;
        this.hYE = "";
        this.hYF = "";
        this.hZc = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE];
        this.hZd = 0;
        this.hZe = null;
        this.hZf = d.CTRL_INDEX;
        this.hYO = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (j.this.fmy != null) {
                    j.this.fmy.zk();
                }
                try {
                    j.this.status = 0;
                    j.this.UI();
                    try {
                        j.a(j.this);
                    } catch (Throwable e) {
                        x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e2));
                    x.e("MicroMsg.SpeexPlayer", "setCompletion File[" + j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
            }
        };
        this.hYP = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.SpeexPlayer", "onError");
                if (j.this.fmy != null) {
                    j.this.fmy.zk();
                }
                if (j.this.hYT != null) {
                    j.this.hYT.onError();
                }
                try {
                    j.this.status = -1;
                    j.this.UI();
                    try {
                        j.a(j.this);
                    } catch (Throwable e) {
                        x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                return false;
            }
        };
        this.hYY = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.hYY;
        if (aVar.Aaa != 0) {
            i = -103;
        } else {
            int nativeTRSpeexDecodeInit = aVar.Aab.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == XWalkUpdater.ERROR_SET_VERNUM || nativeTRSpeexDecodeInit == -102) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.Aaa = nativeTRSpeexDecodeInit;
                aVar.zZY = new byte[(com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i != 0) {
            x.e("speex", "res: " + i);
        }
    }

    public j(Context context) {
        this();
        this.fmy = new b(context);
    }

    public final void a(a aVar) {
        this.hYS = aVar;
    }

    public final void a(d.b bVar) {
        this.hYT = bVar;
    }

    final void UI() {
        if (this.afZ != null) {
            this.afZ.stop();
            this.afZ.release();
            this.afZ = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aO(boolean r9) {
        /*
        r8 = this;
        r3 = 0;
        r1 = 3;
        r7 = 1;
        r6 = 0;
        r4 = 2;
        r8.hZb = r7;
        r0 = r8.fDM;
        if (r0 != r4) goto L_0x0052;
    L_0x000b:
        r8.hYU = r1;
    L_0x000d:
        r0 = r8.hYV;
        r2 = r8.hYU;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r4);
        r8.hYZ = r0;
        r0 = r8.afZ;
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        r0 = r8.afZ;	 Catch:{ Exception -> 0x0055 }
        r0.stop();	 Catch:{ Exception -> 0x0055 }
        r0 = r8.afZ;	 Catch:{ Exception -> 0x0055 }
        r0.release();	 Catch:{ Exception -> 0x0055 }
        r8.afZ = r3;
    L_0x0027:
        if (r9 == 0) goto L_0x0067;
    L_0x0029:
        r0 = r1;
    L_0x002a:
        r2 = com.tencent.mm.compatible.e.q.gHG;
        r2 = r2.gEr;
        if (r2 == 0) goto L_0x007c;
    L_0x0030:
        r2 = com.tencent.mm.compatible.e.q.gHG;
        r2.dump();
        r2 = com.tencent.mm.compatible.e.q.gHG;
        r2 = r2.gEy;
        if (r2 != r7) goto L_0x007c;
    L_0x003b:
        r0 = new com.tencent.mm.compatible.b.d;
        r2 = r8.hYV;
        r3 = r8.hYU;
        r5 = r8.hYZ;
        r5 = r5 * 8;
        r0.<init>(r1, r2, r3, r4, r5);
        r8.afZ = r0;
        r0 = r8.afZ;	 Catch:{ Exception -> 0x0069 }
        r0.play();	 Catch:{ Exception -> 0x0069 }
    L_0x004f:
        r8.hZb = r6;
        return;
    L_0x0052:
        r8.hYU = r4;
        goto L_0x000d;
    L_0x0055:
        r0 = move-exception;
        r2 = "MicroMsg.SpeexPlayer";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r0);	 Catch:{ all -> 0x0063 }
        r8.afZ = r3;
        goto L_0x0027;
    L_0x0063:
        r0 = move-exception;
        r8.afZ = r3;
        throw r0;
    L_0x0067:
        r0 = r6;
        goto L_0x002a;
    L_0x0069:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = new java.lang.Object[r7];
        r0 = r0.getMessage();
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x004f;
    L_0x007c:
        r1 = r0;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.aO(boolean):void");
    }

    public final boolean K(String str, boolean z) {
        return L(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return L(str, z);
    }

    private boolean L(String str, boolean z) {
        if (this.status != 0) {
            x.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            return false;
        }
        x.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            ce(z);
        } catch (Throwable e) {
            try {
                ce(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                this.status = -1;
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ce(boolean r9) {
        /*
        r8 = this;
        r1 = 3;
        r7 = 1;
        r6 = 0;
        r0 = r8.fileName;
        r0 = com.tencent.mm.a.e.bO(r0);
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r9 == 0) goto L_0x00a8;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r2 = com.tencent.mm.compatible.e.q.gHG;	 Catch:{ Exception -> 0x006e }
        r2 = r2.gEr;	 Catch:{ Exception -> 0x006e }
        if (r2 == 0) goto L_0x00c1;
    L_0x0015:
        r2 = com.tencent.mm.compatible.e.q.gHG;	 Catch:{ Exception -> 0x006e }
        r2.dump();	 Catch:{ Exception -> 0x006e }
        r2 = com.tencent.mm.compatible.e.q.gHG;	 Catch:{ Exception -> 0x006e }
        r2 = r2.gEy;	 Catch:{ Exception -> 0x006e }
        if (r2 != r7) goto L_0x00c1;
    L_0x0020:
        r0 = r8.hYV;	 Catch:{ Exception -> 0x006e }
        r2 = r8.hYU;	 Catch:{ Exception -> 0x006e }
        r3 = 2;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r3);	 Catch:{ Exception -> 0x006e }
        r8.hYZ = r0;	 Catch:{ Exception -> 0x006e }
        r8.UI();	 Catch:{ Exception -> 0x006e }
        r0 = new com.tencent.mm.compatible.b.d;	 Catch:{ Exception -> 0x006e }
        r2 = r8.hYV;	 Catch:{ Exception -> 0x006e }
        r3 = r8.hYU;	 Catch:{ Exception -> 0x006e }
        r4 = 2;
        r5 = r8.hYZ;	 Catch:{ Exception -> 0x006e }
        r5 = r5 * 8;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x006e }
        r8.afZ = r0;	 Catch:{ Exception -> 0x006e }
        r0 = r8.hYV;	 Catch:{ Exception -> 0x006e }
        r0 = r0 / 1000;
        r1 = r8.fDM;	 Catch:{ Exception -> 0x006e }
        r0 = r0 * r1;
        r1 = r8.hYW;	 Catch:{ Exception -> 0x006e }
        r0 = r0 * r1;
        r0 = r0 * 2;
        r8.hZf = r0;	 Catch:{ Exception -> 0x006e }
        r0 = r8.fmy;	 Catch:{ Exception -> 0x006e }
        if (r0 == 0) goto L_0x0055;
    L_0x0050:
        r0 = r8.fmy;	 Catch:{ Exception -> 0x006e }
        r0.requestFocus();	 Catch:{ Exception -> 0x006e }
    L_0x0055:
        r0 = r8.afZ;	 Catch:{ Exception -> 0x006e }
        if (r0 == 0) goto L_0x000b;
    L_0x0059:
        r0 = r8.afZ;	 Catch:{ Exception -> 0x00ab }
        r0.play();	 Catch:{ Exception -> 0x00ab }
        r0 = new com.tencent.mm.modelvoice.j$3;	 Catch:{ Exception -> 0x006e }
        r0.<init>();	 Catch:{ Exception -> 0x006e }
        r8.hYX = r0;	 Catch:{ Exception -> 0x006e }
        r0 = r8.hYX;	 Catch:{ Exception -> 0x006e }
        r1 = "SpeexPlayer_play";
        com.tencent.mm.sdk.f.e.post(r0, r1);	 Catch:{ Exception -> 0x006e }
        goto L_0x000b;
    L_0x006e:
        r0 = move-exception;
        r1 = r8.fmy;
        if (r1 == 0) goto L_0x0078;
    L_0x0073:
        r1 = r8.fmy;
        r1.zk();
    L_0x0078:
        r8.UI();
        r1 = "MicroMsg.SpeexPlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "playImp : fail, exception = ";
        r2.<init>(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "exception:%s";
        r3 = new java.lang.Object[r7];
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        goto L_0x000b;
    L_0x00a8:
        r0 = r6;
        goto L_0x000f;
    L_0x00ab:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r2 = "audioTrack error:%s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x006e }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x006e }
        r3[r4] = r0;	 Catch:{ Exception -> 0x006e }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x006e }
        goto L_0x000b;
    L_0x00c1:
        r1 = r0;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.ce(boolean):void");
    }

    public final boolean aM(boolean z) {
        if (this.status != 1) {
            return false;
        }
        this.status = 2;
        synchronized (this.hYF) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.hYF.wait();
                x.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.fmy != null && z) {
                    this.fmy.zk();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                if (this.fmy != null && z) {
                    this.fmy.zk();
                }
                return false;
            } catch (Throwable th) {
                if (this.fmy != null && z) {
                    this.fmy.zk();
                }
            }
        }
        return true;
    }

    public final boolean vd() {
        if (this.status != 2) {
            return false;
        }
        this.status = 1;
        synchronized (this.hYE) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.hYE.notify();
                x.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.fmy != null) {
                    this.fmy.requestFocus();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                if (this.fmy != null) {
                    this.fmy.requestFocus();
                }
                return false;
            } catch (Throwable th) {
                if (this.fmy != null) {
                    this.fmy.requestFocus();
                }
            }
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean vp() {
        x.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.hYE) {
                try {
                    this.hYE.notify();
                    if (this.fmy != null) {
                        this.fmy.zk();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SpeexPlayer", "exception:%s", bi.i(e));
                    UI();
                    if (this.fmy != null) {
                        this.fmy.zk();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.fmy != null) {
                        this.fmy.zk();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        return false;
    }

    public final double vg() {
        return 0.0d;
    }

    public final void b(b.a aVar) {
        if (aVar != null && this.fmy != null) {
            this.fmy.a(aVar);
        }
    }
}
