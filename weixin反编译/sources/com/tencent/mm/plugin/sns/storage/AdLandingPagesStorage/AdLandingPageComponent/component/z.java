package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class z extends a {
    private Runnable hYX;
    TextView ioR;

    public z(Context context, u uVar, ViewGroup viewGroup) {
        super(context, uVar, viewGroup);
    }

    protected final int bkr() {
        return g.qMX;
    }

    public final void bxq() {
        super.bxq();
        if (!e.remove(this.hYX)) {
            e.Q(this.hYX);
        }
    }

    protected final void bxK() {
        if (((u) this.rpm).fqh != 1) {
            this.ioR.setText(((u) this.rpm).rnk);
        } else if (!bi.oN(((u) this.rpm).rnk)) {
            final String replace = ((u) this.rpm).rnk.replace("<icon", "<img");
            e.remove(this.hYX);
            this.hYX = new Runnable() {
                public final void run() {
                    final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter() {
                        public final Drawable getDrawable(String str) {
                            String ep = d.ep("adId", str);
                            if (bi.oN(ep) || !FileOp.bO(ep)) {
                                d.a("adId", str, false, 0, 0, new a() {
                                    public final void bxM() {
                                    }

                                    public final void bxN() {
                                    }

                                    public final void LD(String str) {
                                        try {
                                            final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter() {
                                                public final Drawable getDrawable(String str) {
                                                    String ep = d.ep("adId", str);
                                                    if (bi.oN(ep) || !FileOp.bO(ep)) {
                                                        return null;
                                                    }
                                                    Drawable createFromPath = Drawable.createFromPath(ep);
                                                    if (createFromPath != null) {
                                                        createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) ((u) z.this.rpm).gVS)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) ((u) z.this.rpm).gVS : createFromPath.getIntrinsicHeight());
                                                    }
                                                    return createFromPath;
                                                }
                                            }, null);
                                            ah.y(new Runnable() {
                                                public final void run() {
                                                    z.this.ioR.setText(fromHtml);
                                                }
                                            });
                                        } catch (Exception e) {
                                            x.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                                        }
                                    }
                                });
                                return null;
                            }
                            Drawable createFromPath = Drawable.createFromPath(ep);
                            if (createFromPath == null) {
                                return createFromPath;
                            }
                            int intrinsicWidth;
                            int i;
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) ((u) z.this.rpm).gVS)) / createFromPath.getIntrinsicHeight();
                            } else {
                                intrinsicWidth = createFromPath.getIntrinsicWidth();
                            }
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                i = (int) ((u) z.this.rpm).gVS;
                            } else {
                                i = createFromPath.getIntrinsicHeight();
                            }
                            createFromPath.setBounds(0, 0, intrinsicWidth, i);
                            return createFromPath;
                        }
                    }, null);
                    ah.y(new Runnable() {
                        public final void run() {
                            z.this.ioR.setText(fromHtml);
                        }
                    });
                }
            };
            e.post(this.hYX, "");
        }
        if (((u) this.rpm).textAlignment == 0) {
            this.ioR.setGravity(3);
        } else if (((u) this.rpm).textAlignment == 1) {
            this.ioR.setGravity(17);
        } else if (((u) this.rpm).textAlignment == 2) {
            this.ioR.setGravity(5);
        }
        if (((u) this.rpm).rnl == null || ((u) this.rpm).rnl.length() <= 0) {
            this.ioR.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.ioR.setTextColor(Color.parseColor(((u) this.rpm).rnl));
            } catch (Exception e) {
                x.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((u) this.rpm).rnl);
            }
        }
        if (((u) this.rpm).gVS > 0.0f) {
            this.ioR.setTextSize(0, ((u) this.rpm).gVS);
        }
        TextPaint paint = this.ioR.getPaint();
        if (((u) this.rpm).rnm) {
            paint.setFakeBoldText(true);
        }
        if (((u) this.rpm).rnn) {
            paint.setTextSkewX(-0.25f);
        }
        if (((u) this.rpm).rno) {
            paint.setUnderlineText(true);
        }
        if (((u) this.rpm).maxLines > 0) {
            this.ioR.setMaxLines(((u) this.rpm).maxLines);
        }
        if (((u) this.rpm).rnp == u.rnj) {
            this.ioR.setTypeface(ac.dy(this.context));
        }
    }

    @TargetApi(17)
    public final View bxG() {
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(f.qJD).setBackgroundColor(this.backgroundColor);
        view.findViewById(f.qJE).setBackgroundColor(this.backgroundColor);
        this.ioR = (TextView) view.findViewById(f.qJE);
        return view;
    }

    public final void bxr() {
        super.bxr();
    }

    public final void bxs() {
        super.bxs();
    }
}
