plugins {
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
}

extra.apply {
    set("mavenGroup", "com.spryrocks.barcode-generator")
    set("mavenVersion", "0.0.2")
}
