package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaConversation extends WWMediaObject {
    public byte[] AyM;
    public WWMediaObject AyN;
    public long date;
    public String muD;
    public String name;

    public final boolean checkArgs() {
        if (!super.checkArgs()) {
            return false;
        }
        if (this.AyM != null && this.AyM.length > 10485760) {
            return false;
        }
        if (this.muD != null && this.muD.length() > 10240) {
            return false;
        }
        if ((this.muD == null || WWMediaObject.getFileSize(this.muD) <= 10485760) && this.AyN != null && this.AyN.checkArgs()) {
            return true;
        }
        return false;
    }

    public final void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wwconvobject_name", this.name);
        bundle.putLong("_wwconvobject_date", this.date);
        bundle.putByteArray("_wwconvobject_avatarData", this.AyM);
        bundle.putString("_wwconvobject_avatarPath", this.muD);
        bundle.putBundle("_wwconvobject_message", BaseMessage.b(this.AyN));
    }
}
