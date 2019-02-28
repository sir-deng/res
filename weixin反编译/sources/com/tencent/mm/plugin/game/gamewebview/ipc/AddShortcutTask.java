package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.base.model.d;
import com.tencent.mm.plugin.base.model.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class AddShortcutTask extends GWMainProcessTask {
    public static final Creator<AddShortcutTask> CREATOR = new Creator<AddShortcutTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AddShortcutTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AddShortcutTask[i];
        }
    };
    public String appId;
    public Runnable jfW;
    public boolean success;
    public String username;

    /* synthetic */ AddShortcutTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void YA() {
        if (bi.oN(this.appId) || bi.oN(this.username)) {
            x.e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            return;
        }
        d.a(ad.getContext(), this.username, this.appId, new a() {
            public final void dS(boolean z) {
                AddShortcutTask.this.success = z;
                AddShortcutTask.this.afF();
            }
        });
    }

    public final void YB() {
        if (this.jfW != null) {
            this.jfW.run();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.success = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
    }

    private AddShortcutTask(Parcel parcel) {
        f(parcel);
    }
}
