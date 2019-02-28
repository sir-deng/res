package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aj {
    String mgB = "";
    int position = 0;
    long rCB = 0;
    String rCC = "";
    int rCD = 0;
    long rdk = 0;

    public final boolean bAK() {
        x.i("MicroMsg.ResumeSnsControl", "resume time %d", Long.valueOf(bi.bB(this.rCB)));
        x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", Long.valueOf(this.rCB), this.mgB, this.rCC, Long.valueOf(this.rdk), Integer.valueOf(this.position), Integer.valueOf(this.rCD));
        if (bi.bB(this.rCB) >= 180000 || this.position <= 0) {
            return false;
        }
        x.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", Long.valueOf(this.rdk));
        if (this.rdk == 0) {
            return false;
        }
        ae.bvV().y(this.rdk, -1);
        return true;
    }
}
