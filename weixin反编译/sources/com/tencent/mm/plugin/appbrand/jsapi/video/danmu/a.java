package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public final class a implements d {
    private static int jxa;
    private static int jxb;
    private int Mg;
    private int Mq;
    private StaticLayout gVz;
    private SpannableString jxc;
    private int jxd;
    private int jxe;
    private int jxf = -1;
    private int jxg;
    private int jxh;
    private float jxi;
    private Context mContext;
    private int yg = -1;

    public a(Context context, SpannableString spannableString, int i, int i2) {
        this.mContext = context;
        this.jxc = spannableString;
        this.jxg = b.x(this.mContext, b.jxj);
        this.yg = i;
        this.jxi = 3.0f;
        this.jxh = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.yg);
        textPaint.setTextSize((float) this.jxg);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.Mq = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.gVz = new StaticLayout(this.jxc, textPaint, ((int) Layout.getDesiredWidth(this.jxc, 0, this.jxc.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.Mg = this.gVz.getWidth();
    }

    public final void b(Canvas canvas, boolean z) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == jxa && height == jxb)) {
            jxa = width;
            jxb = height;
        }
        canvas.save();
        canvas.translate((float) this.jxd, (float) this.jxe);
        this.gVz.draw(canvas);
        canvas.restore();
        if (!z) {
            this.jxd = (int) (((float) this.jxd) - (((float) b.ahH()) * this.jxi));
        }
    }

    public final void bJ(int i, int i2) {
        this.jxd = i;
        this.jxe = i2;
    }

    public final float ahE() {
        return this.jxi;
    }

    public final boolean ahF() {
        return this.jxd < 0 && Math.abs(this.jxd) > this.Mg;
    }

    public final int getWidth() {
        return this.Mg;
    }

    public final int getCurrX() {
        return this.jxd;
    }

    public final int ahG() {
        return this.jxh;
    }

    public final boolean kM(int i) {
        if (i >= this.jxh && i - this.jxh <= b.jxk) {
            return true;
        }
        return false;
    }

    public final boolean kN(int i) {
        return i - this.jxh > b.jxk;
    }

    public final boolean a(d dVar) {
        if (dVar.getWidth() + dVar.getCurrX() > jxa) {
            return true;
        }
        if (this.jxf < 0) {
            this.jxf = b.x(this.mContext, 20);
        }
        if (dVar.ahE() >= this.jxi) {
            if (dVar.ahE() != this.jxi || ((float) (jxa - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.jxf)) {
                return false;
            }
            return true;
        } else if (((double) (((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.ahE() * ((float) b.ahH()))) * this.jxi) * ((float) b.ahH()))) <= ((double) jxa) - (((double) this.jxf) * 1.5d)) {
            return false;
        } else {
            return true;
        }
    }
}
