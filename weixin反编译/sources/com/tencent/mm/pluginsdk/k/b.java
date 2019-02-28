package com.tencent.mm.pluginsdk.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public Context context;
    public int fileSize;
    public String filename;
    public int hVH;
    public MediaRecorder oAo;
    private boolean oxw = false;
    public a qDx;
    public f vpd;
    public int vpe = 0;
    private final int vpf = 5;
    private a vpg = new a(Looper.getMainLooper());

    private static class a extends Handler {
        int jhF = 0;
        boolean oxw = false;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            Camera camera = (Camera) message.obj;
            Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.jhF;
            if (this.oxw) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }

    @SuppressLint({"NewApi"})
    public final void b(Surface surface, int i, int i2) {
        while (this.vpd != null) {
            Camera camera = this.vpd.gGm;
            if (surface == null || camera == null) {
                x.e("MicroMsg.SceneVideo", "holder or cam is null ");
                return;
            }
            int i3 = q.gHP.gGL == -1 ? i : q.gHP.gGL;
            int caC = f.caC();
            try {
                camera.unlock();
            } catch (Exception e) {
                x.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", e.getMessage());
            }
            this.oAo = new MediaRecorder();
            this.oAo.setCamera(camera);
            this.oAo.setAudioSource(5);
            this.oAo.setVideoSource(1);
            this.oAo.setOutputFormat(2);
            this.oAo.setVideoSize(this.qDx.mqM, this.qDx.mqN);
            this.oAo.setVideoEncoder(2);
            this.oAo.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                this.oAo.setVideoEncodingBitRate(this.qDx.oyU);
            }
            try {
                if (q.gHH.gIj) {
                    this.oAo.setVideoFrameRate(q.gHH.gIk);
                } else {
                    this.oAo.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                x.d("MicroMsg.SceneVideo", "try set fps failed: " + i3);
            }
            this.oAo.setOutputFile(this.qDx.ozd);
            this.oAo.setPreviewDisplay(surface);
            x.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", Integer.valueOf(caC), this.qDx.toString());
            if (caC == 0) {
                setOrientationHint(q.gHP.gGF == -1 ? 90 : q.gHP.gGF);
            } else {
                if (q.gHP.gGG == -1) {
                    i3 = 270;
                } else {
                    i3 = q.gHP.gGG;
                }
                setOrientationHint(i3);
            }
            try {
                this.oAo.prepare();
                this.oAo.start();
                return;
            } catch (Throwable e3) {
                x.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", e3.getMessage(), Integer.valueOf(this.vpe));
                x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                this.vpe++;
                if (this.vpe < 5) {
                    f fVar = this.vpd;
                    if (i2 < 0 || i2 >= fVar.vpo.size()) {
                        x.d("MicroMsg.YuvReocrder", "ret fr " + i);
                    } else {
                        x.d("MicroMsg.YuvReocrder", "ret fr " + fVar.vpo.get(i2));
                        i = ((Integer) fVar.vpo.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
        x.e("MicroMsg.SceneVideo", "yuvRecoder is null");
    }

    @TargetApi(9)
    private void setOrientationHint(final int i) {
        com.tencent.mm.compatible.a.a.a(9, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                if (b.this.oAo != null) {
                    b.this.oAo.setOrientationHint(i);
                }
            }
        });
    }

    public final int a(Activity activity, boolean z) {
        int line;
        this.context = activity;
        f fVar = this.vpd;
        a aVar = this.qDx;
        if (aVar == null) {
            line = 0 - g.getLine();
        } else {
            fVar.vpn = aVar;
            if (fVar.bgR == null && fVar.oxC == null) {
                fVar.bgR = (SensorManager) activity.getSystemService("sensor");
                fVar.oxC = fVar.bgR.getDefaultSensor(1);
            }
            if (z || fVar.gGm == null) {
                fVar.baD();
                if (z) {
                    f.oxz = (f.oxz ^ -1) & 1;
                }
                fVar.oxB = d.o(activity, f.oxz);
                if (fVar.oxB == null) {
                    x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                    line = 0 - g.getLine();
                } else {
                    fVar.gGm = fVar.oxB.gGm;
                    fVar.vpn.fGt = fVar.oxB.fGt;
                    if (fVar.gGm == null) {
                        x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                        line = 0 - g.getLine();
                    }
                }
            }
            line = 0;
        }
        if (line != 0) {
            return line;
        }
        return 0;
    }

    public final int cax() {
        this.vpd.baD();
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        return this.vpd.b(surfaceHolder);
    }

    public final int aHt() {
        if (this.vpd.gGm == null) {
            return 0;
        }
        return this.vpd.gGm.getParameters().getPreviewSize().width;
    }

    public final int aHu() {
        if (this.vpd.gGm == null) {
            return 0;
        }
        return this.vpd.gGm.getParameters().getPreviewSize().height;
    }
}
