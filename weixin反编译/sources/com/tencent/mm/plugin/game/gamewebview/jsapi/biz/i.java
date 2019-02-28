package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_BYTE = 254;
    public static final String NAME = "chooseMedia";
    private MMActivity.a jeB = new MMActivity.a() {
        public final void b(int i, int i2, Intent intent) {
            if (i == (i.this.hashCode() & 65535)) {
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                            i.this.nco.E(i.this.jfG, d.e("chooseMedia:fail", null));
                            return;
                        }
                        int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        String stringExtra;
                        Map hashMap;
                        if (intExtra == 1) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            x.i("MicroMsg.GameJsApiChooseMedia", "video localId:%s", stringExtra);
                            x.i("MicroMsg.GameJsApiChooseMedia", "video thumbLocalId:%s", stringExtra2);
                            if (bi.oN(stringExtra)) {
                                x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                i.this.nco.E(i.this.jfG, d.e("chooseMedia:fail", null));
                                return;
                            }
                            WebViewJSSDKFileItem Cg = d.Cg(stringExtra);
                            if (Cg == null || !(Cg instanceof WebViewJSSDKVideoItem)) {
                                x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                break;
                            }
                            WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) Cg;
                            x.i("MicroMsg.GameJsApiChooseMedia", "after parse to json data : %s", ai.b(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size));
                            hashMap = new HashMap();
                            hashMap.put(Columns.TYPE, Integer.valueOf(1));
                            hashMap.put("localIds", stringExtra);
                            i.this.nco.E(i.this.jfG, d.e("chooseMedia:ok", hashMap));
                            return;
                        } else if (intExtra == 2) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_ids");
                            x.i("MicroMsg.GameJsApiChooseMedia", "chooseMedia localIds:%s", stringExtra);
                            if (bi.oN(stringExtra)) {
                                x.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                i.this.nco.E(i.this.jfG, d.e("chooseMedia:fail", null));
                                return;
                            }
                            hashMap = new HashMap();
                            hashMap.put(Columns.TYPE, Integer.valueOf(2));
                            hashMap.put("localIds", stringExtra);
                            i.this.nco.E(i.this.jfG, d.e("chooseMedia:ok", hashMap));
                            return;
                        } else {
                            x.e("MicroMsg.GameJsApiChooseMedia", "type:%d is error", Integer.valueOf(intExtra));
                            i.this.nco.E(i.this.jfG, d.e("chooseMedia:fail", null));
                            return;
                        }
                        break;
                    case 0:
                        i.this.nco.E(i.this.jfG, d.e("chooseMedia:cancel", null));
                        return;
                }
                i.this.nco.E(i.this.jfG, d.e("chooseMedia:fail", null));
            }
        }
    };
    int jfG;
    GameWebViewUI ncn;
    com.tencent.mm.plugin.game.gamewebview.ui.d nco;

    public final void a(final com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, final int i) {
        x.i("MicroMsg.GameJsApiChooseMedia", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseMedia", "data is null");
            dVar.E(i, a.e("doChooseMedia:fail_invalid_data", null));
            return;
        }
        this.nco = dVar;
        this.jfG = i;
        this.ncn = dVar.aPO();
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ncn, "android.permission.CAMERA", 119, "", "")));
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.ncn, "android.permission.RECORD_AUDIO", 120, "", "")));
        if (com.tencent.mm.pluginsdk.g.a.a(this.ncn, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String oM = bi.oM(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            final String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            x.i("MicroMsg.GameJsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", oM, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3);
            final Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_count", optInt);
            if (min <= 0) {
                min = 10;
            }
            intent.putExtra("key_pick_local_media_duration", min);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("key_pick_local_media_video_type", 2);
            intent.putExtra("key_pick_local_media_sight_type", optString);
            intent.putExtra("key_pick_local_pic_query_source_type", (optString3.contains("original") ^ optString3.contains("compressed")) != 0 ? 7 : 8);
            intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(optString3.contains("compressed")));
            if (bi.oN(oM)) {
                str = "album|camera";
            } else {
                str = oM;
            }
            if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                l lVar = new l(this.ncn);
                lVar.b(null, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 1, 0, i.this.ncn.getString(R.l.dFh));
                        contextMenu.add(0, 2, 1, i.this.ncn.getString(R.l.dFl));
                    }
                }, new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                i.this.a(optString2, intent);
                                return;
                            case 2:
                                i.this.J(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                lVar.e(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.game.gamewebview.ui.d dVar = dVar;
                        int i = i;
                        i iVar = i.this;
                        dVar.E(i, a.e("doChooseMedia:cancel", null));
                    }
                });
                lVar.bCH();
                return;
            } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                J(intent);
                return;
            } else if (str.contains("camera")) {
                a(optString2, intent);
                return;
            } else {
                dVar.E(i, a.e("chooseMedia:fail_sourceType_error", null));
                return;
            }
        }
        dVar.E(i, a.e("doChooseMedia:fail_no_user_permission", null));
    }

    final void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.ncn.jCj = this.jeB;
        com.tencent.mm.bl.d.a(this.ncn, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }

    final void J(Intent intent) {
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        this.ncn.jCj = this.jeB;
        com.tencent.mm.bl.d.a(this.ncn, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }
}
