package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.f.a.ls;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, c.a {
    private b hZB;
    private d iqP;
    private ObservableTextureView irS;
    private int jlI = -1;
    private boolean jlJ = false;
    private long jlK = -1;
    private com.tencent.mm.remoteservice.d mlo = new com.tencent.mm.remoteservice.d(ad.getContext());
    private SightParams oAt;
    private VideoPlayerTextureView oDe;
    private VideoSeekBarEditorView oDf;
    private f.a oDk = new f.a() {
        public final void onError(int i, int i2) {
            x.e("MicroMsg.SightCaptureUI", "%d on error what %d extra %d", Integer.valueOf(SightCaptureUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        }

        public final void hY() {
            if (SightCaptureUI.this.oDe != null) {
                SightCaptureUI.this.oDe.start();
                SightCaptureUI.this.oDe;
            }
            ah.K(SightCaptureUI.this.oIF);
            SightCaptureUI.this.oDe.vEY = new e() {
                public final void bcn() {
                    ah.h(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.SightCaptureUI", "onTextureUpdate");
                            if (SightCaptureUI.this.oDe != null) {
                                SightCaptureUI.this.oDe.setAlpha(1.0f);
                                SightCaptureUI.this.updateState(4);
                                SightCaptureUI.F(SightCaptureUI.this);
                            }
                        }
                    }, 50);
                    SightCaptureUI.this.oHW.setVisibility(0);
                }
            };
        }

        public final void vi() {
            SightCaptureUI.this.oDe.c(0.0d, true);
        }

        public final int ck(int i, int i2) {
            return 0;
        }

        public final void cl(int i, int i2) {
        }
    };
    private int oHM = 1;
    private boolean oHN = true;
    private com.tencent.mm.plugin.mmsight.model.e oHO;
    private ViewGroup oHP;
    private MMSightRecordButton oHQ;
    private View oHR;
    private View oHS;
    private ViewGroup oHT;
    private ViewGroup oHU;
    private ImageView oHV;
    private ImageView oHW;
    private SurfaceTexture oHX;
    CameraFrontSightView oHY;
    private ViewGroup oHZ;
    private Runnable oIA = new Runnable() {
        public final void run() {
            if (SightCaptureUI.this.jlI == 7 && SightCaptureUI.this.oHQ != null) {
                x.i("MicroMsg.SightCaptureUI", "showRecoderProgressBar");
                MMSightRecordButton i = SightCaptureUI.this.oHQ;
                x.i("MicroMsg.MMSightRecordButton", "showProgressBar");
                i.oGE.setVisibility(0);
            }
        }
    };
    private String oIB;
    private String oIC;
    private boolean oID;
    private Bundle oIE;
    private Runnable oIF = new Runnable() {
        public final void run() {
            if (SightCaptureUI.this.jlI != 4) {
                x.e("MicroMsg.SightCaptureUI", "checkPreviewStatusRunnable, not previewing now!!!");
                SightCaptureUI.this.updateState(9);
            }
        }
    };
    private ImageView oIa;
    private MMSightCameraGLSurfaceView oIb;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a oIc;
    private TextView oId;
    private MMSightCaptureTouchView oIe;
    private View oIf;
    private a oIg;
    private boolean oIh = true;
    private aqp oIi = new aqp();
    private byte[] oIj;
    private int oIk;
    private int oIl;
    private int oIm;
    private int oIn;
    private byte[] oIo;
    private int oIp;
    private c oIq;
    private boolean oIr = false;
    private boolean oIs = false;
    private boolean oIt = false;
    private int oIu = 0;
    private int oIv = 0;
    private Thread oIw = null;
    private long oIx = -1;
    private boolean oIy = false;
    private boolean oIz = false;
    private View ock;
    private int owo = 2;
    private VideoTransPara owp;

    static /* synthetic */ void C(SightCaptureUI sightCaptureUI) {
        if (bi.by(sightCaptureUI.oIj) || sightCaptureUI.oIl <= 0 || sightCaptureUI.oIk <= 0) {
            x.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.oIj, 17, sightCaptureUI.oIk, sightCaptureUI.oIl, null);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.oIk, sightCaptureUI.oIl), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.oIt || sightCaptureUI.oIn == 180) {
                    int i = sightCaptureUI.oIm;
                    if (sightCaptureUI.oIn == 180) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.oIm - sightCaptureUI.oIn) == 0) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 90, CompressFormat.JPEG, sightCaptureUI.iqP.bbb(), false);
                    x.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", Long.valueOf(FileOp.mi(r1)));
                } catch (Exception e) {
                    x.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", e.getMessage());
                }
                j.oAr.D(sightCaptureUI.oIj);
                sightCaptureUI.oIl = 0;
                sightCaptureUI.oIk = 0;
                sightCaptureUI.oIn = 0;
                sightCaptureUI.oIm = 0;
                sightCaptureUI.oIj = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", e2.getMessage());
            }
        }
        sightCaptureUI.jlJ = false;
    }

    static /* synthetic */ void F(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.oHR.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                SightCaptureUI.this.oHR.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                SightCaptureUI.this.oHR.setEnabled(false);
            }
        }).start();
        sightCaptureUI.ock.animate().translationX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                SightCaptureUI.this.ock.setEnabled(true);
            }

            public final void onAnimationStart(Animator animator) {
                SightCaptureUI.this.ock.setEnabled(false);
            }
        }).start();
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.hZB != null) {
            sightCaptureUI.hZB.requestFocus();
        }
        sightCaptureUI.oDe.setVisibility(0);
        sightCaptureUI.oDe.setAlpha(0.0f);
        sightCaptureUI.oDe.setVideoPath(sightCaptureUI.iqP.getFilePath());
        sightCaptureUI.oDe.cdw();
        sightCaptureUI.oDe.qAJ = sightCaptureUI.oDk;
    }

    static /* synthetic */ void N(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.jlI == 1 || sightCaptureUI.jlI == 2) {
            String baH = sightCaptureUI.oHO.baH();
            if (!bi.oN(baH)) {
                StringBuilder append = new StringBuilder().append(baH + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.yz(), m.yx()})).append("\n");
                Object[] objArr = new Object[1];
                k.bbq();
                objArr[0] = k.bbu();
                baH = append.append(String.format("RecorderType %s", objArr)).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.dd(sightCaptureUI))});
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.SightCaptureUI", "DEBUG showCameraInfoImpl: %s", baH);
                        k.bbq();
                        if (k.bbt()) {
                            TextView textView = (TextView) SightCaptureUI.this.findViewById(com.tencent.mm.plugin.u.a.d.oKx);
                            textView.setVisibility(0);
                            textView.setText(baH);
                        }
                    }
                });
            }
        }
    }

    static /* synthetic */ void U(SightCaptureUI sightCaptureUI) {
        try {
            Bitmap mD = com.tencent.mm.plugin.mmsight.d.mD(sightCaptureUI.iqP.getFilePath());
            if (mD != null && sightCaptureUI.owp != null && Math.min(mD.getWidth(), mD.getHeight()) > sightCaptureUI.owp.hwa) {
                int width = mD.getWidth();
                int height = mD.getHeight();
                int i = sightCaptureUI.owp.hwa > 0 ? sightCaptureUI.owp.hwa : sightCaptureUI.owp.width;
                if (width < height) {
                    width = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i)));
                } else {
                    int i2 = i;
                    i = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i)));
                    width = i2;
                }
                com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(mD, i, width, true), 60, CompressFormat.JPEG, sightCaptureUI.iqP.aOC(), true);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "saveNewThumbAfterEdit error: %s", e.getMessage());
        }
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.cnM();
        sightCaptureUI.Ek(8);
        if (sightCaptureUI.oAt == null) {
            x.e("MicroMsg.SightCaptureUI", "sightParams error!");
            return;
        }
        sightCaptureUI.oIu = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        x.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", Integer.valueOf(sightCaptureUI.oIu));
        sightCaptureUI.hZB = new b(sightCaptureUI);
        sightCaptureUI.oHN = sightCaptureUI.oAt.owv;
        sightCaptureUI.owo = sightCaptureUI.oAt.owo;
        sightCaptureUI.oIh = sightCaptureUI.owo == 2;
        k.bbq().oAt = sightCaptureUI.oAt;
        sightCaptureUI.oHM = sightCaptureUI.oAt.mode;
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", Integer.valueOf(sightCaptureUI.oHM), Boolean.valueOf(sightCaptureUI.oHN), Integer.valueOf(sightCaptureUI.owo), Integer.valueOf(sightCaptureUI.oAt.scene));
        sightCaptureUI.owp = sightCaptureUI.oAt.owp;
        if (sightCaptureUI.owp == null) {
            x.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", sightCaptureUI.owp);
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gF(true);
        } else {
            sightCaptureUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.gF(false);
        }
        sightCaptureUI.oIq = new c(sightCaptureUI);
        sightCaptureUI.oIq.oxs = sightCaptureUI;
        sightCaptureUI.oIq.enable();
        sightCaptureUI.oHP = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.cIB);
        sightCaptureUI.oHT = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKa);
        sightCaptureUI.oHU = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKb);
        sightCaptureUI.oHY = (CameraFrontSightView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKh);
        sightCaptureUI.irS = (ObservableTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKm);
        sightCaptureUI.oHQ = (MMSightRecordButton) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKn);
        sightCaptureUI.oHR = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKq);
        sightCaptureUI.ock = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKr);
        sightCaptureUI.oHS = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oJZ);
        sightCaptureUI.oHZ = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.cVv);
        sightCaptureUI.oId = (TextView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oJX);
        if (sightCaptureUI.oHM == 2) {
            sightCaptureUI.oId.setText(com.tencent.mm.plugin.u.a.f.oKL);
        } else if (sightCaptureUI.oHM == 1) {
            sightCaptureUI.oId.setText(com.tencent.mm.plugin.u.a.f.oKM);
        } else if (sightCaptureUI.oHM == 0) {
            sightCaptureUI.oId.setText(com.tencent.mm.plugin.u.a.f.oKK);
        }
        sightCaptureUI.oDe = (VideoPlayerTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKl);
        sightCaptureUI.oHV = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKt);
        sightCaptureUI.oHW = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKe);
        sightCaptureUI.oHW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SightCaptureUI.this.jlI == 3) {
                    SightCaptureUI.f(SightCaptureUI.this);
                } else if (SightCaptureUI.this.jlI == 4) {
                    SightCaptureUI.g(SightCaptureUI.this);
                }
            }
        });
        sightCaptureUI.oIa = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKw);
        sightCaptureUI.oIb = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKd);
        sightCaptureUI.oIe = (MMSightCaptureTouchView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKj);
        sightCaptureUI.oIf = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKp);
        sightCaptureUI.oIc = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.oIb);
        if (sightCaptureUI.oHN) {
            sightCaptureUI.oId.setVisibility(0);
        } else {
            sightCaptureUI.oId.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(sightCaptureUI.mController.xRr, 120);
        CameraFrontSightView cameraFrontSightView = sightCaptureUI.oHY;
        cameraFrontSightView.oGp = cameraFrontSightView.getLayoutParams();
        if (cameraFrontSightView.oGp != null) {
            cameraFrontSightView.oGp.width = fromDPToPix;
            cameraFrontSightView.oGp.height = fromDPToPix;
        }
        cameraFrontSightView.mWidth = fromDPToPix;
        cameraFrontSightView.mHeight = fromDPToPix;
        cameraFrontSightView.oGn = cameraFrontSightView.mWidth / 2;
        cameraFrontSightView.oGo = cameraFrontSightView.mHeight / 2;
        cameraFrontSightView.kaG = com.tencent.mm.bu.a.fromDPToPix(cameraFrontSightView.getContext(), 1);
        cameraFrontSightView.fC.setColor(-12206054);
        cameraFrontSightView.fC.setStrokeWidth((float) cameraFrontSightView.kaG);
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            int fy = ae.fy(sightCaptureUI);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oHQ.getLayoutParams();
            marginLayoutParams.bottomMargin += fy;
            sightCaptureUI.oHQ.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oHS.getLayoutParams();
            marginLayoutParams.bottomMargin += fy;
            sightCaptureUI.oHS.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oHR.getLayoutParams();
            marginLayoutParams.bottomMargin += fy;
            sightCaptureUI.oHR.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oHW.getLayoutParams();
            marginLayoutParams.bottomMargin += fy;
            sightCaptureUI.oHW.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.ock.getLayoutParams();
            marginLayoutParams.bottomMargin = fy + marginLayoutParams.bottomMargin;
            sightCaptureUI.ock.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.oHM == 1 || sightCaptureUI.oHM == 0) {
            sightCaptureUI.oHQ.oGO = new MMSightRecordButton.b() {
                public final void bcb() {
                    x.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", Integer.valueOf(SightCaptureUI.this.jlI));
                    if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.oHO != null && SightCaptureUI.this.oHO.oxy) {
                        int[] iArr = new int[2];
                        SightCaptureUI.this.oHQ.getLocationOnScreen(iArr);
                        com.tencent.mm.plugin.mmsight.model.e h = SightCaptureUI.this.oHO;
                        int i = iArr[1];
                        if (h.oxu <= 0) {
                            int i2 = ae.fA(ad.getContext()).y;
                            x.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i), r2);
                            if (i2 / 2 < i) {
                                try {
                                    if (h.gGm != null) {
                                        h.oxu = ((int) (((double) h.gGm.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                                        x.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(h.oxu), Integer.valueOf(r2));
                                    }
                                } catch (Exception e) {
                                    x.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", e.getMessage());
                                }
                            }
                        }
                        if (SightCaptureUI.this.oHM == 0) {
                            SightCaptureUI.this.oIv = SightCaptureUI.this.bch();
                        }
                    }
                }

                public final void bcc() {
                    if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.oHO != null && SightCaptureUI.this.oHO.oxy) {
                        SightCaptureUI.l(SightCaptureUI.this);
                        x.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", bi.chl().toString());
                        SightCaptureUI.m(SightCaptureUI.this);
                    }
                }

                public final void bcd() {
                    String str = "MicroMsg.TestCaptureUiEvent";
                    String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
                    Object[] objArr = new Object[3];
                    objArr[0] = bi.chl().toString();
                    objArr[1] = SightCaptureUI.this.iqP;
                    objArr[2] = Long.valueOf(SightCaptureUI.this.iqP != null ? SightCaptureUI.this.iqP.bbd() : 0);
                    x.i(str, str2, objArr);
                    if (SightCaptureUI.this.oHM == 0) {
                        if (SightCaptureUI.this.iqP == null || SightCaptureUI.this.iqP.bbd() > 1000 || SightCaptureUI.this.iqP.bbf() != d.c.Start) {
                            SightCaptureUI.this.uF();
                            return;
                        }
                        x.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
                        SightCaptureUI.this.iqP.cancel();
                        if (SightCaptureUI.this.oHM == 0) {
                            SightCaptureUI.o(SightCaptureUI.this);
                        }
                    } else if (SightCaptureUI.this.oHM != 1) {
                    } else {
                        if ((SightCaptureUI.this.iqP == null || SightCaptureUI.this.iqP.bbd() > 1000) && SightCaptureUI.this.iqP != null) {
                            SightCaptureUI.this.uF();
                            return;
                        }
                        x.i("MicroMsg.SightCaptureUI", "video record too short");
                        Toast.makeText(SightCaptureUI.this, com.tencent.mm.plugin.u.a.f.oKN, 1).show();
                        SightCaptureUI.this.bcg();
                    }
                }
            };
            sightCaptureUI.oHQ.oGQ = new MMSightRecordButton.a() {
                public final void bca() {
                    x.i("MicroMsg.TestCaptureUiEvent", "onErrorUp: %s", bi.chl().toString());
                    if (SightCaptureUI.this.iqP != null) {
                        SightCaptureUI.this.iqP.cancel();
                        if (SightCaptureUI.this.oHM == 0) {
                            SightCaptureUI.o(SightCaptureUI.this);
                        }
                    }
                }
            };
            sightCaptureUI.oHQ.oGP = new MMSightRecordButton.c() {
                public final void tq(int i) {
                    if (SightCaptureUI.this.oHO != null) {
                        SightCaptureUI.this.oHO.b(true, true, i);
                    }
                }

                public final void tr(int i) {
                    if (SightCaptureUI.this.oHO != null) {
                        SightCaptureUI.this.oHO.b(false, true, i);
                    }
                }
            };
        }
        if (sightCaptureUI.oHM == 0 || sightCaptureUI.oHM == 2) {
            sightCaptureUI.oHQ.oGN = new MMSightRecordButton.d() {
                public final void bce() {
                    x.v("MicroMsg.TestCaptureUiEvent", "onSimpleTap %s", bi.chl().toString());
                    if (SightCaptureUI.this.iqP != null) {
                        x.i("MicroMsg.SightCaptureUI", "onSimpleTap, mediaRecorder.status: %s", SightCaptureUI.this.iqP.bbf());
                        SightCaptureUI.this.iqP.cancel();
                    }
                    com.tencent.mm.plugin.mmsight.d.FM("TIME_RECODER_2_PLAY");
                    SightCaptureUI.o(SightCaptureUI.this);
                }
            };
        }
        if (sightCaptureUI.oIu > 1) {
            sightCaptureUI.oHV.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (SightCaptureUI.this.oHO != null) {
                        SightCaptureUI.r(SightCaptureUI.this);
                    }
                }
            });
        } else {
            sightCaptureUI.oHV.setVisibility(8);
        }
        sightCaptureUI.ock.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SightCaptureUI.this.jlI == 4) {
                    SightCaptureUI.s(SightCaptureUI.this);
                } else if (SightCaptureUI.this.jlI == 3) {
                    SightCaptureUI.t(SightCaptureUI.this);
                    SightCaptureUI.this.gP(false);
                }
            }
        });
        sightCaptureUI.oHR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SightCaptureUI.this.hZB != null) {
                    SightCaptureUI.this.hZB.zk();
                }
                SightCaptureUI.this.bcg();
                SightCaptureUI.this.gP(true);
            }
        });
        sightCaptureUI.oHS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SightCaptureUI.this.bcm()) {
                    SightCaptureUI.this.finish();
                    SightCaptureUI.this.overridePendingTransition(-1, com.tencent.mm.plugin.u.a.a.oJQ);
                }
            }
        });
        sightCaptureUI.oIe.oGq = new MMSightCaptureTouchView.a() {
            public final void D(float f, float f2) {
                if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.jlI != 3 && SightCaptureUI.this.jlI != 4 && SightCaptureUI.this.oIb != null) {
                    com.tencent.mm.plugin.mmsight.model.e h = SightCaptureUI.this.oHO;
                    int width = SightCaptureUI.this.oIb.getWidth();
                    int height = SightCaptureUI.this.oIb.getHeight();
                    if (!com.tencent.mm.compatible.util.d.fO(14)) {
                        h.oye.removeMessages(4354);
                        h.oye.oyo = f;
                        h.oye.nOR = f2;
                        h.oye.oyp = width;
                        h.oye.oyq = height;
                        h.oye.sendMessageDelayed(h.oye.obtainMessage(4354, h.gGm), 400);
                    }
                    SightCaptureUI sightCaptureUI = SightCaptureUI.this;
                    if (sightCaptureUI.oHY != null) {
                        LayoutParams layoutParams = (LayoutParams) sightCaptureUI.oHY.getLayoutParams();
                        layoutParams.leftMargin = ((int) f) - (sightCaptureUI.oHY.mWidth / 2);
                        layoutParams.topMargin = ((int) f2) - (sightCaptureUI.oHY.mHeight / 2);
                        sightCaptureUI.oHY.setLayoutParams(layoutParams);
                        CameraFrontSightView cameraFrontSightView = sightCaptureUI.oHY;
                        cameraFrontSightView.setVisibility(0);
                        cameraFrontSightView.oGi = true;
                        cameraFrontSightView.oGj = false;
                        cameraFrontSightView.oGk = false;
                        cameraFrontSightView.oGl = false;
                        cameraFrontSightView.oGm = System.currentTimeMillis();
                        cameraFrontSightView.invalidate();
                    }
                }
            }

            public final void bbX() {
                if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.oIu > 1) {
                    SightCaptureUI.this.oHO.oye.removeMessages(4354);
                    SightCaptureUI.r(SightCaptureUI.this);
                }
            }

            public final void Yy() {
                if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.oHO != null) {
                    SightCaptureUI.this.oHO.b(true, false, 1);
                }
            }

            public final void Yz() {
                if (SightCaptureUI.this.jlI != 0 && SightCaptureUI.this.oHO != null) {
                    SightCaptureUI.this.oHO.b(false, false, 1);
                }
            }
        };
        sightCaptureUI.updateState(0);
        sightCaptureUI.bcg();
    }

    static /* synthetic */ void f(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.iqP == null) {
            x.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.oAt.scene == 1) {
            intent.putExtra("from_scene", JsApiDestroyInstanceAudio.CTRL_INDEX);
        } else if (sightCaptureUI.oAt.scene == 2) {
            intent.putExtra("from_scene", 289);
        }
        intent.putExtra("before_photo_edit", bi.oN(sightCaptureUI.oIB) ? sightCaptureUI.iqP.bbb() : sightCaptureUI.oIB);
        intent.putExtra("after_photo_edit", sightCaptureUI.oIC);
        com.tencent.mm.bl.d.b(sightCaptureUI, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4369);
    }

    static /* synthetic */ void g(SightCaptureUI sightCaptureUI) {
        if (MMActivity.ft(sightCaptureUI)) {
            sightCaptureUI.Ek(0);
        }
        sightCaptureUI.oDf = (VideoSeekBarEditorView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oKz);
        if (ae.fz(sightCaptureUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oDf.getLayoutParams();
            marginLayoutParams.bottomMargin = ae.fy(sightCaptureUI);
            sightCaptureUI.oDf.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.oIg = new a();
        sightCaptureUI.oIg.a(sightCaptureUI, sightCaptureUI.oAt.scene, sightCaptureUI.iqP.getFilePath(), sightCaptureUI.oDf, sightCaptureUI.oDe, sightCaptureUI.oHT, sightCaptureUI.owp, false);
        sightCaptureUI.oIg.oHr = new a.a() {
            public final void bbK() {
                x.i("MicroMsg.SightCaptureUI", "on video edit finish");
                if (SightCaptureUI.this.oIg != null) {
                    SightCaptureUI.this.oIg.gN(false);
                    SightCaptureUI.this.oIg.release();
                    SightCaptureUI.this.oIg = null;
                }
                SightCaptureUI.this.oHR.setVisibility(0);
                SightCaptureUI.this.ock.setVisibility(0);
                SightCaptureUI.this.oHW.setVisibility(0);
                SightCaptureUI.this.oDe.stop();
                SightCaptureUI.this.oDe.setVideoPath(SightCaptureUI.this.iqP.getFilePath());
                SightCaptureUI.this.oDe;
                SightCaptureUI.this.oDe.cdw();
                SightCaptureUI.this.oDe.qAJ = SightCaptureUI.this.oDk;
                SightCaptureUI.this.Ek(8);
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        SightCaptureUI.U(SightCaptureUI.this);
                    }
                }, "SightCaptureUI_edit_finish_save_new_thumb");
                SightCaptureUI.this.oIy = true;
            }

            public final void bbL() {
                x.i("MicroMsg.SightCaptureUI", "on video edit exit");
                if (SightCaptureUI.this.oIg != null) {
                    SightCaptureUI.this.oIg.gN(true);
                    SightCaptureUI.this.oIg.release();
                    SightCaptureUI.this.oIg = null;
                }
                SightCaptureUI.this.Ek(8);
                SightCaptureUI.this.oHR.setVisibility(0);
                SightCaptureUI.this.ock.setVisibility(0);
                SightCaptureUI.this.oHW.setVisibility(0);
            }

            public final void onError() {
                x.i("MicroMsg.SightCaptureUI", "on video edit error");
                if (SightCaptureUI.this.oIg != null) {
                    SightCaptureUI.this.oIg.release();
                    SightCaptureUI.this.oIg = null;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        Toast.makeText(SightCaptureUI.this, com.tencent.mm.plugin.u.a.f.oEa, 1).show();
                        SightCaptureUI.this.Ek(8);
                        SightCaptureUI.this.oHR.setVisibility(0);
                        SightCaptureUI.this.ock.setVisibility(0);
                        SightCaptureUI.this.oHW.setVisibility(0);
                    }
                });
            }
        };
        sightCaptureUI.oHR.setVisibility(8);
        sightCaptureUI.ock.setVisibility(8);
        sightCaptureUI.oHW.setVisibility(8);
    }

    static /* synthetic */ void l(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oId != null && sightCaptureUI.oHN) {
            sightCaptureUI.oId.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    SightCaptureUI.this.oId.setVisibility(8);
                }
            }).start();
        }
    }

    static /* synthetic */ void m(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.iqP != null) {
            x.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", sightCaptureUI.iqP.bbf(), bi.chl().toString());
            sightCaptureUI.updateState(6);
            if (sightCaptureUI.iqP.bbf() == d.c.Stop) {
                sightCaptureUI.oIv = sightCaptureUI.bch();
                if (sightCaptureUI.oIv < 0) {
                    sightCaptureUI.bci();
                    return;
                }
            } else if (sightCaptureUI.oIv < 0) {
                sightCaptureUI.bci();
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.oHO != null) {
                com.tencent.mm.plugin.mmsight.model.e eVar = sightCaptureUI.oHO;
                x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
                if (eVar.gGm != null && eVar.oxy) {
                    try {
                        Parameters parameters = eVar.gGm.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                            parameters.setFocusMode("continuous-video");
                        }
                        eVar.gGm.setParameters(parameters);
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", e.getMessage());
                    }
                }
            }
            MMSightRecordButton mMSightRecordButton = sightCaptureUI.oHQ;
            int i = (sightCaptureUI.owp.duration * 1000) - 500;
            x.k("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), new MMSightCircularProgressBar.a() {
                public final void bbY() {
                    SightCaptureUI.this.uF();
                }
            });
            MMSightCircularProgressBar mMSightCircularProgressBar = mMSightRecordButton.oGF;
            x.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(0), Boolean.valueOf(mMSightCircularProgressBar.fBn));
            if (!mMSightCircularProgressBar.fBn) {
                mMSightCircularProgressBar.oGs = 0;
            }
            mMSightCircularProgressBar = mMSightRecordButton.oGF;
            x.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Integer.valueOf(100));
            mMSightCircularProgressBar.oGt = 100;
            mMSightCircularProgressBar = mMSightRecordButton.oGF;
            x.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i));
            mMSightCircularProgressBar.duration = i;
            mMSightRecordButton.oGF.setVisibility(0);
            mMSightRecordButton.oGF.oGw = new com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass1(r2);
            MMSightCircularProgressBar mMSightCircularProgressBar2 = mMSightRecordButton.oGF;
            x.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", Integer.valueOf(mMSightCircularProgressBar2.oGs), Integer.valueOf(mMSightCircularProgressBar2.oGt), Integer.valueOf(mMSightCircularProgressBar2.duration));
            mMSightCircularProgressBar2.oGr = 0.0f;
            mMSightCircularProgressBar2.oGv = new b((float) mMSightCircularProgressBar2.oGs, (float) mMSightCircularProgressBar2.oGt, mMSightCircularProgressBar2.duration);
            b bVar = mMSightCircularProgressBar2.oGv;
            x.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new b.a() {
                public final void an(float f) {
                    MMSightCircularProgressBar.this.oGr = f;
                    MMSightCircularProgressBar.this.invalidate();
                }

                public final void onAnimationEnd() {
                    x.i("MicroMsg.MMSightCircularProgressBar", "onAnimationEnd");
                    ah.y(new Runnable() {
                        public final void run() {
                            if (MMSightCircularProgressBar.this.oGw != null) {
                                MMSightCircularProgressBar.this.oGw.bbY();
                            }
                        }
                    });
                }
            });
            bVar.oHJ = r2;
            b bVar2 = mMSightCircularProgressBar2.oGv;
            x.i("MicroMsg.ProgressHandlerAnimator", "Start");
            bVar2.fBn = true;
            bVar2.oHH = bi.Wz();
            bVar2.hJi.K(20, 20);
        }
    }

    static /* synthetic */ void o(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oHO != null && sightCaptureUI.oHO.oxy && sightCaptureUI.oIq != null && !sightCaptureUI.jlJ) {
            if (sightCaptureUI.jlK < 0 || bi.bB(sightCaptureUI.jlK) <= 300) {
                sightCaptureUI.jlJ = true;
                if (sightCaptureUI.oId != null && sightCaptureUI.oHN) {
                    sightCaptureUI.oId.setVisibility(8);
                }
                sightCaptureUI.updateState(7);
                sightCaptureUI.oHQ.gM(false);
                sightCaptureUI.oIt = sightCaptureUI.oIq.baC();
                sightCaptureUI.oIo = null;
                sightCaptureUI.oIp = -1;
                sightCaptureUI.oHO.a(new com.tencent.mm.plugin.mmsight.model.e.b() {
                    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
                        int i5 = 180;
                        if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
                            x.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
                            SightCaptureUI.this.jlJ = false;
                            return;
                        }
                        x.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        SightCaptureUI.z(SightCaptureUI.this);
                        SightCaptureUI.this.bcl();
                        SightCaptureUI.this.oIk = i;
                        SightCaptureUI.this.oIl = i2;
                        SightCaptureUI.this.oIm = i3;
                        SightCaptureUI.this.oIn = i4;
                        if (SightCaptureUI.this.oIj != null) {
                            j.oAr.D(SightCaptureUI.this.oIj);
                            SightCaptureUI.this.oIj = null;
                        }
                        SightCaptureUI.this.oIj = j.oAr.h(Integer.valueOf(bArr.length));
                        System.arraycopy(bArr, 0, SightCaptureUI.this.oIj, 0, bArr.length);
                        SightCaptureUI.this.oIw = com.tencent.mm.sdk.f.e.b(new Runnable() {
                            public final void run() {
                                SightCaptureUI.C(SightCaptureUI.this);
                            }
                        }, "SightCaptureUI_saveCaptureBitmap");
                        SightCaptureUI.this.oIw.start();
                        com.tencent.mm.plugin.mmsight.model.k.d(true, com.tencent.mm.plugin.mmsight.d.FN("TIME_RECODER_2_PLAY"));
                        if (SightCaptureUI.this.oIt) {
                            if (Math.abs(i3 - i4) != 0) {
                                i5 = 0;
                            }
                            bArr = com.tencent.mm.plugin.mmsight.d.b(bArr, i, i2, i5 % 360);
                            SightCaptureUI.this.oIc.a(bArr, true, 0);
                        } else {
                            if (i4 == 180) {
                                i5 = i3 + i4;
                            } else {
                                i5 = i3;
                            }
                            if (i5 > 360) {
                                i5 -= 360;
                            }
                            SightCaptureUI.this.oIc.a(bArr, false, i5);
                        }
                        SightCaptureUI.this.oIo = bArr;
                        SightCaptureUI.this.oIp = i5;
                        SightCaptureUI.this.updateState(3);
                        SightCaptureUI.this.oHR.post(new Runnable() {
                            public final void run() {
                                SightCaptureUI.F(SightCaptureUI.this);
                            }
                        });
                        if (SightCaptureUI.this.oAt.scene == 1 || SightCaptureUI.this.oAt.scene == 2) {
                            g.pWK.h(13819, Integer.valueOf(1), Integer.valueOf(SightCaptureUI.this.oAt.scene));
                        }
                    }
                }, sightCaptureUI.oIt, sightCaptureUI.oIq.getOrientation());
                sightCaptureUI.jlK = bi.Wz();
            }
        }
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oIx <= 0 || bi.bB(sightCaptureUI.oIx) > 500) {
            x.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", bi.chl().toString(), Integer.valueOf(sightCaptureUI.jlI));
            sightCaptureUI.bcj();
            sightCaptureUI.oIr = true;
            if (sightCaptureUI.jlI == 2) {
                if (sightCaptureUI.iqP == null || !sightCaptureUI.iqP.bbj()) {
                    x.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    String str = "MicroMsg.SightCaptureUI";
                    String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(sightCaptureUI.jlI);
                    objArr[1] = sightCaptureUI.iqP != null ? sightCaptureUI.iqP.bbf() : "";
                    x.i(str, str2, objArr);
                    if (sightCaptureUI.jlI == 2 && sightCaptureUI.iqP != null && sightCaptureUI.iqP.bbf() == d.c.Start) {
                        sightCaptureUI.iqP.pause();
                        sightCaptureUI.oHO.a((Context) sightCaptureUI, sightCaptureUI.oHX, false);
                        sightCaptureUI.oIh = sightCaptureUI.oHO.oyf;
                        if (sightCaptureUI.oIc != null) {
                            sightCaptureUI.oIc.R(sightCaptureUI.oHO.aHt(), sightCaptureUI.oHO.aHu(), sightCaptureUI.oHO.getOrientation());
                        }
                        if (sightCaptureUI.iqP.bbf() != d.c.Pause) {
                            x.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", sightCaptureUI.iqP.bbf());
                        } else {
                            int aHt = sightCaptureUI.oHO.aHt();
                            int aHu = sightCaptureUI.oHO.aHu();
                            int orientation = sightCaptureUI.oHO.getOrientation();
                            Point bbh = sightCaptureUI.iqP.bbh();
                            x.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", Integer.valueOf(aHt), Integer.valueOf(aHu), bbh, Integer.valueOf(orientation), Integer.valueOf(sightCaptureUI.iqP.bbi()));
                            if (!(sightCaptureUI.iqP.bbi() == orientation && bbh.x == aHt && bbh.y == aHu)) {
                                x.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
                            }
                            sightCaptureUI.iqP.m(sightCaptureUI.oHO.aHt(), sightCaptureUI.oHO.aHu(), sightCaptureUI.oHO.oxH.x, sightCaptureUI.oHO.oxH.y);
                            sightCaptureUI.iqP.P(orientation, sightCaptureUI.oHO.oxH.x, sightCaptureUI.oHO.oxH.y);
                        }
                    }
                    sightCaptureUI.oIs = true;
                }
            } else if (sightCaptureUI.jlI == 1) {
                sightCaptureUI.updateState(6);
                if (sightCaptureUI.gO(true)) {
                    sightCaptureUI.updateState(1);
                }
            }
            sightCaptureUI.bck();
            sightCaptureUI.oIx = bi.Wz();
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oAt.scene == 1 || sightCaptureUI.oAt.scene == 2) {
            int i = sightCaptureUI.oIr ? sightCaptureUI.oIs ? 2 : 1 : 0;
            g.pWK.h(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.oAt.scene));
        }
        if (sightCaptureUI.oAt != null && sightCaptureUI.oIy) {
            com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(sightCaptureUI.oAt.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.iqP.getFilePath();
        String JU = com.tencent.mm.plugin.sight.base.d.JU(filePath);
        if (sightCaptureUI.oAt.oww) {
            sightCaptureUI.as(filePath, false);
        }
        if (com.tencent.mm.plugin.mmsight.model.a.baz() != null) {
            sightCaptureUI.oIi.wEd = com.tencent.mm.plugin.mmsight.model.a.baz().baA();
        }
        int bbg = sightCaptureUI.iqP.bbg();
        if (sightCaptureUI.oIy) {
            com.tencent.mm.plugin.sight.base.a JX = com.tencent.mm.plugin.sight.base.d.JX(sightCaptureUI.iqP.getFilePath());
            if (JX != null) {
                bbg = Math.round(((float) JX.mDe) / 1000.0f);
            }
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oHO.oyf, filePath, JU, sightCaptureUI.iqP.getFileName(), sightCaptureUI.iqP.Nx(), bbg, sightCaptureUI.oIi));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void t(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oIw != null && sightCaptureUI.oIw.isAlive()) {
            try {
                sightCaptureUI.oIw.join();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", e.getMessage());
            }
        }
        if (sightCaptureUI.oAt.scene == 1 || sightCaptureUI.oAt.scene == 2) {
            int i = 0;
            if (sightCaptureUI.oIr) {
                i = 1;
            }
            g.pWK.h(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.oAt.scene));
        }
        if (sightCaptureUI.oAt.scene == 1) {
            g.pWK.h(13858, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        } else if (sightCaptureUI.oAt.scene == 2) {
            g.pWK.h(13858, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        }
        Intent intent = new Intent();
        Object obj = (bi.oN(sightCaptureUI.oIC) || sightCaptureUI.iqP == null || !sightCaptureUI.oIC.equals(sightCaptureUI.iqP.bbb())) ? null : 1;
        if (obj == null && sightCaptureUI.oAt.oww) {
            x.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.as(sightCaptureUI.iqP.bbb(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oHO.oyf, sightCaptureUI.iqP.bbb()));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.oIE;
        if (bundle == null) {
            x.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.oID) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            g gVar = g.pWK;
            objArr = new Object[10];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            gVar.h(13857, objArr);
        } else {
            x.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
    }

    static /* synthetic */ void z(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.oHW.getVisibility() == 8) {
            sightCaptureUI.oIe.setVisibility(8);
        } else {
            sightCaptureUI.oIe.setVisibility(0);
        }
        Point dc = com.tencent.mm.plugin.mmsight.d.dc(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oJR);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oJT);
        sightCaptureUI.oHQ.getX();
        sightCaptureUI.oHR.setTranslationX(((((float) dc.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.ock.setTranslationX(((((float) (-dc.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.oHR.setEnabled(false);
        sightCaptureUI.ock.setEnabled(false);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.oAt = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.oAt == null) {
            x.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mlo));
        final long Wz = bi.Wz();
        this.mlo.I(new Runnable() {
            public final void run() {
                x.i("MicroMsg.SightCaptureUI", "connect cost %sms", Long.valueOf(bi.bB(Wz)));
                com.tencent.mm.plugin.mmsight.model.j.b(SightCaptureUI.this.oAt.owp);
                SightCaptureUI.b(SightCaptureUI.this);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", ts(this.jlI));
        if (this.jlI == 2) {
            uF();
        } else if (this.jlI == 1) {
            bcl();
        } else if (this.jlI == 4 && this.oDe != null) {
            this.oDe.pause();
        }
    }

    protected void onResume() {
        boolean z = false;
        super.onResume();
        Ek(8);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = ts(this.jlI);
        if (this.irS != null && this.irS.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.jlI == 2 || this.jlI == 1) {
            bcg();
        } else if (this.jlI == 4) {
            if (this.irS != null) {
                if (this.irS.isAvailable()) {
                    this.oIc.bcp();
                } else {
                    this.irS.a(new com.tencent.mm.plugin.video.b() {
                        public final void d(SurfaceTexture surfaceTexture) {
                            SightCaptureUI.this.oIc.bcp();
                            SightCaptureUI.this.irS.a(null);
                        }
                    });
                }
            }
            if (this.oDe != null) {
                this.oDe.start();
            }
        } else if (this.jlI == 3) {
            if (this.irS != null) {
                this.irS.a(null);
            }
            this.oIc.a(this.oIo, this.oIt, this.oIp);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void uF() {
        x.k("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", Integer.valueOf(this.jlI));
        if (this.jlI == 2) {
            updateState(7);
            this.oHQ.gM(false);
            final int aHt = this.oHO.aHt();
            final int aHu = this.oHO.aHu();
            this.iqP.C(new Runnable() {
                public final void run() {
                    x.k("MicroMsg.SightCaptureUI", "call stop callback now, currentStatus: %s", SightCaptureUI.ts(SightCaptureUI.this.jlI));
                    SightCaptureUI.this.oHO.a(com.tencent.mm.plugin.mmsight.model.e.a.Stoping);
                    SightCaptureUI.this.bcl();
                    final long FN = com.tencent.mm.plugin.mmsight.d.FN("TIME_RECODER_2_PLAY");
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            String filePath = SightCaptureUI.this.iqP.getFilePath();
                            aqp J = SightCaptureUI.this.oIi;
                            try {
                                if (!bi.oN(filePath) && FileOp.bO(filePath)) {
                                    int i;
                                    int i2;
                                    int i3;
                                    int i4;
                                    int i5;
                                    g.pWK.a(440, 87, 1, false);
                                    JSONObject jSONObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(filePath));
                                    int i6 = (int) jSONObject.getDouble("videoFPS");
                                    int optInt = jSONObject.optInt("videoBitrate");
                                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s", Integer.valueOf(i6), Integer.valueOf(optInt));
                                    com.tencent.mm.plugin.mmsight.model.a baz = com.tencent.mm.plugin.mmsight.model.a.baz();
                                    baz.oxa = com.tencent.mm.plugin.mmsight.model.j.oyD.gHU;
                                    baz.videoBitrate = com.tencent.mm.plugin.mmsight.model.j.oyD.videoBitrate;
                                    baz.gHV = com.tencent.mm.plugin.mmsight.model.j.oyD.oyN ? 1 : 0;
                                    baz.oxb = com.tencent.mm.plugin.mmsight.model.j.oyD.oyO ? 1 : 0;
                                    baz.oxc = com.tencent.mm.plugin.mmsight.model.j.oyD.oxc;
                                    baz.oxd = i6;
                                    baz.fileSize = FileOp.mi(filePath);
                                    com.tencent.mm.plugin.sight.base.a JX = com.tencent.mm.plugin.sight.base.d.JX(filePath);
                                    if (JX != null) {
                                        baz.oxg = JX.width;
                                        baz.oxh = JX.height;
                                        baz.oxi = JX.videoBitrate;
                                        baz.oxe = JX.mDe;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.j.oyD.gHU == 1) {
                                        g.pWK.a(440, 89, 1, false);
                                        g.pWK.a(440, 49, (long) i6, false);
                                        i = 93;
                                        i2 = 73;
                                        i3 = 69;
                                    } else {
                                        g.pWK.a(440, 88, 1, false);
                                        g.pWK.a(440, 48, (long) i6, false);
                                        i = 90;
                                        i2 = 54;
                                        i3 = 50;
                                    }
                                    if (com.tencent.mm.plugin.mmsight.model.j.oyD.oxc == 720) {
                                        i2 += 6;
                                        i4 = i + 1;
                                        i5 = i3 + 6;
                                    } else if (com.tencent.mm.plugin.mmsight.model.j.oyD.baT()) {
                                        i2 += 12;
                                        i4 = i + 2;
                                        i5 = i3 + 12;
                                    } else {
                                        i4 = i;
                                        i5 = i3;
                                    }
                                    g.pWK.a(440, (long) i2, (long) i6, false);
                                    g.pWK.a(440, (long) i4, 1, false);
                                    g.pWK.a(440, 47, (long) i6, false);
                                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", filePath, Integer.valueOf(i5));
                                    if (i6 >= 0 && i6 <= 10) {
                                        g.pWK.a(440, (long) i5, 1, false);
                                    } else if (i6 > 10 && i6 <= 15) {
                                        g.pWK.a(440, (long) (i5 + 1), 1, false);
                                    } else if (i6 > 15 && i6 <= 20) {
                                        g.pWK.a(440, (long) (i5 + 2), 1, false);
                                    } else if (i6 > 20 && i6 <= 30) {
                                        g.pWK.a(440, (long) (i5 + 3), 1, false);
                                    }
                                    if (optInt > 0) {
                                        if (com.tencent.mm.plugin.mmsight.model.j.oyD.gHU == 2) {
                                            g.pWK.a(440, 175, (long) optInt, false);
                                            g.pWK.a(440, 176, 1, false);
                                            if (J != null) {
                                                if (J.wEc == 1) {
                                                    g.pWK.a(440, 184, (long) optInt, false);
                                                    g.pWK.a(440, 185, 1, false);
                                                } else if (J.wEc == 2) {
                                                    g.pWK.a(440, 194, (long) optInt, false);
                                                    g.pWK.a(440, 195, 1, false);
                                                }
                                            }
                                        } else {
                                            g.pWK.a(440, 179, (long) optInt, false);
                                            g.pWK.a(440, 180, 1, false);
                                            if (J != null) {
                                                if (J.wEc == 1) {
                                                    g.pWK.a(440, 189, (long) optInt, false);
                                                    g.pWK.a(440, 190, 1, false);
                                                } else if (J.wEc == 2) {
                                                    g.pWK.a(440, 199, (long) optInt, false);
                                                    g.pWK.a(440, 200, 1, false);
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.MMSightRecorderIDKeyStat", "markAfterCaptureFinish error: %s", e.getMessage());
                            }
                            com.tencent.mm.plugin.mmsight.model.k.d(false, FN);
                        }
                    }, "BigSightFFMpegRecorder_markAfterCaptureFinish_idkeystat");
                    x.v("MicroMsg.TestCaptureUiEvent", "doStopRecorderAndStartPreviewDone %s", bi.chl().toString());
                    x.i("MicroMsg.SightCaptureUI", "stop finish, filepath: %s %s time_takevideo %s", SightCaptureUI.this.iqP.getFilePath(), Long.valueOf(FileOp.mi(SightCaptureUI.this.iqP.getFilePath())), Long.valueOf(FN));
                    SightCaptureUI.z(SightCaptureUI.this);
                    i.A(new Runnable() {
                        public final void run() {
                            String FL = com.tencent.mm.plugin.mmsight.d.FL(SightCaptureUI.this.iqP.getFilePath());
                            if (!bi.oN(FL)) {
                                FL = ((FL + "\n" + String.format("FPS: %s", new Object[]{Float.valueOf(SightCaptureUI.this.iqP.bbc())})) + "\n" + String.format("TIME_RECODER_2_PLAY: %s", new Object[]{Long.valueOf(com.tencent.mm.plugin.mmsight.d.FN("TIME_RECODER_2_PLAY"))})) + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.yz(), m.yx()});
                                ah.y(new Runnable() {
                                    public final void run() {
                                        x.i("MicroMsg.SightCaptureUI", "DEBUG showDebugInfo %s", FL);
                                        k.bbq();
                                        if (k.bbt()) {
                                            TextView textView = (TextView) SightCaptureUI.this.findViewById(com.tencent.mm.plugin.u.a.d.oKx);
                                            textView.setVisibility(0);
                                            textView.setText(FL);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    SightCaptureUI.L(SightCaptureUI.this);
                    ah.h(SightCaptureUI.this.oIF, 1000);
                    if (SightCaptureUI.this.oAt.scene == 1 || SightCaptureUI.this.oAt.scene == 2) {
                        g.pWK.h(13819, Integer.valueOf(2), Integer.valueOf(SightCaptureUI.this.oAt.scene));
                    }
                }
            });
        }
    }

    private void bcg() {
        updateState(0);
        this.oIv = 0;
        this.jlJ = false;
        this.oIz = false;
        if (this.oDe != null) {
            this.oDe.stop();
            this.oDe.qAJ = null;
            try {
                ViewGroup.LayoutParams layoutParams = this.oDe.getLayoutParams();
                this.oHT.removeView(this.oDe);
                this.oHT.addView(this.oDe, 0, layoutParams);
            } catch (Exception e) {
                x.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", e.getMessage());
            }
        }
        if (this.oIg != null) {
            this.oIg.release();
            this.oIg = null;
        }
        this.oIb.setVisibility(0);
        this.oIa.setImageBitmap(null);
        bcl();
        this.oHO = new com.tencent.mm.plugin.mmsight.model.e(this.owp, this.oAt.scene);
        this.oHO.a(this.oIc.oJe);
        if (this.oHO.i(this, this.oIh)) {
            if (this.irS.isAvailable()) {
                this.oHX = this.irS.getSurfaceTexture();
                x.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", this.oHX);
                if (gO(false)) {
                    updateState(1);
                } else {
                    updateState(8);
                }
            } else {
                this.irS.a(new com.tencent.mm.plugin.video.b() {
                    public final void d(SurfaceTexture surfaceTexture) {
                        x.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", surfaceTexture);
                        SightCaptureUI.this.oHX = surfaceTexture;
                        if (SightCaptureUI.this.gO(false)) {
                            SightCaptureUI.this.updateState(1);
                        } else {
                            SightCaptureUI.this.updateState(8);
                        }
                    }
                });
            }
            if (this.oId != null && this.oHN) {
                this.oId.setAlpha(1.0f);
                this.oId.setVisibility(0);
            }
            c cVar = this.oIq;
            x.i("MicroMsg.DeviceOrientationListener", "reset");
            cVar.oxp = -1;
            cVar.orientation = -1;
            cVar.oxo = -1;
            this.oIr = false;
            this.oIs = false;
            return;
        }
        updateState(8);
    }

    private boolean gO(boolean z) {
        x.j("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", this.oHX);
        this.oIz = false;
        if (this.iqP != null) {
            if (this.oHO != null) {
                this.oHO.b(this.iqP.bbe());
            }
            this.iqP.cancel();
        }
        if (this.oHO == null) {
            return false;
        }
        boolean a;
        this.oIi = new aqp();
        this.oIi.wEa = true;
        this.oIi.wDZ = com.tencent.mm.plugin.mmsight.model.j.oyD.oyQ;
        if (this.oAt != null) {
            this.oIi.wEc = this.oAt.scene;
        }
        if (z) {
            a = this.oHO.a((Context) this, this.oHX, true);
            this.oIh = this.oHO.oyf;
            if (!a) {
                return false;
            }
        } else if (this.oHO.a(this.oHX, true) < 0) {
            return false;
        }
        if (this.oHO.oxH == null) {
            return false;
        }
        k.bbq();
        this.iqP = k.c(this.owp);
        if (this.iqP == null) {
            x.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.oIz = true;
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.iqP, this.oAt);
        this.iqP.a(this);
        this.oHO.a(this.iqP.bbe());
        if (this.oIc != null) {
            this.oIc.R(this.oHO.aHt(), this.oHO.aHu(), this.oHO.getOrientation());
        }
        this.iqP.m(this.oHO.aHt(), this.oHO.aHu(), this.oHO.oxH.x, this.oHO.oxH.y);
        a = this.iqP.tf(this.oHO.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "preInit result: %s", Boolean.valueOf(a));
        if (!a) {
            this.oIz = true;
        }
        return a;
    }

    private int bch() {
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int c = this.iqP.c(this.oHO.getOrientation(), this.oIq.baC(), this.oIq.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", Integer.valueOf(c));
        if (c >= 0) {
            this.oHO.a(com.tencent.mm.plugin.mmsight.model.e.a.Recording);
        }
        return c;
    }

    private void bci() {
        this.oIz = true;
        updateState(8);
        if (this.iqP != null) {
            try {
                this.iqP.cancel();
                this.iqP = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
    }

    private void bcj() {
        k.bbq();
        if (k.bbt()) {
            TextView textView = (TextView) findViewById(com.tencent.mm.plugin.u.a.d.oKx);
            textView.setVisibility(8);
            textView.setText("");
        }
    }

    private void bck() {
        k.bbq();
        if (k.bbt()) {
            x.i("MicroMsg.SightCaptureUI", "test for debug " + bi.chl().toString());
            i.B(new Runnable() {
                public final void run() {
                    SightCaptureUI.N(SightCaptureUI.this);
                }
            });
        }
    }

    private String as(String str, boolean z) {
        String oF;
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
        if (z) {
            oF = com.tencent.mm.plugin.mmsight.d.oF("jpg");
        } else {
            oF = com.tencent.mm.plugin.mmsight.d.oF("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            x.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", str, oF, Boolean.valueOf(z2), Boolean.valueOf(z3));
            FileOp.x(str, oF);
            com.tencent.mm.platformtools.d.b(oF, this);
        }
        return oF;
    }

    private void bcl() {
        if (this.irS != null) {
            this.irS.a(null);
        }
        if (this.oHO != null) {
            this.oIh = this.oHO.oyf;
            this.oHO.baD();
            this.oIx = -1;
            this.jlK = -1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.mlo.release();
        if (this.iqP != null) {
            this.iqP.C(null);
        }
        if ((this.jlI == -1 ? 1 : null) == null) {
            bcl();
            if (this.oDe != null) {
                this.oDe.stop();
                this.oDe.qAJ = null;
            }
            if (this.hZB != null) {
                this.hZB.zk();
            }
            if (this.oIg != null) {
                this.oIg.release();
                this.oIg = null;
            }
        }
        if (this.oIq != null) {
            this.oIq.disable();
            this.oIq = null;
        }
        j.oAr.Ez();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.u.a.e.oKB;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        switch (i) {
            case 4369:
                x.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", Integer.valueOf(i2));
                if (i2 == -1 && intent != null && this.iqP != null) {
                    this.oID = true;
                    this.oIE = intent.getBundleExtra("report_info");
                    this.oIB = intent.getStringExtra("before_photo_edit");
                    this.oIC = intent.getStringExtra("after_photo_edit");
                    x.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", this.oIB, this.oIC, Boolean.valueOf(CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)));
                    if (CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)) {
                        this.iqP.FP(this.oIC);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        x.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", subCoreImageFullPath);
                        FileOp.x(this.oIC, subCoreImageFullPath);
                        FileOp.deleteFile(this.oIC);
                        com.tencent.mm.platformtools.d.b(this.oIC, this);
                        this.iqP.FP(subCoreImageFullPath);
                        this.oIC = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.oIC, options);
                    x.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(this.oIC, options.outHeight, options.outWidth, true, false, 0);
                    this.oIa.setVisibility(0);
                    this.oIa.setImageBitmap(a);
                    this.oIb.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String ts(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        x.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", Integer.valueOf(this.jlI), ts(this.jlI), Integer.valueOf(i), ts(i));
        x.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", Integer.valueOf(this.jlI), ts(this.jlI), Integer.valueOf(i), ts(i), bi.chl().toString());
        if (i != this.jlI) {
            com.tencent.mm.plugin.mmsight.d.FM("TIME_RECODER_2_PLAY");
            this.jlI = i;
            if (this.jlI != 7) {
                ah.K(this.oIA);
            }
            if (this.jlI == 0) {
                this.oHT.setVisibility(8);
                this.oHW.setVisibility(8);
                this.oHU.setVisibility(8);
                this.oIa.setVisibility(8);
                this.oHZ.setVisibility(0);
                if (this.oIu > 1) {
                    this.oHV.setVisibility(0);
                }
                if (this.oHO != null) {
                    this.oHO.a(com.tencent.mm.plugin.mmsight.model.e.a.Preview);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.oIw != null) {
                    try {
                        this.oIw.interrupt();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", e.getMessage());
                    }
                    this.oIw = null;
                }
            } else if (this.jlI == 1 || this.jlI == 2) {
                this.oHT.setVisibility(0);
                this.oHW.setVisibility(8);
                this.oHU.setVisibility(0);
                this.oHU.setClipChildren(false);
                this.oHR.setVisibility(8);
                this.ock.setVisibility(8);
                this.oHS.setVisibility(0);
                this.oHQ.setVisibility(0);
                this.oDe.setVisibility(8);
                if (this.jlI == 1) {
                    this.oHQ.reset();
                } else {
                    this.oHQ.gM(true);
                    MMSightRecordButton mMSightRecordButton = this.oHQ;
                    x.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
                    mMSightRecordButton.oGE.setVisibility(8);
                }
                this.oIf.setVisibility(8);
                this.oIa.setVisibility(8);
                this.oIe.setVisibility(0);
                if (this.oIu > 1) {
                    this.oHV.setVisibility(0);
                }
                this.oIe.bringToFront();
                this.oHV.bringToFront();
                bcj();
                bck();
            } else if (this.jlI == 4 || this.jlI == 3) {
                this.oHT.setVisibility(0);
                this.oHU.setVisibility(8);
                this.oHU.setClipChildren(false);
                this.oHR.setVisibility(0);
                this.ock.setVisibility(0);
                this.oHS.setVisibility(8);
                this.oHQ.setVisibility(8);
                if (this.jlI == 3) {
                    this.oHW.setVisibility(0);
                    this.oIa.setVisibility(0);
                    this.oDe.setVisibility(8);
                } else {
                    this.oIa.setVisibility(8);
                    this.oDe.setVisibility(0);
                    this.oDe.cdw();
                    ViewGroup.LayoutParams layoutParams = this.oDe.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.oDe.setLayoutParams(layoutParams);
                    if (this.iqP.baC()) {
                        this.oIc.bcp();
                    }
                    this.oHZ.setVisibility(8);
                }
                this.oIe.setVisibility(8);
            } else if (this.jlI == 6) {
                this.oHR.setVisibility(8);
                this.ock.setVisibility(8);
                this.oHW.setVisibility(8);
                this.oHS.setVisibility(8);
                this.oHQ.setVisibility(8);
            } else if (this.jlI == 7) {
                this.oHR.setVisibility(8);
                this.ock.setVisibility(8);
                this.oHS.setVisibility(8);
                this.oHV.setVisibility(8);
                this.oHW.setVisibility(8);
                this.oHQ.gM(false);
                ah.h(this.oIA, 1500);
                this.oHQ.bbZ();
            } else if (this.jlI == 8) {
                this.oHT.setVisibility(0);
                this.oHU.setVisibility(0);
                this.oHU.setClipChildren(false);
                this.oHR.setVisibility(8);
                this.ock.setVisibility(8);
                this.oHW.setVisibility(8);
                this.oHS.setVisibility(0);
                if (this.oIu > 1) {
                    this.oHV.setVisibility(0);
                }
                this.oHQ.setVisibility(0);
                this.oIe.setVisibility(0);
                this.oDe.setVisibility(8);
                this.oIf.setVisibility(8);
                this.oIa.setVisibility(8);
                if (this.oIz) {
                    Toast.makeText(this, com.tencent.mm.plugin.u.a.f.oKI, 1).show();
                } else {
                    Toast.makeText(this, com.tencent.mm.plugin.u.a.f.iEt, 1).show();
                }
                this.oHQ.gM(false);
                this.oHQ.setEnabled(false);
            } else if (this.jlI == 9) {
                this.oHR.setVisibility(8);
                this.ock.setVisibility(8);
                this.oHW.setVisibility(8);
                this.oHS.setVisibility(0);
                this.oHV.setVisibility(8);
                this.oHQ.reset();
                this.oHQ.gM(false);
                this.oHQ.setEnabled(false);
                Toast.makeText(this, com.tencent.mm.plugin.u.a.f.oKJ, 1).show();
            }
        }
    }

    private void gP(boolean z) {
        x.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", Boolean.valueOf(z), this.oIC, this.oIB);
        if (!bi.oN(this.oIC) && z) {
            FileOp.deleteFile(this.oIC);
        }
        if (!bi.oN(this.oIB)) {
            FileOp.deleteFile(this.oIB);
        }
        this.oIC = null;
        this.oIB = null;
        com.tencent.mm.sdk.b.b lsVar = new ls();
        lsVar.fDZ.fql = 0;
        com.tencent.mm.sdk.b.a.xmy.m(lsVar);
    }

    public void onBackPressed() {
        x.i("MicroMsg.SightCaptureUI", "onBackPressed %d", Integer.valueOf(this.jlI));
        if (this.oIg != null && this.oIg.aeX()) {
            return;
        }
        if (this.oIg != null) {
            this.oIg.release();
            this.oIg = null;
            Ek(8);
            this.oHR.setVisibility(0);
            this.ock.setVisibility(0);
            this.oHW.setVisibility(0);
        } else if (bcm()) {
            super.onBackPressed();
            overridePendingTransition(-1, com.tencent.mm.plugin.u.a.a.oJQ);
            gP(true);
        }
    }

    private boolean bcm() {
        return this.jlI == 4 || this.jlI == 3 || this.jlI == 1 || this.jlI == 8 || this.jlI == 9;
    }

    public final void td(int i) {
        if (this.oIu > 1 && this.jlI != 2) {
            x.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", Integer.valueOf(i));
            if (i >= 0) {
                float f;
                if (i != 90 && i != 270) {
                    f = (float) i;
                } else if (i == 270) {
                    f = 90.0f;
                } else {
                    f = -90.0f;
                }
                if (this.oHV.getRotation() != f) {
                    this.oHV.animate().rotation(f).setDuration(100).start();
                }
            }
        }
    }

    public final void Yw() {
        x.i("MicroMsg.SightCaptureUI", "onError: %s", Integer.valueOf(1));
        try {
            if (this.iqP != null) {
                this.iqP.reset();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", e.getMessage());
        }
        updateState(9);
    }
}
