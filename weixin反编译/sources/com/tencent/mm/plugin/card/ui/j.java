package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class j {
    public Bitmap iqd;
    public q iqe = null;
    public ImageView iqf;
    View iqg;
    OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == R.h.cDn || view.getId() == R.h.cDl) {
                if (j.this.iqe != null && j.this.iqe.isShowing()) {
                    j.this.iqe.dismiss();
                }
                if (!j.this.kOv.atR()) {
                    j.this.awO();
                }
            }
        }
    };
    MMActivity isO;
    b kOv;
    float kTA = 0.0f;
    public Bitmap kTs;
    boolean kWR = true;
    Bitmap laK = null;
    TextView laL;
    TextView laM;
    View laN;
    ImageView laO;
    MMVerticalTextView laP;
    MMVerticalTextView laQ;
    ArrayList<Bitmap> laR = new ArrayList();
    String laS = "";

    public j(MMActivity mMActivity) {
        this.isO = mMActivity;
    }

    private void af(float f) {
        LayoutParams attributes = this.isO.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.isO.getWindow().setAttributes(attributes);
    }

    public final void awN() {
        if (this.kTA < 0.8f) {
            af(0.8f);
        }
    }

    public final void awO() {
        af(this.kTA);
    }

    final void awP() {
        if (this.laR.size() > 2) {
            int size = this.laR.size() - 1;
            while (true) {
                int i = size;
                if (i > 1) {
                    l.u((Bitmap) this.laR.remove(i));
                    size = i - 1;
                } else {
                    return;
                }
            }
        }
    }
}
