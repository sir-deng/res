package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.ui.v;

public class NotInterestMenu extends LinearLayout {
    private static int[] qTB = new int[]{j.qRe, j.qRc, j.qRd};
    private Context mContext = null;
    m qEj = null;
    private ListView qTA;
    c qTC = null;
    b qTD = null;

    public interface b {
        void buC();
    }

    class a extends BaseAdapter {

        class a {
            TextView qTF;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            return NotInterestMenu.qTB.length;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(NotInterestMenu.qTB[i]);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = v.fw(NotInterestMenu.this.mContext).inflate(g.qMG, viewGroup, false);
                a aVar = new a();
                aVar.qTF = (TextView) view.findViewById(f.qIZ);
                view.setTag(aVar);
            }
            ((a) view.getTag()).qTF.setText(NotInterestMenu.qTB[i]);
            return view;
        }
    }

    public interface c {
        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    public NotInterestMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        v.fw(this.mContext).inflate(g.qMF, this);
        this.qTA = (ListView) findViewById(f.qIY);
        this.qTA.setAdapter(new a());
        this.qTA.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (NotInterestMenu.this.qTD != null) {
                    NotInterestMenu.this.qTD.buC();
                }
                if (NotInterestMenu.this.qTC != null) {
                    switch (i) {
                        case 0:
                            NotInterestMenu.this.qTC.c(NotInterestMenu.this.qEj);
                            return;
                        case 1:
                            NotInterestMenu.this.qTC.d(NotInterestMenu.this.qEj);
                            return;
                        case 2:
                            NotInterestMenu.this.qTC.e(NotInterestMenu.this.qEj);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
