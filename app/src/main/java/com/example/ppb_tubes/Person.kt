package com.example.ppb_tubes

import android.os.Parcel
import android.os.Parcelable

data class Person(
    var username:String?,
    var tag: String?,
    val email: String?,
    var password: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(username)
        parcel.writeString(tag)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}