package com.tencent.mm.audio.voicejoint.model;

public class DenoiseResult {
    public byte[] denoiseResult;
    public int length;

    public boolean isSuccess() {
        return this.denoiseResult != null && this.denoiseResult.length == this.length;
    }
}
