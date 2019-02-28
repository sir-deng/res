package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView lIk;
    private List<f> xVl;
    private a zuN;

    private static class a extends ArrayAdapter<f> {
        private List<f> lzC;
        private Context mContext;

        static class a {
            TextView ikL;
            ImageView jIs;
            View lzD;
            ImageView lzE;
            MMSwitchBtn tWk;

            public a(View view) {
                this.lzE = (ImageView) view.findViewById(R.h.coH);
                this.jIs = (ImageView) view.findViewById(R.h.coM);
                this.ikL = (TextView) view.findViewById(R.h.cSn);
                this.tWk = (MMSwitchBtn) view.findViewById(R.h.cQc);
                this.lzD = view.findViewById(R.h.bYH);
            }
        }

        public a(Context context, List<f> list) {
            super(context, R.i.doz, list);
            this.mContext = context;
            this.lzC = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.doz, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ikL.setText(((f) getItem(i)).field_appName);
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return R.i.doy;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MoreShareAppUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.eas), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.zuN = new a(this, this.xVl);
        this.lIk.setAdapter(this.zuN);
    }

    protected final void initView() {
        setMMTitle(R.l.dNm);
        this.lIk = (DragSortListView) findViewById(R.h.ctk);
        this.lIk.zAF = new g() {
            public final void cu(int i, int i2) {
                f fVar = (f) MoreShareAppUI.this.zuN.getItem(i);
                MoreShareAppUI.this.zuN.lzC.remove(i);
                MoreShareAppUI.this.zuN.notifyDataSetChanged();
                MoreShareAppUI.this.zuN.insert(fVar, i2);
            }
        };
    }
}
