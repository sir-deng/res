package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.tencent.mm.plugin.g.a.c.c.a;
import com.tencent.mm.plugin.g.a.c.c.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public BluetoothDevice kCP;
    public long kFE;
    public a kFF = null;
    public com.tencent.mm.plugin.g.a.c.c.b kFG = null;
    public c kFH = null;
    public long mSessionId;
    public int mState = 0;

    public b(long j) {
        this.kFE = j;
        this.mSessionId = j;
        this.kCP = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(com.tencent.mm.plugin.g.a.e.a.bN(j));
    }

    public final void disconnect() {
        x.i("MicroMsg.exdevice.BluetoothChatSession", "disconnect");
        this.mState = 0;
        if (this.kFF != null) {
            this.kFF.disconnect();
            this.kFF = null;
        }
        if (this.kFG != null) {
            this.kFG.cancel();
            e.Q(this.kFG);
            this.kFG = null;
        }
        if (this.kFH != null) {
            this.kFH.cancel();
            e.Q(this.kFG);
            this.kFH = null;
        }
    }
}
