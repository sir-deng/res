package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class a {
    public Typeface boj = null;
    public int gVQ = -1;
    public int gVR = -1;
    public float gVS = -1.0f;
    public Alignment gVn = Alignment.ALIGN_NORMAL;
    public TruncateAt gVo = null;
    public TextDirectionHeuristic gVq = null;
    public float gVr = 0.0f;
    public float gVs = 1.0f;
    public boolean gVt = false;
    public TextPaint gVy = null;
    public int gravity = 51;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.gVy}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.gVn}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.gVo}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.gVQ)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.gVq}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.gVr), Float.valueOf(this.gVs)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.gVt)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.boj}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.gVR)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.gVS)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.gVy != null) {
            i += this.gVy.hashCode() * 31;
        }
        i += this.gVn.hashCode() * 31;
        if (this.gVo != null) {
            i += this.gVo.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.gVQ * 31);
        if (this.gVq != null) {
            i += this.gVq.hashCode() * 31;
        }
        i = ((this.gVt ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.gVr * 31.0f)))) + (this.gVs * 31.0f)));
        if (this.boj != null) {
            i += this.boj.hashCode() * 31;
        }
        return (((int) (((float) (i + (this.gVR * 31))) + (this.gVS * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
    }
}
