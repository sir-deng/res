package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

final class c extends h implements a {
    private ViewGroup jKO;
    private List<h> jVu;
    private final a jVv;

    private class a {
        final int jVA;
        final int jVB;
        final int jVw;
        final int jVx;
        private final int jVy;
        final int jVz;

        /* synthetic */ a(c cVar, Context context, byte b) {
            this(context);
        }

        private a(Context context) {
            this.jVw = com.tencent.mm.plugin.appbrand.r.c.c(context, 0.7f);
            this.jVx = (int) (((float) com.tencent.mm.bu.a.eB(context)) / 18.0f);
            this.jVy = 0;
            this.jVz = com.tencent.mm.plugin.appbrand.r.c.c(context, 3.85f);
            this.jVA = com.tencent.mm.bu.a.c(context, d.iuU);
            this.jVB = 2;
        }
    }

    c(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            throw new IllegalStateException("Unexpected parameters");
        }
        this.jVv = new a(this, activity, (byte) 0);
        ViewGroup linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        this.jKO = linearLayout;
        linearLayout = this.jKO;
        List arrayList = new ArrayList(2);
        h eVar = new e(activity, linearLayout);
        eVar.jWy = this;
        arrayList.add(eVar);
        eVar = new f(activity, linearLayout);
        eVar.jWy = this;
        arrayList.add(eVar);
        this.jVu = arrayList;
        a(this.jVu, this.jKO);
        af(this.jVu);
    }

    private void a(List<h> list, ViewGroup viewGroup) {
        if (list != null && list.size() != 0 && viewGroup != null) {
            View view;
            for (int i = 0; i < list.size(); i++) {
                viewGroup.addView(((h) list.get(i)).amc());
                if (i != list.size() - 1) {
                    view = new View(viewGroup.getContext());
                    view.setBackgroundColor(-1);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jVv.jVx, this.jVv.jVw);
                    layoutParams.gravity = 3;
                    viewGroup.addView(view, layoutParams);
                }
            }
            Context context = viewGroup.getContext();
            Drawable colorDrawable = new ColorDrawable(this.jVv.jVA);
            view = new ImageView(context);
            view.setImageDrawable(colorDrawable);
            view.setBackgroundColor(-1);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.jVv.jVB);
            viewGroup.addView(view, 0, layoutParams2);
            View imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, layoutParams2);
            viewGroup.addView(new View(context), -1, this.jVv.jVz);
            imageView = new ImageView(context);
            imageView.setImageDrawable(colorDrawable);
            imageView.setBackgroundColor(-1);
            viewGroup.addView(imageView, -1, this.jVv.jVB);
        }
    }

    private static void af(List<h> list) {
        if (list != null) {
            for (h dn : list) {
                dn.dn(false);
            }
        }
    }

    final void amb() {
        for (h amb : this.jVu) {
            amb.amb();
        }
    }

    final void onDetached() {
        for (h onDetached : this.jVu) {
            onDetached.onDetached();
        }
    }

    final void onResume() {
        for (h onResume : this.jVu) {
            onResume.onResume();
        }
    }

    final View amc() {
        return this.jKO;
    }

    public final void a(h hVar, View view, boolean z) {
        if (this.jKO != null) {
            h hVar2;
            View childAt;
            int i;
            x.i("AppBrandLauncherRecentsListHeaderController", "onViewEnabledChanged [%s] [%s] [%b]", hVar, view, Boolean.valueOf(z));
            if (!(this.jKO == null || this.jVu == null)) {
                for (int i2 = 0; i2 < this.jVu.size() - 1; i2++) {
                    hVar2 = (h) this.jVu.get(i2);
                    if (hVar2 != null) {
                        if (hVar2.amg()) {
                            int i3 = i2 + 1;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= this.jVu.size()) {
                                    i3 = 0;
                                    break;
                                }
                                h hVar3 = (h) this.jVu.get(i4);
                                if (hVar3 != null && hVar3.amg()) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = i4 + 1;
                            }
                            if (i3 != 0) {
                                childAt = this.jKO.getChildAt(this.jKO.indexOfChild(hVar2.amc()) + 1);
                                if (childAt != null) {
                                    childAt.setVisibility(0);
                                }
                            }
                        } else {
                            childAt = this.jKO.getChildAt(this.jKO.indexOfChild(hVar2.amc()) + 1);
                            if (childAt != null) {
                                childAt.setVisibility(8);
                            }
                        }
                    }
                }
            }
            for (h hVar22 : this.jVu) {
                childAt = hVar22.amc();
                if (childAt != null && childAt.getVisibility() == 0) {
                    x.i("AppBrandLauncherRecentsListHeaderController", "hasValidHeader %s", hVar);
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i != 0) {
                this.jKO.setVisibility(0);
            } else {
                this.jKO.setVisibility(8);
            }
        }
    }
}
