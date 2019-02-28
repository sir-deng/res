package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.y.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameGestureGalleryUI extends MMActivity implements OnTouchListener, com.tencent.mm.platformtools.j.a {
    private MMGestureGallery nwA;
    float nwB = 0.0f;
    float nwC = 0.0f;
    boolean nwD = false;
    float nwE = 1.0f;
    private w nwF;
    private List<String> nwG = new ArrayList();
    private int nwH = -1;
    private OnItemSelectedListener nwI = new OnItemSelectedListener() {
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            GameGestureGalleryUI.this.nwH = i;
            GameGestureGalleryUI.this.setMMTitle((GameGestureGalleryUI.this.nwH + 1) + " / " + GameGestureGalleryUI.this.nwG.size());
            x.d("MicroMsg.GameGestureGalleryUI", "pos:" + i);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private a nwy;
    private MMGallery nwz;
    private String thumbUrl;

    class a extends BaseAdapter {

        class a {
            ImageView fzb;
            ProgressBar nwK;

            a() {
            }
        }

        public final int getCount() {
            x.d("MicroMsg.GameGestureGalleryUI", "lstpicurl:" + GameGestureGalleryUI.this.nwG.size());
            return GameGestureGalleryUI.this.nwG.size();
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
                aVar = new a();
                view = View.inflate(GameGestureGalleryUI.this, R.i.dlO, null);
                aVar.nwK = (ProgressBar) view.findViewById(R.h.cEk);
                aVar.fzb = (ImageView) view.findViewById(R.h.image);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar.nwK.setVisibility(8);
            Bitmap a = j.a(new ar((String) GameGestureGalleryUI.this.nwG.get(i)));
            if (a == null || a.isRecycled()) {
                aVar.nwK.setVisibility(0);
                if (!bi.oN(GameGestureGalleryUI.this.thumbUrl)) {
                    a = j.a(new ar(GameGestureGalleryUI.this.thumbUrl));
                }
                if (a == null || a.isRecycled()) {
                    aVar.fzb.setVisibility(8);
                    return view;
                }
                aVar.fzb.setImageBitmap(a);
                aVar.fzb.setVisibility(0);
                return view;
            } else if (g.cpy()) {
                aVar.fzb.setVisibility(8);
                view = new MultiTouchImageView(GameGestureGalleryUI.this, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                return view;
            } else {
                aVar.fzb.setImageBitmap(a);
                aVar.fzb.setVisibility(0);
                aVar.fzb.setScaleType(ScaleType.MATRIX);
                return view;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nwF = new w(false);
        j.a((com.tencent.mm.platformtools.j.a) this);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        this.nwF.GS();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dqu;
    }

    protected final void initView() {
        this.thumbUrl = getIntent().getStringExtra("thumbUrl");
        String oM = bi.oM(getIntent().getStringExtra("nowUrl"));
        this.mController.hideTitleView();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            this.nwG = new ArrayList();
            this.nwG.add(oM);
        } else {
            this.nwG = Arrays.asList(stringArrayExtra);
        }
        for (int i = 0; i < this.nwG.size(); i++) {
            if (oM.equals(this.nwG.get(i))) {
                this.nwH = i;
                break;
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameGestureGalleryUI.this.finish();
                return true;
            }
        });
        this.nwy = new a();
        if (g.cpy()) {
            this.nwA = (MMGestureGallery) findViewById(R.h.ckv);
            this.nwA.setVisibility(0);
            this.nwA.setVerticalFadingEdgeEnabled(false);
            this.nwA.setHorizontalFadingEdgeEnabled(false);
            this.nwA.setAdapter(this.nwy);
            this.nwA.setSelection(this.nwH);
            this.nwA.setOnItemSelectedListener(this.nwI);
            return;
        }
        this.nwz = (MMGallery) findViewById(R.h.ckw);
        this.nwz.setVisibility(0);
        this.nwz.setAdapter(this.nwy);
        this.nwz.setSelection(this.nwH);
        this.nwz.setOnItemSelectedListener(this.nwI);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        x.d("MicroMsg.GameGestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.nwD) {
                    this.nwC = g.J(motionEvent);
                    if (this.nwC >= 5.0f) {
                        float f = this.nwC - this.nwB;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.nwE, this.nwE + f2, this.nwE, this.nwE + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.nwE += f2;
                            this.nwz.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.nwE), (int) (this.nwE * 854.0f)));
                            this.nwB = this.nwC;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.nwB = g.J(motionEvent);
                if (this.nwB > 5.0f) {
                    this.nwD = true;
                    break;
                }
                break;
            case 6:
                this.nwD = false;
                break;
        }
        return false;
    }

    public final void l(String str, Bitmap bitmap) {
        if (this.nwG != null && this.nwG.size() != 0) {
            if ((((String) this.nwG.get(0)).hashCode()).equals(str) && this.nwy != null) {
                this.nwy.notifyDataSetChanged();
            }
        }
    }
}
