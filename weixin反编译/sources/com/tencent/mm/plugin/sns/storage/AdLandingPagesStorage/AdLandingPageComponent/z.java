package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;

public final class z implements Serializable {
    public float height;
    public String iconUrl;
    public float rmQ;
    public float width;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (zVar.iconUrl.equals(this.iconUrl) && zVar.width == this.width && zVar.height == this.height && zVar.rmQ == this.rmQ) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
