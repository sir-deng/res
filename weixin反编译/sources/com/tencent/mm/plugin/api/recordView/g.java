package com.tencent.mm.plugin.api.recordView;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

final class g implements OnTouchListener {
    private long ism = -1;
    private float isn = -1.0f;
    private int iso = 0;
    a isp;

    public interface a {
        void Yx();

        void Yy();

        void Yz();
    }

    g() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
        r8 = this;
        r7 = 1;
        r6 = 0;
        r5 = 0;
        r4 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r0 = r10.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x000f;
            case 1: goto L_0x0070;
            case 2: goto L_0x007e;
            case 3: goto L_0x000e;
            case 4: goto L_0x000e;
            case 5: goto L_0x0050;
            case 6: goto L_0x0060;
            default: goto L_0x000e;
        };
    L_0x000e:
        return r7;
    L_0x000f:
        r0 = "MicroMsg.MMSightRecordViewTouchListener";
        r1 = "ACTION_DOWN";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r8.ism;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0040;
    L_0x0020:
        r0 = android.os.SystemClock.elapsedRealtime();
        r2 = r8.ism;
        r0 = r0 - r2;
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0040;
    L_0x002d:
        r0 = r8.isp;
        if (r0 == 0) goto L_0x0031;
    L_0x0031:
        r0 = android.os.SystemClock.elapsedRealtime();
        r8.ism = r0;
        r8.isn = r4;
        r0 = r8.iso;
        r0 = r0 + 1;
        r8.iso = r0;
        goto L_0x000e;
    L_0x0040:
        r0 = r8.isp;
        if (r0 == 0) goto L_0x0031;
    L_0x0044:
        r0 = r8.isp;
        r10.getX();
        r10.getY();
        r0.Yx();
        goto L_0x0031;
    L_0x0050:
        r0 = "MicroMsg.MMSightRecordViewTouchListener";
        r1 = "ACTION_POINTER_DOWN";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r8.iso;
        r0 = r0 + 1;
        r8.iso = r0;
        goto L_0x000e;
    L_0x0060:
        r0 = "MicroMsg.MMSightRecordViewTouchListener";
        r1 = "ACTION_POINTER_UP";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r8.iso;
        r0 = r0 + -1;
        r8.iso = r0;
        goto L_0x000e;
    L_0x0070:
        r0 = "MicroMsg.MMSightRecordViewTouchListener";
        r1 = "ACTION_UP";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r8.isn = r4;
        r8.iso = r6;
        goto L_0x000e;
    L_0x007e:
        r0 = r8.iso;
        r1 = 2;
        if (r0 < r1) goto L_0x000e;
    L_0x0083:
        r0 = r8.w(r10);
        r1 = "MicroMsg.MMSightRecordViewTouchListener";
        r2 = "distance: %s";
        r3 = new java.lang.Object[r7];
        r4 = java.lang.Float.valueOf(r0);
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.x.v(r1, r2, r3);
        r1 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x000e;
    L_0x009c:
        r1 = r8.isn;
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x00c8;
    L_0x00a2:
        r1 = r8.isn;
        r1 = r0 - r1;
        r1 = java.lang.Math.abs(r1);
        r2 = 1097859072; // 0x41700000 float:15.0 double:5.424144515E-315;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x000e;
    L_0x00b0:
        r1 = r8.isn;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 <= 0) goto L_0x00cc;
    L_0x00b6:
        r1 = "MicroMsg.MMSightRecordViewTouchListener";
        r2 = "zoom out";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r8.isp;
        if (r1 == 0) goto L_0x00c8;
    L_0x00c3:
        r1 = r8.isp;
        r1.Yy();
    L_0x00c8:
        r8.isn = r0;
        goto L_0x000e;
    L_0x00cc:
        r1 = "MicroMsg.MMSightRecordViewTouchListener";
        r2 = "zoom in";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r8.isp;
        if (r1 == 0) goto L_0x00c8;
    L_0x00d9:
        r1 = r8.isp;
        r1.Yz();
        goto L_0x00c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.api.recordView.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private float w(MotionEvent motionEvent) {
        try {
            if (this.iso >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                return Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", e.getMessage());
        }
        return 0.0f;
    }
}
