package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.applet.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiPrivateAddContact extends a {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    private static final class AddContactRequest extends ProcessRequest {
        public static final Creator<AddContactRequest> CREATOR = new Creator<AddContactRequest>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AddContactRequest(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactRequest[i];
            }
        };
        int jgZ;
        int scene;
        String userName;

        AddContactRequest() {
        }

        AddContactRequest(Parcel parcel) {
            h(parcel);
        }

        protected final Class<? extends AppBrandProxyUIProcessTask> afD() {
            return a.class;
        }

        public final void h(Parcel parcel) {
            this.userName = parcel.readString();
            this.scene = parcel.readInt();
            this.jgZ = parcel.readInt();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.userName);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.jgZ);
        }
    }

    private static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z = true;
            final ProcessResult addContactResult = new AddContactResult();
            if (processRequest instanceof AddContactRequest) {
                AddContactRequest addContactRequest = (AddContactRequest) processRequest;
                g gVar = (g) com.tencent.mm.kernel.g.h(g.class);
                Context afu = afu();
                String str = addContactRequest.userName;
                int i = addContactRequest.scene;
                l anonymousClass1 = new l() {
                    public final void ks(int i) {
                        x.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", Integer.valueOf(i));
                        addContactResult.bjW = -1;
                        a.this.a(addContactResult);
                    }
                };
                if (addContactRequest.jgZ != 1) {
                    z = false;
                }
                gVar.a(afu, str, i, anonymousClass1, z, "").show();
                return;
            }
            x.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
            addContactResult.bjW = -1;
            a(addContactResult);
        }
    }

    private static final class AddContactResult extends ProcessResult {
        public static final Creator<AddContactResult> CREATOR = new Creator<AddContactResult>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AddContactResult(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddContactResult[i];
            }
        };
        private int bjW;

        AddContactResult() {
        }

        AddContactResult(Parcel parcel) {
            h(parcel);
        }

        protected final void h(Parcel parcel) {
            this.bjW = parcel.readInt();
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bjW);
        }
    }

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        int afM = afM();
        try {
            int i2 = jSONObject.getInt("scene");
            String string = jSONObject.getString("username");
            if (bi.oN(string)) {
                x.i("MicroMsg.JsApiPrivateAddContact", "username nil");
                pVar.E(i, e("fail", null));
            }
            ProcessRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i2;
            addContactRequest.jgZ = afM;
            com.tencent.mm.plugin.appbrand.ipc.a.a(pVar.mContext, addContactRequest, new b<AddContactResult>() {
                public final /* synthetic */ void c(ProcessResult processResult) {
                    x.i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", Integer.valueOf(((AddContactResult) processResult).bjW));
                    switch (((AddContactResult) processResult).bjW) {
                        case -2:
                            pVar.E(i, JsApiPrivateAddContact.this.e("added", null));
                            return;
                        case -1:
                            pVar.E(i, JsApiPrivateAddContact.this.e("fail", null));
                            return;
                        case 0:
                            pVar.E(i, JsApiPrivateAddContact.this.e("cancel", null));
                            return;
                        case 1:
                            pVar.E(i, JsApiPrivateAddContact.this.e("ok", null));
                            return;
                        default:
                            return;
                    }
                }
            });
        } catch (JSONException e) {
            x.w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", e);
            pVar.E(i, e("fail", null));
        }
    }

    protected int afM() {
        return 1;
    }
}
