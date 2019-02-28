package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoTransPara(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }
    };
    public int audioSampleRate;
    public int duration;
    public int fps;
    public int height;
    public int hvN;
    public int hvO;
    public int hvP;
    public int hvQ;
    public int hwa = 0;
    public boolean isDefault;
    public int videoBitrate;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        boolean z = false;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.fps = parcel.readInt();
        this.videoBitrate = parcel.readInt();
        this.duration = parcel.readInt();
        this.hvO = parcel.readInt();
        this.hvN = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.hvP = parcel.readInt();
        this.hvQ = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.isDefault = z;
        this.hwa = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.videoBitrate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.hvO);
        parcel.writeInt(this.hvN);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.hvP);
        parcel.writeInt(this.hvQ);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.hwa);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.hvO + " audio bitrate " + this.hvN + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.hvP + " preset index " + this.hvQ + " thumbSize " + this.hwa + "]";
    }
}
