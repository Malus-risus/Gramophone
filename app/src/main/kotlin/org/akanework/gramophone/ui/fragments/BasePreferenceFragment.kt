/*
 *     Copyright (C) 2024 Akane Foundation
 *
 *     Gramophone is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Gramophone is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.akanework.gramophone.ui.fragments

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.color.MaterialColors

/**
 * BasePreferenceFragment:
 *   A base fragment for all SettingsTopFragment. It
 * is used to make overlapping color easier.
 *
 * @author AkaneTan
 */
abstract class BasePreferenceFragment : PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(MaterialColors.getColor(view, android.R.attr.colorBackground))
    }

    override fun setDivider(divider: Drawable?) {
        super.setDivider(ColorDrawable(Color.TRANSPARENT))
    }

    override fun setDividerHeight(height: Int) {
        super.setDividerHeight(0)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
    }

    override fun onStart() {
        super.onStart()
        preferenceScreen.sharedPreferences?.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onStop() {
        super.onStop()
        preferenceScreen.sharedPreferences?.unregisterOnSharedPreferenceChangeListener(this)
    }

}