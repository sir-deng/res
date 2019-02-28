package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingTranslateView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.y.bb;
import java.net.URLDecoder;

public final class f {

    public static class b extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 503316529) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddF);
            view.setTag(new a().q(view, true));
            return view;
        }

        protected final boolean r(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            return aVar.yxU;
        }

        private static String ZY(String str) {
            try {
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                if (fV != null) {
                    return URLDecoder.decode(fV.content, "UTF-8");
                }
            } catch (Exception e) {
                x.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e.getMessage());
            }
            return "";
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            String trim;
            CharSequence ZY;
            TextView textView;
            int type;
            Object csn;
            this.yyH = aVar2;
            a aVar3 = (a) aVar;
            String str2 = auVar.field_content;
            String str3 = aVar2.yAM.talker;
            aVar3.ySO.mN(true);
            if (aVar2.yxU && !aVar2.yEL.vus) {
                int hR = bb.hR(str2);
                if (hR != -1) {
                    trim = str2.substring(0, hR).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = str3;
                    }
                    str3 = trim;
                    trim = str2.substring(hR + 1).trim();
                    ZY = ZY(trim);
                    a((com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, aVar2, auVar, str3);
                    a((com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, aVar2, str3, auVar);
                    aVar3.ySN.setText(ZY);
                    textView = aVar3.ySN;
                    type = auVar.getType();
                    csn = aVar2.csn();
                    if (type != 301989937) {
                        i.a(textView, csn);
                    }
                    textView.getText();
                    aVar3.ySN.setTag(ar.b(auVar, aVar2.yxU, i));
                    aVar3.ySN.setOnLongClickListener(s(aVar2));
                    aVar3.ySN.yFI = aVar2.yAM.yBE;
                }
            }
            trim = str2;
            ZY = ZY(trim);
            a((com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, aVar2, auVar, str3);
            a((com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, aVar2, str3, auVar);
            aVar3.ySN.setText(ZY);
            textView = aVar3.ySN;
            type = auVar.getType();
            csn = aVar2.csn();
            if (type != 301989937) {
                i.a(textView, csn);
            }
            textView.getText();
            aVar3.ySN.setTag(ar.b(auVar, aVar2.yxU, i));
            aVar3.ySN.setOnLongClickListener(s(aVar2));
            aVar3.ySN.yFI = aVar2.yAM.yBE;
        }

        protected final boolean cwl() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRS));
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    public static class c extends b {
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 503316529) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.dei);
            view.setTag(new a().q(view, false));
            return view;
        }

        private static String ZY(String str) {
            try {
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(str);
                if (fV != null) {
                    return URLDecoder.decode(fV.content, "UTF-8");
                }
            } catch (Exception e) {
                x.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e.getMessage());
            }
            return "";
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            int i2 = 8;
            this.yyH = aVar2;
            a aVar3 = (a) aVar;
            if (b.cwm()) {
                if (aVar3.pyj != null) {
                    aVar3.pyj.setVisibility(8);
                }
                if (auVar.field_status == 1 || auVar.field_status == 5) {
                    if (aVar3.yRZ != null) {
                        aVar3.yRZ.setVisibility(8);
                    }
                    aVar3.ySN.setBackgroundResource(R.g.bBv);
                    auVar.xHD = true;
                } else {
                    aVar3.ySN.setBackgroundResource(R.g.bBu);
                    if (aVar3.yRZ != null) {
                        if (b.a(aVar2.yAM, auVar.field_msgId)) {
                            if (auVar.xHD) {
                                Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                aVar3.ySN.startAnimation(alphaAnimation);
                                auVar.xHD = false;
                            }
                            aVar3.yRZ.setVisibility(0);
                        } else {
                            aVar3.yRZ.setVisibility(8);
                        }
                    }
                }
            } else if (aVar3.pyj != null) {
                ProgressBar progressBar = aVar3.pyj;
                if (auVar.field_status < 2) {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
            }
            CharSequence ZY = ZY(auVar.field_content);
            if (bi.oN(ZY)) {
                x.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
            }
            aVar3.ySO.mN(true);
            aVar3.ySN.setMinWidth(0);
            aVar3.ySN.setText(ZY);
            TextView textView = aVar3.ySN;
            int type = auVar.getType();
            Object csn = aVar2.csn();
            if (type != 301989937) {
                i.a(textView, csn);
            }
            textView.getText();
            aVar3.ySN.setTag(ar.b(auVar, aVar2.yxU, i));
            aVar3.ySN.setOnLongClickListener(s(aVar2));
            aVar3.ySN.yFI = aVar2.yAM.yBE;
            a(i, (com.tencent.mm.ui.chatting.viewitems.b.a) aVar3, auVar, aVar2.yAM.hnt, aVar2.yxU, aVar2);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            contextMenu.add(((ar) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dRS));
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }
    }

    static final class a extends com.tencent.mm.ui.chatting.viewitems.b.a {
        View mcj;
        ImageView yRZ;
        MMTextView ySN;
        ChattingTranslateView ySO;

        a() {
        }

        public final com.tencent.mm.ui.chatting.viewitems.b.a q(View view, boolean z) {
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.ySN = (MMTextView) view.findViewById(R.h.bTJ);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.mcj = view.findViewById(R.h.bTH);
            this.ySO = (ChattingTranslateView) view.findViewById(R.h.bVk);
            if (!z) {
                this.yRZ = (ImageView) view.findViewById(R.h.bVf);
                this.yRo = (ImageView) view.findViewById(R.h.bVd);
                this.pyj = (ProgressBar) view.findViewById(R.h.cUg);
            }
            return this;
        }
    }
}
