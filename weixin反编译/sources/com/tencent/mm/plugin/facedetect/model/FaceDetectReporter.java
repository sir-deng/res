package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FaceDetectReporter implements Parcelable {
    public static final Creator<FaceDetectReporter> CREATOR = new Creator<FaceDetectReporter>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReporter(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReporter[i];
        }
    };
    public static FaceDetectReporter mmD = new FaceDetectReporter();
    String appId = "";
    public boolean mmB = false;
    private FaceDetectReportInfo mmC = null;
    long mmE = 0;
    long mmF = -1;
    public long mmG = -1;
    public int mmH = 0;
    public boolean mmI = false;
    public long mmh = 0;

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        this.mmh = parcel.readLong();
        this.mmB = parcel.readByte() != (byte) 0;
        this.mmC = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.mmE = parcel.readLong();
        this.mmF = parcel.readLong();
        this.mmG = parcel.readLong();
        this.mmH = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.mmI = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(this.mmh);
        parcel.writeByte((byte) (this.mmB ? 1 : 0));
        parcel.writeParcelable(this.mmC, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.mmE);
        parcel.writeLong(this.mmF);
        parcel.writeLong(this.mmG);
        parcel.writeInt(this.mmH);
        if (!this.mmI) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter aHr() {
        if (mmD != null) {
            return mmD;
        }
        FaceDetectReporter faceDetectReporter;
        synchronized (FaceDetectReporter.class) {
            if (mmD == null) {
                mmD = new FaceDetectReporter();
            }
            faceDetectReporter = mmD;
        }
        return faceDetectReporter;
    }

    public static void e(long j, int i, int i2) {
        x.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        g.pWK.h(14121, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private FaceDetectReporter() {
    }

    public final long aHs() {
        x.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.mmC == null) {
            this.mmC = new FaceDetectReportInfo();
        }
        this.mmC.reset();
        this.mmB = false;
        this.mmh = System.currentTimeMillis();
        this.mmC.mmh = this.mmh;
        return this.mmh;
    }

    public final void a(FaceDetectReporter faceDetectReporter) {
        x.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", bi.chl().toString());
        this.mmC = faceDetectReporter.mmC;
        this.mmB = faceDetectReporter.mmB;
        this.mmh = faceDetectReporter.mmh;
        String str = "MicroMsg.FaceDetectReporter";
        String str2 = "alvinluo sessionId: %d, info: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.mmh);
        objArr[1] = this.mmC != null ? this.mmC.toString() : "null";
        x.v(str, str2, objArr);
    }

    public final void D(int i, boolean z) {
        int i2 = 1;
        x.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", Integer.valueOf(i), Boolean.valueOf(z));
        g gVar = g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(this.mmh);
        if (!z) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.h(14005, objArr);
    }

    public static int pN(int i) {
        switch (i) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void a(int i, boolean z, int i2, int i3, int i4) {
        a(i, z, i2, i3, i4, 0);
    }

    public final void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        x.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", Long.valueOf(this.mmh), Boolean.valueOf(this.mmB), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.mmC != null && !this.mmB) {
            int longValue;
            int longValue2;
            x.v("MicroMsg.FaceDetectReporter", "info: %s", this.mmC.toString());
            this.mmB = true;
            this.mmC.mkG = i5;
            if (this.mmC.fkz != 0) {
                this.mmC.mmy = this.mmC.mmx / this.mmC.fkz;
            }
            if (this.mmC.mmz.containsKey(Integer.valueOf(0)) && this.mmC.mmA.containsKey(Integer.valueOf(0))) {
                longValue = (int) (((Long) this.mmC.mmA.get(Integer.valueOf(0))).longValue() - ((Long) this.mmC.mmz.get(Integer.valueOf(0))).longValue());
            } else {
                longValue = 0;
            }
            if (this.mmC.mmz.containsKey(Integer.valueOf(4)) && this.mmC.mmA.containsKey(Integer.valueOf(4))) {
                longValue2 = (int) (((Long) this.mmC.mmA.get(Integer.valueOf(4))).longValue() - ((Long) this.mmC.mmz.get(Integer.valueOf(4))).longValue());
            } else {
                longValue2 = 0;
            }
            x.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms", Integer.valueOf(longValue), Integer.valueOf(longValue2));
            g gVar = g.pWK;
            Object[] objArr = new Object[26];
            objArr[0] = Long.valueOf(this.mmh);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = Integer.valueOf(this.mmC.mmj);
            objArr[7] = Integer.valueOf(this.mmC.mmk);
            objArr[8] = Integer.valueOf(this.mmC.mml);
            objArr[9] = Integer.valueOf(this.mmC.mmi);
            objArr[10] = Integer.valueOf(this.mmC.mmm);
            objArr[11] = Integer.valueOf(this.mmC.mmn);
            objArr[12] = Integer.valueOf(this.mmC.mmo);
            objArr[13] = Integer.valueOf(this.mmC.mmp);
            objArr[14] = Integer.valueOf(this.mmC.mmq);
            objArr[15] = Integer.valueOf(this.mmC.mmr);
            objArr[16] = Integer.valueOf(this.mmC.mms);
            objArr[17] = Integer.valueOf(this.mmC.mmt);
            objArr[18] = Integer.valueOf(this.mmC.mmu);
            objArr[19] = Integer.valueOf(this.mmC.mkG);
            objArr[20] = Integer.valueOf(this.mmC.mmv);
            objArr[21] = Integer.valueOf(this.mmC.mmw);
            objArr[22] = Integer.valueOf(this.mmC.mmy);
            objArr[23] = Integer.valueOf(longValue);
            objArr[24] = Integer.valueOf(longValue2);
            objArr[25] = this.appId;
            gVar.h(14006, objArr);
        }
    }

    public final void bk(String str, int i) {
        long j = -1;
        int i2 = 1;
        if (this.mmF == -1 || this.mmG == -1 || this.mmG < this.mmF) {
            x.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", Long.valueOf(this.mmF), Long.valueOf(this.mmG));
        } else {
            j = this.mmG - this.mmF;
        }
        x.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", Long.valueOf(this.mmE), str, Integer.valueOf(-1), Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(this.mmI), this.appId, Integer.valueOf(this.mmH));
        g gVar = g.pWK;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.mmE);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(-1);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.appId;
        if (!this.mmI) {
            i2 = 0;
        }
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Long.valueOf(j);
        objArr[7] = Integer.valueOf(this.mmH);
        gVar.h(14560, objArr);
    }

    public final void q(int i, long j) {
        if (this.mmC != null) {
            FaceDetectReportInfo faceDetectReportInfo = this.mmC;
            faceDetectReportInfo.fkz++;
            faceDetectReportInfo = this.mmC;
            faceDetectReportInfo.mmx = (int) (((long) faceDetectReportInfo.mmx) + j);
            this.mmC.pM(i);
        }
    }

    public final void r(int i, long j) {
        if (this.mmC != null) {
            this.mmC.mmz.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }

    public final void s(int i, long j) {
        if (this.mmC != null) {
            this.mmC.mmA.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }
}
