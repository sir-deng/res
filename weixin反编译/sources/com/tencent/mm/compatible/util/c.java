package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(8)
public final class c implements b {
    private Context context;
    private AudioManager gIY;
    a gIZ;
    private OnAudioFocusChangeListener gJa = new OnAudioFocusChangeListener() {
        public final void onAudioFocusChange(int i) {
            if (c.this.gIZ != null) {
                x.d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i));
                c.this.gIZ.es(i);
            }
        }
    };

    public final void a(a aVar) {
        this.gIZ = aVar;
    }

    public c(Context context) {
        this.context = context;
    }

    public final boolean requestFocus() {
        if (this.gIY == null && this.context != null) {
            this.gIY = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gIY != null ? 1 == this.gIY.requestAudioFocus(this.gJa, 3, 2) : false;
        x.k("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gJa.hashCode()));
        return z;
    }

    public final boolean zk() {
        if (this.gIY == null && this.context != null) {
            this.gIY = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gIY != null ? 1 == this.gIY.abandonAudioFocus(this.gJa) : false;
        x.k("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.gJa.hashCode()));
        return z;
    }
}
