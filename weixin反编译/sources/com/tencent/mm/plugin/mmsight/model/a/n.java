package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class n implements d {
    private String frM = "";
    String fwx = null;
    boolean irp = false;
    private String jlH = null;
    private String mFileName;
    private int oAA = 0;
    private float oAB = 0.0f;
    private int oAC = 480;
    private int oAD = 640;
    private int oAE = 1600000;
    int oAF = 480;
    int oAG = 640;
    int oAH;
    private String oAI = null;
    private boolean oAN = false;
    boolean oAO = false;
    private boolean oAP = false;
    boolean oAR = false;
    int oAS = 0;
    a oAT;
    boolean oAV = true;
    private f oAW = new f() {
        public final boolean R(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            if (n.this.oAw.oBP != c.Start && n.this.oAw.oBP != c.PrepareStop) {
                return false;
            }
            if (n.this.oAw.oBP == c.PrepareStop) {
                n.this.oAw.oBP = c.WaitStop;
                x.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
            }
            n.this.oBr.dO(1);
            if (n.this.oBk != null) {
                n.this.oBk.baX();
            }
            if (n.this.oBl != null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = bArr;
                if (n.this.oBo != null) {
                    n.this.oBo.sendMessage(obtain);
                }
            }
            return true;
        }
    };
    s oAw;
    private String oAz = "";
    c oBk;
    q oBl;
    private m oBm;
    private HandlerThread oBn;
    ag oBo;
    private int oBp = 0;
    b oBq = new b("yuvRecorderWriteData");
    b oBr = new b("frameCountCallback");
    Runnable oBs = null;
    private boolean oBt = false;
    VideoTransPara owp;
    private Point oxI = null;
    private boolean oyN = false;
    int ozQ;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.n$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ byte[] juz;

        AnonymousClass9(byte[] bArr) {
            this.juz = bArr;
        }

        public final void run() {
            n nVar = n.this;
            byte[] bArr = this.juz;
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (bi.oN(nVar.fwx)) {
                            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                            nVar.oAO = false;
                            return;
                        }
                        int width;
                        Bitmap b;
                        int i = (nVar.oAH == 0 || nVar.oAH == 180) ? nVar.oAF : nVar.oAG;
                        int i2 = (nVar.oAH == 0 || nVar.oAH == 180) ? nVar.oAG : nVar.oAF;
                        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                        Rect rect = new Rect(0, 0, i, i2);
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (nVar.owp != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > nVar.owp.hwa) {
                            width = decodeByteArray.getWidth();
                            i = decodeByteArray.getHeight();
                            int i3 = nVar.owp.hwa > 0 ? nVar.owp.hwa : nVar.owp.width;
                            if (width < i) {
                                width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            } else {
                                int i4 = i3;
                                i3 = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                                width = i4;
                            }
                            decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i3, width, true);
                        }
                        if (!nVar.irp || nVar.oAS == 180) {
                            width = nVar.oAH;
                            if (nVar.oAS == 180) {
                                width += 180;
                                if (width > 360) {
                                    width -= 360;
                                }
                            }
                            b = d.b(decodeByteArray, (float) width);
                        } else if (Math.abs(nVar.oAH - nVar.oAS) == 0) {
                            b = d.b(decodeByteArray, 180.0f);
                            decodeByteArray.recycle();
                        } else {
                            b = decodeByteArray;
                        }
                        d.a(b, 60, CompressFormat.JPEG, nVar.fwx, true);
                        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", nVar.fwx, Integer.valueOf(nVar.oAH), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(FileOp.mi(nVar.fwx)));
                        return;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", e.getMessage());
                    nVar.oAO = false;
                    return;
                }
            }
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
            nVar.oAO = false;
        }
    }

    public n(VideoTransPara videoTransPara) {
        this.owp = videoTransPara;
        this.oAC = videoTransPara.width;
        this.oAD = videoTransPara.height;
        this.oAE = videoTransPara.videoBitrate;
        k.bbq();
        int bbr = k.bbr();
        if (bbr == -1) {
            this.oAE = videoTransPara.videoBitrate;
        } else {
            this.oAE = bbr;
        }
        this.oAw = new s();
        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", Integer.valueOf(this.oAC), Integer.valueOf(this.oAD), Integer.valueOf(this.oAE));
    }

    private boolean th(int i) {
        long Wz = bi.Wz();
        this.oyN = j.oyD.oyN;
        int i2 = this.oAE;
        this.ozQ = SightVideoJNI.initDataBufferForMMSight(this.oAF, this.oAG, i, this.oAC, this.oAD, (float) this.owp.fps, i2, this.owp.hvQ, 8, this.owp.hvP, 23.0f, false, false, this.owp.duration, false);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", Integer.valueOf(this.ozQ));
        if (this.ozQ < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
            k.baN();
            return false;
        }
        this.oAH = i;
        this.oBl = new q(this.oAF, this.oAG, this.oAC, this.oAD, this.oAE, this.owp.hvO, this.owp.fps, this.oyN);
        int cR = this.oBl.cR(this.ozQ, i);
        int i3 = 0;
        int i4 = -1;
        if (CaptureMMProxy.getInstance() != null) {
            i4 = CaptureMMProxy.getInstance().getInt(w.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, -1);
        }
        if (i4 < 0) {
            this.oBk = new g(this.owp.audioSampleRate, this.owp.hvN);
            this.oBk.gG(this.oBt);
            i3 = this.oBk.ax(this.ozQ, com.tencent.mm.plugin.sight.base.d.JV(this.oAz));
            if (cR < 0 || i3 < 0) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(cR), Integer.valueOf(i3));
                if (i3 < 0 && cR >= 0) {
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
                    this.oBk.clear();
                    this.oBk = new i(this.owp.audioSampleRate, this.owp.hvN);
                    this.oBk.gG(this.oBt);
                    x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", Integer.valueOf(this.oBk.ax(this.ozQ, com.tencent.mm.plugin.sight.base.d.JV(this.oAz))));
                    if (this.oBk.ax(this.ozQ, com.tencent.mm.plugin.sight.base.d.JV(this.oAz)) >= 0) {
                        return true;
                    }
                }
                SightVideoJNI.releaseBigSightDataBuffer(this.ozQ);
                k.baN();
                return false;
            }
        }
        if (i4 == 1) {
            this.oBk = new g(this.owp.audioSampleRate, this.owp.hvN);
            this.oBk.gG(this.oBt);
            i3 = this.oBk.ax(this.ozQ, com.tencent.mm.plugin.sight.base.d.JV(this.oAz));
        } else if (i4 == 2) {
            this.oBk = new i(this.owp.audioSampleRate, this.owp.hvN);
            this.oBk.gG(this.oBt);
            i3 = this.oBk.ax(this.ozQ, com.tencent.mm.plugin.sight.base.d.JV(this.oAz));
        }
        if (cR < 0 || i3 < 0) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", Integer.valueOf(cR), Integer.valueOf(i3));
            SightVideoJNI.releaseBigSightDataBuffer(this.ozQ);
            k.baN();
            return false;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", Long.valueOf(bi.bB(Wz)));
        return true;
    }

    public final boolean tf(int i) {
        if (this.oAP) {
            return true;
        }
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
        boolean th = th(i);
        this.oAP = true;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", Boolean.valueOf(th));
        return th;
    }

    public final int c(int i, boolean z, int i2) {
        int i3 = -1;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
        this.oBq.reset();
        this.oAA = 0;
        this.oBr.reset();
        this.oAO = false;
        this.irp = z;
        this.oAS = i2;
        this.oAw.a(c.WaitStart);
        if (bi.oN(this.oAz)) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
        } else {
            try {
                this.mFileName = e.bR(this.oAz);
                String mk = FileOp.mk(this.oAz);
                if (!mk.endsWith("/")) {
                    mk = mk + "/";
                }
                this.oAI = mk + "tempRotate.mp4";
            } catch (Exception e) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", e.getMessage());
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", this.oAz, this.oAI);
            this.oAH = i;
            this.oBn = com.tencent.mm.sdk.f.e.dc("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
            this.oBn.start();
            this.oBo = new ag(this.oBn.getLooper()) {
                public final void handleMessage(Message message) {
                    if (message.what == 1) {
                        byte[] bArr = (byte[]) message.obj;
                        if (bArr != null) {
                            n nVar = n.this;
                            if (nVar.oBl != null) {
                                int i;
                                boolean z;
                                int i2;
                                int i3;
                                int i4;
                                boolean z2;
                                boolean z3;
                                b bVar;
                                a aVar;
                                Looper looper;
                                b.a aVar2;
                                Object obj;
                                nVar.oBq.dO(1);
                                long Wz = bi.Wz();
                                r rVar = nVar.oBl;
                                int i5 = nVar.oAF;
                                int i6 = nVar.oAG;
                                bi.Wz();
                                int i7 = rVar.oBB;
                                boolean z4 = rVar.oyN;
                                if (z4) {
                                    i = rVar.oBC == -1 ? rVar.oBB : rVar.oBC;
                                } else if (rVar.oBC == -1 || rVar.oBC == rVar.oBB) {
                                    z = false;
                                    i2 = (rVar.oBC != -1 || rVar.oBC == rVar.oBB) ? rVar.oBB : rVar.oBC;
                                    i3 = (i2 != 0 || i2 == 180) ? i5 : i6;
                                    i4 = (i2 != 0 || i2 == 180) ? i6 : i5;
                                    z2 = i3 == rVar.nZY || i4 != rVar.mBg;
                                    z3 = (rVar.oBD != -1 || rVar.oBE == -1 || (rVar.oBD == rVar.nZY && rVar.oBE == rVar.mBg)) ? z2 : true;
                                    x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(rVar.oyN), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2));
                                    bVar = new b(i3, i4, rVar.ozz, rVar.nZY, rVar.mBg, z3, z, i7, bArr);
                                    aVar = rVar.oBF;
                                    if (!aVar.ozn) {
                                        if (aVar.handler == null) {
                                            aVar.handler = new ag(Looper.myLooper());
                                        }
                                        i4 = aVar.ozj % a.ozh;
                                        if (aVar.ozi[i4] != null) {
                                            i5 = aVar.ozj;
                                            looper = aVar.ozi[i4].getLooper();
                                            aVar2 = aVar.ozo;
                                            bVar.ozv = i5;
                                            bVar.ozA = i4;
                                            bVar.ozw = bi.Wz();
                                            x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", Integer.valueOf(bVar.ozs.length), Integer.valueOf(bVar.ozv));
                                            new ag(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(aVar2));
                                            aVar.ozj++;
                                        }
                                    }
                                    x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bi.bB(Wz)));
                                    if (!nVar.oAO && nVar.oAV) {
                                        nVar.oAO = true;
                                        obj = new byte[bArr.length];
                                        System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                        com.tencent.mm.sdk.f.e.post(new AnonymousClass9(obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                                    }
                                    nVar.oAR = true;
                                } else {
                                    z4 = true;
                                    i = rVar.oBC;
                                    i7 = Math.max(0, rVar.oBB <= 180 ? i - rVar.oBB : i + (360 - rVar.oBB));
                                    if (i7 >= 360) {
                                        i = 0;
                                    } else {
                                        z = true;
                                        if (rVar.oBC != -1) {
                                        }
                                        if (i2 != 0) {
                                        }
                                        if (i2 != 0) {
                                        }
                                        if (i3 == rVar.nZY) {
                                        }
                                        if (rVar.oBD != -1) {
                                        }
                                        x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(rVar.oyN), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2));
                                        bVar = new b(i3, i4, rVar.ozz, rVar.nZY, rVar.mBg, z3, z, i7, bArr);
                                        aVar = rVar.oBF;
                                        if (aVar.ozn) {
                                            if (aVar.handler == null) {
                                                aVar.handler = new ag(Looper.myLooper());
                                            }
                                            i4 = aVar.ozj % a.ozh;
                                            if (aVar.ozi[i4] != null) {
                                                i5 = aVar.ozj;
                                                looper = aVar.ozi[i4].getLooper();
                                                aVar2 = aVar.ozo;
                                                bVar.ozv = i5;
                                                bVar.ozA = i4;
                                                bVar.ozw = bi.Wz();
                                                x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", Integer.valueOf(bVar.ozs.length), Integer.valueOf(bVar.ozv));
                                                new ag(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(aVar2));
                                                aVar.ozj++;
                                            }
                                        }
                                        x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bi.bB(Wz)));
                                        nVar.oAO = true;
                                        obj = new byte[bArr.length];
                                        System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                        com.tencent.mm.sdk.f.e.post(new AnonymousClass9(obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                                        nVar.oAR = true;
                                    }
                                }
                                z = z4;
                                i7 = i;
                                if (rVar.oBC != -1) {
                                }
                                if (i2 != 0) {
                                }
                                if (i2 != 0) {
                                }
                                if (i3 == rVar.nZY) {
                                }
                                if (rVar.oBD != -1) {
                                }
                                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, needRotateEachFrame: %s, needScale: %s, width: %s, height: %s, rotate: %s, needRotate %s srcWidth %d srcHeight %d determinRotate %d", Boolean.valueOf(rVar.oyN), Boolean.valueOf(z3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2));
                                bVar = new b(i3, i4, rVar.ozz, rVar.nZY, rVar.mBg, z3, z, i7, bArr);
                                aVar = rVar.oBF;
                                if (aVar.ozn) {
                                    if (aVar.handler == null) {
                                        aVar.handler = new ag(Looper.myLooper());
                                    }
                                    i4 = aVar.ozj % a.ozh;
                                    if (aVar.ozi[i4] != null) {
                                        i5 = aVar.ozj;
                                        looper = aVar.ozi[i4].getLooper();
                                        aVar2 = aVar.ozo;
                                        bVar.ozv = i5;
                                        bVar.ozA = i4;
                                        bVar.ozw = bi.Wz();
                                        x.i("MicroMsg.FrameBufProcessor", "create framebuf %d %d", Integer.valueOf(bVar.ozs.length), Integer.valueOf(bVar.ozv));
                                        new ag(looper).post(new com.tencent.mm.plugin.mmsight.model.a.b.AnonymousClass1(aVar2));
                                        aVar.ozj++;
                                    }
                                }
                                x.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "writeYuvData used %sms", Long.valueOf(bi.bB(Wz)));
                                nVar.oAO = true;
                                obj = new byte[bArr.length];
                                System.arraycopy(bArr, 0, obj, 0, bArr.length);
                                com.tencent.mm.sdk.f.e.post(new AnonymousClass9(obj), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
                                nVar.oAR = true;
                            }
                        }
                    }
                }
            };
            if (!this.oAP) {
                th(i);
                this.oAP = true;
            }
            i3 = this.oBk.a(new c.a() {
                public final void baZ() {
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
                    if (n.this.oAw.oBP != c.Initialized) {
                        x.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                        return;
                    }
                    r rVar = n.this.oBl;
                    x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Start");
                    rVar.fBn = true;
                    rVar.startTime = System.currentTimeMillis();
                    n.this.oAw.a(c.Start);
                }
            });
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", Integer.valueOf(i3));
            this.oAR = false;
            if (i3 != 0) {
                this.oAw.a(c.Error);
            } else {
                this.oAw.a(c.Initialized);
            }
            k.baL();
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecCapture");
            g.pWK.a(440, 2, 1, false);
        }
        return i3;
    }

    public final void C(Runnable runnable) {
        this.oBs = runnable;
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", runnable);
        if (this.oBl == null || this.oBk == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            if (runnable != null) {
                ah.y(runnable);
            }
        } else if (this.oAw == null || this.oAw.oBP != c.Stop) {
            this.oAW = null;
            this.oAA = (int) this.oBl.bbw();
            if (this.oAw != null) {
                this.oAw.a(c.PrepareStop);
            }
            this.oBl.a(new f.a() {
                public final void bbo() {
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stopImpl result: %s", Boolean.valueOf(n.this.bbv()));
                            if (!n.this.bbv()) {
                                SightVideoJNI.releaseBigSightDataBuffer(n.this.ozQ);
                                if (n.this.oAT != null) {
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            n.this.oAT.Yw();
                                        }
                                    });
                                }
                            } else if (n.this.oBs != null) {
                                x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "call stopCallback");
                                ah.y(n.this.oBs);
                            }
                        }
                    }, "MMSightMediaCodecMP4MuxRecorder_stop");
                }
            });
            this.oBk.a(new c.b() {
                public final void bba() {
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
                }
            });
        } else {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
            if (this.oBk != null) {
                this.oBk.clear();
            }
            if (this.oBl != null) {
                this.oBl.clear();
            }
            if (runnable != null) {
                ah.y(runnable);
            }
        }
    }

    final boolean bbv() {
        long Wz = bi.Wz();
        if (!(this.oBn == null || this.oBo == null)) {
            if (com.tencent.mm.compatible.util.d.fN(18)) {
                this.oBn.quitSafely();
            } else {
                this.oBn.quit();
            }
            this.oBo = null;
        }
        this.oAB = (((float) this.oBl.frameCount) * 1000.0f) / ((float) this.oAA);
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s", Integer.valueOf(r2), Float.valueOf(this.oAB), Integer.valueOf(this.oAA), this.oAz, Long.valueOf(bi.bB(Wz)));
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", this.oBr.getValue());
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", this.oBq.getValue());
        this.oBm = new m(this.ozQ, this.oAz, this.oAB, this.oAE, this.oAA, this.owp.audioSampleRate);
        Wz = bi.Wz();
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", Long.valueOf(bi.bB(Wz)), Boolean.valueOf(this.oBm.bbn()));
        if (this.oBm.bbn()) {
            if ((this.irp && this.oyN) || (!(this.oyN || this.irp) || ((this.irp && Math.abs(this.oAH - this.oAS) == 0) || this.oAS == 180))) {
                long Wz2 = bi.Wz();
                int i = (this.oyN || this.irp) ? this.oyN ? this.oAS : 180 : this.oAH;
                if (this.oAS == 180 && !this.oyN) {
                    i += 180;
                    if (i > 360) {
                        i -= 360;
                    }
                }
                SightVideoJNI.tagRotateVideo(this.oAz, this.oAI, i);
                this.oAN = true;
                x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", Long.valueOf(bi.bB(Wz2)), Integer.valueOf(this.oAH), Boolean.valueOf(this.irp), Integer.valueOf(this.oAS), Integer.valueOf(i));
                Wz = bi.Wz();
                try {
                    FileOp.deleteFile(this.oAz);
                    FileOp.at(this.oAI, this.oAz);
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", Long.valueOf(bi.bB(Wz)));
                    final String str = this.oAI;
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            try {
                                FileOp.deleteFile(str);
                            } catch (Exception e) {
                                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", e.getMessage());
                            }
                        }
                    }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
                    return false;
                }
            }
            SightVideoJNI.releaseBigSightDataBuffer(this.ozQ);
            this.oAw.a(c.Stop);
            this.frM = com.tencent.mm.c.g.bV(this.oAI);
            return true;
        }
        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
        x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecMuxError");
        g.pWK.a(440, 31, 1, false);
        return false;
    }

    public final String Nx() {
        return bi.aD(this.frM, "");
    }

    public final void cancel() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
        if (this.oBl == null || this.oBk == null) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
            return;
        }
        this.oAw.a(c.WaitStop);
        this.oBl.a(null);
        this.oBk.a(new c.b() {
            public final void bba() {
                x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
            }
        });
        if (!(this.oBn == null || this.oBo == null)) {
            this.oBo.removeMessages(0);
            this.oBn.quit();
            this.oBo = null;
        }
        SightVideoJNI.releaseBigSightDataBuffer(this.ozQ);
        this.oAw.a(c.Stop);
        reset();
    }

    public final void setFilePath(String str) {
        this.oAz = str;
    }

    public final void FO(String str) {
        this.fwx = str;
    }

    public final void FP(String str) {
        this.jlH = str;
    }

    public final String bbb() {
        return this.jlH;
    }

    public final String getFilePath() {
        return this.oAz;
    }

    public final String getFileName() {
        return this.mFileName;
    }

    public final float bbc() {
        return this.oAB;
    }

    public final void reset() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", this.oBl, this.oBk, this.oBm);
        this.oBl = null;
        this.oBk = null;
        this.oBm = null;
        this.oAP = false;
        this.oAR = false;
    }

    public final long bbd() {
        if (this.oBl != null) {
            return this.oBl.bbw();
        }
        return 0;
    }

    public final f bbe() {
        return this.oAW;
    }

    public final void m(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.oAC = i3;
        this.oAD = i4;
        this.oAF = i;
        this.oAG = i2;
        if (j.oAr.h(Integer.valueOf(((i * i2) * 3) / 2)) == null) {
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(3));
            long Wz = bi.Wz();
            for (int i5 = 0; i5 < 3; i5++) {
                j.oAr.D(new byte[(((i * i2) * 3) / 2)]);
            }
            x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", Long.valueOf(bi.bB(Wz)));
        }
    }

    public final String aOC() {
        return this.fwx;
    }

    public final c bbf() {
        return this.oAw.oBP;
    }

    public final int bbg() {
        return Math.round(((float) this.oAA) / 1000.0f);
    }

    public final Point bbh() {
        return new Point(this.oAF, this.oAG);
    }

    public final int bbi() {
        return this.oAH;
    }

    public final void pause() {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
        if (this.oAw != null && this.oAw.oBP == c.Start) {
            this.oAw.a(c.Pause);
        }
    }

    public final void P(int i, int i2, int i3) {
        x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", Integer.valueOf(i));
        if (this.oAw != null && this.oAw.oBP == c.Pause) {
            if (this.oBl != null) {
                r rVar = this.oBl;
                rVar.oBC = i;
                rVar.oBD = i2;
                rVar.oBE = i3;
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            this.oAw.a(c.Start);
        }
    }

    public final boolean bbj() {
        return this.oAR;
    }

    public final void a(a aVar) {
        this.oAT = aVar;
    }

    public final boolean baC() {
        return this.irp;
    }

    public final void bbk() {
        this.oBt = true;
    }

    public final com.tencent.mm.audio.b.c.a bbl() {
        return this.oBk != null ? this.oBk.baY() : null;
    }

    public final void bbm() {
        this.oAV = false;
    }
}
