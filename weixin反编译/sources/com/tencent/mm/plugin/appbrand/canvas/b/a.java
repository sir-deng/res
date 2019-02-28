package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.mm.plugin.appbrand.q.j;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    public int iOg = a.iOk;
    private float iOh = (((float) getAlpha()) / 255.0f);
    private String iOi;
    private int iOj;
    private int su = getColor();

    public enum a {
        ;

        static {
            iOk = 1;
            iOl = 2;
            iOm = 3;
            iOn = 4;
            iOo = new int[]{iOk, iOl, iOm, iOn};
        }
    }

    protected final Object clone() {
        return super.clone();
    }

    public final a abE() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a = j.a(Shader.class, "copy", shader, new Class[0], new Object[0], null);
            if (a != null && (a instanceof Shader)) {
                shader = (Shader) a;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.iOg = this.iOg;
        return aVar;
    }

    public final void S(float f) {
        this.iOh = f;
        setColor(this.su);
    }

    public final void setColor(int i) {
        this.su = i;
        super.setColor(((((int) (((float) Color.alpha(i)) * this.iOh)) & 255) << 24) | (16777215 & i));
    }

    public final void reset() {
        this.iOg = a.iOk;
        super.reset();
    }

    public final void qB(String str) {
        this.iOi = str;
        setTypeface(Typeface.create(str, this.iOj));
    }

    public final void jK(int i) {
        this.iOj = i;
        setTypeface(Typeface.create(this.iOi, i));
    }
}
