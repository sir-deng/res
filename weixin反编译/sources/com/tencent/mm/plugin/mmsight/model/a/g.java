package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class g extends h {
    private int ozQ = -1;

    public g(int i, int i2) {
        super(i, i2);
    }

    public final int ax(int i, String str) {
        this.ozQ = i;
        return super.ax(i, str);
    }

    protected final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.ozQ >= 0 && byteBuffer != null && bufferInfo != null && !this.oAf) {
            SightVideoJNI.writeAACData(this.ozQ, byteBuffer, bufferInfo.size);
        }
    }

    protected final boolean bbp() {
        return true;
    }
}
