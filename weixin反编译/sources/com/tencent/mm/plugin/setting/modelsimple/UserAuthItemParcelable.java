package com.tencent.mm.plugin.setting.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserAuthItemParcelable implements Parcelable {
    public static final Creator<UserAuthItemParcelable> CREATOR = new Creator<UserAuthItemParcelable>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
            userAuthItemParcelable.scope = parcel.readString();
            userAuthItemParcelable.qmh = parcel.readString();
            userAuthItemParcelable.state = parcel.readInt();
            userAuthItemParcelable.qmi = parcel.readInt();
            return userAuthItemParcelable;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new UserAuthItemParcelable[i];
        }
    };
    public String qmh;
    public int qmi;
    public String scope;
    public int state;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scope);
        parcel.writeString(this.qmh);
        parcel.writeInt(this.state);
        parcel.writeInt(this.qmi);
    }
}
