package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView Fv;
    private MRecyclerView jRE;

    private static class b extends BaseAdapter {
        private LayoutInflater DF;

        public b(LayoutInflater layoutInflater) {
            this.DF = layoutInflater;
        }

        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final t a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(t tVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    protected final int getLayoutId() {
        return h.izG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Fv = (ListView) findViewById(g.iym);
        this.jRE = (MRecyclerView) findViewById(g.iyg);
        this.Fv.setAdapter(new b(getLayoutInflater()));
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.jRE.a(new LinearLayoutManager(1, false));
        this.jRE.a(new a());
        this.jRE.addHeaderView(getLayoutInflater().inflate(h.izF, null));
    }
}
