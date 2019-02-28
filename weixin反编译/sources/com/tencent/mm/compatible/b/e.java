package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements a {
    private AcousticEchoCanceler gDK = null;

    @TargetApi(16)
    public e(AudioRecord audioRecord) {
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        x.d("MicroMsg.MMAcousticEchoCanceler", "available  " + isAvailable);
        if (isAvailable) {
            this.gDK = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AcousticEchoCanceler.isAvailable();
    }

    @TargetApi(16)
    public final boolean xM() {
        if (this.gDK != null) {
            try {
                int enabled = this.gDK.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                x.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMAcousticEchoCanceler", e, "", new Object[0]);
            }
        }
        return false;
    }
}
