package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import java.util.ArrayList;
import java.util.List;

public class WWMediaMergedConvs extends WWMediaObject {
    public List<WWMediaConversation> AyP = new ArrayList();

    public final boolean checkArgs() {
        if (!super.checkArgs() || this.AyP == null || this.AyP.size() == 0) {
            return false;
        }
        boolean z;
        for (BaseMessage checkArgs : this.AyP) {
            if (!checkArgs.checkArgs()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final void toBundle(Bundle bundle) {
        bundle.putInt("_wwmergedconvobject_messageslen", this.AyP.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.AyP.size()) {
                bundle.putBundle("_wwmergedconvobject_messages" + i2, BaseMessage.b((BaseMessage) this.AyP.get(i2)));
                i = i2 + 1;
            } else {
                super.toBundle(bundle);
                return;
            }
        }
    }
}
