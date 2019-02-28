package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new Creator<ProductSectionItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ProductSectionItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProductSectionItem[i];
        }
    };
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public List<Skus> phs;
    public String pht;
    public String phu;
    public int scene;

    public static class Skus implements Parcelable {
        public static final Creator<Skus> CREATER = new Creator<Skus>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Skus(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Skus[i];
            }
        };
        public String aAM;
        public String value;

        public Skus(Parcel parcel) {
            this.aAM = parcel.readString();
            this.value = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.aAM);
            parcel.writeString(this.value);
        }

        public static String bm(List<Skus> list) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return stringBuilder.toString();
                }
                Skus skus = (Skus) list.get(i2);
                if (i2 != 0) {
                    stringBuilder.append("、");
                }
                stringBuilder.append(skus.value);
                i = i2 + 1;
            }
        }
    }

    public ProductSectionItem(Parcel parcel) {
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.phs = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.aAM = parcel.readString();
                skus.value = parcel.readString();
                this.phs.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.pht = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.phu = parcel.readString();
        this.scene = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.phs != null) {
            parcel.writeInt(this.phs.size());
            while (true) {
                int i3 = i2;
                if (i3 >= this.phs.size()) {
                    break;
                }
                Skus skus = (Skus) this.phs.get(i3);
                parcel.writeString(skus.aAM);
                parcel.writeString(skus.value);
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.pht);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.phu);
        parcel.writeInt(this.scene);
    }
}
