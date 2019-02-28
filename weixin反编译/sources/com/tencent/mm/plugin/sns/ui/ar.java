package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ar {
    public static int[] rJT = new int[]{0, 0, 1, 3, 6, 9};
    public static int[] rJU = new int[]{f.qGW};
    public static int[] rJV = new int[]{f.qGW, f.qGX, f.qGY};
    public static int[] rJW = new int[]{f.qGW, f.qGX, f.qGY, f.qGZ, f.qHa, f.qHb};
    public static int[] rJX = new int[]{f.qGW, f.qGX, f.qGY, f.qGZ, f.qHa, f.qHb, f.qHc, f.qHd, f.qHe};
    static double rJY = -1.0d;
    static double rJZ = -1.0d;
    static double rKa = -1.0d;
    static double rKb = -1.0d;
    static double rKc = -1.0d;
    private Context context;
    private LinkedList<LinearLayout> rKd = new LinkedList();

    public ar(Context context) {
        this.context = context;
    }

    public ar(Context context, byte b) {
        this.context = context;
    }

    public final void a(PhotosContent photosContent, bpb bpb, String str, int i, int i2, int i3, boolean z, an anVar, boolean z2) {
        int[] iArr = rJX;
        if (i2 == 2 || i2 == 11) {
            iArr = rJU;
        } else if (i2 == 3) {
            iArr = rJV;
        } else if (i2 == 4) {
            iArr = rJW;
        } else if (i2 == 5) {
            iArr = rJX;
        }
        List list = bpb.wYj.wfh;
        if (rJY < 0.0d) {
            rJY = (double) b.b(this.context, 160.0f);
            rJZ = (double) b.b(this.context, 200.0f);
            rKa = (double) b.b(this.context, 44.0f);
            rKb = (double) b.b(this.context, 66.0f);
            rKc = (double) b.b(this.context, 300.0f);
        }
        int size = list.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.bwc().cu(photosContent.xQ(size));
                photosContent.xQ(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View xQ = photosContent.xQ(size);
                xQ.setVisibility(8);
                ae.bwc().cu(xQ);
                photosContent.xQ(size).position = i3;
            }
            photosContent.xQ(0).setVisibility(0);
            a((are) list.get(0), photosContent.xQ(0), str, i, i3, z, anVar, i2, z2);
        }
    }

    public final void a(PhotosContent photosContent, bpb bpb, String str, int i, int i2, int i3, boolean z, an anVar, List<arg> list) {
        int[] iArr = rJX;
        if (i2 == 2 || i2 == 11) {
            iArr = rJU;
        } else if (i2 == 3) {
            iArr = rJV;
        } else if (i2 == 4) {
            iArr = rJW;
        } else if (i2 == 5) {
            iArr = rJX;
        }
        List list2 = bpb.wYj.wfh;
        if (rJY < 0.0d) {
            rJY = (double) b.b(this.context, 160.0f);
            rJZ = (double) b.b(this.context, 200.0f);
            rKa = (double) b.b(this.context, 44.0f);
            rKb = (double) b.b(this.context, 66.0f);
            rKc = (double) b.b(this.context, 300.0f);
        }
        int size = list2.size();
        if (size == 0) {
            for (size = 0; size < iArr.length; size++) {
                ae.bwc().cu(photosContent.xQ(size));
                photosContent.xQ(size).position = i3;
            }
            photosContent.setVisibility(8);
            return;
        }
        photosContent.xP(ae.bwn());
        photosContent.setVisibility(0);
        if (size == 1) {
            for (size = 1; size < iArr.length; size++) {
                View xQ = photosContent.xQ(size);
                xQ.setVisibility(8);
                ae.bwc().cu(xQ);
                photosContent.xQ(size).position = i3;
            }
            photosContent.xQ(0).setVisibility(0);
            if (list == null || list.size() <= 0) {
                a((are) list2.get(0), photosContent.xQ(0), str, i, i3, z, anVar, i2, false);
                return;
            }
            a((are) list2.get(0), photosContent.xQ(0), str, i, i3, z, anVar, i2, false, (arg) list.get(0));
        } else if (size == 4) {
            List arrayList = new ArrayList();
            int length = iArr.length - 1;
            int i4 = 3;
            while (length >= 0) {
                View xQ2 = photosContent.xQ(length);
                xQ2.position = i3;
                if (length == 0 || length == 1 || length == 3 || length == 4) {
                    xQ2.setVisibility(0);
                    arrayList.add(xQ2);
                    ap apVar = new ap();
                    apVar.fvn = str;
                    size = i4 - 1;
                    apVar.index = i4;
                    apVar.rHV = arrayList;
                    apVar.rFe = z;
                    apVar.position = i3;
                    xQ2.setTag(apVar);
                    a((are) list2.get(apVar.index), xQ2, i, anVar);
                    i4 = size;
                } else {
                    xQ2.setVisibility(8);
                    ae.bwc().cu(xQ2);
                }
                length--;
            }
        } else {
            List arrayList2 = new ArrayList();
            for (size = iArr.length - 1; size >= 0; size--) {
                View xQ3 = photosContent.xQ(size);
                xQ3.position = i3;
                if (size < list2.size()) {
                    xQ3.setVisibility(0);
                    arrayList2.add(xQ3);
                    ap apVar2 = new ap();
                    apVar2.fvn = str;
                    apVar2.index = size;
                    apVar2.rHV = arrayList2;
                    apVar2.rFe = z;
                    apVar2.position = i3;
                    xQ3.setTag(apVar2);
                    a((are) list2.get(apVar2.index), xQ3, i, anVar);
                } else {
                    xQ3.setVisibility(8);
                    ae.bwc().cu(xQ3);
                }
            }
        }
    }

    private static void a(are are, QFadeImageView qFadeImageView, int i, an anVar) {
        ae.bwc().b(are, qFadeImageView, i, anVar);
    }

    private static void a(are are, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2, arg arg) {
        if (qFadeImageView == null) {
            x.e("MicroMsg.SnsMultiLineImageLineMgr", "");
            return;
        }
        double min;
        ap apVar = new ap();
        apVar.fvn = str;
        apVar.index = 0;
        List arrayList = new ArrayList();
        arrayList.add(qFadeImageView);
        apVar.rHV = arrayList;
        apVar.rFe = z;
        apVar.position = i2;
        qFadeImageView.setTag(apVar);
        double d = 0.0d;
        double d2 = 0.0d;
        if (i3 == 11 && z2) {
            ae.bwc().c(are, qFadeImageView, i, anVar);
        } else {
            ae.bwc().a(are, (View) qFadeImageView, i, anVar);
        }
        if (are.wES != null) {
            d = (double) are.wES.wFF;
            d2 = (double) are.wES.wFG;
        }
        if (d <= 0.0d || d2 <= 0.0d) {
            d = rJY;
            d2 = rJY;
        } else {
            min = Math.min(rJZ / d, rJZ / d2);
            d *= min;
            d2 *= min;
            if (d < rKa) {
                min = (1.0d * rKa) / d;
                d *= min;
                d2 *= min;
            }
            if (d2 < rKa) {
                min = (1.0d * rKa) / d2;
                d *= min;
                d2 *= min;
            }
            if (d > rJZ) {
                d = rJZ;
            }
            if (d2 > rJZ) {
                d2 = rJZ;
            }
        }
        if (d < 1.0d) {
            d = 1.0d;
        }
        if (d2 < 1.0d) {
            d2 = 1.0d;
        }
        if (arg == null || arg.wFF <= 0.0f || arg.wFG <= 0.0f) {
            min = d;
            d = d2;
        } else {
            min = (double) arg.wFF;
            d = (double) arg.wFG;
        }
        if (qFadeImageView.getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) qFadeImageView.getLayoutParams();
            if (((double) layoutParams.width) != min || ((double) layoutParams.height) != d) {
                qFadeImageView.setLayoutParams(new LayoutParams((int) min, (int) d));
            }
        }
    }

    private static void a(are are, QFadeImageView qFadeImageView, String str, int i, int i2, boolean z, an anVar, int i3, boolean z2) {
        a(are, qFadeImageView, str, i, i2, z, anVar, i3, z2, new arg());
    }
}
