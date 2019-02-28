package com.tencent.mm.plugin.appbrand.collector;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class CollectSession implements Parcelable {
    public static final Creator<CollectSession> CREATOR = new Creator<CollectSession>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            CollectSession collectSession = new CollectSession();
            collectSession.groupId = parcel.readString();
            collectSession.id = parcel.readString();
            collectSession.iOL = (TimePoint) parcel.readParcelable(CollectSession.class.getClassLoader());
            collectSession.iOO = parcel.readString();
            Bundle readBundle = parcel.readBundle();
            if (readBundle != null) {
                collectSession.fxY.putAll(readBundle);
            }
            TimePoint timePoint = collectSession.iOL;
            if (timePoint != null) {
                collectSession.iON.put(timePoint.name, timePoint);
                while (timePoint.iOY.get() != null) {
                    timePoint = (TimePoint) timePoint.iOY.get();
                    collectSession.iON.put(timePoint.name, timePoint);
                }
                collectSession.iOM = timePoint;
            }
            return collectSession;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CollectSession[i];
        }
    };
    public final Bundle fxY = new Bundle();
    String groupId;
    TimePoint iOL;
    TimePoint iOM;
    final Map<String, TimePoint> iON = new HashMap();
    String iOO;
    String id;

    CollectSession() {
    }

    public CollectSession(String str) {
        this.id = str;
    }

    public final void qF(String str) {
        Assert.assertNull(this.iOL);
        this.iOL = new TimePoint(str, System.nanoTime());
        this.iOM = this.iOL;
        this.iOL.iOW.set(1);
        this.iON.put(str, this.iOL);
    }

    public final void qG(String str) {
        Assert.assertNotNull(this.iOM);
        long nanoTime = System.nanoTime();
        TimePoint timePoint = (TimePoint) this.iON.get(str);
        if (timePoint == null) {
            timePoint = new TimePoint(str, nanoTime);
            timePoint.iOW.set(1);
            this.iON.put(str, timePoint);
            this.iOM.iOY.set(timePoint);
            this.iOM = timePoint;
            return;
        }
        timePoint.iOX.set((nanoTime + (timePoint.iOX.get() * ((long) timePoint.iOW.get()))) / ((long) (timePoint.iOW.get() + 1)));
        timePoint.iOW.incrementAndGet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.id);
        parcel.writeParcelable(this.iOL, i);
        parcel.writeString(this.iOO);
        parcel.writeBundle(this.fxY);
    }
}
