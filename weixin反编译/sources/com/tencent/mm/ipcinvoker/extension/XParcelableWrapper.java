package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.o;

public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new Creator<XParcelableWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            XParcelableWrapper xParcelableWrapper = new XParcelableWrapper();
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (xParcelableWrapper.gOM == null) {
                    xParcelableWrapper.gOM = (f) o.e(readString, f.class);
                }
                if (xParcelableWrapper.gOM != null) {
                    xParcelableWrapper.gOM.readFromParcel(parcel);
                }
            }
            return xParcelableWrapper;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XParcelableWrapper[i];
        }
    };
    public f gOM;

    /* synthetic */ XParcelableWrapper(byte b) {
        this();
    }

    private XParcelableWrapper() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gOM != null) {
            parcel.writeInt(1);
            parcel.writeString(this.gOM.getClass().getName());
            this.gOM.e(parcel);
            return;
        }
        parcel.writeInt(0);
    }
}
