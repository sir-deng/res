package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameWebViewLaunchParams implements Parcelable {
    public static final Creator<GameWebViewLaunchParams> CREATOR = new Creator<GameWebViewLaunchParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameWebViewLaunchParams(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameWebViewLaunchParams[i];
        }
    };
    public GameFloatLayerInfo nka;

    /* synthetic */ GameWebViewLaunchParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.nka, i);
    }

    private GameWebViewLaunchParams(Parcel parcel) {
        this.nka = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
    }
}
