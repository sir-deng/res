package com.tencent.mm.audio.voicejoint.model;

public class VoiceJointResult {
    public int jointErrCode;
    public String jointErrMsg;
    public byte[] jointPcmData;
    public int jointPcmDataLen;
    public int[] keywordLengthList;
    public int[] keywordStartPosList;
    public int starId;
    public VoiceSplitResult userSplitResult;
    public String voiceMd5;

    public VoiceJointResult(int i, String str) {
        this.jointErrCode = i;
        this.jointErrMsg = str;
    }

    public boolean isSuccess() {
        return this.jointPcmData != null && this.jointPcmData.length > 0 && this.jointPcmDataLen > 0;
    }
}
