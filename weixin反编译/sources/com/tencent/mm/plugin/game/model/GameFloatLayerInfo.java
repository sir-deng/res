package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameFloatLayerInfo implements Parcelable {
    public static final Creator<GameFloatLayerInfo> CREATOR = new Creator<GameFloatLayerInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameFloatLayerInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameFloatLayerInfo[i];
        }
    };
    public boolean nhE;
    public int orientation;
    public String url;

    /* synthetic */ GameFloatLayerInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.nhE ? 1 : 0);
        parcel.writeInt(this.orientation);
    }

    private GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        this.url = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.nhE = z;
        this.orientation = parcel.readInt();
    }
}
