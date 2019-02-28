package com.tencent.mm.plugin.setting.modelsimple;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SwitchAccountModel implements Parcelable {
    public static final Creator<SwitchAccountModel> CREATOR = new Creator<SwitchAccountModel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SwitchAccountModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SwitchAccountModel[i];
        }
    };
    public final String muD;
    public final String qme;
    public final String qmf;
    public final int qmg;
    public final String username;

    public SwitchAccountModel(String str, String str2, String str3, String str4, int i) {
        this.qme = str;
        this.username = str2;
        this.muD = str3;
        this.qmf = str4;
        this.qmg = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.qme);
        parcel.writeString(this.username);
        parcel.writeString(this.muD);
        parcel.writeString(this.qmf);
        parcel.writeInt(this.qmg);
    }
}
