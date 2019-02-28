package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.protocal.c.acw;

public class GameMenuParcel implements Parcelable {
    public static final Creator<GameMenuParcel> CREATOR = new Creator<GameMenuParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameMenuParcel(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameMenuParcel[i];
        }
    };
    public String appId;
    public acw jbb;

    /* synthetic */ GameMenuParcel(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        c.a(this.jbb, parcel);
    }

    private GameMenuParcel(Parcel parcel) {
        this.appId = parcel.readString();
        this.jbb = (acw) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}
