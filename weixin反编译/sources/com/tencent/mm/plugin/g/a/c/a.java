package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID kFA = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID kFz = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public final BroadcastReceiver jle = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                x.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + action);
                BluetoothDevice bluetoothDevice;
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getBondState() != 12) {
                        a.this.kFB.bS(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    }
                } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    a.this.kFB.arS();
                } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                    a aVar;
                    switch (intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1)) {
                        case 20:
                        case 21:
                            aVar = a.this.kFB;
                            return;
                        case 23:
                            aVar = a.this.kFB;
                            return;
                        default:
                            return;
                    }
                } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (a.this.kCx.containsKey(Long.valueOf(com.tencent.mm.plugin.exdevice.j.b.Aa(address)))) {
                        x.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice.getName(), address);
                        if (a.this.kFB != null) {
                            a.this.kFB.g(com.tencent.mm.plugin.exdevice.j.b.Aa(address), false);
                        }
                    }
                }
            }
        }
    };
    public BluetoothAdapter kBQ;
    public HashMap<Long, b> kCx = new HashMap();
    public a kFB;
    public Context kFC;
    public ag mHandler;
    public boolean mIsInit = false;
    private Runnable mRunnable;

    public static abstract class a {
        public void b(long j, long j2, long j3) {
        }

        public void bS(String str, String str2) {
        }

        public void arS() {
        }

        public void g(long j, boolean z) {
        }

        public void b(long j, byte[] bArr) {
        }

        public void h(long j, boolean z) {
        }

        public void b(long j, int i, String str) {
        }
    }

    private final class b implements Runnable {
        private long kCI = 0;
        private long kCJ = 0;

        public b(long j, long j2) {
            this.kCI = j;
            this.kCJ = j2;
        }

        public final void run() {
            a aVar = a.this;
            b bVar = new b(this.kCI);
            long j = bVar.mSessionId;
            b bVar2 = (b) aVar.kCx.remove(Long.valueOf(j));
            if (bVar2 != null) {
                bVar2.disconnect();
            }
            aVar.kCx.put(Long.valueOf(j), bVar);
            if (a.this.kFB != null) {
                a.this.kFB.b(j, this.kCI, this.kCJ);
            }
        }
    }

    public a(ah ahVar) {
        this.mHandler = new ag(ahVar.oFY.getLooper());
        this.mRunnable = new Runnable() {
            public final void run() {
                if (a.this.kBQ.isDiscovering()) {
                    a.this.kBQ.cancelDiscovery();
                }
            }
        };
    }

    public final boolean asa() {
        Assert.assertTrue(this.mIsInit);
        if (this.kBQ == null) {
            return false;
        }
        return true;
    }

    private boolean asb() {
        if (!this.kBQ.isDiscovering()) {
            return true;
        }
        if (this.kBQ.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
        return false;
    }

    public final boolean dW(boolean z) {
        x.i("MicroMsg.exdevice.BluetoothChatManager", "scanDevices" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!asa()) {
            x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            return false;
        } else if (!z) {
            return asb();
        } else {
            if (this.kBQ.isDiscovering() && !asb()) {
                return false;
            }
            if (this.kBQ.startDiscovery()) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
                return true;
            }
            x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            return false;
        }
    }
}
