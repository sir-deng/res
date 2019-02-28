package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.au.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.e;
import com.tencent.mm.y.as;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b extends e implements com.tencent.mm.plugin.music.model.d.a {
    int count;
    ag oPb = new ag(Looper.getMainLooper());
    boolean oRt;
    final int oSP = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 26);
    final int oSQ = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), GameJsApiLaunchApplication.CTRL_BYTE);
    HashMap<Integer, View> oSR = new HashMap();
    d oSS = new d();
    int oST;
    int scene;

    public class a {
        com.tencent.mm.au.a fBv;
        private int mode = 1;
        MusicItemLayout oSW;
        View oSX;
        View oSY;
        View oSZ;
        CdnImageView oTa;
        TextView oTb;
        TextView oTc;
        LyricView oTd;
        boolean oTe;
        private AnimationListener oTf = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.oTe = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$1 */
        class AnonymousClass1 extends ShaderFactory {
            final /* synthetic */ int oTg;

            AnonymousClass1(int i) {
                this.oTg = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, this.oTg}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        public class a extends Animation {
            final int mBg;
            final int oTj;
            View view;

            public a(View view, int i) {
                this.view = view;
                this.mBg = i;
                this.oTj = view.getHeight();
            }

            protected final void applyTransformation(float f, Transformation transformation) {
                this.view.getLayoutParams().height = (int) (((float) this.oTj) + (((float) (this.mBg - this.oTj)) * f));
                this.view.requestLayout();
            }

            public final void initialize(int i, int i2, int i3, int i4) {
                super.initialize(i, i2, i3, i4);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }

        /* renamed from: com.tencent.mm.plugin.music.ui.b$a$2 */
        class AnonymousClass2 extends ShaderFactory {
            final /* synthetic */ int oTi;

            AnonymousClass2(int i) {
                this.oTi = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{this.oTi, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        public final void h(com.tencent.mm.au.a aVar, boolean z) {
            if (aVar != null) {
                x.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", aVar.field_songName);
                this.fBv = aVar;
                if (bi.oN(aVar.field_songHAlbumUrl)) {
                    com.tencent.mm.plugin.music.model.e bef = h.bef();
                    boolean z2 = b.this.oRt;
                    if (aVar != null) {
                        if (bef.oPl != null) {
                            as.CN().c(bef.oPl);
                            bef.oPl = null;
                        }
                        if (aVar.field_songId <= 0) {
                            x.e("MicroMsg.Music.MusicPlayerManager", "can't get songId ");
                            g.pWK.k(10911, "1");
                        } else {
                            bef.oPl = new com.tencent.mm.plugin.music.model.e.b(aVar, z2);
                            as.CN().a(bef.oPl, 0);
                        }
                    }
                }
                this.oSW.setTag(this);
                if ((!com.tencent.mm.plugin.music.model.g.d(aVar) || b.this.scene == 3) && !bi.oN(aVar.field_songSinger)) {
                    this.oTc.setText(aVar.field_songSinger);
                    this.oTc.setVisibility(0);
                } else {
                    this.oTc.setVisibility(8);
                }
                this.oTb.setText(aVar.field_songName);
                this.oTb.setTag(aVar.field_songName);
                LyricView lyricView = this.oTd;
                com.tencent.mm.plugin.music.model.h.a beg = h.beg();
                lyricView.oSy = beg.oSx.get(aVar.field_musicId) != null ? (com.tencent.mm.plugin.music.model.a) beg.oSx.get(aVar.field_musicId) : beg.g(aVar, b.this.oRt);
                lyricView.invalidate();
                if (!com.tencent.mm.plugin.music.model.g.d(aVar) || b.this.oRt) {
                    this.oTd.dR(1);
                }
                bfo();
                d dVar = b.this.oSS;
                ImageView imageView = this.oTa;
                Context context = b.this.context;
                boolean z3 = b.this.oRt;
                if (z) {
                    dVar.gBc.remove(aVar.field_musicId);
                }
                Bitmap bitmap = (Bitmap) dVar.gBc.get(aVar.field_musicId);
                int[] o;
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                    x.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath);
                    imageView.setTag(aVar);
                    com.tencent.mm.ap.a.a.c.a aVar2;
                    if (aVar.Qt()) {
                        aVar2 = new com.tencent.mm.ap.a.a.c.a();
                        aVar2.hFn = com.tencent.mm.plugin.music.model.g.c(aVar, true);
                        aVar2.hFl = true;
                        aVar2.hFj = true;
                        aVar2.hFA = R.g.bBE;
                        if (z3) {
                            aVar2.hFv = true;
                            aVar2.hFw = 10;
                        }
                        o.PG().a(aVar.field_songHAlbumUrl, imageView, aVar2.PQ(), dVar.oPa);
                    } else {
                        switch (aVar.field_musicType) {
                            case 0:
                            case 5:
                            case 7:
                            case 10:
                            case 11:
                                break;
                            case 1:
                            case 8:
                            case 9:
                                are are = new are();
                                are.nMq = aVar.field_songMediaId;
                                are.wEP = aVar.field_songAlbumUrl;
                                are.wEQ = aVar.field_songAlbumType;
                                are.nlE = are.wEP;
                                if (n.qWB != null) {
                                    bitmap = n.qWB.b(are);
                                    if (bitmap == null) {
                                        imageView.setImageResource(R.g.bBE);
                                        if (!(aVar.Qs() || dVar.oOZ == null)) {
                                            dVar.oOZ.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                                        }
                                        n.qWB.cu(imageView);
                                        n.qWB.a(are, imageView, context.hashCode(), an.xHx);
                                        dVar.oPb.removeCallbacksAndMessages(null);
                                        dVar.oPb.postDelayed(new b(aVar), 1000);
                                        break;
                                    }
                                    bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                                    break;
                                }
                                break;
                            case 4:
                                aVar2 = new com.tencent.mm.ap.a.a.c.a();
                                aVar2.hFn = com.tencent.mm.plugin.music.model.g.c(aVar, false);
                                aVar2.hFl = true;
                                aVar2.hFj = true;
                                if (z3) {
                                    aVar2.hFv = true;
                                    aVar2.hFw = 10;
                                }
                                o.PG().a(aVar.field_songAlbumUrl, imageView, aVar2.PQ(), dVar.oPa);
                                break;
                            case 6:
                                bitmap = o.PC().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bu.a.getDensity(context), false);
                                break;
                        }
                        if (bitmap == null) {
                            bitmap = o.PC().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bu.a.getDensity(context), false);
                        }
                        if (bitmap != null) {
                            bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                        } else {
                            imageView.setImageResource(R.g.bBE);
                            if (!(aVar.Qs() || dVar.oOZ == null)) {
                                dVar.oOZ.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                            }
                            x.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", aVar.field_songAlbumUrl);
                            if (!TextUtils.isEmpty(aVar.field_songAlbumUrl)) {
                                aVar2 = new com.tencent.mm.ap.a.a.c.a();
                                aVar2.hFn = com.tencent.mm.plugin.music.model.g.c(aVar, true);
                                aVar2.hFl = true;
                                aVar2.hFj = true;
                                if (z3) {
                                    aVar2.hFv = true;
                                    aVar2.hFw = 10;
                                }
                                o.PG().a(aVar.field_songAlbumUrl, imageView, aVar2.PQ(), dVar.oPa);
                            }
                        }
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        dVar.a(aVar, bitmap);
                        imageView.setImageBitmap(bitmap);
                        o = c.o(bitmap);
                        if (!aVar.e(o)) {
                            aVar = h.beg().P(aVar.field_musicId, o[0], o[1]);
                        }
                        if (dVar.oOZ != null && aVar != null) {
                            dVar.oOZ.a(aVar, o);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", aVar.field_musicId);
                imageView.setImageBitmap(bitmap);
                o = aVar.Qs() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : c.o(bitmap);
                if (dVar.oOZ != null) {
                    dVar.oOZ.a(aVar, o);
                }
            }
        }

        public final boolean bfn() {
            return this.mode == 2;
        }

        public final void bfo() {
            if (!this.oTe && this.mode != 1) {
                f.cW(3, b.this.scene);
                if (b.this.oST == 0) {
                    b.this.oST = this.oSX.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.this.oST);
                    layoutParams.weight = 0.0f;
                    this.oSX.setLayoutParams(layoutParams);
                }
                f.oPt = true;
                f.bed();
                this.mode = 1;
                this.oTe = true;
                Animation aVar = new a(this.oTd, b.this.oSP);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.oTf);
                this.oTd.startAnimation(aVar);
            }
        }

        public final void bfp() {
            if (!this.oTe && this.mode != 2) {
                f.cW(2, b.this.scene);
                if (b.this.oST == 0) {
                    b.this.oST = this.oSX.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b.this.oST);
                    layoutParams.weight = 0.0f;
                    this.oSX.setLayoutParams(layoutParams);
                }
                f.oPt = true;
                f.bed();
                this.mode = 2;
                this.oTe = true;
                Animation aVar = new a(this.oTd, b.this.oSQ);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.oTf);
                this.oTd.startAnimation(aVar);
            }
        }

        public final void bfq() {
            f.oPt = true;
            f.bed();
            if (this.mode == 1) {
                bfp();
            } else {
                bfo();
            }
        }
    }

    public b(Context context, int i, boolean z) {
        super(context);
        this.scene = i;
        this.oRt = z;
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.doG, viewGroup, false);
            aVar = new a();
            aVar.oSW = (MusicItemLayout) view.findViewById(R.h.cyn);
            aVar.oTb = (TextView) view.findViewById(R.h.cyo);
            aVar.oTd = (LyricView) view.findViewById(R.h.cuE);
            aVar.oSX = view.findViewById(R.h.bJO);
            aVar.oSY = view.findViewById(R.h.bJP);
            aVar.oSZ = view.findViewById(R.h.bJQ);
            aVar.oTa = (CdnImageView) view.findViewById(R.h.bJN);
            aVar.oTc = (TextView) view.findViewById(R.h.cyx);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List list = h.bef().oPg;
        int size = (i - 100000) % list.size();
        if (size < 0) {
            size += list.size();
        }
        x.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", Integer.valueOf(size));
        com.tencent.mm.au.a Hc = h.beg().Hc((String) list.get(size));
        this.oSR.put(Integer.valueOf(i), view);
        aVar.h(Hc, false);
        return view;
    }

    public final void ue(int i) {
        this.oSR.remove(Integer.valueOf(i));
    }

    public final int bfm() {
        return h.bef().oPg.size();
    }

    public final void C(final int i, final long j) {
        ah.y(new Runnable() {
            public final void run() {
                View view = (View) b.this.oSR.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).oTd.dR(j);
                }
            }
        });
    }

    public final void a(com.tencent.mm.au.a aVar, int[] iArr) {
        for (Entry value : this.oSR.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.fBv.field_musicId.equals(aVar.field_musicId)) {
                x.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", aVar2.fBv.field_songName);
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.oSW.setBackgroundColor(i);
                LyricView lyricView = aVar2.oTd;
                lyricView.oSz.setColor(i2);
                lyricView.oSz.setAlpha(255);
                lyricView.oSA.setColor(i2);
                lyricView.oSA.setAlpha(127);
                aVar2.oTa.setBackgroundColor(i);
                ShaderFactory anonymousClass1 = new AnonymousClass1(i);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(anonymousClass1);
                aVar2.oSY.setBackgroundDrawable(paintDrawable);
                anonymousClass1 = new AnonymousClass2((i & 16777215) | 1426063360);
                Drawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(anonymousClass1);
                aVar2.oSZ.setBackgroundDrawable(paintDrawable2);
                aVar2.oTb.setTextColor(i2);
                aVar2.oTc.setTextColor(i2);
                ((MusicMainUI) this.context).q(aVar);
            }
        }
    }
}
