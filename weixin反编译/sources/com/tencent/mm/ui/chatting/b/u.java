package com.tencent.mm.ui.chatting.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.g.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;

public final class u {
    public p fhH;
    public p liK = null;
    public boolean yAH = false;
    public com.tencent.mm.ui.chatting.u yCy;
    private int yJA = 0;
    public boolean yJB = false;
    public boolean yJC = false;
    public View yJo;
    public boolean yJp = false;
    public boolean yJq = false;
    public boolean yJr = false;
    public long yJs = -1;
    public ArrayList<String> yJt;
    public boolean yJu = false;
    public TextView yJv;
    public ListView yJw;
    public View yJx;
    public boolean yJy = false;
    private boolean yJz = true;

    /* renamed from: com.tencent.mm.ui.chatting.b.u$12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ int keR;
        final /* synthetic */ long val$position;

        public AnonymousClass12(long j, int i) {
            this.val$position = j;
            this.keR = i;
        }

        public final void run() {
            x.i("MicroMsg.ChattingUI.SearchImp", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", Long.valueOf(this.val$position), Integer.valueOf(this.keR));
            t.a(u.this.fhH.ctl(), this.keR, false);
            if (u.this.yJB && !u.this.yJr) {
                new ag().postDelayed(new Runnable(this.keR, this.val$position) {
                    public final void run() {
                        int firstVisiblePosition = r5 - u.this.fhH.ctl().getFirstVisiblePosition();
                        View childAt = u.this.fhH.ctl().getChildAt(firstVisiblePosition);
                        View childAt2 = u.this.fhH.ctl().getChildAt(firstVisiblePosition + u.this.fhH.ctl().getHeaderViewsCount());
                        as.Hm();
                        au dI = c.Fh().dI(r6);
                        View view = null;
                        if (childAt != null) {
                            if (dI.cjT() || dI.cjW()) {
                                view = childAt.findViewById(R.h.bTK);
                            } else if (dI.cjX()) {
                                view = childAt.findViewById(R.h.image);
                            } else if (dI.ckb()) {
                                view = childAt.findViewById(R.h.bTq);
                            }
                            if (view == null && childAt2 != null) {
                                if (dI.cjT() || dI.cjW()) {
                                    view = childAt2.findViewById(R.h.bTK);
                                } else if (dI.cjX()) {
                                    view = childAt2.findViewById(R.h.image);
                                }
                            }
                            if (view != null) {
                                a.b(u.this.fhH.cte().getContext(), view);
                            }
                        }
                    }
                }, 200);
                as.Hm();
                c.Db().a(w.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.u$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ int keR;
        final /* synthetic */ long val$position;

        public AnonymousClass11(long j, int i) {
            this.val$position = j;
            this.keR = i;
        }

        public final void run() {
            u.this.fhH.ctl().postDelayed(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ChattingUI.SearchImp", "if (isShowSearchChatResult || isFromGlobalSearch) on set position %d, set selection %d", Long.valueOf(AnonymousClass11.this.val$position), Integer.valueOf(AnonymousClass11.this.keR));
                    t.a(u.this.fhH.ctl(), AnonymousClass11.this.keR, false);
                    if (u.this.yJB && !u.this.yJr) {
                        new ag().postDelayed(/* anonymous class already generated */, 200);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
                    }
                }
            }, 100);
        }
    }

    public u(p pVar) {
        this.fhH = pVar;
    }

    public final boolean ge(long j) {
        if (this.yJs != j || !this.yJr || this.yJt == null || this.yJt.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void cuI() {
        String str = "MicroMsg.ChattingUI.SearchImp";
        String str2 = "enter edit search mode, search stub view is null?%B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yJo == null);
        x.v(str, str2, objArr);
        this.yJy = true;
        this.fhH.ctl().setVisibility(8);
        if (this.yJo != null) {
            this.yJo.setVisibility(0);
        } else {
            g.a(this.fhH.cte(), R.h.cJz);
            this.yJo = this.fhH.cte().findViewById(R.h.cJE);
            this.yJo.setVisibility(0);
            this.yJx = this.fhH.cte().findViewById(R.h.cJx);
            this.fhH.ctl().setFocusable(false);
            this.fhH.ctl().setFocusableInTouchMode(false);
            this.yJx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.yJx.setVisibility(8);
            this.yJv = (TextView) this.fhH.cte().findViewById(R.h.ceq);
            this.yCy = new com.tencent.mm.ui.chatting.u(this.fhH.cte().getContext(), new au(), this.fhH.csn(), this.fhH.ctj(), this.fhH.csR());
            this.yCy.yDg = new com.tencent.mm.ui.chatting.u.a() {
                public final void FQ(int i) {
                    u.this.FY(i);
                }
            };
            this.yJw = (ListView) this.fhH.cte().findViewById(R.h.cJy);
            this.yJw.setVisibility(0);
            this.yJw.setAdapter(this.yCy);
            this.yJw.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                    au auVar = (au) u.this.yCy.getItem(i);
                    if (auVar != null && !bi.oN(auVar.field_talker)) {
                        u.this.cuJ();
                        if (u.this.fhH.cto() != null) {
                            s cto = u.this.fhH.cto();
                            if (auVar == null) {
                                x.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
                            } else if (cto.yAE.fX(auVar.field_msgId)) {
                                cto.yCx.FN(cto.yAE.yBX.size());
                                cto.yCx.setVisibility(0);
                                cto.liK.cyP();
                            }
                        }
                        if (!u.this.yJu) {
                            u.this.yJu = true;
                            u.this.fhH.ctn().mv(true);
                            u.this.fhH.ctl().setTranscriptMode(0);
                        }
                        u.this.fhH.ctn().mt(false);
                        u.this.fhH.ctn().mu(false);
                        final int r = u.this.fhH.ctm().r(auVar.field_msgId, false);
                        u.this.fhH.ctm().a(null, null);
                        u.this.fhH.ctl().post(new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.ChattingUI.SearchImp", "on search click, click position %d, set selection %d", Integer.valueOf(i), Integer.valueOf(r));
                                t.a(u.this.fhH.ctl(), r, false);
                            }
                        });
                    }
                }
            });
            this.yJw.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    u.this.fhH.cte().hideVKB();
                    return false;
                }
            });
            if (this.fhH.cto() != null) {
                this.fhH.cto().yCy = this.yCy;
            }
        }
        FY(-1);
    }

    public final void cuJ() {
        x.v("MicroMsg.ChattingUI.SearchImp", "exit edit search mode");
        this.yJy = false;
        this.yJz = true;
        if (this.yJv != null) {
            this.yJv.setVisibility(8);
        }
        if (this.yJx != null) {
            this.yJx.setVisibility(8);
        }
        if (this.yJw != null) {
            this.yJw.setVisibility(8);
        }
        this.fhH.ctl().setVisibility(0);
        this.fhH.cte().hideVKB();
    }

    public final void FY(int i) {
        x.v("MicroMsg.ChattingUI.SearchImp", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i), Boolean.valueOf(this.yJy), Boolean.valueOf(this.yJz));
        if (this.yJp || this.yJy) {
            if (this.yJz && i >= 0) {
                this.yJz = false;
                g.pWK.h(10811, Integer.valueOf(2));
            }
            if (i > 0) {
                this.yJw.setVisibility(0);
                this.fhH.ctl().setVisibility(8);
                this.yJv.setVisibility(8);
                this.yJx.setVisibility(8);
                return;
            } else if (i == 0) {
                this.yJw.setVisibility(8);
                this.fhH.ctl().setVisibility(8);
                this.yJv.setVisibility(0);
                this.yJx.setVisibility(8);
                return;
            } else {
                this.yJw.setVisibility(8);
                this.fhH.ctl().setVisibility(0);
                this.yJv.setVisibility(8);
                this.yJx.setVisibility(0);
                return;
            }
        }
        x.d("MicroMsg.ChattingUI.SearchImp", "not search now");
    }
}
