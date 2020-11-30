package com.example.latihanmodul8

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val mContext: Context, fm: FragmentManager) :FragmentPagerAdapter(fm) {
    //menampilkan sesuai posisi fragment
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FirstFragment.newInstance()
        }else if(position == 1){
            SecondFragment.newInstance()
        }else{
            ThirdFragment.newInstance()
        }
    }
    //memberikan judul halaman tiap tab
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }
    //menampilkan jumlah halaman yang dibuat adapter
    override fun getCount(): Int {
        return 3
    }
    //memberikan nama pada tab
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3)
    }
}