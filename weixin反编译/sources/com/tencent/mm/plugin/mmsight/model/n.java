package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class n {
    final Object lock = new byte[0];
    boolean oyH = false;
    a oyI;

    n() {
    }

    public final a o(Context context, int i) {
        if (context == null) {
            return null;
        }
        final long Wy = bi.Wy();
        final long id = Thread.currentThread().getId();
        synchronized (this.lock) {
            this.oyH = false;
            this.oyI = null;
            final Context context2 = context;
            final int i2 = i;
            e.post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.SightCamera.OpenCameraThread", "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(id), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(bi.Wy() - Wy));
                    synchronized (n.this.lock) {
                        try {
                            n.this.oyI = d.o(context2, i2);
                        } catch (Exception e) {
                            x.e("MicroMsg.SightCamera.OpenCameraThread", "openCamera failed e:%s", e.getMessage());
                            n.this.oyI = null;
                        }
                        if (n.this.oyH && n.this.oyI != null) {
                            x.e("MicroMsg.SightCamera.OpenCameraThread", "thread time out now, release camera :%d ", Long.valueOf(bi.Wy() - Wy));
                            try {
                                Camera camera = n.this.oyI.gGm;
                                camera.setPreviewCallback(null);
                                camera.stopPreview();
                                camera.release();
                                n.this.oyI = null;
                            } catch (Exception e2) {
                                x.e("MicroMsg.SightCamera.OpenCameraThread", "realease Camera failed e:%s", e2.getMessage());
                            }
                        }
                        n.this.lock.notify();
                    }
                    return;
                }
            }, "SightCamera_openCamera");
            try {
                this.lock.wait(30000);
            } catch (InterruptedException e) {
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Lock wait failed e:%s", e.getMessage());
            }
            if (this.oyI == null || this.oyI.gGm == null) {
                this.oyH = true;
                x.e("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Timeout:%d", Long.valueOf(bi.Wy() - Wy));
                return null;
            }
            x.i("MicroMsg.SightCamera.OpenCameraThread", "Open Camera Succ thread:%d Time:%d camera:%s", Long.valueOf(id), Long.valueOf(bi.Wy() - Wy), this.oyI.gGm);
            a aVar = this.oyI;
            return aVar;
        }
    }
}
