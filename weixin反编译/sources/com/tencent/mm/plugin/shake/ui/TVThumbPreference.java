package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    f jPY;
    private ImageView qyK;
    private ImageView qyL;
    private ImageView qyM;
    List<String> qyN;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qyN = null;
        setLayoutResource(R.i.dtx);
        setWidgetLayoutResource(0);
        j.a((a) this);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.qyK = (ImageView) view.findViewById(R.h.cRm);
        this.qyL = (ImageView) view.findViewById(R.h.cRn);
        this.qyM = (ImageView) view.findViewById(R.h.cRo);
        if (this.qyN != null && this.qyN.size() > 0) {
            i bVar = new b((String) this.qyN.get(0));
            this.qyK.setTag(bVar.Wq());
            Bitmap a = j.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.qyK.setImageBitmap(a);
            }
            this.qyK.setVisibility(0);
            if (1 < this.qyN.size()) {
                bVar = new b((String) this.qyN.get(1));
                this.qyL.setTag(bVar.Wq());
                a = j.a(bVar);
                if (!(a == null || a.isRecycled())) {
                    this.qyL.setImageBitmap(a);
                }
                this.qyL.setVisibility(0);
                if (2 < this.qyN.size()) {
                    bVar = new b((String) this.qyN.get(2));
                    this.qyM.setTag(bVar.Wq());
                    a = j.a(bVar);
                    if (!(a == null || a.isRecycled())) {
                        this.qyM.setImageBitmap(a);
                    }
                    this.qyM.setVisibility(0);
                }
            }
        }
    }

    public final void l(String str, final Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.qyK != null && this.qyK.getTag() != null && str.equals((String) this.qyK.getTag())) {
                this.qyK.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.qyK.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.jPY != null) {
                            TVThumbPreference.this.jPY.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.qyL != null && this.qyL.getTag() != null && str.equals((String) this.qyL.getTag())) {
                this.qyL.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.qyL.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.jPY != null) {
                            TVThumbPreference.this.jPY.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.qyM != null && this.qyM.getTag() != null && str.equals((String) this.qyM.getTag())) {
                this.qyM.post(new Runnable() {
                    public final void run() {
                        TVThumbPreference.this.qyM.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.jPY != null) {
                            TVThumbPreference.this.jPY.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }
}
