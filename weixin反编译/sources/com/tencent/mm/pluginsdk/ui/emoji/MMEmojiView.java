package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mm.bu.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;

public class MMEmojiView extends MMAnimateView {
    private EmojiInfo lHc;
    private int mScreenWidth;
    int vzj;
    private int vzk;
    boolean vzl;
    public boolean vzm;

    public MMEmojiView(Context context) {
        this(context, null);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
        init(context);
    }

    public MMEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vzl = false;
        this.vzm = false;
        init(context);
    }

    private void init(Context context) {
        this.vzj = context.getResources().getDimensionPixelSize(c.ltv);
        this.vzk = context.getResources().getDimensionPixelSize(c.lOI);
        this.mScreenWidth = a.eB(context);
    }

    public final void a(EmojiInfo emojiInfo, String str) {
        this.lHc = emojiInfo;
        String clq = emojiInfo.clq();
        if ((emojiInfo.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
            cX(clq, str);
        } else if (b.aSR().CU(str) != null) {
            setImageDrawable(b.aSR().CU(str));
        } else {
            a(this.lHc, ((PluginEmoji) g.k(PluginEmoji.class)).getProvider().a(this.lHc), str);
        }
    }

    public final void a(EmojiInfo emojiInfo, byte[] bArr, String str) {
        this.lHc = emojiInfo;
        try {
            if (!bi.by(bArr)) {
                Drawable fVar;
                if (bi.oN(str)) {
                    if (p.bs(bArr) && ((PluginEmoji) g.k(PluginEmoji.class)).getProvider().aBM()) {
                        fVar = new f(bArr);
                        this.vzm = true;
                    } else {
                        x.v("MicroMsg.emoji.MMEmojiView", "set with gif");
                        fVar = new com.tencent.mm.plugin.gif.c(bArr);
                    }
                    if (!fVar.isRunning()) {
                        fVar.reset();
                    }
                } else {
                    this.lzu = str;
                    fVar = b.aSR().o(this.lzu, bArr);
                }
                setImageDrawable(fVar);
                return;
            }
        } catch (MMGIFException e) {
            MMAnimateView.a(e);
            if (e.getErrorCode() == 103) {
                x.d("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray D_GIF_ERR_NOT_GIF_FILE");
                Bitmap bn = d.bn(bArr);
                if (bn != null) {
                    bn.setDensity(320);
                    setImageBitmap(bn);
                    return;
                }
                x.w("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                if (this.lHc != null) {
                    this.lHc.cli();
                    x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
                }
                init();
                return;
            }
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e.toString());
            if (this.lHc != null) {
                this.lHc.cli();
                x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
            }
        } catch (IOException e2) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e2.toString());
        } catch (NullPointerException e3) {
            x.e("MicroMsg.emoji.MMEmojiView", "setMMGIFFileByteArray failed. %s", e3.toString());
        }
        if (this.lHc != null) {
            this.lHc.cli();
            x.i("MicroMsg.emoji.MMEmojiView", "delete file.");
        }
        init();
    }

    protected void onMeasure(int i, int i2) {
        float f;
        int i3 = 0;
        super.onMeasure(i, i2);
        int intrinsicWidth = getDrawable() == null ? 0 : getDrawable().getIntrinsicWidth();
        if (getDrawable() != null) {
            i3 = getDrawable().getIntrinsicHeight();
        }
        if (this.lHc != null && intrinsicWidth == 0 && r1 == 0) {
            intrinsicWidth = (int) (((float) this.lHc.field_width) * aSS());
            i3 = (int) (((float) this.lHc.field_height) * aSS());
        }
        if (i3 < this.vzk || intrinsicWidth < this.vzk) {
            if (intrinsicWidth < i3) {
                f = ((float) this.vzk) / ((float) intrinsicWidth);
                intrinsicWidth = this.vzk;
                i3 = (int) (((float) i3) * f);
            } else if (i3 < intrinsicWidth) {
                f = ((float) this.vzk) / ((float) i3);
                i3 = this.vzk;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                i3 = this.vzk;
                intrinsicWidth = this.vzk;
            }
        }
        if (this.vzl) {
            if (intrinsicWidth > this.vzj || i3 > this.vzj) {
                if (intrinsicWidth > i3) {
                    f = ((float) this.vzj) / ((float) intrinsicWidth);
                    intrinsicWidth = this.vzj;
                    i3 = (int) (((float) i3) * f);
                } else if (i3 > intrinsicWidth) {
                    f = ((float) this.vzj) / ((float) i3);
                    i3 = this.vzj;
                    intrinsicWidth = (int) (((float) intrinsicWidth) * f);
                } else {
                    intrinsicWidth = this.vzj;
                    i3 = this.vzj;
                }
            }
        } else if (intrinsicWidth > this.mScreenWidth || i3 > this.mScreenWidth) {
            if (intrinsicWidth > i3) {
                f = ((float) this.mScreenWidth) / ((float) intrinsicWidth);
                intrinsicWidth = this.mScreenWidth;
                i3 = (int) (((float) i3) * f);
            } else if (i3 > intrinsicWidth) {
                f = ((float) this.mScreenWidth) / ((float) i3);
                i3 = this.mScreenWidth;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            } else {
                intrinsicWidth = this.mScreenWidth;
                i3 = this.mScreenWidth;
            }
        }
        setMeasuredDimension(intrinsicWidth, i3);
    }
}
