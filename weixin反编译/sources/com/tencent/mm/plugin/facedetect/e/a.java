package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class a {
    private static volatile a mqB = null;
    private static final String mqQ = (o.aHw() + File.separator + "fdv_");
    public static final String mqR = (o.aHw() + File.separator + "video_temp_test.mp4");
    private static final String mqS = (o.aHw() + File.separator + "fdv_t_");
    private d iqP;
    private String mFilePath;
    private final Object mLock;
    public com.tencent.mm.remoteservice.d mlo;
    public ah mqC;
    private final int mqD;
    private final int mqE;
    private final int mqF;
    private int mqG;
    private int mqH;
    private boolean mqI;
    private int mqJ;
    public boolean mqK;
    private b mqL;
    public int mqM;
    public int mqN;
    private String mqO;
    public com.tencent.mm.plugin.mmsight.api.b mqP;
    private com.tencent.mm.plugin.mmsight.model.a.d.a mqT;
    private com.tencent.mm.plugin.facedetect.model.d.b mqU;

    public interface b {
        void As(String str);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.e.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int mqV;
        final /* synthetic */ int mqW;
        final /* synthetic */ int mqX;
        final /* synthetic */ boolean mqY = false;
        final /* synthetic */ int mqZ = 0;
        final /* synthetic */ int mra;
        final /* synthetic */ int mrb;

        public AnonymousClass1(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
            this.mqV = i;
            this.mqW = i2;
            this.mqX = i3;
            this.mra = i5;
            this.mrb = i6;
        }

        public final void run() {
            if (this.mqV == 90 || this.mqV == 270) {
                x.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
                a.this.mqM = this.mqW;
                a.this.mqN = this.mqX;
            } else {
                a.this.mqM = this.mqX;
                a.this.mqN = this.mqW;
            }
            synchronized (a.this.mLock) {
                a.this.mqH = this.mqV;
                a.this.mqI = this.mqY;
                a.this.mqJ = this.mqZ;
            }
            a.this.mFilePath = a.mqQ + bi.Wz() + ".mp4";
            a.this.mqO = a.mqS + bi.Wz() + ".thumb";
            a.d(a.this);
            ah.y(new Runnable() {
                public final void run() {
                    final long Wz = bi.Wz();
                    a.this.mlo.I(new Runnable() {
                        public final void run() {
                            synchronized (a.this.mLock) {
                                x.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(bi.bB(Wz)));
                                long Wz = bi.Wz();
                                a.this.iqP = a.this.mqP.Yg();
                                a.this.iqP.setFilePath(a.this.mFilePath);
                                a.this.iqP.FO(a.this.mqO);
                                a.this.iqP.bbk();
                                a.this.iqP.m(a.this.mqM, a.this.mqN, AnonymousClass1.this.mra, AnonymousClass1.this.mrb);
                                a.this.iqP.tf(a.this.mqH);
                                a.this.iqP.a(a.this.mqT);
                                a.this.mqG = a.mrl;
                                x.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(bi.bB(Wz)));
                            }
                        }
                    });
                }
            });
        }
    }

    public enum a {
        ;

        static {
            mrk = 1;
            mrl = 2;
            mrm = 3;
            mrn = 4;
            mro = 5;
            mrp = 6;
            mrq = new int[]{mrk, mrl, mrm, mrn, mro, mrp};
        }
    }

    static /* synthetic */ void d(a aVar) {
        com.tencent.mm.loader.stub.b.deleteFile(aVar.mFilePath);
        com.tencent.mm.loader.stub.b.deleteFile(aVar.mqO);
    }

    private a() {
        this.mLock = new Object();
        this.mqC = null;
        this.mqD = 960;
        this.mqE = 540;
        this.mqF = 15;
        this.mqG = a.mrk;
        this.mqH = 0;
        this.mqI = false;
        this.mqJ = 0;
        this.mqK = false;
        this.mqL = null;
        this.mqM = -1;
        this.mqN = -1;
        this.mFilePath = "";
        this.mqO = "";
        this.mlo = new com.tencent.mm.remoteservice.d(ad.getContext());
        this.mqP = com.tencent.mm.plugin.mmsight.api.b.owF.Yh();
        this.mqT = new com.tencent.mm.plugin.mmsight.model.a.d.a() {

            /* renamed from: com.tencent.mm.plugin.facedetect.e.a$5$1 */
            class AnonymousClass1 implements Runnable {
                final /* synthetic */ int kDF = 1;

                AnonymousClass1(int i) {
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r5 = this;
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;	 Catch:{ Exception -> 0x003c }
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ Exception -> 0x003c }
                    r0 = r0.iqP;	 Catch:{ Exception -> 0x003c }
                    if (r0 == 0) goto L_0x0015;
                L_0x000a:
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;	 Catch:{ Exception -> 0x003c }
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ Exception -> 0x003c }
                    r0 = r0.iqP;	 Catch:{ Exception -> 0x003c }
                    r0.reset();	 Catch:{ Exception -> 0x003c }
                L_0x0015:
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;
                    com.tencent.mm.plugin.facedetect.e.a.d(r0);
                L_0x001c:
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;
                    r1 = r0.mLock;
                    monitor-enter(r1);
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;	 Catch:{ all -> 0x0061 }
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0061 }
                    r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrl;	 Catch:{ all -> 0x0061 }
                    r0.mqG = r2;	 Catch:{ all -> 0x0061 }
                    monitor-exit(r1);	 Catch:{ all -> 0x0061 }
                    r0 = com.tencent.mm.plugin.facedetect.model.FaceContextData.aHa();
                    r0 = r0.mlO;
                    r2 = 2;
                    r3 = r5.kDF;
                    com.tencent.mm.plugin.facedetect.model.FaceDetectReporter.e(r0, r2, r3);
                    return;
                L_0x003c:
                    r0 = move-exception;
                    r1 = "MicroMsg.FaceVideoRecorder";
                    r2 = "hy: onError, reset mediaRecorder error: %s";
                    r3 = 1;
                    r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0058 }
                    r4 = 0;
                    r0 = r0.getMessage();	 Catch:{ all -> 0x0058 }
                    r3[r4] = r0;	 Catch:{ all -> 0x0058 }
                    com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ all -> 0x0058 }
                    r0 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;
                    r0 = com.tencent.mm.plugin.facedetect.e.a.this;
                    com.tencent.mm.plugin.facedetect.e.a.d(r0);
                    goto L_0x001c;
                L_0x0058:
                    r0 = move-exception;
                    r1 = com.tencent.mm.plugin.facedetect.e.a.AnonymousClass5.this;
                    r1 = com.tencent.mm.plugin.facedetect.e.a.this;
                    com.tencent.mm.plugin.facedetect.e.a.d(r1);
                    throw r0;
                L_0x0061:
                    r0 = move-exception;
                    monitor-exit(r1);	 Catch:{ all -> 0x0061 }
                    throw r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.e.a.5.1.run():void");
                }
            }

            public final void Yw() {
                x.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", Integer.valueOf(1));
                a.this.mqC.F(new AnonymousClass1(1));
            }
        };
        this.mqU = new com.tencent.mm.plugin.facedetect.model.d.b() {
            public final void aw(final byte[] bArr) {
                x.v("MicroMsg.FaceVideoRecorder", "hy: on video data come");
                a.this.mqC.F(new Runnable() {
                    public final void run() {
                        SightVideoJNI.mirrorCameraData(bArr, a.this.mqM, a.this.mqN, false);
                        if (a.this.iqP.bbe() != null) {
                            a.this.iqP.bbe().R(bArr);
                        }
                    }
                });
            }

            public final com.tencent.mm.memory.a<byte[]> aGZ() {
                return j.oAr;
            }
        };
        this.mqC = new ah("face_video_handler");
    }

    public static a aIa() {
        if (mqB != null) {
            return mqB;
        }
        a aVar;
        synchronized (a.class) {
            if (mqB == null) {
                mqB = new a();
            }
            aVar = mqB;
        }
        return aVar;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mqG == a.mrm;
        }
        return z;
    }

    public final com.tencent.mm.audio.b.c.a aIb() {
        if (this.iqP != null) {
            return this.iqP.bbl();
        }
        x.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        return null;
    }

    public final void aIc() {
        this.mqC.F(new Runnable() {
            public final void run() {
                synchronized (a.this.mLock) {
                    if (a.this.mqG == a.mrk) {
                        x.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                        a.d(a.this);
                        return;
                    }
                    x.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
                    a.this.iqP.cancel();
                    a.d(a.this);
                    com.tencent.mm.plugin.facedetect.model.d.aGY().b(a.this.mqU);
                    a.this.mqG = a.mrp;
                    a.this.mlo.release();
                }
            }
        });
    }

    public final void a(final b bVar) {
        this.mqC.F(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r3 = this;
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;
                r1 = r0.mLock;
                monitor-enter(r1);
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r2 = r3;	 Catch:{ all -> 0x0070 }
                r0.mqL = r2;	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqG;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrk;	 Catch:{ all -> 0x0070 }
                if (r0 != r2) goto L_0x003a;
            L_0x0018:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: not initialized. should not happen";
                com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                com.tencent.mm.plugin.facedetect.e.a.d(r0);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                if (r0 == 0) goto L_0x0038;
            L_0x002e:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                r2 = 0;
                r0.As(r2);	 Catch:{ all -> 0x0070 }
            L_0x0038:
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
            L_0x0039:
                return;
            L_0x003a:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqG;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrp;	 Catch:{ all -> 0x0070 }
                if (r0 == r2) goto L_0x004e;
            L_0x0044:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqG;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrl;	 Catch:{ all -> 0x0070 }
                if (r0 != r2) goto L_0x0073;
            L_0x004e:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: cancelled or not started capturing.";
                com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                com.tencent.mm.plugin.facedetect.e.a.d(r0);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                if (r0 == 0) goto L_0x006e;
            L_0x0064:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                r2 = 0;
                r0.As(r2);	 Catch:{ all -> 0x0070 }
            L_0x006e:
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
                goto L_0x0039;
            L_0x0070:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
                throw r0;
            L_0x0073:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqG;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mro;	 Catch:{ all -> 0x0070 }
                if (r0 != r2) goto L_0x00a3;
            L_0x007d:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: already stopped";
                com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                if (r0 == 0) goto L_0x00a1;
            L_0x008e:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqL;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r2 = r2.iqP;	 Catch:{ all -> 0x0070 }
                r2 = r2.getFilePath();	 Catch:{ all -> 0x0070 }
                r0.As(r2);	 Catch:{ all -> 0x0070 }
            L_0x00a1:
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
                goto L_0x0039;
            L_0x00a3:
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.mqG;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrn;	 Catch:{ all -> 0x0070 }
                if (r0 != r2) goto L_0x00b8;
            L_0x00ad:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: stopping. wait";
                com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
                goto L_0x0039;
            L_0x00b8:
                r0 = "MicroMsg.FaceVideoRecorder";
                r2 = "hy: stop record and release";
                com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.model.d.aGY();	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r2 = r2.mqU;	 Catch:{ all -> 0x0070 }
                r0.b(r2);	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r2 = com.tencent.mm.plugin.facedetect.e.a.a.mrn;	 Catch:{ all -> 0x0070 }
                r0.mqG = r2;	 Catch:{ all -> 0x0070 }
                r0 = com.tencent.mm.plugin.facedetect.e.a.this;	 Catch:{ all -> 0x0070 }
                r0 = r0.iqP;	 Catch:{ all -> 0x0070 }
                r2 = new com.tencent.mm.plugin.facedetect.e.a$4$1;	 Catch:{ all -> 0x0070 }
                r2.<init>();	 Catch:{ all -> 0x0070 }
                r0.C(r2);	 Catch:{ all -> 0x0070 }
                monitor-exit(r1);	 Catch:{ all -> 0x0070 }
                goto L_0x0039;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.e.a.4.run():void");
            }
        });
    }

    public final int aId() {
        int i;
        synchronized (this.mLock) {
            i = this.mqG;
        }
        return i;
    }
}
