package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static boolean a(AudioManager audioManager) {
        if (ar.ve()) {
            return false;
        }
        x.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(q.gHP.gGq), Integer.valueOf(q.gHP.gGp));
        if ((q.gHP.gGp == 1 || q.gHP.gGq == -1) && audioManager.isBluetoothScoOn()) {
            x.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", bi.chl());
            audioManager.stopBluetoothSco();
        }
        return true;
    }
}
