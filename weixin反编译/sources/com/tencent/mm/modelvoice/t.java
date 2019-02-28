package com.tencent.mm.modelvoice;

import com.tencent.mm.ad.h;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements a {
    private static int fmB = 100;
    String fileName = "";
    private b fmz;
    private h.a hZD = null;
    private int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int vk() {
        b bVar = this.fmz;
        return ((bVar.fks == com.tencent.mm.compatible.b.b.a.PCM || bVar.fks == com.tencent.mm.compatible.b.b.a.SILK) && bVar.fkr != null) ? bVar.fkr.flj : 1;
    }

    public final void a(h.a aVar) {
        this.hZD = aVar;
    }

    public t(com.tencent.mm.compatible.b.b.a aVar) {
        this.fmz = new b(aVar);
    }

    public final boolean cI(String str) {
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            x.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fileName = str;
        try {
            this.fmz.a(new b.a() {
                public final void onError() {
                    if (t.this.hZD != null) {
                        t.this.hZD.onError();
                    }
                    try {
                        t.this.fmz.release();
                        t.this.status = -1;
                    } catch (Exception e) {
                        x.e("VoiceRecorder", "setErrorListener File[" + t.this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
                    }
                }
            });
            this.fmz.vm();
            this.fmz.vn();
            this.fmz.vl();
            this.fmz.setOutputFile(this.fileName);
            this.fmz.setMaxDuration(70000);
            this.fmz.prepare();
            this.fmz.start();
            x.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.zp());
            this.status = 1;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean vj() {
        if (this.fmz == null) {
            return true;
        }
        try {
            this.fmz.vp();
            this.fmz.release();
            this.fileName = "";
            this.status = 0;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final int getMaxAmplitude() {
        if (this.status != 1) {
            return 0;
        }
        int maxAmplitude = this.fmz.getMaxAmplitude();
        if (maxAmplitude > fmB) {
            fmB = maxAmplitude;
        }
        return (maxAmplitude * 100) / fmB;
    }
}
