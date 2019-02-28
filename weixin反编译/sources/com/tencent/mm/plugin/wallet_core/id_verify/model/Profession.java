package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new Creator<Profession>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Profession(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Profession[i];
        }
    };
    public String sQn;
    public int sQo;

    public Profession(String str, int i) {
        this.sQn = str;
        this.sQo = i;
    }

    protected Profession(Parcel parcel) {
        this.sQn = parcel.readString();
        this.sQo = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sQn);
        parcel.writeInt(this.sQo);
    }
}
