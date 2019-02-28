package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> jeP = new HashSet();
    public String jeC = (Process.myPid() + hashCode());
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
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.jeQ.send(obtain);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MainProcessTask", e.getMessage());
            return false;
        }
    }

    public final void afy() {
        jeP.add(this);
    }

    public final void afz() {
        jeP.remove(this);
    }
}
