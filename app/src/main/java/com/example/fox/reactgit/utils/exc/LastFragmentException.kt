package com.example.fox.reactgit.utils.exc

import java.lang.Exception

class LastFragmentException:Exception("There is no fragments in backStack. Cant popBackStack.")