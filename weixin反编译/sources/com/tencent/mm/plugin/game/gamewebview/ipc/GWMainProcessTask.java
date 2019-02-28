package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class GWMainProcessTask implements Parcelable {
    private static final Set<Object> jez = new HashSet();
    String jeC = (Process.myPid() + hashCode());
    Messenger jeQ;

    public abstract void YA();

    public void YB() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }

    public final boolean afF() {
        if (this.jeQ == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(GameWebViewMainProcessService.a(this, false));
        try {
            this.jeQ.send(obtain);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GWMainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void afy() {
        jez.add(this);
    }

    public final void afz() {
        jez.remove(this);
    }
}
