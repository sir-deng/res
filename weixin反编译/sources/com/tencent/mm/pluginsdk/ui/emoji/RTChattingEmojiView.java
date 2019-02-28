package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;

public class RTChattingEmojiView extends FrameLayout {
    private EmojiInfo lHc;
    private int mStatus = -1;
    private TextView snL;
    private LayoutParams vzA;
    LayoutParams vzB;
    private int vzt;
    private int vzu;
    private int vzv;
    private int vzw;
    private int vzx;
    public ChattingEmojiView vzy;
    private ProgressBar vzz;

    public RTChattingEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RTChattingEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        this.vzt = getContext().getResources().getDimensionPixelSize(c.ltv);
        this.vzu = getContext().getResources().getDimensionPixelSize(c.lOH);
        this.vzw = getContext().getResources().getDimensionPixelSize(c.lOK);
        this.vzx = getContext().getResources().getDimensionPixelSize(c.lOJ);
        this.vzy = new ChattingEmojiView(getContext());
        this.vzz = new ProgressBar(getContext());
        this.vzz.setIndeterminateDrawable(getResources().getDrawable(d.bEP));
        this.snL = new TextView(getContext());
        this.snL.setText(h.lPy);
        this.snL.setTextColor(getResources().getColor(b.lOD));
        this.vzA = new LayoutParams(-2, -2);
        this.vzB = new LayoutParams(-2, -2);
        this.vzA.gravity = 17;
        addView(this.vzz, this.vzA);
        addView(this.snL, this.vzA);
    }

    public final void a(EmojiInfo emojiInfo, long j) {
        a(emojiInfo, j, new aj(""));
    }

    public final void a(EmojiInfo emojiInfo, long j, aj ajVar) {
        x.d("MicroMsg.emoji.RTChattingEmojiView", "setEmojiInfo");
        this.lHc = emojiInfo;
        if (this.lHc.YI()) {
            CN(2);
            MMAnimateView mMAnimateView = this.vzy;
            boolean z = !ajVar.hXo;
            int e = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().e(emojiInfo);
            int[] f = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().f(emojiInfo);
            String name = emojiInfo.getName();
            String valueOf = String.valueOf(j + emojiInfo.getName());
            Drawable dVar;
            if (bi.oN(valueOf)) {
                dVar = new com.tencent.mm.plugin.gif.d(mMAnimateView.getContext(), false, z, e, f, name);
                dVar.start();
                mMAnimateView.setImageDrawable(dVar);
                return;
            }
            mMAnimateView.lzu = valueOf;
            com.tencent.mm.plugin.gif.b aSR = com.tencent.mm.plugin.gif.b.aSR();
            Context context = mMAnimateView.getContext();
            if (TextUtils.isEmpty(name)) {
                dVar = null;
            } else {
                if (aSR.nEg.get(valueOf) == null || ((WeakReference) aSR.nEg.get(valueOf)).get() == null) {
                    dVar = null;
                } else {
                    dVar = (com.tencent.mm.plugin.gif.d) ((WeakReference) aSR.nEg.get(valueOf)).get();
                }
                if (dVar == null) {
                    dVar = new com.tencent.mm.plugin.gif.d(context, false, z, e, f, name);
                    aSR.nEg.put(valueOf, new WeakReference(dVar));
                }
            }
            if (z == dVar.mIsPlaying) {
                dVar.start();
            } else {
                dVar.lNI = 0;
                dVar.nEV = 0;
                dVar.mIsPlaying = true;
                dVar.start();
            }
            mMAnimateView.setImageDrawable(dVar);
        } else if (this.lHc.clk()) {
            CN(2);
            this.vzy.a(EmojiInfo.bk(getContext(), emojiInfo.getName()), String.valueOf(j));
        } else {
            String clq = this.lHc.clq();
            if (e.bN(clq) > 0) {
                CN(2);
                byte[] d = e.d(clq, 0, 10);
                if (d == null || p.br(d)) {
                    this.vzy.cX(clq, String.valueOf(j));
                    return;
                } else {
                    this.vzy.a(this.lHc, ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().a(this.lHc), String.valueOf(j));
                    return;
                }
            }
            if (emojiInfo.field_state == EmojiInfo.xIX) {
                CN(0);
                ccU();
            } else {
                CN(3);
                ccU();
            }
            this.vzy.setImageBitmap(null);
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        CN(2);
        if (this.vzy != null && bitmap != null && !bitmap.isRecycled()) {
            bitmap.setDensity(320);
            this.vzy.setImageBitmap(bitmap);
        }
    }

    public boolean performClick() {
        if (this.mStatus == 3) {
            CN(1);
            ccU();
            return true;
        } else if (this.mStatus == 2) {
            return super.performClick();
        } else {
            x.d("MicroMsg.emoji.RTChattingEmojiView", "do nothing when loading");
            return true;
        }
    }

    private void ccU() {
        com.tencent.mm.sdk.b.b coVar = new co();
        coVar.frG.frH = this.lHc;
        coVar.frG.scene = 0;
        a.xmy.m(coVar);
    }

    private void CN(int i) {
        this.mStatus = i;
        switch (i) {
            case 0:
                this.vzz.setVisibility(0);
                this.snL.setVisibility(4);
                this.vzy.setVisibility(4);
                setBackgroundResource(d.bHc);
                return;
            case 1:
                this.vzz.setVisibility(0);
                this.snL.setVisibility(4);
                this.vzy.setVisibility(4);
                setBackgroundResource(d.lOO);
                return;
            case 2:
                this.vzy.setVisibility(0);
                this.vzz.setVisibility(4);
                this.snL.setVisibility(4);
                setBackgroundResource(d.bHc);
                return;
            case 3:
                Drawable drawable = getResources().getDrawable(d.lOR);
                drawable.setBounds(0, 0, this.vzv, this.vzv);
                x.d("MicroMsg.emoji.RTChattingEmojiView", "iconSize:%d hashcode:%d", Integer.valueOf(this.vzv), Integer.valueOf(hashCode()));
                this.snL.setCompoundDrawables(null, drawable, null, null);
                this.snL.setText(h.lPy);
                this.snL.setVisibility(0);
                this.vzz.setVisibility(4);
                this.vzy.setVisibility(4);
                setBackgroundResource(d.lOO);
                return;
            default:
                return;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mStatus == 0 || this.mStatus == 1 || this.mStatus == 3) {
            int i3;
            if (this.lHc == null || this.lHc.field_height == 0) {
                i3 = this.vzu;
            } else {
                i3 = (int) (((float) this.lHc.field_height) * this.vzy.aSS());
                if (i3 < this.vzu) {
                    i3 = this.vzu;
                }
            }
            if (i3 > this.vzt) {
                i3 = this.vzt;
            }
            this.vzv = this.vzw;
            if (i3 >= this.vzu && i3 < this.vzu + (this.vzw - this.vzx)) {
                this.vzv = this.vzx + (i3 - this.vzu);
            }
            int i4 = this.vzt;
            setMeasuredDimension(i4, i3);
            super.onMeasure(MeasureSpec.makeMeasureSpec(i4, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
            CN(this.mStatus);
            return;
        }
        super.onMeasure(i, i2);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
