package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m {
    private View Iv;
    private OnItemClickListener XC = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            EmojiInfo pg = m.this.vyw == null ? null : m.this.vyw.pg(i);
            if (!(pg == null || m.this.vyr == null || m.this.vxc == null)) {
                m.this.vyr.l(pg);
                m.this.vxc.clear();
                g.pWK.h(10994, Integer.valueOf(1), m.this.vys, "", Integer.valueOf(i), pg.Nx(), Integer.valueOf(m.this.vyw.getCount()));
            }
            m.this.vyp.dismiss();
        }
    };
    private int kjA = 3;
    ArrayList<EmojiInfo> lJz = new ArrayList();
    Context mContext;
    ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            int i = 0;
            switch (message.what) {
                case CdnLogic.kMediaTypeBackupFile /*20001*/:
                    m.this.hide();
                    return;
                case 20002:
                    removeMessages(CdnLogic.kMediaTypeBackupFile);
                    return;
                case 20003:
                    m mVar = m.this;
                    mVar.mHandler.removeMessages(CdnLogic.kMediaTypeBackupFile);
                    if (mVar.vyu) {
                        b bVar = mVar.vyw;
                        bVar.mData = mVar.lJz;
                        bVar.notifyDataSetInvalidated();
                        if (mVar.lJz != null && mVar.lJz.size() > 2) {
                            mVar.vyp.setWidth(((int) (((double) mVar.vyn) * 2.5d)) + (mVar.vyo * 2));
                        } else if (mVar.lJz == null || mVar.lJz.size() != 2) {
                            mVar.vyp.setWidth(mVar.vyn + (mVar.vyo * 2));
                        } else {
                            mVar.vyp.setWidth((mVar.vyn * 2) + (mVar.vyo * 2));
                        }
                        mVar.ccO();
                        if (mVar.lJz == null || mVar.lJz.size() < 3) {
                            mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                        } else {
                            mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 5000);
                        }
                        g gVar = g.pWK;
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = mVar.vys;
                        objArr[2] = "";
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = "";
                        if (mVar.lJz != null) {
                            i = mVar.lJz.size();
                        }
                        objArr[5] = Integer.valueOf(i);
                        gVar.h(10994, objArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    a vxc;
    int vyn;
    int vyo;
    q vyp;
    View vyq;
    j vyr;
    String vys;
    public String vyt = "";
    public boolean vyu = true;
    private HorizontalListView vyv;
    b vyw;
    private boolean vyx = true;
    private Comparator vyy = new Comparator<EmojiInfo>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            EmojiInfo emojiInfo = (EmojiInfo) obj;
            EmojiInfo emojiInfo2 = (EmojiInfo) obj2;
            if (emojiInfo == null && emojiInfo2 == null) {
                return 0;
            }
            if (emojiInfo != null) {
                if (emojiInfo2 == null) {
                    return 1;
                }
                if (emojiInfo.field_lastUseTime == emojiInfo2.field_lastUseTime) {
                    return 0;
                }
                if (emojiInfo.field_lastUseTime > emojiInfo2.field_lastUseTime) {
                    return 1;
                }
            }
            return -1;
        }
    };
    private com.tencent.mm.ui.base.HorizontalListView.a vyz = new com.tencent.mm.ui.base.HorizontalListView.a() {
        public final boolean q(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    m.this.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    m.this.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                    break;
            }
            return false;
        }
    };

    class b extends BaseAdapter {
        ArrayList<EmojiInfo> mData;

        b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            return pg(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final EmojiInfo pg(int i) {
            if (this.mData == null || this.mData.size() <= i) {
                return null;
            }
            return (EmojiInfo) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(m.this.mContext).inflate(f.lPj, null);
                c cVar2 = new c(view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            EmojiInfo pg = pg(i);
            cVar.lFZ.hX = m.this.vyn;
            cVar.lFZ.setScaleType(ScaleType.CENTER_INSIDE);
            CharSequence charSequence = "";
            if (pg != null) {
                charSequence = ((PluginEmoji) com.tencent.mm.kernel.g.k(PluginEmoji.class)).getEmojiMgr().yF(pg.Nx());
            }
            if (bi.oN(charSequence)) {
                cVar.lFZ.setContentDescription(m.this.mContext.getString(h.ebl));
            } else {
                cVar.lFZ.setContentDescription(charSequence);
            }
            if (pg == null) {
                x.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
            } else if (pg.clk()) {
                cVar.lFZ.a(EmojiInfo.bk(m.this.mContext, pg.getName()), pg.getName());
            } else {
                cVar.lFZ.a(pg, "");
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String hON;

        public AnonymousClass6(String str) {
            this.hON = str;
        }

        public final void run() {
            if (m.this.ch(this.hON)) {
                m.this.mHandler.sendEmptyMessage(20003);
                return;
            }
            m.this.mHandler.removeMessages(20003);
            m.this.mHandler.sendEmptyMessage(CdnLogic.kMediaTypeBackupFile);
        }
    }

    class c {
        PreViewEmojiView lFZ;

        public c(View view) {
            this.lFZ = (PreViewEmojiView) view.findViewById(e.lPg);
            this.lFZ.hX = m.this.vyn;
        }
    }

    public interface a {
        void clear();
    }

    public m(Context context) {
        this.mContext = context;
        this.Iv = View.inflate(this.mContext, f.lPi, null);
        this.vyv = (HorizontalListView) this.Iv.findViewById(e.lPh);
        this.vyw = new b();
        this.vyv.setAdapter(this.vyw);
        this.vyv.setOnItemClickListener(this.XC);
        this.vyv.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.vyv.vyz = this.vyz;
        this.vyn = com.tencent.mm.bu.a.aa(this.mContext, com.tencent.mm.plugin.m.a.c.lOG);
        this.vyo = com.tencent.mm.bu.a.aa(this.mContext, com.tencent.mm.plugin.m.a.c.bvC);
        this.vyp = new q(this.Iv, this.vyn + (this.vyo * 2), this.vyn + (this.vyo * 2), true);
        this.vyp.setBackgroundDrawable(new ColorDrawable(0));
        this.vyp.setOutsideTouchable(true);
        this.vyp.setFocusable(false);
    }

    public final void ccO() {
        if (this.vyq != null) {
            int[] iArr = new int[2];
            this.vyq.getLocationOnScreen(iArr);
            this.vyp.showAtLocation(this.vyq, 0, iArr[0] - ((this.vyp.getWidth() - this.vyq.getWidth()) / 2), iArr[1] - this.vyp.getHeight());
        }
    }

    public final void hide() {
        if (this.vyp != null && this.vyp.isShowing()) {
            this.vyp.dismiss();
        }
    }

    public final boolean ch(String str) {
        try {
            if (!bi.oN(str)) {
                ArrayList yM = ((PluginEmoji) com.tencent.mm.kernel.g.k(PluginEmoji.class)).getEmojiMgr().yM(str);
                if (!(yM == null || yM.isEmpty())) {
                    this.vys = str.replaceAll(",", "");
                    if (yM == null || yM.isEmpty()) {
                        return false;
                    }
                    EmojiInfo yI;
                    ArrayList arrayList = new ArrayList();
                    this.lJz.clear();
                    int size = yM.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        yI = ((PluginEmoji) com.tencent.mm.kernel.g.k(PluginEmoji.class)).getEmojiMgr().yI((String) yM.get(i));
                        if (yI != null) {
                            arrayList.add(yI);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        x.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        return false;
                    }
                    if (this.vyx) {
                        yI = (EmojiInfo) Collections.max(arrayList, this.vyy);
                        this.lJz.add(yI);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                            if (!(emojiInfo.cd(yI) || this.lJz.contains(emojiInfo))) {
                                this.lJz.add(emojiInfo);
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            yI = (EmojiInfo) it2.next();
                            if (!this.lJz.contains(yI)) {
                                this.lJz.add(yI);
                            }
                        }
                    }
                    return (this.lJz == null || this.lJz.isEmpty()) ? false : true;
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.SuggestEmoticonBubble", bi.i(e));
        }
        this.vys = "";
        return false;
    }
}
