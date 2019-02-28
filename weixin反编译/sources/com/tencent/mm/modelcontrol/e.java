package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bi;

public final class e {
    protected String hvM;
    protected int hvN;
    protected int hvO;
    protected int hvP;
    protected int hvQ;
    protected boolean hvR;
    protected f[] hvS;

    protected final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.hvM = str;
        this.hvN = bi.getInt(str2, 0);
        this.hvN = this.hvN == 0 ? 64000 : this.hvN * 1000;
        this.hvO = bi.getInt(str3, 1);
        this.hvP = bi.getInt(str4, 2);
        this.hvQ = bi.getInt(str5, 1);
        if (bi.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.hvR = z;
    }

    protected final boolean Nj() {
        if (bi.oN(this.hvM)) {
            return true;
        }
        return b.kN(this.hvM);
    }

    protected final VideoTransPara Nk() {
        VideoTransPara videoTransPara = null;
        if (this.hvS != null) {
            for (f fVar : this.hvS) {
                if (fVar != null && fVar.hvT <= 0 && fVar.hvU >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.hvV;
                    videoTransPara.height = fVar.hvW;
                    videoTransPara.fps = fVar.hvX;
                    videoTransPara.videoBitrate = fVar.hvY;
                    videoTransPara.hvO = this.hvO;
                    videoTransPara.hvN = this.hvN;
                    videoTransPara.hvP = this.hvP;
                    videoTransPara.hvQ = this.hvQ;
                }
            }
        }
        return videoTransPara;
    }

    public final String toString() {
        return "[ busyTime " + this.hvM + " audioBitrate " + this.hvN + " iFrame " + this.hvO + " profileIndex " + this.hvP + " presetIndex " + this.hvQ + " isStepBr " + this.hvR + " ]";
    }
}
