package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bi;

public final class GalleryItem {

    public static class VideoMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                VideoMediaItem videoMediaItem = new VideoMediaItem();
                videoMediaItem.hQc = parcel.readString();
                videoMediaItem.mqO = parcel.readString();
                videoMediaItem.mWR = parcel.readLong();
                videoMediaItem.mMimeType = parcel.readString();
                videoMediaItem.videoWidth = parcel.readInt();
                videoMediaItem.videoHeight = parcel.readInt();
                videoMediaItem.hQf = parcel.readInt();
                videoMediaItem.hQd = parcel.readString();
                videoMediaItem.hQe = parcel.readString();
                videoMediaItem.hQg = parcel.readInt();
                videoMediaItem.videoFrameRate = parcel.readInt();
                videoMediaItem.videoBitRate = parcel.readInt();
                return videoMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public String hQd;
        public String hQe;
        public int hQf = -1;
        public int hQg = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        public VideoMediaItem(long j) {
            super(j);
        }

        public VideoMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 2;
        }

        public final String aOC() {
            if (bi.oN(this.mqO)) {
                return this.hQc;
            }
            return this.mqO;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hQc);
            parcel.writeString(this.mqO);
            parcel.writeLong(this.mWR);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.hQf);
            parcel.writeString(this.hQd);
            parcel.writeString(this.hQe);
            parcel.writeInt(this.hQg);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
        }

        public String toString() {
            return "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.hQd + '\'' + ", audioTrackMime='" + this.hQe + '\'' + ", durationMs=" + this.hQf + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.hQg + ", videoFrameRate=" + this.videoFrameRate + '}';
        }
    }

    public static abstract class MediaItem implements Parcelable, Comparable<MediaItem> {
        public String hQc;
        public String mMimeType;
        public String mWP;
        public String mWQ;
        public long mWR;
        public long mWS;
        public String mqO;

        public abstract String aOC();

        public abstract int getType();

        public /* synthetic */ int compareTo(Object obj) {
            return a((MediaItem) obj);
        }

        public MediaItem() {
            this(0, "", "", "");
        }

        public MediaItem(long j) {
            this(j, "", "", "");
        }

        public MediaItem(long j, String str, String str2, String str3) {
            this.mWR = j;
            this.hQc = str;
            this.mqO = str2;
            this.mMimeType = str3;
        }

        public static MediaItem a(int i, long j, String str, String str2, String str3) {
            if (i == 1) {
                return new ImageMediaItem(j, str, str2, str3);
            }
            return new VideoMediaItem(j, str, str2, str3);
        }

        public static MediaItem w(int i, long j) {
            if (i == 1) {
                return new ImageMediaItem(j);
            }
            return new VideoMediaItem(j);
        }

        public final int a(com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = -1;
            r2 = r6.mWS;
            r4 = r7.mWS;
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 <= 0) goto L_0x000b;
        L_0x0009:
            r0 = 1;
        L_0x000a:
            return r0;
        L_0x000b:
            r2 = r6.mWS;
            r4 = r7.mWS;
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 >= 0) goto L_0x000a;
        L_0x0013:
            goto L_0x000a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem.a(com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem):int");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) obj;
            if (this.hQc == null || !this.hQc.equals(mediaItem.hQc)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MediaItem{mOrignalPath='" + this.hQc + '\'' + ", mThumbPath='" + this.mqO + '\'' + ", origId=" + this.mWR + ", addDate=" + this.mWS + ", mMimeType='" + this.mMimeType + '\'' + '}';
        }
    }

    public static class AlbumItem implements Parcelable {
        public static final Creator<AlbumItem> CREATOR = new Creator<AlbumItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AlbumItem(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AlbumItem[i];
            }
        };
        public int fuA;
        public String mWN;
        public MediaItem mWO;

        public AlbumItem(String str, int i) {
            this.mWN = bi.oM(str);
            this.fuA = i;
        }

        protected AlbumItem(Parcel parcel) {
            this.mWN = parcel.readString();
            this.fuA = parcel.readInt();
            this.mWO = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        }

        public final String aOC() {
            if (this.mWO == null) {
                return null;
            }
            return this.mWO.aOC();
        }

        public final long aOD() {
            if (this.mWO == null) {
                return -1;
            }
            return this.mWO.mWR;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mWN);
            parcel.writeInt(this.fuA);
            parcel.writeParcelable(this.mWO, i);
        }
    }

    public static class ImageMediaItem extends MediaItem {
        public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                MediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.hQc = parcel.readString();
                imageMediaItem.mqO = parcel.readString();
                imageMediaItem.mWR = parcel.readLong();
                imageMediaItem.mWS = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                return imageMediaItem;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        public ImageMediaItem(long j) {
            super(j);
        }

        public ImageMediaItem(long j, String str, String str2, String str3) {
            super(j, str, str2, str3);
        }

        public final int getType() {
            return 1;
        }

        public final String aOC() {
            if (bi.oN(this.mqO)) {
                return this.hQc;
            }
            return this.mqO;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.hQc);
            parcel.writeString(this.mqO);
            parcel.writeLong(this.mWR);
            parcel.writeLong(this.mWS);
            parcel.writeString(this.mMimeType);
        }
    }
}
