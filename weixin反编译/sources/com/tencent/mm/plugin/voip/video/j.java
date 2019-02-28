package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;

public final class j {
    public ArrayList<a> kCL = new ArrayList();
    public boolean sBc = false;
    public int sBd = 0;
    public int sBe;
    public int sBf;
    public v2protocal ssL = new v2protocal(new ag(Looper.myLooper()));

    public interface a {
        void a(int[] iArr, boolean z, int i);
    }

    private class b {
        public int sBg;
        public int sBh;
        public int sBi;
        public int sBj;

        public final String toString() {
            return String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[]{Integer.valueOf(this.sBg), Integer.valueOf(this.sBh), Integer.valueOf(this.sBi), Integer.valueOf(this.sBj)});
        }
    }
}
