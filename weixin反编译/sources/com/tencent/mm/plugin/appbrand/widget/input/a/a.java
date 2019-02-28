package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.mm.sdk.platformtools.ag;

public final class a {
    private final ag H = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (1000 == message.what) {
                String str = (String) message.obj;
                int i = message.arg1;
                if (a.this.kgv != null) {
                    a.this.kgv.aC(str, i);
                }
            }
        }
    };
    public volatile c kgv;

    public final void a(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            Message obtainMessage = this.H.obtainMessage(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
            this.H.removeMessages(1000);
            this.H.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        }
    }
}
