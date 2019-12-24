package net.fonix232.typiapp.domain.navigation

class NavigationException(command: NavCommand) :
    Exception("Invalid navigation target: ${command::class.java.canonicalName}")
