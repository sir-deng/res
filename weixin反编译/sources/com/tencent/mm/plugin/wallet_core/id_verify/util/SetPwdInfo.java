package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SetPwdInfo implements Parcelable {
    public static final Creator<SetPwdInfo> CREATOR = new Creator<SetPwdInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SetPwdInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetPwdInfo[i];
        }
    };
    public String oja;
    public String ojb = "";
    public String ojc = "";
    public int sQA;

    protected SetPwdInfo(Parcel parcel) {
        this.sQA = parcel.readInt();
        this.oja = parcel.readString();
        this.ojb = parcel.readString();
        this.ojc = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sQA);
        parcel.writeString(this.oja);
        parcel.writeString(this.ojb);
        parcel.writeString(this.ojc);
    }

    public int describeContents() {
        return 0;
    }
}
