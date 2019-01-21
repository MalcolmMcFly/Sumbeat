package mvvm.kotlin.nerdery.com.data.model

import mvvm.kotlin.nerdery.com.data.model.api.VenueResponse
import mvvm.kotlin.nerdery.com.data.model.entity.base.ReflectsApiResponse

data class Venue(
    var name: String? = "",
    var city: String? = "",
    var country: String? = "",
    var latitude: Double? = 0.0,
    var longitude: Double? = 0.0,
    var region: String? = ""
) : ReflectsApiResponse<Venue, VenueResponse> {

    override  fun reflectFrom(apiResponse: VenueResponse): Venue {
        name = apiResponse.name
        city = apiResponse.city
        country = apiResponse.country
        latitude = apiResponse.latitude.toDoubleOrNull()
        longitude = apiResponse.longitude.toDoubleOrNull()
        region = apiResponse.region
        return this
    }
}