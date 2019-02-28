package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.OutputStream;

public final class ar extends l<g, String, Boolean> {
    private String fileName;
    private OutputStream hnp = null;
    private String hnq;
    private String mediaId;
    private String qZT;
    private String qZX = "";

    public final /* synthetic */ Object bvz() {
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void n(Object[] objArr) {
        g[] gVarArr = (g[]) objArr;
        super.n(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.mediaId = gVar.mediaId;
            this.qZT = am.r(ae.getAccSnsPath(), this.mediaId);
            this.qZX = i.aK(gVar.requestType, this.mediaId);
            this.hnq = "sns_tmpt_" + this.mediaId;
            this.fileName = "snst_" + this.mediaId;
        }
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        ae.bwa().KB(this.qZX);
    }

    public final ag bvy() {
        return ae.bvR();
    }
}
