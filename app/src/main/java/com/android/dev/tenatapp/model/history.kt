package com.android.dev.tenatapp.model

import android.graphics.Bitmap
import java.io.Serializable

data class history(var purpose:String,val formonth:String, val onmonth:String,val fees:String,val image: Bitmap):Serializable
