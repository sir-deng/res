package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<uw> lMc = new LinkedList();
    private Context mContext;
    private Animation nPW;
    private Animation psg;
    private Animation psh;
    private HashMap<String, Boolean> psi = new HashMap();

    class a {
        ImageView jSg;
        TextView jtn;

        public a(View view) {
            this.jSg = (ImageView) view.findViewById(R.h.cfY);
            this.jtn = (TextView) view.findViewById(R.h.cgh);
        }
    }

    public a(Context context) {
        this.mContext = context;
        this.nPW = AnimationUtils.loadAnimation(this.mContext, R.a.bpO);
        this.psh = AnimationUtils.loadAnimation(this.mContext, R.a.bpO);
        this.psg = AnimationUtils.loadAnimation(this.mContext, R.a.bpP);
        this.nPW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.psh.setInterpolator(new AccelerateInterpolator());
        this.psg.setInterpolator(new AccelerateDecelerateInterpolator());
        this.nPW.setDuration(300);
        this.psh.setDuration(1000);
        this.psg.setDuration(1000);
    }

    public final void I(LinkedList<uw> linkedList) {
        this.lMc = linkedList;
        if (this.lMc != null && this.lMc.size() > 0) {
            int size = this.lMc.size();
            for (int i = 0; i < size; i++) {
                String a = a((uw) this.lMc.get(i));
                if (!this.psi.containsKey(a)) {
                    this.psi.put(a, Boolean.valueOf(false));
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.lMc == null ? 1 : this.lMc.size() + 1;
    }

    public final Object getItem(int i) {
        if (this.lMc != null && i < this.lMc.size()) {
            return this.lMc.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.dhw, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        uw uwVar = (uw) getItem(i);
        if (uwVar != null) {
            if (bi.oN(uwVar.kzN)) {
                aVar.jtn.setText(uwVar.kyG);
            } else {
                aVar.jtn.setText(uwVar.kzN);
            }
            if (bi.oN(uwVar.kyG)) {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jSg, uwVar.wjz);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jSg, uwVar.kyG);
            }
            String a = a(uwVar);
            view.clearAnimation();
            if (this.psi.containsKey(a) && !((Boolean) this.psi.get(a)).booleanValue()) {
                view.startAnimation(this.nPW);
                this.psi.put(a, Boolean.valueOf(true));
            }
        }
        if (i + 1 == getCount()) {
            aVar.jtn.setText("");
            aVar.jSg.setImageResource(R.g.byy);
            if (view != null) {
                this.psh.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(a.this.psg);
                    }
                });
                this.psg.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        view.startAnimation(a.this.psh);
                    }
                });
                view.startAnimation(this.psh);
            }
        }
        return view;
    }

    private static String a(uw uwVar) {
        if (uwVar == null) {
            return "";
        }
        if (bi.oN(uwVar.kyG)) {
            return uwVar.wjz;
        }
        return uwVar.kyG;
    }
}
