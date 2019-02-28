package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BroadCastData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }
    };
    ArrayList<KVReportDataInfo> pWa = new ArrayList();
    ArrayList<StIDKeyDataInfo> pWb = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> pWc = new ArrayList();

    public BroadCastData(BroadCastData broadCastData) {
        if (broadCastData != null) {
            this.pWa = new ArrayList(broadCastData.pWa);
            this.pWb = new ArrayList(broadCastData.pWb);
            this.pWc = new ArrayList(broadCastData.pWc);
        }
    }

    protected BroadCastData(Parcel parcel) {
        parcel.readTypedList(this.pWa, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.pWb, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.pWc, GroupIDKeyDataInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.pWa);
        parcel.writeTypedList(this.pWb);
        parcel.writeTypedList(this.pWc);
    }
}
