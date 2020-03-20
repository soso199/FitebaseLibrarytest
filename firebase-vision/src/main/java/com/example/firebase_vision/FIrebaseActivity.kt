package com.example.firebase_vision

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions

class FIrebaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f_irebase)

        FirebaseApp.initializeApp(this, FirebaseOptions.Builder().setApiKey("AIzaSyDtCKSrnEmqgPAQO8d6ygrjil4DOj_7Uhg").setApplicationId("1:159074211479:android:661419455e1efde08f7bd2").build())

// High-accuracy landmark detection and face classification
        val highAccuracyOpts = FirebaseVisionFaceDetectorOptions.Builder()
            .setPerformanceMode(FirebaseVisionFaceDetectorOptions.ACCURATE)
            .setLandmarkMode(FirebaseVisionFaceDetectorOptions.ALL_LANDMARKS)
            .setClassificationMode(FirebaseVisionFaceDetectorOptions.ALL_CLASSIFICATIONS)
            .build()


        val image = FirebaseVisionImage.fromBitmap(BitmapFactory.decodeResource(resources, R.drawable.dd))

        val detector = FirebaseVision.getInstance()
            .getVisionFaceDetector(highAccuracyOpts)

        val result = detector.detectInImage(image)
            .addOnSuccessListener { faces ->
                Log.d("success",faces.toString())
            }
            .addOnFailureListener { e ->
                Log.d("failure","")
            }
    }
}
