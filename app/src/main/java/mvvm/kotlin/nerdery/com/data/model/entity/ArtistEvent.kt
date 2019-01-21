package mvvm.kotlin.nerdery.com.data.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import mvvm.kotlin.nerdery.com.data.model.Offer
import mvvm.kotlin.nerdery.com.data.model.Venue
import mvvm.kotlin.nerdery.com.data.model.api.ArtistEventResponse
import mvvm.kotlin.nerdery.com.data.model.entity.base.ReflectsApiResponse
import mvvm.kotlin.nerdery.com.data.persistence.converter.Converters
import mvvm.kotlin.nerdery.com.util.DateTimeUtil.defaultFormatter
import org.threeten.bp.LocalDateTime

@Entity
open class ArtistEvent(
    @PrimaryKey
    var id: Long? = 0L,
    var artistId: Long? = 0L,
    @TypeConverters(Converters::class)
    var dateTime: LocalDateTime? = null,
    var description: String? = "",
    @TypeConverters(Converters::class)
    var lineup: List<String>? = null,
    @TypeConverters(Converters::class)
    var offers: List<Offer>? = null,
    @TypeConverters(Converters::class)
    var onSaleDateTime: LocalDateTime? = null,
    var url: String? = "",
    @Embedded(prefix = "venue_")
    var venue: Venue? = null,
    var favorite: Boolean = false
) : ReflectsApiResponse<ArtistEvent, ArtistEventResponse> {

    override fun reflectFrom(apiResponse: ArtistEventResponse): ArtistEvent {
        id = apiResponse.id.toLong()
        artistId = apiResponse.artistId.toLong()
        dateTime = defaultFormatter.parse(apiResponse.datetime, LocalDateTime::from)
        description = apiResponse.description
        lineup = apiResponse.lineup
        apiResponse.offers?.let { offer ->
            offers = offer.map { Offer().reflectFrom(it!!) }
        }
        if (apiResponse.onSaleDatetime?.isNotEmpty() == true) {
            onSaleDateTime = defaultFormatter.parse(apiResponse.onSaleDatetime, LocalDateTime::from)
        }
        url = apiResponse.url
        apiResponse.venue?.let {
            venue = Venue().reflectFrom(it)
        }
        return this
    }
}