package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.v;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends v {
    private Bitmap feZ = null;
    Context mContext;
    ArrayList<MediaItem> mXw = new ArrayList();
    ArrayList<String> mYS = new ArrayList();
    boolean mYT;
    HashSet<String> mYU = new HashSet();
    int mYV = -1;
    View mYW = null;
    boolean mYX = false;
    private HashMap<String, WeakReference<b>> mYY = new HashMap();
    public e mYZ = new e(this);
    public d mZa = new d(this);

    class a implements OnClickListener {
        private String filePath;

        public a(String str) {
            this.filePath = str;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.filePath)), "video/*");
            try {
                c.this.mContext.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    static class b {
        ImageView mDW;
        MultiTouchImageView mZc;
        TextView mZd;

        b() {
        }
    }

    public final /* synthetic */ Object e(int i, View view) {
        Object view2;
        b bVar;
        String str;
        MediaItem mediaItem;
        String str2;
        long Wz = bi.Wz();
        if (view2 == null) {
            view2 = View.inflate(this.mContext, R.i.dlN, null);
            b bVar2 = new b();
            bVar2.mZc = (MultiTouchImageView) view2.findViewById(R.h.image);
            bVar2.mDW = (ImageView) view2.findViewById(R.h.cVl);
            bVar2.mZd = (TextView) view2.findViewById(R.h.cVf);
            view2.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view2.getTag();
        }
        String str3;
        if (this.mYT) {
            MediaItem mediaItem2 = (MediaItem) this.mXw.get(i);
            str3 = mediaItem2.hQc;
            str = mediaItem2.mqO;
            mediaItem = mediaItem2;
            str2 = str3;
        } else {
            str3 = (String) this.mYS.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aOn() != null) {
                int indexOf = com.tencent.mm.plugin.gallery.model.c.aOn().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aOn().get(indexOf);
                    str = null;
                    str2 = str3;
                }
            }
            mediaItem = null;
            str = null;
            str2 = str3;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.mZd.setText(this.mContext.getString(R.l.ell, new Object[]{bi.by(new File(str2).length())}));
                bVar.mZd.setVisibility(0);
            } else {
                bVar.mZd.setVisibility(8);
            }
            bVar.mDW.setVisibility(8);
            bVar.mDW.setOnClickListener(null);
        } else {
            bVar.mZd.setVisibility(8);
            bVar.mDW.setVisibility(0);
            bVar.mDW.setOnClickListener(new a(str2));
            if (com.tencent.mm.plugin.gallery.model.c.aOl().aOO() == 4) {
                Runnable mVar = new m(mediaItem.hQc, i, (VideoMediaItem) mediaItem, null);
                if (e.V(mVar)) {
                    x.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", Integer.valueOf(16842794));
                } else {
                    e.post(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        MultiTouchImageView multiTouchImageView2;
        if (com.tencent.mm.plugin.gallery.model.c.aOl().aOO() != 3 || (!(mediaItem == null && p.Vw(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            com.tencent.mm.plugin.gallery.model.c.aOm().aOB();
            if (this.mZa.mZp.bu(str2)) {
                bitmap = (Bitmap) this.mZa.mZp.get(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.mZc, bitmap);
                }
            }
            bitmap = com.tencent.mm.plugin.gallery.model.c.aOk().BW(bi.oN(str) ? str2 : str);
            if (bitmap == null) {
                multiTouchImageView = bVar.mZc;
                if (this.feZ == null || this.feZ.isRecycled()) {
                    this.feZ = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bEG);
                }
                a(multiTouchImageView, this.feZ);
            } else {
                a(bVar.mZc, bitmap);
            }
            if (!this.mYU.contains(str2)) {
                this.mYU.add(str2);
                d dVar = this.mZa;
                multiTouchImageView2 = bVar.mZc;
                if (!dVar.tj.contains(str2)) {
                    int hashCode = multiTouchImageView2.hashCode();
                    dVar.qR(hashCode);
                    dVar.mZm.put(str2, Integer.valueOf(hashCode));
                    dVar.mZn.put(hashCode, str2);
                    dVar.mZl.put(hashCode, new WeakReference(multiTouchImageView2));
                    dVar.tj.add(str2);
                    dVar.aPc();
                }
            }
        } else {
            multiTouchImageView = bVar.mZc;
            multiTouchImageView.yod = true;
            try {
                multiTouchImageView.yoe = com.tencent.mm.ui.e.b.c.fV(str2, str2);
                multiTouchImageView.setImageDrawable(multiTouchImageView.yoe);
                if (multiTouchImageView.yoe != null) {
                    multiTouchImageView.eV(multiTouchImageView.yoe.getIntrinsicWidth(), multiTouchImageView.yoe.getIntrinsicHeight());
                }
            } catch (Exception e) {
                multiTouchImageView.yod = false;
            }
            multiTouchImageView2 = bVar.mZc;
            if (multiTouchImageView2.yod && multiTouchImageView2.yoe != null) {
                ((com.tencent.mm.ui.e.b.a) multiTouchImageView2.yoe).stop();
                ((com.tencent.mm.ui.e.b.a) multiTouchImageView2.yoe).start();
            }
            bVar.mZc.aE(1.0f);
            bVar.mZc.rIg = false;
            if (VERSION.SDK_INT == 20) {
                bVar.mZc.setLayerType(1, null);
            } else {
                l.k(bVar.mZc, bVar.mZc.getWidth(), bVar.mZc.getHeight());
            }
            bVar.mZc.requestLayout();
            bVar.mZc.cqJ();
        }
        x.v("MicroMsg.ImageAdapter", "test getview: %d position:%d", Long.valueOf(bi.bB(Wz)), Integer.valueOf(i));
        return view2;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final void B(ArrayList<String> arrayList) {
        this.mYS.clear();
        this.mYS = new ArrayList();
        this.mYS.addAll(arrayList);
        reset();
        notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.mYT) {
            return super.b(viewGroup, i);
        }
        x.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", Integer.valueOf(i), Integer.valueOf(this.mYV));
        if (i != this.mYV || !this.mYX) {
            return super.b(viewGroup, i);
        }
        x.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.ynv.put(this.mYW, Integer.valueOf(this.mYV));
        this.ynw.put(this.mYV, this.mYW);
        this.mYV = -1;
        this.mYX = false;
        return this.mYW;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.mYT) {
            super.a(viewGroup, i, obj);
        } else if (obj == null) {
            x.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", Integer.valueOf(i));
        } else {
            if (this.mYW != null) {
                x.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.mYW.hashCode()));
            }
            if (obj == this.mYW && this.mYX) {
                x.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                return;
            }
            super.a(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
        }
    }

    public final int getCount() {
        if (this.mYT) {
            return this.mXw.size();
        }
        return this.mYS.size();
    }

    public final MultiTouchImageView qP(int i) {
        View Fj = super.Fj(i);
        if (Fj == null) {
            x.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            return null;
        } else if (Fj == null || Fj.getVisibility() == 8) {
            return null;
        } else {
            Fj = Fj.findViewById(R.h.image);
            if (Fj == null) {
                return null;
            }
            return (MultiTouchImageView) Fj;
        }
    }

    public final String kF(int i) {
        if (this.mYT) {
            if (i >= 0 && i < this.mXw.size()) {
                return ((MediaItem) this.mXw.get(i)).hQc;
            }
            x.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", Integer.valueOf(i), Integer.valueOf(this.mXw.size()));
            return "";
        } else if (i >= 0 && i < this.mYS.size()) {
            return (String) this.mYS.get(i);
        } else {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mYS.size()));
            return "";
        }
    }

    public final MediaItem qQ(int i) {
        if (this.mYT) {
            if (i >= 0 && i < this.mXw.size()) {
                return (MediaItem) this.mXw.get(i);
            }
            x.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", Integer.valueOf(i), Integer.valueOf(this.mXw.size()));
            return null;
        } else if (i < 0 || i >= this.mYS.size()) {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", Integer.valueOf(i), Integer.valueOf(this.mYS.size()));
            return null;
        } else {
            String str = (String) this.mYS.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aOn() == null) {
                return null;
            }
            int indexOf = com.tencent.mm.plugin.gallery.model.c.aOn().indexOf(MediaItem.a(0, 0, str, str, ""));
            if (indexOf >= 0) {
                return (MediaItem) com.tencent.mm.plugin.gallery.model.c.aOn().get(indexOf);
            }
            return null;
        }
    }

    @TargetApi(11)
    static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        multiTouchImageView.aE(4.5f);
        multiTouchImageView.rIg = false;
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            l.k(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.eV(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
    }

    public final void release() {
        detach();
        this.mYY.clear();
        this.mYU.clear();
    }

    public final void detach() {
        super.detach();
        d dVar = this.mZa;
        dVar.mZr = null;
        dVar.mZl.clear();
        dVar.mZo.clear();
        dVar.mZn.clear();
        dVar.mZm.clear();
        dVar.aPa();
    }
}
