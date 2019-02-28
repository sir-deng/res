package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class k {
    p fhH;
    public ad yEA;
    public v yEB;
    public u yEG;
    public a yEI;
    public y yEJ;

    public k(p pVar) {
        this.fhH = pVar;
    }

    @TargetApi(11)
    public final void cur() {
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.ChattingUI.DragDropMgr", "sdk not support dragdrop event");
            return;
        }
        if (this.fhH.ctl() != null) {
            this.fhH.ctl().setOnDragListener(null);
        }
        if (this.fhH.ctp() != null) {
            this.fhH.ctp().setOnDragListener(null);
            this.fhH.ctp().a(null);
        }
    }

    @TargetApi(11)
    public final void cus() {
        if (!this.yEG.yAH && !this.yEG.yJp) {
            if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.ChattingUI.DragDropMgr", "sdk not support dragdrop event");
            } else {
                new Runnable() {
                    public final void run() {
                        OnDragListener anonymousClass1 = new OnDragListener() {
                            public final boolean onDrag(View view, DragEvent dragEvent) {
                                switch (dragEvent.getAction()) {
                                    case 1:
                                        x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_STARTED");
                                        return true;
                                    case 2:
                                        x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_LOCATION");
                                        return true;
                                    case 3:
                                        x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DROP");
                                        ClipData clipData = dragEvent.getClipData();
                                        if (clipData == null) {
                                            return true;
                                        }
                                        int itemCount = clipData.getItemCount();
                                        for (int i = 0; i < itemCount; i++) {
                                            Item itemAt = clipData.getItemAt(i);
                                            if (itemAt == null) {
                                                x.e("MicroMsg.ChattingUI.DragDropMgr", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                k.this.fhH.cte().startActivity(itemAt.getIntent());
                                            } else if (itemAt.getUri() != null) {
                                                l lVar = new l(k.this.fhH.cte().getContext(), itemAt.getUri());
                                                if (lVar.fileType != 0 && lVar.filePath != null) {
                                                    switch (lVar.fileType) {
                                                        case 3:
                                                            String str = lVar.filePath;
                                                            k.this.yEB.u(q.a(str, k.this.fhH.csn(), true) ? 1 : 0, 0, str);
                                                            break;
                                                        case 4:
                                                            Intent intent = new Intent();
                                                            intent.setData(itemAt.getUri());
                                                            k.this.yEA.al(intent);
                                                            break;
                                                        default:
                                                            k.this.yEI.a(lVar);
                                                            break;
                                                    }
                                                }
                                                x.e("MicroMsg.ChattingUI.DragDropMgr", "get file path failed");
                                            } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                                k.this.yEJ.dp(itemAt.getText().toString(), 0);
                                            }
                                        }
                                        return true;
                                    case 4:
                                        x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_ENDED");
                                        return true;
                                    case 5:
                                        x.i("MicroMsg.ChattingUI.DragDropMgr", "ACTION_DRAG_ENTERED");
                                        return true;
                                    default:
                                        x.e("MicroMsg.ChattingUI.DragDropMgr", "Unknown action type received by OnDragListener.");
                                        return false;
                                }
                            }
                        };
                        if (k.this.fhH.ctl() != null) {
                            k.this.fhH.ctl().setOnDragListener(anonymousClass1);
                        }
                        if (k.this.fhH.ctp() != null) {
                            k.this.fhH.ctp().setOnDragListener(anonymousClass1);
                            k.this.fhH.ctp().a(anonymousClass1);
                        }
                    }
                }.run();
            }
        }
    }
}
