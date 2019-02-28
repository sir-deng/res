package com.tencent.mm.plugin.g.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static boolean cp(Context context) {
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")));
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean asa() {
        boolean z;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", Boolean.valueOf(z));
        return z;
    }

    public static boolean asc() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        x.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", Boolean.valueOf(defaultAdapter.isEnabled()));
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    public static String bN(long j) {
        return b.cL(j);
    }
}
