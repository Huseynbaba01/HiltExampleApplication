package com.thenexprojects.hiltexampleapplication.example

import javax.inject.Inject

class Car @Inject constructor (val model: String, val engine: Engine) {
}