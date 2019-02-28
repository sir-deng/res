package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.e;
import com.tencent.mm.af.y;
import com.tencent.mm.bl.d;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class BizContactEntranceView extends RelativeLayout {
    private View lyX = null;
    private Context mContext;
    View zab;
    private TextView zac;
    private boolean zad = true;
    private boolean zae;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
        cwB();
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
        cwB();
    }

    public BizContactEntranceView(Context context) {
        super(context);
        this.mContext = context;
        init();
        cwB();
    }

    private void init() {
        this.zae = false;
        View.inflate(getContext(), R.i.dbu, this);
        this.lyX = findViewById(R.h.bYH);
        this.zab = this.lyX.findViewById(R.h.bNQ);
        LayoutParams layoutParams = this.zab.getLayoutParams();
        layoutParams.height = (int) (((float) a.ab(getContext(), R.f.buB)) * a.ey(getContext()));
        this.zab.setLayoutParams(layoutParams);
        this.lyX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("intent_service_type", 251658241);
                d.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
            }
        });
        this.zab.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (BizContactEntranceView.this.mContext instanceof MMActivity) {
                    ((MMActivity) BizContactEntranceView.this.mContext).aWY();
                }
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.zab.findViewById(R.h.bNP);
        ImageView imageView = (ImageView) maskLayout.view;
        n.JF();
        imageView.setImageBitmap(com.tencent.mm.ac.d.ji("service_officialaccounts"));
        this.zac = (TextView) maskLayout.findViewById(R.h.cSe);
    }

    final void cwB() {
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        if (c.Ff().cje() > 0) {
            this.zad = true;
        } else {
            this.zad = false;
        }
        this.zab.setVisibility(this.zad ? 0 : 8);
        if (this.zad) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    long j = 0;
                    e Ml = y.Ml();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select updateTime from BizInfo").append(" where type = 1");
                    stringBuilder.append(" and status = 1").append(" ORDER BY updateTime DESC");
                    x.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
                    Cursor rawQuery = Ml.rawQuery(r1, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            j = rawQuery.getLong(0);
                            rawQuery.close();
                        } else {
                            rawQuery.close();
                        }
                    }
                    as.Hm();
                    final long ca = bi.ca(c.Db().get(233473, null));
                    x.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(ca));
                    ah.y(new Runnable() {
                        public final void run() {
                            TextView c = BizContactEntranceView.this.zac;
                            int i = (!BizContactEntranceView.this.zae || j <= ca) ? 4 : 0;
                            c.setVisibility(i);
                        }
                    });
                }
            });
        }
        x.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(r4), Boolean.valueOf(this.zad), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setVisible(boolean z) {
        int i = 0;
        x.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(true), Boolean.valueOf(this.zad));
        View view = this.lyX;
        if (!this.zad) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
