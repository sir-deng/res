package com.tencent.mm.pluginsdk.model.app;

final class r {
    public String appId;
    public int hPf;

    public r(String str, int i) {
        this.appId = str;
        this.hPf = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (rVar.appId.equals(this.appId) && rVar.hPf == this.hPf) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.appId + this.hPf;
    }
}
