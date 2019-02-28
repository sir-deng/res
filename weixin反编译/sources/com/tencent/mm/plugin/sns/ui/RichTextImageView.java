package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class RichTextImageView extends LinearLayout {
    private Activity fBA;
    private TextView ikn;
    private ImageView ork;
    private TextView rCE;
    private boolean rCF = false;
    private String rCG;
    private TextView ryo;

    public RichTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBA = (Activity) context;
        View inflate = inflate(this.fBA, g.qNO, this);
        this.ryo = (TextView) inflate.findViewById(f.qJm);
        this.ikn = (TextView) inflate.findViewById(f.qLQ);
        this.rCE = (TextView) inflate.findViewById(f.qHA);
        this.ork = (ImageView) inflate.findViewById(f.qIs);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.rCF && this.rCG != null) {
            x.d("MicroMsg.RichTextImageView", "onLayout  Heighth:" + this.ryo.getHeight() + " LineHeight:" + this.ryo.getLineHeight());
            int height = this.ryo.getHeight() / this.ryo.getLineHeight();
            int lineCount = this.ryo.getLineCount();
            Rect rect = new Rect();
            int i5 = 0;
            int i6 = 0;
            while (i5 < height) {
                try {
                    this.ryo.getLineBounds(i5, rect);
                    i6 += rect.height();
                    if (i6 > this.ryo.getHeight()) {
                        break;
                    }
                    i5++;
                } catch (IndexOutOfBoundsException e) {
                }
            }
            if (lineCount >= i5 && this.rCF) {
                if (i5 <= 0) {
                    i5 = 1;
                }
                i5 = this.ryo.getLayout().getLineVisibleEnd(i5 - 1);
                x.e("test", "bottomH:" + this.rCE.getHeight() + "length" + this.rCG.substring(i5, this.rCG.length()).length());
                x.e("test", "bottomH:" + this.rCE.getHeight());
                if (this.rCE.getText().length() > 0) {
                    this.rCE.setVisibility(0);
                    this.rCF = false;
                    new ag().post(new Runnable() {
                        public final void run() {
                            RichTextImageView.this.ryo.setText(RichTextImageView.this.rCG.substring(0, i5));
                            RichTextImageView.this.rCE.setText(RichTextImageView.this.rCG.substring(i5, RichTextImageView.this.rCG.length()));
                            RichTextImageView.this.rCE.invalidate();
                            RichTextImageView.this.rCF = false;
                            x.e("test", "bottomH:" + RichTextImageView.this.rCE.getHeight());
                        }
                    });
                }
                x.e("test", "bottom:" + i4 + "   mesH:" + this.rCE.getMeasuredHeight());
            }
        }
    }
}
