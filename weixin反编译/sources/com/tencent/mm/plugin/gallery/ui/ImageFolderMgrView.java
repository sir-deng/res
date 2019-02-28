package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, com.tencent.mm.plugin.gallery.model.g.a {
    boolean Od = false;
    a mZe = null;
    FrameLayout mZf;
    private View mZg;
    private ListView mZh;
    private b mZi;
    boolean mZj = false;

    public interface a {
        void b(AlbumItem albumItem);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mZf = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mZf.setVisibility(8);
        addView(this.mZf, layoutParams);
        this.mZg = new View(getContext());
        this.mZg.setBackgroundColor(-872415232);
        this.mZg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ImageFolderMgrView.this.fv(false);
            }
        });
        this.mZf.addView(this.mZg, new FrameLayout.LayoutParams(-1, -1));
        this.mZh = new ListView(getContext());
        this.mZh.setCacheColorHint(0);
        this.mZh.setBackgroundResource(R.e.btq);
        this.mZh.setSelector(R.g.bDK);
        this.mZh.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvK);
        this.mZh.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.buH);
        layoutParams.gravity = 80;
        this.mZf.addView(this.mZh, layoutParams);
        this.mZi = new b(getContext(), c.aOl().aOP());
        this.mZh.setAdapter(this.mZi);
    }

    public final void aOZ() {
        fv(!this.Od);
    }

    private void fv(boolean z) {
        Animation loadAnimation;
        if (this.Od == z) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.Od));
        } else if (this.mZj) {
            x.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
        } else if (this.Od) {
            this.mZj = true;
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bqm);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    ImageFolderMgrView.this.mZf.setVisibility(8);
                    ImageFolderMgrView.this.Od = false;
                    ImageFolderMgrView.this.mZj = false;
                }
            });
            this.mZh.startAnimation(loadAnimation);
            this.mZg.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bqa));
        } else {
            this.mZj = true;
            this.mZf.setVisibility(0);
            this.mZg.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.bpZ));
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    ImageFolderMgrView.this.Od = true;
                    ImageFolderMgrView.this.mZj = false;
                }
            });
            this.mZh.startAnimation(loadAnimation);
        }
    }

    public final void x(ArrayList<AlbumItem> arrayList) {
        b bVar = this.mZi;
        bVar.mYL = arrayList;
        if (!(bVar.mYL == null || bVar.mYL.isEmpty() || ((AlbumItem) bVar.mYL.get(0)).mWO == null)) {
            AlbumItem albumItem;
            AlbumItem albumItem2 = null;
            Iterator it = bVar.mYL.iterator();
            while (true) {
                albumItem = albumItem2;
                if (!it.hasNext()) {
                    break;
                }
                albumItem2 = (AlbumItem) it.next();
                if (albumItem != null) {
                    if (albumItem.mWO.mWS >= albumItem2.mWO.mWS) {
                        albumItem2 = albumItem;
                    }
                }
            }
            if (albumItem != null) {
                bVar.mYM.mWO = albumItem.mWO;
            }
        }
        c.aOm().y(new Runnable() {
            public final void run() {
                ImageFolderMgrView.this.mZi.notifyDataSetChanged();
            }

            public final String toString() {
                return super.toString() + "|onQueryAlbumFinished";
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlbumItem qO = this.mZi.qO(i);
        if (qO == null) {
            x.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + i);
            return;
        }
        if (this.mZe != null) {
            this.mZe.b(qO);
        }
        this.mZi.mYN = bi.aD(qO.mWN, "");
        this.mZh.setSelection(0);
        this.mZi.notifyDataSetChanged();
        this.mZg.performClick();
    }
}
