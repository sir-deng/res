package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.Iterator;

public class LargeTouchableAreasItemView extends LinearLayout {
    private static final int lgG = Color.argb(0, 0, 0, 0);
    private final Paint fC = new Paint();
    private boolean gPt;
    private final ArrayList<b> lgH = new ArrayList();
    private c lgI;
    a lgJ;
    private int lgK;
    private int lgL = -1;
    private int lgM = -1;
    private ImageButton lgN;

    public interface a {
        void eo(boolean z);
    }

    private static class b {
        public int color;
        public Rect rect;

        public b(Rect rect, int i) {
            this.rect = rect;
            this.color = i;
        }
    }

    public LargeTouchableAreasItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setDescendantFocusability(393216);
        this.lgI = new c(this);
        this.fC.setStyle(Style.FILL);
        this.lgK = (int) ((context.getResources().getDisplayMetrics().density * 66.0f) + 0.5f);
        LayoutInflater.from(context).inflate(R.i.dey, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lgN = (ImageButton) findViewById(R.h.bPh);
        this.lgN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LargeTouchableAreasItemView.this.en(!LargeTouchableAreasItemView.this.gPt);
                if (LargeTouchableAreasItemView.this.lgJ != null) {
                    LargeTouchableAreasItemView.this.lgJ.eo(LargeTouchableAreasItemView.this.gPt);
                }
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != this.lgL || i6 != this.lgM) {
            this.lgL = i5;
            this.lgM = i6;
            c cVar = this.lgI;
            if (cVar.lkD != null) {
                cVar.lkD.clear();
            }
            cVar.lkE = null;
            Rect rect = new Rect((i5 - this.lgN.getWidth()) - this.lgK, 0, i5, i6);
            i5 = lgG;
            View view = this.lgN;
            c cVar2 = this.lgI;
            TouchDelegate touchDelegate = new TouchDelegate(rect, view);
            if (cVar2.lkD == null) {
                cVar2.lkD = new ArrayList();
            }
            cVar2.lkD.add(touchDelegate);
            this.lgH.add(new b(rect, i5));
            setTouchDelegate(this.lgI);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Iterator it = this.lgH.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.fC.setColor(bVar.color);
            canvas.drawRect(bVar.rect, this.fC);
        }
        super.dispatchDraw(canvas);
    }

    public final void en(boolean z) {
        if (this.gPt != z) {
            this.gPt = z;
            this.lgN.setImageResource(this.gPt ? R.k.dxZ : R.k.dya);
        }
    }
}
