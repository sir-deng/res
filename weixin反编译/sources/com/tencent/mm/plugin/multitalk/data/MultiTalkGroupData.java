package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new Creator<MultiTalkGroupData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zZC = bi.aD(parcel.readString(), "");
            multiTalkGroup.zZD = bi.aD(parcel.readString(), "");
            multiTalkGroup.zZE = bi.aD(parcel.readString(), "");
            multiTalkGroup.zVs = parcel.readInt();
            multiTalkGroup.zZF = bi.aD(parcel.readString(), "");
            int readInt = parcel.readInt();
            multiTalkGroup.zZG = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                multiTalkGroup.zZG.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).oLs);
            }
            return new MultiTalkGroupData(multiTalkGroup);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupData[i];
        }
    };
    private MultiTalkGroup oLr;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.oLr = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aD(this.oLr.zZC, ""));
        parcel.writeString(bi.aD(this.oLr.zZD, ""));
        parcel.writeString(bi.aD(this.oLr.zZE, ""));
        parcel.writeInt(this.oLr.zVs);
        parcel.writeString(bi.aD(this.oLr.zZF, ""));
        parcel.writeInt(this.oLr.zZG.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.oLr.zZG.size()) {
                parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.oLr.zZG.get(i3)), i);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
