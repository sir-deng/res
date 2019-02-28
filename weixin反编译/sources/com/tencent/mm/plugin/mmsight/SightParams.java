package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new Creator<SightParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightParams[i];
        }
    };
    public int mode = 0;
    public int owo = 2;
    public VideoTransPara owp;
    public String owq = "";
    public String owr = "";
    public String ows = "";
    public String owt = "";
    public String owu = "";
    public boolean owv = true;
    public boolean oww = true;
    public int owx;
    public int scene = -1;

    public SightParams(int i, int i2) {
        if (i == 1) {
            this.owp = d.Na().Nb();
        } else if (i == 2 || i == 3 || i == 4) {
            this.owp = d.Na().Nc();
        } else {
            this.owp = d.Na().Nc();
        }
        this.scene = i;
        this.mode = i2;
        g.Dr();
        this.owx = ((Integer) g.Dq().Db().get(344066, Integer.valueOf(0))).intValue();
    }

    protected SightParams(Parcel parcel) {
        boolean z = true;
        this.mode = parcel.readInt();
        this.owp = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.owq = parcel.readString();
        this.owr = parcel.readString();
        this.ows = parcel.readString();
        this.owt = parcel.readString();
        this.owx = parcel.readInt();
        this.owo = parcel.readInt();
        this.owv = parcel.readInt() > 0;
        this.scene = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.oww = z;
    }

    public final SightParams j(String str, String str2, String str3, String str4) {
        this.ows = str;
        this.owq = str2;
        this.owr = str3;
        this.owt = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.owp, i);
        parcel.writeString(this.owq);
        parcel.writeString(this.owr);
        parcel.writeString(this.ows);
        parcel.writeString(this.owt);
        parcel.writeInt(this.owx);
        parcel.writeInt(this.owo);
        parcel.writeInt(this.owv ? 1 : 0);
        parcel.writeInt(this.scene);
        if (!this.oww) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
    }
}
