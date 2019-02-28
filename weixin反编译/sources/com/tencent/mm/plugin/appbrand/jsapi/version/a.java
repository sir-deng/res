package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.plugin.appbrand.jsapi.f;

public enum a {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String jvf;

    private static final class a extends f {
        private static final int CTRL_INDEX = -1;
        private static final String NAME = "onUpdateStatusChange";

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private a(String str) {
        this.jvf = str;
    }

    public static a ti(String str) {
        for (a aVar : values()) {
            if (aVar.jvf.equals(str)) {
                return aVar;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid name %s", new Object[]{str}));
    }

    public final String toString() {
        return this.jvf;
    }
}
