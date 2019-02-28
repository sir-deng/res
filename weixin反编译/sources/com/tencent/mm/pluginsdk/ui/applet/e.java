package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.a.j;
import com.tencent.mm.ap.o;
import com.tencent.mm.api.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a.c;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e implements o {

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.e$10 */
    static class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.applet.o.a vtT;
        final /* synthetic */ q vtU;
        final /* synthetic */ View zS;

        AnonymousClass10(com.tencent.mm.pluginsdk.ui.applet.o.a aVar, View view, q qVar) {
            this.vtT = aVar;
            this.zS = view;
            this.vtU = qVar;
        }

        public final void onClick(View view) {
            if (this.vtT != null) {
                this.vtT.a(true, e.cY(this.zS), e.cZ(this.zS));
            }
            this.vtU.dismiss();
            this.vtU.setFocusable(false);
            this.vtU.setTouchable(false);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.e$6 */
    static class AnonymousClass6 implements OnDismissListener {
        final /* synthetic */ Bitmap val$bmp;

        AnonymousClass6(Bitmap bitmap) {
            this.val$bmp = bitmap;
        }

        public final void onDismiss() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = r1.val$bmp;
            if (r0 == 0) goto L_0x000c;
        L_0x0004:
            r0 = r1.val$bmp;
            r0 = r0.isRecycled();
            if (r0 == 0) goto L_0x000c;
        L_0x000c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.e.6.onDismiss():void");
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.e$8 */
    static class AnonymousClass8 implements DialogInterface.OnDismissListener {
        final /* synthetic */ Bitmap val$bmp;

        AnonymousClass8(Bitmap bitmap) {
            this.val$bmp = bitmap;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.val$bmp != null && !this.val$bmp.isRecycled()) {
                this.val$bmp.recycle();
            }
        }
    }

    public static class a {
        public DialogInterface.OnDismissListener kbX;
        public Context mContext;
        public i pDT;
        public final com.tencent.mm.ui.base.i.a vtY;
        String vtZ = null;

        public a(Context context) {
            this.mContext = context;
            this.vtY = new com.tencent.mm.ui.base.i.a(this.mContext);
            this.vtY.mp(false);
            this.vtY.mq(false);
            this.vtY.a(new c() {
                public final CharSequence a(CharSequence charSequence, float f) {
                    return ((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(a.this.mContext, charSequence, f);
                }
            });
        }

        public final a bT(Object obj) {
            e.a(this.mContext, this.vtY, obj);
            this.vtY.mo(true);
            return this;
        }

        public final a cbE() {
            this.vtY.yhY.yfP = 2;
            return this;
        }

        public final a SU(String str) {
            int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.bu.a.ev(this.mContext)));
            if (!bi.oN(str)) {
                this.vtY.R(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, str.toString(), (float) fromDPToPix));
            }
            return this;
        }

        public final a SV(String str) {
            this.vtY.yhY.fwx = str;
            return this;
        }

        public final a cbF() {
            this.vtY.yhY.yfS = 8;
            return this;
        }

        public final a a(Bitmap bitmap, int i) {
            this.vtY.a(bitmap, true, i);
            this.vtY.mo(false);
            this.vtY.a(new AnonymousClass8(bitmap));
            return this;
        }

        public final a SW(String str) {
            Context context = this.mContext;
            com.tencent.mm.ui.base.i.a aVar = this.vtY;
            View inflate = v.fw(context).inflate(R.i.dnt, null);
            MMAnimateView mMAnimateView = (MMAnimateView) inflate.findViewById(R.h.ccb);
            if (mMAnimateView == null) {
                x.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
            } else if (bi.oN(str)) {
                x.e("MicroMsg.MMConfirmDialog", "Error , emoji msg path is null !!");
            } else {
                EmojiInfo yI = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yI(str);
                if (str.indexOf(File.separatorChar) == -1) {
                    d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                    com.tencent.mm.plugin.emoji.d.aAT();
                    str = emojiMgr.cr("", str);
                }
                if (yI == null || (yI.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                    mMAnimateView.CV(str);
                } else {
                    mMAnimateView.g(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(yI), "");
                }
                aVar.dk(inflate);
                aVar.EU(1);
            }
            this.vtY.mo(false);
            return this;
        }

        public final a a(com.tencent.mm.ui.base.i.a.a aVar) {
            this.vtY.yhY.yfy = aVar;
            return this;
        }

        public final a da(View view) {
            this.vtY.dk(view);
            return this;
        }

        public final a f(Boolean bool) {
            this.vtY.yhY.yfr = bool.booleanValue();
            if (bool.booleanValue()) {
                this.vtY.Zo(this.mContext.getString(R.l.dUm));
            }
            return this;
        }

        public final a SX(String str) {
            this.vtY.Zo(str);
            return this;
        }

        public final a cbG() {
            this.vtY.mo(false);
            return this;
        }

        public final a Co(int i) {
            this.vtZ = this.mContext.getResources().getString(i);
            return this;
        }

        public final a a(com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
            this.pDT = this.vtY.ale();
            if (this.kbX != null) {
                this.pDT.setOnDismissListener(this.kbX);
            }
            e.a(this.mContext, this.pDT, this.vtZ, null, aVar, aVar);
            return this;
        }
    }

    static /* synthetic */ String cY(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bWW);
        return editText == null ? null : editText.getText().toString();
    }

    static /* synthetic */ int cZ(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bWW);
        return editText instanceof PasterEditText ? ((PasterEditText) editText).bBC() : 0;
    }

    static void a(Context context, com.tencent.mm.ui.base.i.a aVar, Object obj) {
        if (obj != null) {
            List F;
            if (obj instanceof String) {
                F = bi.F(((String) obj).split(","));
            } else if (obj instanceof List) {
                F = (List) obj;
            } else {
                F = null;
            }
            if (!bi.cC(F)) {
                if (F.size() == 1) {
                    final String str = (String) F.get(0);
                    int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bu.a.ev(context)));
                    aVar.Q(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, context.getString(R.l.eER).toString(), (float) fromDPToPix));
                    String gw = ((b) g.h(b.class)).gw(str);
                    int fromDPToPix2 = com.tencent.mm.bu.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bu.a.ev(context)));
                    if (s.eX(str)) {
                        CharSequence a = ((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, (gw + context.getString(R.l.eJv, new Object[]{Integer.valueOf(((com.tencent.mm.plugin.chatroom.b.a) g.h(com.tencent.mm.plugin.chatroom.b.a.class)).gn(str))})).toString(), (float) fromDPToPix2);
                        final View inflate = v.fw(context).inflate(R.i.dfB, null);
                        GridView gridView = (GridView) inflate.findViewById(R.h.bSF);
                        final List arrayList = new ArrayList();
                        final List gl = ((com.tencent.mm.plugin.chatroom.b.a) g.h(com.tencent.mm.plugin.chatroom.b.a.class)).gl(str);
                        aVar.a(str, a, Boolean.valueOf(true), new com.tencent.mm.ui.base.i.a.b() {
                            public final void cbD() {
                                bi.hideVKB(inflate);
                                if (arrayList.size() == 0 && !bi.oN(str)) {
                                    ArrayList arrayList = arrayList;
                                    List<String> list = gl;
                                    if (!bi.cC(list)) {
                                        for (String gw : list) {
                                            arrayList.add(((b) g.h(b.class)).gw(gw));
                                        }
                                    }
                                }
                            }
                        });
                        gridView.setAdapter(new j(context, gl, arrayList));
                        gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.e.transparent)));
                        if (gl != null) {
                            if (gl.size() > 16) {
                                gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bu.a.aa(context, R.f.buL)));
                                gridView.setPadding(com.tencent.mm.bu.a.aa(context, R.f.buK), 0, com.tencent.mm.bu.a.aa(context, R.f.buK), 0);
                            } else {
                                gridView.setPadding(0, 0, 0, com.tencent.mm.bu.a.aa(context, R.f.buJ));
                            }
                        }
                        aVar.yhY.yfN = inflate;
                        return;
                    }
                    aVar.a(str, ((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).a(context, gw.toString(), (float) fromDPToPix2), Boolean.valueOf(false), null);
                    return;
                }
                aVar.yhY.yft = F;
                aVar.Zm(context.getString(R.l.ewc));
            }
        }
    }

    static void a(Context context, final i iVar, String str, String str2, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar2) {
        CharSequence str3;
        CharSequence str22;
        if (bi.oN(str3) || str3.length() == 0) {
            str3 = context.getResources().getString(R.l.dUp);
        }
        if (bi.oN(str22) || str22.length() == 0) {
            str22 = context.getResources().getString(R.l.dEy);
        }
        iVar.a(str3, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                iVar.dismiss();
                if (aVar != null) {
                    com.tencent.mm.pluginsdk.ui.applet.o.a aVar = aVar;
                    String cpG = iVar.cpG();
                    i iVar = iVar;
                    aVar.a(true, cpG, iVar.kT instanceof PasterEditText ? ((PasterEditText) iVar.kT).bBC() : 0);
                }
            }
        });
        iVar.b(str22, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                iVar.dismiss();
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    public static i a(p pVar, String str, String str2, String str3, String str4, boolean z, String str5, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(pVar.xRr, R.i.deI, null);
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        aVar2.mp(false);
        aVar2.mq(false);
        a(aVar2, pVar.xRr, str);
        l(inflate, z);
        a(pVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bWV);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xRr, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bWS).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xRr, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bWX);
        if (cdnImageView != null) {
            cdnImageView.Y(str2, b, b);
        }
        aVar2.dk(inflate);
        i ale = aVar2.ale();
        ale.show();
        return ale;
    }

    public static i a(p pVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return a(pVar, str, str2, z, str3, aVar, pVar.xRr.getResources().getString(R.l.dHf));
    }

    public static i a(p pVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.o.a aVar, String str4) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xRr, aVar2, bi.F(string.split(",")));
        }
        aVar2.mo(true);
        aVar2.R(str).mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str3, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i b(p pVar, String str, String str2, String str3, String str4, String str5, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(pVar.xRr, R.i.deI, null);
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        aVar2.mp(false);
        aVar2.mq(false);
        a(aVar2, pVar.xRr, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.h.bWW);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(pVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bWV);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xRr, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bWS).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xRr, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bWX);
        if (cdnImageView != null) {
            cdnImageView.Y(str2, b, b);
        }
        aVar2.dk(inflate);
        i ale = aVar2.ale();
        ale.show();
        return ale;
    }

    public static i a(p pVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return a(pVar, str, z, "", aVar);
    }

    public static i a(p pVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xRr, aVar2, bi.F(string.split(",")));
        }
        aVar2.mo(true);
        aVar2.R(str).mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str2, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i b(p pVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return b(pVar, str, z, "", aVar);
    }

    public static i b(p pVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if (str == null || !com.tencent.mm.a.e.bO(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xRr, aVar2, bi.F(string.split(",")));
        }
        aVar2.mo(true);
        aVar2.mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        if (!bi.oN(str)) {
            Bitmap Vs = com.tencent.mm.sdk.platformtools.d.Vs(str);
            if (Vs != null) {
                aVar2.a(Vs, true, 3);
                a(aVar2, Vs);
                aVar2.mo(false);
            }
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str2, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i a(p pVar, byte[] bArr, boolean z, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return a(pVar, bArr, z, "", aVar);
    }

    public static i a(p pVar, byte[] bArr, boolean z, String str, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if (bArr == null || bArr.length == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xRr, aVar2, bi.F(string.split(",")));
        }
        aVar2.mo(true);
        aVar2.mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.mo(false);
            }
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i b(p pVar, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
            return null;
        }
        View V = V(pVar.xRr, R.i.deJ);
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        aVar2.mp(false);
        aVar2.mq(false);
        if (V != null) {
            EditText editText = (EditText) V.findViewById(R.h.bWW);
            if (editText != null) {
                editText.setVisibility(0);
                editText.setHint(bi.oM(str2));
            }
        }
        a(pVar, aVar2, aVar, V, str3);
        if (!bi.oN(null)) {
            a(aVar2, pVar.xRr, null);
        }
        ((TextView) V.findViewById(R.h.bWY)).setVisibility(8);
        TextView textView = (TextView) V.findViewById(R.h.bWV);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xRr, str, textView.getTextSize()));
        ((TextView) V.findViewById(R.h.bWS)).setVisibility(8);
        int b = BackwardSupportUtil.b.b(pVar.xRr, 120.0f);
        ImageView imageView = (CdnImageView) V.findViewById(R.h.bWX);
        if (imageView != null) {
            if (!bi.oN(null)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, null);
            } else if (bi.oN(null)) {
                imageView.setVisibility(8);
            } else {
                imageView.Y(null, b, b);
            }
        }
        aVar2.dk(V);
        i ale = aVar2.ale();
        ale.show();
        return ale;
    }

    public static i a(p pVar, int i, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return a(pVar, i, str, z, "", aVar);
    }

    public static i a(p pVar, int i, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(pVar.xRr, aVar2, bi.F(string.split(",")));
        }
        aVar2.mo(true);
        if (i == R.k.dvu) {
            string = pVar.xRr.getResources().getString(R.l.dFu);
        } else if (i == R.k.dvy) {
            string = pVar.xRr.getResources().getString(R.l.dFU);
        } else if (i == R.k.dvL) {
            string = pVar.xRr.getResources().getString(R.l.dHi);
        } else {
            string = pVar.xRr.getResources().getString(R.l.dDY);
        }
        aVar2.R(str).mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str2, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i a(p pVar, String str, boolean z, int i, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        return a(pVar, str, z, i, "", aVar);
    }

    public static i a(p pVar, String str, boolean z, int i, String str2, com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        Object F;
        com.tencent.mm.ui.base.i.a aVar2 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        String string = pVar.xRr.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            F = bi.F(string.split(","));
        } else {
            F = null;
        }
        a(pVar.xRr, aVar2, F);
        aVar2.mo(true);
        switch (i) {
            case 1:
                string = pVar.xRr.getResources().getString(R.l.dHi);
                break;
            case 2:
                string = pVar.xRr.getResources().getString(R.l.dFU);
                break;
            default:
                string = pVar.xRr.getResources().getString(R.l.dDY);
                break;
        }
        aVar2.R(new StringBuffer(string).append(str).toString()).mp(false).mq(false);
        if (z) {
            aVar2.Zo(pVar.xRr.getString(R.l.dUm));
        }
        i ale = aVar2.ale();
        a(pVar.xRr, ale, str2, null, aVar, aVar);
        ale.show();
        return ale;
    }

    public static i a(p pVar, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.o.a aVar, com.tencent.mm.pluginsdk.ui.applet.o.a aVar2) {
        com.tencent.mm.ui.base.i.a aVar3 = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        aVar3.a(com.tencent.mm.compatible.g.a.decodeResource(pVar.xRr.getResources(), R.k.dyD), false, 3);
        aVar3.mp(false);
        aVar3.mq(false);
        aVar3.yhY.yfw = true;
        aVar3.yhY.yfo = str;
        aVar3.EU(17);
        i ale = aVar3.ale();
        a(pVar.xRr, ale, str3, str2, aVar2, aVar);
        ale.ER(pVar.xRr.getResources().getColor(R.e.bsE));
        ale.show();
        return ale;
    }

    public static q a(p pVar, Bitmap bitmap, String str, String str2, String str3, String str4, String str5, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        final View V = V(pVar.xRr, R.i.deM);
        final q cX = cX(V);
        a(V, aVar, cX);
        if (bi.oN(str2)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        a(V, R.h.bWY, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) V.findViewById(R.h.bWV);
        noMeasuredTextView.yoG = true;
        noMeasuredTextView.O(pVar.xRr.getResources().getDimension(R.f.but) * com.tencent.mm.bu.a.ev(pVar.xRr));
        noMeasuredTextView.setTextColor(com.tencent.mm.bu.a.Z(pVar.xRr, R.e.btv));
        if (bi.oN(str)) {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).b(pVar.xRr, str3, noMeasuredTextView.gu.getTextSize()));
        } else {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) g.h(com.tencent.mm.plugin.emoji.b.a.class)).b(pVar.xRr, ((b) g.h(b.class)).gw(str), noMeasuredTextView.gu.getTextSize()));
        }
        a(V, R.h.bWT, str4, true, 8);
        Button button = (Button) V.findViewById(R.h.bWO);
        if (!bi.oN(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, e.cY(V), e.cZ(V));
                }
                cX.dismiss();
                cX.setFocusable(false);
                cX.setTouchable(false);
            }
        });
        if (!bi.oN(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) V.findViewById(R.h.bWX), str);
        }
        a(pVar, cX);
        return cX;
    }

    public static q a(p pVar, long j, String str, String str2, String str3, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar) {
        final View V = V(pVar.xRr, R.i.deM);
        final q cX = cX(V);
        a(V, aVar, cX);
        if (bi.oN(str)) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        String str4;
        String str5;
        CharSequence charSequence;
        a(V, R.h.bWY, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) V.findViewById(R.h.bWV);
        noMeasuredTextView.yoG = true;
        noMeasuredTextView.O(pVar.xRr.getResources().getDimension(R.f.but) * com.tencent.mm.bu.a.ev(pVar.xRr));
        noMeasuredTextView.setTextColor(com.tencent.mm.bu.a.Z(pVar.xRr, R.e.btv));
        com.tencent.mm.af.a.c ag = ((f) g.h(f.class)).ag(j);
        if (ag == null || !ag.Mz()) {
            j ca = ((com.tencent.mm.api.g) g.h(com.tencent.mm.api.g.class)).ca(ag.field_bizChatServId);
            if (ca != null) {
                str4 = ca.field_userName;
                str5 = ca.field_headImageUrl;
                String str6 = ca.field_brandUserName;
                Object charSequence2 = str4;
                str4 = str5;
                str5 = str6;
            } else {
                x.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                return null;
            }
        }
        str4 = ag.field_chatName;
        str5 = ag.field_headImageUrl;
        charSequence2 = str4;
        str4 = str5;
        str5 = ag.field_brandUserName;
        if (charSequence2 == null) {
            charSequence2 = str2;
        }
        if (bi.oN(charSequence2)) {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xRr, str2, noMeasuredTextView.gu.getTextSize()));
        } else {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(pVar.xRr, charSequence2, noMeasuredTextView.gu.getTextSize()));
        }
        a(V, R.h.bWT, null, true, 8);
        Button button = (Button) V.findViewById(R.h.bWO);
        if (!bi.oN(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, e.cY(V), e.cZ(V));
                }
                cX.dismiss();
                cX.setFocusable(false);
                cX.setTouchable(false);
            }
        });
        com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
        aVar2.hFo = com.tencent.mm.api.a.bZ(str5);
        aVar2.hFl = true;
        aVar2.hFI = true;
        aVar2.hFA = R.k.bBC;
        com.tencent.mm.ap.a.a.c PQ = aVar2.PQ();
        if (!bi.oN(str4)) {
            o.PG().a(str4, (ImageView) V.findViewById(R.h.bWX), PQ);
        }
        a(pVar, cX);
        return cX;
    }

    public static i a(p pVar, String str, View view, String str2, final o.b bVar) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(pVar.xRr);
        aVar.mp(false);
        aVar.mq(false);
        a(aVar, pVar.xRr, str);
        if (bi.oN(str2) || str2.length() == 0) {
            str2 = pVar.xRr.getResources().getString(R.l.dUp);
        }
        aVar.Zp(str2).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.gk(true);
                }
            }
        });
        aVar.EW(R.l.dEy).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.gk(false);
                }
            }
        });
        aVar.dk(view);
        i ale = aVar.ale();
        ale.EQ(pVar.xRr.getResources().getColor(R.e.buj));
        ale.show();
        return ale;
    }

    public static View V(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
    }

    static q cX(View view) {
        return new q(view, -1, -1);
    }

    public static void a(p pVar, com.tencent.mm.ui.base.i.a aVar, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar2, final View view, String str) {
        if (bi.oN(str) || str.length() == 0) {
            str = pVar.xRr.getResources().getString(R.l.dUp);
        }
        aVar.Zp(str).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(true, e.cY(view), e.cZ(view));
                }
            }
        });
        aVar.EW(R.l.dEy).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    private static void a(com.tencent.mm.ui.base.i.a aVar, Context context, String str) {
        aVar.Zm(str);
        aVar.yhY.voU = context.getResources().getColor(R.e.btv);
        aVar.yhY.yfO = 2;
    }

    static void a(final View view, final com.tencent.mm.pluginsdk.ui.applet.o.a aVar, final q qVar) {
        ((Button) view.findViewById(R.h.bWO)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, e.cY(view), e.cZ(view));
                }
                qVar.dismiss();
                qVar.setFocusable(false);
                qVar.setTouchable(false);
            }
        });
        Button button = (Button) view.findViewById(R.h.bWP);
        if (button != null) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.a(false, null, 0);
                    }
                    qVar.dismiss();
                    qVar.setFocusable(false);
                    qVar.setTouchable(false);
                }
            });
        }
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.h.bWW);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && bi.oN(str)) {
            textView.setVisibility(i2);
        } else {
            textView.setText(str);
        }
    }

    static void a(p pVar, q qVar) {
        try {
            if (!pVar.xRr.isFinishing()) {
                qVar.setInputMethodMode(1);
                qVar.setSoftInputMode(16);
                qVar.setFocusable(true);
                qVar.setTouchable(true);
                qVar.showAtLocation(pVar.xRr.getWindow().getDecorView(), 17, 0, 0);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
        }
    }

    public static void a(com.tencent.mm.ui.base.i.a aVar, final Bitmap bitmap) {
        aVar.a(new DialogInterface.OnDismissListener() {
            public final void onDismiss(android.content.DialogInterface r2) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r1 = this;
                r0 = r2;
                if (r0 == 0) goto L_0x000c;
            L_0x0004:
                r0 = r2;
                r0 = r0.isRecycled();
                if (r0 == 0) goto L_0x000c;
            L_0x000c:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.e.7.onDismiss(android.content.DialogInterface):void");
            }
        });
    }
}
