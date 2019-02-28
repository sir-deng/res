package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    int audioSampleRate;
    c fkr = null;
    private int hvN;
    private final int jFJ = 100;
    int jFm;
    boolean oAa = false;
    boolean oAb = false;
    a oAc = null;
    o oAd;
    ag oAe = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (h.this.oAc != null) {
                h.this.oAc.baZ();
                h.this.oAc = null;
            }
        }
    };
    protected boolean oAf;
    boolean oAg;
    final Object oAh = new byte[0];
    b oAi;
    boolean oAj = false;
    ag oAk;
    Runnable oAl = new Runnable() {
        public final void run() {
            if (h.this.fkr != null) {
                h.this.oAj = true;
                h.this.fkr.vj();
            }
        }
    };
    private c.a oAm = new c.a() {
        public final void q(byte[] bArr, int i) {
            int i2 = 0;
            h.this.oAe.sendEmptyMessage(0);
            if (!h.this.oAa) {
                i2 = 1;
            }
            if (i2 == 0) {
                h.this.jFm += FileUtils.S_IWUSR;
            }
            boolean z = h.this.oAf;
            if (i2 == 0) {
                h hVar = h.this;
                if (0 == hVar.ozU) {
                    hVar.ozU = System.nanoTime();
                }
                if (hVar.oAd != null && hVar.oAd.oBz <= 0) {
                    hVar.oAd.oBz = System.nanoTime();
                }
                if (hVar.ozR != null) {
                    if (hVar.ozR == null) {
                        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                    } else {
                        try {
                            ByteBuffer[] inputBuffers = hVar.ozR.getInputBuffers();
                            int dequeueInputBuffer = hVar.ozR.dequeueInputBuffer(100);
                            hVar.ozV = dequeueInputBuffer;
                            if (dequeueInputBuffer < 0) {
                                x.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                                hVar.gH(false);
                            }
                            if (hVar.ozR == null) {
                                x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                            } else if (hVar.ozV >= 0) {
                                ByteBuffer byteBuffer = inputBuffers[hVar.ozV];
                                byteBuffer.clear();
                                byteBuffer.put(bArr);
                                byteBuffer.position(0);
                                hVar.ozW = bArr.length;
                                hVar.ozX = System.nanoTime();
                                hVar.ozX -= (long) ((hVar.ozW / hVar.audioSampleRate) / 1000000000);
                                if (hVar.ozW == -3) {
                                    x.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                                }
                                hVar.ozY = (hVar.ozX - (hVar.oAd != null ? hVar.oAd.oBz : hVar.ozU)) / 1000;
                                x.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + hVar.ozW + " audio bytes with pts " + hVar.ozY + ", end:" + z + ", enqueue:" + hVar.ozV);
                                if (z) {
                                    x.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                    hVar.ozR.queueInputBuffer(hVar.ozV, 0, hVar.ozW, hVar.ozY, 4);
                                } else {
                                    hVar.ozR.queueInputBuffer(hVar.ozV, 0, hVar.ozW, hVar.ozY, 0);
                                }
                            }
                        } catch (Throwable th) {
                            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th.getMessage());
                        }
                    }
                    hVar.gH(z);
                }
            }
            if (z && !h.this.oAj) {
                synchronized (h.this.oAh) {
                    if (h.this.oAi != null) {
                        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                        h.this.oAi.bba();
                        h.this.oAi = null;
                    } else {
                        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                    }
                    h.this.oAg = true;
                }
                h.this.oAj = true;
                h.this.oAk.removeCallbacks(h.this.oAl);
                h.this.oAk.post(h.this.oAl);
            }
        }

        public final void aK(int i, int i2) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    };
    MediaCodec ozR;
    private MediaFormat ozS;
    private BufferInfo ozT;
    long ozU = 0;
    int ozV;
    int ozW;
    long ozX;
    long ozY;
    private int ozZ;
    private long startTime = 0;

    public h(int i, int i2) {
        this.hvN = i2;
        this.audioSampleRate = i;
        this.oAd = null;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", Integer.valueOf(this.hvN), Integer.valueOf(this.audioSampleRate));
    }

    public int ax(int i, String str) {
        String str2;
        String str3;
        Object[] objArr;
        if (!(this.oAb || this.fkr == null)) {
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.oAi == null);
            x.e(str2, str3, objArr);
            this.fkr.vj();
        }
        if (this.ozR != null) {
            boolean z;
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.oAi == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            this.ozR.stop();
            this.ozR.release();
            this.ozR = null;
            if (this.oAi != null) {
                this.oAi.bba();
                this.oAi = null;
            }
        }
        this.jFm = 0;
        this.oAf = false;
        synchronized (this.oAh) {
            this.oAg = false;
            this.oAi = null;
        }
        if (!this.oAb) {
            this.fkr = new c(this.audioSampleRate, 1, 5);
            this.fkr.et(FileUtils.S_IWUSR);
            this.fkr.aQ(false);
            this.fkr.fle = this.oAm;
        }
        if (this.oAk == null) {
            x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.oAk = new ag();
        } else if (this.oAk.getLooper() != Looper.myLooper()) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", this.oAk.getLooper(), Looper.myLooper());
            this.oAk = new ag();
        }
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.hvN));
        try {
            this.ozT = new BufferInfo();
            this.ozS = new MediaFormat();
            this.ozS.setString("mime", "audio/mp4a-latm");
            this.ozS.setInteger("aac-profile", 2);
            this.ozS.setInteger("sample-rate", this.audioSampleRate);
            this.ozS.setInteger("channel-count", 1);
            this.ozS.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.hvN);
            this.ozS.setInteger("max-input-size", 16384);
            this.ozR = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.ozR.configure(this.ozS, null, null, 1);
            this.ozR.start();
            return 0;
        } catch (Throwable th) {
            MediaCodec th2 = th;
            x.printErrStackTrace("MicroMsg.MMSightAACMediaCodecRecorder", th2, "start aac encoder error: %s", th2.getMessage());
            if (this.ozR != null) {
                try {
                    this.ozR.stop();
                    this.ozR.release();
                    this.ozR = th2;
                } catch (Exception e) {
                    str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
                    str3 = "try to stop aac encoder error: %s";
                    this.ozR = null;
                    x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
                    g.pWK.a(440, 15, 1, false);
                    return -1;
                } catch (Throwable th3) {
                    th2 = th3;
                    this.ozR = null;
                }
            }
            x.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
            g.pWK.a(440, 15, 1, false);
            return -1;
        } finally {
            this.oAa = false;
        }
    }

    public final int a(a aVar) {
        int i = 0;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", aVar);
        this.oAc = aVar;
        if (!this.oAb) {
            if (this.fkr == null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
                return -1;
            } else if (!this.fkr.vs()) {
                i = -1;
            }
        }
        return i;
    }

    public final int a(b bVar) {
        boolean z;
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.fkr == null);
        if (this.oAi == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.oAf);
        x.i(str, str2, objArr);
        if (this.fkr == null && !this.oAb) {
            return -1;
        }
        this.oAf = true;
        synchronized (this.oAh) {
            this.oAi = bVar;
            if (this.oAg && bVar != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                bVar.bba();
                this.oAi = null;
            }
        }
        ah.h(new Runnable() {
            public final void run() {
                try {
                    if (h.this.ozR != null) {
                        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
                        h.this.ozR.stop();
                        h.this.ozR.release();
                        h.this.ozR = null;
                    }
                    if (h.this.fkr != null && !h.this.oAb) {
                        h.this.fkr.vj();
                        h.this.fkr = null;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", e.getMessage());
                }
            }
        }, 500);
        return 0;
    }

    public final void clear() {
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        try {
            if (this.ozR != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.ozR.stop();
                this.ozR.release();
                this.ozR = null;
            }
            if (this.fkr != null && !this.oAb) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
                this.fkr.vj();
                this.fkr = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", e.getMessage());
        }
    }

    public final void baX() {
        this.oAa = true;
    }

    public final c.a baY() {
        return this.oAm;
    }

    public final void gG(boolean z) {
        this.oAb = z;
    }

    final void gH(boolean z) {
        if (this.ozR == null) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.ozR.getOutputBuffers();
            while (true) {
                this.ozZ = this.ozR.dequeueOutputBuffer(this.ozT, 100);
                x.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", Integer.valueOf(this.ozZ));
                if (this.ozZ == -1) {
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    return;
                } else if (this.ozZ == -3) {
                    outputBuffers = this.ozR.getOutputBuffers();
                } else if (this.ozZ == -2) {
                    MediaFormat outputFormat = this.ozR.getOutputFormat();
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + outputFormat);
                    if (this.oAd != null) {
                        this.oAd.d(outputFormat);
                    }
                } else if (this.ozZ < 0) {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(this.ozZ));
                } else {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.ozZ];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + this.ozZ + " was null");
                    }
                    if ((this.ozT.flags & 2) != 0) {
                        x.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(this.ozT.size), Boolean.valueOf(bbp()));
                        if (bbp()) {
                            this.ozT.size = 0;
                        }
                    }
                    if (this.ozT.size != 0) {
                        if (!(this.oAd == null || this.oAd.fBn)) {
                            this.oAd.d(this.ozR.getOutputFormat());
                        }
                        byteBuffer.position(this.ozT.offset);
                        byteBuffer.limit(this.ozT.offset + this.ozT.size);
                        e(byteBuffer, this.ozT);
                    }
                    this.ozR.releaseOutputBuffer(this.ozZ, false);
                    if ((this.ozT.flags & 4) != 0) {
                        if (z) {
                            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                            this.ozR.stop();
                            this.ozR.release();
                            this.ozR = null;
                            return;
                        }
                        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", e.getMessage());
        }
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.oAd != null && (bufferInfo.flags & 4) == 0) {
            this.oAd.f(byteBuffer, bufferInfo);
        }
    }

    protected boolean bbp() {
        return false;
    }
}
