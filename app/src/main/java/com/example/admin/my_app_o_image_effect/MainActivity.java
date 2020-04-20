package com.example.admin.my_app_o_image_effect;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    
    ImageView myImageView;
    Drawable myFlower;
    Bitmap bitmapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myImageView = (ImageView) findViewById(R.id.myImageView);

       /* myFlower = ResourcesCompat.getDrawable(getResources(),R.drawable.park_pic, null);//added image to a variable
        bitmapImage = ((BitmapDrawable) myFlower).getBitmap();//convert to bitmap to process it
        
        Bitmap newphoto = invertImage(bitmapImage);
        myImageView.setImageBitmap(newphoto);*/

       Drawable [] layers = new Drawable[2];//creating layer 1 for flower ad other for filter
        layers[0] = ResourcesCompat.getDrawable(getResources(),R.drawable.park_pic,null);
        layers[1] = ResourcesCompat.getDrawable(getResources(),R.drawable.image_filter,null);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        myImageView.setImageDrawable(layerDrawable);
    }
    //convert image into bitmap in order to apply effects on it
    public static Bitmap invertImage(Bitmap orignal){
        Bitmap finalImage = Bitmap.createBitmap(orignal.getWidth(),orignal.getHeight(),orignal.getConfig());
        
        int A,R,G,B;
        int pixelcolor;
        int height = orignal.getHeight();
        int width =  orignal.getWidth();
        //image is a matrix of pixels
        
        for(int y = 0; y<height; y++)
        {   
            for(int x = 0; x<width; x++) {
                pixelcolor = orignal.getPixel(x, y);
                A = Color.alpha(pixelcolor);
                R = 255 - Color.red(pixelcolor);
                G = 255 - Color.green(pixelcolor);
                B = 255 - Color.blue(pixelcolor);
                
                finalImage.setPixel(x,y,Color.argb(A,R,G,B));
                 
                
            }
        }
        return finalImage;
    }
}
