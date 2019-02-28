package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new Creator<MultiTalkGroupMemberData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.zZH = bi.aD(parcel.readString(), "");
            multiTalkGroupMember.zZI = bi.aD(parcel.readString(), "");
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.aAk = parcel.readInt();
            multiTalkGroupMember.zYH = parcel.readInt();
            return new MultiTalkGroupMemberData(multiTalkGroupMember);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMemberData[i];
        }
    };
    MultiTalkGroupMember oLs;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.oLs = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bi.aD(this.oLs.zZH, ""));
        parcel.writeString(bi.aD(this.oLs.zZI, ""));
        parcel.writeInt(this.oLs.status);
        parcel.writeInt(this.oLs.aAk);
        parcel.writeInt(this.oLs.zYH);
    }
}
