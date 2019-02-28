package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    private int rFU = 103;

    public final void d(c cVar) {
        cVar.rUc.setImageResource(e.qFn);
        cVar.rTI.setTextColor(-2730427);
        if (cVar.rTR != null) {
            cVar.rTR.setLayoutResource(g.qNt);
            if (!cVar.rTS) {
                cVar.rUj = (PhotosContent) cVar.rTR.inflate();
                cVar.rTS = true;
            }
        } else {
            cVar.rUj = (PhotosContent) cVar.nav.findViewById(f.qIp);
            cVar.rTS = true;
        }
        x.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.kZv);
        TagImageView tagImageView = (TagImageView) cVar.rUj.findViewById(ar.rJX[0]);
        cVar.rUj.a(tagImageView);
        tagImageView.setOnClickListener(this.rfY.rfs.rzz);
    }

    public final void a(c cVar, int i, ay ayVar, bpb bpb, int i2, av avVar) {
        String str = ayVar.ryG;
        if (cVar.rUU != null) {
            if (!ayVar.rQd || cVar.qUf.wVf == null || cVar.qUf.wVf.wVH <= 0) {
                cVar.rUU.setBackgroundResource(e.qFd);
            } else {
                cVar.rUU.setBackgroundResource(e.qFe);
            }
        }
        TagImageView xQ = cVar.rUj.xQ(0);
        List arrayList = new ArrayList();
        arrayList.add(xQ);
        ap apVar = new ap();
        apVar.fvn = str;
        apVar.index = 0;
        apVar.rHV = arrayList;
        apVar.rFe = this.rFe;
        if (xQ != null) {
            xQ.setTag(apVar);
        }
        arf arf = ayVar.rQD;
        cVar.ruX = arf;
        ar arVar;
        PhotosContent photosContent;
        String str2;
        int hashCode;
        boolean z;
        an cjD;
        if (arf == null) {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + ayVar.ryG);
        } else if (q.FY().equals(bpb.kyG)) {
            cVar.rUj.setVisibility(0);
            arVar = avVar.rFJ;
            photosContent = cVar.rUj;
            str2 = ayVar.ryG;
            hashCode = this.mActivity.hashCode();
            z = this.rFe;
            cjD = an.cjD();
            cjD.time = bpb.pgR;
            arVar.a(photosContent, bpb, str2, hashCode, i2, i, z, cjD, true);
        } else if (ayVar.rQg) {
            cVar.rUj.setVisibility(0);
            arVar = avVar.rFJ;
            photosContent = cVar.rUj;
            str2 = ayVar.ryG;
            hashCode = this.mActivity.hashCode();
            z = this.rFe;
            cjD = an.cjD();
            cjD.time = bpb.pgR;
            arVar.a(photosContent, bpb, str2, hashCode, i2, i, z, cjD, false);
        } else if (arf.fMy == 0) {
            cVar.rUj.setVisibility(0);
            arVar = avVar.rFJ;
            photosContent = cVar.rUj;
            str2 = ayVar.ryG;
            hashCode = this.mActivity.hashCode();
            z = this.rFe;
            cjD = an.cjD();
            cjD.time = bpb.pgR;
            arVar.a(photosContent, bpb, str2, hashCode, i2, i, z, cjD, true);
        } else {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + arf.fMy);
        }
    }
}
