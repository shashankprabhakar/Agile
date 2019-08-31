package main.models

data class Location(
        val latitude: Double,
        val longitude: Double)

constructor(latitude: Double, longitude: Double) {
    id = UUID.randomUUID().toString()
    this.latitude = latitude
    this.longitude = longitude
}

override fun equals(obj: Any?): Boolean {
    return if (obj is Location) {
        val other: Any? = obj
        (Objects.equal(latitude, other.latitude)
                && Objects.equal(longitude, other.longitude))
    } else {
        false
    }
}

override fun toString(): String {
    return toStringHelper(this).addValue(id)
            .addValue(latitude)
            .addValue(longitude)
            .toString()
}

override fun hashCode(): Int {
    return Objects.hashCode(id, latitude, longitude)
}