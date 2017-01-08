package com.ccb.test.anny.imagetest.model;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;

import com.ccb.test.anny.imagetest.R;

/**
 * Created by Anny on 2017-1-8.
 */

public class TestData {

    static String[] testFactorNm = {"测试切片", "安卓", "建行"};
    static int[] testImageResourceId = {R.drawable.test_map,
                                        R.drawable.android_test1,
                                        R.drawable.ccb_test2
                                        };
    static int size = testFactorNm.length;

    public static String getFactorNm(int index) {
        index = index % size;
        return testFactorNm[index];
    }

    public static Uri getImageUriByIndex(Resources resource, int index) {
        index = index % size;
        int resouceId = testImageResourceId[index];

        return getImageUriByResourceId(resource, resouceId);
    }

    public static Uri getImageUriByResourceId(Resources resource, int resouceId) {
        //Resources resource = context.getResources();
        String uriStr = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resource.getResourcePackageName(resouceId) + "/" +
                resource.getResourceTypeName(resouceId) + "/" +
                resource.getResourceEntryName(resouceId);
        Uri imageUri = Uri.parse(uriStr);
        return imageUri;
    }



}
