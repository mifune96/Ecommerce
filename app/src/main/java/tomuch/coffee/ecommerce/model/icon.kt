package tomuch.coffee.ecommerce.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class icon (
    val  company: String,
    val avatar: String,
) : Parcelable