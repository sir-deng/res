package com.tencent.mm.compatible.e;

public final class t {
    public int gHU;
    public int gHV;
    public int gHW;
    public int gHX;
    public int gHY;
    public int gHZ;
    public int gIa;
    public int gIb;
    public int gIc;
    public int gId;
    public int gIe;

    public t() {
        reset();
    }

    public final void reset() {
        this.gHU = -1;
        this.gHV = -1;
        this.gHW = -1;
        this.gHX = -1;
        this.gHY = -1;
        this.gHZ = -1;
        this.gIa = -1;
        this.gIb = -1;
        this.gIc = -1;
        this.gId = -1;
        this.gIe = -1;
    }

    public final String toString() {
        return String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s, useMetering: %s, transcodeEncoderType: %s, checkSendVideoBitrate: %s", new Object[]{Integer.valueOf(this.gHU), Integer.valueOf(this.gHV), Integer.valueOf(this.gHW), Integer.valueOf(this.gHX), Integer.valueOf(this.gHY), Integer.valueOf(this.gHZ), Integer.valueOf(this.gIa), Integer.valueOf(this.gIb), Integer.valueOf(this.gIc), Integer.valueOf(this.gId), Integer.valueOf(this.gIe)});
    }
}
