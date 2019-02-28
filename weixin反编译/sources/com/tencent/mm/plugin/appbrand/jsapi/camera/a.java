package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a {
    boolean jln;
    boolean jlo;
    HashMap<Integer, AppBrandCameraView> jlp;

    private static class a {
        private static a jlq = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.jln = true;
        this.jlo = true;
        this.jlp = new HashMap();
    }

    public final boolean g(Integer num) {
        if (!this.jlp.containsKey(num)) {
            return false;
        }
        ((AppBrandCameraView) this.jlp.remove(num)).release();
        return true;
    }

    public final boolean ago() {
        if (!this.jln) {
            x.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        return this.jln;
    }
}
