package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

public final class d {

    static class a extends BaseAdapter {
        private final Context context;
        List<String> plg;
        int plh = -1;
        private final int style;

        public a(Context context) {
            this.context = context;
            this.style = 1;
        }

        public final int getCount() {
            return this.plg != null ? this.plg.size() : 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.context, g.gZv, null);
                b bVar = new b();
                bVar.pli = (TextView) view.findViewById(f.text);
                bVar.plj = (CheckBox) view.findViewById(f.gXa);
                bVar.plk = (RadioButton) view.findViewById(f.radio);
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            bVar2.pli.setText((CharSequence) this.plg.get(i));
            switch (this.style) {
                case 1:
                    bVar2.plj.setVisibility(8);
                    bVar2.plk.setVisibility(0);
                    bVar2.plk.setChecked(i == this.plh);
                    break;
                case 2:
                    bVar2.plj.setVisibility(0);
                    bVar2.plk.setVisibility(8);
                    CheckBox checkBox = bVar2.plj;
                    if (i != this.plh) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    break;
                default:
                    bVar2.plj.setVisibility(8);
                    bVar2.plk.setVisibility(8);
                    break;
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.d$1 */
    static class AnonymousClass1 implements OnItemClickListener {
        final /* synthetic */ OnItemClickListener ple;
        final /* synthetic */ a plf;

        AnonymousClass1(OnItemClickListener onItemClickListener, a aVar) {
            this.ple = onItemClickListener;
            this.plf = aVar;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.ple != null) {
                this.ple.onItemClick(adapterView, view, i, j);
            }
            this.plf.plh = i;
            this.plf.notifyDataSetChanged();
        }
    }

    static class b {
        TextView pli;
        CheckBox plj;
        RadioButton plk;

        b() {
        }
    }
}
