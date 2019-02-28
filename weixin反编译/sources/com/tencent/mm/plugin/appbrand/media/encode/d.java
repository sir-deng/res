package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.mm.plugin.appbrand.media.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;

public final class d extends b {
    private int hQJ = 2;
    private byte[] jFR;
    private FileOutputStream mFileOutputStream;
    private String mFilePath = "";

    public final boolean f(String str, int i, int i2, int i3) {
        boolean z = true;
        x.i("MicroMsg.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.mFilePath = str;
        this.hQJ = i2;
        x.i("MicroMsg.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", Integer.valueOf(Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5)));
        if (Mp3EncodeJni.init(i, i2, i, i3 / 1000, 5) == -1) {
            j.ln(17);
            return false;
        }
        x.i("MicroMsg.MP3AudioEncoder", "lame MPEG version:%d", Integer.valueOf(Mp3EncodeJni.getVersion()));
        try {
            this.mFileOutputStream = new FileOutputStream(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "init", new Object[0]);
            j.ln(18);
            z = false;
        }
        return z;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        if (this.jFN <= 0) {
            x.e("MicroMsg.MP3AudioEncoder", "mMinBufferSize %d is invalid", Integer.valueOf(this.jFN));
            return false;
        } else if (this.mFileOutputStream == null) {
            x.e("MicroMsg.MP3AudioEncoder", "mFileOutputStream is null");
            return false;
        } else {
            int i2;
            if (this.jFR == null) {
                x.i("MicroMsg.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", Integer.valueOf(this.hQJ), Integer.valueOf(this.jFN), Integer.valueOf((int) (7200.0d + (((double) (this.jFN * this.hQJ)) * 1.25d))));
                this.jFR = new byte[i2];
            }
            short[] sArr = new short[(i / 2)];
            for (i2 = 0; i2 < sArr.length; i2++) {
                sArr[i2] = (short) ((bArr[i2 * 2] & 255) | ((bArr[(i2 * 2) + 1] & 255) << 8));
            }
            i2 = Mp3EncodeJni.encode(sArr, sArr, i / 2, this.jFR);
            x.d("MicroMsg.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", Integer.valueOf(i), Integer.valueOf(sArr.length), Integer.valueOf(i2));
            if (i2 > 0) {
                x.d("MicroMsg.MP3AudioEncoder", "encodeSize:%d, len:%d", Integer.valueOf(i2), Integer.valueOf(i));
                try {
                    this.mFileOutputStream.write(this.jFR, 0, i2);
                    d(this.jFR, i2, false);
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "encode write", new Object[0]);
                    j.ln(20);
                    return false;
                }
            }
            x.e("MicroMsg.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", Integer.valueOf(i2));
            return false;
        }
    }

    public final void flush() {
        x.i("MicroMsg.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.jFR == null) {
            x.e("MicroMsg.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            return;
        }
        int flush = Mp3EncodeJni.flush(this.jFR);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.jFR, 0, flush);
                d(this.jFR, flush, true);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "flush write", new Object[0]);
                j.ln(20);
                return;
            }
        }
        x.e("MicroMsg.MP3AudioEncoder", "flush fail, flushResult:%d", Integer.valueOf(flush));
    }

    public final void close() {
        x.i("MicroMsg.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MP3AudioEncoder", e, "close", new Object[0]);
                j.ln(20);
            }
            this.mFileOutputStream = null;
        }
    }
}
