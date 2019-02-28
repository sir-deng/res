package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import java.util.Stack;

public final class f implements c {
    public String gQA;
    public a iNT;
    public a iNU;
    public Stack<a> iNV;
    public Stack<a> iNW;
    public Paint iNX = new Paint();
    public Paint iNY;
    public g iNZ;
    private c iOa;

    public f(c cVar) {
        this.iOa = cVar;
        this.iNT = new a();
        this.iNU = new a();
        this.iNT.setStyle(Style.STROKE);
        this.iNU.setStyle(Style.FILL);
        this.iNT.setAntiAlias(true);
        this.iNU.setAntiAlias(true);
        this.iNT.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.q.f.ma(1));
        this.iNU.setStrokeWidth((float) com.tencent.mm.plugin.appbrand.q.f.ma(1));
        this.iNV = new Stack();
        this.iNW = new Stack();
        this.iNX.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    public final void invalidate() {
        this.iOa.invalidate();
    }
}
