package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.a.oy;
import com.tencent.mm.f.a.tu;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.R;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener, com.tencent.mm.ui.widget.MMWebView.d {
    private static final Pattern nfi = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern nfj = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static RenderPriority tFA = RenderPriority.NORMAL;
    private static final ArrayList<aa> tFu = new ArrayList();
    private static int tGl = 0;
    private static IUtils tGq = null;
    private static final Set<String> tyO;
    public com.tencent.mm.plugin.webview.stub.e fCC = new com.tencent.mm.plugin.webview.stub.e.a() {
        public final boolean n(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "callback, actionCode = " + i);
            final String string;
            final String string2;
            final boolean z;
            int length;
            final int i2;
            final String string3;
            final Map hashMap;
            final int i3;
            switch (i) {
                case 13:
                    if (bundle != null) {
                        bundle.putString("application_language", WebViewUI.this.jAm.getLanguage());
                        WebViewUI.this.tFT = new d(bundle);
                        break;
                    }
                    break;
                case 15:
                    string = bundle.getString("exdevice_device_id");
                    final boolean z2 = bundle.getBoolean("exdevice_is_complete");
                    final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                    final boolean z3 = bundle.getBoolean("exdevice_is_lan_device");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                String str = string;
                                byte[] bArr = byteArray;
                                boolean z = z2;
                                boolean z2 = z3;
                                if (dVar.tNo) {
                                    String str2 = "MicroMsg.JsApiHandler";
                                    String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = str;
                                    objArr[1] = Boolean.valueOf(z);
                                    objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                    com.tencent.mm.sdk.platformtools.x.i(str2, str3, objArr);
                                    if (bi.oN(str)) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONArray jSONArray = new JSONArray();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("deviceId", str);
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.bUd();
                                        if (com.tencent.mm.plugin.webview.ui.tools.a.b.bb(bArr) || (bArr != null && z2)) {
                                            jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                                        }
                                        jSONArray.put(jSONObject2);
                                        jSONObject.put("devices", jSONArray);
                                        if (z) {
                                            jSONObject.put("isCompleted", "1");
                                        } else {
                                            jSONObject.put("isCompleted", "0");
                                        }
                                    } catch (Exception e) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", e.getMessage());
                                    }
                                    try {
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onScanWXDeviceResult", jSONObject, dVar.tNq, dVar.tNr));
                                        dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                                    } catch (Exception e2) {
                                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e2.getMessage());
                                    }
                                    if (!z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.bUd().tIm = bArr;
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", WebViewUI.this.tsa, WebViewUI.this.jAn);
                        }
                    });
                    break;
                case 16:
                    string2 = bundle.getString("exdevice_device_id");
                    final String string4 = bundle.getString("exdevice_brand_name");
                    final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                String str = string2;
                                byte[] bArr = byteArray2;
                                String str2 = string4;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", str, str2);
                                    if (bi.oN(str) || bi.oN(str2) || bArr == null) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass3(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onReceiveDataFromWXDevice", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                            }
                        }
                    });
                    break;
                case 17:
                    string2 = bundle.getString("exdevice_device_id");
                    final boolean z4 = bundle.getBoolean("exdevice_is_bound");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                String str = string2;
                                boolean z = z4;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", str, Boolean.valueOf(z));
                                    if (bi.oN(str)) {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    if (z) {
                                        hashMap.put("state", "bind");
                                    } else {
                                        hashMap.put("state", "unbind");
                                    }
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass4(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceBindStateChange", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 18:
                    z = bundle.getBoolean("exdevice_bt_state");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                boolean z = z;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", Boolean.valueOf(z));
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass5(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceBluetoothStateChange", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case R.styleable.AppCompatTheme_dialogTheme /*42*/:
                case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                case 46:
                    WebViewUI.bTO();
                    break;
                case 47:
                    z = bundle.getBoolean("exdevice_lan_state");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                boolean z = z;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", Boolean.valueOf(z));
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass6(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceLanStateChange", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    String[] stringArray = bundle.getStringArray("msgIds");
                    String[] stringArray2 = bundle.getStringArray("contents");
                    String[] stringArray3 = bundle.getStringArray("senders");
                    int[] intArray = bundle.getIntArray("msgTypes");
                    int[] intArray2 = bundle.getIntArray("msgTimes");
                    final JSONArray jSONArray = new JSONArray();
                    length = stringArray == null ? 0 : stringArray.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("newMsgId", stringArray[i4]);
                            jSONObject.put("content", stringArray2[i4]);
                            jSONObject.put("sender", stringArray3[i4]);
                            jSONObject.put("msgType", intArray[i4]);
                            jSONObject.put("msgTime", intArray2[i4]);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + e.getMessage());
                        }
                    }
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                JSONArray jSONArray = jSONArray;
                                if (jSONArray == null) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("msgs", jSONArray);
                                ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass58(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetMsgProofItems", hashMap, dVar.tNq, dVar.tNr)));
                            }
                        }
                    });
                    break;
                case 60:
                case 61:
                case 62:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case FileUtils.S_IWUSR /*128*/:
                case 130:
                case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
                case com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX /*134*/:
                case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
                case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                case 137:
                case 138:
                case 142:
                case 143:
                case com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX /*144*/:
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                case 100001:
                case 100002:
                case 200000:
                case 200001:
                case 200002:
                case 200003:
                    WebViewUI.this.h(i, bundle);
                    break;
                case 70:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "on service click, update tid = %s", bundle.getString("service_click_tid"));
                    WebViewUI.this.tGs = string2;
                    WebViewUI.this.tGt = System.currentTimeMillis();
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.pzt != null) {
                                com.tencent.mm.plugin.normsg.a.d.oXY.a(WebViewUI.this.pzt, oy.class);
                                if (WebViewUI.this.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "on service click, test");
                                    com.tencent.mm.sdk.b.a.xmy.m(new oy());
                                }
                            }
                        }
                    });
                    break;
                case 90:
                    string2 = bundle.getString("webview_network_type");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.Qk(string2);
                            }
                        }
                    });
                    break;
                case 1001:
                    if (!WebViewUI.this.isFinishing()) {
                        WebViewUI.this.finish();
                        break;
                    }
                    break;
                case 1002:
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null && WebViewUI.this.jAn != null && WebViewUI.this.jAn.bTf() != null && WebViewUI.this.jAn.bTf().go(42)) {
                                WebViewUI.this.tsa.f(bundle, "download_succ");
                            }
                        }
                    });
                    break;
                case 1003:
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null && WebViewUI.this.jAn != null && WebViewUI.this.jAn.bTf() != null && WebViewUI.this.jAn.bTf().go(42)) {
                                WebViewUI.this.tsa.f(bundle, "download_fail");
                            }
                        }
                    });
                    break;
                case 1004:
                    string2 = bundle.getString("exdevice_device_id");
                    i2 = bundle.getInt("exdevice_on_state_change_state");
                    final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            boolean z = false;
                            if (WebViewUI.this.tsa != null && WebViewUI.this.jAn != null && WebViewUI.this.jAn.bTf() != null) {
                                WebViewUI.this.jAn.bTf();
                                JsapiPermissionWrapper.ces();
                                WebViewUI.this.tsa.cF(string2, i2);
                            } else if (WebViewUI.this.tsa == null || !valueOf.booleanValue()) {
                                String str = "MicroMsg.WebViewUI";
                                String str2 = "something null, %s, %s";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(WebViewUI.this.tsa == null);
                                if (WebViewUI.this.jAn == null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
                            } else {
                                WebViewUI.this.tsa.cF(string2, i2);
                            }
                        }
                    });
                    break;
                case 1006:
                    if (WebViewUI.this.tsa != null) {
                        WebViewUI.this.handler.post(new Runnable() {
                            public final void run() {
                                boolean z = false;
                                byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                if (byteArray == null || WebViewUI.this.jAn == null || WebViewUI.this.jAn.bTf() == null) {
                                    String str = "MicroMsg.WebViewUI";
                                    String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Boolean.valueOf(byteArray != null);
                                    if (WebViewUI.this.jAn != null) {
                                        z = true;
                                    }
                                    objArr[1] = Boolean.valueOf(z);
                                    com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "update control bytes, %d", Integer.valueOf(byteArray.length));
                                    WebViewUI.this.jAn.bTf().vHC = byteArray;
                                }
                                if (WebViewUI.this.tsa != null) {
                                    WebViewUI.this.tsa.bVb();
                                }
                            }
                        });
                        break;
                    }
                    break;
                case 1007:
                    final long j = bundle.getLong("download_manager_downloadid");
                    final int i5 = bundle.getInt("download_manager_progress");
                    string3 = bundle.getString("download_manager_appid", "");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null && WebViewUI.this.jAn != null && WebViewUI.this.jAn.bTf() != null && WebViewUI.this.jAn.bTf().go(42)) {
                                WebViewUI.this.tsa.g(string3, j, i5);
                            }
                        }
                    });
                    break;
                case 1008:
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null && WebViewUI.this.jAn != null && WebViewUI.this.jAn.bTf() != null && WebViewUI.this.jAn.bTf().go(42)) {
                                WebViewUI.this.tsa.f(bundle, "download_removed");
                            }
                        }
                    });
                    break;
                case 2002:
                    hashMap = new HashMap();
                    hashMap.put("err_msg", bundle.getString("playResult"));
                    hashMap.put("localId", bundle.getString("localId"));
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.am(hashMap);
                            }
                        }
                    });
                    break;
                case 2003:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.cG(string2, i2);
                            }
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.cH(string2, i2);
                            }
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.cI(string2, i2);
                            }
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.cJ(string2, i2);
                            }
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            WebViewUI.this.setMMSubTitle(com.tencent.mm.R.l.eXp);
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER /*2008*/:
                    hashMap = new HashMap();
                    hashMap.put("localId", bundle.getString("localId"));
                    hashMap.put("err_msg", bundle.getString("recordResult"));
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            WebViewUI.this.setMMSubTitle(null);
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.an(hashMap);
                            }
                        }
                    });
                    break;
                case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            WebViewUI.this.setMMSubTitle(null);
                        }
                    });
                    break;
                case 2010:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.cK(string2, i2);
                            }
                        }
                    });
                    break;
                case 2011:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                String str = string2;
                                int i = i2;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
                                    Map hashMap = new HashMap();
                                    hashMap.put("localId", str);
                                    hashMap.put("percent", Integer.valueOf(i));
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass10(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.e.NAME, hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                            }
                        }
                    });
                    break;
                case 2100:
                    string = bundle.getString("background_audio_state_player_state");
                    final int i6 = bundle.getInt("background_audio_state_player_duration");
                    final String string5 = bundle.getString("background_audio_state_player_src");
                    i3 = bundle.getInt("background_audio_state_player_err_code");
                    final String string6 = bundle.getString("background_audio_state_player_err_msg");
                    final String string7 = bundle.getString("background_audio_state_player_src_id");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                String str = string;
                                int i = i6;
                                String str2 = string5;
                                int i2 = i3;
                                String str3 = string6;
                                String str4 = string7;
                                if (dVar.tNo) {
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4);
                                    Map hashMap = new HashMap();
                                    hashMap.put("state", str);
                                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                                    hashMap.put("src", str2);
                                    hashMap.put("errCode", Integer.valueOf(i2));
                                    hashMap.put("errMsg", str3);
                                    hashMap.put("srcId ", str4);
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass17(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBackgroundAudioStateChange", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 4007:
                    length = bundle.getInt("nfc_key_on_touch_errcode", 0);
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                int i = length;
                                if (dVar.tNo) {
                                    Map hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(i));
                                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass19(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onNfcTouch", hashMap, dVar.tNq, dVar.tNr)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                            }
                        }
                    });
                    break;
                case 40001:
                    string2 = bundle.getString("err_msg");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.Qh(string2);
                            }
                        }
                    });
                    break;
                case 40002:
                    string3 = bundle.getString("uuid");
                    final int i7 = bundle.getInt("major");
                    i3 = bundle.getInt("minor");
                    final double d = bundle.getDouble("accuracy");
                    final double d2 = bundle.getDouble("rssi");
                    final float f = bundle.getFloat("heading");
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tsa != null) {
                                WebViewUI.this.tsa.a(string3, i7, i3, d, d2, f);
                            }
                        }
                    });
                    break;
                case 80001:
                case 80002:
                    WebViewUI.this.s(i, bundle);
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(final com.tencent.mm.plugin.webview.stub.c r4) {
            /*
            r3 = this;
            r0 = 0;
            r1 = 1;
            r2 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this;
            r2 = r2.tFC;
            r2 = r2.tHW;
            if (r2 <= 0) goto L_0x003e;
        L_0x000a:
            r2 = r1;
        L_0x000b:
            if (r2 != 0) goto L_0x002f;
        L_0x000d:
            r2 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this;
            r2 = r2.tFD;
            r2 = r2.tHX;
            if (r2 <= 0) goto L_0x0040;
        L_0x0015:
            r2 = r1;
        L_0x0016:
            if (r2 != 0) goto L_0x002f;
        L_0x0018:
            r2 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this;
            r2 = r2.tFE;
            r2 = r2.tHY;
            if (r2 <= 0) goto L_0x0021;
        L_0x0020:
            r0 = r1;
        L_0x0021:
            if (r0 != 0) goto L_0x002f;
        L_0x0023:
            r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this;
            r0 = r0.tGP;
            r0 = r0.bRy();
            if (r0 == 0) goto L_0x003d;
        L_0x002f:
            r0 = com.tencent.mm.plugin.webview.ui.tools.WebViewUI.this;
            r0 = r0.handler;
            r2 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$12$22;
            r2.<init>(r4);
            r0.post(r2);
        L_0x003d:
            return r1;
        L_0x003e:
            r2 = r0;
            goto L_0x000b;
        L_0x0040:
            r2 = r0;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12.a(com.tencent.mm.plugin.webview.stub.c):boolean");
        }

        public final boolean AJ(final int i) {
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", Integer.valueOf(i));
                    if (i != 0) {
                        WebViewUI.this.tEM.finish();
                    } else if (!WebViewUI.this.tGa && !WebViewUI.this.tGc) {
                        WebViewUI.this.tEM.start();
                    }
                }
            });
            return true;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            if (WebViewUI.this.tsa != null) {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                WebViewUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewUI.this.tsa.a(str3, str4, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aa(bundle2), z2);
                    }
                });
            }
            return false;
        }

        public final String bSz() {
            return WebViewUI.this.fJB;
        }

        public final String aeH() {
            return WebViewUI.this.aPR();
        }

        public final String bSA() {
            return WebViewUI.this.getIntent().getStringExtra("srcUsername");
        }

        public final void kv(final boolean z) {
            final boolean booleanExtra = WebViewUI.this.getIntent().getBooleanExtra("forceHideShare", false);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra));
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    if (booleanExtra) {
                        if (!(WebViewUI.this.pzt == null || bi.oN(WebViewUI.this.pzt.getUrl()))) {
                            WebViewUI.this.tFO.put(WebViewUI.this.pzt.getUrl(), Boolean.valueOf(false));
                        }
                        WebViewUI.this.kA(false);
                        return;
                    }
                    if (!(WebViewUI.this.pzt == null || bi.oN(WebViewUI.this.pzt.getUrl()))) {
                        WebViewUI.this.tFO.put(WebViewUI.this.pzt.getUrl(), Boolean.valueOf(z));
                    }
                    WebViewUI.this.kA(z);
                }
            });
        }

        public final void kw(final boolean z) {
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    WebViewUI.this.kB(z);
                }
            });
        }

        public final void bSB() {
            if (WebViewUI.this.tsa != null) {
                WebViewUI.this.tsa.bSB();
            }
        }

        public final void O(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
            if (bundle != null) {
                Intent intent = new Intent();
                intent.putExtra("result_data", bundle);
                WebViewUI.this.setResult(-1, intent);
            }
            WebViewUI.this.finish();
        }

        public final void Po(String str) {
            int i = 0;
            try {
                i = bi.getInt(str, 0);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + e.getMessage());
            }
            if (WebViewUI.this.pzt == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
            } else {
                WebViewUI.this.handler.post(new Runnable() {
                    public final void run() {
                        WebViewUI.this.Bg(i);
                    }
                });
            }
        }

        public final void bSC() {
            if (WebViewUI.this.tsa != null) {
                WebViewUI.this.tsa.bSC();
            }
        }

        public final void f(String str, final String str2, int i, int i2) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "result: " + str2);
            if (WebViewUI.this.jAs != null && str != null && str.equals(WebViewUI.this.jAs.tBB)) {
                if (WebViewUI.this.jAs != null) {
                    WebViewUI.this.jAs.bSt();
                }
                WebViewUI.this.jAq = i;
                WebViewUI.this.jAr = i2;
                if (str2 != null && WebViewUI.this.jAo != null) {
                    WebViewUI.this.handler.post(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.pzt != null) {
                                WebViewUI.this.jAp = str2;
                                WebViewUI.this.jAo.b(WebViewUI.this.pzt, new OnCreateContextMenuListener() {
                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        if (WebViewUI.this.jAt != null) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "show webkit menu");
                                            WebViewUI.this.b(contextMenu, WebViewUI.this.jAt);
                                            WebViewUI.this.jAt = null;
                                        } else if (WebViewUI.this.jAu != null) {
                                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "show IX5 menu");
                                            WebViewUI.this.a(contextMenu, WebViewUI.this.jAu);
                                            WebViewUI.this.jAu = null;
                                        }
                                    }
                                }, null);
                                WebViewUI.this.jAo.bCH();
                            }
                        }
                    });
                }
            }
        }

        public final void p(final int i, final Bundle bundle) {
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    if (WebViewUI.this.pzt != null) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + i);
                        Set<Object> hashSet = new HashSet();
                        if (i == 3003 || i == TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT) {
                            hashSet.add("menuItem:share:brand");
                            hashSet.add("menuItem:share:appMessage");
                            hashSet.add("menuItem:share:dataMessage");
                            hashSet.add("menuItem:share:timeline");
                            hashSet.add("menuItem:favorite");
                            hashSet.add("menuItem:profile");
                            hashSet.add("menuItem:addContact");
                            hashSet.add("menuItem:copyUrl");
                            hashSet.add("menuItem:openWithSafari");
                            hashSet.add("menuItem:share:email");
                            hashSet.add("menuItem:delete");
                            hashSet.add("menuItem:editTag");
                            hashSet.add("menuItem:readMode");
                            hashSet.add("menuItem:originPage");
                            hashSet.add("menuItem:share:qq");
                            hashSet.add("menuItem:share:weiboApp");
                            hashSet.add("menuItem:share:QZone");
                            hashSet.add("menuItem:share:Facebook");
                            hashSet.add("menuItem:share:enterprise");
                            hashSet.add("menuItem:share:wework");
                            hashSet.add("menuItem:share:weread");
                            hashSet.add("menuItem:addShortcut");
                        } else if (bundle == null) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
                            return;
                        } else {
                            Collection stringArrayList = bundle.getStringArrayList("menu_item_list");
                            if (stringArrayList == null || stringArrayList.size() == 0) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
                                return;
                            }
                            hashSet.addAll(stringArrayList);
                            hashSet.remove("menuItem:exposeArticle");
                            hashSet.remove("menuItem:setFont");
                            hashSet.remove("menuItem:keepTop");
                            hashSet.remove("menuItem:cancelKeepTop");
                            hashSet.remove("menuItem:profile");
                            hashSet.remove("menuItem:addContact");
                            hashSet.remove("menuItem:refresh");
                        }
                        String url = WebViewUI.this.pzt.getUrl();
                        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) WebViewUI.this.tGG.get(url);
                        switch (i) {
                            case 3001:
                            case 3003:
                                SparseBooleanArray sparseBooleanArray2;
                                if (sparseBooleanArray == null) {
                                    sparseBooleanArray = new SparseBooleanArray();
                                    WebViewUI.this.tGG.put(url, sparseBooleanArray);
                                    sparseBooleanArray2 = sparseBooleanArray;
                                } else {
                                    sparseBooleanArray2 = sparseBooleanArray;
                                }
                                for (Object obj : hashSet) {
                                    int a = bi.a((Integer) WebViewUI.this.nfO.get(obj), -1);
                                    if (a >= 0) {
                                        sparseBooleanArray2.put(a, true);
                                    }
                                }
                                return;
                            case 3002:
                            case TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT /*3004*/:
                                if (sparseBooleanArray != null) {
                                    for (Object obj2 : hashSet) {
                                        int a2 = bi.a((Integer) WebViewUI.this.nfO.get(obj2), -1);
                                        if (a2 >= 0) {
                                            sparseBooleanArray.delete(a2);
                                        }
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }

        public final void eT(final String str, String str2) {
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    if (bi.oN(WebViewUI.this.pzt.getUrl())) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setPageOwner, null url");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + str);
                    WebViewUI.this.tFP.put(WebViewUI.this.pzt.getUrl(), str);
                }
            });
        }

        public final Bundle e(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            Intent intent;
            int b;
            final String string;
            final String string2;
            final boolean z;
            boolean z2;
            CharSequence mMTitle;
            String aeH;
            int init;
            switch (i) {
                case 11:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tFU != null && WebViewUI.this.tFU.isShowing()) {
                                WebViewUI.this.tFU.dismiss();
                            }
                        }
                    });
                    break;
                case 12:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.tFT = null;
                        }
                    });
                    break;
                case 18:
                    bundle2.putString("KPublisherId", WebViewUI.this.fHA);
                    intent = WebViewUI.this.getIntent();
                    if (intent != null) {
                        b = WebViewUI.this.PT(WebViewUI.this.getIntent().getStringExtra("geta8key_username"));
                        bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                        bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                        bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                        bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                        bundle2.putInt("getA8KeyScene", b);
                        bundle2.putString("referUrl", WebViewUI.this.tzH);
                        break;
                    }
                    break;
                case 22:
                    bundle2.putInt("pay_channel", WebViewUI.this.getIntent().getIntExtra("pay_channel", -1));
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", Integer.valueOf(WebViewUI.this.getIntent().getIntExtra("pay_channel", -1)));
                    break;
                case 25:
                    bundle2.putInt("scene", WebViewUI.this.getIntent().getIntExtra("scene", -1));
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", Integer.valueOf(WebViewUI.this.getIntent().getIntExtra("scene", 0)));
                    break;
                case 33:
                    intent = WebViewUI.this.getIntent();
                    if (intent != null) {
                        bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                        bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                        break;
                    }
                    break;
                case 34:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.p(WebViewUI.this);
                        }
                    });
                    break;
                case 35:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.tGC.startLoading();
                        }
                    });
                    break;
                case 36:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.tGC.stopLoading();
                        }
                    });
                    break;
                case 37:
                    string = bundle.getString("show_kb_placeholder");
                    b = bundle.getInt("show_kb_max_length");
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.cD(string, b);
                        }
                    });
                    break;
                case 38:
                    if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                        WebViewUI.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                WebViewUI.this.tGC.ky(true);
                            }
                        });
                        break;
                    }
                    break;
                case 39:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.q(WebViewUI.this);
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    string = bundle.getString("set_page_title_text");
                    b = d.aM(bundle.getString("set_page_title_color"), WebViewUI.this.bTp());
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.rEZ) {
                                if (string != null) {
                                    WebViewUI.this.setMMTitle(string);
                                }
                                WebViewUI.this.oj(b);
                            }
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    Bitmap bitmap;
                    string2 = bundle.getString("set_navigation_bar_buttons_text");
                    string = bundle.getString("set_navigation_bar_buttons_icon_data");
                    z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                    if (bi.oN(string)) {
                        bitmap = null;
                    } else {
                        try {
                            bitmap = d.PI(string);
                        } catch (Exception e) {
                            bitmap = null;
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", e);
                        }
                    }
                    final int aM = d.aM(bundle.getString("set_navigation_bar_buttons_left_text_color"), -1);
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (z) {
                                WebViewUI.this.kD(true);
                                return;
                            }
                            Boolean bool = null;
                            String aPR = WebViewUI.this.aPR();
                            if (!bi.oN(aPR)) {
                                bool = (Boolean) WebViewUI.this.tFR.get(aPR);
                            }
                            WebViewUI.this.kD(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
                            if (bitmap != null && !bitmap.isRecycled()) {
                                WebViewUI.this.b(string2, new BitmapDrawable(WebViewUI.this.getResources(), bitmap));
                            } else if (!bi.oN(string2)) {
                                WebViewUI.this.addTextOptionMenu(0, string2, new OnMenuItemClickListener() {
                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "click item: %s", Integer.valueOf(menuItem.getItemId()));
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                        if (dVar.tNo) {
                                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
                                            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onNavigationBarRightButtonClick", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
                                        } else {
                                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
                                        }
                                        return false;
                                    }
                                });
                            }
                            WebViewUI.this.Bb(aM);
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            boolean z = bundle.getBoolean("enable_fullscreen_params_enable", false);
                            if (WebViewUI.this.getIntent() != null) {
                                WebViewUI.this.getIntent().removeExtra("show_full_screen");
                            }
                            WebViewUI.this.I(z, false);
                        }
                    });
                    break;
                case 47:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.tGC.bTh();
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                case R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    break;
                case 53:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            WebViewUI.this.U(bundle);
                        }
                    });
                    break;
                case 54:
                    z2 = bundle.getBoolean("add_shortcut_status");
                    if (WebViewUI.this.tsa != null) {
                        WebViewUI.this.tsa.kH(z2);
                        break;
                    }
                    break;
                case R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                        bundle2.putString("enterprise_context_biz", WebViewUI.this.getIntent().getStringExtra("enterprise_biz_name"));
                        bundle2.putLong("enterprise_context_bizchatid", WebViewUI.this.getIntent().getLongExtra("biz_chat_chat_id", -1));
                        break;
                    }
                    break;
                case 72:
                    WebViewUI.this.tGC.AX(d.aM(bundle.getString("key_set_bounce_background_color"), WebViewUI.this.getResources().getColor(com.tencent.mm.R.e.bui)));
                    break;
                case 73:
                    intent = WebViewUI.this.getIntent();
                    if (bundle != null) {
                        switch (bundle.getInt("scene")) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 37:
                            case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                break;
                            case 33:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                break;
                            case 34:
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("<exposecontent>");
                                stringBuilder.append("<weburl>");
                                if (intent.getStringExtra("k_expose_current_url") != null) {
                                    stringBuilder.append(intent.getStringExtra("k_expose_current_url"));
                                }
                                stringBuilder.append("</weburl>");
                                stringBuilder.append("<webscence>");
                                stringBuilder.append(WebViewUI.this.PT(WebViewUI.this.getIntent().getStringExtra("geta8key_username")));
                                stringBuilder.append("</webscence>");
                                stringBuilder.append("</exposecontent>");
                                bundle2.putString("content", stringBuilder.toString());
                                break;
                            case 35:
                            case 36:
                            case 38:
                            case 39:
                                break;
                            case 51:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                                break;
                            default:
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "unknown expose scene: %d", Integer.valueOf(bundle.getInt("scene")));
                                return bundle2;
                        }
                        bundle2.putString("username", intent.getStringExtra("k_username"));
                        break;
                    }
                    break;
                case 77:
                    bundle2.putString("KSessionId", WebViewUI.this.frp);
                    bundle2.putString("KUserAgent", WebViewUI.this.jKI);
                    bundle2.putBoolean("KReportPage", WebViewUI.this.tFd);
                    bundle2.putString("KUrl", WebViewUI.this.tGL);
                    break;
                case 79:
                    WebViewUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            bundle2.putInt("height", WebViewUI.this.bTu());
                        }
                    });
                    break;
                case 81:
                    bundle2.putBoolean("from_shortcut", WebViewUI.this.tFl);
                    break;
                case 84:
                    mMTitle = WebViewUI.this.mController.getMMTitle();
                    aeH = aeH();
                    bundle2.putString("webview_current_url", aeH);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", aeH);
                    break;
                case 85:
                    mMTitle = WebViewUI.this.mController.getMMTitle();
                    aeH = aeH();
                    Intent intent2 = WebViewUI.this.getIntent();
                    if (intent2 != null) {
                        bundle2.putString("share_report_pre_msg_url", intent2.getStringExtra("share_report_pre_msg_url"));
                        bundle2.putString("share_report_pre_msg_title", intent2.getStringExtra("share_report_pre_msg_title"));
                        bundle2.putString("share_report_pre_msg_desc", intent2.getStringExtra("share_report_pre_msg_desc"));
                        bundle2.putString("share_report_pre_msg_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                        bundle2.putString("share_report_pre_msg_appid", intent2.getStringExtra("share_report_pre_msg_appid"));
                        bundle2.putInt("share_report_from_scene", intent2.getIntExtra("share_report_from_scene", 0));
                        bundle2.putString("share_report_biz_username", intent2.getStringExtra("share_report_biz_username"));
                    }
                    bundle2.putString("share_report_current_url", aeH);
                    bundle2.putString("share_report_current_title", mMTitle != null ? mMTitle.toString() : "");
                    break;
                case 86:
                    bundle2.putBoolean("is_from_keep_top", WebViewUI.this.getIntent().getBooleanExtra("is_from_keep_top", false));
                    break;
                case R.styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    if (!WebViewUI.this.tGd) {
                        bundle2.putString("full_url", bi.oM(WebViewUI.this.mKN));
                        if (WebViewUI.this.tGf != null && WebViewUI.this.tGf.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            com.tencent.xweb.c.iQ(ad.getContext());
                            com.tencent.xweb.b cJc = com.tencent.xweb.b.cJc();
                            for (String string3 : WebViewUI.this.tGf.keySet()) {
                                cJc.setCookie(bi.WF(WebViewUI.this.mKN), string3 + "=" + ((String) WebViewUI.this.tGf.get(string3)));
                            }
                            cJc.setCookie(bi.WF(WebViewUI.this.mKN), "httponly");
                            com.tencent.xweb.c.cJe();
                            com.tencent.xweb.c.sync();
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "cookies:%s", cJc.getCookie(bi.WF(WebViewUI.this.mKN)));
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 95:
                    WebViewUI.this.T(bundle);
                    break;
                case 97:
                    bundle2.putInt("web_page_count", WebViewUI.tGl);
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", WebViewUI.this.getIntent().getIntExtra("geta8key_scene", 0));
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "Key value: getA8KeyScene(%d)", Integer.valueOf(init));
                    break;
                case 101:
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    com.tencent.mm.bl.d.b(WebViewUI.this, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", WebViewUI.this.fHA));
                    break;
                case HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION /*1009*/:
                    if (WebViewUI.this.tEW != null) {
                        WebViewUI.this.tEW.disable();
                    }
                    WebViewUI.this.screenOrientation = bundle.getInt("screen_orientation", -1);
                    if (WebViewUI.this.screenOrientation == 1001) {
                        WebViewUI.this.screenOrientation = 0;
                        if (WebViewUI.this.tEW != null) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            WebViewUI.this.tEW.enable();
                        }
                    } else if (WebViewUI.this.screenOrientation == 1002) {
                        WebViewUI.this.screenOrientation = 1;
                        if (WebViewUI.this.tEW != null) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            WebViewUI.this.tEW.enable();
                        }
                    }
                    WebViewUI.this.afw();
                    break;
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case 4005:
                case 4008:
                    final com.tencent.mm.sdk.b.b kVar = new com.tencent.mm.f.a.k();
                    kVar.fnU.context = WebViewUI.this.mController.xRr;
                    kVar.fnU.actionCode = i;
                    if (4003 == i) {
                        kVar.fnU.fnW = bundle.getString("apdu");
                    } else if (4004 == i) {
                        aeH = bundle.getString("apdus");
                        z = bundle.getBoolean("breakIfFail", true);
                        boolean z3 = bundle.getBoolean("breakIfTrue", false);
                        kVar.fnU.fnW = aeH;
                        kVar.fnU.fnX = z;
                        kVar.fnU.fnY = z3;
                    }
                    kVar.frD = new Runnable() {
                        public final void run() {
                            bundle2.putAll(kVar.fnV.fnZ);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xmy.m(kVar);
                    break;
                case 5001:
                    if (WebViewUI.this.jAm.isSDCardAvailable()) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "availableSize = %d", Long.valueOf(ax.cgQ()));
                        if (ax.cgQ() < 524288000) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.trw);
                            z2 = true;
                            if (!file.exists()) {
                                z2 = file.mkdirs();
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z2));
                            }
                            if (z2) {
                                init = FactoryProxyManager.getPlayManager().init(WebViewUI.this, com.tencent.mm.plugin.webview.a.trw);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(WebViewUI.this, null);
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(WebViewUI.this, null);
                    }
                    if (init == 0) {
                        if (WebViewUI.tGq == null) {
                            WebViewUI.tGq = new x(WebViewUI.this, (byte) 0);
                            FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.tGq);
                        }
                        b = FactoryProxyManager.getPlayManager().getLocalServerPort();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", Integer.valueOf(init), Integer.valueOf(b));
                        ag n = WebViewUI.this.tGu;
                        if (b <= 0 || b > 65535) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", Integer.valueOf(b));
                        }
                        if (!n.tyY.contains(Integer.valueOf(b))) {
                            n.tyY.add(Integer.valueOf(b));
                        }
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    init = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", aeH, r3, Integer.valueOf(r8), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init));
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", string2);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", Integer.valueOf(init));
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, b));
                    break;
                case 6001:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                    WebViewUI.this.sendBroadcast(intent3);
                    break;
                case 90000:
                    bundle2.putStringArray("webview_get_route_url_list", WebViewUI.this.tGp.bSu());
                    bundle2.putInt("webview_get_route_url_geta8key_scene", WebViewUI.this.PT(WebViewUI.this.getIntent().getStringExtra("geta8key_username")));
                    bundle2.putString("geta8key_username", WebViewUI.this.getIntent().getStringExtra("geta8key_username"));
                    break;
                case 90001:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", WebViewUI.this.aPR(), com.tencent.xweb.b.cJc().getCookie(WebViewUI.this.aPR()));
                    bundle2.putString("cookie", aeH);
                    break;
                case 90002:
                    g.tEG.eW(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }

        public final void P(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setCustomMenu");
            ArrayList stringArrayList = bundle.getStringArrayList("keys");
            ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
            int size = stringArrayList.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(new com.tencent.mm.j.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
            }
            if (stringArrayList.size() > 0) {
                String url = WebViewUI.this.pzt.getUrl();
                if (WebViewUI.this.tFQ.containsKey(url)) {
                    WebViewUI.this.tFQ.remove(url);
                }
                WebViewUI.this.tFQ.put(url, arrayList);
            }
        }

        public final void kx(boolean z) {
            WebViewUI.this.kD(z);
        }

        public final void eU(final String str, final String str2) {
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    if (!bi.oN(str)) {
                        if (!bi.oN(str2)) {
                            WebViewUI.this.getIntent().putExtra("view_port_code", str2);
                        }
                        WebViewUI.this.pzt.loadUrl(str);
                    }
                }
            });
        }
    };
    private String fHA;
    public volatile String fJB = null;
    private int fNt;
    private int fromScene;
    private String frp = "";
    public com.tencent.mm.sdk.platformtools.ag handler;
    private int height;
    public com.tencent.mm.plugin.webview.stub.d jAm = null;
    public e jAn = null;
    com.tencent.mm.ui.tools.l jAo;
    String jAp;
    int jAq;
    int jAr;
    com.tencent.mm.plugin.webview.modeltools.g jAs;
    com.tencent.xweb.WebView.a jAt;
    com.tencent.xweb.WebView.a jAu;
    private final com.tencent.mm.plugin.webview.modeltools.c jAv = new com.tencent.mm.plugin.webview.modeltools.c();
    private com.tencent.mm.plugin.webview.modeltools.g.c jAy = new com.tencent.mm.plugin.webview.modeltools.g.c() {
        public final void ty(String str) {
            try {
                if (WebViewUI.this.jAm != null) {
                    WebViewUI.this.jAm.c(str, null);
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
                }
            } catch (RemoteException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "recog failed");
            }
        }
    };
    private String jKI = "";
    private long jNQ = 0;
    private String jOH;
    public int jSO;
    private long kIK = 0;
    private ServiceConnection lwY = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (WebViewUI.this.pzt == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                return;
            }
            WebViewUI.this.jAm = com.tencent.mm.plugin.webview.stub.d.a.X(iBinder);
            try {
                WebViewUI.this.jAm.a(WebViewUI.this.fCC, WebViewUI.this.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", e.getMessage());
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "onServiceConnected, invoker == null ? %b";
            Object[] objArr = new Object[1];
            if (WebViewUI.this.jAm != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
            if (WebViewUI.this.jAm == null) {
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                WebViewUI.this.finish();
                return;
            }
            WebViewUI.this.alu();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((WebViewUI.this.tGm && WebViewUI.tGl <= 0) || (!WebViewUI.this.tGm && WebViewUI.tGl <= 1)) {
                com.tencent.mm.plugin.webview.modeltools.b.d(WebViewUI.this.jAm);
                com.tencent.mm.plugin.webview.modelcache.o bSb = a.tAm;
                for (int i = 0; i < bSb.tAk.size(); i++) {
                    bSb.tAk.valueAt(i);
                }
                bSb.tAk.clear();
                bSb.tAl.clear();
            }
            if (WebViewUI.this.tGm || WebViewUI.this.tGn || WebViewUI.this.isFinishing()) {
                WebViewUI.this.jAm = null;
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            WebViewUI.this.bTk();
        }
    };
    public String mKN;
    public boolean neY = true;
    private int networkType;
    private Map<String, Integer> nfO = new HashMap();
    protected com.tencent.mm.ui.snackbar.b.b nfQ = new com.tencent.mm.ui.snackbar.b.b() {
        public final void aQv() {
            try {
                WebViewUI.this.jAm.favEditTag();
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    private int nfb = 0;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> ngt = new ArrayList();
    private long ngu = 0;
    public View nrV;
    private View nrW;
    public int nrX = 0;
    public String nrY = null;
    public MMWebView pzt;
    private boolean rEZ = true;
    public int screenOrientation = -1;
    private final com.tencent.mm.plugin.webview.modeltools.a tDX = new com.tencent.mm.plugin.webview.modeltools.a();
    protected boolean tDg = true;
    protected boolean tEL = false;
    public MMFalseProgressBar tEM;
    public ProgressBar tEN;
    private ImageButton tEO;
    private ImageButton tEP;
    private View tEQ;
    public FrameLayout tER;
    public FrameLayout tES;
    public MovingImageButton tET;
    public boolean tEU = false;
    public boolean tEV = false;
    protected com.tencent.mm.plugin.webview.modeltools.e tEW;
    private WebViewInputFooter tEX;
    public WebViewSearchContentInputFooter tEY;
    private boolean tEZ;
    public l tFB = new l(null);
    protected m tFC = new m();
    protected o tFD = new o();
    protected q tFE = new q();
    private boolean tFF = false;
    private com.tencent.mm.sdk.platformtools.aa<String, Bitmap> tFG = new com.tencent.mm.sdk.platformtools.aa(12);
    private HashMap<String, String> tFH = new HashMap();
    private b tFI;
    private int tFJ = 0;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.f tFK;
    protected volatile boolean tFL = false;
    private boolean tFM = false;
    private String tFN = "";
    private HashMap<String, Boolean> tFO = new HashMap();
    private HashMap<String, String> tFP = new HashMap();
    private HashMap<String, ArrayList<com.tencent.mm.j.d.b>> tFQ = new HashMap();
    private HashMap<String, Boolean> tFR = new HashMap();
    private HashMap<String, Integer> tFS = new HashMap();
    private d tFT;
    private com.tencent.mm.ui.base.i tFU = null;
    private View tFV;
    protected View tFW = null;
    private String tFX = null;
    private boolean tFY = false;
    private volatile boolean tFZ = false;
    private boolean tFa;
    public String tFb = null;
    private boolean tFc = false;
    public boolean tFd = false;
    public boolean tFe = false;
    private boolean tFf = false;
    private boolean tFg = false;
    private boolean tFh = true;
    private boolean tFi = false;
    private boolean tFj = false;
    private boolean tFk = false;
    private boolean tFl = false;
    private boolean tFm = true;
    private int tFn;
    private String tFo = null;
    private byte[] tFp = new byte[0];
    private boolean tFq = false;
    private boolean tFr = false;
    View tFs;
    al tFt;
    private boolean tFv = false;
    private CustomViewCallback tFw;
    private View tFx;
    protected com.tencent.xweb.j tFy;
    private ProgressBar tFz;
    private com.tencent.mm.plugin.webview.modeltools.e.b tGA = new com.tencent.mm.plugin.webview.modeltools.e.b() {
        public final void a(com.tencent.mm.plugin.webview.modeltools.e.a aVar, com.tencent.mm.plugin.webview.modeltools.e.a aVar2) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            WebViewUI.this.screenOrientation = 4;
            WebViewUI.this.afw();
            if (WebViewUI.this.tEW != null) {
                WebViewUI.this.tEW.disable();
            }
        }
    };
    private boolean tGB = false;
    public final f tGC = new f();
    private boolean tGD;
    private OnLongClickListener tGE = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                return bTW();
            }
            return true;
        }

        private boolean bTW() {
            boolean cG;
            Exception e;
            boolean z;
            com.tencent.xweb.WebView.a hitTestResult = WebViewUI.this.pzt.getHitTestResult();
            if (hitTestResult == null || bi.oN(hitTestResult.mExtra)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
                return false;
            }
            try {
                cG = WebViewUI.this.jAm.cG(hitTestResult.mExtra);
                if (cG) {
                    try {
                        WebViewUI.this.jAm.cA(hitTestResult.mExtra, WebViewUI.this.hashCode());
                    } catch (Exception e2) {
                        e = e2;
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                        z = cG;
                        if (!z) {
                            return z;
                        }
                        com.tencent.mm.ui.base.h.a((Context) WebViewUI.this, hitTestResult.mExtra, new String[]{com.tencent.mm.bu.a.ac(WebViewUI.this, com.tencent.mm.R.l.eBI), com.tencent.mm.bu.a.ac(WebViewUI.this, com.tencent.mm.R.l.eBG)}, "", new com.tencent.mm.ui.base.h.c(hitTestResult.mExtra) {
                            public final void jo(int i) {
                                switch (i) {
                                    case 0:
                                        if (WebViewUI.this.PV(r4)) {
                                            WebViewUI.this.pzt.loadUrl(r4);
                                            return;
                                        }
                                        com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + r4);
                                        WebViewUI.this.aPM();
                                        return;
                                    case 1:
                                        com.tencent.mm.pluginsdk.h.c.a(WebViewUI.this, r4, r4);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                }
                z = cG;
            } catch (Exception e3) {
                e = e3;
                cG = true;
            }
            if (!z) {
                return z;
            }
            com.tencent.mm.ui.base.h.a((Context) WebViewUI.this, hitTestResult.mExtra, new String[]{com.tencent.mm.bu.a.ac(WebViewUI.this, com.tencent.mm.R.l.eBI), com.tencent.mm.bu.a.ac(WebViewUI.this, com.tencent.mm.R.l.eBG)}, "", /* anonymous class already generated */);
            return true;
        }
    };
    String[] tGF;
    private Map<String, SparseBooleanArray> tGG = new HashMap();
    private String tGH = "";
    private volatile String tGI = "";
    private volatile String tGJ = null;
    private volatile String tGK = "";
    private volatile String tGL = "";
    private long tGM = 0;
    private com.tencent.mm.ui.base.r tGN;
    private com.tencent.mm.plugin.webview.model.y.d tGO = new com.tencent.mm.plugin.webview.model.y.d() {
        public final void OM(String str) {
            WebViewUI.this.j(str, true, 9);
        }

        public final void goBack() {
            if (WebViewUI.this.pzt != null && !WebViewUI.this.tFY) {
                if (WebViewUI.this.pzt.canGoBack() && WebViewUI.this.neY) {
                    WebViewUI.this.bTt();
                    return;
                }
                g.tEG.close();
                WebViewUI.this.finish();
            }
        }

        public final void c(OnCancelListener onCancelListener) {
            if (WebViewUI.this.tGN != null) {
                WebViewUI.this.tGN.dismiss();
            }
            WebViewUI.this.tGN = com.tencent.mm.ui.base.h.a(WebViewUI.this, WebViewUI.this.getString(com.tencent.mm.R.l.ezS), true, onCancelListener);
        }

        public final void aDe() {
            if (WebViewUI.this.tGN != null) {
                WebViewUI.this.tGN.dismiss();
            }
        }
    };
    private com.tencent.mm.plugin.webview.model.y.b tGP = new com.tencent.mm.plugin.webview.model.y.b() {
        private Map<Integer, Integer> tHP = new HashMap();

        public final void AA(int i) {
            WebViewUI.this.AZ(i);
            if (this.tHP.containsKey(Integer.valueOf(i))) {
                this.tHP.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.tHP.get(Integer.valueOf(i))).intValue() + 1));
                return;
            }
            this.tHP.put(Integer.valueOf(i), Integer.valueOf(1));
        }

        public final void remove(int i) {
            WebViewUI.this.Ba(i);
            if (this.tHP.containsKey(Integer.valueOf(i))) {
                this.tHP.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.tHP.get(Integer.valueOf(i))).intValue() - 1));
                return;
            }
            this.tHP.put(Integer.valueOf(i), Integer.valueOf(0));
        }

        public final boolean bRy() {
            for (Entry value : this.tHP.entrySet()) {
                if (((Integer) value.getValue()).intValue() > 0) {
                    return true;
                }
            }
            return false;
        }
    };
    private com.tencent.mm.ui.base.k tGQ;
    private String[] tGR = null;
    public int tGS = -1;
    private volatile boolean tGa = false;
    private final Set<String> tGb = new HashSet();
    private boolean tGc = false;
    private boolean tGd = false;
    private final Map<String, Map<String, String>> tGe = new ConcurrentHashMap();
    private Map<String, String> tGf;
    private Map tGg;
    private String tGh = "";
    private boolean tGi = false;
    private final Map<String, String> tGj = new HashMap();
    private final Set<String> tGk = new HashSet();
    public boolean tGm = false;
    private boolean tGn = false;
    private com.tencent.mm.plugin.webview.model.a tGo = new com.tencent.mm.plugin.webview.model.a(this.tyl);
    private com.tencent.mm.plugin.webview.modeltools.j tGp = new com.tencent.mm.plugin.webview.modeltools.j();
    private WebViewClipBoardHelper tGr;
    private volatile String tGs;
    private volatile long tGt;
    private ag tGu = new ag();
    public com.tencent.xweb.o tGv = new com.tencent.xweb.o() {
        public final boolean z(MotionEvent motionEvent) {
            if (WebViewUI.this.pzt == null) {
                return false;
            }
            return WebViewUI.this.pzt.O(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (WebViewUI.this.pzt == null) {
                return false;
            }
            return WebViewUI.this.pzt.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void aik() {
            if (WebViewUI.this.pzt != null) {
                WebViewUI.this.pzt.czP();
            }
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            if (WebViewUI.this.pzt != null) {
                WebViewUI.this.pzt.c(i, i2, z, z2);
                if (z2 && WebViewUI.this.tyl != null) {
                    WebViewUI.this.tyl.t("mm_scroll_bottom", Boolean.valueOf(true));
                }
            }
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (WebViewUI.this.pzt != null) {
                WebViewUI.this.pzt.y(i, i2, i3, i4);
                WebViewUI.this.onWebViewScrollChanged(i, i2, i3, i4);
            }
        }

        public final boolean A(MotionEvent motionEvent) {
            if (WebViewUI.this.pzt == null) {
                return false;
            }
            return WebViewUI.this.pzt.P(motionEvent);
        }

        public final boolean B(MotionEvent motionEvent) {
            if (WebViewUI.this.pzt == null) {
                return false;
            }
            return WebViewUI.this.pzt.Q(motionEvent);
        }
    };
    private com.tencent.mm.sdk.b.c<oy> tGw = new com.tencent.mm.sdk.b.c<oy>() {
        {
            this.xmG = oy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return bTV();
        }

        private boolean bTV() {
            if (WebViewUI.this.jAm == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Cli Event, invoker is null");
            } else if (WebViewUI.this.tGs == null || WebViewUI.this.tGs.length() == 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Cli Event, tid is null");
            } else {
                try {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "Cli Event, tid = %s, stime = %d, etime = %d", WebViewUI.this.tGs, Long.valueOf(WebViewUI.this.tGt), Long.valueOf(System.currentTimeMillis()));
                    Bundle bundle = new Bundle();
                    bundle.putString("service_click_tid", new String(WebViewUI.this.tGs));
                    bundle.putLong("service_click_stime", WebViewUI.this.tGt);
                    bundle.putLong("service_click_etime", r0);
                    WebViewUI.this.jAm.r(2836, bundle);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Cli Event Exception, msg = %s", e.getMessage());
                }
                WebViewUI.this.tGs = null;
            }
            return false;
        }
    };
    private boolean tGx = true;
    @Deprecated
    private boolean tGy = false;
    private int tGz = 0;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d tsa = null;
    public aj tyl = new aj();
    private volatile String tzH;
    private int width;

    private class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private a() {
        }

        /* synthetic */ a(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://jump/");
        }

        public final boolean Cz(String str) {
            if (WebViewUI.this.jAn.bTg().cen()) {
                try {
                    WebViewUI.this.jAm.aP(str, WebViewUI.this.jAn.bTf().go(7));
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
            }
            return true;
        }
    }

    private static final class aa {
        final int id;
        final WeakReference<WebViewUI> rZo;

        public aa(WebViewUI webViewUI) {
            this.rZo = new WeakReference(webViewUI);
            this.id = webViewUI.hashCode();
        }
    }

    private class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        public final String tHR;

        private b() {
            this.tHR = "weixin://addfriend/";
        }

        /* synthetic */ b(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://addfriend/");
        }

        public final boolean Cz(String str) {
            if (WebViewUI.this.jAn.bTf().go(5)) {
                String substring = str.substring(19);
                if (bi.oN(substring)) {
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_webview", true);
                bundle.putString("userName", substring);
                try {
                    WebViewUI.this.jAm.a(8, bundle, WebViewUI.this.hashCode());
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                    return true;
                }
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
            return true;
        }
    }

    private static final class d {
        private String lang;
        private String ndS;
        private String ndT;
        private String ndU;
        private String ndV;
        private String ndW;
        private String ndX;
        String tHS;

        public d(Bundle bundle) {
            this.tHS = bundle.getString("close_window_confirm_dialog_switch");
            this.ndS = bundle.getString("close_window_confirm_dialog_title_cn");
            this.ndT = bundle.getString("close_window_confirm_dialog_title_eng");
            this.ndU = bundle.getString("close_window_confirm_dialog_ok_cn");
            this.ndV = bundle.getString("close_window_confirm_dialog_ok_eng");
            this.ndW = bundle.getString("close_window_confirm_dialog_cancel_cn");
            this.ndX = bundle.getString("close_window_confirm_dialog_cancel_eng");
            this.lang = bundle.getString("application_language");
        }

        public final String aPz() {
            if ("zh_CN".equals(this.lang)) {
                return this.ndS;
            }
            return this.ndT;
        }

        public final String aPA() {
            if ("zh_CN".equals(this.lang)) {
                return this.ndU;
            }
            return this.ndV;
        }

        public final String aPB() {
            if ("zh_CN".equals(this.lang)) {
                return this.ndW;
            }
            return this.ndX;
        }
    }

    private class e implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private e() {
        }

        /* synthetic */ e(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://critical_update/");
        }

        public final boolean Cz(String str) {
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 25, 1, true);
            WebViewUI.g(WebViewUI.this, 1);
            return true;
        }
    }

    protected class g extends com.tencent.xweb.x5.a.a.a.a.b {
        public Object onMiscCallBack(String str, Bundle bundle) {
            String str2 = null;
            String str3 = "MicroMsg.WebViewUI";
            String str4 = "method = %s, bundler == null ? %b, invoker == null ? %b";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bundle == null);
            objArr[2] = Boolean.valueOf(WebViewUI.this.jAm == null);
            com.tencent.mm.sdk.platformtools.x.i(str3, str4, objArr);
            if (bi.oN(str) || bundle == null || WebViewUI.this.jAm == null) {
                return str2;
            }
            String Pv;
            try {
                Pv = WebViewUI.this.jAm.Pv("WebviewEnableTbsDownload");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get dynamic config failed");
                Pv = str2;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "enable value = %s", Pv);
            if (bi.oN(Pv) || !Pv.equals("0")) {
                Bundle e2;
                if (str.equals("addDownloadTask")) {
                    try {
                        e2 = WebViewUI.this.jAm.e(14, bundle);
                        if (e2 != null) {
                            return Long.valueOf(e2.getLong("download_id", 0));
                        }
                    } catch (RemoteException e3) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
                    }
                }
                if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME)) {
                    try {
                        e2 = WebViewUI.this.jAm.e(16, bundle);
                        if (e2 != null) {
                            return Boolean.valueOf(e2.getBoolean("cancel_result", false));
                        }
                    } catch (RemoteException e4) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
                    }
                }
                if (str.equals("queryDownloadTask")) {
                    try {
                        e2 = WebViewUI.this.jAm.e(15, bundle);
                        if (e2 != null) {
                            return Integer.valueOf(e2.getInt("download_state", 0));
                        }
                    } catch (RemoteException e5) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
                    }
                }
                if (str.equals("installDownloadTask")) {
                    try {
                        e2 = WebViewUI.this.jAm.e(17, bundle);
                        if (e2 != null) {
                            return Boolean.valueOf(e2.getBoolean("install_result"));
                        }
                    } catch (RemoteException e6) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
                    }
                }
                if (str.equals("getDrawable")) {
                    str3 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                    int i = bundle.getInt("resourceId");
                    if (!bi.oN(str3) && i > 0) {
                        try {
                            return com.tencent.mm.bv.a.b(WebViewUI.this.getPackageManager().getResourcesForApplication(str3), i);
                        } catch (Exception e7) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", str3, e7.getMessage());
                        }
                    }
                }
                if (!str.equals("getShareUrl")) {
                    return str2;
                }
                try {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getShareUrl by x5 core, shareurl = %s", WebViewUI.this.jAm.Cu(WebViewUI.this.pzt.getUrl()));
                    return WebViewUI.this.jAm.Cu(WebViewUI.this.pzt.getUrl());
                } catch (Exception e8) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getShare url failed");
                    return str2;
                }
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
            return str2;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return WebViewUI.this.tGv.z(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return WebViewUI.this.tGv.B(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return WebViewUI.this.tGv.A(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return WebViewUI.this.tGv.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            WebViewUI.this.tGv.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            WebViewUI.this.tGv.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            WebViewUI.this.tGv.aik();
        }

        public final boolean onShowLongClickPopupMenu() {
            if (WebViewUI.this.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                return false;
            }
            return true;
        }
    }

    private class f implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private f() {
        }

        /* synthetic */ f(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://");
        }

        public final boolean Cz(String str) {
            int b = WebViewUI.this.PT(bi.oM(WebViewUI.this.tFX));
            if (!com.tencent.mm.pluginsdk.d.ai(str, WebViewUI.this.ngu)) {
                return false;
            }
            try {
                if ("weixin://dl/shopping".equals(str)) {
                    String bSG = WebViewUI.this.jAm.bSG();
                    if (!bi.oN(bSG)) {
                        WebViewUI.this.pzt.loadUrl(bSG);
                    }
                } else if ("weixin://dl/faq".equals(str)) {
                    int bSI = WebViewUI.this.jAm.bSI();
                    int bSJ = WebViewUI.this.jAm.bSJ();
                    WebViewUI.this.pzt.loadUrl(ad.getContext().getString(com.tencent.mm.R.l.eNF, new Object[]{Integer.valueOf(bSI), Integer.valueOf(bSJ)}));
                } else if ("weixin://dl/posts".equals(str)) {
                    WebViewUI.this.jAm.bSK();
                } else if ("weixin://dl/moments".equals(str)) {
                    WebViewUI.this.jAm.bSL();
                } else if (str.startsWith("weixin://dl/feedback")) {
                    WebViewUI.this.jAm.PA(str);
                } else if ("weixin://dl/scan".equals(str)) {
                    com.tencent.mm.bl.d.a(WebViewUI.this, "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                } else {
                    com.tencent.mm.pluginsdk.d.RM(str);
                }
                List arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add("1");
                arrayList.add(String.valueOf(b));
                arrayList.add(bi.oM(WebViewUI.this.tFX));
                arrayList.add(bi.oM(WebViewUI.this.fJB));
                WebViewUI.this.jAm.f(11405, arrayList);
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", e.getMessage());
                return true;
            }
        }
    }

    protected class h extends com.tencent.xweb.p {
        public boolean PD(String str) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                return true;
            }
            if (WebViewUI.this.Cs(str)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + str);
                return true;
            }
            WebViewUI.this.tGJ = str;
            return false;
        }

        public final boolean b(WebView webView, final String str) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + str);
            if (!WebViewUI.this.PV(str)) {
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
                WebViewUI.this.aPM();
                return true;
            } else if (com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "about:blank")) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
                return true;
            } else {
                try {
                    int intExtra;
                    if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                        WebViewUI.this.PR(str);
                        return true;
                    } else if (str.startsWith("weixin://dl/business") && com.tencent.mm.pluginsdk.d.j(Uri.parse(str))) {
                        String host = Uri.parse(WebViewUI.this.fJB).getHost();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.BROWSABLE");
                        intent.setData(Uri.parse(str + "&domain=" + host));
                        intExtra = WebViewUI.this.getIntent().getIntExtra("pay_channel", -1);
                        if (intExtra != -1) {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", str, Integer.valueOf(intExtra));
                            intent.putExtra("pay_channel", intExtra);
                        }
                        intent.putExtra("translate_link_scene", 13);
                        WebViewUI.this.startActivity(intent);
                        return true;
                    } else if (str.startsWith("weixinpreinject://iframe") && WebViewUI.this.tFK != null) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                        if (!str.equals(WebViewUI.this.tGH)) {
                            WebViewUI.this.tGH = "";
                            return true;
                        } else if (!WebViewUI.this.Cz(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                                return true;
                            }
                            intExtra = WebViewUI.this.tFB.Cn(str);
                            if (intExtra == 0) {
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                            if (WebViewUI.this.PP(str)) {
                                WebViewUI.this.pzt.stopLoading();
                                WebViewUI.this.pzt.post(new Runnable() {
                                    public final void run() {
                                        WebViewUI.this.Ct(str);
                                    }
                                });
                            } else {
                                WebViewUI.this.pzt.stopLoading();
                            }
                            if (str.equals(WebViewUI.this.tFo)) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return PD(str);
                            }
                            WebViewUI.this.j(str, true, intExtra);
                            return true;
                        }
                    } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                        if ((WebViewUI.this.fJB.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && WebViewUI.this.tFj) {
                            com.tencent.mm.pluginsdk.d.aT(WebViewUI.this.mController.xRr, str);
                            WebViewUI.this.finish();
                            return true;
                        }
                        if (!str.equals(WebViewUI.this.tGH)) {
                            WebViewUI.this.tGH = "";
                            return true;
                        } else if (!WebViewUI.this.Cz(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                                return true;
                            }
                            intExtra = WebViewUI.this.tFB.Cn(str);
                            if (intExtra == 0 && intExtra != 2 && (intExtra != 8 || WebViewUI.this.tFf)) {
                                return PD(str);
                            }
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                            if (WebViewUI.this.PP(str)) {
                                WebViewUI.this.pzt.stopLoading();
                                WebViewUI.this.pzt.post(/* anonymous class already generated */);
                            } else {
                                WebViewUI.this.pzt.stopLoading();
                            }
                            if (str.equals(WebViewUI.this.tFo)) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return PD(str);
                            }
                            WebViewUI.this.j(str, true, intExtra);
                            return true;
                        }
                    } else {
                        if (str.startsWith("weixin://webview/initReady/") || str.startsWith("weixin://webview/preInjectJSBridge/")) {
                            return true;
                        }
                        if (!str.equals(WebViewUI.this.tGH)) {
                            WebViewUI.this.tGH = "";
                            return true;
                        } else if (!WebViewUI.this.Cz(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                intExtra = WebViewUI.this.tFB.Cn(str);
                                if (intExtra == 0) {
                                }
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + intExtra);
                                if (WebViewUI.this.PP(str)) {
                                    WebViewUI.this.pzt.stopLoading();
                                } else {
                                    WebViewUI.this.pzt.stopLoading();
                                    WebViewUI.this.pzt.post(/* anonymous class already generated */);
                                }
                                if (str.equals(WebViewUI.this.tFo)) {
                                    WebViewUI.this.j(str, true, intExtra);
                                    return true;
                                }
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return PD(str);
                            }
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                    if (WebViewUI.this.jAn == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                        return true;
                    }
                }
            }
        }

        public final void a(WebView webView, String str, boolean z) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
            super.a(webView, str, z);
            if (com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "about:blank")) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
                return;
            }
            String url = webView.getUrl();
            if (WebViewUI.this.tFf) {
                WebViewUI.this.j(url, false, -1);
            }
            if (!(WebViewUI.this.jAn == null || WebViewUI.this.jAn.has(url))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", url);
                WebViewUI.this.j(url, false, -1);
                WebViewUI.this.J(true, false);
                WebViewUI.this.tGi = true;
            }
            WebViewUI.this.tGC.bTh();
            WebViewUI.this.tGJ = str;
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            super.b(webView, str, bitmap);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + str);
            com.tencent.mm.plugin.report.service.g.pWK.a(155, 0, 1, false);
            if (WebViewUI.this.bTA()) {
                if (TextUtils.isEmpty(str) || !str.equals(webView.getUrl())) {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", str, webView.getUrl());
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
                    WebViewUI.this.bTB();
                    if (WebViewUI.this.tFK != null) {
                        WebViewUI.this.tFK.tKB = false;
                    }
                    WebViewUI.this.bTQ();
                }
            }
            if (com.tencent.mm.sdk.a.b.cfx() && "http://www.dktest-mmcrash.com/".equals(str)) {
                Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
            }
            WebViewUI.this.tzH = WebViewUI.this.tGJ;
            WebViewUI.this.f(str, bi.Wx(), 1);
            WebViewUI.this.tyl.bRN().tzH = WebViewUI.this.tzH;
            WebViewUI.this.tGJ = str;
            g gVar = g.tEG;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", str, gVar.tEH, gVar.rke);
            String str2 = gVar.tEH;
            gVar.tEH = str;
            if (!bi.oN(gVar.rke)) {
                gVar.d(1, str2, 0);
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", WebViewUI.this.tzH, WebViewUI.this.tGJ);
            if (WebViewUI.this.PV(str)) {
                WebViewUI.this.tGC.bTh();
                WebViewUI.this.tGC.PO(str);
                if (WebViewUI.this.Cz(str)) {
                    WebViewUI.this.tGH = str;
                    return;
                }
                WebViewUI.this.tFK.bUT();
                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                if (WebViewUI.this.PP(str)) {
                    WebViewUI.this.tGa = true;
                    WebViewUI.this.tEM.finish();
                    WebViewUI.this.pzt.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (WebViewUI.this.tsa != null) {
                        WebViewUI.this.tsa.o((String) WebViewUI.this.tGj.get(str), (Map) WebViewUI.this.tGe.get(str));
                    }
                } else {
                    WebViewUI.this.tGa = false;
                    if (!WebViewUI.this.tGc) {
                        WebViewUI.this.tEM.start();
                    }
                }
                WebViewUI.q(WebViewUI.this, str);
                if (w.NO_NEED.equals(WebViewUI.this.j(str, false, -1))) {
                    WebViewUI.this.tGp.Pm(str);
                }
                WebViewUI.this.J(true, false);
                WebViewUI.this.tGi = false;
                com.tencent.mm.plugin.webview.model.aj.l bRL = WebViewUI.this.tyl.bRL();
                int J = WebViewUI.this.fNt;
                String i = WebViewUI.this.fHA;
                bRL.fNt = J;
                bRL.tzz = i;
                if (bi.oN(str)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                } else if (!bRL.tzL.containsKey(str)) {
                    bRL.tzL.put(str, Long.valueOf(bi.Wy()));
                }
                WebViewUI.this.nfb = 0;
                return;
            }
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + str);
            WebViewUI.this.aPM();
        }

        public void a(WebView webView, String str) {
            super.a(webView, str);
            WebViewUI.this.tFr = true;
            if (!WebViewUI.this.tFY) {
                WebViewUI.this.tFY = true;
                WebViewUI.this.tyl.bRP().tzs = true;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", str);
            com.tencent.mm.plugin.webview.model.aj.c bRU = WebViewUI.this.tyl.bRU();
            if (bRU.muv && !bRU.tzu) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("http")) {
                        String host = parse.getHost();
                        if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(283, 0, 1, true);
                            bRU.tzu = true;
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", str);
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", str);
                }
            }
            g gVar = g.tEG;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", gVar.rke);
            if (!bi.oN(gVar.rke)) {
                gVar.qq(2);
            }
            if (WebViewUI.this.pzt == null) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
                return;
            }
            WebViewUI.this.tGp.Pm(str);
            String title = WebViewUI.this.pzt.getTitle();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", WebViewUI.this.mController.getMMTitle(), title, Boolean.valueOf(WebViewUI.this.tEL), Boolean.valueOf(WebViewUI.this.rEZ), WebViewUI.this.tGJ);
            if (WebViewUI.this.pzt.isX5Kernel && !bi.oN(title) && title.length() > 0 && !title.equals(WebViewUI.this.mController.getMMTitle()) && !title.startsWith("http") && ((WebViewUI.this.tGJ == null || !WebViewUI.this.tGJ.equals(title)) && !WebViewUI.this.tEL && WebViewUI.this.rEZ)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                WebViewUI.this.setMMTitle(title);
            }
            WebViewUI.this.tGC.PO(WebViewUI.this.aPR());
            boolean booleanExtra = WebViewUI.this.getIntent().getBooleanExtra("shouldForceViewPort", false);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + booleanExtra);
            if (booleanExtra) {
                webView.evaluateJavascript(WebViewUI.this.getIntent().getStringExtra("view_port_code"), null);
            }
            WebViewUI.this.bTL();
            if (WebViewUI.this.PV(str)) {
                WebViewUI.this.setProgressBarIndeterminateVisibility(false);
                WebViewUI.this.tEM.finish();
                WebViewUI.this.tGH = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.this.tGh);
                WebViewUI.this.tFK.bUU();
                if (!(WebViewUI.this.jAn == null || WebViewUI.this.jAn.PN(str) == null)) {
                    WebViewUI.this.K(WebViewUI.this.jAn.PN(str).go(34), WebViewUI.this.jAn.PN(str).go(75));
                }
                WebViewUI.this.kB(false);
                com.tencent.mm.plugin.webview.model.aj.l bRL = WebViewUI.this.tyl.bRL();
                if (bi.oN(str)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                } else if (bRL.tzL.containsKey(str)) {
                    bRL.tzL.put(str, Long.valueOf(bi.Wy() - ((Long) bRL.tzL.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.aj.e bRM = WebViewUI.this.tyl.bRM();
                if (bi.oN(str)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                } else if (bRM.tzx.containsKey(str)) {
                    bRM.tzx.put(str, Long.valueOf(bi.Wy() - ((Long) bRM.tzx.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.aj.f bRO = WebViewUI.this.tyl.bRO();
                com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.jAm;
                if (!(dVar == null || bRO.kLT)) {
                    bRO.kLT = true;
                    int bRH = aj.bRH();
                    long Wy = bi.Wy() - bRO.startTime;
                    if (Wy >= 0 && Wy <= 180000) {
                        String str2 = bRO.tzz;
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Long.valueOf(Wy);
                        objArr[2] = Integer.valueOf(bRH);
                        objArr[3] = bRO.url == null ? bRO.url : bRO.url.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(aj.ndJ);
                        objArr[8] = Integer.valueOf(aj.tzq);
                        objArr[9] = Integer.valueOf(bRO.fNt);
                        objArr[10] = bRO.tzz;
                        aj.a(dVar, str2, objArr);
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", bRO.url, Long.valueOf(Wy), Integer.valueOf(bRH), Integer.valueOf(aj.ndJ), Integer.valueOf(aj.tzq), Integer.valueOf(bRO.fNt), bRO.tzz);
                    }
                }
                if (!WebViewUI.this.tFO.containsKey(str)) {
                    WebViewUI.this.tFO.put(str, Boolean.valueOf(WebViewUI.this.cnI()));
                }
                WebViewUI.this.kA(((Boolean) WebViewUI.this.tFO.get(str)).booleanValue());
                Boolean bool = (Boolean) WebViewUI.this.tFR.get(str);
                if (bool == null || !bool.booleanValue()) {
                    WebViewUI.this.showOptionMenu(0, true);
                } else {
                    WebViewUI.this.showOptionMenu(0, false);
                }
                if (WebViewUI.this.tFh && bi.oN(WebViewUI.this.tGI)) {
                    WebViewUI.this.tGI = WebViewUI.this.tGJ;
                }
                WebViewUI.this.tGM = bi.Wx();
                com.tencent.mm.sdk.b.a.xmy.m(new tu());
                return;
            }
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + str);
            WebViewUI.this.aPM();
        }

        @TargetApi(8)
        public final void a(WebView webView, com.tencent.xweb.h hVar, SslError sslError) {
            String F = webView.getUrl() == null ? WebViewUI.this.tGJ : webView.getUrl();
            com.tencent.mm.plugin.report.service.g.pWK.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.a(155, 30, 1, false);
            if (WebViewUI.this.tFI == null) {
                WebViewUI.this.tFI = new b(WebViewUI.this, WebViewUI.this.pzt);
            }
            WebViewUI.this.tFI.a(F, hVar, sslError);
        }

        public void a(WebView webView, int i, String str, String str2) {
            boolean isConnected = ao.isConnected(WebViewUI.this);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected));
            com.tencent.mm.plugin.report.service.g.pWK.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.a(155, (long) a.AP(i), 1, false);
            super.a(webView, i, str, str2);
            g.tEG.AY(i);
            if (WebViewUI.this.tFk) {
                WebViewUI.this.finish();
            }
        }

        public final void f(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + str);
            if (WebViewUI.this.PV(str)) {
                com.tencent.mm.plugin.webview.model.aj.e bRM = WebViewUI.this.tyl.bRM();
                if (bi.oN(str)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                } else if (!(bi.oN(bRM.jOH) || str.equals(bRM.jOH) || !bRM.tzy)) {
                    if (bRM.tzw.containsKey(bRM.jOH)) {
                        bRM.tzw.put(bRM.jOH, Long.valueOf(bi.Wy() - ((Long) bRM.tzw.get(bRM.jOH)).longValue()));
                    }
                    bRM.tzy = false;
                }
                super.f(webView, str);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + str);
            super.f(webView, str);
            WebViewUI.this.aPM();
        }

        public com.tencent.xweb.m c(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", str);
            if (PX(str)) {
                return null;
            }
            return PY(str);
        }

        public com.tencent.xweb.m a(WebView webView, com.tencent.xweb.l lVar) {
            if (lVar == null || lVar.getUrl() == null || bi.oN(lVar.getUrl().toString())) {
                return super.a(webView, lVar);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
            if (PX(lVar.getUrl().toString())) {
                return null;
            }
            return PY(lVar.getUrl().toString());
        }

        public com.tencent.xweb.m a(WebView webView, com.tencent.xweb.l lVar, Bundle bundle) {
            if (lVar == null || lVar.getUrl() == null || bi.oN(lVar.getUrl().toString())) {
                return super.a(webView, lVar);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
            if (PX(lVar.getUrl().toString())) {
                return null;
            }
            if (WebView.getCurWebType() != com.tencent.xweb.WebView.c.WV_KIND_X5 || WebView.getTbsCoreVersion(WebViewUI.this) > 36541) {
                try {
                    int i = bundle.getInt("resourceType");
                    if ((i == 1 || i == 7) && !WebViewUI.this.tFq) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                        WebViewUI.this.j(lVar.getUrl().toString(), false, 5);
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", e.getMessage());
                } catch (Throwable th) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", th.getMessage());
                }
            }
            return PY(lVar.getUrl().toString());
        }

        private boolean PX(String str) {
            if (WebViewUI.this.PV(str)) {
                return false;
            }
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            WebViewUI.this.aPM();
            return true;
        }

        private com.tencent.xweb.m PY(String str) {
            String aPR = WebViewUI.this.aPR();
            com.tencent.xweb.m a = WebViewUI.this.tGu.a(str, !WebViewUI.this.tFZ, WebViewUI.this.jAm);
            if (a == null) {
                return null;
            }
            if (!str.equals(aPR) && !WebViewUI.this.eX(aPR, str)) {
                return a;
            }
            WebViewUI.this.handler.post(new Runnable() {
                public final void run() {
                    if (WebViewUI.this.pzt != null) {
                        WebViewUI.this.pzt.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    }
                    WebViewUI webViewUI = WebViewUI.this;
                    Runnable anonymousClass68 = new Runnable() {
                        public final void run() {
                            if (WebViewUI.this.tEM != null) {
                                WebViewUI.this.tEM.finish();
                            }
                        }
                    };
                    if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                        anonymousClass68.run();
                    } else {
                        webViewUI.handler.post(anonymousClass68);
                    }
                }
            });
            return a;
        }
    }

    private class j implements com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a {
        private j() {
        }

        /* synthetic */ j(WebViewUI webViewUI, byte b) {
            this();
        }

        public final void wk(int i) {
            int i2 = 2;
            switch (i) {
                case 0:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
            }
            WebViewUI.this.Bf(i2);
            try {
                if (WebViewUI.this.jAm.aPk()) {
                    WebViewUI.this.jAm.eo(16384, i2);
                    WebViewUI.this.jAm.eo(16388, i2);
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
            }
        }
    }

    public static class l {
        private static final Pattern ndA = Pattern.compile(".*#.*wechat_redirect");
        public String ndB = null;
        String[] tGF = null;
        private LinkedList<String> tHV = new LinkedList();

        public l(String str) {
            this.ndB = str;
        }

        public final int Cn(String str) {
            int i = 0;
            if (bi.oN(str)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.ndB)) {
                return 0;
            } else {
                if (ndA.matcher(str).find()) {
                    return 2;
                }
                if (!bi.oN(str) && this.tGF != null && this.tGF.length != 0 && !this.tHV.contains(str)) {
                    String substring;
                    if (URLUtil.isHttpUrl(str)) {
                        substring = str.substring(7);
                    } else {
                        substring = str;
                    }
                    if (URLUtil.isHttpsUrl(substring)) {
                        substring = str.substring(8);
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", str, substring);
                    for (String str2 : this.tGF) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "force geta8key path = %s", str2);
                        if (substring.startsWith(r5[r2])) {
                            this.tHV.add(str);
                            i = 1;
                            break;
                        }
                    }
                }
                return i != 0 ? 8 : 1;
            }
        }
    }

    private class n implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private n() {
        }

        /* synthetic */ n(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://gethtml/");
        }

        public final boolean Cz(String str) {
            if (!bi.oN(str)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + str.substring(17));
                WebViewUI.this.bTG();
            }
            return false;
        }
    }

    private class c implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private c() {
        }

        /* synthetic */ c(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://webview/close/");
        }

        public final boolean Cz(String str) {
            if (WebViewUI.this.jAn.bTf().go(17)) {
                WebViewUI.this.finish();
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "close window permission fail");
            }
            return true;
        }
    }

    protected class q {
        int tHY = 0;

        protected q() {
        }
    }

    private class s implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private s() {
        }

        /* synthetic */ s(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.jAm;
            if (6 != WebViewUI.this.getIntent().getIntExtra("geta8key_scene", 0)) {
                return !bi.oN(str) && dVar != null && com.tencent.mm.plugin.webview.model.y.c.a(dVar) && com.tencent.mm.plugin.webview.model.y.c.a(str, dVar);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
                return false;
            }
        }

        public final boolean Cz(String str) {
            String stringExtra = WebViewUI.this.getIntent().getStringExtra("geta8key_username");
            return com.tencent.mm.plugin.webview.model.y.c.a(str, stringExtra, WebViewUI.this.PT(stringExtra), WebViewUI.this.jAm, WebViewUI.this.tGO, WebViewUI.this.tGP, WebViewUI.this.hashCode());
        }
    }

    private class t implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private t() {
        }

        /* synthetic */ t(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://readershare/");
        }

        public final boolean Cz(String str) {
            com.tencent.mm.ui.base.h.a(WebViewUI.this, "", new String[]{WebViewUI.this.getString(com.tencent.mm.R.l.eCl)}, "", new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    if (i == 0) {
                        t tVar = t.this;
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("shortUrl", WebViewUI.this.getIntent().getStringExtra("shortUrl"));
                            bundle.putInt(Columns.TYPE, WebViewUI.this.getIntent().getIntExtra(Columns.TYPE, 0));
                            WebViewUI.this.jAm.a(4, bundle, tVar.hashCode());
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                        }
                    }
                }
            });
            return true;
        }
    }

    private class v implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private final String tIa;

        private v() {
            this.tIa = "weixin://openapi/openwebview/result?";
        }

        /* synthetic */ v(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://openapi/openwebview/result?");
        }

        public final boolean Cz(String str) {
            Resp resp = new Resp();
            Uri parse = Uri.parse(str);
            resp.result = parse.getQuery();
            resp.errCode = bi.getInt(parse.getQueryParameter("errCode"), 0);
            resp.errStr = parse.getQueryParameter("errMsg");
            resp.transaction = WebViewUI.this.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (bi.oN(queryParameter)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
            } else {
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                com.tencent.mm.pluginsdk.model.app.p.ae(bundle);
                Args args = new Args();
                try {
                    args.targetPkgName = WebViewUI.this.jAm.Pt(queryParameter);
                    args.bundle = bundle;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", args);
                    MMessageActV2.send(WebViewUI.this, args);
                    WebViewUI.this.finish();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    }

    private class x implements IUtils {
        private x() {
        }

        /* synthetic */ x(WebViewUI webViewUI, byte b) {
            this();
        }

        public final void javaUtilLog(int i, String str, String str2) {
            switch (i) {
                case 2:
                    com.tencent.mm.sdk.platformtools.x.v(str, str2);
                    return;
                case 3:
                    com.tencent.mm.sdk.platformtools.x.d(str, str2);
                    return;
                case 4:
                    com.tencent.mm.sdk.platformtools.x.i(str, str2);
                    return;
                case 5:
                    com.tencent.mm.sdk.platformtools.x.w(str, str2);
                    return;
                case 6:
                    com.tencent.mm.sdk.platformtools.x.e(str, str2);
                    return;
                default:
                    return;
            }
        }

        public final void httpproxyReport(String... strArr) {
            com.tencent.mm.plugin.webview.model.aj.i bRS = WebViewUI.this.tyl.bRS();
            if (!(strArr == null || strArr.length == 0)) {
                if (bRS.tzA == null) {
                    bRS.tzA = new ArrayList();
                } else {
                    bRS.tzA.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", strArr[r0]);
                    bRS.tzA.add(add);
                }
            }
            com.tencent.mm.plugin.webview.model.aj.i bRS2 = WebViewUI.this.tyl.bRS();
            com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.jAm;
            if (bRS2.tzA != null && bRS2.tzA.size() != 0 && dVar != null) {
                d.a(dVar, 12033, bRS2.tzA);
                bRS2.tzA.clear();
            }
        }

        public final void idKeyReport(String str, String str2, String str3) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", str, str2, str3);
            if (!bi.oN(str) && !bi.oN(str2) && !bi.oN(str3)) {
                com.tencent.mm.plugin.report.service.g.pWK.a((long) bi.getInt(str, 0), (long) bi.getInt(str2, 0), (long) bi.getInt(str3, 0), false);
            }
        }

        public final void kvReport(String... strArr) {
            com.tencent.mm.plugin.webview.model.aj.h bRT = WebViewUI.this.tyl.bRT();
            if (!(strArr == null || strArr.length == 0)) {
                if (bRT.tzA == null) {
                    bRT.tzA = new ArrayList();
                } else {
                    bRT.tzA.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", strArr[r0]);
                    bRT.tzA.add(add);
                }
            }
            com.tencent.mm.plugin.webview.model.aj.h bRT2 = WebViewUI.this.tyl.bRT();
            com.tencent.mm.plugin.webview.stub.d dVar = WebViewUI.this.jAm;
            if (bRT2.tzA != null && bRT2.tzA.size() != 0 && dVar != null) {
                d.a(dVar, 12666, bRT2.tzA);
                bRT2.tzA.clear();
            }
        }
    }

    private class z implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private z() {
        }

        /* synthetic */ z(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://viewimage/");
        }

        public final boolean Cz(String str) {
            try {
                if (WebViewUI.this.jAm.isSDCardAvailable()) {
                    WebViewUI.this.jOH = str.substring(19);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.this.jOH);
                    com.tencent.mm.pluginsdk.ui.tools.s.a(WebViewUI.this.pzt, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.this.tFm);
                    return true;
                }
                WebViewUI.this.jAm.a(2, null, WebViewUI.this.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    protected class o {
        int tHX = 0;

        protected o() {
        }
    }

    enum w {
        NO_NEED,
        WILL_GET,
        FAILED
    }

    private class p implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private p() {
        }

        /* synthetic */ p(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://profile/");
        }

        public final boolean Cz(String str) {
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
            } else if (!(WebViewUI.this.jAn == null || WebViewUI.this.jAn.bTf() == null || !WebViewUI.this.jAn.bTf().go(2))) {
                WebViewUI.this.tsa.Qg(substring);
            }
            return true;
        }
    }

    private class u implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private u() {
        }

        /* synthetic */ u(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://recommend_update/");
        }

        public final boolean Cz(String str) {
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 24, 1, true);
            WebViewUI.g(WebViewUI.this, 2);
            return true;
        }
    }

    private class y implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private y() {
        }

        /* synthetic */ y(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://private/gethtml/");
        }

        public final boolean Cz(String str) {
            try {
                String decode = URLDecoder.decode(str.substring(25));
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", WebViewUI.this.jOH);
                bundle.putString("tweetid", bi.oM(WebViewUI.this.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt(Columns.TYPE, WebViewUI.this.getIntent().getIntExtra(Columns.TYPE, 0));
                WebViewUI.this.jAm.a(3, bundle, WebViewUI.this.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    private class i implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private final String tHU;

        private i() {
            this.tHU = "weixin://feedback/";
        }

        /* synthetic */ i(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://feedback/");
        }

        public final boolean Cz(String str) {
            Bundle bundle = new Bundle();
            bundle.putInt(com.tencent.mm.ui.u.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
            bundle.putInt(com.tencent.mm.ui.u.FLAG_OVERRIDE_EXIT_ANIMATION, com.tencent.mm.R.a.bqm);
            try {
                WebViewUI.this.jAm.a(7, bundle, WebViewUI.this.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            return true;
        }
    }

    private class k implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private k() {
        }

        /* synthetic */ k(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://connectToFreeWifi/");
        }

        public final boolean Cz(String str) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "apKey value = %s", queryParameter);
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!bi.oN(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!bi.oN(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.bl.d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            return true;
        }
    }

    protected class m {
        int tHW = 0;

        protected m() {
        }

        public final void bTY() {
            if (this.tHW == 0) {
                WebViewUI.this.AZ(233);
            }
            this.tHW++;
        }

        public final void bTZ() {
            this.tHW--;
            if (this.tHW <= 0) {
                WebViewUI.this.Ba(233);
            }
        }
    }

    private class r implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        private r() {
        }

        /* synthetic */ r(WebViewUI webViewUI, byte b) {
            this();
        }

        public final boolean Cy(String str) {
            if (bi.oN(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eL(str, "weixin://manual_update/");
        }

        public final boolean Cz(String str) {
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 26, 1, true);
            WebViewUI.g(WebViewUI.this, 3);
            return true;
        }
    }

    static /* synthetic */ void R(WebViewUI webViewUI) {
        webViewUI.bTM();
        if (!webViewUI.aPV()) {
            webViewUI.tGm = true;
            g.tEG.close();
            webViewUI.finish();
        }
    }

    static /* synthetic */ void S(WebViewUI webViewUI) {
        View view = webViewUI.pzt.getView();
        view.scrollTo(view.getScrollX(), 0);
        com.tencent.mm.plugin.webview.model.aj.g bRQ = webViewUI.tyl.bRQ();
        bRQ.tzv = new Object[]{webViewUI.fJB, Integer.valueOf(7)};
        bRQ.c(webViewUI.jAm);
    }

    static /* synthetic */ void Z(WebViewUI webViewUI) {
        CharSequence url = webViewUI.pzt.getUrl();
        if (url == null || url.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "copyLink fail, url is null");
            return;
        }
        CharSequence Cu;
        try {
            Cu = webViewUI.jAm.Cu(url);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "copy link failed");
            Cu = url;
        }
        ClipboardManager clipboardManager = (ClipboardManager) webViewUI.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(Cu);
                Toast.makeText(webViewUI, webViewUI.getString(com.tencent.mm.R.l.eYm), 0).show();
                return;
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e2, "clip.setText error", new Object[0]);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "clipboard manager is null");
    }

    static /* synthetic */ void a(WebViewUI webViewUI, MenuItem menuItem) {
        if (menuItem instanceof com.tencent.mm.ui.base.o) {
            String str = ((com.tencent.mm.ui.base.o) menuItem).jhS;
            if (!bi.oN(str) && !str.equals(webViewUI.pzt.getUrl())) {
                webViewUI.pzt.loadUrl(str);
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (!webViewUI.tFr) {
            return;
        }
        if (webViewUI.pzt.getX5WebViewExtension() == null && VERSION.SDK_INT < 19) {
            return;
        }
        if (i == -3) {
            final int i2 = webViewKeyboardLinearLayout.tEd;
            webViewUI.handler.post(new Runnable() {
                public final void run() {
                    if (WebViewUI.this.tsa != null) {
                        WebViewUI.this.tsa.Br(i2);
                    }
                }
            });
            return;
        }
        webViewUI.handler.post(new Runnable() {
            public final void run() {
                if (WebViewUI.this.tsa != null) {
                    WebViewUI.this.tsa.Br(0);
                }
            }
        });
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, long j) {
        final Intent intent = new Intent(webViewUI, WebViewDownloadWithX5UI.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("task_url", str);
        intent.putExtra("page_url", webViewUI.aPR());
        intent.putExtra("task_size", j);
        if (WebView.getTbsCoreVersion(webViewUI) < 43305 || WebView.getCurWebType() != com.tencent.xweb.WebView.c.WV_KIND_X5) {
            webViewUI.startActivity(intent);
        } else {
            QbSdk.fileInfoDetect(webViewUI, str, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onReceiveValue value = %s", str);
                    if (!bi.oN(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optBoolean("ret")) {
                                intent.putExtra("title", jSONObject.optString("appName"));
                                intent.putExtra("thumb_url", jSONObject.optString("apkIconUrl"));
                            }
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "onReceiveValue", new Object[0]);
                        }
                    }
                    WebViewUI.this.startActivity(intent);
                }
            });
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, String str2, int i, int i2) {
        if (webViewUI.jAn == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "startGetReadingModeInfo fail, after onDestroy");
            return;
        }
        o oVar = webViewUI.tFD;
        if (oVar.tHX == 0) {
            oVar.tGT.AZ(673);
        }
        oVar.tHX++;
        webViewUI.tFN = str;
        webViewUI.tFM = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        bundle.putInt("webview_binder_id", webViewUI.hashCode());
        boolean z = false;
        try {
            z = webViewUI.jAm.r(673, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "startGetReadingModeInfo, doScene ret = " + z);
    }

    static /* synthetic */ void aa(WebViewUI webViewUI) {
        com.tencent.mm.plugin.webview.stub.d dVar = webViewUI.jAm;
        if (webViewUI != null && !webViewUI.isFinishing()) {
            String aPR = webViewUI.aPR();
            if (bi.oN(aPR)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                return;
            }
            if (dVar != null) {
                try {
                    aPR = dVar.Cu(aPR);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", e);
                }
            }
            if (!(aPR.startsWith("http://") || aPR.startsWith("https://"))) {
                aPR = "http://" + aPR;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aPR));
            try {
                if (bi.PZ()) {
                    webViewUI.startActivity(intent);
                } else {
                    webViewUI.startActivityForResult(com.tencent.mm.plugin.webview.modeltools.a.a(webViewUI, intent, aPR), 2);
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", e2.getMessage());
            }
        }
    }

    static /* synthetic */ void ab(WebViewUI webViewUI) {
        webViewUI.tsa.aQ("sendEmail", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:email", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
    }

    static /* synthetic */ void ah(WebViewUI webViewUI) {
        webViewUI.tsa.aQ(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            try {
                dVar.jAm.G("scene", "wework", dVar.tBL);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
    }

    static /* synthetic */ void ai(WebViewUI webViewUI) {
        String str = null;
        try {
            str = webViewUI.jAm.Cu(webViewUI.pzt.getUrl());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getShareUrl failed : %s", e.getMessage());
        }
        if (bi.oN(str)) {
            str = webViewUI.fJB;
        }
        try {
            str = "weread://mp?url=" + com.tencent.mm.compatible.util.p.encode(str, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "encode url failed ; %s", e2.getMessage());
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "now url = %s", str);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bi.k(webViewUI.mController.xRr, intent)) {
            webViewUI.startActivity(intent);
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "not availble app match this intent");
        }
    }

    static /* synthetic */ void aj(WebViewUI webViewUI) {
        webViewUI.tsa.aQ("shareQQ", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:qq", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
    }

    static /* synthetic */ void ak(WebViewUI webViewUI) {
        webViewUI.tsa.aQ("shareWeiboApp", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:weiboApp", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
    }

    static /* synthetic */ void al(WebViewUI webViewUI) {
        webViewUI.tsa.aQ("shareQZone", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:QZone", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
    }

    static /* synthetic */ void am(WebViewUI webViewUI) {
        webViewUI.tsa.aQ(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
            try {
                dVar.jAm.G("scene", "facebook", dVar.tBL);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
    }

    static /* synthetic */ void an(WebViewUI webViewUI) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            final Object stringArrayList = webViewUI.jAm.e(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                if (stringArrayList.size() == 1) {
                    webViewUI.PQ((String) stringArrayList.get(0));
                    return;
                }
                webViewUI.cs(stringArrayList);
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(webViewUI.mController.xRr);
                lVar.a(webViewUI.pzt, webViewUI, null);
                lVar.zux = new com.tencent.mm.ui.base.p.a() {
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        if (WebViewUI.i(menuItem)) {
                            imageView.setVisibility(8);
                            return;
                        }
                        String str = menuItem.getTitle();
                        if (WebViewUI.this.tFG.get(str) == null || ((Bitmap) WebViewUI.this.tFG.get(str)).isRecycled()) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                            try {
                                String Pq = WebViewUI.this.jAm.Pq(str);
                                if (!bi.oN(Pq)) {
                                    Bitmap PH = d.PH(Pq);
                                    if (PH != null && !PH.isRecycled()) {
                                        imageView.setImageBitmap(PH);
                                        WebViewUI.this.tFG.put(str, PH);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                                return;
                            }
                        }
                        imageView.setImageBitmap((Bitmap) WebViewUI.this.tFG.get(str));
                    }
                };
                lVar.zuy = new com.tencent.mm.ui.base.p.b() {
                    public final void a(TextView textView, MenuItem menuItem) {
                        String str = menuItem.getTitle();
                        if (textView != null) {
                            String str2 = (String) WebViewUI.this.tFH.get(str);
                            if (bi.oN(str2)) {
                                textView.setText(str);
                            } else {
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(WebViewUI.this.mController.xRr, str2, textView.getTextSize()));
                            }
                        }
                    }
                };
                lVar.b(webViewUI.pzt, new OnCreateContextMenuListener() {
                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        Iterator it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            contextMenu.add((String) it.next());
                        }
                    }
                }, new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        WebViewUI.this.PQ(menuItem.getTitle().toString());
                    }
                });
                lVar.bCH();
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "builder add, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void ao(WebViewUI webViewUI) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "JumpToReadArticle");
        if (webViewUI.tsa != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
            if (dVar.tNo) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onArticleReadBtnClicked");
                ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass18(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onArticleReadingBtnClicked", new HashMap(), dVar.tNq, dVar.tNr)));
                return;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onArticleReadBtnClicked fail, not ready");
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, int i) {
        if (webViewUI.tEX != null && com.tencent.mm.compatible.util.d.fN(21)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.tEX.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.tEX.setLayoutParams(marginLayoutParams);
            }
        }
    }

    static /* synthetic */ void c(WebViewUI webViewUI, int i) {
        if (webViewUI.tEY != null && com.tencent.mm.compatible.util.d.fN(21)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.tEY.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.tEY.setLayoutParams(marginLayoutParams);
            }
            if (webViewUI.pzt.isX5Kernel) {
                i = webViewUI.tEY.getVisibility() == 0 ? webViewUI.tEY.getHeight() + i : 0;
            } else if (webViewUI.tEY.getVisibility() == 0) {
                i += webViewUI.tEY.getHeight();
            }
            webViewUI.pzt.setPadding(webViewUI.pzt.getPaddingLeft(), webViewUI.pzt.getPaddingTop(), webViewUI.pzt.getPaddingRight(), i);
        }
    }

    static /* synthetic */ void c(WebViewUI webViewUI, String str) {
        if (webViewUI.jAm != null) {
            Bundle bundle = new Bundle(1);
            bundle.putString("show_kb_input_callback_text", bi.oM(str));
            try {
                webViewUI.jAm.a(41, bundle, webViewUI.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", e, str);
            }
        }
        if (webViewUI.tEX != null) {
            webViewUI.tEX.hide();
        }
    }

    static /* synthetic */ void e(WebViewUI webViewUI, String str) {
        try {
            webViewUI.jAm.Py(str);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "sendImgToFriend fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void f(WebViewUI webViewUI, String str) {
        try {
            com.tencent.mm.pluginsdk.model.c.a(webViewUI.jAm.Px(str), 34, (Activity) webViewUI, webViewUI.nfQ);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void g(WebViewUI webViewUI, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("update_type_key", i);
        try {
            webViewUI.jAm.a(1, bundle, webViewUI.hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "doUpdate fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void h(WebViewUI webViewUI, String str) {
        if (webViewUI.tsa != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, 43);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
            try {
                dVar.jAm.a(21, bundle, dVar.tBL);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = " + e);
            }
        }
    }

    static /* synthetic */ void i(WebViewUI webViewUI, String str) {
        webViewUI.tsa.aQ("profile", true);
        webViewUI.tsa.Qg(str);
    }

    static /* synthetic */ boolean i(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    static /* synthetic */ void j(WebViewUI webViewUI, String str) {
        if (!(bi.oN(str) || str.equals(webViewUI.pzt.getUrl()))) {
            webViewUI.pzt.loadUrl(str);
        }
        webViewUI.tFM = false;
    }

    static /* synthetic */ void l(WebViewUI webViewUI, String str) {
        webViewUI.tsa.aQ(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tsa;
        if (dVar.tNo) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "connector");
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tNq, dVar.tNr) + ")", null);
            try {
                dVar.jAm.G("connector_local_send", str, dVar.tBL);
                dVar.jAm.G("scene", "connector", dVar.tBL);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
    }

    static /* synthetic */ void p(WebViewUI webViewUI) {
        webViewUI.tGC.tEo = new com.tencent.mm.plugin.webview.ui.tools.f.a() {
            public final void bTj() {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
                if (WebViewUI.this.tsa != null) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                    if (dVar.tNo) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                        ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass54(com.tencent.mm.plugin.webview.ui.tools.jsapi.d.Qj(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onPullDownRefresh", null, dVar.tNq, dVar.tNr))));
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
                }
            }
        };
        f fVar = webViewUI.tGC;
        fVar.iQf = true;
        if (fVar.tEq != null) {
            fVar.tEq.setVisibility(0);
            fVar.tEq.tCK = fVar;
            fVar.tEq.tCH = true;
            fVar.tEq.ky(false);
            fVar.tEq.tCI = fVar.tEr;
        }
        if (fVar.tEp != null) {
            fVar.tEp.setWillNotDraw(true);
            fVar.tEp.setImageResource(f.tEs);
            fVar.tEp.setVisibility(0);
            fVar.tEp.setAlpha(0.0f);
            fVar.tEp.setWillNotDraw(false);
            fVar.tEp.invalidate();
        }
        if (fVar.tEB != null) {
            fVar.tEB.setVisibility(8);
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI) {
        if (webViewUI.pzt != null) {
            webViewUI.pzt.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "get background color s = %s", str);
                    if (!bi.oN(str)) {
                        int color = WebViewUI.this.getResources().getColor(com.tencent.mm.R.e.bui);
                        String[] split;
                        if (WebViewUI.nfi.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 4) {
                                try {
                                    color = Color.argb(bi.getInt(bi.oM(split[3]).trim(), 0), bi.getInt(bi.oM(split[0]).trim(), 0), bi.getInt(bi.oM(split[1]).trim(), 0), bi.getInt(bi.oM(split[2]).trim(), 0));
                                } catch (Exception e) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e);
                                    return;
                                }
                            }
                            return;
                        } else if (WebViewUI.nfj.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 3) {
                                try {
                                    color = Color.argb(255, bi.getInt(bi.oM(split[0]).trim(), 0), bi.getInt(bi.oM(split[1]).trim(), 0), bi.getInt(bi.oM(split[2]).trim(), 0));
                                } catch (Exception e2) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", str, e2);
                                    return;
                                }
                            }
                            return;
                        } else {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", str);
                        }
                        WebViewUI.this.tGC.AX(color);
                        WebViewUI.this.tGC.bTi();
                    }
                }
            });
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI, String str) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) webViewUI.tGG.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            webViewUI.tGG.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
        }
    }

    static {
        Set hashSet = new HashSet();
        tyO = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.hbw;
        if (!bi.oN(str)) {
            str = com.tencent.mm.compatible.util.e.hbw.replace("/data/user/0", "/data/data");
        }
        tyO.add("file://" + new File(com.tencent.mm.plugin.aj.a.g.Aj(0)).getAbsolutePath());
        tyO.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "fts/res").getAbsolutePath());
        tyO.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        tyO.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "wenote/res").getAbsolutePath());
        tyO.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath());
        tyO.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        tyO.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "emoji/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", r1.getAbsolutePath(), r0.getAbsolutePath());
        tyO.add("file://" + new File(com.tencent.mm.plugin.aj.a.g.Aj(1)).getAbsolutePath());
        tyO.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "fts_browse/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", r0.getAbsolutePath(), r1.getAbsolutePath());
        Iterator it = tyO.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", (String) it.next());
        }
    }

    public void T(Bundle bundle) {
    }

    public void U(Bundle bundle) {
        int color;
        int i;
        boolean z = bundle.getBoolean("set_navigation_bar_color_reset", false);
        if (z) {
            color = getResources().getColor(com.tencent.mm.R.e.bre);
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        Drawable colorDrawable = new ColorDrawable(color);
        colorDrawable.setAlpha(i);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
        }
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(com.tencent.mm.R.h.divider);
            if (findViewById != null && !z) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setNavigationBar set divider half_alpha_white color");
                findViewById.setBackgroundColor(getResources().getColor(com.tencent.mm.R.e.bsL));
            } else if (findViewById != null && z) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "setNavigationBar set divider actionbar_devider_color color");
                findViewById.setBackgroundColor(getResources().getColor(com.tencent.mm.R.e.brh));
            }
            customView.setBackgroundDrawable(colorDrawable);
            customView.invalidate();
            if (color == getResources().getColor(com.tencent.mm.R.e.bre)) {
                color = getResources().getColor(com.tencent.mm.R.e.btT);
            } else {
                color = d.j(color, 0.8f);
            }
            setStatusBarColor(color);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "setNavigationBar view is null");
    }

    private void Cr(String str) {
        if (this.pzt != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.pzt, new Object[0]);
            } catch (NoSuchMethodException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private void kz(boolean z) {
        if (!z) {
            this.tFv = true;
        }
    }

    public void onResume() {
        Bundle bundle;
        super.onResume();
        this.tyl.bRN().tzJ = bi.Wz();
        g gVar = g.tEG;
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", gVar.rke);
        if (!bi.oN(gVar.rke)) {
            gVar.qq(7);
        }
        if (!this.tGx) {
            int hashCode = hashCode();
            for (int size = tFu.size() - 1; size >= 0; size--) {
                if (((aa) tFu.get(size)).id == hashCode) {
                    tFu.remove(size);
                    break;
                }
            }
            tFu.add(new aa(this));
        }
        this.tGx = false;
        if (this.tFv) {
            kz(true);
            this.tFv = false;
        }
        bTv();
        if (this.jAm != null) {
            try {
                bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.jAm.e(83, bundle);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
        Cr("onResume");
        Cq("onResume");
        try {
            if (this.jAm != null) {
                bundle = this.jAm.e(19, null);
                if (bundle != null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onResume, has init = %b", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")));
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", e2.getMessage());
        }
        this.kIK = bi.Wx();
        com.tencent.mm.modelstat.d.b(3, "WebViewUI_" + PT(bi.oM(this.tFX)), hashCode());
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + PT(bi.oM(this.tFX)), hashCode());
        com.tencent.mm.modelstat.d.g("WebViewUI_" + PT(bi.oM(this.tFX)), this.kIK, bi.Wx());
        com.tencent.mm.plugin.webview.model.aj.j bRN = this.tyl.bRN();
        if (bRN.tzJ != -1) {
            bRN.jNM += bi.bB(bRN.tzJ) / 1000;
        }
        g gVar = g.tEG;
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", gVar.rke);
        if (gVar.hjU) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!bi.oN(gVar.rke)) {
            gVar.qq(6);
        }
        try {
            if (this.jAm != null) {
                Bundle e = this.jAm.e(19, null);
                if (e != null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPause, has init = %b", Boolean.valueOf(e.getBoolean("webview_video_proxy_init")));
                    if (e.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "notify app toback failed : %s", e2.getMessage());
        }
        bTF();
        Cr("onPause");
        Cq("onPause");
        if (this.tFy != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.tFy.onHideCustomView();
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e3, "onPause", new Object[0]);
            }
        }
    }

    public void finish() {
        if (this.tFg) {
            setResult(-1);
        }
        try {
            if (this.jAm != null) {
                this.jAm.AM(hashCode());
                this.jAm.AI(hashCode());
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + e);
        }
        this.tGn = true;
        super.finish();
    }

    public int getLayoutId() {
        return com.tencent.mm.R.i.cYM;
    }

    protected boolean convertActivityFromTranslucent() {
        return getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    }

    public void setMMTitle(String str) {
        super.setMMTitle(str);
        oj(bTp());
    }

    private void Cq(String str) {
        if (this.tsa != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tsa;
            if (dVar.tNo) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + str);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("activity:state_change", hashMap, dVar.tNq, dVar.tNr);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    try {
                        dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
                    }
                } else {
                    ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass7(a));
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
            }
            try {
                if (str.equals("onPause")) {
                    this.jAm.AO(hashCode());
                } else if (str.equals("onResume")) {
                    this.jAm.AN(hashCode());
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onResume, ex = " + e2.getMessage());
            }
        }
    }

    public boolean bSW() {
        return false;
    }

    private void bTk() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.lwY, 1);
    }

    protected final void onCreateBeforeSetContentView() {
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        String str;
        Bundle bundle2;
        boolean z;
        super.onCreate(bundle);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.tFn = getIntent().getIntExtra("geta8key_session_id", (int) System.currentTimeMillis());
        this.tFp = getIntent().getByteArrayExtra("geta8key_cookie");
        this.tFb = bTy();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.tFl = getIntent().getBooleanExtra("from_shortcut", false);
        this.nrY = getIntent().getStringExtra("status_bar_style");
        this.nrX = getIntent().getIntExtra("customize_status_bar_color", 0);
        if (getIntent() == null) {
            str = "";
        } else {
            str = getIntent().getStringExtra("custom_action_bar_color");
        }
        if (!bi.oN(str)) {
            Integer valueOf;
            try {
                valueOf = Integer.valueOf(Color.parseColor(str));
            } catch (Exception e) {
                valueOf = null;
            }
            if (valueOf != null) {
                bundle2 = new Bundle(1);
                bundle2.putInt("set_navigation_bar_color_color", valueOf.intValue());
                bundle2.putInt("set_navigation_bar_color_alpha", 255);
                U(bundle2);
                if (!getIntent().hasExtra("customize_status_bar_color")) {
                    this.nrX = valueOf.intValue();
                }
            }
        }
        this.fJB = bTy();
        this.tGc = getIntent().getBooleanExtra("show_native_web_view", false);
        this.tFa = getIntent().getBooleanExtra("key_trust_url", false);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "albie: trustUrl : %b.", Boolean.valueOf(this.tFa));
        tGl++;
        tFu.add(new aa(this));
        if (tFu.size() > 1) {
            aa aaVar = (aa) tFu.get(tFu.size() - 2);
            if (!(aaVar.rZo == null || aaVar.rZo.get() == null)) {
                ((WebViewUI) aaVar.rZo.get()).kz(false);
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "initView , rawUrl = %s ", this.fJB);
        this.fHA = bi.oM(getIntent().getStringExtra("KPublisherId"));
        this.fNt = PT(getIntent().getStringExtra("geta8key_username"));
        com.tencent.mm.plugin.webview.model.aj.m bRJ = this.tyl.bRJ();
        int i = this.fNt;
        String str2 = this.fHA;
        bRJ.fNt = i;
        bRJ.tzz = str2;
        this.handler = new com.tencent.mm.sdk.platformtools.ag();
        if (this.tyl != null) {
            aj ajVar = this.tyl;
            bundle2 = getIntent().getBundleExtra("mm_report_bundle");
            if (bundle2 != null) {
                if (ajVar.tzp != null) {
                    ajVar.tzp.mym = null;
                }
                ajVar.tzp = new com.tencent.mm.plugin.webview.model.aj.a(bundle2);
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.tFc = z;
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.nfO.clear();
        this.nfO.put("menuItem:share:brand", Integer.valueOf(0));
        this.nfO.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.nfO.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.nfO.put("menuItem:share:timeline", Integer.valueOf(2));
        this.nfO.put("menuItem:favorite", Integer.valueOf(3));
        this.nfO.put("menuItem:profile", Integer.valueOf(5));
        this.nfO.put("menuItem:addContact", Integer.valueOf(5));
        this.nfO.put("menuItem:copyUrl", Integer.valueOf(6));
        this.nfO.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.nfO.put("menuItem:share:email", Integer.valueOf(8));
        this.nfO.put("menuItem:delete", Integer.valueOf(9));
        this.nfO.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.nfO.put("menuItem:setFont", Integer.valueOf(11));
        this.nfO.put("menuItem:editTag", Integer.valueOf(12));
        this.nfO.put("menuItem:readMode", Integer.valueOf(14));
        this.nfO.put("menuItem:originPage", Integer.valueOf(14));
        this.nfO.put("menuItem:share:qq", Integer.valueOf(20));
        this.nfO.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.nfO.put("menuItem:share:QZone", Integer.valueOf(22));
        this.nfO.put("menuItem:share:Facebook", Integer.valueOf(33));
        this.nfO.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.nfO.put("menuItem:refresh", Integer.valueOf(28));
        this.nfO.put("menuItem:share:wework", Integer.valueOf(25));
        this.nfO.put("menuItem:share:weread", Integer.valueOf(26));
        this.nfO.put("menuItem:keepTop", Integer.valueOf(30));
        this.nfO.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.nfO.put("menuItem:addShortcut", Integer.valueOf(29));
        this.nfO.put("menuItem:search", Integer.valueOf(31));
        this.nfO.put("menuItem:readArticle", Integer.valueOf(34));
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.pluginsdk.model.x.a.eg(this);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "initWebView, check Tbs time consumed = %d(ms)", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        this.pzt = bTr();
        this.pzt.zEM = this;
        if (!(this.pzt == null || this.pzt.isX5Kernel || com.tencent.mm.compatible.util.d.fN(19))) {
            try {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new com.tencent.mm.compatible.loader.c(this.pzt, "mSysWebView", null).get());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get());
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get());
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj);
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
            }
        }
        this.pzt.getSettings().setJavaScriptEnabled(booleanExtra3);
        this.pzt.getSettings().setPluginsEnabled(booleanExtra);
        this.pzt.getSettings().cJp();
        this.pzt.getSettings().setBuiltInZoomControls(booleanExtra2);
        this.pzt.getSettings().setUseWideViewPort(true);
        this.pzt.getSettings().setLoadWithOverviewMode(true);
        this.pzt.getSettings().cJk();
        this.pzt.getSettings().cJj();
        this.pzt.getSettings().setGeolocationEnabled(true);
        this.pzt.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.pzt.getSettings().cJr();
        this.pzt.getSettings().cJn();
        this.pzt.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.pzt.getSettings().cJm();
        this.pzt.getSettings().cJo();
        this.pzt.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.hbu + "databases/");
        com.tencent.xweb.b.cJc().cJd();
        com.tencent.xweb.b.cJc().b(this.pzt);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e3) {
        }
        bTk();
        this.jAn = new e(this, this.pzt);
        initView();
        Cq("onCreate");
        this.jKI = this.pzt.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", " onCreate fromScene %d", Integer.valueOf(this.fromScene));
        this.frp = com.tencent.mm.y.u.hC(bi.oM(hashCode()));
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", " onCreate sessionId %s", this.frp);
        if (ao.isConnected(this)) {
            if (ao.isWifi((Context) this)) {
                this.networkType = 1;
            } else if (ao.is4G(this)) {
                this.networkType = 4;
            } else if (ao.is3G(this)) {
                this.networkType = 3;
            } else if (ao.is2G(this)) {
                this.networkType = 2;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "get networkType %d", Integer.valueOf(this.networkType));
        }
        this.width = getResources().getDisplayMetrics().widthPixels;
        this.height = getResources().getDisplayMetrics().heightPixels;
        com.tencent.mm.plugin.webview.model.aj.f bRO = this.tyl.bRO();
        int i2 = this.fNt;
        String str3 = this.fHA;
        bRO.fNt = i2;
        bRO.tzz = str3;
        bRO.url = this.fJB;
        com.tencent.mm.plugin.webview.model.aj.c bRU = this.tyl.bRU();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", this.fJB);
        try {
            Uri parse = Uri.parse(this.fJB);
            final ViewGroup viewGroup;
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str3 = parse.getHost();
                if (str3 == null || str3.toLowerCase().endsWith(".qq.com")) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", str3);
                    try {
                        this.nrV = this.mController.contentView;
                        if (this.nrV != null) {
                            aSc();
                            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new OnLayoutChangeListener() {
                                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                    WebViewUI.this.aSc();
                                }
                            });
                        }
                    } catch (Exception e22) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", e22.getMessage());
                    }
                    try {
                        if (com.tencent.mm.compatible.util.d.fN(21)) {
                            viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                            viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                    WebViewUI.this.a(viewGroup, windowInsets);
                                    return windowInsets.consumeSystemWindowInsets();
                                }
                            });
                        } else {
                            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                        }
                    } catch (Exception e222) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", e222.getMessage());
                    }
                    this.tEW = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tGA);
                    this.tGo.Dt().F(new Runnable() {
                        public final void run() {
                            com.tencent.mm.bw.f.chQ();
                            com.tencent.mm.bw.b.chK();
                        }
                    });
                    this.tGr = new WebViewClipBoardHelper(this);
                    this.tGw.cfB();
                }
                bRU.muv = true;
                this.nrV = this.mController.contentView;
                if (this.nrV != null) {
                    aSc();
                    ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
                }
                if (com.tencent.mm.compatible.util.d.fN(21)) {
                    ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                } else {
                    viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                    viewGroup.setOnApplyWindowInsetsListener(/* anonymous class already generated */);
                }
                this.tEW = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tGA);
                this.tGo.Dt().F(/* anonymous class already generated */);
                this.tGr = new WebViewClipBoardHelper(this);
                this.tGw.cfB();
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", parse.getScheme());
            this.nrV = this.mController.contentView;
            if (this.nrV != null) {
                aSc();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
            }
            if (com.tencent.mm.compatible.util.d.fN(21)) {
                viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                viewGroup.setOnApplyWindowInsetsListener(/* anonymous class already generated */);
            } else {
                ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
            }
            this.tEW = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tGA);
            this.tGo.Dt().F(/* anonymous class already generated */);
            this.tGr = new WebViewClipBoardHelper(this);
            this.tGw.cfB();
        } catch (Exception e4) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", r3);
        }
    }

    public boolean bTl() {
        return true;
    }

    public final int bTm() {
        if (getResources().getDimensionPixelSize(com.tencent.mm.R.f.byt) > com.tencent.mm.bu.a.fromDPToPix(this, 48)) {
            return getResources().getDimensionPixelSize(com.tencent.mm.R.f.byt);
        }
        if (com.tencent.mm.compatible.util.j.aS(this)) {
            return getResources().getDimensionPixelSize(com.tencent.mm.R.f.buH);
        }
        return getResources().getDimensionPixelSize(com.tencent.mm.R.f.buG);
    }

    protected final void aSc() {
        if (this.nrV != null) {
            Object obj = (this.tEU || this.tEV) ? 1 : null;
            if (obj == null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nrV.getLayoutParams();
                int bTn = bTn();
                if (bTn != marginLayoutParams.topMargin) {
                    marginLayoutParams.topMargin = bTn;
                    this.nrV.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public int bTn() {
        return this.jSO + bTm();
    }

    @TargetApi(21)
    public void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        if (this.jSO != windowInsets.getSystemWindowInsetTop()) {
            View viewGroup2;
            this.jSO = windowInsets.getSystemWindowInsetTop();
            aSc();
            if (viewGroup2 instanceof SwipeBackLayout) {
                viewGroup2 = viewGroup2.getChildAt(0);
            }
            int i = com.tencent.mm.R.h.action_bar_container;
            if (i > 0) {
                View findViewById = viewGroup2.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            if (bTo()) {
                bTq();
            }
        }
    }

    public boolean bTo() {
        return true;
    }

    public int alo() {
        return getResources().getColor(com.tencent.mm.R.e.btT);
    }

    protected final int bTp() {
        if (com.tencent.mm.compatible.util.d.fN(21) && aSd()) {
            return com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR;
        }
        return getResources().getColor(com.tencent.mm.R.e.brf);
    }

    private boolean aSd() {
        if (bi.oN(this.nrY) || !this.nrY.equals("black")) {
            return false;
        }
        return true;
    }

    public final void bTq() {
        if (!com.tencent.mm.compatible.util.d.fN(21) || this.nrX == 0) {
            setStatusBarColor(alo());
            return;
        }
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.nrX));
        if (aSd()) {
            cnJ();
        }
        U(this.nrX, aSd());
    }

    public final void U(int i, boolean z) {
        if (VERSION.SDK_INT >= 23 && !com.tencent.mm.compatible.util.h.zq()) {
            setStatusBarColor(i);
            Window window = getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        } else if (VERSION.SDK_INT >= 21) {
            if (z) {
                i = d.j(i, 0.78f);
            }
            setStatusBarColor(i);
        }
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        if (this.jSO > 0 && !com.tencent.mm.compatible.util.d.fO(21)) {
            getWindow().setStatusBarColor(0);
            if (this.nrW == null) {
                this.nrW = new View(this);
                ((ViewGroup) findViewById(16908290)).addView(this.nrW, new LayoutParams(-1, this.jSO));
            } else {
                LayoutParams layoutParams = this.nrW.getLayoutParams();
                if (layoutParams.height != this.jSO) {
                    layoutParams.height = this.jSO;
                    this.nrW.setLayoutParams(layoutParams);
                }
            }
            this.nrW.setBackgroundColor(i);
        }
    }

    public final String aPR() {
        if (this.handler == null) {
            return this.tGJ;
        }
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            return this.pzt == null ? "" : this.pzt.getUrl();
        } else {
            if (!bi.oN(this.tGJ)) {
                return this.tGJ;
            }
            this.tGJ = (String) new bd<String>("") {
                protected final /* synthetic */ Object run() {
                    return WebViewUI.this.pzt == null ? "" : WebViewUI.this.pzt.getUrl();
                }
            }.b(this.handler);
            return this.tGJ;
        }
    }

    public MMWebView bTr() {
        return com.tencent.mm.ui.widget.MMWebView.a.co(this);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public void afw() {
        if (VERSION.SDK_INT <= 10) {
            super.afw();
        } else if (this.screenOrientation == -1) {
            this.xQT = getSharedPreferences(ad.cgf(), 4).getBoolean("settings_landscape_mode", false);
            if (this.xQT) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    public final int getForceOrientation() {
        return this.screenOrientation;
    }

    private View bTs() {
        int identifier;
        View view = null;
        if (com.tencent.mm.compatible.util.d.fN(11)) {
            try {
                identifier = Resources.getSystem().getIdentifier("action_bar_container", SlookAirButtonFrequentContactAdapter.ID, "android");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", e);
            }
            if (identifier > 0) {
                view = findViewById(identifier);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", Integer.valueOf(identifier), view);
            return view;
        }
        identifier = -1;
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", Integer.valueOf(identifier), view);
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.tGz != configuration.orientation) {
            View bTs = bTs();
            bTs = bTs == null ? null : (View) bTs.getParent();
            if (bTs != null) {
                bTs.dispatchConfigurationChanged(configuration);
                bTs.requestLayout();
                this.tGz = configuration.orientation;
            }
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onStart");
    }

    protected void onStop() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onStop");
        J(true, true);
        super.onStop();
    }

    private void AZ(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.jAm.a(5, bundle, hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
        }
    }

    private void Ba(int i) {
        try {
            if (this.jAm != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.jAm.a(6, bundle, hashCode());
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    @TargetApi(11)
    public void onDestroy() {
        Bundle bundle;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        if (this.tEW != null) {
            this.tEW.disable();
        }
        this.tGm = true;
        tGl--;
        int hashCode = hashCode();
        for (int size = tFu.size() - 1; size >= 0; size--) {
            if (((aa) tFu.get(size)).id == hashCode) {
                tFu.remove(size);
                break;
            }
        }
        f("", bi.Wx(), 0);
        com.tencent.mm.plugin.webview.modelcache.o bSb = a.tAm;
        bSb.tAl.put(hashCode(), Boolean.valueOf(false));
        com.tencent.mm.plugin.webview.model.aj.g bRQ = this.tyl.bRQ();
        bRQ.tzv = new Object[]{this.fJB, Integer.valueOf(2)};
        bRQ.c(this.jAm);
        this.tyl.c(this.jAm);
        aj ajVar = this.tyl;
        ajVar.tzg = null;
        ajVar.tze = null;
        ajVar.tzf = null;
        ajVar.tzd = null;
        ajVar.tzh = null;
        ajVar.tzi = null;
        ajVar.tzj = null;
        ajVar.tzk = null;
        if (ajVar.tzp != null) {
            ajVar.tzp.mym = null;
            ajVar.tzp = null;
        }
        Cq("onDestroy");
        this.tFO.clear();
        for (SparseBooleanArray sparseBooleanArray : this.tGG.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.tGG.clear();
        com.tencent.mm.plugin.webview.model.a aVar = this.tGo;
        if (!(aVar.tyk == null || aVar.tyk.oFY.getLooper() == null)) {
            aVar.tyk.oFY.getLooper().quit();
        }
        aVar.tyk = null;
        ag agVar = this.tGu;
        agVar.tyY.clear();
        agVar.tyZ.clear();
        agVar.tza.clear();
        agVar.tyW.clear();
        agVar.tyX.clear();
        if (this.tGQ != null) {
            this.tGQ.dismiss();
            this.tGQ = null;
        }
        if (this.tGN != null) {
            this.tGN.dismiss();
            this.tGN = null;
        }
        Ba(233);
        this.tFP.clear();
        this.tFS.clear();
        this.tGw.dead();
        if (com.tencent.xweb.c.iQ(ad.getContext()) != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (bTE()) {
            try {
                if (this.jAm != null) {
                    bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.jAm.a(30, bundle, hashCode());
                }
            } catch (Exception e) {
            }
        }
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", Boolean.valueOf(this.tFc));
        if (this.tFc) {
            try {
                bundle = getIntent().getBundleExtra("mm_report_bundle");
                if (bi.oN(bundle.getString("mm_event_class"))) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                } else if (this.jAm != null) {
                    bundle.putLong("key_activity_browse_time", cnN());
                    this.jAm.e(250, bundle);
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e2.toString());
            }
        }
        try {
            if (this.jAm != null) {
                bundle = new Bundle();
                bundle.putLong("key_activity_browse_time", cnN());
                this.jAm.e(251, bundle);
            }
        } catch (Exception e22) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", e22.toString());
        }
        try {
            if (this.jAm != null) {
                bundle = this.jAm.e(19, null);
                if (bundle != null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(tGl));
                    if (bundle.getBoolean("webview_video_proxy_init") && tGl <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.jAm.e(75, null);
                    }
                }
            }
        } catch (Exception e222) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "deinit video player failed : %s", e222.getMessage());
        }
        if (this.lwY != null) {
            try {
                unbindService(this.lwY);
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e3, "unbindService", new Object[0]);
            }
        }
        if (this.tsa != null) {
            this.tsa.detach();
        }
        this.ngt.clear();
        if (this.tFI != null) {
            b bVar = this.tFI;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            bVar.context = null;
            bVar.tCV = null;
            bVar.tCW.clear();
            bVar.tCX.clear();
        }
        if (this.tFK != null) {
            this.tFK.detach();
        }
        if (VERSION.SDK_INT >= 11) {
            this.pzt.removeJavascriptInterface("MicroMsg");
            this.pzt.removeJavascriptInterface("JsApi");
        }
        try {
            this.pzt.setWebChromeClient(null);
            this.pzt.setWebViewClient(null);
            this.pzt.setOnTouchListener(null);
            this.pzt.setOnLongClickListener(null);
            this.pzt.setVisibility(8);
            this.pzt.removeAllViews();
            this.pzt.clearView();
        } catch (Exception e2222) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", e2222.getMessage());
        }
        this.tGp.bSv();
        if (this.jAn != null) {
            this.jAn.detach();
            this.jAn = null;
        }
        try {
            this.tGC.release();
        } catch (Exception e22222) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e22222.getMessage());
        }
        try {
            this.pzt.destroy();
        } catch (Exception e222222) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", e222222.getMessage());
        }
        Object obj = this.tGr;
        try {
            obj.tBH.removePrimaryClipChangedListener(obj);
            obj.tBH = null;
        } catch (Exception e4) {
        }
        this.pzt = null;
        System.gc();
    }

    private void aPM() {
        try {
            this.tGC.release();
            this.pzt.stopLoading();
            this.pzt.removeAllViews();
            this.pzt.clearView();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.tsa != null) {
            this.tsa.detach();
        }
        try {
            this.pzt.destroy();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", e2.getMessage());
        }
        this.pzt = null;
        finish();
        com.tencent.mm.sdk.platformtools.x.cfX();
        Process.killProcess(Process.myPid());
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || this.tGB) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.plugin.webview.model.aj.g bRQ;
        if (i == 4 && this.pzt.hasEnteredFullscreen()) {
            this.pzt.leaveFullscreen();
            return true;
        } else if (i != 4 || this.tFx == null || this.tFw == null || this.tFy == null) {
            if (i == 4) {
                boolean z;
                if (this.tEX == null || !this.tEX.isShown()) {
                    z = false;
                } else {
                    this.tEX.hide();
                    bTF();
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            if (i == 4) {
                if (this.pzt.canGoBack() && this.neY) {
                    bTt();
                    bRQ = this.tyl.bRQ();
                    bRQ.tzv = new Object[]{this.fJB, Integer.valueOf(1)};
                    bRQ.c(this.jAm);
                    return true;
                }
                g.tEG.close();
                bTM();
            }
            if (i == 4 && aPV()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        } else {
            try {
                this.tFy.onHideCustomView();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
            }
            bRQ = this.tyl.bRQ();
            bRQ.tzv = new Object[]{this.fJB, Integer.valueOf(1)};
            bRQ.c(this.jAm);
            return true;
        }
    }

    public void bTt() {
        this.pzt.goBack();
        this.tFo = null;
        if (this.tFM) {
            this.tFM = false;
        }
        g gVar = g.tEG;
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", gVar.rke);
        if (!bi.oN(gVar.rke)) {
            gVar.qq(5);
        }
    }

    public void cD(String str, int i) {
        if (this.tEX != null) {
            this.tEX.show();
            if (!bi.oN(str)) {
                this.tEX.setText(str);
            }
            if (i >= 0) {
                this.tEX.By(i);
            }
        }
    }

    public int bTu() {
        if (this.tEX == null) {
            return 0;
        }
        return this.tEX.bVH();
    }

    protected void bTe() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.mController.contentView == null) {
            this.pzt.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.R.e.btq));
            return;
        }
        setBackGroundColorResource(intExtra);
        this.mController.contentView.setBackgroundResource(intExtra);
        this.pzt.setBackgroundResource(17170445);
        findViewById(com.tencent.mm.R.h.cYX).setBackgroundResource(17170445);
    }

    public void bTv() {
        if (getIntent() != null && getIntent().hasExtra("show_full_screen")) {
            I(getIntent().getBooleanExtra("show_full_screen", false), true);
        }
    }

    private void I(boolean z, boolean z2) {
        this.tEU = z;
        MarginLayoutParams marginLayoutParams;
        final View decorView;
        if (z) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            if (this.nrV != null) {
                marginLayoutParams = (MarginLayoutParams) this.nrV.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.nrV.setLayoutParams(marginLayoutParams);
            }
            if (this.nrW != null) {
                this.nrW.setVisibility(8);
            }
            getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                public final void onSystemUiVisibilityChange(int i) {
                    if ((i & 4) == 0 && WebViewUI.this.tEU) {
                        WebViewUI.G(decorView, 5894);
                    }
                }
            });
            G(decorView, 5894);
            if (z2) {
                this.tET.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        WebViewUI.this.aQg();
                    }
                });
                this.tET.setVisibility(0);
                return;
            }
            this.tET.setVisibility(8);
            return;
        }
        this.tET.setVisibility(8);
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5895);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            if (this.nrV != null) {
                marginLayoutParams = (MarginLayoutParams) this.nrV.getLayoutParams();
                marginLayoutParams.topMargin = bTm();
                this.nrV.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.nrW != null) {
            this.nrW.setVisibility(0);
        }
    }

    private static void G(View view, int i) {
        if (view != null) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 5894);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.tEU) {
            G(getWindow().getDecorView(), 5894);
        }
    }

    public void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.tFk = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.tFh = getIntent().getBooleanExtra("is_favorite_item", false);
        this.rEZ = getIntent().getBooleanExtra("isWebwx", true);
        this.tFf = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.tFZ = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.tFj = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.tFV = LayoutInflater.from(this.mController.xRr).inflate(com.tencent.mm.R.i.dtc, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.tFX = bi.oM(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            addTextOptionMenu(1, getString(com.tencent.mm.R.l.eLH), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        WebViewUI.this.pzt.loadUrl(WebViewUI.this.jAm.PA(null));
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", e.getMessage());
                    }
                    return false;
                }
            });
        }
        this.tEN = (ProgressBar) findViewById(com.tencent.mm.R.h.bZO);
        this.tFW = findViewById(com.tencent.mm.R.h.cHl);
        this.tFW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WebViewUI.this.j(WebViewUI.this.tFo, true, -1);
                com.tencent.mm.plugin.webview.model.aj.g bRQ = WebViewUI.this.tyl.bRQ();
                bRQ.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(4)};
                bRQ.c(WebViewUI.this.jAm);
            }
        });
        if (this.rEZ) {
            CharSequence oM = bi.oM(getIntent().getStringExtra("title"));
            if (oM.length() > 0) {
                this.tEL = true;
            }
            super.P(oM);
            oj(bTp());
        } else {
            setMMTitle("");
        }
        kB(false);
        kC(false);
        if (tFA == RenderPriority.NORMAL) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.pzt.getSettings().setRenderPriority(RenderPriority.HIGH);
            tFA = RenderPriority.HIGH;
        }
        this.tGC.cU(this.mController.contentView);
        this.tGC.b(this.pzt);
        bTe();
        this.tER = (FrameLayout) findViewById(com.tencent.mm.R.h.cID);
        this.tES = (FrameLayout) findViewById(com.tencent.mm.R.h.bYH);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.pzt.isX5Kernel);
        if (this.pzt.isX5Kernel) {
            this.pzt.setWebViewCallbackClient(this.tGv);
            this.pzt.setWebViewClientExtension(new g());
            f fVar = this.tGC;
            com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a anonymousClass9 = new com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a() {
                public final void bSU() {
                    if (WebViewUI.this.pzt.isX5Kernel) {
                        com.tencent.mm.plugin.webview.model.aj.g bRQ = WebViewUI.this.tyl.bRQ();
                        bRQ.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(10)};
                        bRQ.c(WebViewUI.this.jAm);
                    }
                }
            };
            if (fVar.tEq != null) {
                fVar.tEq.tCJ = anonymousClass9;
            }
        }
        this.tEX = (WebViewInputFooter) findViewById(com.tencent.mm.R.h.cYS);
        if (this.tEX != null) {
            this.tEX.hide();
            this.tEX.tRq = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c() {
                public final void Cx(String str) {
                    WebViewUI.c(WebViewUI.this, str);
                }
            };
            this.tEX.tRr = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a() {
                public final boolean vD(String str) {
                    if (WebViewUI.this.tsa != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                        Map hashMap = new HashMap();
                        hashMap.put("smiley", str);
                        ah.y(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass21(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetSmiley", hashMap, dVar.tNq, dVar.tNr)));
                    }
                    return true;
                }
            };
            this.tEX.tRs = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b() {
                public final void aPZ() {
                    WebViewUI.b(WebViewUI.this, 0);
                }

                public final void aQa() {
                    WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) WebViewUI.this.findViewById(com.tencent.mm.R.h.cYX);
                    if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.tEd > 0) {
                        WebViewUI.b(WebViewUI.this, webViewKeyboardLinearLayout.tEd);
                    }
                }
            };
        }
        this.tEY = (WebViewSearchContentInputFooter) findViewById(com.tencent.mm.R.h.cJF);
        if (this.tEY != null) {
            this.tEY.tRo = new com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a() {
                public final void aQb() {
                    WebViewUI.c(WebViewUI.this, 0);
                    WebViewUI.this.pzt.clearMatches();
                    WebViewUI.this.tEY.bVE();
                }

                public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    if (webViewSearchContentInputFooter.getVisibility() == 0) {
                        b(webViewSearchContentInputFooter);
                    }
                }

                public final void aQc() {
                    com.tencent.mm.plugin.report.service.g.pWK.a(480, 5, 1, false);
                    WebViewUI.this.pzt.findNext(false);
                }

                public final void aQd() {
                    com.tencent.mm.plugin.report.service.g.pWK.a(480, 4, 1, false);
                    WebViewUI.this.pzt.findNext(true);
                }

                public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    WebViewUI.this.pzt.clearMatches();
                    webViewSearchContentInputFooter.reset();
                    WebViewUI.this.tEY.o(0, 0, true);
                    WebViewUI.this.tEZ = false;
                    WebViewUI.this.pzt.findAllAsync(webViewSearchContentInputFooter.bVF());
                }

                public final boolean c(int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(480, 6, 1, false);
                    }
                    return false;
                }

                public final void onShow() {
                }
            };
            this.pzt.setFindListener(new FindListener() {
                public final void onFindResultReceived(int i, int i2, boolean z) {
                    if (!(!z || WebViewUI.this.tEZ || bi.oN(WebViewUI.this.tEY.bVF()))) {
                        if (i2 == 0) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(480, 3, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.g.pWK.a(480, 2, 1, false);
                        }
                        WebViewUI.this.tEZ = true;
                    }
                    WebViewUI.this.tEY.o(i, i2, z);
                }
            });
        }
        this.tET = (MovingImageButton) findViewById(com.tencent.mm.R.h.ckn);
        this.tFs = findViewById(com.tencent.mm.R.h.cYP);
        if (this.tFs != null) {
            this.tFs.setVisibility(8);
        }
        if (!booleanExtra) {
            this.pzt.setVerticalScrollBarEnabled(false);
        }
        this.tFy = new com.tencent.xweb.j() {
            public volatile boolean mgx = false;
            private Dialog nft = null;
            private final List<String> tHE = new LinkedList();

            public final void a(WebView webView, int i) {
                if (i < 100) {
                    WebViewUI.this.kC(false);
                } else if (i >= 100) {
                    WebViewUI.this.kC(true);
                }
            }

            public final void d(WebView webView, String str) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", str, WebViewUI.this.tGJ);
                super.d(webView, str);
                if (WebViewUI.this.tEL) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + str);
                } else if (str == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "null title");
                } else if (WebViewUI.this.rEZ && !bi.oM(WebViewUI.this.tGJ).equals(str) && !com.tencent.mm.plugin.webview.modelcache.p.vf(str)) {
                    WebViewUI.this.setMMTitle(str);
                }
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
                try {
                    if (WebViewUI.this.tFx != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    WebViewUI.this.kB(false);
                    WebViewUI.this.tFx = view;
                    WebViewUI.this.tFw = customViewCallback;
                    if (WebViewUI.this.pzt.isXWalkKernel()) {
                        WebViewUI.this.tES.addView(view, 0);
                        WebViewUI.this.tGy = true;
                        WebViewUI.this.fullScreenNoTitleBar(true);
                        WebViewUI.this.setStatusBarColor(0);
                        if (WebViewUI.this.nrV != null) {
                            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WebViewUI.this.nrV.getLayoutParams();
                            marginLayoutParams.topMargin = 0;
                            WebViewUI.this.nrV.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    WebViewUI.this.pzt.setVisibility(8);
                    WebViewUI.this.tES.addView(view);
                    WebViewUI.this.setTitleVisibility(4);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
                if (WebViewUI.this.tFx != null) {
                    try {
                        WebViewUI.this.kB(false);
                        if (WebViewUI.this.pzt.isXWalkKernel()) {
                            WebViewUI.this.tGy = false;
                            WebViewUI.this.fullScreenNoTitleBar(false);
                            WebViewUI.this.setStatusBarColor(WebViewUI.this.getResources().getColor(com.tencent.mm.R.e.btT));
                            if (WebViewUI.this.nrV != null) {
                                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WebViewUI.this.nrV.getLayoutParams();
                                int bTm = WebViewUI.this.jSO + WebViewUI.this.bTm();
                                if (bTm != marginLayoutParams.topMargin) {
                                    marginLayoutParams.topMargin = bTm;
                                    WebViewUI.this.nrV.setLayoutParams(marginLayoutParams);
                                }
                            }
                        } else {
                            WebViewUI.this.pzt.setVisibility(0);
                            WebViewUI.this.setTitleVisibility(0);
                        }
                        if (WebViewUI.this.tES != null) {
                            WebViewUI.this.tES.removeView(WebViewUI.this.tFx);
                        }
                        WebViewUI.this.tFx = null;
                        if (WebViewUI.this.tFw != null) {
                            WebViewUI.this.tFw.onCustomViewHidden();
                        }
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
                    }
                }
            }

            public final View getVideoLoadingProgressView() {
                if (WebViewUI.this.tFz == null) {
                    WebViewUI.this.tFz = new ProgressBar(WebViewUI.this);
                    WebViewUI.this.tFz.setIndeterminate(true);
                }
                return WebViewUI.this.tFz;
            }

            public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", str);
                com.tencent.mm.ui.base.h.a(WebViewUI.this, false, WebViewUI.this.getString(com.tencent.mm.R.l.eYD, new Object[]{str}), WebViewUI.this.getString(com.tencent.mm.R.l.eYE), WebViewUI.this.getString(com.tencent.mm.R.l.dGf), WebViewUI.this.getString(com.tencent.mm.R.l.dEy), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok, origin = %s");
                        callback.invoke(str, true, false);
                        d.a(WebViewUI.this.jAm, 14340, WebViewUI.this.fJB, WebViewUI.this.aPR(), Integer.valueOf(WebViewUI.this.fNt), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(aj.bRH()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel, origin = %s");
                        callback.invoke(str, false, false);
                        d.a(WebViewUI.this.jAm, 14340, WebViewUI.this.fJB, WebViewUI.this.aPR(), Integer.valueOf(WebViewUI.this.fNt), WebViewUI.this.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(aj.bRH()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                });
            }

            public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                WebViewUI.this.jAv.a(WebViewUI.this, WebViewUI.this.jAn, valueCallback, null, str, str2);
            }

            public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, com.tencent.xweb.j.a aVar) {
                if (aVar.getMode() != 0) {
                    return false;
                }
                if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                    return true;
                }
                String str = aVar.getAcceptTypes()[0];
                String str2 = "*";
                if (aVar.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                WebViewUI.this.jAv.a(WebViewUI.this, WebViewUI.this.jAn, null, valueCallback, str, str2);
                return true;
            }

            public final boolean b(WebView webView, final String str, String str2, final com.tencent.xweb.f fVar) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsConfirm");
                final PBool pBool = new PBool();
                pBool.value = false;
                if (WebViewUI.this.isFinishing() || WebViewUI.this.xQV) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsConfirm finish");
                    fVar.cancel();
                    return true;
                }
                WebViewUI.this.nfb = WebViewUI.this.nfb + 1;
                if (WebViewUI.this.nfb > 2) {
                    this.nft = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(com.tencent.mm.R.l.eYy), WebViewUI.this.getString(com.tencent.mm.R.l.dGf), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.nfb));
                            fVar.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            WebViewUI.this.finish();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            fVar.confirm();
                        }
                    }, com.tencent.mm.R.e.brB);
                } else {
                    this.nft = com.tencent.mm.ui.base.h.a(WebViewUI.this.mController.xRr, false, str2, "", WebViewUI.this.getString(com.tencent.mm.R.l.dGf), WebViewUI.this.getString(com.tencent.mm.R.l.dEy), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            fVar.confirm();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            fVar.cancel();
                        }
                    });
                }
                if (this.nft == null) {
                    return super.b(webView, str, str2, fVar);
                }
                this.nft.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
                        if (!pBool.value) {
                            fVar.cancel();
                        }
                    }
                });
                this.nft.setCancelable(false);
                this.nft.setCanceledOnTouchOutside(false);
                return true;
            }

            public final boolean a(WebView webView, String str, String str2, String str3, com.tencent.xweb.e eVar) {
                return super.a(webView, str, str2, str3, eVar);
            }

            public final boolean a(WebView webView, final String str, String str2, final com.tencent.xweb.f fVar) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsAlert");
                final PBool pBool = new PBool();
                pBool.value = false;
                if (WebViewUI.this.isFinishing() || WebViewUI.this.xQV) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsAlert finish");
                    fVar.cancel();
                    return true;
                }
                com.tencent.mm.ui.base.i a;
                WebViewUI.this.nfb = WebViewUI.this.nfb + 1;
                if (WebViewUI.this.nfb > 2) {
                    a = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(com.tencent.mm.R.l.eYy), WebViewUI.this.getString(com.tencent.mm.R.l.dGf), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(11683, str, Integer.valueOf(1), Integer.valueOf(WebViewUI.this.nfb));
                            fVar.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            WebViewUI.this.finish();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            fVar.confirm();
                        }
                    }, com.tencent.mm.R.e.btd);
                } else {
                    a = com.tencent.mm.ui.base.h.a(WebViewUI.this, str2, "", WebViewUI.this.getString(com.tencent.mm.R.l.dGf), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            fVar.confirm();
                        }
                    });
                }
                if (a == null) {
                    return super.a(webView, str, str2, fVar);
                }
                a.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                        if (!pBool.value) {
                            fVar.cancel();
                        }
                    }
                });
                a.setCanceledOnTouchOutside(false);
                a.mn(false);
                return true;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String message = consoleMessage != null ? consoleMessage.message() : null;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onConsoleMessage : %s", message);
                if (bi.oN(message) || WebViewUI.this.tFK == null || !message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
                    return false;
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "whiteScreenEnd");
                WebViewUI.this.tFe = true;
                return true;
            }
        };
        this.pzt.setWebChromeClient(this.tFy);
        this.pzt.setWebViewClient(new h());
        this.pzt.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
                int intExtra = WebViewUI.this.getIntent().getIntExtra("key_download_restrict", 0);
                if (!bi.oN(WebViewUI.this.getIntent().getStringExtra("key_function_id"))) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14596, WebViewUI.this.getIntent().getStringExtra("key_function_id"), Integer.valueOf(intExtra), Integer.valueOf(0));
                }
                if (intExtra == 1) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "not allow download file : %s", str);
                    return;
                }
                if (str4 == null || !str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                    intExtra = 0;
                } else {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", str);
                    d.a(WebViewUI.this.jAm, 11154, str);
                    intExtra = 1;
                }
                if (WebViewUI.this.jAn == null || WebViewUI.this.jAn.bTf() == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                    return;
                }
                if (str4 != null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", Boolean.valueOf(WebViewUI.this.bSR()));
                    CharSequence PW = WebViewUI.Ch(str3);
                    int i2 = (PW == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", PW)) ? 0 : 1;
                    boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.tMU.contains(str4.toLowerCase());
                    if (!r4 || (i2 == 0 && !contains)) {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (i == 0 && !WebViewUI.this.jAn.bTf().go(24) && !WebViewUI.this.tFF) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
                } else if (intExtra != 0) {
                    WebViewUI.a(WebViewUI.this, str, j);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    try {
                        WebViewUI.this.startActivity(intent);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
                    }
                }
            }
        });
        this.pzt.requestFocus(130);
        this.pzt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (WebViewUI.this.tEQ != null && WebViewUI.this.tEQ.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.R.a.bqc);
                    loadAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            WebViewUI.this.tEQ.setVisibility(8);
                        }
                    });
                    WebViewUI.this.tEQ.startAnimation(loadAnimation);
                    WebViewUI.this.tEQ.setVisibility(8);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                if (WebViewUI.this.pzt != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
                    if (motionEvent.getPointerCount() > 1) {
                        WebViewUI.this.pzt.getSettings().setBuiltInZoomControls(true);
                        WebViewUI.this.pzt.getSettings().setSupportZoom(true);
                    } else {
                        WebViewUI.this.pzt.getSettings().setBuiltInZoomControls(false);
                        WebViewUI.this.pzt.getSettings().setSupportZoom(false);
                    }
                }
                return false;
            }
        });
        this.pzt.getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.s.aL(this, this.pzt.getSettings().getUserAgentString()));
        this.pzt.czN();
        this.jAo = new com.tencent.mm.ui.tools.l(this.mController.xRr);
        this.jAo.a(this.pzt, this, null);
        this.jAo.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (WebViewUI.this.jAs != null && WebViewUI.this.jAm != null) {
                    try {
                        WebViewUI.this.jAm.Pz(WebViewUI.this.jAs.tBB);
                        WebViewUI.this.jAs.bSt();
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "cancel capture failed");
                    }
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WebViewUI.this.aWY();
                WebViewUI.R(WebViewUI.this);
                return true;
            }
        }, bTw());
        if (bTx()) {
            final WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(com.tencent.mm.R.h.cYX);
            webViewKeyboardLinearLayout.xPq = new com.tencent.mm.ui.KeyboardLinearLayout.a() {
                public final void ra(int i) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + i);
                    WebViewUI.a(WebViewUI.this, webViewKeyboardLinearLayout, i);
                    if (i == -3) {
                        final int i2 = webViewKeyboardLinearLayout.tEd;
                        if (i2 > 0) {
                            WebViewUI.this.bTl();
                            WebViewUI.b(WebViewUI.this, i2);
                        }
                        WebViewUI.c(WebViewUI.this, i2);
                        if (WebViewUI.this.pzt.isX5Kernel || VERSION.SDK_INT >= 19) {
                            WebViewUI.this.handler.post(new Runnable() {
                                public final void run() {
                                    if (WebViewUI.this.tsa != null) {
                                        WebViewUI.this.tsa.Br(i2);
                                    }
                                }
                            });
                        }
                        if (WebViewUI.this.tEX != null && WebViewUI.this.tEX.getVisibility() == 0) {
                            WebViewUI.this.tEX.bVI();
                        }
                    } else {
                        WebViewUI.c(WebViewUI.this, 0);
                        WebViewUI.b(WebViewUI.this, 0);
                    }
                    WebViewUI webViewUI = WebViewUI.this;
                    if (i == -3 && webViewUI.tFs != null) {
                        boolean z;
                        if ((webViewUI.jAn.bTg().vHx & 1) > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + z);
                        if (!(!z || webViewUI.tFs.getVisibility() == 0 || webViewUI.tEY.isShown())) {
                            if (webViewUI.tFt == null) {
                                webViewUI.tFt = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                                    public final boolean uG() {
                                        WebViewUI.this.bTF();
                                        return false;
                                    }
                                }, false);
                            }
                            webViewUI.tFt.K(4000, 4000);
                            View view = webViewUI.tFs;
                            ((ImageView) view.findViewById(com.tencent.mm.R.h.cti)).setImageResource(com.tencent.mm.R.k.dzD);
                            TextView textView = (TextView) view.findViewById(com.tencent.mm.R.h.ctj);
                            textView.setTextSize(14.0f);
                            textView.setText(com.tencent.mm.R.l.eYo);
                            ((ImageButton) view.findViewById(com.tencent.mm.R.h.cth)).setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    WebViewUI.this.bTF();
                                }
                            });
                            webViewUI.tFs.setVisibility(0);
                            com.tencent.mm.plugin.report.service.g.pWK.k(13125, webViewUI.bTy());
                        }
                    }
                    WebViewUI.this.tGS = i;
                }
            };
        }
        this.tEM = (MMFalseProgressBar) findViewById(com.tencent.mm.R.h.cYJ);
        super.setTitleBarDoubleClickListener(new Runnable() {
            public final void run() {
                WebViewUI.S(WebViewUI.this);
            }
        });
    }

    public int bTw() {
        return this.tGc ? 0 : com.tencent.mm.R.k.byC;
    }

    public final void Bb(int i) {
        Drawable mutate = getResources().getDrawable(com.tencent.mm.R.g.byC).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        com.tencent.mm.ui.p pVar = this.mController;
        if (pVar.mActionBar != null && pVar.xRA != null && mutate != null) {
            pVar.xRA.setImageDrawable(mutate);
            mutate.invalidateSelf();
        }
    }

    public boolean bTx() {
        return true;
    }

    public void onActivityResult(int r2, int r3, android.content.Intent r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.utils.BlockUtils.getNextBlock(BlockUtils.java:289)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:131)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:642)
	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:111)
	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:74)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r1 = this;
        super.onActivityResult(r2, r3, r4);
        r0 = r1.jAv;
        r0 = r0.b(r1, r2, r3, r4);
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = com.tencent.mm.plugin.webview.modeltools.a.b(r1, r2, r3, r4);
        if (r0 == 0) goto L_0x000b;
    L_0x0012:
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onSwipeBack() {
        if (this.pzt != null) {
            if (this.tGD) {
                this.pzt.setOnLongClickListener(this.tGE);
            } else {
                this.pzt.setOnLongClickListener(null);
            }
        }
        aWY();
        super.onSwipeBack();
    }

    public final boolean alr() {
        bTM();
        return true;
    }

    public void onCancel() {
        if (this.pzt != null) {
            if (this.tGD) {
                this.pzt.setOnLongClickListener(this.tGE);
            } else {
                this.pzt.setOnLongClickListener(null);
            }
        }
        super.onCancel();
    }

    public void onDrag() {
        if (this.pzt != null) {
            this.pzt.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        super.onDrag();
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar, String str) {
        if (bi.oN(str) || bVar == null) {
            return false;
        }
        return bVar.Cy(str);
    }

    public void alu() {
        String Pv;
        boolean z;
        int bSQ;
        Map hashMap;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw postBinded");
        bTL();
        com.tencent.mm.plugin.webview.model.a aVar = this.tGo;
        com.tencent.mm.plugin.webview.stub.d dVar = this.jAm;
        try {
            Pv = dVar.Pv("DNSAdvanceOpen");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", Pv);
            if (bi.oN(Pv)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = Pv.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    Pv = dVar.Pv("DNSAdvanceRelateDomain");
                    if (bi.oN(Pv)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        aVar.Dt().F(new com.tencent.mm.plugin.webview.model.a.AnonymousClass1(Pv, dVar));
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        if (bTA()) {
            ah.y(new Runnable() {
                public final void run() {
                    WebViewUI.this.pzt.getCurWebviewClient().a(WebViewUI.this.pzt, WebViewUI.this.pzt.getUrl());
                }
            });
        }
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundleExtra.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "KDownloadRestrict = %d, KFunctionID = %s", Integer.valueOf(bundleExtra.getInt("key_download_restrict", 0)), bundleExtra.getString("key_function_id", ""));
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.jAm.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        Pv = null;
        if (this.pzt != null) {
            Pv = this.pzt.getTitle();
        }
        if (bi.oN(Pv)) {
            Pv = getIntent().getStringExtra("title");
        }
        if (bi.oN(Pv)) {
            Pv = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.model.aj.j bRN = this.tyl.bRN();
        bRN.username = stringExtra;
        bRN.tzI = intExtra;
        bRN.fJB = this.fJB;
        bRN.tzE = intExtra2;
        bRN.scene = PT(stringExtra);
        bRN.tzD = longExtra;
        bRN.tzF = new com.tencent.mm.a.o(longExtra).toString();
        bRN.tzB = stringExtra2;
        bRN.tzC = stringExtra3;
        bRN.ncP = stringExtra4;
        bRN.appId = stringExtra5;
        bRN.tzG = stringExtra6;
        bRN.tzH = this.tzH;
        bRN.rzD = string;
        bRN.title = bi.aD(Pv, "");
        bRN.gkM = stringExtra7;
        this.tyl.bRP().fJB = this.fJB;
        if (bTE()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.jAm.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!bi.oN(stringExtra2)) {
            try {
                this.jAm.Pw(stringExtra2);
            } catch (Exception e5) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", Integer.valueOf(getIntent().getIntExtra("pay_channel", -1)));
            } else {
                bSQ = this.jAm.bSQ();
                if (bSQ != -1) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", Integer.valueOf(bSQ));
                    getIntent().putExtra("pay_channel", bSQ);
                }
            }
        } catch (Exception e6) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.ngt.clear();
        MMWebView mMWebView = this.pzt;
        e eVar = this.jAn;
        Map hashMap2 = new HashMap();
        hashMap2.put("webview_type", "1");
        hashMap2.put("init_url", this.fJB);
        hashMap2.put("init_font_size", "1");
        hashMap2.put("short_url", bi.oM(getIntent().getStringExtra("shortUrl")));
        this.tsa = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(mMWebView, eVar, hashMap2, this.jAm, hashCode());
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.tsa;
        stringExtra = getIntent().getStringExtra("geta8key_username");
        if (!bi.oN(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (bi.oN(stringExtra)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(PT(stringExtra)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        hashMap.put("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0)));
        if (!bi.oN(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        int intExtra3 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra3 != -1) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "get pay scene from extra: %s", Integer.valueOf(intExtra3));
        } else {
            intExtra3 = 3;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "default pay scene to: %s", Integer.valueOf(3));
        }
        hashMap.put("pay_scene", Integer.valueOf(intExtra3));
        dVar2.tNn = hashMap;
        if (bTz() != null) {
            bTz().tpT = this.tsa;
        }
        this.pzt.addJavascriptInterface(this.tsa, "__wx");
        this.ngt.add(this.tsa);
        this.ngt.add(new s());
        this.ngt.add(new p());
        this.ngt.add(new e());
        this.ngt.add(new r());
        this.ngt.add(new u());
        this.ngt.add(new a());
        this.ngt.add(new z());
        this.ngt.add(new t());
        this.ngt.add(new i());
        this.ngt.add(new b());
        this.ngt.add(new c());
        this.ngt.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.pzt, this.tsa));
        this.ngt.add(new y());
        this.ngt.add(new v());
        this.ngt.add(new n());
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.ngt.add(new k());
        }
        this.ngt.add(new f());
        try {
            bSQ = bi.getInt(this.jAm.Pv("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            bSQ = 0;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", Integer.valueOf(bSQ), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false)));
        if (bSQ == 1 || r1) {
            this.tGC.ky(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.tGC.ky(true);
        }
        try {
            this.tFJ = bi.getInt(this.jAm.Pv("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", Integer.valueOf(this.tFJ));
        aj.H(this.pzt.isX5Kernel, bi.oM(this.fJB).startsWith("https://"));
        if (this.pzt.isX5Kernel) {
            com.tencent.mm.pluginsdk.ui.tools.j.qq(7);
            com.tencent.mm.plugin.report.service.g.pWK.a(64, 64, 1, 0, 1, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(64, 0, 1, false);
        }
        this.tFK = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.pzt, this.jAm, this.tsa, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a() {
            public final void bTX() {
                int T;
                int i = 2;
                boolean z = false;
                try {
                    if (WebViewUI.this.jAm.aPk()) {
                        if (WebViewUI.this.bTI() || WebViewUI.this.bTJ()) {
                            T = WebViewUI.this.bTK();
                            if (T > 0 && T <= 4) {
                                i = T;
                            }
                            WebViewUI.this.Bf(i);
                            WebViewUI.this.J(true, true);
                            if (WebViewUI.this.pzt != null && WebViewUI.this.jAn != null && WebViewUI.this.tsa != null) {
                                String url = WebViewUI.this.pzt.getUrl();
                                if (!bi.oN(url) && WebViewUI.this.tGk.add(url)) {
                                    GeneralControlWrapper bTg = WebViewUI.this.jAn.bTg();
                                    boolean z2 = (bTg.vHx & WXMediaMessage.TITLE_LENGTH_LIMIT) > 0;
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = " + z2);
                                    if (z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", Boolean.valueOf(dVar.tNo));
                                        if (dVar.tNi != null && dVar.tNo) {
                                            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:get_all_hosts", new HashMap(), dVar.tNq, dVar.tNr) + ")", null);
                                        }
                                    }
                                    if ((bTg.vHx & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = " + z2);
                                    if (z2) {
                                        WebViewUI.this.tsa.kI(false);
                                        return;
                                    }
                                    ag n = WebViewUI.this.tGu;
                                    if (!bi.oN(url)) {
                                        url = Uri.parse(url).getHost();
                                        if (!bi.oN(url)) {
                                            z = n.tza.remove(url);
                                        }
                                    }
                                    if (z) {
                                        WebViewUI.this.tsa.kI(true);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (bi.oN(WebViewUI.this.fJB) || !com.tencent.mm.plugin.webview.a.trv.matcher(WebViewUI.this.fJB).matches()) {
                            T = WebViewUI.this.jAm.en(16384, 2);
                        } else {
                            T = WebViewUI.this.jAm.en(16388, 2);
                        }
                        i = T;
                        WebViewUI.this.Bf(i);
                        WebViewUI.this.J(true, true);
                        if (WebViewUI.this.pzt != null) {
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
                }
                T = 2;
                i = T;
                WebViewUI.this.Bf(i);
                WebViewUI.this.J(true, true);
                if (WebViewUI.this.pzt != null) {
                }
            }
        }, getIntent().getBooleanExtra("key_load_js_without_delay", false), bTA());
        try {
            bSQ = bi.getInt(this.jAm.Pv("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            bSQ = 0;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "js digest verification config = %d", Integer.valueOf(bSQ));
        if (bSQ == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && bTN()) {
            this.tsa.bUZ();
            this.tGu.tzb = this.tsa.tNr;
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            kA(false);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", Long.valueOf(System.currentTimeMillis()));
        } else {
            kA(getIntent().getBooleanExtra("showShare", true));
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z));
        }
        this.tEQ = LayoutInflater.from(this).inflate(com.tencent.mm.R.i.dui, null);
        FontChooserView fontChooserView = (FontChooserView) this.tEQ.findViewById(com.tencent.mm.R.h.ciX);
        View findViewById = this.tEQ.findViewById(com.tencent.mm.R.h.ciW);
        if (!this.pzt.isX5Kernel) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.R.a.bqc);
                    loadAnimation.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            WebViewUI.this.tEQ.setVisibility(8);
                        }
                    });
                    WebViewUI.this.tEQ.startAnimation(loadAnimation);
                    WebViewUI.this.tEQ.setVisibility(8);
                }
            });
        }
        fontChooserView.tQw = new j();
        this.tEQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.tES.addView(this.tEQ);
        this.tEQ.setVisibility(8);
        bSQ = 2;
        try {
            if (this.jAm.aPk()) {
                bSQ = (bTI() || bTJ()) ? bTK() : (bi.oN(this.fJB) || !com.tencent.mm.plugin.webview.a.trv.matcher(this.fJB).matches()) ? this.jAm.en(16384, 0) : this.jAm.en(16388, 0);
            }
        } catch (Exception e7) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (bSQ <= 0 || bSQ > 4) {
            bSQ = 2;
        }
        Bf(bSQ);
        Bg(bSQ);
        try {
            this.jAm.a(this.fJB, true, null);
        } catch (Exception e52222) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.ngt) {
            if (a(bVar, this.fJB)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "initView, url handled, result = " + bVar.Cz(this.fJB) + ", url = " + this.fJB);
                return;
            }
        }
        if (bSW()) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            return;
        }
        String stringExtra8 = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.DATA);
        if (stringExtra8 != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.jAm.Pr(stringExtra8);
                } catch (Exception e522222) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.pzt.setOnLongClickListener(this.tGE);
            this.tGD = true;
            this.pzt.getSettings().setUseWideViewPort(false);
            this.pzt.getSettings().setLoadWithOverviewMode(false);
            if (PV(null)) {
                this.pzt.getSettings().setJavaScriptEnabled(false);
                this.pzt.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = " + stringExtra8);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
            aPM();
            return;
        }
        if (bi.oN(this.fJB)) {
            hf(false);
        }
        if (this.fJB == null || this.fJB.length() == 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            return;
        }
        Uri parse = Uri.parse(this.fJB);
        if (parse == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "initView uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.fJB = "http://" + this.fJB;
        } else if (!parse.getScheme().startsWith("http")) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (!PV(this.fJB)) {
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.fJB);
                aPM();
                return;
            } else if (bTA()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "webview ispreloaded , do not reload url");
                return;
            } else {
                this.pzt.loadUrl(this.fJB);
                return;
            }
        }
        this.tFB = new l(this.fJB);
        try {
            bundleExtra = this.jAm.e(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.tGF = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.tFB.tGF = this.tGF;
            }
        } catch (Exception e5222222) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", e5222222.getMessage());
        }
        if (this.tFf || this.jAn.has(this.fJB)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.tFf);
            if (!PV(this.fJB)) {
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.fJB);
                aPM();
                return;
            } else if (PP(this.fJB)) {
                this.tGa = true;
                this.tEM.finish();
                this.tEM.setVisibility(8);
                Ct(this.fJB);
                return;
            } else {
                this.pzt.loadUrl(this.fJB);
                return;
            }
        }
        if (PP(this.fJB)) {
            Ct(this.fJB);
            this.tGJ = this.fJB;
            this.tGa = true;
            this.tEM.finish();
            this.tEM.setVisibility(8);
        }
        if (!this.tGm && !this.tGn && !isFinishing()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            j(this.fJB, false, -1);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.fJB);
        }
    }

    public boolean PP(String str) {
        return com.tencent.mm.plugin.webview.modelcache.o.a(str, this.jAm, hashCode());
    }

    public void Ct(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        if (this.pzt != null) {
            this.pzt.loadUrl(str, hashMap);
        }
    }

    public final boolean needShowIdcError() {
        return false;
    }

    private boolean aQi() {
        try {
            if (this.jAm != null) {
                return this.jAm.bSN();
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "invoker is null");
            return false;
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + e.getMessage());
            return false;
        }
    }

    private boolean bSR() {
        try {
            if (this.jAm != null) {
                return this.jAm.bSR();
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "invoker is null");
            return false;
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
            return false;
        }
    }

    private static String Ch(String str) {
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                return matcher.group(1);
            }
            return null;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
            return null;
        }
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.jAm.isSDCardAvailable();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        contextMenu.setHeaderTitle(com.tencent.mm.R.l.eYG);
        try {
            isSDCardAvailable = this.jAm.aPk();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get has setuin failed : %s", e2.getMessage());
            isSDCardAvailable = false;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.jAn.bTg().ceq()), Boolean.valueOf(this.jAn.bTg().cer()));
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, getString(com.tencent.mm.R.l.eBX)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        com.tencent.mm.pluginsdk.ui.tools.s.a(WebViewUI.this, str, com.tencent.xweb.b.cJc().getCookie(str), WebViewUI.this.jAm.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.s.b() {
                            public final void tx(String str) {
                                if (bi.oN(str)) {
                                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
                                } else {
                                    WebViewUI.e(WebViewUI.this, str);
                                }
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getString(com.tencent.mm.R.l.eHt)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean isSDCardAvailable;
                try {
                    isSDCardAvailable = WebViewUI.this.jAm.isSDCardAvailable();
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    isSDCardAvailable = false;
                }
                try {
                    com.tencent.mm.pluginsdk.ui.tools.s.a(WebViewUI.this, str, com.tencent.xweb.b.cJc().getCookie(str), isSDCardAvailable);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", e2.getMessage());
                }
                return true;
            }
        });
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, getString(com.tencent.mm.R.l.eAq)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = WebViewUI.this.jAm.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        com.tencent.mm.pluginsdk.ui.tools.s.a(WebViewUI.this, replaceAll, com.tencent.xweb.b.cJc().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b() {
                            public final void tx(String str) {
                                WebViewUI.f(WebViewUI.this, str);
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.jAp == null) {
            return false;
        }
        final String str2 = this.jAp;
        contextMenu.add(0, 0, 0, com.tencent.mm.plugin.scanner.a.aF(this.jAq, this.jAp) ? getString(com.tencent.mm.R.l.eCE) : getString(com.tencent.mm.R.l.eCD)).setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                try {
                    WebViewUI.this.jAm.g(str2, WebViewUI.this.aPR(), str, WebViewUI.this.jAq, WebViewUI.this.jAr);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
                } catch (RemoteException e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "recognize qbar result failed");
                }
                return false;
            }
        });
        this.jAp = null;
        return true;
    }

    private void a(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.jAn.bTg().ceo() && aQi()) {
            this.jAu = aVar;
            this.jAs = new com.tencent.mm.plugin.webview.modeltools.g();
            this.jAs.a(this.pzt, this.jAy);
        }
    }

    private void b(ContextMenu contextMenu, com.tencent.xweb.WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.jAn.bTg().ceo() && aQi()) {
            this.jAt = aVar;
            this.jAs = new com.tencent.mm.plugin.webview.modeltools.g();
            this.jAs.a(this.pzt, this.jAy);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        com.tencent.xweb.WebView.a hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.pzt.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }

    public final String bTy() {
        String str = null;
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", e.getMessage());
            if (e instanceof ClassNotFoundException) {
                finish();
                return str;
            }
        }
        if (str != null && str.length() > 0) {
            return str;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    public com.tencent.mm.plugin.aj.b bTz() {
        return null;
    }

    public boolean bTA() {
        return false;
    }

    public void bTB() {
    }

    private boolean bTC() {
        boolean z = false;
        try {
            return this.jAm.Pu("favorite");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[z]);
            return z;
        }
    }

    private void cs(List<String> list) {
        Object gw;
        Exception e;
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.tFG.get(str) != null) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "find %s icon from cache ok", str);
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", str);
                    try {
                        String Pq = this.jAm.Pq(str);
                        if (!bi.oN(Pq)) {
                            Bitmap PH = d.PH(Pq);
                            if (PH != null) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "load ok, and cache it");
                                this.tFG.put(str, PH);
                            }
                        }
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e2.getMessage());
                    }
                }
                if (this.tFH.containsKey(str)) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "find %s nick from cache ok", str);
                } else {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", str);
                    try {
                        gw = this.jAm.gw(str);
                        try {
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "load nick ok");
                        } catch (Exception e3) {
                            e = e3;
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                            this.tFH.put(str, gw);
                        }
                    } catch (Exception e22) {
                        Exception exception = e22;
                        gw = null;
                        e = exception;
                    }
                    this.tFH.put(str, gw);
                }
            }
        }
    }

    protected final boolean Bc(int i) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.tGG.get(this.pzt.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            return true;
        }
        return false;
    }

    public final void aQq() {
        String PS = PS(this.tGJ);
        String stringExtra = getIntent().getStringExtra("shortcut_user_name");
        if (bi.oN(PS) || bi.oN(stringExtra)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "addShortcut, appid or username is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", PS);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            this.jAm.e(80, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "addShortcut, e = " + e.getMessage());
        }
    }

    public void aQg() {
        boolean z;
        com.tencent.mm.ui.widget.g gVar;
        String str = null;
        String url = this.pzt.getUrl();
        final ArrayList arrayList = this.tFQ.containsKey(url) ? (ArrayList) this.tFQ.get(url) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        final Boolean valueOf = Boolean.valueOf(z);
        if (valueOf.booleanValue()) {
            gVar = new com.tencent.mm.ui.widget.g(this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
        } else {
            gVar = new com.tencent.mm.ui.widget.g(this.mController.xRr, com.tencent.mm.ui.widget.g.zCs, true);
        }
        gVar.zux = new com.tencent.mm.ui.base.p.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                if (WebViewUI.i(menuItem)) {
                    imageView.setVisibility(8);
                    return;
                }
                String str = menuItem.getTitle();
                if (WebViewUI.this.tFG.get(str) == null || ((Bitmap) WebViewUI.this.tFG.get(str)).isRecycled()) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                    try {
                        String Pq = WebViewUI.this.jAm.Pq(str);
                        if (!bi.oN(Pq)) {
                            Bitmap PH = d.PH(Pq);
                            if (PH != null && !PH.isRecycled()) {
                                imageView.setImageBitmap(PH);
                                WebViewUI.this.tFG.put(str, PH);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                        return;
                    }
                }
                imageView.setImageBitmap((Bitmap) WebViewUI.this.tFG.get(str));
            }
        };
        gVar.zuy = new com.tencent.mm.ui.base.p.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                String str = menuItem.getTitle();
                if (textView != null) {
                    String str2 = (String) WebViewUI.this.tFH.get(str);
                    if (bi.oN(str2)) {
                        textView.setText(str);
                    } else {
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(WebViewUI.this.mController.xRr, str2, textView.getTextSize()));
                    }
                }
            }
        };
        gVar.rQG = new com.tencent.mm.ui.base.p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Throwable e;
                boolean z;
                boolean z2 = false;
                if (WebViewUI.i(menuItem)) {
                    com.tencent.mm.j.d.b bVar = (com.tencent.mm.j.d.b) menuItem.getMenuInfo();
                    if (bVar != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = WebViewUI.this.tsa;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                        Map hashMap = new HashMap();
                        hashMap.put("key", bVar.aAM);
                        hashMap.put("title", bVar.title);
                        dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:custom", hashMap, dVar.tNq, dVar.tNr) + ")", null);
                        return;
                    }
                    return;
                }
                String stringExtra;
                String stringExtra2;
                String stringExtra3;
                com.tencent.mm.plugin.webview.model.aj.d bRR;
                com.tencent.mm.plugin.webview.model.aj.d bRR2;
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 1:
                        stringExtra = WebViewUI.this.getIntent().getStringExtra("KPublisherId");
                        stringExtra2 = WebViewUI.this.getIntent().getStringExtra("KAppId");
                        stringExtra3 = WebViewUI.this.getIntent().getStringExtra("srcUsername");
                        bRR = WebViewUI.this.tyl.bRR();
                        bRR.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                        bRR.c(WebViewUI.this.jAm);
                        WebViewUI.this.tFd = WebViewUI.this.jAn.bTg().cep();
                        WebViewUI.this.aQk();
                        return;
                    case 2:
                        int intValue;
                        stringExtra = WebViewUI.this.getIntent().getStringExtra("KPublisherId");
                        stringExtra2 = WebViewUI.this.getIntent().getStringExtra("KAppId");
                        stringExtra3 = WebViewUI.this.getIntent().getStringExtra("srcUsername");
                        bRR = WebViewUI.this.tyl.bRR();
                        bRR.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(2), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                        bRR.c(WebViewUI.this.jAm);
                        WebViewUI.this.tFd = WebViewUI.this.jAn.bTg().cep();
                        if (WebViewUI.this.tFS.containsKey(WebViewUI.this.pzt.getUrl())) {
                            intValue = ((Integer) WebViewUI.this.tFS.get(WebViewUI.this.pzt.getUrl())).intValue();
                        } else {
                            intValue = 0;
                        }
                        WebViewUI webViewUI = WebViewUI.this;
                        webViewUI.tsa.aQ("shareTimeline", true);
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = webViewUI.tsa;
                        if (dVar2.tNo) {
                            try {
                                dVar2.jAm.G("urlAttribute", String.valueOf(intValue), dVar2.tBL);
                            } catch (Throwable e2) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                            }
                            dVar2.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:timeline", new HashMap(), dVar2.tNq, dVar2.tNr) + ")", null);
                        } else {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
                        }
                        webViewUI.tyl.Pa("mm_share_sns_count");
                        return;
                    case 3:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(3), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        com.tencent.mm.plugin.report.service.g.pWK.a(157, 6, 1, false);
                        WebViewUI.this.tFd = WebViewUI.this.jAn.bTg().cep();
                        WebViewUI.this.aQr();
                        return;
                    case 5:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(4), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        stringExtra = (String) WebViewUI.this.tFP.get(WebViewUI.this.pzt.getUrl());
                        if (stringExtra == null) {
                            stringExtra = WebViewUI.this.getIntent().getStringExtra("srcUsername");
                        }
                        WebViewUI.h(WebViewUI.this, "Contact_Scene");
                        WebViewUI.i(WebViewUI.this, stringExtra);
                        return;
                    case 6:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(5), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.Z(WebViewUI.this);
                        return;
                    case 7:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(13), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.aa(WebViewUI.this);
                        return;
                    case 8:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(15), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.ab(WebViewUI.this);
                        return;
                    case 9:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(7), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        com.tencent.mm.ui.base.h.a(WebViewUI.this.mController.xRr, WebViewUI.this.mController.xRr.getString(com.tencent.mm.R.l.dEI), null, null, WebViewUI.this.mController.xRr.getString(com.tencent.mm.R.l.dEH), new com.tencent.mm.ui.base.h.d() {
                            public final void cr(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("fav_local_id", WebViewUI.this.getIntent().getLongExtra("fav_local_id", -1));
                                        try {
                                            if (WebViewUI.this.jAm.S(bundle)) {
                                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
                                                WebViewUI.this.tyl.t("mm_del_fav", Boolean.valueOf(true));
                                                WebViewUI.this.finish();
                                                return;
                                            }
                                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "try to del web url fail");
                                            return;
                                        } catch (Throwable e) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "try to del web url crash");
                                            return;
                                        }
                                    default:
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 10:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(11), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.this.bTG();
                        return;
                    case 11:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(8), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        if (WebViewUI.this.tEQ.getVisibility() == 8) {
                            WebViewUI.this.tEQ.startAnimation(AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.R.a.bqb));
                            WebViewUI.this.tEQ.setVisibility(0);
                            return;
                        }
                        Animation loadAnimation = AnimationUtils.loadAnimation(WebViewUI.this, com.tencent.mm.R.a.bqc);
                        loadAnimation.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                WebViewUI.this.tEQ.setVisibility(8);
                            }
                        });
                        WebViewUI.this.tEQ.startAnimation(loadAnimation);
                        WebViewUI.this.tEQ.setVisibility(8);
                        return;
                    case 12:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(6), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", WebViewUI.this.getIntent().getLongExtra("fav_local_id", -1));
                        com.tencent.mm.bl.d.b(WebViewUI.this.mController.xRr, "favorite", ".ui.FavTagEditUI", intent);
                        WebViewUI.this.tyl.Pa("mm_edit_fav_count");
                        return;
                    case 14:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(9), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        if (WebViewUI.this.tFM) {
                            WebViewUI.j(WebViewUI.this, WebViewUI.this.tFN);
                            return;
                        } else {
                            WebViewUI.a(WebViewUI.this, WebViewUI.this.pzt.getUrl(), WebViewUI.this.pzt.getSettings().getUserAgentString(), WebViewUI.this.width, WebViewUI.this.height);
                            return;
                        }
                    case 15:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(19), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.a(WebViewUI.this, menuItem);
                        return;
                    case 16:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(21), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.a(WebViewUI.this, menuItem);
                        return;
                    case 17:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(20), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.a(WebViewUI.this, menuItem);
                        return;
                    case 18:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(22), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.a(WebViewUI.this, menuItem);
                        return;
                    case 19:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(23), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.a(WebViewUI.this, menuItem);
                        return;
                    case 20:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(17), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.aj(WebViewUI.this);
                        return;
                    case 21:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(18), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.ak(WebViewUI.this);
                        return;
                    case 22:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(24), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.al(WebViewUI.this);
                        return;
                    case 23:
                        intent = new Intent();
                        stringExtra2 = WebViewUI.this.getIntent().getStringExtra("sns_local_id");
                        if (stringExtra2 != null) {
                            intent.putExtra("sns_send_data_ui_activity", true);
                            intent.putExtra("sns_local_id", stringExtra2);
                        } else {
                            intent.putExtra("Retr_Msg_Id", Long.valueOf(WebViewUI.this.getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                        }
                        com.tencent.mm.bl.d.a(WebViewUI.this.mController.xRr, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    case 24:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(16), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.an(WebViewUI.this);
                        return;
                    case 25:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(26), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.ah(WebViewUI.this);
                        return;
                    case 26:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(27), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.ai(WebViewUI.this);
                        return;
                    case 27:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(32), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        if (!WebViewUI.this.aPV()) {
                            WebViewUI.this.finish();
                            return;
                        }
                        return;
                    case 28:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(10), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        if (WebViewUI.this.pzt != null) {
                            WebViewUI.this.pzt.reload();
                            return;
                        }
                        return;
                    case 29:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(31), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.this.aQq();
                        return;
                    case 30:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(29), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.this.aQn();
                        return;
                    case 31:
                        com.tencent.mm.plugin.report.service.g.pWK.a(480, 1, 1, false);
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(28), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        if (!WebViewUI.this.tEY.isShown()) {
                            WebViewUI.this.tEY.reset();
                            WebViewUI.this.tEY.bVE();
                            WebViewUI.this.tEY.show();
                            return;
                        }
                        return;
                    case 32:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(30), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.this.aQo();
                        return;
                    case 33:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(14), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        WebViewUI.am(WebViewUI.this);
                        return;
                    case 34:
                        WebViewUI.ao(WebViewUI.this);
                        return;
                    default:
                        bRR2 = WebViewUI.this.tyl.bRR();
                        bRR2.tzv = new Object[]{WebViewUI.this.fJB, Integer.valueOf(16), Integer.valueOf(1)};
                        bRR2.c(WebViewUI.this.jAm);
                        stringExtra3 = menuItem.getTitle();
                        if (!bi.oN(stringExtra3)) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, stringExtra3);
                                bundle = WebViewUI.this.jAm.e(50, bundle);
                                if (bundle != null) {
                                    z = bundle.getInt("key_biz_type") == 2;
                                    try {
                                        if (bundle.getInt("key_biz_type") == 3) {
                                            z2 = true;
                                        }
                                    } catch (RemoteException e3) {
                                        e2 = e3;
                                    }
                                }
                            } catch (RemoteException e4) {
                                e2 = e4;
                                z = false;
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                z2 = z;
                                if (z2) {
                                    WebViewUI.this.PQ(stringExtra3);
                                    return;
                                } else {
                                    WebViewUI.l(WebViewUI.this, stringExtra3);
                                    return;
                                }
                            }
                            if (z2) {
                                WebViewUI.this.PQ(stringExtra3);
                                return;
                            } else {
                                WebViewUI.l(WebViewUI.this, stringExtra3);
                                return;
                            }
                        }
                        return;
                }
            }
        };
        gVar.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(com.tencent.mm.ui.base.n nVar) {
                com.tencent.mm.plugin.report.service.g.pWK.a(480, 0, 1, false);
                int i;
                com.tencent.mm.ui.base.o oVar;
                if (valueOf.booleanValue()) {
                    int size = arrayList.size();
                    for (i = 0; i < size; i++) {
                        com.tencent.mm.j.d.b bVar = (com.tencent.mm.j.d.b) arrayList.get(i);
                        oVar = (com.tencent.mm.ui.base.o) nVar.f(bVar.id, bVar.title);
                        oVar.ykK = bVar;
                        oVar.setIcon(null);
                        oVar.setIcon(0);
                    }
                    return;
                }
                try {
                    LinkedList ap = WebViewUI.this.bTD();
                    if (ap != null) {
                        i = 0;
                        while (i < ap.size() && i < 8) {
                            com.tencent.mm.j.d.a aVar = (com.tencent.mm.j.d.a) ap.get(i);
                            if ("index".equals(bi.oM(aVar.id))) {
                                oVar = (com.tencent.mm.ui.base.o) nVar.a(15, WebViewUI.this.getString(com.tencent.mm.R.l.eXc), com.tencent.mm.R.k.dwN);
                            } else if ("categories".equals(bi.oM(aVar.id))) {
                                oVar = (com.tencent.mm.ui.base.o) nVar.a(16, WebViewUI.this.getString(com.tencent.mm.R.l.eXb), com.tencent.mm.R.k.dwM);
                            } else if ("cart".equals(bi.oM(aVar.id))) {
                                oVar = (com.tencent.mm.ui.base.o) nVar.a(17, WebViewUI.this.getString(com.tencent.mm.R.l.eXa), com.tencent.mm.R.k.dwL);
                            } else if ("profile".equals(bi.oM(aVar.id))) {
                                oVar = (com.tencent.mm.ui.base.o) nVar.a(18, WebViewUI.this.getString(com.tencent.mm.R.l.eXe), com.tencent.mm.R.k.dwS);
                            } else if ("member".equals(bi.oM(aVar.id))) {
                                oVar = (com.tencent.mm.ui.base.o) nVar.a(19, WebViewUI.this.getString(com.tencent.mm.R.l.eXd), com.tencent.mm.R.k.dwO);
                            } else {
                                oVar = null;
                            }
                            if (oVar != null) {
                                oVar.jhS = aVar.url;
                            }
                            i++;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "exception in add jd menu, " + e.getMessage());
                }
                if (WebViewUI.this.jAn == null || WebViewUI.this.jAn.bTf() == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "get permission failed");
                    return;
                }
                boolean gI;
                String bSE;
                JsapiPermissionWrapper bTf = WebViewUI.this.jAn.bTf();
                if (bTf.go(21) && WebViewUI.this.Bc(1)) {
                    nVar.a(1, WebViewUI.this.getString(com.tencent.mm.R.l.eBX), com.tencent.mm.R.k.dxb);
                }
                if (bTf.go(23) && WebViewUI.this.Bc(2)) {
                    nVar.a(2, WebViewUI.this.getString(com.tencent.mm.R.l.eBY), com.tencent.mm.R.k.dwQ);
                }
                if (!(WebViewUI.this.tFh && (bi.oN(WebViewUI.this.tGJ) || bi.oN(WebViewUI.this.tGI) || WebViewUI.this.tGJ.startsWith(WebViewUI.this.tGI))) && WebViewUI.this.bTC() && WebViewUI.this.Bc(3)) {
                    nVar.a(3, WebViewUI.this.getString(com.tencent.mm.R.l.eAq), com.tencent.mm.R.k.dwJ);
                }
                try {
                    if (WebViewUI.this.jAm.r(WebViewUI.this.getIntent().getLongExtra("msg_id", Long.MIN_VALUE), WebViewUI.this.getIntent().getStringExtra("sns_local_id"))) {
                        nVar.a(23, WebViewUI.this.getString(com.tencent.mm.R.l.dZr), com.tencent.mm.R.k.dwR);
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                }
                nVar.a(31, WebViewUI.this.getString(com.tencent.mm.R.l.eYO), com.tencent.mm.R.k.dwZ);
                if (bTf.go(44) && WebViewUI.this.Bc(6)) {
                    nVar.a(6, WebViewUI.this.getString(com.tencent.mm.R.l.eYl), com.tencent.mm.R.k.dwD);
                }
                if (bTf.vHC != null && WebViewUI.this.tFh && !bi.oN(WebViewUI.this.tGJ) && !bi.oN(WebViewUI.this.tGI) && WebViewUI.this.tGJ.startsWith(WebViewUI.this.tGI) && WebViewUI.this.getIntent().getBooleanExtra("key_detail_can_delete", true) && WebViewUI.this.bTC()) {
                    if (WebViewUI.this.Bc(12)) {
                        nVar.a(12, WebViewUI.this.getString(com.tencent.mm.R.l.eeS), com.tencent.mm.R.k.dwy);
                    }
                    if (WebViewUI.this.Bc(9)) {
                        nVar.a(9, WebViewUI.this.getString(com.tencent.mm.R.l.dEH), com.tencent.mm.R.k.dwE);
                    }
                }
                String stringExtra = WebViewUI.this.getIntent().getStringExtra("srcUsername");
                if (!bi.oN(stringExtra)) {
                    try {
                        gI = WebViewUI.this.jAm.gI(stringExtra);
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                        gI = false;
                    }
                    if (gI) {
                        boolean gH;
                        try {
                            gH = WebViewUI.this.jAm.gH(stringExtra);
                        } catch (Exception e32) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "sharebtn click fail, ex = " + e32.getMessage());
                            gH = false;
                        }
                        if (gH) {
                            gI = bTf.go(19);
                        } else {
                            gI = bTf.go(20);
                        }
                        boolean bTE = WebViewUI.this.bTE();
                        if ((gI && WebViewUI.this.Bc(5)) || bTE) {
                            int i2 = gH ? com.tencent.mm.R.l.eYw : com.tencent.mm.R.l.eYn;
                            if (bTE) {
                                i2 = com.tencent.mm.R.l.eYx;
                            }
                            nVar.a(5, WebViewUI.this.getString(i2), com.tencent.mm.R.k.dwA);
                        }
                    } else {
                        try {
                            WebViewUI.this.jAm.Pw(stringExtra);
                        } catch (Exception e322) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "sharebtn click fail triggerGetContact, ex = " + e322.getMessage());
                        }
                    }
                }
                if (bTf.go(bq.CTRL_INDEX) && WebViewUI.this.Bc(34)) {
                    nVar.a(34, WebViewUI.this.getString(com.tencent.mm.R.l.eYM), com.tencent.mm.R.k.dwW);
                }
                if (WebViewUI.this.Vi()) {
                    if (WebViewUI.this.Bc(32)) {
                        nVar.a(32, WebViewUI.this.getString(com.tencent.mm.R.l.eBZ), com.tencent.mm.R.k.dxc);
                    }
                } else if (WebViewUI.this.Bc(30)) {
                    nVar.a(30, WebViewUI.this.getString(com.tencent.mm.R.l.eCe), com.tencent.mm.R.k.dxd);
                }
                if (bTf.go(45) && WebViewUI.this.Bc(7)) {
                    nVar.a(7, WebViewUI.this.getString(com.tencent.mm.R.l.eYq), com.tencent.mm.R.k.dwB);
                }
                if (bTf.go(43) && WebViewUI.this.Bc(24) && !com.tencent.mm.pluginsdk.model.app.p.m(WebViewUI.this.mController.xRr, "com.tencent.wework")) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_action", "enterprise_has_connector");
                        bundle = WebViewUI.this.jAm.e(71, bundle);
                        if (bundle != null) {
                            gI = bundle.getBoolean("enterprise_has_connector");
                            if (gI) {
                                nVar.a(24, WebViewUI.this.getString(com.tencent.mm.R.l.eCi), com.tencent.mm.R.k.dwH);
                            }
                        }
                    } catch (Exception e3222) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "builder add, ex = " + e3222.getMessage());
                    }
                    gI = false;
                    if (gI) {
                        nVar.a(24, WebViewUI.this.getString(com.tencent.mm.R.l.eCi), com.tencent.mm.R.k.dwH);
                    }
                }
                if (bTf.go(18) && WebViewUI.this.Bc(11)) {
                    nVar.a(11, WebViewUI.this.getString(com.tencent.mm.R.l.eBW), com.tencent.mm.R.k.dwK);
                }
                if (WebViewUI.this.Bc(28)) {
                    nVar.a(28, WebViewUI.this.getString(com.tencent.mm.R.l.eWK), com.tencent.mm.R.k.dwX);
                }
                if (bTf.go(73) && WebViewUI.this.Bc(14) && !WebViewUI.this.tFM) {
                    nVar.a(14, WebViewUI.this.getString(com.tencent.mm.R.l.eYN), com.tencent.mm.R.k.dwV);
                }
                if (WebViewUI.this.tFM && WebViewUI.this.Bc(14)) {
                    nVar.a(14, WebViewUI.this.getString(com.tencent.mm.R.l.eYL), com.tencent.mm.R.k.dwR);
                }
                gI = (WebViewUI.this.jAn.bTg().vHx & 16) > 0;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.GeneralControlWrapper", "allowExpose, ret = " + gI);
                if (gI && WebViewUI.this.Bc(10)) {
                    nVar.a(10, WebViewUI.this.getString(com.tencent.mm.R.l.dMw), com.tencent.mm.R.k.dwC);
                }
                if (bTf.go(36) && WebViewUI.this.Bc(8)) {
                    try {
                        bSE = WebViewUI.this.jAm.bSE();
                    } catch (Exception e4) {
                        bSE = null;
                    }
                    if (bi.oN(bSE)) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "get mail session key is null or nil, should not show send mail menu");
                    } else {
                        nVar.a(8, WebViewUI.this.getString(com.tencent.mm.R.l.eYs), com.tencent.mm.R.k.dwP);
                    }
                }
                if (bTf.go(31) && WebViewUI.this.Bc(30)) {
                    try {
                        if (WebViewUI.this.jAm.e(78, null).getBoolean("isOpenForFaceBook", false)) {
                            nVar.a(33, WebViewUI.this.getString(com.tencent.mm.R.l.eYR), com.tencent.mm.R.k.dyw);
                        }
                    } catch (Throwable e22) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e22, "", new Object[0]);
                    }
                }
                if (WWAPIFactory.iP(WebViewUI.this).cIZ() && WebViewUI.this.Bc(25)) {
                    bSE = WWAPIFactory.iP(WebViewUI.this).cJa();
                    nVar.a(25, WebViewUI.this.getString(com.tencent.mm.R.l.eCj, new Object[]{bSE}), com.tencent.mm.R.k.dxf);
                }
                if (com.tencent.mm.plugin.webview.stub.a.aM(WebViewUI.this, WebViewUI.this.pzt.getUrl()) && WebViewUI.this.Bc(26)) {
                    nVar.a(26, WebViewUI.this.getString(com.tencent.mm.R.l.eYQ), com.tencent.mm.R.k.dxe);
                }
                if (bTf.go(91) && com.tencent.mm.plugin.webview.stub.a.dP(WebViewUI.this) && WebViewUI.this.Bc(20)) {
                    nVar.a(20, WebViewUI.this.getString(com.tencent.mm.R.l.eYS), com.tencent.mm.R.k.dwT);
                }
                if (bTf.go(com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX) && com.tencent.mm.plugin.webview.stub.a.dP(WebViewUI.this) && WebViewUI.this.Bc(22)) {
                    nVar.a(22, WebViewUI.this.getString(com.tencent.mm.R.l.eYT), com.tencent.mm.R.k.dwU);
                }
                try {
                    if (bTf.go(43) && WebViewUI.this.Bc(0) && WebViewUI.this.jAm.Ma()) {
                        List<CharSequence> LZ = WebViewUI.this.jAm.LZ();
                        for (CharSequence add : LZ) {
                            nVar.add(add);
                        }
                        WebViewUI.this.cs(LZ);
                    }
                } catch (Exception e32222) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "builder add, ex = " + e32222.getMessage());
                }
                if (WebViewUI.this.tET != null && WebViewUI.this.tET.getVisibility() == 0) {
                    nVar.a(27, WebViewUI.this.getString(com.tencent.mm.R.l.eCd), com.tencent.mm.R.k.dwI);
                }
                bSE = WebViewUI.this.PS(WebViewUI.this.tGJ);
                stringExtra = WebViewUI.this.getIntent().getStringExtra("shortcut_user_name");
                if (!WebViewUI.this.tFl && !bi.oN(bSE) && !bi.oN(stringExtra) && bTf.go(255) && WebViewUI.this.Bc(29)) {
                    nVar.a(29, WebViewUI.this.getString(com.tencent.mm.R.l.eBV), com.tencent.mm.R.k.dBS);
                }
            }
        };
        if (this.pzt != null) {
            str = this.pzt.getUrl();
        }
        if (!bi.oN(str)) {
            if (!bi.oN(Uri.parse(str).getHost())) {
                CharSequence string = getString(com.tencent.mm.R.l.eXn, new Object[]{Uri.parse(str).getHost()});
                if (com.tencent.mm.sdk.a.b.cfx()) {
                    try {
                        if (this.jAm.e(98, null) != null) {
                            string = string + "_NewBridge";
                        }
                    } catch (Exception e) {
                    }
                }
                gVar.e(string, 1);
            }
        }
        if (this.tEU) {
            gVar.tMI = true;
            gVar.tMJ = true;
        } else {
            gVar.tMI = false;
            gVar.tMJ = false;
        }
        if (this.tEY == null || !this.tEY.isShown()) {
            aWY();
            ah.h(new Runnable() {
                public final void run() {
                    if (WebViewUI.this.isFinishing() || WebViewUI.this.tGm) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    } else {
                        gVar.bUX();
                    }
                }
            }, 100);
            return;
        }
        this.tEY.hide();
        ah.h(new Runnable() {
            public final void run() {
                if (WebViewUI.this.isFinishing() || WebViewUI.this.tGm) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                } else {
                    gVar.bUX();
                }
            }
        }, 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.j.d.a> bTD() {
        /*
        r12 = this;
        r0 = 0;
        r2 = 1;
        r3 = 0;
        r1 = r12.pzt;
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        r1 = "MicroMsg.WebViewUI";
        r2 = "viewwv is null, maybe has destroyed";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = r12.fJB;
        r1 = r12.pzt;
        if (r1 == 0) goto L_0x00cc;
    L_0x0017:
        r1 = r12.pzt;
        r1 = r1.getUrl();
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r5 != 0) goto L_0x00cc;
    L_0x0023:
        if (r1 == 0) goto L_0x0010;
    L_0x0025:
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x00b8 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = ".*(\\.wanggou\\.com|\\.jd\\.com)";
        r5 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.getHost();	 Catch:{ Exception -> 0x00b8 }
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0010;
    L_0x003b:
        r4 = ".";
        r4 = r1.startsWith(r4);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0054;
    L_0x0044:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b8 }
        r6 = ".";
        r4.<init>(r6);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b8 }
    L_0x0054:
        r4 = "MicroMsg.WebViewUI";
        r6 = "host = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00b8 }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.d(r4, r6, r7);	 Catch:{ Exception -> 0x00b8 }
        r1 = r5.matcher(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.matches();	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x006d:
        r1 = r12.tGg;	 Catch:{ Exception -> 0x00b8 }
        if (r1 != 0) goto L_0x00a2;
    L_0x0071:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r1 = r12.jAm;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.bSH();	 Catch:{ Exception -> 0x00b8 }
        r12.tGg = r1;	 Catch:{ Exception -> 0x00b8 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "[hakon] getConfigListMap %b, cost %d";
        r1 = 2;
        r8 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00b8 }
        r9 = 0;
        r1 = r12.tGg;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x00b6;
    L_0x008b:
        r1 = r2;
    L_0x008c:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b8 }
        r8[r9] = r1;	 Catch:{ Exception -> 0x00b8 }
        r1 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00b8 }
        r8[r1] = r4;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x00b8 }
    L_0x00a2:
        r1 = r12.tGg;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x00a6:
        r1 = r12.tGg;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.size();	 Catch:{ Exception -> 0x00b8 }
        if (r1 <= 0) goto L_0x0010;
    L_0x00ae:
        r1 = r12.tGg;	 Catch:{ Exception -> 0x00b8 }
        r0 = com.tencent.mm.j.d.j(r1);	 Catch:{ Exception -> 0x00b8 }
        goto L_0x0010;
    L_0x00b6:
        r1 = r3;
        goto L_0x008c;
    L_0x00b8:
        r1 = move-exception;
        r4 = "MicroMsg.WebViewUI";
        r5 = "[hakon] getJDMenuItems, ex = ";
        r2 = new java.lang.Object[r2];
        r1 = r1.getMessage();
        r2[r3] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r4, r5, r2);
        goto L_0x0010;
    L_0x00cc:
        r1 = r4;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bTD():java.util.LinkedList<com.tencent.mm.j.d$a>");
    }

    protected final boolean bTE() {
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        return (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) ? false : true;
    }

    protected final void b(String str, Drawable drawable) {
        final boolean bTE = bTE();
        final String stringExtra = getIntent().getStringExtra("srcUsername");
        a(0, str, drawable, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (bTE) {
                    WebViewUI.i(WebViewUI.this, stringExtra);
                } else {
                    WebViewUI.this.aQg();
                }
                return true;
            }
        });
    }

    public void kA(boolean z) {
        this.tGB = z;
        if (this.pzt == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            return;
        }
        enableOptionMenu(z);
        showOptionMenu(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            showOptionMenu(booleanExtra);
        }
        int i = com.tencent.mm.R.g.bDJ;
        if (bTD() != null) {
            i = com.tencent.mm.R.k.dzj;
        }
        getIntent().getStringExtra("srcUsername");
        bTE();
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            addIconOptionMenu(0, i, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    WebViewUI.this.aQg();
                    return true;
                }
            });
        }
        kD(!z);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (com.tencent.mm.compatible.util.d.fN(21)) {
            Drawable b = android.support.v4.content.a.b((Context) this, i2);
            if (b != null) {
                if (aSd()) {
                    b.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                } else {
                    b.clearColorFilter();
                }
                a(i, getString(com.tencent.mm.v.a.k.hai), b, onMenuItemClickListener);
                return;
            }
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    private void bTF() {
        if (this.tFs != null) {
            this.tFs.setVisibility(8);
        }
        if (this.tFt != null) {
            this.tFt.TN();
        }
    }

    public final void aQk() {
        this.tsa.aQ(GameJsApiSendAppMessage.NAME, true);
        this.tsa.bVe();
        this.tyl.Pa("mm_send_friend_count");
    }

    private void PQ(String str) {
        this.tsa.aQ(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tsa;
        if (dVar.tNo) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tNq, dVar.tNr) + ")", null);
            try {
                dVar.jAm.G("connector_local_send", str, dVar.tBL);
                dVar.jAm.G("scene", "enterprise", dVar.tBL);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bTG() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 2;
        r11 = 4;
        r10 = 1;
        r9 = 0;
        r0 = r14.getIntent();
        r1 = "geta8key_username";
        r0 = r0.getStringExtra(r1);
        r1 = r14.getIntent();
        r2 = "k_username";
        r1.putExtra(r2, r0);
        r0 = r14.getIntent();
        r1 = "k_expose_url";
        r2 = r14.pzt;
        r2 = r2.getUrl();
        r0.putExtra(r1, r2);
        r0 = r14.getIntent();
        r1 = "showShare";
        r0.putExtra(r1, r9);
        r0 = r14.pzt;
        r2 = r0.getUrl();
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r1 != 0) goto L_0x0049;
    L_0x0041:
        r0 = android.net.Uri.parse(r2);
        r0 = r0.getHost();
    L_0x0049:
        r1 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r3 != 0) goto L_0x0148;
    L_0x0050:
        r3 = "mp.weixin.qq.com";
        r0 = r0.startsWith(r3);
        if (r0 == 0) goto L_0x0148;
    L_0x0059:
        r0 = "https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r4 = 0;
        r5 = r14.pzt;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r5 = r5.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r6 = "utf-8";
        r5 = com.tencent.mm.compatible.util.p.encode(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r3[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r0 = java.lang.String.format(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x013a }
    L_0x0073:
        if (r0 == 0) goto L_0x0156;
    L_0x0075:
        r1 = r14.pzt;
        r1 = r1.getUrl();
        r3 = r14.PS(r1);
        r1 = r14.jAn;
        r1 = r1.bTg();
        r1 = r1.cep();
        r2 = "MicroMsg.WebViewUI";
        r4 = "doExpose enableReportPageEvent %s";
        r5 = new java.lang.Object[r10];
        r6 = java.lang.Boolean.valueOf(r1);
        r5[r9] = r6;
        com.tencent.mm.sdk.platformtools.x.d(r2, r4, r5);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x011d;
    L_0x00a0:
        if (r1 == 0) goto L_0x011d;
    L_0x00a2:
        r1 = r14.pzt;
        r1 = r1.getUrl();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x00ae:
        r4 = com.tencent.mm.sdk.platformtools.bi.Wx();
        r1 = "MicroMsg.WebViewUI";
        r2 = "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r9] = r7;
        r7 = java.lang.Long.valueOf(r4);
        r6[r10] = r7;
        r6[r12] = r3;
        r7 = r14.pzt;
        r7 = r7.getUrl();
        r6[r13] = r7;
        r7 = r14.frp;
        r6[r11] = r7;
        r7 = 5;
        r8 = java.lang.Integer.valueOf(r11);
        r6[r7] = r8;
        r7 = 6;
        r8 = java.lang.Integer.valueOf(r10);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r6);
        r1 = "";
        r2 = r14.pzt;	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r2 = r2.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r6 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x0159 }
    L_0x00f8:
        r2 = com.tencent.mm.plugin.report.service.g.pWK;
        r6 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r4 = java.lang.Long.valueOf(r4);
        r7[r9] = r4;
        r7[r10] = r3;
        r7[r12] = r1;
        r1 = r14.frp;
        r7[r13] = r1;
        r1 = java.lang.Integer.valueOf(r11);
        r7[r11] = r1;
        r1 = 5;
        r3 = java.lang.Integer.valueOf(r10);
        r7[r1] = r3;
        r2.h(r6, r7);
    L_0x011d:
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r1 == 0) goto L_0x0134;
    L_0x0123:
        r0 = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
        r1 = new java.lang.Object[r10];
        r2 = 34;
        r2 = java.lang.Integer.valueOf(r2);
        r1[r9] = r2;
        r0 = java.lang.String.format(r0, r1);
    L_0x0134:
        r1 = r14.pzt;
        r1.loadUrl(r0);
        return;
    L_0x013a:
        r0 = move-exception;
        r3 = "MicroMsg.WebViewUI";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.x.e(r3, r0);
        r0 = r2;
        goto L_0x0073;
    L_0x0148:
        r0 = r14.getIntent();
        r2 = "k_expose_current_url";
        r3 = r14.aPR();
        r0.putExtra(r2, r3);
    L_0x0156:
        r0 = r1;
        goto L_0x0075;
    L_0x0159:
        r2 = move-exception;
        r6 = "MicroMsg.WebViewUI";
        r7 = "";
        r8 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r2, r7, r8);
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.bTG():void");
    }

    private void Bd(int i) {
        CharSequence PS = PS(this.tGL);
        if (TextUtils.isEmpty(this.tGL) || TextUtils.isEmpty(PS)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "stev appId is null or empty");
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "stev appId %s", PS);
        long Wx = bi.Wx();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", Integer.valueOf(13377), Long.valueOf(Wx), PS, this.tGL, this.frp, Integer.valueOf(3), Integer.valueOf(i));
        String str = "";
        try {
            str = com.tencent.mm.compatible.util.p.encode(this.tGL, "UTF-8");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(13377, Long.valueOf(Wx), PS, str, this.frp, Integer.valueOf(3), Integer.valueOf(i));
    }

    public final void aQr() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", this.fJB);
        if (!bi.oN(this.fJB) && this.fJB.endsWith("#rd")) {
            String substring = this.fJB.substring(0, this.fJB.length() - 3);
            if (!(bi.oN(this.tGL) || this.tGL.startsWith(substring))) {
                bundle.putString("rawUrl", this.tGL);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bi.oN(this.tGL) || this.tGL.startsWith(this.fJB))) {
            bundle.putString("rawUrl", this.tGL);
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.b R = this.jAm.R(bundle);
            if (R.bSw()) {
                this.tsa.aQ(GameJsApiSendAppMessage.NAME, false);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tsa;
                if (dVar.tNo) {
                    Map hashMap = new HashMap();
                    hashMap.put("scene", "favorite");
                    dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tNq, dVar.tNr) + ")", null);
                    try {
                        dVar.jAm.G("scene", "favorite", dVar.tBL);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onFavorite fail, not ready");
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "on favorite simple url");
                return;
            }
            com.tencent.mm.pluginsdk.model.c.a(R.getRet(), 35, (Activity) this, this.nfQ);
            if (R.getRet() == 0) {
                Bd(1);
            } else {
                Bd(2);
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "edw, favoriteUrl fail, ex = " + e2.getMessage());
        }
    }

    private void kB(boolean z) {
        if (findViewById(com.tencent.mm.R.h.cYK) != null) {
            if ((findViewById(com.tencent.mm.R.h.cYK).getVisibility() == 0) != z) {
                findViewById(com.tencent.mm.R.h.cYK).startAnimation(AnimationUtils.loadAnimation(this.mController.xRr, z ? com.tencent.mm.R.a.bpO : com.tencent.mm.R.a.bpP));
            }
            if (z) {
                findViewById(com.tencent.mm.R.h.cYK).setVisibility(0);
                this.tEO = (ImageButton) findViewById(com.tencent.mm.R.h.cYI);
                ImageButton imageButton = this.tEO;
                boolean z2 = this.pzt != null && this.pzt.canGoBack();
                imageButton.setEnabled(z2);
                this.tEO.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (WebViewUI.this.pzt != null) {
                            WebViewUI.this.pzt.goBack();
                            WebViewUI.this.tFo = null;
                        }
                    }
                });
                this.tEP = (ImageButton) findViewById(com.tencent.mm.R.h.cYL);
                this.tEP.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (WebViewUI.this.pzt != null) {
                            WebViewUI.this.pzt.reload();
                        }
                    }
                });
                return;
            }
            findViewById(com.tencent.mm.R.h.cYK).setVisibility(8);
        }
    }

    private void kC(boolean z) {
        if (this.tEP != null) {
            this.tEP.setEnabled(z);
        }
    }

    protected final void J(boolean z, boolean z2) {
        enableOptionMenu(z);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", Boolean.valueOf(z));
        setProgressBarIndeterminateVisibility(false);
        if (z2) {
            this.tEM.finish();
        } else if (!this.tGa && !this.tGc) {
            this.tEM.start();
        }
    }

    public void PR(String str) {
        if (this.jAn.bTg().cen()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.jAm.a(str, this.jAn.bTf().go(7), bundle)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + str);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    }

    public boolean Cz(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.ngt) {
            if (a(bVar, str)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "url handled, url = " + str);
                if (this.tGH.equals(str)) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    return true;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "url handled, ret = " + bVar.Cz(str) + ", url = " + str);
                return true;
            }
        }
        return false;
    }

    public final String PS(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || this.jAm == null) {
            return str2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("webview_binder_id", hashCode());
        bundle.putString("rawUrl", str);
        try {
            str2 = bi.oM(this.jAm.e(76, bundle).getString("appId"));
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "stev cachedAppId %s", str2);
            return str2;
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "get cachedAppId error ", e.getMessage());
            return str2;
        }
    }

    public final void f(String str, long j, int i) {
        long j2;
        long j3;
        String str2;
        String str3;
        String str4;
        String encode;
        Throwable e;
        CharSequence PS = PS(this.tGL);
        if (this.fromScene != 0) {
            this.tGK = " ";
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", Boolean.valueOf(this.jAn.bTg().cep()));
        if (this.jNQ > 0 && this.tGM > this.jNQ && j > this.tGM && !TextUtils.isEmpty(PS) && r4) {
            j2 = this.tGM - this.jNQ;
            j3 = j - this.tGM;
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", Integer.valueOf(13376), Long.valueOf(this.jNQ), PS, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.jKI, this.tGL, this.frp, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.tGK);
            str2 = "";
            str3 = "";
            String str5 = "";
            str4 = "";
            try {
                str2 = com.tencent.mm.compatible.util.p.encode(bi.oM(this.jKI), "UTF-8");
                str3 = com.tencent.mm.compatible.util.p.encode(bi.oM(this.tGL), "UTF-8");
                encode = com.tencent.mm.compatible.util.p.encode(bi.oM(str), "UTF-8");
                try {
                    str4 = com.tencent.mm.compatible.util.p.encode(bi.oM(this.tGK), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                encode = str5;
                e = th;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13376, Long.valueOf(this.jNQ), PS, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.frp, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str4);
            this.fromScene = 0;
        }
        if (i == 1) {
            this.tGK = this.tGL;
            this.tGL = str;
            this.jNQ = j;
        }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
        com.tencent.mm.plugin.report.service.g.pWK.h(13376, Long.valueOf(this.jNQ), PS, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.frp, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str4);
        this.fromScene = 0;
        if (i == 1) {
            this.tGK = this.tGL;
            this.tGL = str;
            this.jNQ = j;
        }
    }

    public final w j(String str, boolean z, int i) {
        if (this.tGm || this.tGn || isFinishing()) {
            return w.FAILED;
        }
        if (this.tFW != null) {
            this.tFW.setVisibility(8);
        }
        if (this.jAn == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            return w.FAILED;
        } else if (this.tFf) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.jAn.b(str, null, null);
            return w.NO_NEED;
        } else {
            Object obj = (this.jAm != null && this.tGb.contains(str) && PP(str)) ? 1 : null;
            if ((this.jAn.has(str) || obj != null) && !z) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                this.tFF = this.jAn.bTf().go(24);
                return w.NO_NEED;
            }
            int Cn;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int PT = PT(stringExtra);
            if (i == -1) {
                Cn = this.tFB.Cn(str);
            } else {
                Cn = i;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", str, Integer.valueOf(PT), stringExtra, Integer.valueOf(Cn), Boolean.valueOf(z), getIntent().getStringExtra("key_function_id"), Integer.valueOf(getIntent().getIntExtra("key_wallet_region", 0)));
            if (i != 5) {
                J(false, false);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
            this.tGb.add(str);
            this.jAn.b(str, null, null);
            this.tFF = this.jAn.bTf().go(24);
            this.tGd = true;
            this.tFC.bTY();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", PT);
            bundle.putInt("geta8key_data_reason", Cn);
            if (this.pzt.isX5Kernel) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", aj.bRI());
            bundle.putInt("geta8key_session_id", this.tFn);
            if (!bi.oN(getIntent().getStringExtra("k_share_url"))) {
                bundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
                getIntent().putExtra("k_share_url", "");
            }
            bundle.putInt("key_wallet_region", r4);
            bundle.putString("key_function_id", r3);
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putByteArray("k_a8key_cookie", this.tFp);
            this.tFo = str;
            boolean z2 = false;
            try {
                z2 = this.jAm.r(233, bundle);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + z2);
            com.tencent.mm.plugin.webview.model.aj.k bRK = this.tyl.bRK();
            int i2 = this.fNt;
            String str2 = this.fHA;
            bRK.fNt = i2;
            bRK.tzz = str2;
            if (bi.oN(str)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!bRK.tzK.containsKey(str)) {
                bRK.tzK.put(str, Long.valueOf(bi.Wy()));
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(154, 11, 1, false);
            return w.WILL_GET;
        }
    }

    private int PT(String str) {
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.jAm == null) {
                intExtra = 1;
            } else {
                try {
                    intExtra = this.jAm.hq(str) ? 8 : this.jAm.gI(str) ? 7 : 1;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e.getMessage());
                    intExtra = 1;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", Integer.valueOf(intExtra));
        return intExtra;
    }

    private boolean PU(String str) {
        if (bi.oN(str)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            return false;
        }
        AZ(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", hashCode());
        try {
            this.jAm.r(106, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        return true;
    }

    private boolean Cs(String str) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (this.jAm.cG(str)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + str);
                this.jAm.cA(str, hashCode());
                return true;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        final Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            Intent intent;
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                replace = str.replace(com.tencent.smtt.sdk.WebView.SCHEME_TEL, "");
                if (!bi.oN(replace)) {
                    try {
                        this.jAm.cC(replace, hashCode());
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", e2.getMessage());
                    }
                }
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    startActivity(intent);
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", e22.getMessage());
                }
                return true;
            } else {
                try {
                    if (this.jAn.bTg().cem() || this.jAm == null || !this.jAm.aPk()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        if (!bi.oN(getIntent().getStringExtra("key_function_id"))) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(14596, r4, Integer.valueOf(intExtra), Integer.valueOf(1));
                        }
                        if (intExtra == 1) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", str);
                            return true;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", Long.valueOf(bi.Wx() - this.tGM));
                        if (bi.Wx() - this.tGM <= 2) {
                            replace = aPR();
                            try {
                                replace = com.tencent.mm.compatible.util.p.encode(replace, "UTF-8");
                                str = com.tencent.mm.compatible.util.p.encode(str, "UTF-8");
                            } catch (Exception e3) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "formate url failed");
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(13983, Integer.valueOf(4), replace, str);
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            return com.tencent.mm.by.a.post(new Runnable() {
                                public final void run() {
                                    com.tencent.mm.pluginsdk.model.app.g.d(WebViewUI.this, parse);
                                }
                            });
                        }
                        intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (bi.k(this, intent)) {
                            startActivity(intent);
                            return true;
                        }
                    }
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                    return true;
                } catch (Throwable e4) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e4, "", new Object[0]);
                }
            }
        }
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bi.oN(str2)) {
            this.jAn.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.tGb.remove(str2);
            this.tGd = false;
            this.mKN = str2;
        }
        if (eX(str, str2)) {
            this.jAn.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.tGb.remove(str);
        } else if (this.jAm != null && !bi.oN(str) && PP(str)) {
            this.jAn.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.tGb.remove(str);
        }
    }

    public void bTH() {
    }

    protected void b(com.tencent.mm.plugin.webview.stub.c cVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.pzt == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
        } else if (isFinishing() || this.jAn == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
        } else {
            String str;
            Bundle data;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            String str2 = null;
            try {
                i = cVar.getType();
                i2 = cVar.bSx();
                i3 = cVar.bSy();
                str2 = cVar.KS();
                str = str2;
                data = cVar.getData();
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
                str = str2;
                data = null;
            }
            if (data == null) {
                data = new Bundle();
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode()));
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i + ", errCode = " + i3 + ", errType = " + i2);
            if (data.getInt("scene_end_listener_hash_code") != hashCode()) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "hash code not equal");
            } else if (i == 233 || i == 131 || i == 106 || i == 673 || i == 666 || i == 1254 || i == 1373) {
                String str3;
                boolean z;
                com.tencent.mm.plugin.webview.model.y.d dVar;
                switch (i) {
                    case 106:
                        finish();
                        return;
                    case 233:
                        this.tFC.bTZ();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                        this.ngu = data.getLong("geta8key_result_deep_link_bit_set", 0);
                        int i4 = data.getInt("geta8key_result_reason");
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i4);
                        str3 = null;
                        switch (i4) {
                            case 0:
                            case 2:
                            case 8:
                            case 9:
                                if ((i2 != 0 || i3 != 0) && (i2 != 4 || i3 != -2005)) {
                                    g.tEG.AY(i2);
                                    str2 = data.getString("geta8key_result_req_url");
                                    if (!(this.tFW == null || PP(str2))) {
                                        this.tFW.setVisibility(0);
                                        J(true, true);
                                    }
                                    this.tyl.bRP().tzt = false;
                                    this.tyl.bRK().aO(str2, false);
                                    com.tencent.mm.plugin.report.service.g.pWK.a(154, 12, 1, false);
                                    i = a.AR(i4);
                                    if (-1 != i) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(154, (long) i, 1, false);
                                    }
                                    if (this.tFk) {
                                        finish();
                                        break;
                                    }
                                }
                                str3 = data.getString("geta8key_result_full_url");
                                a(data.getString("geta8key_result_req_url"), str3, jsapiPermissionWrapper, generalControlWrapper);
                                V(data);
                                this.tFF = jsapiPermissionWrapper.go(24);
                                this.tyl.bRP().tzt = true;
                                this.tFp = data.getByteArray("geta8key_result_cookie");
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bi.bA(this.tFp));
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i2 != 0 || i3 != 0) {
                                    if (i2 != 4 || i3 != -2005) {
                                        if (i2 != 0 && i3 == -3300) {
                                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", Integer.valueOf(i2), Integer.valueOf(i3));
                                            this.tFq = true;
                                            break;
                                        }
                                        com.tencent.mm.plugin.report.service.g.pWK.a(154, 12, 1, false);
                                        com.tencent.mm.plugin.report.service.g.pWK.a(154, (long) a.AR(i4), 1, false);
                                        J(true, true);
                                        break;
                                    }
                                    this.pzt.stopLoading();
                                    str3 = data.getString("geta8key_result_full_url");
                                    a(data.getString("geta8key_result_req_url"), str3, jsapiPermissionWrapper, generalControlWrapper);
                                    V(data);
                                    this.tFp = data.getByteArray("geta8key_result_cookie");
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bi.bA(this.tFp));
                                    break;
                                }
                                str3 = data.getString("geta8key_result_req_url");
                                this.jAn.b(str3, jsapiPermissionWrapper, generalControlWrapper);
                                this.tGb.remove(str3);
                                if (this.tGi) {
                                    J(true, true);
                                    this.tGi = false;
                                }
                                if (i4 != 5) {
                                    this.tFF = jsapiPermissionWrapper.go(24);
                                }
                                this.tFp = data.getByteArray("geta8key_result_cookie");
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", bi.bA(this.tFp));
                                break;
                                break;
                        }
                        K(this.jAn.PN(str3).go(34), this.jAn.PN(str3).go(75));
                        bTH();
                        return;
                    case 666:
                        q qVar = this.tFE;
                        qVar.tHY--;
                        if (qVar.tHY <= 0) {
                            qVar.tGT.Ba(666);
                        }
                        finish();
                        return;
                    case 673:
                        o oVar = this.tFD;
                        oVar.tHX--;
                        if (oVar.tHX <= 0) {
                            oVar.tGT.Ba(673);
                        }
                        if (i2 == 0 && i3 == 0) {
                            str3 = data != null ? data.getString("reading_mode_result_url") : null;
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", str3);
                            if (bi.oN(str3)) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                return;
                            } else {
                                this.pzt.loadUrl(str3);
                                return;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        return;
                    case 1254:
                        z = i2 == 0 && i3 == 0;
                        com.tencent.mm.plugin.webview.stub.d dVar2 = this.jAm;
                        dVar = this.tGO;
                        com.tencent.mm.plugin.webview.model.y.b bVar = this.tGP;
                        int hashCode = hashCode();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", Boolean.valueOf(z));
                        dVar.aDe();
                        bVar.remove(1254);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a((Context) this, str, ad.getContext().getString(com.tencent.mm.R.l.eXG), new com.tencent.mm.plugin.webview.model.y.c.AnonymousClass2(dVar));
                            return;
                        } else if (data == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            return;
                        } else {
                            z = data.getBoolean("is_recent_has_auth");
                            boolean z2 = data.getBoolean("is_silence_auth");
                            if (z || z2) {
                                str2 = data.getString("redirect_url");
                                if (bi.oN(str2)) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str2);
                                dVar.OM(str2);
                                return;
                            }
                            com.tencent.mm.plugin.webview.model.y.c.AnonymousClass3 anonymousClass3 = new com.tencent.mm.plugin.webview.model.y.c.AnonymousClass3(data, dVar, dVar2, bVar, hashCode);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                return;
                            } else {
                                new com.tencent.mm.plugin.webview.ui.tools.widget.h(this).a(com.tencent.mm.plugin.webview.model.y.V((ArrayList) data.getSerializable("scope_list")), data.getString("appname"), data.getString("appicon_url"), getString(com.tencent.mm.R.l.eXQ), anonymousClass3);
                                return;
                            }
                        }
                    case 1373:
                        z = i2 == 0 && i3 == 0;
                        dVar = this.tGO;
                        com.tencent.mm.plugin.webview.model.y.b bVar2 = this.tGP;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", Boolean.valueOf(z));
                        bVar2.remove(1373);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a((Context) this, str, ad.getContext().getString(com.tencent.mm.R.l.eXG), new com.tencent.mm.plugin.webview.model.y.c.AnonymousClass4(dVar));
                            return;
                        } else if (data == null) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            return;
                        } else {
                            str3 = data.getString("redirect_url");
                            if (bi.oN(str3)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                return;
                            }
                            dVar.OM(str3);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", str3);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void K(boolean z, boolean z2) {
        if (z) {
            setMMSubTitle(com.tencent.mm.R.l.eXI);
            if (!this.tFi) {
                int i;
                if (ad.cgg().getInt("enter_web_pay_over_time", 2) <= 0) {
                    i = 0;
                } else {
                    i = ad.cgh().getInt("enter_web_pay_over_time", 2);
                    if (i > 0) {
                        Editor edit = ad.cgh().edit();
                        edit.putInt("enter_web_pay_over_time", i - 1);
                        edit.commit();
                    }
                }
                switch (i) {
                    case 1:
                        Be(com.tencent.mm.R.i.duf);
                        break;
                    case 2:
                        Be(com.tencent.mm.R.i.dug);
                        break;
                }
                this.tFi = true;
            }
        } else if (z2) {
            setMMSubTitle(com.tencent.mm.R.l.eXT);
        } else {
            setMMSubTitle(null);
        }
    }

    private void Be(int i) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "showUserEdPage");
        this.tGQ = new com.tencent.mm.ui.base.k(this, com.tencent.mm.R.m.eZo);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, null);
        ImageView imageView;
        if (i == com.tencent.mm.R.i.duf) {
            imageView = (ImageView) linearLayout.findViewById(com.tencent.mm.R.h.coj);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(com.tencent.mm.R.h.cdd);
            try {
                if (this.jAm.bSM()) {
                    imageView2.setImageResource(com.tencent.mm.R.g.bEE);
                } else {
                    imageView2.setImageResource(com.tencent.mm.R.g.bEC);
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            try {
                String Pq = this.jAm.Pq(this.jAm.aT(2, null));
                if (!bi.oN(Pq)) {
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(d.PH(Pq), false, 1.0f);
                    if (!(a == null || a.isRecycled())) {
                        imageView.setImageBitmap(a);
                    }
                }
            } catch (RemoteException e2) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", e2.toString());
            }
        } else if (i == com.tencent.mm.R.i.dug) {
            imageView = (ImageView) linearLayout.findViewById(com.tencent.mm.R.h.cwf);
            try {
                if (this.jAm.bSM()) {
                    imageView.setImageResource(com.tencent.mm.R.g.bEF);
                } else {
                    imageView.setImageResource(com.tencent.mm.R.g.bED);
                }
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebViewUI", e3, "", new Object[0]);
            }
        }
        linearLayout.setMinimumWidth(10000);
        TextView textView = (TextView) linearLayout.findViewById(com.tencent.mm.R.h.cwq);
        this.tGQ.getWindow();
        this.tGQ.setCanceledOnTouchOutside(true);
        this.tGQ.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.tGQ.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WebViewUI.this.tGQ.dismiss();
            }
        });
        this.tGQ.setContentView(linearLayout);
        this.tGQ.show();
    }

    private void n(String str, Map<String, String> map) {
        String aD = bi.aD(aPR(), this.fJB);
        if (bi.oN(aD)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            this.pzt.loadUrl(str);
        } else if (this.tsa == null) {
            if (map.size() > 0) {
                this.pzt.loadUrl(str, map);
            } else {
                this.pzt.loadUrl(str);
            }
        } else if (!bi.oM(str).contains("#wechat_redirect")) {
            if (!eX(aD, str)) {
                String Pg = com.tencent.mm.plugin.webview.modelcache.p.Pg(aD);
                String Pg2 = com.tencent.mm.plugin.webview.modelcache.p.Pg(str);
                Object obj = (bi.oN(Pg2) || bi.oN(Pg) || !Pg2.equals(Pg) || this.jAm == null || !PP(aD)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.pzt.loadUrl(str, map);
                        return;
                    } else {
                        this.pzt.loadUrl(str);
                        return;
                    }
                }
            }
            this.tGj.put(aD, str);
            this.tGe.put(aD, map);
            this.tsa.o(str, map);
        } else if (map.size() > 0) {
            this.pzt.loadUrl(str, map);
        } else {
            this.pzt.loadUrl(str);
        }
    }

    private boolean eX(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.trv.matcher(str).matches() && com.tencent.mm.plugin.webview.a.trv.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.jAm != null && PP(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean V(Bundle bundle) {
        String str;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", Integer.valueOf(i), string, string2, string3);
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.tGf = hashMap;
        if (bi.oN(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        aj.H(this.pzt.isX5Kernel, bi.oM(str).startsWith("https://"));
        this.tyl.bRK().aO(string4, true);
        com.tencent.mm.plugin.webview.model.aj.e bRM = this.tyl.bRM();
        int i3 = this.fNt;
        String str2 = this.fHA;
        bRM.fNt = i3;
        bRM.tzz = str2;
        if (bi.oN(string2)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            bRM.jOH = string2;
            bRM.tzy = true;
            if (!bRM.tzw.containsKey(string2)) {
                bRM.tzw.put(string2, Long.valueOf(bi.Wy()));
            }
            if (!bRM.tzx.containsKey(string2)) {
                bRM.tzx.put(string2, Long.valueOf(bi.Wy()));
            }
        }
        switch (i) {
            case 1:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    return false;
                }
                this.pzt.getSettings().setJavaScriptEnabled(false);
                this.pzt.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (PV(string2)) {
                    n(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                aPM();
                return true;
            case 3:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getA8key-app: " + string2);
                if (string2 != null && string2.length() != 0) {
                    return Cs(string2);
                }
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                return false;
            case 4:
                return PU(string2);
            case 6:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (PV(string2)) {
                    this.pzt.loadUrl(string2);
                    kA(false);
                    return true;
                } else {
                    com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    aPM();
                    return true;
                }
            case 7:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (PV(string2)) {
                    n(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + string2);
                aPM();
                return true;
            case 20:
                if (bi.oN(string2)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    q qVar = this.tFE;
                    if (qVar.tHY == 0) {
                        qVar.tGT.AZ(666);
                    }
                    qVar.tHY++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    bundle2.putInt("webview_binder_id", hashCode());
                    try {
                        this.jAm.r(666, bundle2);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                return true;
            default:
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    public boolean bTI() {
        return false;
    }

    public boolean bTJ() {
        return false;
    }

    private int bTK() {
        float f = this.mController.xRr.getSharedPreferences(ad.cgf(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            return 1;
        }
        if (f == 1.125f) {
            return 3;
        }
        if (f == 1.25f || f == 1.375f || f == 1.625f) {
            return 4;
        }
        return 2;
    }

    private void Bf(int i) {
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.tsa != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tsa;
            if (dVar.tNo) {
                Map hashMap = new HashMap();
                hashMap.put("fontSize", String.valueOf(i));
                dVar.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:setfont", hashMap, dVar.tNq, dVar.tNr) + ")", null);
            } else {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            }
        }
        FontChooserView fontChooserView = (FontChooserView) this.tEQ.findViewById(com.tencent.mm.R.h.ciX);
        if (fontChooserView != null) {
            fontChooserView.qsT = i - 1;
        }
    }

    private void Bg(int i) {
        if (this.pzt != null && this.pzt.getSettings() != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + i);
            switch (i) {
                case 1:
                    this.pzt.getSettings().a(com.tencent.xweb.n.a.SMALLER);
                    return;
                case 3:
                    this.pzt.getSettings().a(com.tencent.xweb.n.a.LARGER);
                    return;
                case 4:
                    this.pzt.getSettings().a(com.tencent.xweb.n.a.LARGEST);
                    return;
                default:
                    this.pzt.getSettings().a(com.tencent.xweb.n.a.NORMAL);
                    return;
            }
        }
    }

    private final boolean PV(String str) {
        if (com.tencent.mm.platformtools.r.ifK) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            return true;
        } else if (bi.oN(str)) {
            return true;
        } else {
            if (this.tFa) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", str);
                return true;
            }
            String toLowerCase = str.toLowerCase();
            if (!toLowerCase.startsWith("file://")) {
                return true;
            }
            for (String eL : tyO) {
                if (com.tencent.mm.pluginsdk.ui.tools.s.eL(toLowerCase, eL)) {
                    return true;
                }
            }
            return false;
        }
    }

    @TargetApi(11)
    private void bTL() {
        if (com.tencent.mm.compatible.util.d.fO(11)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
        } else if (this.pzt == null || this.jAm == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        } else {
            int i;
            try {
                this.pzt.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e.getMessage());
            }
            if (this.tGR == null) {
                try {
                    if (this.jAm.aPk()) {
                        this.tGR = this.jAm.bSD();
                    }
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", e2.getMessage());
                }
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "removeConfigJsInterface, to remove list size = %d";
            Object[] objArr = new Object[1];
            if (this.tGR == null) {
                i = 0;
            } else {
                i = this.tGR.length;
            }
            objArr[0] = Integer.valueOf(i);
            com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
            if (this.tGR != null && this.tGR.length != 0) {
                try {
                    for (String str3 : this.tGR) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", str3);
                        this.pzt.removeJavascriptInterface(str3);
                    }
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", e22.getMessage());
                }
            }
        }
    }

    public final void aQn() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "doKeepPageTopLogic");
        getIntent().putExtra("is_from_keep_top", true);
        if (this.pzt != null) {
            com.tencent.mm.ui.snackbar.a.h(this.mController.xRr, getString(com.tencent.mm.R.l.eCf));
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                eY(getIntent().getStringExtra("custom_keep_top_url"), getIntent().getStringExtra("custom_keep_top_title"));
            } else {
                eY(this.pzt.getUrl(), String.valueOf(this.mController.getMMTitle()));
            }
        }
    }

    public final void aQo() {
        eY(null, null);
        com.tencent.mm.ui.snackbar.a.h(this.mController.xRr, getString(com.tencent.mm.R.l.eCa));
    }

    private void eY(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("key_last_page", str);
        bundle.putString("key_last_page_title", str2);
        bundle.putInt("key_keep_top_scene", getIntent().getIntExtra("keep_top_scene", 0));
        try {
            this.jAm.e(82, bundle);
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "keepLastPage exp=%s", e.getLocalizedMessage());
        }
    }

    public final boolean Vi() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "hasKeepLastPageTop KIsFromKeepTop=%b", Boolean.valueOf(com.tencent.mm.sdk.platformtools.t.a(getIntent(), "is_from_keep_top", false)));
        if (!com.tencent.mm.sdk.platformtools.t.a(getIntent(), "is_from_keep_top", false)) {
            return false;
        }
        try {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "hasKeepLastPageTop hasKeep=%b", Boolean.valueOf(this.jAm.e(89, new Bundle()).getBoolean("key_is_webview_keep_top", true)));
            return this.jAm.e(89, new Bundle()).getBoolean("key_is_webview_keep_top", true);
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "hasKeepLastPageTop exp=%s", e.getLocalizedMessage());
            return true;
        }
    }

    public final boolean aPV() {
        if (this.tFT != null) {
            boolean z;
            d dVar = this.tFT;
            if (bi.oN(dVar.tHS)) {
                z = false;
            } else {
                z = dVar.tHS.equals("true");
            }
            if (!(!z || bi.oN(this.tFT.aPz()) || bi.oN(this.tFT.aPA()) || bi.oN(this.tFT.aPB()))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", this.tFT.aPz(), this.tFT.aPA(), this.tFT.aPB());
                View inflate = View.inflate(this.mController.xRr, com.tencent.mm.R.i.dns, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(com.tencent.mm.R.h.cwh);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(com.tencent.mm.R.h.cwj);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(com.tencent.mm.R.e.btv));
                textView = (TextView) inflate.findViewById(com.tencent.mm.R.h.cwi);
                textView.setTextColor(getResources().getColor(com.tencent.mm.R.e.btv));
                textView.setVisibility(8);
                this.tFU = com.tencent.mm.ui.base.h.a(this.mController.xRr, true, "", inflate, r4, r5, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (checkBox != null && checkBox.isChecked()) {
                            try {
                                if (WebViewUI.this.jAm.aPk()) {
                                    WebViewUI.this.jAm.eo(327792, 1);
                                }
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
                            }
                        }
                        WebViewUI.this.tGm = true;
                        WebViewUI.this.tFU = null;
                        g.tEG.close();
                        WebViewUI.this.finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WebViewUI.this.tFU = null;
                    }
                });
                return true;
            }
        }
        return false;
    }

    private void bTM() {
        if (this.pzt != null) {
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "updateKeepTopPage: SCENE_CUSTOM_TOP_URL no update");
            } else if (Vi()) {
                eY(this.pzt.getUrl(), String.valueOf(this.mController.getMMTitle()));
            }
        }
    }

    public void hf(boolean z) {
    }

    public void h(int i, Bundle bundle) {
    }

    public boolean bTN() {
        return true;
    }

    public void s(int i, Bundle bundle) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    }

    protected static void bTO() {
    }

    public final void kD(boolean z) {
        String url = this.pzt.getUrl();
        if (z) {
            showOptionMenu(0, false);
            this.tFR.put(url, Boolean.valueOf(true));
            return;
        }
        showOptionMenu(0, true);
        if (this.tFR.containsKey(url)) {
            this.tFR.remove(url);
        }
    }

    public final boolean bTP() {
        if (this.tGS == -3) {
            return false;
        }
        showVKB();
        return true;
    }

    public final void aWY() {
        super.aWY();
        this.tGS = -2;
    }

    public final void showVKB() {
        super.showVKB();
        if (this.tGS == -3) {
            this.tGS = -2;
        } else {
            this.tGS = -3;
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        super.setBackBtn(onMenuItemClickListener, i);
        if (com.tencent.mm.compatible.util.d.fN(21) && aSd()) {
            cnJ();
        }
    }

    public void bTQ() {
    }
}
