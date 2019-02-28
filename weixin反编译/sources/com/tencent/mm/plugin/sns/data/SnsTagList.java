package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsTagList implements Parcelable {
    public static final Creator<SnsTagList> CREATOR = new Creator<SnsTagList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsTagList snsTagList = new SnsTagList();
            snsTagList.qWW = parcel.readInt();
            for (int i = 0; i < snsTagList.qWW; i++) {
                snsTagList.qWX.add(Long.valueOf(parcel.readLong()));
            }
            return snsTagList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsTagList[i];
        }
    };
    private int qWW = 0;
    private List<Long> qWX = new LinkedList();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.qWW = this.qWX.size();
        parcel.writeInt(this.qWW);
        for (Long longValue : this.qWX) {
            parcel.writeLong(longValue.longValue());
        }
    }
}
