package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    public String qnu;
    public String username;
    public q vqp;
    private Bitmap vqq;
    private Bitmap vqr;
    private a vqs;

    private class b implements com.tencent.mm.ui.tools.MMGestureGallery.c {
        private b() {
        }

        /* synthetic */ b(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void aJP() {
            if (GetHdHeadImageGalleryView.this.qnu != null && GetHdHeadImageGalleryView.this.username != null) {
                h.a(GetHdHeadImageGalleryView.this.getContext(), null, GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(com.tencent.mm.plugin.comm.a.a.ltr), "", new com.tencent.mm.ui.base.h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                String str = e.gJf + "hdImg_" + g.s(GetHdHeadImageGalleryView.this.username.getBytes()) + System.currentTimeMillis() + ".jpg";
                                FileOp.deleteFile(str);
                                FileOp.x(GetHdHeadImageGalleryView.this.qnu, str);
                                d.b(str, GetHdHeadImageGalleryView.this.getContext());
                                Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(com.tencent.mm.plugin.comm.a.h.enM, new Object[]{e.gJf}), 1).show();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    private class a extends BaseAdapter {

        class a {
            ImageView fzb;
            ProgressBar nwK;
            View vqu;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(GetHdHeadImageGalleryView.this.getContext(), f.ltH, null);
                aVar2.nwK = (ProgressBar) view.findViewById(com.tencent.mm.plugin.comm.a.e.ltA);
                aVar2.fzb = (ImageView) view.findViewById(com.tencent.mm.plugin.comm.a.e.ltz);
                aVar2.vqu = view.findViewById(com.tencent.mm.plugin.comm.a.e.ltB);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            if (GetHdHeadImageGalleryView.this.vqr != null) {
                aVar.nwK.setVisibility(8);
                aVar.fzb.setVisibility(8);
                aVar.vqu.setVisibility(8);
                view = new MultiTouchImageView(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.vqr.getWidth(), GetHdHeadImageGalleryView.this.vqr.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(GetHdHeadImageGalleryView.this.vqr);
                view.aE(2.0f);
                view.ynW = true;
                return view;
            }
            aVar.nwK.setVisibility(0);
            aVar.vqu.setVisibility(0);
            if (GetHdHeadImageGalleryView.this.vqq != null) {
                aVar.fzb.setVisibility(0);
                aVar.fzb.setImageBitmap(GetHdHeadImageGalleryView.this.vqq);
                return view;
            }
            aVar.fzb.setVisibility(8);
            return view;
        }
    }

    private class c implements MMGestureGallery.f {
        private c() {
        }

        /* synthetic */ c(GetHdHeadImageGalleryView getHdHeadImageGalleryView, byte b) {
            this();
        }

        public final void awD() {
            if (GetHdHeadImageGalleryView.this.vqp != null) {
                GetHdHeadImageGalleryView.this.vqp.dismiss();
            }
        }
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.vqs = new a();
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.vqs);
        setSelection(0);
        this.zuj = new c();
        this.zuk = new b();
    }

    public final void setThumbImage(Bitmap bitmap) {
        this.vqq = bitmap;
        this.vqs.notifyDataSetChanged();
    }

    public final void N(Bitmap bitmap) {
        this.vqr = bitmap;
        this.vqs.notifyDataSetChanged();
    }
}
