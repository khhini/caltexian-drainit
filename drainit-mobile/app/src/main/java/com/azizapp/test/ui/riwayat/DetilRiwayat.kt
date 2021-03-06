package com.azizapp.test.ui.riwayat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.azizapp.test.R
import com.azizapp.test.databinding.ActivityDetilRiwayatBinding
import com.azizapp.test.model.Pengaduan
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detil_riwayat.*
import kotlinx.android.synthetic.main.bottom_sheet_detail.*


@AndroidEntryPoint
class DetilRiwayat : AppCompatActivity() {

    lateinit var binding: ActivityDetilRiwayatBinding

    companion object {
        const val DETAIL_EXTRA_PARCEL = "DETAIL_EXTRA_PARCEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilRiwayatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        binding.collapsingToolbar.title = "Detail Laporan"

//        binding.collapsingToolbar.setCollapsedTitleTextColor(
//            ContextCompat.getColor(this, R.color.white))
//        binding.collapsingToolbar.setExpandedTitleColor(
//            ContextCompat.getColor(this, R.color.header))

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detil_riwayat)
        val item: Pengaduan? = intent.getParcelableExtra(DETAIL_EXTRA_PARCEL)

        binding.apply {
            lifecycleOwner = this@DetilRiwayat
            data = item
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}