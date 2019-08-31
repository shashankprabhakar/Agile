package main.models
import com.google.common.base.MoreObjects.toStringHelper
import com.google.common.base.Objects
import java.io.Serializable
import java.util.*

class User : Serializable {
    var id: String? = null
    var firstname: String? = null
    var lastname: String? = null
    var email: String? = null
    var password: String? = null
    var activities: Map<String, Activity> = HashMap()

    constructor() {}

    constructor(firstname: String?, lastname: String?, email: String?, password: String?) {
        id = UUID.randomUUID().toString()
        this.firstname = firstname
        this.lastname = lastname
        this.email = email
        this.password = password
    }

    override fun equals(obj: Any?): Boolean {
        return if (obj is User) {
            val other = obj
            (Objects.equal(firstname, other.firstname)
                    && Objects.equal(lastname, other.lastname)
                    && Objects.equal(email, other.email)
                    && Objects.equal(password, other.password)
                    && Objects.equal(activities, other.activities))
        } else {
            false
        }
    }

    override fun toString(): String {
        return toStringHelper(this).addValue(id)
                .addValue(firstname)
                .addValue(lastname)
                .addValue(password)
                .addValue(email)
                .addValue(activities)
                .toString()
    }

    override fun hashCode(): Int {
        return Objects.hashCode(id, lastname, firstname, email, password)
    }
}