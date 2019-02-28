package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import com.tencent.mm.network.i.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends a {
    private al hmy = new al(new al.a() {
        public final boolean uG() {
            x.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(ac.this.icP.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((n) ac.this.icP.getBroadcastItem(i)).eq(ac.this.icM);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetworkEvent", "exception:%s", bi.i(e));
                }
            }
            ac.this.icP.finishBroadcast();
            return false;
        }
    }, false);
    private int icM = 4;
    private long icN;
    private int icO = 0;
    private final RemoteCallbackList<n> icP = new RemoteCallbackList();

    public final int Vy() {
        x.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > bi.bz(this.icN) ? 5 : this.icM));
        return 0 > bi.bz(this.icN) ? 5 : this.icM;
    }

    public final boolean c(n nVar) {
        try {
            this.icP.register(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "addListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bi.i(e));
        }
        return true;
    }

    public final boolean d(n nVar) {
        boolean z = false;
        try {
            return this.icP.unregister(nVar);
        } catch (Throwable e) {
            x.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            x.e("MicroMsg.NetworkEvent", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final void Vz() {
        this.icP.kill();
    }

    public final void iW(int i) {
        int i2 = 0;
        x.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (i != this.icM) {
            if (3 != i) {
                if (2 == i) {
                    if (!(this.icM == 0 || this.icM == 1)) {
                        this.icO++;
                        if (this.icO > 0) {
                            this.icM = 2;
                            i2 = 1;
                        }
                    }
                } else if (4 == i) {
                    this.icO = 0;
                    this.icM = 4;
                    i2 = 1;
                }
                this.icM = i;
                i2 = 1;
            } else if (this.icM == 2) {
                this.icM = i;
                i2 = 1;
            }
        }
        if (i2 != 0) {
            if (i == 0 || i == 4 || i == 6) {
                this.hmy.K(1000, 1000);
            }
        }
    }

    public final long VA() {
        return this.icN;
    }
}
