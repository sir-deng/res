package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class WepkgMainProcessTask implements Parcelable {
    private static final Set<Object> jez = new HashSet();
    Messenger jeQ;
    int mTaskId;

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

    public final void Du() {
        if (this.jeQ != null) {
            Message obtain = Message.obtain();
            obtain.what = this.mTaskId;
            obtain.setData(WepkgMainProcessService.c(this));
            try {
                this.jeQ.send(obtain);
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgMainProcessTask", e.getMessage());
            }
        }
    }

    public final void afy() {
        jez.add(this);
    }

    public final void afz() {
        jez.remove(this);
    }
}
