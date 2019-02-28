package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class d extends f {
    boolean fkP;
    AudioRecord fld;
    a fle;
    byte[] fln = null;
    private int flo;
    int flp;
    private OnRecordPositionUpdateListener flq = new OnRecordPositionUpdateListener() {
        public final void onMarkerReached(AudioRecord audioRecord) {
        }

        public final void onPeriodicNotification(AudioRecord audioRecord) {
            if (!d.this.mIsPause && d.this.fld != null) {
                if (d.this.fkP || d.this.fln == null) {
                    d.this.fln = new byte[d.this.flp];
                }
                int read = d.this.fld.read(d.this.fln, 0, d.this.flp);
                x.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
                if (d.this.fll != null) {
                    d.this.fll.c(read, d.this.fln);
                }
                if (read > d.this.fln.length) {
                    read = d.this.fln.length;
                }
                if (d.this.mIsMute && read > 0) {
                    Arrays.fill(d.this.fln, 0, read, (byte) 0);
                }
                if (d.this.fle != null && read > 0) {
                    d.this.fle.q(d.this.fln, read);
                }
            }
        }
    };
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        this.fld = audioRecord;
        this.fle = aVar;
        this.fkP = z;
        this.flo = i;
        this.flp = i2;
    }

    public final boolean vs() {
        if (this.mHandlerThread != null) {
            x.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        this.mHandlerThread = e.dc("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.fld.setRecordPositionUpdateListener(this.flq, ag.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.fld.setPositionNotificationPeriod(this.flo);
        if (this.fkP || this.fln == null) {
            this.fln = new byte[this.flp];
        }
        int read = this.fld.read(this.fln, 0, this.flp);
        x.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        if (this.fle != null && read > 0) {
            this.fle.q(this.fln, read);
        }
        return true;
    }

    public final void uF() {
        this.fld.setRecordPositionUpdateListener(null);
        this.fld = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
    }

    public final void aS(boolean z) {
        this.mIsMute = z;
    }
}
