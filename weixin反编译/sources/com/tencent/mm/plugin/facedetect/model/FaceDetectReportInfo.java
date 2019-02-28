package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.xwalk.core.XWalkUpdater;

class FaceDetectReportInfo implements Parcelable {
    public static final Creator<FaceDetectReportInfo> CREATOR = new Creator<FaceDetectReportInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReportInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReportInfo[i];
        }
    };
    protected int fkz = 0;
    protected int mkG = 0;
    protected HashMap<Integer, Long> mmA = new HashMap();
    protected long mmh = 0;
    protected int mmi = 0;
    protected int mmj = 0;
    protected int mmk = 0;
    protected int mml = 0;
    protected int mmm = 0;
    protected int mmn = 0;
    protected int mmo = 0;
    protected int mmp = 0;
    protected int mmq = 0;
    protected int mmr = 0;
    protected int mms = 0;
    protected int mmt = 0;
    protected int mmu = 0;
    protected int mmv = 0;
    protected int mmw = 0;
    protected int mmx = 0;
    protected int mmy = 0;
    protected HashMap<Integer, Long> mmz = new HashMap();

    protected FaceDetectReportInfo(Parcel parcel) {
        this.mmh = parcel.readLong();
        this.mmi = parcel.readInt();
        this.mmj = parcel.readInt();
        this.mmk = parcel.readInt();
        this.mml = parcel.readInt();
        this.mmm = parcel.readInt();
        this.mmn = parcel.readInt();
        this.mmo = parcel.readInt();
        this.mmp = parcel.readInt();
        this.mmq = parcel.readInt();
        this.mmr = parcel.readInt();
        this.mms = parcel.readInt();
        this.mmt = parcel.readInt();
        this.mmu = parcel.readInt();
        this.mmv = parcel.readInt();
        this.mmw = parcel.readInt();
        this.fkz = parcel.readInt();
        this.mkG = parcel.readInt();
        this.mmx = parcel.readInt();
        this.mmy = parcel.readInt();
        try {
            this.mmz = parcel.readHashMap(HashMap.class.getClassLoader());
            this.mmA = parcel.readHashMap(HashMap.class.getClassLoader());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mmh);
        parcel.writeInt(this.mmi);
        parcel.writeInt(this.mmj);
        parcel.writeInt(this.mmk);
        parcel.writeInt(this.mml);
        parcel.writeInt(this.mmm);
        parcel.writeInt(this.mmn);
        parcel.writeInt(this.mmo);
        parcel.writeInt(this.mmp);
        parcel.writeInt(this.mmq);
        parcel.writeInt(this.mmr);
        parcel.writeInt(this.mms);
        parcel.writeInt(this.mmt);
        parcel.writeInt(this.mmu);
        parcel.writeInt(this.mmv);
        parcel.writeInt(this.mmw);
        parcel.writeInt(this.fkz);
        parcel.writeInt(this.mkG);
        parcel.writeInt(this.mmx);
        parcel.writeInt(this.mmy);
        parcel.writeMap(this.mmz);
        parcel.writeMap(this.mmA);
    }

    public int describeContents() {
        return 0;
    }

    public final void pM(int i) {
        if (i > 0) {
            if (i == 1) {
                this.mmj++;
            } else if (i == 2) {
                this.mmk++;
            } else {
                this.mmj++;
            }
        } else if (i == 0) {
            this.mml++;
        } else if (i == -11) {
            this.mmn++;
        } else if (i == -12) {
            this.mmo++;
        } else if (i == -13) {
            this.mmp++;
        } else if (i == XWalkUpdater.ERROR_SET_VERNUM) {
            this.mmt++;
        } else if (i == -102) {
            this.mmq++;
        } else if (i == -103) {
            this.mmr++;
        } else if (i == -105) {
            this.mms++;
        } else if (i == -106) {
            this.mmm++;
        } else if (i == -107) {
            this.mmu++;
        } else if (i == -108) {
            this.mmv++;
        } else if (i == -109) {
            this.mmw++;
        } else {
            this.mmi++;
        }
    }

    public final void reset() {
        this.mmh = 0;
        this.mmj = 0;
        this.mmk = 0;
        this.mml = 0;
        this.mmi = 0;
        this.mmm = 0;
        this.mmn = 0;
        this.mmo = 0;
        this.mmp = 0;
        this.mmq = 0;
        this.mmr = 0;
        this.mms = 0;
        this.mmt = 0;
        this.mmu = 0;
        this.fkz = 0;
        this.mkG = 0;
        this.mmx = 0;
        this.mmy = 0;
        this.mmz.clear();
        this.mmA.clear();
    }

    public String toString() {
        return "detectOk: " + this.mmj + ", motionOk: " + this.mmk + ", noFace: " + this.mml + ", systemErr: " + this.mmi + ", noLiveFace: " + this.mmm + ", tooDark: " + this.mmn + ", tooLight: " + this.mmo + ", backLight: " + this.mmp + ", tooSmall: " + this.mmq + ", tooBig: " + this.mmr + ", tooActive: " + this.mms + ", poseNotValid: " + this.mmt + ", timeOut: " + this.mmu + ", totalFrame: " + this.fkz + ", verifyTime: " + this.mkG + ", processTimePerFrame: " + this.mmy;
    }
}
