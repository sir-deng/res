package com.tencent.mm.audio.a;

import android.content.Context;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.g.b;
import com.tencent.mm.ad.g.c;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a implements g, com.tencent.mm.compatible.b.f.a {
    private static String fjT = null;
    private Context context;
    private d fjI;
    private boolean fjJ;
    private boolean fjK;
    private boolean fjL;
    private int fjM;
    private boolean fjN;
    private boolean fjO;
    private boolean fjP;
    private c fjQ;
    private g.d fjR;
    private String fjS;
    private com.tencent.mm.compatible.util.b.a fjU;
    public b fjV;
    public com.tencent.mm.ad.g.a fjW;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.fjI = null;
        this.context = null;
        this.fjJ = false;
        this.fjK = false;
        this.fjL = false;
        this.fjM = 0;
        this.fjN = false;
        this.fjO = false;
        this.fjP = true;
        this.fjS = null;
        this.fjU = new com.tencent.mm.compatible.util.b.a() {
            public final void es(int i) {
                x.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", Integer.valueOf(i));
                if (i == -2 || i == -3) {
                    if (a.this.isPlaying()) {
                        x.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", a.this.fjS, a.fjT);
                        if (a.this.fjS == null || a.this.fjS.equals(a.fjT)) {
                            a.this.aM(false);
                        }
                    }
                } else if (i == 1 || i == 2 || i == 3) {
                    a.this.vd();
                } else if (i == -1) {
                    a.this.aN(false);
                }
            }
        };
        this.fjV = null;
        this.context = context;
        this.fjM = i;
        com.tencent.mm.audio.b.g.b bVar = new com.tencent.mm.audio.b.g.b();
    }

    public final boolean isPlaying() {
        if (this.fjI == null) {
            return false;
        }
        return this.fjI.isPlaying();
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.fjM));
        Assert.assertTrue(str.length() > 0);
        fjT = this.fjS;
        this.fjS = str;
        String str2;
        if (FileOp.bO(z2 ? str : q.getFullPath(str))) {
            if (i == -1) {
                i = o.e(str, this.fjM, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fjI = new s(this.context);
                } else {
                    this.fjI = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fjI = new j(this.context);
                } else {
                    this.fjI = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fjI = new i(this.context);
                } else {
                    this.fjI = new i();
                }
            }
            if (this.fjI != null) {
                this.fjI.b(this.fjU);
            }
            this.fjJ = z;
            this.fjN = z;
            if (f.xN().xY() || f.xN().xS()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xN().xY()), Boolean.valueOf(f.xN().xS()));
                this.fjJ = false;
            }
            f.xN().h(this.fjJ, false);
            vf();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.fjM == 0) {
                str2 = q.getFullPath(str);
            }
            f.xN().a((com.tencent.mm.compatible.b.f.a) this);
            if (!f.xN().xY()) {
                f.xN().xP();
                this.fjO = true;
            }
            if (this.fjI.K(str2, this.fjJ)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            f.xN().xQ();
            this.fjO = false;
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.getFullPath(str);
        }
        objArr[1] = str;
        x.e(str2, str3, objArr);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(this.fjM));
        Assert.assertTrue(str.length() > 0);
        if (FileOp.bO(str)) {
            if (i == -1) {
                i = o.e(str, this.fjM, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fjI = new s(this.context);
                } else {
                    this.fjI = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fjI = new j(this.context);
                } else {
                    this.fjI = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fjI = new i(this.context);
                } else {
                    this.fjI = new i();
                }
            }
            if (this.fjI != null) {
                this.fjI.b(this.fjU);
            }
            this.fjJ = z;
            this.fjN = z;
            if (f.xN().xY() || f.xN().xS()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xN().xY()), Boolean.valueOf(f.xN().xS()));
                this.fjJ = false;
            }
            f.xN().h(this.fjJ, false);
            vf();
            setError();
            f.xN().a((com.tencent.mm.compatible.b.f.a) this);
            if (!f.xN().xY()) {
                f.xN().xP();
                this.fjO = true;
            }
            if (this.fjI.c(str, this.fjJ, i2)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            f.xN().xQ();
            this.fjO = false;
            return false;
        }
        x.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        return false;
    }

    public final boolean pause() {
        return aM(true);
    }

    public final boolean aM(boolean z) {
        if (this.fjI == null) {
            return false;
        }
        boolean aM;
        x.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.fjI.isPlaying()) {
            aM = this.fjI.aM(z);
        } else {
            aM = false;
        }
        if (aM) {
            if (this.fjO) {
                f.xN().xQ();
                this.fjO = false;
            }
            if (this.fjQ != null) {
                this.fjQ.bD(z);
            }
        }
        f.xN().setMode(0);
        return aM;
    }

    public final boolean vd() {
        if (this.fjI == null) {
            return false;
        }
        x.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean vd = this.fjI.vd();
        if (vd) {
            f.xN().xP();
            this.fjO = true;
            if (f.xN().xS()) {
                this.fjJ = false;
            }
            f.xN().h(this.fjJ, false);
        }
        return vd;
    }

    public final boolean k(String str, boolean z) {
        return a(str, z, false, -1);
    }

    public final boolean ve() {
        return this.fjK;
    }

    public final void stop() {
        aN(false);
    }

    public final void aN(boolean z) {
        if (this.fjI != null) {
            x.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", Boolean.valueOf(this.fjO), Boolean.valueOf(this.fjI.isPlaying()), Boolean.valueOf(z));
            this.fjI.vp();
            f.xN().b((com.tencent.mm.compatible.b.f.a) this);
            if (this.fjO && !z) {
                f.xN().xQ();
                this.fjO = false;
            }
            if (!(z || this.fjR == null)) {
                this.fjR.onStop();
            }
            f.xN().setMode(0);
        }
    }

    public final void aO(boolean z) {
        if (this.fjJ != z) {
            this.fjJ = z;
            if (this.fjI != null && this.fjI.isPlaying()) {
                this.fjI.aO(z);
            }
            f.xN().h(z, false);
        }
    }

    public final void a(b bVar) {
        this.fjV = bVar;
    }

    public final void a(c cVar) {
        this.fjQ = cVar;
    }

    public final void a(g.d dVar) {
        this.fjR = dVar;
    }

    private void setError() {
        d.b anonymousClass2 = new d.b() {
            public final void onError() {
                f.xN().b(a.this);
                if (a.this.fjO) {
                    f.xN().xQ();
                    a.this.fjO = false;
                }
                f.xN().setMode(0);
                if (a.this.fjV != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            a.this.fjV.onError();
                        }
                    });
                }
            }
        };
        if (this.fjI != null) {
            this.fjI.a(anonymousClass2);
        }
    }

    public final void a(com.tencent.mm.ad.g.a aVar) {
        this.fjW = aVar;
    }

    private void vf() {
        com.tencent.mm.modelvoice.d.a anonymousClass3 = new com.tencent.mm.modelvoice.d.a() {
            public final void vi() {
                e.post(new Runnable() {
                    public final void run() {
                        try {
                            if (com.tencent.mm.compatible.e.q.gHG.gEA == 1) {
                                Thread.sleep(300);
                            }
                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", a.this.fjW, Boolean.valueOf(a.this.fjP));
                            ah.y(new Runnable() {
                                public final void run() {
                                    f.xN().h(a.this.fjJ, false);
                                    if (a.this.fjP) {
                                        b bVar;
                                        Context h = a.this.context;
                                        int i = com.tencent.mm.plugin.e.a.a.knN;
                                        boolean g = a.this.fjJ;
                                        com.tencent.mm.sdk.platformtools.as.a anonymousClass1 = new com.tencent.mm.sdk.platformtools.as.a() {
                                            public final void vi() {
                                                x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                                if (!a.this.isPlaying()) {
                                                    f.xN().b(a.this);
                                                    x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.fjL));
                                                    if (!a.this.fjL) {
                                                        f.xN().xQ();
                                                    }
                                                    a.this.fjL = false;
                                                    a.this.fjO = false;
                                                    f.xN().setMode(0);
                                                    x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                                }
                                            }
                                        };
                                        if (g) {
                                            bVar = b.ON;
                                        } else {
                                            bVar = b.OFF;
                                        }
                                        as.a(h, i, bVar, false, anonymousClass1);
                                    } else {
                                        x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                        if (!a.this.isPlaying()) {
                                            f.xN().b(a.this);
                                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", Boolean.valueOf(a.this.fjL));
                                            if (!a.this.fjL) {
                                                f.xN().xQ();
                                            }
                                            a.this.fjL = false;
                                            a.this.fjO = false;
                                            f.xN().setMode(0);
                                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                        }
                                    }
                                    if (a.this.fjW != null) {
                                        x.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                                        a.this.fjW.vi();
                                        return;
                                    }
                                    x.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                                }
                            });
                        } catch (Throwable e) {
                            x.e("MicroMsg.SceneVoicePlayer", "exception:%s", bi.i(e));
                        }
                    }
                }, "SceneVoice_onCompletion");
            }
        };
        if (this.fjI != null) {
            this.fjI.a(anonymousClass3);
        }
    }

    public final double vg() {
        if (this.fjI == null) {
            return 0.0d;
        }
        return this.fjI.vg();
    }

    public final void aP(boolean z) {
        x.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.fjL = z;
    }

    public final boolean vh() {
        if (this.fjI != null && this.fjI.getStatus() == 2) {
            return true;
        }
        return false;
    }

    public final void er(int i) {
        x.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fjJ), Boolean.valueOf(this.fjN), Boolean.valueOf(this.fjO));
        switch (i) {
            case 1:
                aO(false);
                return;
            case 2:
            case 4:
                aO(this.fjN);
                if (this.fjO) {
                    f.xN().xQ();
                    this.fjO = false;
                    return;
                }
                return;
            case 6:
                aO(this.fjN);
                if (this.fjI != null && this.fjI.isPlaying()) {
                    f.xN().xP();
                    this.fjO = true;
                    return;
                }
                return;
            case 7:
                if (this.fjI != null && this.fjI.isPlaying()) {
                    f.xN().xP();
                    this.fjO = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
