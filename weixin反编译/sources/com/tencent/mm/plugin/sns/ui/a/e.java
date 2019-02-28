package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    private int rFT;
    private int rFU = 103;
    MaskImageView rVa;

    public static class a extends c {
    }

    public final void d(c cVar) {
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        x.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.kZv);
        this.rFT = ae.bwn();
        if (cVar.rTR != null) {
            if (this.kZv == 2) {
                cVar.rTR.setLayoutResource(g.qOe);
            } else if (this.kZv == 3) {
                cVar.rTR.setLayoutResource(g.qOb);
            } else if (this.kZv == 4) {
                cVar.rTR.setLayoutResource(g.qOc);
            } else if (this.kZv == 5) {
                cVar.rTR.setLayoutResource(g.qOd);
            } else {
                x.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.kZv);
            }
            if (!cVar.rTS) {
                cVar.rUj = (PhotosContent) cVar.rTR.inflate();
                cVar.rTS = true;
            }
        } else {
            cVar.rUj = (PhotosContent) cVar.nav.findViewById(f.qJa);
            cVar.rTS = true;
        }
        cVar.rUj.rBE.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ar.rJT[this.kZv]) {
                TagImageView tagImageView = (TagImageView) cVar.rUj.findViewById(ar.rJX[i2]);
                cVar.rUj.a(tagImageView);
                tagImageView.setOnClickListener(this.rfY.rfs.rzz);
                this.rfY.kMf.c(tagImageView, this.rfY.rfs.rVG, this.rfY.rfs.rVs);
                i = i2 + 1;
            } else {
                cVar.rUj.xP(this.rFT);
                return;
            }
        }
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bpb bpb, int i2, av avVar) {
        cVar.rUj.setVisibility(0);
        String str = bpb.wYi == null ? null : bpb.wYi.nMq;
        if (!bi.oN(str)) {
            boolean booleanValue;
            if (avVar.rNE.containsKey(str)) {
                booleanValue = ((Boolean) avVar.rNE.get(str)).booleanValue();
            } else {
                avVar.rNE.put(str, Boolean.valueOf(com.tencent.mm.plugin.sns.c.a.ihO.cA(str)));
                booleanValue = true;
            }
            if (booleanValue) {
                com.tencent.mm.plugin.sns.c.a.ihO.a(this.mActivity, str, bpb.kyG, bpb.wYn, ayVar.rPN);
            }
        }
        List linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (ayVar.rxi && i2 == 2) {
            final b byB = ayVar.qEj.byB();
            if (byB != null && byB.rll == 1 && cVar.rUj.xQ(0) != null) {
                are are;
                if (bpb.wYj == null || bpb.wYj.wfh.size() <= 0) {
                    are = null;
                } else {
                    are = (are) bpb.wYj.wfh.get(0);
                }
                width = (((width - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 28);
                int i3 = (int) ((are.wES.wFG * ((float) width)) / are.wES.wFF);
                arg arg = new arg();
                arg.wFF = (float) width;
                arg.wFG = (float) i3;
                arg.wFH = arg.wFF * arg.wFG;
                linkedList.add(arg);
                i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= ar.rJT[i2]) {
                        break;
                    }
                    avVar.kMf.c((TagImageView) cVar.rUj.findViewById(ar.rJX[i4]), avVar.rfs.rVJ, avVar.rfs.rVs);
                    i3 = i4 + 1;
                }
            } else if (byB != null && byB.rlb > 0.0f && byB.rlc > 0.0f) {
                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlb, 1, byB.rld, byB.rle);
                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlc, 1, byB.rld, byB.rle);
                int i5;
                arg arg2;
                if (byB.rla == 0) {
                    arg arg3 = new arg();
                    arg3.wFF = a;
                    arg3.wFG = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)))) {
                        arg3.wFF = (float) (((width - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12));
                        arg3.wFG = (float) ((int) ((arg3.wFF * byB.rlc) / byB.rlb));
                    }
                    arg3.wFH = arg3.wFF * arg3.wFG;
                    linkedList.add(arg3);
                } else if (byB.rla == 1) {
                    width = (((width - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12);
                    i5 = (int) ((((float) width) * byB.rlc) / byB.rlb);
                    arg2 = new arg();
                    if (width > 0) {
                        a = (float) width;
                    }
                    arg2.wFF = a;
                    if (i5 > 0) {
                        a = (float) i5;
                    } else {
                        a = a2;
                    }
                    arg2.wFG = a;
                    arg2.wFH = arg2.wFF * arg2.wFG;
                    linkedList.add(arg2);
                } else if (byB.rla == 2) {
                    width = ((width - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bu.a.fromDPToPix(this.mActivity, 12);
                    i5 = (int) ((((float) width) * byB.rlc) / byB.rlb);
                    arg2 = new arg();
                    if (width > 0) {
                        a = (float) width;
                    }
                    arg2.wFF = a;
                    if (i5 > 0) {
                        a2 = (float) i5;
                    }
                    arg2.wFG = a2;
                    arg2.wFH = arg2.wFF * arg2.wFG;
                    linkedList.add(arg2);
                }
            }
            if (!bi.oN(byB.rlg)) {
                final PhotosContent photosContent = cVar.rUj;
                final TagImageView xQ = cVar.rUj.xQ(0);
                d.a("adId", byB.rlg, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                    }

                    public final void LD(String str) {
                        e.this.rVa = (MaskImageView) photosContent.findViewById(f.qIW);
                        if (e.this.rVa != null) {
                            e.this.rVa.setVisibility(0);
                            e.this.rVa.setImageBitmap(BitmapFactory.decodeFile(str));
                            float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlh, 1, byB.rld, byB.rle);
                            float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rli, 1, byB.rld, byB.rle);
                            float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlj, 1, byB.rld, byB.rle);
                            float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlk, 1, byB.rld, byB.rle);
                            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                            layoutParams.setMargins((int) ((((float) xQ.getRight()) - a3) - a), (int) ((((float) xQ.getBottom()) - a4) - a2), 0, 0);
                            e.this.rVa.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
        ar arVar = avVar.rFJ;
        PhotosContent photosContent2 = cVar.rUj;
        str = ayVar.ryG;
        int hashCode = this.mActivity.hashCode();
        boolean z = this.rFe;
        an cjD = an.cjD();
        cjD.time = bpb.pgR;
        arVar.a(photosContent2, bpb, str, hashCode, i2, i, z, cjD, linkedList);
        cVar.rUY.setTag(cVar.rUj.xQ(0));
        cVar.rUZ.setTag(cVar.rUj.xQ(0));
    }
}
