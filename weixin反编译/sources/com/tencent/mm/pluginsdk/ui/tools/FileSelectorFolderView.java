package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class FileSelectorFolderView extends LinearLayout implements OnItemClickListener {
    boolean Od = false;
    private FrameLayout mZf;
    private View mZg;
    private ListView mZh;
    private boolean mZj = false;
    a vDF = null;
    private b vDG;

    public interface a {
        void CT(int i);
    }

    public static class b extends BaseAdapter {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return 2;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.i.dit, null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            switch (i) {
                case 0:
                    cVar.ikn.setText(R.l.ehu);
                    break;
                case 1:
                    cVar.ikn.setText(R.l.ehv);
                    break;
                default:
                    cVar.ikn.setText(R.l.dEU);
                    break;
            }
            return view;
        }
    }

    static class c {
        TextView ikn;

        c(View view) {
            this.ikn = (TextView) view.findViewById(R.h.crX);
        }
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    final void fv(boolean z) {
        Animation loadAnimation;
        if (this.Od == z) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.Od));
        } else if (this.mZj) {
            x.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
        } else if (this.Od) {
            this.mZj = true;
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.a.bqm);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    FileSelectorFolderView.this.mZf.setVisibility(8);
                    FileSelectorFolderView.this.Od = false;
                    FileSelectorFolderView.this.mZj = false;
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
                    FileSelectorFolderView.this.Od = true;
                    FileSelectorFolderView.this.mZj = false;
                }
            });
            this.mZh.startAnimation(loadAnimation);
        }
    }

    private void init() {
        setOrientation(1);
        this.mZf = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mZf.setVisibility(8);
        addView(this.mZf, layoutParams);
        this.mZg = new View(getContext());
        this.mZg.setBackgroundColor(-872415232);
        this.mZg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FileSelectorFolderView.this.fv(false);
            }
        });
        this.mZf.addView(this.mZg, new FrameLayout.LayoutParams(-1, -1));
        this.mZh = new ListView(getContext());
        this.mZh.setCacheColorHint(0);
        this.mZh.setBackgroundResource(R.e.btq);
        this.mZh.setSelector(R.g.bDK);
        this.mZh.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvK);
        this.mZh.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.buH);
        layoutParams.gravity = 80;
        this.mZf.addView(this.mZh, layoutParams);
        this.vDG = new b(getContext());
        this.mZh.setAdapter(this.vDG);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.vDF != null) {
            this.vDF.CT(i);
        }
        this.mZg.performClick();
    }
}
