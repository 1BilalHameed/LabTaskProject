package com.example.user.labtaskapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyFragmentAdaptor(val fm:FragmentManager,val pages:ArrayList<Fragment>,val fragmentTitle:ArrayList<String>):FragmentPagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {

        return pages[p0]
    }

    override fun getCount(): Int {
        return fragmentTitle.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return fragmentTitle[position]
    }

}