package com.echomu.mobiletest.bean

/**
 * @author echoMu
 * @date 2024/9/20
 * @desc
 */
data class Booking(
    val canIssueTicketChecking: Boolean,
    val duration: Int,
    val expiryTime: String,
    val segments: List<Segment>,
    val shipReference: String,
    val shipToken: String
)

data class Segment(
    val id: Int,
    val originAndDestinationPair: OriginAndDestinationPair
)

data class OriginAndDestinationPair(
    val destination: Destination,
    val destinationCity: String,
    val origin: Origin,
    val originCity: String
)

data class Destination(
    val code: String,
    val displayName: String,
    val url: String
)

data class Origin(
    val code: String,
    val displayName: String,
    val url: String
)