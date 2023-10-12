package com.example.week12

import android.R.attr.path
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date


class CameraActivity : AppCompatActivity() {
    var imgView : ImageView? = null;
    var currentPhotoPath : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        imgView = findViewById(R.id.ImageView);
    }

    fun createFilePhoto() : File {
        var timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date());
        var fileName = "JPGE_" + timeStamp + "_";
        var storage = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        var image = File.createTempFile(fileName, ".jpg", storage);
        currentPhotoPath = image.absolutePath;
        return image;
    }
    fun openCamera(view : View) {
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            var file : File = createFilePhoto();
            if(file != null) {
                var photoURI = FileProvider.getUriForFile(this, "com.example.fileprovider", file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(intent, 999);
            }
        } catch (e : IOException) {
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 999 && resultCode == RESULT_OK) {
            var w = imgView?.width;
            var h = imgView?.height;
            var options : BitmapFactory.Options = BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(currentPhotoPath, options);


            var photoW = options.outWidth;
            var photoH = options.outHeight;
            var scale = Math.max(1, Math.min(photoW / w!!, photoH / h!!));
            options.inJustDecodeBounds = false;
            options.inSampleSize = scale;
            options.inPurgeable = true;

            var bitmap = BitmapFactory.decodeFile(currentPhotoPath, options);
            imgView?.setImageBitmap(bitmap);

            var intent  = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            var file = File(currentPhotoPath);
            var uri_Content = Uri.fromFile(file);
            intent.setData(uri_Content);
        }
    }
}