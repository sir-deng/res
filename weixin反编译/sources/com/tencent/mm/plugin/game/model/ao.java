package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;

public final class ao implements e {
    ArrayList<a> njI;
    private boolean njJ = false;

    public static class a {
        public int hSi;
        public String njK;

        public a(int i, String str) {
            this.hSi = i;
            this.njK = str;
        }

        public static a g(int i, Object... objArr) {
            a aVar = new a();
            aVar.hSi = i;
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            aVar.njK = stringBuilder.toString();
            if (m.fxD > 0) {
                x.i("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
            } else {
                x.d("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
            }
            return aVar;
        }
    }

    public ao() {
        as.CN().a(427, (e) this);
        this.njI = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.njI.contains(aVar)) {
            this.njI.add(aVar);
        }
        aRB();
    }

    private void aRB() {
        while (!this.njJ) {
            if (this.njI == null || this.njI.size() == 0) {
                x.d("MicroMsg.AppReportService", "report queue is null, no need do scnene");
                return;
            }
            a aVar = (a) this.njI.remove(0);
            if (aVar != null) {
                this.njJ = true;
                as.CN().a(new al(aVar.hSi, aVar.njK), 0);
                return;
            }
        }
        x.i("MicroMsg.AppReportService", "is doing scene, wait for a minite");
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.njJ = false;
        aRB();
    }
}
