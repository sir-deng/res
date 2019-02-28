package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    public LinkedList<d> mAZ = new LinkedList();
    a mBa = null;
    public OnClickListener mBb = new OnClickListener() {
        public final void onClick(final View view) {
            if (((Integer) view.getTag()).intValue() == 0) {
                FavTagPanel.this.a((TextView) view, true, false);
                if (FavTagPanel.this.mBa != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            FavTagPanel.this.mBa;
                            ((TextView) view).getText().toString();
                        }
                    });
                    return;
                }
                return;
            }
            FavTagPanel.this.a((TextView) view, false, false);
            if (FavTagPanel.this.mBa != null) {
                view.post(new Runnable() {
                    public final void run() {
                        FavTagPanel.this.mBa.AX(((TextView) view).getText().toString());
                    }
                });
            }
        }
    };

    public interface a extends com.tencent.mm.ui.base.MMTagPanel.a {
        void AW(String str);

        void AX(String str);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void aKi() {
        if (this.wml.size() <= 0 && !this.mAZ.isEmpty()) {
            String str = ((d) this.mAZ.getLast()).ymH;
            AY(str);
            if (this.mBa != null) {
                this.mBa.AW(str);
            }
            cqx();
        }
    }

    public final void AY(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.FavTagPanel", "want to remove type, but it is null or empty");
            return;
        }
        Iterator it = this.mAZ.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.ymH)) {
                this.mAZ.remove(dVar);
                removeView(dVar.ymI);
                a(dVar);
                cqx();
                return;
            }
        }
        x.w("MicroMsg.FavTagPanel", "want to remove type %s, but it not exsited!", str);
    }
}
