// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    id ("io.github.takahirom.roborazzi") version "1.7.0-alpha-1" apply false
}