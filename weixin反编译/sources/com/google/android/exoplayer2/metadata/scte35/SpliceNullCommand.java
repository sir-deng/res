package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Creator<SpliceNullCommand> CREATOR = new Creator<SpliceNullCommand>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SpliceNullCommand[i];
        }
    };

    public final void writeToParcel(Parcel parcel, int i) {
    }
}
