package com.tencent.mm.plugin.music.model;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    OnAudioFocusChangeListener oOX = new OnAudioFocusChangeListener() {
        public final void onAudioFocusChange(int i) {
            x.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i));
            if (i == -2 || i == -3) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (h.bef().bdT().Qy()) {
                    h.bef().bdT().bet();
                }
            } else if (i == 1 || i == 2 || i == 3) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (h.bef().bdT().Qy()) {
                    h.bef().bdT().resume();
                }
            } else if (i == -1) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                if (h.bef().bdT().Qy()) {
                    h.bef().bdT().bet();
                    h.bef();
                    e.bea();
                    h.bef().beb();
                }
                h.beh().abandonAudioFocus(c.this.oOX);
            }
        }
    };

    public final boolean requestFocus() {
        boolean z;
        int requestAudioFocus = h.beh().requestAudioFocus(this.oOX, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    public final void bdR() {
        x.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        h.beh().abandonAudioFocus(this.oOX);
    }
}
