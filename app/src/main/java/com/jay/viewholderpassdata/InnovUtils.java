package com.jay.viewholderpassdata;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;



import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by khurseeda on 11/7/2016.
 */

public class InnovUtils {
    public static Context appContext;
    public static String PREFERENCE;
    private static String TAG = InnovUtils.class.getSimpleName();

    public static final String const_side_menu = "Side Menu";
    public static final Pattern MOBILE_PATTERN = Pattern.compile("[1-9][0-9]{9}");
    public static final Pattern PANCARD_PATTERN = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    public static final int const_milliseconds_qms_duration = 4000;
    public static final String const_playstore_url = "https://play.google.com/store/apps/details?id=com.innov.recruiter";
    public static final String const_records_per_page = "10";
    public static final String const_Masters_Storage_file = "allmasters.json";
    public static final long const_millis_to_exit = 2000;

    public static final String const_SPK_GCM_REG_ID = "SPK_GCM_REG_ID";
    public static final String const_SPK_FORCE_UPDATE_ENABLED = "SPK_FORCE_UPDATE_ENABLED";
    public static final String const_SPK_SERVICE_URL = "service_url";
    public static final String const_SPK_MASTERS_FETCH_TIMESTAMP = "SPK_MASTERS_FETCH_TIMESTAMP";
    public static final String const_SPK_IMEI = "SPK_IMEI";
    public static final String const_SPK_APIKEY = "SPK_APIKEY";
    public static final String const_SPK_MEMBERNAME = "SPK_MEMBERNAME";
    public static final String const_SPK_MEMBER_ID = "memberid";
    public static final String const_SPK_MEMBER_EMAIL = "SPK_MEMBER_EMAIL";
    public static final String const_SPK_USER_TYPE = "userTypeNew";
    public static final String const_SPK_MEMBER_CITY_NAME = "SPK_MEMBER_CITY_NAME";
    public static final String const_SPK_RETAILER_CATEGORY = "SPK_RETAILER_CATEGORY";
    public static final String const_SPK_LAST_UPDATE_DETAIL = "LAST_UPDATE_DETAIL";

    public static void runAfterDelay(int delay, Runnable runnable) {
        final Handler handler = new Handler();
        handler.postDelayed(runnable, delay);
    }

//    public static boolean connectedToInternet(Context appContext) {
//        ConnectivityManager cm = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
//        //NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//      //  boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
//       // return isConnected;
//    }

    // for memberId string preferencesf


    public static void setSharedPreferenceBoolean(Context context, String name,
                                                  boolean value) {
        appContext = context;
        SharedPreferences settings = context
                .getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static boolean getSharedPreferencesBoolean(Context context,
                                                      String name) {
        SharedPreferences settings = context
                .getSharedPreferences(PREFERENCE, 0);
        return settings.getBoolean(name, false);
    }
    public static void setSharedPreference(Context context, String name, String value) {
        appContext = context;
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putString(name, value);
        // editor.putString(name, "653");
        editor.commit();
    }

    public static String getSharedPreferences(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getString(name, "");
    }


    @Nullable
    public static String simpleClassName(Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass().getSimpleName();
    }


    public static void showDialog(Context context, String message) {
        ContextThemeWrapper themedContext;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            themedContext = new ContextThemeWrapper(context, android.R.style.Theme_Black);
        } else {
            themedContext = new ContextThemeWrapper(context, android.R.style.Theme_Black);
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(themedContext);
        alertDialog.setMessage(message).setCancelable(false).setNeutralButton("OK", null);
        AlertDialog alert = alertDialog.create();
        alert.show();
    }


    /**
     * To Convert String Into MD5 Hash
     */
    public static String getMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String md5 = number.toString(16);

            while (md5.length() < 32)
                md5 = "0" + md5;

            return md5;
        } catch (NoSuchAlgorithmException e) {

            return null;
        }
    }

    public static void hideKeyboard(Activity appContext) {
        InputMethodManager imm = (InputMethodManager) appContext.getSystemService(INPUT_METHOD_SERVICE);
        View view = appContext.getCurrentFocus();
        if (view != null) {
            IBinder binder = view.getWindowToken();
            if (binder != null) {
                imm.hideSoftInputFromWindow(binder, 0);
            }
        }
    }

    public static void showToastMessage(Context con, String msg, String toastLength) {


        if (toastLength.equalsIgnoreCase("S")) {
//            Snackbar snack = Snackbar.make(con.findViewById(R.id.frame_layout_main_activity), msg, Snackbar.LENGTH_SHORT);
//            snack.show();
            Toast.makeText(con, msg, Toast.LENGTH_SHORT).show();
        }

        if (toastLength.equalsIgnoreCase("L")) {
//            Snackbar snack = Snackbar.make(findViewById(R.id.frame_layout_main_activity), msg, Snackbar.LENGTH_LONG);
//            snack.show();
            Toast.makeText(con, msg, Toast.LENGTH_LONG).show();
        }

/*        if (msg == "" || msg == null || toastLength == "" || toastLength == null) {
            return;
        }
        if (!(msg instanceof String) || !(toastLength instanceof String)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("toast_length", toastLength);
        bundle.putString("message", msg);
        EventBus.getDefault().post(new ResponceEvent(ResponceEvent.EventType.StatusShowSnackbar, bundle));*/
    }

    public static Bitmap setImage(String imgstring) {
        byte[] decodedString = Base64.decode(imgstring, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;

    }

    public static String getStringImage(String imageFile, Context appContext) {

        File file = new File(imageFile.toString().trim());
        Uri fileUri = Uri.fromFile(file);

        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(appContext.getContentResolver(), fileUri);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            Log.e(TAG, "Byte Array : " + imageBytes);

            String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            return encodedImage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateFormat(String date) {
//      01-11-2001

        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
        Date oneWayTripDate;
        try {
            oneWayTripDate = input.parse(date);                 // parse input
            return output.format(oneWayTripDate);    // format output
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRealPathFromURI(Uri contentURI, Context appContext) {
        String result;
        Cursor cursor = appContext.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    public static Uri getOutputMediaFileUri(File file) {
        return Uri.fromFile(file);
    }

    /**
     * Innov Bit Map
     */

    public static Bitmap innovBitMap(String imgString) {
        byte[] decodedString = Base64.decode(imgString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }


    public static Boolean isValidString(Object string) {
        boolean result = true;
        if (string == null) {
            result = false;
        } else if (!(string instanceof String)) {
            result = false;
        } else {
            String aString = (String) string;
            if (aString.isEmpty()) {
                result = false;
            }
        }
        return result;
    }

//    public static boolean connectedToInternet() {
//        ConnectivityManager cm = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
//        return isConnected;
//    }

    public static String versionName(Context appContext) {
        String version = "version";
        try {
            PackageInfo pInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return version;
    }


    /***
     *  Scaled Bitmap
     */
    public static Bitmap createScaledBitmap(String pathName, int width, int height) {
        final BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, opt);
        opt.inSampleSize = calculateBmpSampleSize(opt, width, height);
        opt.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(pathName, opt);
    }

    public static  int calculateBmpSampleSize(BitmapFactory.Options opt, int width, int height) {
        final int outHeight = opt.outHeight;
        final int outWidth = opt.outWidth;
        int sampleSize = 1;
        if (outHeight > height || outWidth > width) {
            final int heightRatio = Math.round((float) outHeight / (float) height);
            final int widthRatio = Math.round((float) outWidth / (float) width);
            sampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return sampleSize;
    }


}
