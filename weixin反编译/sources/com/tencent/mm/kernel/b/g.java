package com.tencent.mm.kernel.b;

import android.app.Application;
import com.tencent.mm.kernel.a.a;

public abstract class g {
    public String gQd;
    public a gRM = new a();
    public Application gUt;
    private Boolean gUu;

    public abstract String getPackageName();

    public g(String str, Application application) {
        this.gQd = str;
        this.gUt = application;
    }

    public String toString() {
        return this.gQd != null ? this.gQd : super.toString();
    }

    public final boolean DZ() {
        if (this.gUu == null) {
            this.gUu = Boolean.valueOf(fT(""));
        }
        return this.gUu.booleanValue();
    }

    public final boolean fT(String str) {
        return this.gQd != null && this.gQd.equals(getPackageName() + str);
    }
}
