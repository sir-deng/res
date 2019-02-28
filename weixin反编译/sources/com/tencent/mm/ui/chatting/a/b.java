package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b extends android.support.v7.widget.RecyclerView.a {
    public static e yHc;
    public static f yHd = null;
    private Context mContext;
    public String yHe;

    public static class a extends t {
        public ImageView ikK;
        public TextView ikL;
        public TextView ljv;
        public TextView lmk;
        public View nav;

        public a(View view) {
            super(view);
            this.nav = view;
            this.ikK = (ImageView) view.findViewById(R.h.cgj);
            this.lmk = (TextView) view.findViewById(R.h.cgT);
            this.ljv = (TextView) view.findViewById(R.h.chp);
            this.ikL = (TextView) view.findViewById(R.h.chq);
            this.ikL.setSingleLine(false);
            this.ikL.setMaxLines(2);
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (b.yHc != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.yHc.a(intValue, b.yHd.FW(intValue));
                    }
                }
            });
            view.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (b.yHc != null) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b.yHc.a(view, intValue, b.yHd.FW(intValue));
                    }
                    return true;
                }
            });
        }

        public static void d(TextView textView, String str) {
            if (!bi.oN(str)) {
                textView.getContext();
                textView.setText(com.tencent.mm.bb.b.a(textView.getText(), str));
            }
        }
    }

    public static abstract class b {
        public String bgp;
        public String fqG;
        public long frh;
        public String jXs;
        public long timestamp;
        public String title;
        public int type;
        public String username;
        Pattern yHg = Pattern.compile("[._a-zA-Z0-9]+");

        public b(long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.timestamp = j;
            this.type = i;
            this.title = str;
            this.frh = j2;
            this.username = str2;
            this.fqG = str3;
            this.bgp = str4;
            this.jXs = str5;
        }

        public int getType() {
            return this.type;
        }

        public boolean ZM(String str) {
            if (ZN(str)) {
                if (!bi.oN(this.title) && this.title.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oN(this.fqG) && this.fqG.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oN(this.jXs) && this.jXs.toLowerCase().contains(str)) {
                    return true;
                }
                if (!bi.oN(this.bgp) && this.bgp.toLowerCase().contains(str)) {
                    return true;
                }
            } else if (!bi.oN(this.title) && fT(str, this.title.toLowerCase())) {
                return true;
            } else {
                if (!bi.oN(this.fqG) && fT(str, this.fqG.toLowerCase())) {
                    return true;
                }
                if (!bi.oN(this.jXs) && fT(str, this.jXs.toLowerCase())) {
                    return true;
                }
                if (!bi.oN(this.bgp) && fT(str, this.bgp.toLowerCase())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean fT(String str, String str2) {
            if (bi.oN(str2)) {
                return false;
            }
            Matcher matcher = this.yHg.matcher(str2);
            boolean z = false;
            while (matcher.find()) {
                z = matcher.group().startsWith(str);
                x.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", str, r3);
                if (z) {
                    return z;
                }
            }
            return z;
        }

        public static boolean ZN(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (toCharArray[i] >= 19968 && toCharArray[i] <= 40891) {
                    return true;
                }
                i++;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return super.equals(obj);
            }
            return this.frh == ((b) obj).frh;
        }
    }

    public class d extends t {
        TextView iko;

        public d(View view) {
            super(view);
            this.iko = (TextView) view.findViewById(R.h.caq);
            this.iko.setTextColor(b.this.mContext.getResources().getColor(R.e.bsm));
            view.findViewById(R.h.content).setBackgroundColor(b.this.mContext.getResources().getColor(R.e.bsl));
        }
    }

    public interface f {
        b FW(int i);

        void a(a aVar, int i);

        int getCount();

        t l(ViewGroup viewGroup);
    }

    public static class c extends b {
        public c(long j) {
            this.timestamp = j;
        }

        public final boolean ZM(String str) {
            return false;
        }

        public final int getType() {
            return Integer.MAX_VALUE;
        }
    }

    public interface e {
        void a(int i, b bVar);

        void a(View view, int i, b bVar);
    }

    public b(Context context, f fVar) {
        yHd = fVar;
        this.mContext = context;
    }

    public final int getItemViewType(int i) {
        return yHd.FW(i).getType();
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.i.djv, viewGroup, false));
        }
        return yHd.l(viewGroup);
    }

    public final void a(t tVar, int i) {
        int itemViewType = getItemViewType(i);
        b FW = yHd.FW(i);
        if (itemViewType == Integer.MAX_VALUE) {
            b FW2 = yHd.FW(i + 1);
            if (i == getItemCount() - 1 || gd(FW2.timestamp) != gd(FW.timestamp)) {
                ((d) tVar).iko.setVisibility(8);
                return;
            }
            ((d) tVar).iko.setVisibility(0);
            ((d) tVar).iko.setText(com.tencent.mm.ui.gridviewheaders.a.cyc().a(new Date(FW.timestamp), this.mContext));
            return;
        }
        a aVar = (a) tVar;
        aVar.nav.setTag(Integer.valueOf(i));
        if (itemViewType != 33) {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ikK, FW.username);
        }
        TextView textView = aVar.lmk;
        Context context = this.mContext;
        CharSequence charSequence = bi.oN(this.yHe) ? bi.oN(FW.bgp) ? bi.oN(FW.jXs) ? FW.fqG : FW.jXs : FW.bgp : bi.oN(FW.bgp) ? !bi.oN(FW.jXs) ? (bi.oN(FW.fqG) || !FW.fqG.contains(this.yHe)) ? FW.jXs : FW.jXs + "(" + FW.fqG + ")" : FW.fqG : (bi.oN(FW.jXs) || !FW.jXs.contains(this.yHe)) ? (bi.oN(FW.fqG) || !FW.fqG.contains(this.yHe)) ? FW.bgp : FW.bgp + "(" + FW.fqG + ")" : FW.bgp + "(" + FW.jXs + ")";
        textView.setText(i.b(context, charSequence, aVar.lmk.getTextSize()));
        aVar.ljv.setText(g.e(this.mContext, FW.timestamp));
        aVar.ikL.setText(FW.title);
        yHd.a((a) tVar, i);
        if (!bi.oN(this.yHe)) {
            a.d(aVar.lmk, this.yHe);
            a.d(aVar.ikL, this.yHe);
        }
    }

    public final int getItemCount() {
        boolean z;
        int count = yHd == null ? 0 : yHd.getCount();
        String str = "MicroMsg.MediaHistoryListAdapter";
        String str2 = " null == mIDetail?%s getItemCount:%s";
        Object[] objArr = new Object[2];
        if (yHd == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(count);
        x.i(str, str2, objArr);
        return count;
    }

    private static long gd(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.cyc().b(new Date(j));
    }
}
