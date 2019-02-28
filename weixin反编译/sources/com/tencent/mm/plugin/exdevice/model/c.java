package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    public static c lQg;
    private byte[] gzU = new byte[0];
    private ah hPO = new ah("ExdeviceHandlerThread");
    private final Map<Integer, Set<d>> hoJ = new HashMap();
    public m lQh;
    a lQi = new a() {
        public final void aEy() {
            if (d.this.lQm == null) {
                d.this.lQm = new c();
                d.this.lQm.lVO = null;
            }
            d.this.lQm.cy(ad.getContext());
        }
    };
    Vector<ae> lQj = new Vector();

    public interface a {
        void aEy();
    }

    public final boolean a(final ae aeVar) {
        this.hPO.F(new Runnable() {
            public final void run() {
                boolean z = true;
                Object obj = c.this;
                ae aeVar = aeVar;
                if (obj.lQh == null) {
                    x.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (obj.lQi != null) {
                        x.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        obj.lQi.aEy();
                        new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                            private long hoU = 10;

                            public final boolean uG() {
                                if (c.this.lQh == null) {
                                    long j = this.hoU;
                                    this.hoU = j - 1;
                                    if (j > 0) {
                                        return true;
                                    }
                                }
                                x.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", Long.valueOf(this.hoU));
                                if (this.hoU > 0) {
                                    c.this.aEx();
                                }
                                return false;
                            }
                        }, true).K(100, 100);
                    } else {
                        x.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    aeVar.a(obj.lQh, obj);
                } else {
                    obj.lQj.add(aeVar);
                }
            }
        });
        return true;
    }

    final void aEx() {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", Integer.valueOf(this.lQj.size()));
        if (!this.lQj.isEmpty()) {
            a((ae) this.lQj.remove(0));
        }
    }

    public final void a(long j, int i, int i2, String str) {
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.lQj.size()));
        synchronized (this.gzU) {
            aEx();
        }
    }
}
