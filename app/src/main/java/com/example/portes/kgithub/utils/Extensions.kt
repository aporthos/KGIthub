package com.example.portes.kgithub.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by portes on 03/12/17.
 */
fun ViewGroup.inflate(mResource: Int)  = LayoutInflater.from(context).inflate(mResource, this, false)