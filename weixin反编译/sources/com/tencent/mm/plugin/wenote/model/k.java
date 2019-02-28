package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

public final class k {
    private static k tXL = null;
    public long duration;
    public b hZB = new b(ad.getContext());
    public long kJN = -1;
    private Toast kJO;
    public boolean kKa;
    public boolean kKb;
    public final al kKh = new al(new a() {
        public final boolean uG() {
            if (k.this.kJN == -1) {
                k.this.kJN = bi.Wz();
            }
            long bB = bi.bB(k.this.kJN);
            if (bB >= 3590000 && bB <= 3600000) {
                if (k.this.kJO == null) {
                    k.this.kJO = Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.duz, new Object[]{Integer.valueOf((int) ((3600000 - bB) / 1000))}), 0);
                } else {
                    k.this.kJO.setText(ad.getContext().getString(R.l.duz, new Object[]{Integer.valueOf((int) ((3600000 - bB) / 1000))}));
                }
                k.this.kJO.show();
            }
            if (bB < 3600000) {
                return true;
            }
            x.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
            k.this.kKb = true;
            k.this.aKu();
            if (k.this.tXN != null) {
                k.this.tXN.bWI();
            }
            return false;
        }
    }, true);
    private final ag kKj = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            k.this.kKa = false;
        }
    };
    public TextView mBA;
    public long mEr;
    public j mEy;
    public String path = "";
    public com.tencent.mm.modelvoice.k tXJ;
    public String tXK = "";
    public int tXM = 0;
    public com.tencent.mm.plugin.wenote.model.b.a tXN;
    public com.tencent.mm.plugin.wenote.model.a.k tXO = null;
    public final ag tXP = new ag() {
        public final void handleMessage(Message message) {
            if (k.this.tXO.tYg.booleanValue()) {
                k.this.tXN.bWJ();
                k.this.tXO.tYg = Boolean.valueOf(false);
            }
            k.this.tXO.tYC = (int) com.tencent.mm.bh.b.bw(k.this.getDuration());
            sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 250);
        }
    };

    private k() {
    }

    public static k bWD() {
        if (tXL == null) {
            tXL = new k();
        }
        return tXL;
    }

    public final void aKu() {
        if (this.kKa) {
            boolean z;
            this.tXP.removeMessages(Downloads.RECV_BUFFER_SIZE);
            if (this.tXK.equals("speex")) {
                this.tXJ.vj();
            } else {
                this.mEy.vj();
            }
            if (this.hZB != null) {
                this.hZB.zk();
            }
            this.duration = getDuration();
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.kKh.TN();
            if (z) {
                File file = new File(this.path);
                if (file.exists()) {
                    file.delete();
                }
                this.kKj.sendEmptyMessageDelayed(0, 500);
            }
            this.kKa = false;
        }
    }

    private long getDuration() {
        if (this.mEr == 0) {
            return 0;
        }
        return bi.bB(this.mEr);
    }

    public static void destroy() {
        tXL = null;
    }

    public static k bWE() {
        return tXL;
    }
}
