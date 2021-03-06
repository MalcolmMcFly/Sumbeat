package com.erm.artists.ui.main

import android.content.Context
import android.util.SparseArray
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.erm.artists.ui.favorite.FavoriteArtistsFragment
import com.erm.artists.ui.favorite.FavoriteEventsFragment

class MainPagerAdapter(fragmentManager: FragmentManager, val context: Context) : FragmentStatePagerAdapter(fragmentManager) {
    companion object {
        const val TOTAL_FRAGMENTS = 2
    }

    private val registeredFragments = SparseArray<Fragment>()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            MainActivityViewModel.CurrentFragment.ARTISTS.ordinal -> FavoriteArtistsFragment.newInstance()
            else -> FavoriteEventsFragment.newInstance()
        }
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as Fragment
        registeredFragments.put(position, fragment)
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    override fun getCount(): Int {
        return TOTAL_FRAGMENTS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return ""
    }
}