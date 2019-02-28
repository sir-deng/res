package com.tencent.mm.plugin.facedetect.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectDecorView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements e, com.tencent.mm.plugin.facedetect.views.a {
    private String gBJ = null;
    boolean lSi = false;
    private int mkx = -1;
    h mpM = null;
    private b mpN = null;
    private boolean mpO = false;
    private boolean mpP = false;
    private View mpQ = null;
    private RelativeLayout mpR;
    FaceDetectView mpS = null;
    FaceScanRect mpT = null;
    private TextView mpU = null;
    private Button mpV = null;
    private FaceDetectProcessService mpW = null;
    private ServiceConnection mpX = null;
    private boolean mpY = false;
    private boolean mpZ = false;
    private com.tencent.mm.plugin.facedetect.c.a mpl = null;
    private a mpm = null;
    private b mpn = null;
    private boolean mpo = false;
    private c mqa = null;
    private WakeLock wakeLock = null;

    private interface a {
        void onFinish();
    }

    private class b {
        private boolean mqh;
        boolean mqi;
        private boolean mqj;
        private final boolean mqk;

        private b() {
            this.mqh = true;
            this.mqi = false;
            this.mqj = true;
            this.mqk = true;
        }

        /* synthetic */ b(FaceDetectUI faceDetectUI, byte b) {
            this();
        }

        public final synchronized void aHY() {
            this.mqi = true;
        }

        final synchronized void reset() {
            this.mqi = false;
        }

        final synchronized void aHZ() {
            x.i("MicroMsg.FaceDetectUI", "toString: %s", toString());
            if (this.mqh && this.mqi && this.mqj) {
                FaceDetectUI.this.mpR.setVisibility(0);
            }
        }

        public final String toString() {
            return "InitHandler{isCgiInitDone=" + this.mqh + ", isCameraInitDone=" + this.mqi + ", isLightInitDone=true, isLibraryInitDone=" + this.mqj + '}';
        }
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.aGS();
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        x.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.aIa().mqK) {
            com.tencent.mm.plugin.facedetect.e.a aIa = com.tencent.mm.plugin.facedetect.e.a.aIa();
            int rotation = faceDetectUI.mpS.msd.mrJ.getRotation();
            int aHt = faceDetectUI.mpS.msd.mrJ.aHt();
            int aIm = faceDetectUI.mpS.aIm();
            int i = faceDetectUI.mpS.msd.mrJ.aIk().x;
            int aIm2 = faceDetectUI.mpS.aIm();
            x.i("MicroMsg.FaceVideoRecorder", "hy: init record");
            x.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d", Integer.valueOf(rotation), Integer.valueOf(aHt), Integer.valueOf(aIm), Boolean.valueOf(false), Integer.valueOf(0));
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = aIa.mqM;
            videoTransPara.height = aIa.mqN;
            videoTransPara.fps = 30;
            videoTransPara.videoBitrate = 1200000;
            videoTransPara.hvO = 1;
            videoTransPara.hvN = 64000;
            videoTransPara.hvP = 2;
            videoTransPara.hvQ = 1;
            videoTransPara.audioSampleRate = 16000;
            videoTransPara.duration = 15;
            aIa.mqP.a(aIa.mlo, videoTransPara);
            aIa.mqC.F(new com.tencent.mm.plugin.facedetect.e.a.AnonymousClass1(rotation, aIm, aHt, false, 0, i, aIm2));
        }
        faceDetectUI.mpS.g(false, faceDetectUI.gBJ);
        ah.h(new Runnable() {
            public final void run() {
                int[] iArr = null;
                x.i("MicroMsg.FaceDetectUI", "alvinluo dismiss cover and start capture");
                FaceDetectUI.this.mpN.aHY();
                FaceDetectUI.this.mpN.aHZ();
                FaceDetectUI faceDetectUI = FaceDetectUI.this;
                if (h.mlZ == null) {
                    h.mlZ = new h();
                }
                faceDetectUI.mpM = h.mlZ;
                h hVar = faceDetectUI.mpM;
                hVar.lNI = 0;
                hVar.mlX = null;
                hVar.mlY = -1;
                hVar = faceDetectUI.mpM;
                g gVar = f.mlS.mlT.mnX;
                if (gVar.mlW == null) {
                    x.e("MicroMsg.FaceDetectNativeManager", "hy: get all motion not init");
                } else {
                    iArr = gVar.mlW.engineGetAllMotions();
                }
                hVar.mlX = iArr;
                hVar.mlY = hVar.mlX == null ? 0 : hVar.mlX.length;
                faceDetectUI.lSi = true;
                FaceDetectView faceDetectView = faceDetectUI.mpS;
                RectF rectF = new RectF((float) faceDetectUI.mpT.getLeft(), (float) faceDetectUI.mpT.getTop(), (float) faceDetectUI.mpT.getRight(), (float) faceDetectUI.mpT.getBottom());
                FaceDetectDecorView faceDetectDecorView = faceDetectView.mse;
                String str = "MicroMsg.FaceDetectDecorView";
                String str2 = "hy: trigger showCover cover: %s, old: %s";
                Object[] objArr = new Object[2];
                objArr[0] = rectF.toString();
                objArr[1] = faceDetectDecorView.msb == null ? "null" : faceDetectDecorView.msb.toString();
                x.i(str, str2, objArr);
                faceDetectDecorView.mrZ = true;
                if (faceDetectDecorView.msb == null || !faceDetectDecorView.msb.equals(rectF)) {
                    faceDetectDecorView.msb = rectF;
                    x.i("MicroMsg.FaceDetectDecorView", "alvinluo invalidate %s", faceDetectDecorView.msb.toString());
                    faceDetectDecorView.invalidate();
                }
                faceDetectUI.aHU();
            }
        }, 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.gBJ = getIntent().getStringExtra("k_user_name");
        this.mpo = getIntent().getBooleanExtra("k_need_signature", false);
        this.mkx = getIntent().getIntExtra("k_server_scene", -1);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aHr().a(faceDetectReporter);
        }
        int i = com.tencent.mm.plugin.facedetect.c.b.mlr;
        this.mpl = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.mkx, getIntent().getExtras());
        o.p(this);
        this.mpV = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.csO);
        this.mpV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.FaceDetectUI", "hy: user cancelled with left button");
                FaceDetectUI.this.aHN();
            }
        });
        this.mpQ = findViewById(com.tencent.mm.plugin.facedetect.a.e.miH);
        this.mpQ.setVisibility(8);
        this.mpR = (RelativeLayout) findViewById(com.tencent.mm.plugin.facedetect.a.e.miL);
        this.mpT = (FaceScanRect) findViewById(com.tencent.mm.plugin.facedetect.a.e.miK);
        this.mpS = (FaceDetectView) findViewById(com.tencent.mm.plugin.facedetect.a.e.miJ);
        this.mpU = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.miE);
        this.mpS.msh = this;
        FaceDetectView faceDetectView = this.mpS;
        ViewGroup viewGroup = this.mpR;
        ViewGroup viewGroup2 = this.mpT.mtn;
        faceDetectView.msf = viewGroup;
        faceDetectView.msg = viewGroup2;
        this.mpS.mpU = this.mpU;
        this.mpS.g(true, this.gBJ);
        this.mpT.mtm = new com.tencent.mm.plugin.facedetect.views.FaceScanRect.b() {
            public final void aHX() {
                FaceDetectView c = FaceDetectUI.this.mpS;
                RectF rectF = new RectF((float) FaceDetectUI.this.mpT.getLeft(), (float) FaceDetectUI.this.mpT.getTop(), (float) FaceDetectUI.this.mpT.getRight(), (float) FaceDetectUI.this.mpT.getBottom());
                FaceDetectDecorView faceDetectDecorView = c.mse;
                faceDetectDecorView.mrZ = true;
                faceDetectDecorView.msa = true;
                faceDetectDecorView.msb = rectF;
                faceDetectDecorView.invalidate();
            }
        };
        this.mpT.setVisibility(4);
        this.mpN = new b();
    }

    private void aEA() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", Boolean.valueOf(this.mpY));
        if (this.mpY) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            unbindService(this.mpX);
            this.mpY = false;
        }
    }

    public final void aGX() {
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.mpX = new ServiceConnection() {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                x.i("MicroMsg.FaceDetectUI", "alvinluo service connected %s", componentName);
                FaceDetectUI.this.mpY = true;
                FaceDetectUI.this.mpW = ((com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.a) iBinder).moa;
                f fVar = f.mlS;
                FaceDetectProcessService d = FaceDetectUI.this.mpW;
                x.i("MicroMsg.FaceDetectManager", "alvinluo bindService process name: %s, hashCode: %d", bi.r(ad.getContext(), Process.myPid()), Integer.valueOf(fVar.hashCode()));
                fVar.mlT = d;
                x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI service hashCode: %d", Integer.valueOf(FaceDetectUI.this.mpW.hashCode()));
                FaceDetectUI.e(FaceDetectUI.this);
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                x.i("MicroMsg.FaceDetectUI", "alvinluo service disconnected %s", componentName.toString());
                FaceDetectUI.this.mpY = false;
            }
        };
        x.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        bindService(intent, this.mpX, 1);
    }

    protected void onStop() {
        super.onStop();
        x.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        aEA();
        if (this.mpZ) {
            finish();
        } else {
            b(1, 90006, "cancel with on stop", null);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.facedetect.a.g.mjw;
    }

    public final void aGS() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.mpT.mtp = a.mts;
        FaceScanRect faceScanRect = this.mpT;
        if (faceScanRect.mtp == a.mtq) {
            x.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.mto.setVisibility(0);
            faceScanRect.msX.setBackgroundResource(d.miB);
            faceScanRect.mto.startAnimation(faceScanRect.mtl);
            for (View view : faceScanRect.mtg) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.white));
            }
            faceScanRect.mtp = a.mtq;
        }
        this.mpS.mse.mrY = false;
        this.mpT.setVisibility(0);
        x.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", Integer.valueOf(this.mpT.getTop()), Integer.valueOf(this.mpT.getRight()), Integer.valueOf(this.mpT.getLeft()), Integer.valueOf(this.mpT.getBottom()));
        this.mpO = true;
        this.lSi = false;
        this.mpN.reset();
        if (this.mpO) {
            this.mqa = new c() {
                public final void pV(int i) {
                    x.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", Integer.valueOf(i));
                    if (i == 0) {
                        FaceDetectUI.f(FaceDetectUI.this);
                    } else if (i == 1) {
                        FaceDetectUI.this.b(4, 90016, "preview error", FaceDetectUI.this.getString(com.tencent.mm.plugin.facedetect.a.h.mkm));
                    } else if (i == 2) {
                        FaceDetectUI.this.b(4, 90008, "camera permission not granted", FaceDetectUI.this.getString(com.tencent.mm.plugin.facedetect.a.h.ezZ));
                    }
                }
            };
            x.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = this.mqa;
            FaceDetectView faceDetectView = this.mpS;
            faceDetectView.msd.a(new com.tencent.mm.plugin.facedetect.views.FaceDetectView.AnonymousClass4(cVar));
        }
    }

    public final void aGU() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.mpP) {
            this.mqa = null;
            this.mpP = true;
            if (this.mpN.mqi) {
                aHV();
                this.mpS.msd.mrJ.aIi();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    long Wz = bi.Wz();
                    Runtime.getRuntime().gc();
                    x.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", Long.valueOf(bi.bB(Wz)));
                }
            }, "Face_active_gc");
        }
        aEA();
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.aIa().isStarted() && com.tencent.mm.plugin.facedetect.e.a.aIa().mqK) {
            com.tencent.mm.plugin.facedetect.e.a.aIa().aIc();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.aHr());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("err_type", i);
        bundle3.putInt("err_code", i2);
        bundle3.putString("err_msg", str);
        bundle3.putAll(bundle2);
        Intent intent = new Intent();
        intent.putExtras(bundle3);
        setResult(-1, intent);
        finish();
    }

    final void aHU() {
        if (this.lSi) {
            x.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.mpS;
            Rect rect = new Rect(this.mpT.getLeft(), this.mpT.getTop(), this.mpT.getRight(), this.mpT.getBottom());
            com.tencent.mm.plugin.facedetect.model.h.a aHq = h.aHq();
            if (aHq.type != 100) {
                if (faceDetectView.msi != null) {
                    faceDetectView.msi.aHD();
                }
                faceDetectView.kRY = false;
                faceDetectView.isPaused = false;
                faceDetectView.mso = bi.Wz();
                faceDetectView.msm = aHq.mmc;
                faceDetectView.msl = aHq.ipn;
                faceDetectView.mmd = aHq.mmd;
                faceDetectView.msj = true;
                faceDetectView.msn = aHq.mmg;
                faceDetectView.msi = com.tencent.mm.plugin.facedetect.d.b.c.a(aHq);
                if (faceDetectView.msi != null) {
                    if (faceDetectView.msf != null) {
                        faceDetectView.msf.removeAllViews();
                    }
                    if (faceDetectView.msg != null) {
                        faceDetectView.msg.removeAllViews();
                    }
                    faceDetectView.msi.a(faceDetectView.getContext(), faceDetectView.msf, faceDetectView.msg);
                }
                if (faceDetectView.msd != null) {
                    faceDetectView.msd.a(rect, aHq.mma);
                }
                faceDetectView.msk = false;
            }
        }
    }

    private void aHV() {
        this.lSi = false;
        this.mpS.eZ(false);
        x.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        this.mpO = false;
        this.mpS.msd.mrJ.stopPreview();
        x.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (z) {
            aHV();
        }
        if (z2) {
            x.i("MicroMsg.FaceDetectUI", "hy: need blur");
            final Bitmap aHW = aHW();
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    final Bitmap n = o.n(FaceDetectUI.this.gBJ, aHW);
                    ah.y(new Runnable() {
                        public final void run() {
                            FaceDetectUI.this.mpm.w(n);
                        }
                    });
                }
            }, "FaceDetectUI_BlurBgMap");
        }
        this.mpm.a(bVar);
    }

    private void b(int i, int i2, String str, String str2) {
        x.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(4), Integer.valueOf(i2), str);
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        aHV();
        b(4, i2, str, bundle);
    }

    public final void g(int i, int i2, String str, Bundle bundle) {
    }

    public final void K(int i, String str) {
        boolean z = true;
        x.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", Integer.valueOf(i));
        if (!FaceCharacteristicsResult.pK(i)) {
            h hVar = this.mpM;
            if (hVar.lNI >= hVar.mlY + -1) {
                x.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.mpS.eZ(true);
                final Bitmap aHW = aHW();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (aHW != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                final a anonymousClass9 = new a() {
                    public final void onFinish() {
                        x.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
                        FaceDetectUI.this.mpZ = true;
                        FaceDetectUI.this.b(0, 0, "collect data ok", null);
                    }
                };
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        o.n(FaceDetectUI.this.gBJ, aHW);
                        ah.y(new Runnable() {
                            public final void run() {
                                if (anonymousClass9 != null) {
                                    anonymousClass9.onFinish();
                                }
                            }
                        });
                    }
                }, "save_face_bitmap");
                return;
            }
            hVar = this.mpM;
            g gVar = f.mlS.mlT.mnX;
            if (gVar.mlW == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                x.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.mlW.engineNextMotion();
            }
            hVar.lNI++;
            int i2 = h.aHq().type;
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            if (h.aHq().mmf) {
                this.mpT.b(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        FaceDetectUI.this.aHU();
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                return;
            }
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", Integer.valueOf(i2));
            aHU();
        } else if (i == 3) {
            b(4, 90017, "face detect time out", str);
        } else if (i == 6 || i == 5) {
            b(4, 90023, "face track failed or not stable", str);
        } else if (i == 7) {
            b(4, 90009, "audio permission not granted", ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.eAd));
        } else {
            b(4, 90018, "system error", str);
        }
    }

    public final void pU(int i) {
        if (i == 1) {
            this.mpT.b(null);
        }
    }

    private void aHN() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        FaceDetectView faceDetectView = this.mpS;
        com.tencent.mm.plugin.facedetect.d.b.b aHE = faceDetectView.msi != null ? faceDetectView.msi.aHE() : new com.tencent.mm.plugin.facedetect.d.b.b(90004, "user cancelled in processing");
        b(1, aHE.errCode, aHE.foE, null);
    }

    protected void onDestroy() {
        x.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", Integer.valueOf(hashCode()));
        super.onDestroy();
    }

    public void finish() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.mpm != null && this.mpm.aHO()) {
            this.mpm.dismiss();
        }
        if (this.mpn != null) {
            this.mpn.dismiss();
        }
        x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        aGU();
        super.finish();
    }

    public void onBackPressed() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        aHN();
    }

    private Bitmap aHW() {
        return this.mpS.msd.getBitmap();
    }
}
