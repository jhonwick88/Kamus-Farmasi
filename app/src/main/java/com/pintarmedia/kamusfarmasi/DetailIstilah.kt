package com.pintarmedia.kamusfarmasi

import android.os.Bundle
import com.pintarmedia.kamusfarmasi.model.Farmasi
import kotlinx.android.synthetic.main.detail_istilah.*

class DetailIstilah : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_istilah)
        val farmasi = intent.extras?.get("farmasi") as Farmasi
        istilahTV.text = farmasi.istilah
        artiTV.text = farmasi.arti
        copyIstilah.setOnClickListener { showToast("copied") }
        moreAction.setOnClickListener { showToast("share it") }

    }
}
