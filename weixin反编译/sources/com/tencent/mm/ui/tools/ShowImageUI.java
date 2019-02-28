package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery kXH;
    private boolean zvZ;
    private a zwa;
    private boolean zwb;

    private class a extends BaseAdapter {
        String imagePath;

        private a() {
        }

        /* synthetic */ a(ShowImageUI showImageUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (p.Vw(this.imagePath)) {
                Context context = viewGroup.getContext();
                String str = this.imagePath;
                e eVar = new e(str);
                if (view == null || !(view instanceof MMAnimateView)) {
                    view = new MMAnimateView(context);
                } else {
                    MMAnimateView mMAnimateView = (MMAnimateView) view;
                }
                view.cX(str, str);
                view.a(str, new h() {
                    public final void invalidate() {
                        view.invalidate();
                    }
                });
                if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                    ((c) view.getDrawable()).stop();
                }
                if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                    ((c) view.getDrawable()).start();
                }
            } else {
                Bitmap oH = j.oH(this.imagePath);
                if (oH == null) {
                    x.w("MicroMsg.ShowImageUI", "get image fail");
                    if (view == null || (view instanceof MultiTouchImageView)) {
                        view = View.inflate(viewGroup.getContext(), R.i.dsP, null);
                    }
                    ((ImageView) view.findViewById(R.h.cpm)).setImageResource(R.k.dyE);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                } else {
                    Context context2 = viewGroup.getContext();
                    if (view == null || !(view instanceof MultiTouchImageView)) {
                        view = new MultiTouchImageView(context2, oH.getWidth(), oH.getHeight());
                    } else {
                        MultiTouchImageView view2 = (MultiTouchImageView) view2;
                        view2.eV(oH.getWidth(), oH.getHeight());
                    }
                    view2.setLayoutParams(new LayoutParams(-1, -1));
                    view2.setImageBitmap(oH);
                    view2.ynW = true;
                }
            }
            return view2;
        }
    }

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        as.Hm();
        cg dI = com.tencent.mm.y.c.Fh().dI(longExtra);
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI.field_content);
        if (p.Vw(stringExtra) || (dI.aNJ() && fV != null && fV.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", dI.field_content);
            if (fV != null && fV.type == 2) {
                stringExtra = u.hC("msg_" + dI.field_msgSvrId);
                u.GQ().t(stringExtra, true).o("prePublishId", "msg_" + dI.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.dsO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!bi.oN(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.zvZ = getIntent().getBooleanExtra("key_favorite", false);
        this.zwb = getIntent().getBooleanExtra("show_menu", true);
        this.kXH = (MMGestureGallery) findViewById(R.h.ckv);
        this.kXH.setVerticalFadingEdgeEnabled(false);
        this.kXH.setHorizontalFadingEdgeEnabled(false);
        this.zwa = new a();
        this.zwa.imagePath = getIntent().getStringExtra("key_image_path");
        this.kXH.setAdapter(this.zwa);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShowImageUI.this.finish();
                return true;
            }
        });
        if (this.zwb) {
            addIconOptionMenu(0, R.k.dAb, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    if (ShowImageUI.this.zvZ && d.Pu("favorite")) {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(ShowImageUI.this.getString(R.l.eET));
                        linkedList2.add(Integer.valueOf(1));
                        linkedList.add(ShowImageUI.this.getString(R.l.eAq));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(ShowImageUI.this.getString(R.l.eHt));
                    } else {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(ShowImageUI.this.getString(R.l.eET));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(ShowImageUI.this.getString(R.l.eHt));
                    }
                    b diVar = new di();
                    diVar.fsL.frh = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1);
                    com.tencent.mm.sdk.b.a.xmy.m(diVar);
                    if (diVar.fsM.fsk) {
                        linkedList2.add(Integer.valueOf(3));
                        linkedList.add(ShowImageUI.this.getString(R.l.dRX));
                    }
                    com.tencent.mm.ui.base.h.a(ShowImageUI.this, "", linkedList, linkedList2, "", false, new com.tencent.mm.ui.base.h.d() {
                        public final void cr(int i, int i2) {
                            switch (i2) {
                                case 0:
                                    ShowImageUI.b(ShowImageUI.this);
                                    return;
                                case 1:
                                    Activity activity = ShowImageUI.this;
                                    com.tencent.mm.f.a.cg cgVar = new com.tencent.mm.f.a.cg();
                                    long longExtra = activity.getIntent().getLongExtra("key_message_id", -1);
                                    if (-1 == longExtra) {
                                        x.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                                        f.a(cgVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.getIntent().getStringExtra("key_image_path"));
                                    } else {
                                        f.a(cgVar, longExtra);
                                    }
                                    cgVar.frk.activity = activity;
                                    com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                                    return;
                                case 2:
                                    k.h(ShowImageUI.this.getIntent().getStringExtra("key_image_path"), ShowImageUI.this);
                                    return;
                                case 3:
                                    ShowImageUI.d(ShowImageUI.this);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }
}
