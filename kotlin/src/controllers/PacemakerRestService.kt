package controllers

import Activity
import Location
import User
import io.javalin.Javalin
import jdk.javadoc.internal.doclets.toolkit.builders.AbstractBuilder
import main.models.User


class PacemakerRestService {
    class PacemakerRestService {
        val pacemaker = PacemakerAPI()

        fun listUsers(ctx: Context) {
            ctx.json(pacemaker.users)
        }

        fun createUser(ctx: Context) {
            val user = ctx.bodyAsClass(User::class.java)
            val newUser = pacemaker.createUser(user.firstname, user.lastname, user.email, user.password)
            ctx.json(newUser)
        }

        fun deleteUsers(ctx: Context) {
            pacemaker.deleteUsers()
            ctx.status(200)
        }

    }

}


