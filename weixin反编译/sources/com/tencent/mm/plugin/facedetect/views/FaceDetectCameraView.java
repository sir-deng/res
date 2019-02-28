package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static a mrI = null;
    private int height;
    private boolean kBN;
    private long mlQ;
    private final Object mrA;
    private boolean mrB;
    private boolean mrC;
    private final Object mrD;
    private final Object mrE;
    private Rect mrF;
    private c mrG;
    private boolean mrH;
    public b mrJ;
    private byte[] mrK;
    private boolean mrL;
    private long mrM;
    b mrr;
    private SurfaceTexture mrs;
    private ActivityManager mrt;
    private long mru;
    private long mrv;
    private int mrw;
    private boolean mrx;
    private boolean mry;
    private boolean mrz;
    private int width;

    private class c implements b {
        m mrR;
        PreviewCallback mrS;
        private com.tencent.mm.plugin.facedetect.model.d.b mrT;

        /* synthetic */ c(FaceDetectCameraView faceDetectCameraView, byte b) {
            this();
        }

        private c() {
            this.mrR = null;
            this.mrS = new PreviewCallback() {
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    x.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                    d aGY = d.aGY();
                    synchronized (d.mLock) {
                        x.v("MicroMsg.FaceCameraDataCallbackHolder", "hy: publish");
                        if (aGY.mlJ == null || aGY.mlJ.size() == 0) {
                            x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: nothing's listening to preview data");
                        } else if (bArr == null || bArr.length == 0) {
                            x.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: null camera data got");
                        } else {
                            for (a aVar : aGY.mlJ) {
                                int length = bArr.length;
                                aVar.data = (byte[]) aVar.mlK.aGZ().b(Integer.valueOf(length));
                                System.arraycopy(bArr, 0, aVar.data, 0, length);
                                aVar.mlK.aw(aVar.data);
                            }
                        }
                    }
                }
            };
            this.mrT = new com.tencent.mm.plugin.facedetect.model.d.b() {
                public final void aw(byte[] bArr) {
                    if (!FaceDetectCameraView.this.mrL) {
                        if (FaceDetectCameraView.this.mrK == null) {
                            FaceDetectCameraView.this.mrK = com.tencent.mm.plugin.facedetect.model.c.mlG.h(Integer.valueOf(bArr.length));
                        }
                        System.arraycopy(bArr, 0, FaceDetectCameraView.this.mrK, 0, bArr.length);
                        FaceDetectCameraView.this.mrK = bArr;
                    }
                    com.tencent.mm.plugin.facedetect.model.c.mlG.D(bArr);
                    f.aHi().post(new Runnable() {
                        public final void run() {
                            x.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
                            long Wz = bi.Wz();
                            long p = Wz - FaceDetectCameraView.this.mrv;
                            if (FaceDetectCameraView.this.mrv >= 0) {
                                x.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", Long.valueOf(p));
                            }
                            if (FaceDetectCameraView.this.mrv < 0 || p > FaceDetectCameraView.this.mru) {
                                FaceDetectCameraView.this.mrv = Wz;
                                FaceDetectCameraView.b(FaceDetectCameraView.this, FaceDetectCameraView.this.mrK);
                            }
                        }
                    });
                }

                public final com.tencent.mm.memory.a<byte[]> aGZ() {
                    return com.tencent.mm.plugin.facedetect.model.c.mlG;
                }
            };
            this.mrR = new m(FaceDetectCameraView.this.getContext());
            FaceDetectCameraView.this.mrv = -1;
            FaceDetectCameraView.this.mrL = false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.facedetect.views.c r5) {
            /*
            r4 = this;
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r0.mrG = r5;
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r1 = r0.mrE;
            monitor-enter(r1);
            r0 = r4.mrR;	 Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x001b;
        L_0x0010:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: camera is null. return";
            com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0031 }
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
        L_0x001a:
            return;
        L_0x001b:
            r0 = r4.mrR;	 Catch:{ all -> 0x0031 }
            r0 = r0.mmJ;	 Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0034;
        L_0x0021:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: already previewed. return";
            com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x0031 }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x0031 }
            com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.f(r0);	 Catch:{ all -> 0x0031 }
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
            goto L_0x001a;
        L_0x0031:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
            throw r0;
        L_0x0034:
            monitor-exit(r1);	 Catch:{ all -> 0x0031 }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r0.mrC = true;
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r0 = r0.mrx;
            if (r0 != 0) goto L_0x0075;
        L_0x0042:
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r0 = r0.isAvailable();
            if (r0 == 0) goto L_0x006b;
        L_0x004a:
            r0 = "MicroMsg.FaceDetectCameraView";
            r1 = "hy: already available. manually call available";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r1 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r1 = r1.getSurfaceTexture();
            r2 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r2 = r2.getWidth();
            r3 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r3 = r3.getHeight();
            r0.onSurfaceTextureAvailable(r1, r2, r3);
            goto L_0x001a;
        L_0x006b:
            r0 = "MicroMsg.FaceDetectCameraView";
            r1 = "hy: not initialized yet. do after init";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            goto L_0x001a;
        L_0x0075:
            r0 = com.tencent.mm.sdk.platformtools.bi.Wz();
            r2 = new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView$c$1;
            r2.<init>(r0);
            r0 = "FaceDetectCameraView_Camera";
            com.tencent.mm.sdk.f.e.post(r2, r0);
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.a(com.tencent.mm.plugin.facedetect.views.c):void");
        }

        public final void stopPreview() {
            synchronized (FaceDetectCameraView.this.mrE) {
                if (this.mrR != null && this.mrR.mmJ) {
                    m mVar = this.mrR;
                    if (mVar.gGm != null) {
                        mVar.gGm.stopPreview();
                        mVar.mmJ = false;
                        com.tencent.mm.plugin.facedetect.model.c.mlG.Ez();
                    }
                }
            }
        }

        public final void aIi() {
            if (!FaceDetectCameraView.this.mrz) {
                FaceDetectCameraView.this.mrz = true;
                e.post(new Runnable() {
                    public final void run() {
                        synchronized (FaceDetectCameraView.this.mrE) {
                            if (c.this.mrR == null) {
                                return;
                            }
                            x.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                            c.this.mrR.setPreviewCallback(null);
                            d aGY = d.aGY();
                            synchronized (d.mLock) {
                                if (aGY.mlJ != null) {
                                    aGY.mlJ.clear();
                                }
                            }
                            if (FaceDetectCameraView.this.mrs != null) {
                                FaceDetectCameraView.this.mrs.release();
                            }
                            c.this.mrR.release();
                            c.this.mrR = null;
                            x.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                            FaceDetectCameraView.this.mrz = false;
                        }
                    }
                }, "FaceDetectCameraView_Camera");
            }
        }

        public final int aHt() {
            int aHt;
            synchronized (FaceDetectCameraView.this.mrE) {
                aHt = this.mrR.aHt();
            }
            return aHt;
        }

        public final int aHu() {
            int aHu;
            synchronized (FaceDetectCameraView.this.mrE) {
                aHu = this.mrR.aHu();
            }
            return aHu;
        }

        public final int getRotation() {
            int i;
            synchronized (FaceDetectCameraView.this.mrE) {
                i = this.mrR.mmO;
            }
            return i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cT(long r8) {
            /*
            r7 = this;
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;
            r1 = r0.mrE;
            monitor-enter(r1);
            r0 = r7.mrR;	 Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0016;
        L_0x000b:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: camera is null. return";
            com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x005f }
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
        L_0x0015:
            return;
        L_0x0016:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: start capturing. tween: %d";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x005f }
            r4 = 0;
            r5 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x005f }
            r3[r4] = r5;	 Catch:{ all -> 0x005f }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x005f }
            r0.mru = r8;	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x005f }
            r0 = r0.kBN;	 Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0072;
        L_0x0036:
            r0 = r7.mrR;	 Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0062;
        L_0x003a:
            r0 = r7.mrR;	 Catch:{ all -> 0x005f }
            r0 = r0.mmJ;	 Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0062;
        L_0x0040:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: is previewing. directly start capture";
            com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x005f }
            r2 = 0;
            r0.mrB = r2;	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.model.d.aGY();	 Catch:{ all -> 0x005f }
            r2 = r7.mrT;	 Catch:{ all -> 0x005f }
            r0.a(r2);	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x005f }
            r0.kBN = true;	 Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
            goto L_0x0015;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: not previewed yet. wait";
            com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x005f }
            r0 = com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.this;	 Catch:{ all -> 0x005f }
            r2 = 1;
            r0.mrB = r2;	 Catch:{ all -> 0x005f }
            goto L_0x005d;
        L_0x0072:
            r0 = "MicroMsg.FaceDetectCameraView";
            r2 = "hy: already scanning";
            com.tencent.mm.sdk.platformtools.x.w(r0, r2);	 Catch:{ all -> 0x005f }
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.cT(long):void");
        }

        public final void aIj() {
            synchronized (FaceDetectCameraView.this.mrE) {
                if (this.mrR != null && this.mrR.mmJ) {
                    d.aGY().b(this.mrT);
                    if (!FaceDetectCameraView.this.mrL) {
                        FaceDetectCameraView.this.mrK = null;
                    }
                }
            }
        }

        public final Point aIk() {
            Point point;
            synchronized (FaceDetectCameraView.this.mrE) {
                point = this.mrR.mmS;
            }
            return point;
        }
    }

    private interface b {
        void a(c cVar);

        int aHt();

        int aHu();

        void aIi();

        void aIj();

        Point aIk();

        void cT(long j);

        int getRotation();

        void stopPreview();
    }

    private static class a extends ag {
        private WeakReference<FaceDetectCameraView> zH;

        /* synthetic */ a(FaceDetectCameraView faceDetectCameraView, byte b) {
            this(faceDetectCameraView);
        }

        private a(FaceDetectCameraView faceDetectCameraView) {
            super(Looper.getMainLooper());
            this.zH = new WeakReference(faceDetectCameraView);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.zH == null || this.zH.get() == null) {
                x.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
            } else if (message.what == 1) {
                FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
                if (FaceCharacteristicsResult.pL(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.zH.get()).mrr != null) {
                        ((FaceDetectCameraView) this.zH.get()).mrr.d(faceCharacteristicsResult);
                    }
                } else if (FaceCharacteristicsResult.pK(faceCharacteristicsResult.errCode)) {
                    if (((FaceDetectCameraView) this.zH.get()).mrr != null) {
                        ((FaceDetectCameraView) this.zH.get()).mrr.b(faceCharacteristicsResult.errCode, faceCharacteristicsResult.foE);
                    }
                } else if (((FaceDetectCameraView) this.zH.get()).mrr != null) {
                    ((FaceDetectCameraView) this.zH.get()).mrr.c(faceCharacteristicsResult);
                }
            }
        }
    }

    static /* synthetic */ void a(FaceDetectCameraView faceDetectCameraView, Point point) {
        DisplayMetrics displayMetrics = faceDetectCameraView.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        final int i2 = displayMetrics.heightPixels;
        x.v("MicroMsg.FaceDetectCameraView", "alvinluo screen size: (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
        final int i3 = displayMetrics.widthPixels;
        i = (int) (((1.0d * ((double) i3)) * ((double) point.x)) / ((double) point.y));
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo previewResolution: (%d, %d), adjust: (%d, %d), temp:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(i3), Integer.valueOf(i), Double.valueOf(((1.0d * ((double) i3)) * ((double) point.x)) / ((double) point.y)));
        ah.y(new Runnable() {
            public final void run() {
                int i = i2 - i;
                x.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", Integer.valueOf(i));
                if (i > 0) {
                    i /= 2;
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i);
                    MarginLayoutParams marginLayoutParams = new MarginLayoutParams(FaceDetectCameraView.this.getLayoutParams());
                    layoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.height + i);
                    x.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(i), Integer.valueOf(i + marginLayoutParams.height));
                    FaceDetectCameraView.this.setLayoutParams(layoutParams);
                    FaceDetectCameraView.this.invalidate();
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView r14, byte[] r15) {
        /*
        r0 = 4;
        r13 = 2;
        r6 = 0;
        r12 = 1;
        r8 = r14.mrD;
        monitor-enter(r8);
        r1 = r14.kBN;	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x0016;
    L_0x000b:
        r0 = "MicroMsg.FaceDetectCameraView";
        r1 = "hy: not requesting scanning. stop send msg";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ all -> 0x00a5 }
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
    L_0x0015:
        return;
    L_0x0016:
        if (r15 == 0) goto L_0x00a2;
    L_0x0018:
        r1 = r14.mrL;	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x00a2;
    L_0x001c:
        r1 = 1;
        r14.mrL = r1;	 Catch:{ all -> 0x00a5 }
        r1 = com.tencent.mm.plugin.facedetect.model.f.mlS;	 Catch:{ all -> 0x00a5 }
        r2 = r14.mrJ;	 Catch:{ all -> 0x00a5 }
        r2 = r2.aHt();	 Catch:{ all -> 0x00a5 }
        r3 = r14.mrJ;	 Catch:{ all -> 0x00a5 }
        r3 = r3.aHu();	 Catch:{ all -> 0x00a5 }
        r4 = r14.mrJ;	 Catch:{ all -> 0x00a5 }
        r4 = r4.getRotation();	 Catch:{ all -> 0x00a5 }
        r1 = r1.mlT;	 Catch:{ all -> 0x00a5 }
        r1 = r1.mnX;	 Catch:{ all -> 0x00a5 }
        r5 = "MicroMsg.FaceDetectNativeManager";
        r7 = "alvinluo process parameter: width: %d, height: %d, depth: %d, imageType: %d, rotateAngle: %d, imgData length: %d";
        r9 = 6;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x00a5 }
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 1;
        r11 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 2;
        r11 = 3;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 3;
        r11 = 1;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 4;
        r11 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        r10 = 5;
        r11 = r15.length;	 Catch:{ all -> 0x00a5 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00a5 }
        r9[r10] = r11;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.x.v(r5, r7, r9);	 Catch:{ all -> 0x00a5 }
        r7 = new com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;	 Catch:{ all -> 0x00a5 }
        r7.<init>();	 Catch:{ all -> 0x00a5 }
        r5 = r1.mlW;	 Catch:{ all -> 0x00a5 }
        if (r5 != 0) goto L_0x00a8;
    L_0x0079:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: process not init";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 4;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkn;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
    L_0x0091:
        r1 = 0;
        r14.mrL = r1;	 Catch:{ all -> 0x00a5 }
        r1 = mrI;	 Catch:{ all -> 0x00a5 }
        r1 = r1.obtainMessage();	 Catch:{ all -> 0x00a5 }
        r2 = 1;
        r1.what = r2;	 Catch:{ all -> 0x00a5 }
        r1.obj = r0;	 Catch:{ all -> 0x00a5 }
        r1.sendToTarget();	 Catch:{ all -> 0x00a5 }
    L_0x00a2:
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
        goto L_0x0015;
    L_0x00a5:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x00a5 }
        throw r0;
    L_0x00a8:
        switch(r4) {
            case 0: goto L_0x00c5;
            case 90: goto L_0x00c4;
            case 270: goto L_0x0122;
            default: goto L_0x00ab;
        };
    L_0x00ab:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: rotate type not support!";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkk;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
        goto L_0x0091;
    L_0x00c4:
        r6 = r0;
    L_0x00c5:
        r10 = com.tencent.mm.sdk.platformtools.bi.Wz();	 Catch:{ all -> 0x00a5 }
        r0 = r1.mlW;	 Catch:{ all -> 0x00a5 }
        r4 = 3;
        r5 = 1;
        r1 = r15;
        r0 = r0.engineFaceProcess(r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.sdk.platformtools.bi.bB(r10);	 Catch:{ all -> 0x00a5 }
        if (r0 == 0) goto L_0x00e1;
    L_0x00d8:
        r1 = com.tencent.mm.plugin.facedetect.model.FaceDetectReporter.aHr();	 Catch:{ all -> 0x00a5 }
        r4 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1.q(r4, r2);	 Catch:{ all -> 0x00a5 }
    L_0x00e1:
        r1 = "MicroMsg.FaceDetectNativeManager";
        r4 = "hy: process using: %d ms. result: %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00a5 }
        r6 = 0;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00a5 }
        r5[r6] = r2;	 Catch:{ all -> 0x00a5 }
        r2 = 1;
        r3 = r0.result;	 Catch:{ all -> 0x00a5 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00a5 }
        r5[r2] = r3;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ all -> 0x00a5 }
        r7.mlM = r0;	 Catch:{ all -> 0x00a5 }
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x0124;
    L_0x0103:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: invalid face status";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00a5 }
    L_0x010c:
        r0 = "MicroMsg.FaceDetectNativeManager";
        r1 = "hy: detect result is: %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a5 }
        r3 = 0;
        r4 = r7.toString();	 Catch:{ all -> 0x00a5 }
        r2[r3] = r4;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);	 Catch:{ all -> 0x00a5 }
        r0 = r7;
        goto L_0x0091;
    L_0x0122:
        r6 = 5;
        goto L_0x00c5;
    L_0x0124:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 <= 0) goto L_0x016c;
    L_0x012a:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != r12) goto L_0x013f;
    L_0x0130:
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkl;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x013f:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != r13) goto L_0x0154;
    L_0x0145:
        r0 = -1;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkl;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0154:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: unknown face num. regard as ok";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00a5 }
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkl;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x016c:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x0182;
    L_0x0172:
        r0 = 10;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkg;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0182:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -1;
        if (r0 == r1) goto L_0x0190;
    L_0x0189:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -2;
        if (r0 != r1) goto L_0x01a0;
    L_0x0190:
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkn;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01a0:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -11;
        if (r0 != r1) goto L_0x01b9;
    L_0x01a8:
        r0 = 13;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mko;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01b9:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -12;
        if (r0 != r1) goto L_0x01d2;
    L_0x01c1:
        r0 = 15;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkp;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01d2:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -13;
        if (r0 != r1) goto L_0x01eb;
    L_0x01da:
        r0 = 14;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkd;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x01eb:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -101; // 0xffffffffffffff9b float:NaN double:NaN;
        if (r0 != r1) goto L_0x0204;
    L_0x01f3:
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mke;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0204:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
        if (r0 != r1) goto L_0x021d;
    L_0x020c:
        r0 = 16;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkf;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x021d:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -103; // 0xffffffffffffff99 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0236;
    L_0x0225:
        r0 = 17;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mki;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0236:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -105; // 0xffffffffffffff97 float:NaN double:NaN;
        if (r0 != r1) goto L_0x024f;
    L_0x023e:
        r0 = 18;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkh;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x024f:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0268;
    L_0x0257:
        r0 = 11;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkj;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0268:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -107; // 0xffffffffffffff95 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0280;
    L_0x0270:
        r0 = 3;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkm;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0280:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        if (r0 != r1) goto L_0x0298;
    L_0x0288:
        r0 = 6;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkh;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x0298:
        r0 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r0 = r0.result;	 Catch:{ all -> 0x00a5 }
        r1 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        if (r0 != r1) goto L_0x02b0;
    L_0x02a0:
        r0 = 5;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkh;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
    L_0x02b0:
        r0 = "MicroMsg.FaceCharacteristicsResult";
        r1 = "hy: not defined system error! %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00a5 }
        r3 = 0;
        r4 = r7.mlM;	 Catch:{ all -> 0x00a5 }
        r4 = r4.result;	 Catch:{ all -> 0x00a5 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00a5 }
        r2[r3] = r4;	 Catch:{ all -> 0x00a5 }
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);	 Catch:{ all -> 0x00a5 }
        r0 = 1;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x00a5 }
        r2 = com.tencent.mm.plugin.facedetect.a.h.mkn;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getString(r2);	 Catch:{ all -> 0x00a5 }
        r7.ag(r0, r1);	 Catch:{ all -> 0x00a5 }
        goto L_0x010c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView, byte[]):void");
    }

    static /* synthetic */ void f(FaceDetectCameraView faceDetectCameraView) {
        if (faceDetectCameraView.mrB && faceDetectCameraView.mru > 0) {
            x.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            ah.y(new Runnable() {
                public final void run() {
                    FaceDetectCameraView.this.a(FaceDetectCameraView.this.mrF, FaceDetectCameraView.this.mru);
                    FaceDetectCameraView.this.mrB = false;
                }
            });
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrr = null;
        this.mrs = null;
        this.mru = FaceDetectView.mst;
        this.mrv = -1;
        this.mlQ = -1;
        this.mrw = 1;
        this.mrx = false;
        this.mry = false;
        this.mrz = false;
        this.mrA = new Object();
        this.mrB = false;
        this.mrC = false;
        this.kBN = false;
        this.mrD = new Object();
        this.mrE = new Object();
        this.mrF = null;
        this.width = p.CTRL_INDEX;
        this.height = 576;
        this.mrG = null;
        this.mrH = false;
        this.mrJ = null;
        this.mrK = null;
        this.mrL = false;
        this.mrM = -1;
        this.mrt = (ActivityManager) getContext().getSystemService("activity");
        x.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", Boolean.valueOf(this.mrH));
        this.mrJ = new c();
        mrI = new a();
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    public final void a(c cVar) {
        this.mrJ.a(cVar);
        this.mlQ = -1;
    }

    public final synchronized void a(Rect rect, long j) {
        aIe();
        this.mrF = rect;
        aIg();
        this.mrJ.cT(j);
    }

    private static void aIe() {
        x.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.aHh();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        cqy();
        this.mrx = true;
        this.mrs = surfaceTexture;
        if (this.mrC) {
            a(this.mrG);
        }
    }

    public final void aIf() {
        this.kBN = false;
        this.mrJ.aIj();
        aIe();
        int aHm = f.mlS.aHm();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.aHr().s(aHm, r2);
    }

    private synchronized void aIg() {
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.mlS.aHl();
        g gVar = f.mlS.mlT.mnX;
        if (gVar.mlW == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            x.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.mlW.engineGetCurrMotion();
        }
        int aHm = f.mlS.aHm();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", Long.valueOf(System.currentTimeMillis()));
        FaceDetectReporter.aHr().r(aHm, r2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.mrs = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.mrx = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    }

    final synchronized FaceResult aIh() {
        FaceResult aHo;
        f.aHh();
        int aHl = f.mlS.aHl();
        aHo = f.mlS.mlT.mnX.aHo();
        String str = "MicroMsg.FaceDetectCameraView";
        String str2 = "hy: motionResult: %d, finalResult: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aHl);
        objArr[1] = Integer.valueOf(aHo != null ? aHo.result : -10000);
        x.i(str, str2, objArr);
        return aHo;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        x.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
