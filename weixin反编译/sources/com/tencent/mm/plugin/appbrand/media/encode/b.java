package com.tencent.mm.plugin.appbrand.media.encode;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.media.encode.c.a;
import com.tencent.mm.sdk.platformtools.x;

public class b implements c {
    String jFK = "audio/mp4a-latm";
    String jFL = "audio/mpeg";
    a jFM = null;
    int jFN = 0;
    int jFO = 0;
    byte[] jFP;
    int jFQ = 0;

    public final void lo(int i) {
        x.i("MicroMsg.AudioEncoder", "mMinBufferSize:%d", Integer.valueOf(this.jFN));
        this.jFN = i;
    }

    public final void a(a aVar) {
        this.jFM = aVar;
    }

    public final void lp(int i) {
        x.i("MicroMsg.AudioEncoder", "setEncodeBuffFrameSize frameSize:%d", Integer.valueOf(i));
        this.jFO = i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        this.jFP = new byte[(i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)];
    }

    public boolean f(String str, int i, int i2, int i3) {
        return false;
    }

    public boolean a(boolean z, byte[] bArr, int i) {
        return false;
    }

    public void flush() {
    }

    public void close() {
    }

    public final void d(byte[] bArr, int i, boolean z) {
        if (this.jFM == null) {
            x.e("MicroMsg.AudioEncoder", "mEncodeListener is null, return");
        } else if (this.jFO == 0) {
            x.e("MicroMsg.AudioEncoder", "no frameSize, return");
        } else {
            if (i > this.jFO) {
                x.w("MicroMsg.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", Integer.valueOf(i), Integer.valueOf(this.jFO));
            }
            x.d("MicroMsg.AudioEncoder", "bufferedSize:%d, buffSize:%d", Integer.valueOf(this.jFQ), Integer.valueOf(i));
            int i2 = this.jFQ + i;
            if (i2 >= this.jFO && bArr != null) {
                x.d("MicroMsg.AudioEncoder", "flush all, currentBufferedSize:%d", Integer.valueOf(i2));
                if (i2 > this.jFP.length) {
                    x.i("MicroMsg.AudioEncoder", "expand the end codeBuffer:%d", Integer.valueOf(i2));
                    Object obj = this.jFP;
                    this.jFP = new byte[i2];
                    System.arraycopy(obj, 0, this.jFP, 0, this.jFQ);
                }
                System.arraycopy(bArr, 0, this.jFP, this.jFQ, i);
                this.jFM.c(this.jFP, i2, false);
                this.jFQ = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.jFP, this.jFQ, i);
                this.jFQ = i2;
                x.d("MicroMsg.AudioEncoder", "append buff, currentBufferedSize:%d", Integer.valueOf(this.jFQ));
            }
            if (z) {
                x.i("MicroMsg.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", Integer.valueOf(this.jFQ));
                this.jFM.c(this.jFP, this.jFQ, z);
                this.jFQ = 0;
            }
        }
    }
}
