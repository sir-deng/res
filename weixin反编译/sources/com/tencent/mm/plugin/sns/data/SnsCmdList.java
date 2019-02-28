package com.tencent.mm.plugin.sns.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class SnsCmdList implements Parcelable {
    public static final Creator<SnsCmdList> CREATOR = new Creator<SnsCmdList>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            int i = 0;
            SnsCmdList snsCmdList = new SnsCmdList();
            snsCmdList.qWP = parcel.readInt();
            snsCmdList.qWR.clear();
            for (int i2 = 0; i2 < snsCmdList.qWP; i2++) {
                snsCmdList.qWR.add(Integer.valueOf(parcel.readInt()));
            }
            snsCmdList.qWQ = parcel.readInt();
            snsCmdList.qWS.clear();
            while (i < snsCmdList.qWQ) {
                snsCmdList.qWS.add(Integer.valueOf(parcel.readInt()));
                i++;
            }
            return snsCmdList;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsCmdList[i];
        }
    };
    private int qWP = 0;
    private int qWQ = 0;
    public List<Integer> qWR = new LinkedList();
    public List<Integer> qWS = new LinkedList();

    public final void wL(int i) {
        this.qWR.add(Integer.valueOf(i));
    }

    public final void wM(int i) {
        this.qWS.add(Integer.valueOf(i));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        this.qWP = this.qWR.size();
        parcel.writeInt(this.qWP);
        for (int i3 = 0; i3 < this.qWP; i3++) {
            parcel.writeInt(((Integer) this.qWR.get(i3)).intValue());
        }
        this.qWQ = this.qWS.size();
        parcel.writeInt(this.qWQ);
        while (i2 < this.qWQ) {
            parcel.writeInt(((Integer) this.qWS.get(i2)).intValue());
            i2++;
        }
    }
}
