package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new Creator<WrapperParcelable>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            WrapperParcelable wrapperParcelable = new WrapperParcelable();
            if (parcel.readInt() == 1) {
                wrapperParcelable.gOJ = c.a(parcel.readString(), parcel);
            }
            return wrapperParcelable;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WrapperParcelable[i];
        }
    };
    Object gOJ;

    /* synthetic */ WrapperParcelable(byte b) {
        this();
    }

    private WrapperParcelable() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gOJ != null) {
            a av = c.av(this.gOJ);
            if (av != null) {
                parcel.writeInt(1);
                parcel.writeString(av.getClass().getName());
                av.a(this.gOJ, parcel);
                return;
            }
        }
        parcel.writeInt(1);
    }
}
