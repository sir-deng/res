package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends FileObserver {
    private String qnF;
    private a vkD;

    public interface a {
        void bBk();
    }

    public w(String str, a aVar) {
        super(str);
        x.i("MicroMsg.ScreenshotObserver", "observer  " + str);
        this.vkD = aVar;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.qnF == null || !str.equalsIgnoreCase(this.qnF)) {
                this.qnF = str;
                this.vkD.bBk();
                x.i("MicroMsg.ScreenshotObserver", "Send event to listener. " + str);
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
