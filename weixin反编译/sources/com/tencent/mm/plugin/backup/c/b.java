package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.plugin.backup.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class b extends d {
    private static b kqv;
    String kqA = "tickit";
    private d kqw;
    private c kqx;
    private a kqy;
    private a kqz;
    private WakeLock wakeLock = null;

    public static b apy() {
        if (kqv == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            kqv = bVar;
            com.tencent.mm.plugin.backup.a.a.a(bVar);
        }
        return kqv;
    }

    public final void aoN() {
        kqv = null;
    }

    public final void j(Object... objArr) {
        final String str = (String) objArr[0];
        ah.y(new Runnable() {
            public final void run() {
                c apB = b.apy().apB();
                x.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", str);
                as.CN().a(595, apB.krb);
                as.CN().a(new e(r1), 0);
            }
        });
    }

    public final a apz() {
        if (this.kqz == null) {
            this.kqz = new a();
        }
        return this.kqz;
    }

    public final d apA() {
        if (this.kqw == null) {
            this.kqw = new d();
        }
        return this.kqw;
    }

    public final c apB() {
        if (this.kqx == null) {
            this.kqx = new c();
        }
        return this.kqx;
    }

    public final a apC() {
        if (this.kqy == null) {
            this.kqy = new a();
        }
        return this.kqy;
    }

    public final void aoT() {
        ah.y(new Runnable() {
            public final void run() {
                try {
                    if (b.this.wakeLock == null) {
                        b.this.wakeLock = ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock");
                    }
                    if (!b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.acquire();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    public final void aoU() {
        ah.y(new Runnable() {
            public final void run() {
                try {
                    if (b.this.wakeLock != null && b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.release();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
