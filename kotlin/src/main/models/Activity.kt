package main.models


import java.util.UUID

data class Activity(

var id: String? = null
var type: String? = null
var location: String? = null
var distance = 0.0
var route: List<Location> = ArrayList()

constructor() {}
constructor(type: String?, location: String?, distance: Double) {
    id = UUID.randomUUID().toString()
    this.type = type
    this.location = location
    this.distance = distance
}

fun getDistance(): String? {
    return Double.toString(distance)
}

fun getRoute(): String {
    return route.toString()
}

override fun equals(obj: Any?): Boolean {
    return if (obj is Activity) {
        val other = obj
        (Objects.equal(type, other.type)
                && Objects.equal(location, other.location)
                && Objects.equal(distance, other.distance)
                && Objects.equal(route, other.route))
    } else {
        false
    }
}

override fun toString(): String {
    return toStringHelper(this).addValue(id)
            .addValue(type)
            .addValue(location)
            .addValue(distance)
            .addValue(route)
            .toString()
}

override fun hashCode(): Int {
    return Objects.hashCode(id, type, location, distance)
}