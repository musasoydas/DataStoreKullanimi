package com.example.datastorekullanimi

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(val context: Context) {
    val Context.ds: DataStore<Preferences> by preferencesDataStore("bilgiler")

    companion object{
        val AD_KEY= stringPreferencesKey("AD")
        val YAS_KEY= intPreferencesKey("Yas")
    }

    suspend fun kayitAd(ad: String){
        context.ds.edit {
            it[AD_KEY]= ad
        }
    }

    suspend fun okuAd(): String{
        val p= context.ds.data.first()
        return p[AD_KEY] ?: "isim yok"
    }
    suspend fun silAd(){
        context.ds.edit {
            it.remove(AD_KEY)
        }
    }

    suspend fun yasEkle(yas : Int){
        context.ds.edit {
            it[YAS_KEY]= yas
        }
    }
    suspend fun yasOku(): Int{
        val p= context.ds.data.first()
        return p[YAS_KEY] ?: 0
    }
    suspend fun yasSil(){
        context.ds.edit {
            it.remove(YAS_KEY)
        }
    }
}