package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public interface b {
    void Ni(String str);

    void a(CaptureView captureView);

    void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void aP(int i, String str);

    void aVo();

    void b(int i, int i2, int[] iArr);

    void bHJ();

    Context bIK();

    void bIL();

    void dU(int i, int i2);

    void ff(long j);

    void setMute(boolean z);

    void uninit();

    void zc(int i);
}
