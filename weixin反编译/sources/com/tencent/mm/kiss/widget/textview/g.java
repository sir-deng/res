package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.R;

public final class g {
    protected f gVB;
    public a gVC;
    protected StaticLayout gVD;
    protected boolean gVE = false;
    int gVF;
    int gVG;
    private boolean gVH = false;
    boolean gVI = false;
    private boolean gVJ = false;
    private boolean gVK = false;
    View gVL;
    private int gVM = 0;
    private int gVN = 0;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.gVL = view;
        this.gVC = aVar;
    }

    public final void init() {
        this.text = "";
        this.gVL.setWillNotDraw(false);
    }

    public final void setSingleLine(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.gVC.maxLines != i) {
            this.gVC.maxLines = i;
            this.gVE = true;
            Eq();
            this.gVL.requestLayout();
            this.gVL.invalidate();
        }
    }

    public final void setLines(int i) {
        if (this.gVC.maxLines != i || this.gVC.minLines != i) {
            this.gVE = true;
            Eq();
            this.gVC.maxLines = i;
            this.gVC.minLines = i;
            this.gVL.requestLayout();
            this.gVL.invalidate();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = ad.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != 0.0f && this.gVC != null && applyDimension != this.gVC.gVS) {
            this.gVC.gVS = applyDimension;
            this.gVE = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
    }

    public final void b(f fVar) {
        if (fVar == null || fVar.gVz == null) {
            this.gVB = null;
            return;
        }
        if (this.gVC == null) {
            b bVar = new b();
            bVar.gVC = new a();
            bVar.gVC.maxLines = fVar.maxLines;
            bVar.gVC.maxLength = fVar.maxLength;
            bVar.gVC.gVy = fVar.gVy;
            bVar.gVC.gVn = fVar.gVn;
            bVar.gVC.gVo = fVar.gVo;
            bVar.gVC.gravity = fVar.gravity;
            bVar.gVC.gVS = fVar.gVy.getTextSize();
            bVar.gVC.textColor = fVar.gVy.getColor();
            this.gVC = bVar.gVC;
        }
        Eq();
        this.gVL.setWillNotDraw(false);
        this.gVB = fVar;
        this.gVD = fVar.gVz;
        this.text = fVar.text;
        this.gVH = this.text instanceof Spannable;
        if (this.gVH) {
            this.text = this.gVB.text;
            com.tencent.mm.kiss.widget.textview.b.b.Et();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        this.gVL.requestLayout();
        this.gVL.invalidate();
    }

    public final void setTextColor(int i) {
        if (this.gVC != null && i != this.gVC.textColor) {
            this.gVC.textColor = i;
            this.gVE = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
    }

    public final void setGravity(int i) {
        if (this.gVC != null && i != this.gVC.gravity) {
            this.gVC.gravity = i;
            this.gVE = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
    }

    public final void setMaxLines(int i) {
        if (this.gVC != null && i != this.gVC.maxLines) {
            this.gVC.maxLines = i;
            this.gVE = true;
            Eq();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.gVL.requestLayout();
            this.gVL.invalidate();
        }
    }

    public final int getLineHeight() {
        TextPaint paint = this.gVB.gVz.getPaint();
        if (paint == null) {
            paint = this.gVC.gVy;
        }
        return Math.round((((float) paint.getFontMetricsInt(null)) * this.gVC.gVs) + this.gVC.gVr);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            if (this.text == null || !this.text.equals(charSequence) || z) {
                this.text = charSequence;
                this.gVE = true;
                this.gVL.requestLayout();
                this.gVL.invalidate();
                if (h.DEBUG) {
                    x.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + new aj().toString());
                }
            }
        }
    }

    final void Eq() {
        this.gVN = 0;
        this.gVM = 0;
        this.gVF = 0;
        this.gVG = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        if (this.gVB != null) {
            return this.gVB.gVy.getTextSize();
        }
        if (this.gVC != null) {
            return this.gVC.gVS;
        }
        return 0.0f;
    }

    public final Layout Eo() {
        return this.gVD;
    }

    public final f Ep() {
        return this.gVB;
    }

    public final int getLineCount() {
        if (this.gVD == null) {
            return 0;
        }
        return this.gVD.getLineCount();
    }

    public final boolean v(MotionEvent motionEvent) {
        int i = -1;
        boolean z = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (!this.gVL.isEnabled() || !this.gVH) {
            return false;
        }
        com.tencent.mm.kiss.widget.textview.b.b.Et();
        boolean a = com.tencent.mm.kiss.widget.textview.b.b.a(this.gVL, this.gVD, (Spannable) this.text, motionEvent);
        this.gVK = a;
        if (this.gVJ && z) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z2 = (x < ((float) this.gVF) || x > ((float) (this.gVD.getWidth() + this.gVF))) ? false : y >= ((float) this.gVG) && y <= ((float) (this.gVD.getHeight() + this.gVG));
            if (z2) {
                Spannable spannable = (Spannable) this.text;
                int selectionStart = this.text == null ? -1 : Selection.getSelectionStart(this.text);
                if (this.text != null) {
                    i = Selection.getSelectionEnd(this.text);
                }
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(selectionStart, i, ClickableSpan.class);
                if (clickableSpanArr.length > 0) {
                    x.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                    clickableSpanArr[0].onClick(this.gVL);
                    return true;
                }
            }
        }
        return a;
    }

    public final boolean performClick() {
        if (this.gVK || !this.gVI) {
            return false;
        }
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.gVD == null || this.gVB == null) {
            boolean gF = gF(this.gVL.getMeasuredWidth());
            if (h.DEBUG) {
                x.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.gVD, this.gVB, Boolean.valueOf(gF));
            }
            if (gF) {
                this.gVL.requestLayout();
                this.gVL.invalidate();
                return;
            }
            return;
        }
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.gVL.getPaddingLeft(), this.gVL.getPaddingTop(), (this.gVL.getRight() - this.gVL.getLeft()) - this.gVL.getPaddingRight(), (this.gVL.getBottom() - this.gVL.getTop()) - this.gVL.getPaddingBottom());
        if (this.gVF == 0 || this.gVG == 0) {
            int paddingLeft = this.gVL.getPaddingLeft();
            int right = ((this.gVL.getRight() - this.gVL.getLeft()) - this.gVL.getPaddingLeft()) - this.gVL.getPaddingRight();
            int width = this.gVD.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.gVB.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.gVF = right;
            paddingLeft = this.gVL.getPaddingTop();
            width = ((this.gVL.getBottom() - this.gVL.getTop()) - this.gVL.getPaddingTop()) - this.gVL.getPaddingBottom();
            right = 0;
            int height = this.gVD.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.gVB.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        right = 0;
                        break;
                    case 80:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.gVG = right;
        }
        canvas.translate((float) this.gVF, (float) this.gVG);
        this.gVD.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            x.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    private boolean gF(int i) {
        if (this.gVE || this.gVB == null || this.gVD == null) {
            if (this.gVC == null) {
                return false;
            }
            if (i > 0) {
                Eq();
                long j = 0;
                if (h.DEBUG) {
                    j = System.nanoTime();
                }
                this.gVB = d.a(this.text, i, this.gVC).Ej();
                this.gVD = this.gVB.gVz;
                this.gVE = false;
                if (h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    x.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                return true;
            }
        }
        return false;
    }

    public final Point aU(int i, int i2) {
        Point point;
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        gF(size);
        if (this.gVD != null) {
            int i3;
            int i4;
            if (mode != 1073741824) {
                i3 = 0;
                if (this.gVC.gVo == null) {
                    Layout layout = this.gVD;
                    if (this.gVM != 0) {
                        i3 = this.gVM;
                    } else {
                        int lineCount = layout.getLineCount();
                        CharSequence text = layout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(layout.getLineEnd(i4) - 1) != 10) {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, layout.getLineWidth(i4));
                        }
                        this.gVM = (int) Math.ceil((double) f);
                        this.gVM += this.gVL.getPaddingLeft() + this.gVL.getPaddingRight();
                        i3 = this.gVM;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.gVD.getText(), this.gVD.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (h.DEBUG) {
                    x.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == 1073741824) {
                i3 = size2;
            } else {
                Layout layout2 = this.gVD;
                if (this.gVN != 0) {
                    i3 = this.gVN;
                } else {
                    i3 = layout2.getLineCount();
                    if (this.gVB.maxLines > 0 && this.gVB.maxLines < i3) {
                        i3 = this.gVB.maxLines;
                    }
                    mode = this.gVL.getPaddingTop() + this.gVL.getPaddingBottom();
                    i4 = layout2.getLineTop(i3);
                    if (this.gVC.minLines <= 0 || i3 >= this.gVC.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.gVC.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.gVN = i3 + mode;
                    i3 = this.gVN;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            x.d(str, str2, objArr);
        }
        return point;
    }
}
