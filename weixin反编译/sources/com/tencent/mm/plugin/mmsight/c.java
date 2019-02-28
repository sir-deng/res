package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c {
    private static ConcurrentSkipListSet<Integer> ovW = new ConcurrentSkipListSet();

    public static synchronized void sX(int i) {
        synchronized (c.class) {
            try {
                x.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i));
                ovW.add(Integer.valueOf(i));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e.getMessage());
            }
        }
        return;
    }

    public static synchronized void sY(int i) {
        synchronized (c.class) {
            try {
                x.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i));
                ovW.remove(Integer.valueOf(i));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e.getMessage());
            }
        }
        return;
    }

    public static synchronized boolean sZ(int i) {
        boolean contains;
        synchronized (c.class) {
            try {
                contains = ovW.contains(Integer.valueOf(i));
                x.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i), Boolean.valueOf(contains));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e.getMessage());
                contains = false;
            }
        }
        return contains;
    }
}
