package com.tencent.mm.audio.c;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class d implements a {
    private static com.tencent.mm.audio.c.a.a fnp = new com.tencent.mm.audio.c.a.a();
    private boolean fnd = false;
    private BlockingQueue<com.tencent.mm.audio.b.g.a> fnf = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    private String fnh;
    private int fni = 0;
    private byte[] fnj = null;
    private int fnk = 16000;
    private Object fnl = new Object();
    private a fnm = null;
    private int fnn;
    private boolean fno = false;
    private FileOutputStream mFileOutputStream;
    private int mSampleRate = 16000;

    private final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void run() {
            x.i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                boolean a;
                synchronized (d.this) {
                    a = d.this.fnd;
                }
                x.d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + d.this.fnf.size());
                if (!a || !d.this.fnf.isEmpty()) {
                    try {
                        com.tencent.mm.audio.b.g.a aVar = (com.tencent.mm.audio.b.g.a) d.this.fnf.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            x.i("MicroMsg.SilkWriter", "poll byte null file:" + d.this.fnh);
                        } else {
                            int size = d.this.fnf.size();
                            if (size > 10 || a) {
                                x.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                                size = false;
                            } else if (size < 9) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (d.fnp.count >= 10 && d.fnp.fmS > 240) {
                                size = 0;
                            }
                            d.this.a(aVar, size, false);
                        }
                    } catch (InterruptedException e) {
                        x.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public d(int i, int i2) {
        this.mSampleRate = i;
        this.fnk = i2;
    }

    public final boolean cL(String str) {
        x.i("MicroMsg.SilkWriter", "initWriter path: " + str);
        if (str == null) {
            x.e("MicroMsg.SilkWriter", "path is null");
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.fnh = str;
            this.mFileOutputStream = fileOutputStream;
            int yw = m.yw();
            if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                this.fnn = 4;
            } else if ((yw & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                this.fnn = 2;
            } else {
                x.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                return false;
            }
            if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fnk, this.fnn) != 0) {
                x.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fnk, this.fnn)));
                return false;
            }
            this.fnj = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
            yw = -1;
            c fp = com.tencent.mm.y.c.c.IL().fp("100279");
            if (fp.isValid()) {
                yw = bi.getInt((String) fp.civ().get("isVoiceMsgOptOpen"), 0);
            }
            if (1 == yw) {
                this.fno = true;
            }
            if (yw == 0) {
                this.fno = false;
            }
            if (this.fno) {
                MediaRecorder.SetVoiceSilkControl(200, 1);
                x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
            } else {
                MediaRecorder.SetVoiceSilkControl(200, 0);
                x.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e.getMessage());
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(byte[] r7, int r8, boolean r9) {
        /*
        r6 = this;
        r5 = 0;
        r1 = -1;
        r2 = "MicroMsg.SilkWriter";
        r3 = "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s";
        r0 = 4;
        r4 = new java.lang.Object[r0];
        r0 = r6.fnf;
        if (r0 != 0) goto L_0x0033;
    L_0x000f:
        r0 = r1;
    L_0x0010:
        r0 = java.lang.Integer.valueOf(r0);
        r4[r5] = r0;
        r0 = 1;
        if (r7 != 0) goto L_0x003a;
    L_0x0019:
        r1 = java.lang.Integer.valueOf(r1);
        r4[r0] = r1;
        r0 = 2;
        r1 = java.lang.Integer.valueOf(r8);
        r4[r0] = r1;
        r0 = 3;
        r1 = java.lang.Boolean.valueOf(r9);
        r4[r0] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
        if (r8 > 0) goto L_0x003c;
    L_0x0032:
        return;
    L_0x0033:
        r0 = r6.fnf;
        r0 = r0.size();
        goto L_0x0010;
    L_0x003a:
        r1 = r7.length;
        goto L_0x0019;
    L_0x003c:
        monitor-enter(r6);
        r0 = r6.fnd;	 Catch:{ all -> 0x004c }
        if (r0 == 0) goto L_0x004f;
    L_0x0041:
        r0 = "MicroMsg.SilkWriter";
        r1 = "already stop";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x004c }
        monitor-exit(r6);	 Catch:{ all -> 0x004c }
        goto L_0x0032;
    L_0x004c:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x004c }
        throw r0;
    L_0x004f:
        monitor-exit(r6);	 Catch:{ all -> 0x004c }
        r0 = r6.fnm;
        if (r0 != 0) goto L_0x0063;
    L_0x0054:
        r0 = new com.tencent.mm.audio.c.d$a;
        r0.<init>(r6, r5);
        r6.fnm = r0;
        r0 = r6.fnm;
        r1 = "SilkWriter_run";
        com.tencent.mm.sdk.f.e.post(r0, r1);
    L_0x0063:
        r0 = r6.fnf;
        if (r0 == 0) goto L_0x0032;
    L_0x0067:
        r0 = r6.fnf;
        r1 = new com.tencent.mm.audio.b.g$a;
        r1.<init>(r7, r8, r9);
        r0.add(r1);
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.c.d.b(byte[], int, boolean):void");
    }

    public final void vK() {
        x.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            this.fnd = true;
        }
        if (this.fnm != null) {
            try {
                e.S(this.fnm);
            } catch (Throwable e) {
                x.e("MicroMsg.SilkWriter", "exception:%s", bi.i(e));
            }
        }
        synchronized (this.fnl) {
            MediaRecorder.SilkEncUnInit();
        }
        x.i("MicroMsg.SilkWriter", "finish Thread file:" + this.fnh);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "close silk file:" + this.fnh + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean vL() {
        x.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.fnl) {
            MediaRecorder.SilkEncUnInit();
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fnk, this.fnn) == 0) {
            return true;
        }
        x.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fnk, this.fnn)));
        return false;
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i) {
        return a(aVar, 0, false);
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i, boolean z) {
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.mSampleRate * 20) * 2) / 1000);
        short s2 = this.fni + aVar.flJ;
        int i2 = 0;
        Object obj = new byte[s];
        byte[] bArr = new byte[((this.fno ? 6 : 1) * s)];
        String value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceNoiseSuppression");
        boolean z2 = !bi.oN(value) ? bi.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        x.d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z2));
        int i3 = 0;
        while (s2 >= s) {
            int SilkDoEnc;
            if (this.fni > 0) {
                try {
                    System.arraycopy(this.fnj, 0, obj, 0, this.fni);
                    System.arraycopy(aVar.buf, 0, obj, this.fni, s - this.fni);
                    i2 += s - this.fni;
                    this.fni = 0;
                } catch (Exception e) {
                    x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.fni), Integer.valueOf(s - this.fni), e.getMessage());
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, obj, 0, s);
                i2 += s;
            } catch (Exception e2) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i2), Short.valueOf(s), e2.getMessage());
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.fnl) {
                if (this.fno) {
                    if (s3 >= s || !aVar.flK) {
                        MediaRecorder.SetVoiceSilkControl(201, 0);
                    } else {
                        MediaRecorder.SetVoiceSilkControl(201, 1);
                        x.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                    }
                }
                SilkDoEnc = MediaRecorder.SilkDoEnc(obj, s, bArr, sArr, z2);
            }
            Object obj2 = null;
            if (z && sArr[0] >= (short) 10 && bArr[0] == (byte) 2 && bArr[1] == (byte) 35 && bArr[2] == (byte) 33 && bArr[3] == (byte) 83 && bArr[4] == (byte) 73 && bArr[5] == (byte) 76 && bArr[6] == (byte) 75 && bArr[7] == (byte) 95 && bArr[8] == (byte) 86 && bArr[9] == (byte) 51) {
                x.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj2 = 1;
            }
            if (SilkDoEnc != 0) {
                this.fni = 0;
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(SilkDoEnc));
                return -1;
            }
            x.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(aVar.flK), Integer.valueOf(aVar.flJ));
            try {
                if (sArr[0] < bArr.length && sArr[0] > (short) 0) {
                    if (!z || obj2 == null) {
                        this.mFileOutputStream.write(bArr, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        x.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.mFileOutputStream.write(Arrays.copyOfRange(bArr, 1, bArr.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.fnh);
                return -1;
            }
        }
        try {
            this.mFileOutputStream.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.fnj, this.fni, s2);
                this.fni += s2;
                long zp = aVar2.zp();
                if (i == 1) {
                    com.tencent.mm.audio.c.a.a aVar3 = fnp;
                    aVar3.fmS = ((aVar3.fmS * ((long) aVar3.count)) + zp) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                x.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + zp + " useFloat:" + i + " avg:" + fnp.fmS + " cnt:" + fnp.count);
                return i3;
            } catch (Exception e22) {
                x.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i2), Integer.valueOf(this.fni), Integer.valueOf(s2), e22.getMessage());
                return -1;
            }
        } catch (IOException e4) {
            x.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.fnh);
            return -1;
        }
    }
}
