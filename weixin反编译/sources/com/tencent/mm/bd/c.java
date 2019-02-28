package com.tencent.mm.bd;

import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.c.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    public BlockingQueue<g.a> hQO = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public String mFileName = null;

    public final boolean JH() {
        x.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        e eVar = new e();
        String SJ = b.SJ();
        try {
            x.i("MicroMsg.SpeexEncoderWorker", "path " + SJ);
            File file = new File(SJ);
            if (!file.exists()) {
                file.mkdir();
            }
            eVar.cL(SJ + this.mFileName + ".temp");
            while (this.hQO.size() > 0) {
                g.a aVar = (g.a) this.hQO.poll();
                if (aVar.buf != null && aVar.flJ > 0) {
                    eVar.a(aVar, 0, false);
                }
            }
            eVar.vK();
            try {
                new File(SJ + this.mFileName + ".temp").renameTo(new File(SJ + this.mFileName + ".spx"));
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexEncoderWorker", "exception:%s", bi.i(e));
            }
            e.SS().start();
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e2);
        }
        return true;
    }

    public final boolean JI() {
        return false;
    }
}
