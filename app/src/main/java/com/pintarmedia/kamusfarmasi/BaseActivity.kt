package com.pintarmedia.kamusfarmasi

import android.content.ClipData
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity(){
    fun showToast(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
    fun copyClipboard(context : Context, text: String){
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Text Copied", Toast.LENGTH_SHORT).show()
    }
}