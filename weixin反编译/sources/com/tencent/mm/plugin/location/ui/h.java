package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    Context context;
    private String lis = "";
    private ag mHandler = new ag(Looper.getMainLooper());
    private boolean mIsInit = false;
    MMHorList nZk;
    a nZl;
    private int nZm;
    c nZn = null;

    public interface c {
        void Ep(String str);
    }

    class a extends BaseAdapter {
        ArrayList<b> nZq = new ArrayList();

        public a(ArrayList<b> arrayList) {
            this.nZq.addAll(arrayList);
        }

        public final int getCount() {
            return this.nZq.size();
        }

        public final Object getItem(int i) {
            return this.nZq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return ((b) this.nZq.get(i)).nZs.nZt;
        }

        public final b En(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nZq.size()) {
                    return null;
                }
                if (((b) this.nZq.get(i2)).username.equals(str)) {
                    return (b) this.nZq.get(i2);
                }
                i = i2 + 1;
            }
        }

        public final boolean Eo(String str) {
            for (int i = 0; i < this.nZq.size(); i++) {
                if (((b) this.nZq.get(i)).username.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public final ArrayList<String> aWx() {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = this.nZq.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).username);
            }
            return arrayList;
        }
    }

    class b {
        boolean nZr = false;
        a nZs;
        private LayoutParams nrC;
        String username;

        class a {
            ImageView ilM;
            RelativeLayout nZt;

            a() {
            }
        }

        public b(String str) {
            this.username = str;
            if (bi.oN(str)) {
                x.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                return;
            }
            this.nZs = new a();
            LayoutInflater layoutInflater = (LayoutInflater) h.this.context.getSystemService("layout_inflater");
            this.nZs.nZt = (RelativeLayout) layoutInflater.inflate(R.i.dmP, null);
            this.nZs.ilM = (ImageView) this.nZs.nZt.findViewById(R.h.bLD);
            com.tencent.mm.pluginsdk.ui.a.b.o(this.nZs.ilM, this.username);
            this.nZs.nZt.setTag(this.username);
            this.nrC = new LayoutParams(-2, -2);
            this.nrC.leftMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(h.this.context, 5.0f);
            this.nrC.rightMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(h.this.context, 5.0f);
            this.nrC.gravity = 17;
        }

        public final void aWy() {
            x.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", this.username);
            this.nZs.nZt.setBackgroundResource(R.g.bDy);
            this.nZs.nZt.invalidate();
            this.nZr = true;
        }

        public final void aWz() {
            x.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", this.username);
            this.nZs.nZt.setBackgroundResource(R.g.bDx);
            this.nZs.nZt.invalidate();
            this.nZr = false;
        }
    }

    public h(Context context, View view, String str) {
        this.context = context;
        this.nZk = (MMHorList) view;
        this.lis = str;
        aWv();
    }

    private void aWv() {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", Integer.valueOf(l.aWb().Eg(this.lis).size()));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!bi.oN(str)) {
                arrayList.add(new b(str));
                arrayList2.add(str);
            }
        }
        E(arrayList);
        F(arrayList2);
        this.nZk.invalidate();
        this.nZl.notifyDataSetChanged();
    }

    private void E(ArrayList<b> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nZr) {
                bVar.aWy();
            }
        }
        this.nZm = com.tencent.mm.bu.a.fromDPToPix(this.context, 60);
        this.nZk.ykp = true;
        this.nZk.ykq = this.nZm;
        this.nZk.yko = true;
        this.nZk.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) view.getTag();
                if (!bi.oN(str)) {
                    g.pWK.h(10997, "15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    if (h.this.nZn != null) {
                        h.this.nZn.Ep(str);
                    }
                }
            }
        });
        this.nZl = new a(arrayList);
        this.nZk.setAdapter(this.nZl);
    }

    private void Ek(String str) {
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", str);
        if (!this.nZl.Eo(str)) {
            b bVar = new b(str);
            a aVar = this.nZl;
            aVar.nZq.add(bVar);
            aVar.notifyDataSetChanged();
            this.nZk.invalidate();
        }
    }

    private void El(String str) {
        int i = 0;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", str);
        if (this.nZl.Eo(str)) {
            int i2;
            a aVar = this.nZl;
            while (true) {
                i2 = i;
                if (i2 >= aVar.nZq.size()) {
                    i2 = -1;
                    break;
                } else if (((b) aVar.nZq.get(i2)).username.equals(str)) {
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (i2 != -1) {
                aVar.nZq.remove(i2);
                aVar.notifyDataSetChanged();
            }
            this.nZk.invalidate();
        }
    }

    public final void Em(String str) {
        int i = 0;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", str);
        if (this.nZl.Eo(str)) {
            this.nZl.En(str).aWy();
            this.nZl.notifyDataSetChanged();
            this.nZk.invalidate();
            if (!this.nZk.oSJ && !bi.oN(str)) {
                a aVar = this.nZl;
                int i2 = 0;
                while (i2 < aVar.nZq.size()) {
                    if (((b) aVar.nZq.get(i2)).username.equals(str)) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", Integer.valueOf(i2));
                if (i2 != -1) {
                    int i3 = i2 * this.nZm;
                    int i4 = this.nZk.ykc;
                    if (i3 >= i4) {
                        i4 = i3 > i4 + (this.nZm * 3) ? i3 - (this.nZm * 3) : 0;
                    }
                    if (i2 != 0) {
                        i = i4;
                    }
                    this.mHandler.post(new Runnable() {
                        public final void run() {
                            x.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", Integer.valueOf(i));
                            h.this.nZk.Fg(i);
                        }
                    });
                }
            }
        }
    }

    public final void aWw() {
        a aVar = this.nZl;
        Iterator it = aVar.nZq.iterator();
        while (it.hasNext()) {
            ((b) it.next()).aWz();
        }
        aVar.notifyDataSetChanged();
        this.nZk.invalidate();
    }

    public final void F(ArrayList<String> arrayList) {
        String str;
        Iterator it;
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList aWx = this.nZl.aWx();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            if (aWx.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = aWx.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        x.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()));
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                Ek((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                El((String) it.next());
            }
        }
    }
}
