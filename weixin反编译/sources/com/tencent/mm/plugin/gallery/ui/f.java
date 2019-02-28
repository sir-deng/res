package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class f extends android.support.v7.widget.RecyclerView.a<a> implements OnClickListener {
    private Context mContext;
    private boolean mYT;
    private ArrayList<String> mZB;
    c naf;
    private int nag;
    ArrayList<String> nah = new ArrayList();
    b nai;
    private int naj = -1;
    private int nak = -1;
    private int nal;
    private int nam;
    private Drawable nan;
    android.support.v7.widget.a.a nao = new android.support.v7.widget.a.a(new android.support.v7.widget.a.a.a() {
        int fKv = -1;

        public final boolean a(t tVar, t tVar2) {
            int gf = tVar.gf();
            int gf2 = tVar2.gf();
            f.this.V(gf, gf2);
            if (f.this.nai != null) {
                f.this.nai.cH(gf, gf2);
            }
            f.this.nak = gf2;
            return false;
        }

        public final void e(final t tVar, final int i) {
            super.e(tVar, i);
            if (tVar != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(f.this.mContext, R.a.bqh);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (i == 2) {
                            f.this.naj = f.this.nak = tVar.gf();
                            AnonymousClass1.this.fKv = f.this.nam;
                            x.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", Integer.valueOf(AnonymousClass1.this.fKv));
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) tVar).nav.startAnimation(loadAnimation);
            }
        }

        public final void c(RecyclerView recyclerView, t tVar) {
            if (tVar != null) {
                super.c(recyclerView, tVar);
                Animation loadAnimation = AnimationUtils.loadAnimation(f.this.mContext, R.a.bqg);
                loadAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        com.tencent.mm.plugin.gallery.a.a.swap(f.this.nah, f.this.naj, f.this.nak);
                        if (f.this.nai == null) {
                            return;
                        }
                        if (AnonymousClass1.this.fKv > f.this.naj && AnonymousClass1.this.fKv <= f.this.nak) {
                            f.this.nai.L(f.this.naj, f.this.nak, AnonymousClass1.this.fKv - 1);
                        } else if (AnonymousClass1.this.fKv < f.this.naj && AnonymousClass1.this.fKv >= f.this.nak) {
                            f.this.nai.L(f.this.naj, f.this.nak, AnonymousClass1.this.fKv + 1);
                        } else if (f.this.naj == AnonymousClass1.this.fKv) {
                            f.this.nai.L(f.this.naj, f.this.nak, f.this.nak);
                        } else {
                            f.this.nai.L(f.this.naj, f.this.nak, AnonymousClass1.this.fKv);
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) tVar).nav.startAnimation(loadAnimation);
            }
        }

        public final void ho() {
        }

        public final float hn() {
            return 0.295858f;
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i, boolean z) {
            super.a(canvas, recyclerView, tVar, f / 1.3f, f2 / 1.3f, i, z);
        }

        public final int hh() {
            return 3342387;
        }

        public final boolean hj() {
            return true;
        }

        public final boolean hk() {
            return false;
        }
    });

    public interface b {
        void L(int i, int i2, int i3);

        void cH(int i, int i2);

        void qT(int i);
    }

    public static class a extends t {
        public ImageView mXJ;
        public ImageView mXK;
        public RelativeLayout mXL;
        public TextView mXM;
        public ImageView mXQ;
        public ImageView mXR;
        public ImageView mXS;
        public ImageView nau;
        public View nav;
        public int naw;

        public a(View view) {
            super(view);
            this.nav = view;
            this.mXR = (ImageView) view.findViewById(R.h.cnF);
            this.mXS = (ImageView) view.findViewById(R.h.cdj);
            this.nau = (ImageView) view.findViewById(R.h.ceO);
            this.mXJ = (ImageView) view.findViewById(R.h.cvH);
            this.mXK = (ImageView) view.findViewById(R.h.cvK);
            this.mXL = (RelativeLayout) view.findViewById(R.h.cVl);
            this.mXM = (TextView) view.findViewById(R.h.cVm);
            this.mXQ = (ImageView) view.findViewById(R.h.cvF);
            this.mXQ.setBackgroundResource(R.e.bsK);
            this.mXQ.setVisibility(8);
        }
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.i.dpC, viewGroup, false));
    }

    public final /* synthetic */ void a(t tVar, int i, List list) {
        a aVar = (a) tVar;
        if (list.isEmpty()) {
            a(aVar, i);
            return;
        }
        MediaItem a = a(i, aVar);
        if (a != null) {
            c(aVar.mXJ, a.hQc, i);
        }
    }

    public final void cI(int i, int i2) {
        this.nam = i;
        this.nal = i2;
    }

    public f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        this.mContext = context;
        this.mZB = arrayList;
        this.nah.addAll(arrayList);
        this.nag = i;
        this.mYT = z;
        this.nan = context.getResources().getDrawable(R.g.divider);
    }

    private void a(final a aVar, int i) {
        MediaItem a = a(i, aVar);
        if (a == null) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            return;
        }
        LayoutParams layoutParams = aVar.nav.getLayoutParams();
        int i2 = this.nag;
        layoutParams.width = i2;
        layoutParams.height = i2;
        c(aVar.mXJ, a.hQc, i);
        aVar.nav.setOnClickListener(this);
        if (this.mYT) {
            aVar.nav.setTag(Integer.valueOf(aVar.naw));
        } else {
            aVar.nav.setTag(a.hQc);
        }
        if (a.getType() == 2) {
            aVar.mXL.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).hQf)) / 1000.0f);
            aVar.mXM.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            aVar.mXL.setVisibility(8);
        }
        String aOC = a.aOC();
        String str = a.hQc;
        if (bi.oN(aOC) && bi.oN(str)) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: " + i);
            return;
        }
        h.a(aVar.mXK, a.getType(), aOC, str, a.mWR, this.nag, new com.tencent.mm.plugin.gallery.ui.h.a() {
            public final void aOU() {
                x.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", Integer.valueOf(aVar.mXK.getWidth()), Integer.valueOf(aVar.mXK.getHeight()));
            }
        });
        if ((c.aOl().aOO() == 3 || c.aOl().aOO() == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            aVar.mXR.setVisibility(0);
        } else {
            aVar.mXR.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            aVar.mXS.setVisibility(0);
        } else {
            aVar.mXS.setVisibility(8);
        }
        aVar.nau.setVisibility(8);
    }

    private void c(ImageView imageView, String str, int i) {
        if (i == this.nam && this.mZB.contains(str)) {
            x.i("MicroMsg.PreviewSelectedImageAdapter", "show select box");
            imageView.setVisibility(0);
            imageView.setBackground(null);
            imageView.setImageDrawable(this.nan);
        } else if (i == this.nam && !this.mZB.contains(str)) {
            x.i("MicroMsg.PreviewSelectedImageAdapter", "no show select box");
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(this.nan);
        } else if (i != this.nam && this.mZB.contains(str)) {
            imageView.setVisibility(8);
            imageView.setBackground(null);
            imageView.setImageDrawable(null);
        } else if (!(i == this.nam || this.mZB.contains(str))) {
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
        }
        if (this.nal != i) {
            return;
        }
        if (!bi.oN(this.naf.kF(this.nal)) && this.naf.kF(this.nal).equals(str)) {
            imageView.setVisibility(0);
        } else if (!bi.oN(this.naf.kF(this.nal)) && !this.naf.kF(this.nal).equals(str)) {
            imageView.setVisibility(8);
        }
    }

    public final int getItemCount() {
        return this.nah.size();
    }

    public final void onClick(View view) {
        if (this.nai == null) {
            return;
        }
        if (this.mYT) {
            this.nai.qT(((Integer) view.getTag()).intValue());
        } else {
            this.nai.qT(this.nah.indexOf(view.getTag()));
        }
    }

    private MediaItem a(int i, a aVar) {
        if (i < 0 || i >= this.nah.size()) {
            x.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.nah.size()));
            return null;
        }
        String str = (String) this.nah.get(i);
        MediaItem a;
        int indexOf;
        Iterator it;
        MediaItem mediaItem;
        if (this.mYT) {
            if (this.naf.mXw == null) {
                return null;
            }
            a = MediaItem.a(0, 0, str, str, "");
            indexOf = this.naf.mXw.indexOf(a);
            if (indexOf >= 0) {
                aVar.naw = indexOf;
                return (MediaItem) this.naf.mXw.get(indexOf);
            }
            it = c.aOq().iterator();
            while (it.hasNext()) {
                mediaItem = (MediaItem) it.next();
                if (mediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.hQc);
                    return mediaItem;
                }
            }
            return null;
        } else if (c.aOn() != null) {
            a = MediaItem.a(0, 0, str, str, "");
            indexOf = c.aOn().indexOf(a);
            if (indexOf >= 0) {
                return (MediaItem) c.aOn().get(indexOf);
            }
            it = c.aOq().iterator();
            while (it.hasNext()) {
                mediaItem = (MediaItem) it.next();
                if (mediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", mediaItem.hQc);
                    return mediaItem;
                }
            }
            return null;
        } else {
            return MediaItem.a(1, 0, str, str, "");
        }
    }
}
