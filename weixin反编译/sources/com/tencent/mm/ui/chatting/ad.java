package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

public final class ad {
    private static ad yFV;
    Object yFU;

    public interface b {
        boolean d(View view, MotionEvent motionEvent);
    }

    @TargetApi(14)
    public static class a implements OnHoverListener {
        private b yFW;

        public a(b bVar) {
            this.yFW = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            if (this.yFW != null) {
                return this.yFW.d(view, motionEvent);
            }
            return false;
        }
    }

    public static synchronized ad ctP() {
        ad adVar;
        synchronized (ad.class) {
            if (yFV == null) {
                yFV = new ad();
            }
            adVar = yFV;
        }
        return adVar;
    }
}
