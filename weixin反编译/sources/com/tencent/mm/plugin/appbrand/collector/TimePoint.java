package com.tencent.mm.plugin.appbrand.collector;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class TimePoint implements Parcelable {
    public static final Creator<TimePoint> CREATOR = new Creator<TimePoint>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            TimePoint timePoint = new TimePoint();
            timePoint.name = parcel.readString();
            timePoint.iOX.set(parcel.readLong());
            timePoint.iOW.set(parcel.readInt());
            timePoint.iOY.set((TimePoint) parcel.readParcelable(TimePoint.class.getClassLoader()));
            return timePoint;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TimePoint[i];
        }
    };
    final AtomicInteger iOW;
    final AtomicLong iOX;
    final AtomicReference<TimePoint> iOY;
    String name;

    TimePoint() {
        this.iOW = new AtomicInteger();
        this.iOX = new AtomicLong();
        this.iOY = new AtomicReference();
        this.name = "";
    }

    public TimePoint(String str, long j) {
        this.iOW = new AtomicInteger();
        this.iOX = new AtomicLong();
        this.iOY = new AtomicReference();
        this.name = str;
        this.iOX.set(j);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.iOX.get());
        parcel.writeInt(this.iOW.get());
        parcel.writeParcelable((Parcelable) this.iOY.get(), i);
    }
}
