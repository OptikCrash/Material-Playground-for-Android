package com.digitalrelay.materialplayground.models

class Theme(primaryColor: Int, primaryDarkColor: Int, accentColor: Int) {
    var id: Int = 0
    var primaryColor: Int = 0
    var primaryDarkColor: Int = 0
    var accentColor: Int = 0

    init {
        this.primaryColor = primaryColor
        this.primaryDarkColor = primaryDarkColor
        this.accentColor = accentColor
    }

    constructor(id: Int, primaryColor: Int, primaryDarkColor: Int, accentColor: Int) : this(primaryColor, primaryDarkColor, accentColor) {
        this.id = id
    }

}