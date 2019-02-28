package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMHorList;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private ag mHandler;
    private String nZA;
    private final int nZm = com.tencent.mm.bu.a.fromDPToPix(null, 58);
    private final int siA = 5;
    private MMHorList siB;
    a siC;
    private al siD;
    private final int siz = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;

    private static class a extends BaseAdapter {
        private Context mContext;
        String nZA;
        List<String> siG = new LinkedList();

        class a {
            public ImageView ikK;
            public TextView kHt;

            a() {
            }
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.siG.size();
        }

        public final Object getItem(int i) {
            return this.siG.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String str = (String) this.siG.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dtg, null);
                a aVar2 = new a();
                aVar2.ikK = (ImageView) view.findViewById(R.h.crY);
                aVar2.kHt = (TextView) view.findViewById(R.h.cTw);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ikK.setBackgroundResource(str.equals(this.nZA) ? R.g.bGE : 0);
            aVar.kHt.setVisibility(8);
            b.b(aVar.ikK, str, true);
            return view;
        }
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.i.dtf, this);
        this.siB = (MMHorList) findViewById(R.h.coI);
        this.siB.ykp = true;
        this.siB.yko = true;
        this.siB.ykq = this.nZm;
        this.siC = new a(getContext());
        this.siB.setAdapter(this.siC);
        this.mHandler = new ag(Looper.getMainLooper());
        this.siB.yjZ = new com.tencent.mm.ui.base.MMHorList.a() {
            public final void bFK() {
                TalkRoomAvatarsFrame.this.siD.TN();
            }

            public final void bFL() {
                TalkRoomAvatarsFrame.this.siD.K(2000, 2000);
            }

            public final void aYc() {
                TalkRoomAvatarsFrame.this.mHandler.post(new Runnable() {
                    public final void run() {
                        TalkRoomAvatarsFrame.this.siC.notifyDataSetChanged();
                    }
                });
            }
        };
        this.siD = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                TalkRoomAvatarsFrame.this.aVL();
                return false;
            }
        }, false);
    }

    public final void MY(String str) {
        if (this.siB != null) {
            if (!bi.oN(this.nZA) || !bi.oN(str)) {
                if (bi.oN(this.nZA) || !this.nZA.equals(str)) {
                    this.nZA = str;
                    aVL();
                }
            }
        }
    }

    private void aVL() {
        this.siC.nZA = this.nZA;
        if (bi.oN(this.nZA)) {
            this.siC.notifyDataSetChanged();
        } else if (!this.siB.oSJ) {
            a aVar = this.siC;
            int indexOf = aVar.siG.indexOf(this.nZA) * this.nZm;
            int i = this.siB.ykc;
            if (indexOf < i) {
                this.siB.Fg(indexOf);
            } else if (indexOf > i + (this.nZm * 4)) {
                this.siB.Fg(indexOf - (this.nZm * 4));
            } else {
                this.siC.notifyDataSetChanged();
            }
        }
    }
}
