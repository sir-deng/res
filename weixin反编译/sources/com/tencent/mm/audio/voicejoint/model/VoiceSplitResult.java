package com.tencent.mm.audio.voicejoint.model;

import com.tencent.mm.sdk.platformtools.x;

public class VoiceSplitResult {
    private static final int CHECK_LENGTH_EXTRA_IN_MS = 300;
    private static final int SPLIT_RESULT_MAX_LENGTH = 50;
    private static final int SPLIT_RESULT_MIN_LENGTH = 12;
    private static final String TAG = "MicroMsg.VoiceSplitResult";
    public int cityLen;
    public int cityStartPos;
    public int nameLen;
    public int nameStartPos;
    public int[] splitResult;
    public int splitResultCode;
    public int splitResultLength;
    public int starVoiceId;
    public String userOriginPcmFilePath;

    public VoiceSplitResult(int i) {
        this.splitResultCode = i;
    }

    public boolean isSuccess() {
        return this.splitResultCode == 1 && this.splitResult != null && this.splitResult.length > 0 && this.splitResultLength > 0;
    }

    public void checkAdjustResult(c cVar) {
        if (this.splitResult != null) {
            int i = this.splitResultLength + 4;
            Object obj = new int[i];
            System.arraycopy(this.splitResult, 0, obj, 2, this.splitResultLength);
            obj[0] = null;
            obj[1] = obj[2];
            obj[3] = obj[4];
            if (hasCity()) {
                obj[5] = obj[6];
            }
            obj[i - 2] = this.splitResult[this.splitResultLength - 1];
            obj[i - 1] = this.splitResult[this.splitResultLength - 1];
            if (cVar != null) {
                this.nameStartPos = this.splitResult[0];
                this.nameLen = (this.splitResult[2] - this.splitResult[0]) + 9600;
                int i2 = (int) (((float) ((this.splitResult[2] - this.splitResult[1]) * 1000)) / 32000.0f);
                x.d(TAG, "alvinluo voice split nameLengthInMs: %d, limit: %d", Integer.valueOf(i2), Integer.valueOf(cVar.fmO));
                if (i2 > 0 && i2 > cVar.fmO) {
                    x.e(TAG, "alvinluo voice split name length overlimit");
                    this.splitResultCode = -104;
                }
                if (hasCity()) {
                    this.cityStartPos = this.splitResult[2];
                    this.cityLen = (this.splitResult[4] - this.splitResult[2]) + 9600;
                    i2 = (int) (((float) ((this.splitResult[4] - this.splitResult[3]) * 1000)) / 32000.0f);
                    x.d(TAG, "alvinluo voice split cityLengthInMs: %d, limit: %d", Integer.valueOf(i2), Integer.valueOf(cVar.fmP));
                    if (i2 > 0 && i2 > cVar.fmP) {
                        x.e(TAG, "alvinluo voice split city length overlimit");
                        this.splitResultCode = -105;
                    }
                }
            }
            this.splitResult = obj;
            this.splitResultLength = i;
        }
    }

    public boolean hasCity() {
        return (this.starVoiceId == 2 || this.starVoiceId == 66 || this.starVoiceId == 70) ? false : true;
    }
}
