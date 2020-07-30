package com.manwinder.redditnews.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class RedditResponseData(
    val `data`: Data,
    val kind: String
) {
    data class Data(
        /*val after: String,
        val before: Any?,*/
        val children: List<Children?>/*,
        val dist: Int,
        val modhash: String*/
    ) {
        data class Children(
            val `data`: Data?/*,
            val kind: String*/
        ) {
            @Parcelize
            data class Data(
                /*val all_awardings: List<Any>,
                val allow_live_comments: Boolean,
                val approved_at_utc: Any?,
                val approved_by: Any?,
                val archived: Boolean,
                val author: String,
                val author_flair_background_color: Any?,
                val author_flair_css_class: Any?,
                val author_flair_richtext: List<Any>,
                val author_flair_template_id: Any?,
                val author_flair_text: Any?,
                val author_flair_text_color: Any?,
                val author_flair_type: String,
                val author_fullname: String,
                val author_patreon_flair: Boolean,
                val author_premium: Boolean,
                val awarders: List<Any>,
                val banned_at_utc: Any?,
                val banned_by: Any?,
                val can_gild: Boolean,
                val can_mod_post: Boolean,
                val category: Any?,
                val clicked: Boolean,
                val content_categories: Any?,
                val contest_mode: Boolean,
                val created: Double,
                val created_utc: Double,
                val crosspost_parent: String,
                val crosspost_parent_list: List<CrosspostParent>,
                val discussion_type: Any?,
                val distinguished: Any?,
                val domain: String,
                val downs: Int,
                val edited: Any?,
                val gilded: Int,
                val gildings: Gildings,
                val hidden: Boolean,
                val hide_score: Boolean,
                val id: String,
                val is_crosspostable: Boolean,
                val is_meta: Boolean,
                val is_original_content: Boolean,
                val is_reddit_media_domain: Boolean,
                val is_robot_indexable: Boolean,
                val is_self: Boolean,
                val is_video: Boolean,
                val likes: Any?,
                val link_flair_background_color: String,
                val link_flair_css_class: Any?,
                val link_flair_richtext: List<Any>,
                val link_flair_text: Any?,
                val link_flair_text_color: String,
                val link_flair_type: String,
                val locked: Boolean,
                val media: Any?,
                val media_embed: MediaEmbed,
                val media_metadata: MediaMetadata,
                val media_only: Boolean,
                val mod_note: Any?,
                val mod_reason_by: Any?,
                val mod_reason_title: Any?,
                val mod_reports: List<Any>,
                val name: String,
                val no_follow: Boolean,
                val num_comments: Int,
                val num_crossposts: Int,
                val num_reports: Any?,
                val over_18: Boolean,
                val parent_whitelist_status: String,
                val permalink: String,
                val pinned: Boolean,
                val pwls: Int,
                val quarantine: Boolean,
                val removal_reason: Any?,
                val removed_by: Any?,
                val removed_by_category: Any?,
                val report_reasons: Any?,
                val saved: Boolean,
                val score: Int,
                val secure_media: Any?,
                val secure_media_embed: SecureMediaEmbed,
                val selftext: String,
                val selftext_html: Any?,
                val send_replies: Boolean,
                val spoiler: Boolean,
                val stickied: Boolean,
                val subreddit: String,
                val subreddit_id: String,
                val subreddit_name_prefixed: String,
                val subreddit_subscribers: Int,
                val subreddit_type: String,
                val suggested_sort: Any?,
                val thumbnail: String,*/
                val title: String?,
                /*val top_awarded_type: Any?,
                val total_awards_received: Int,
                val treatment_tags: List<Any>,
                val ups: Int,
                val upvote_ratio: Double,*/
                val url: String?/*,
                val url_overridden_by_dest: String,
                val user_reports: List<Any>,
                val view_count: Any?,
                val visited: Boolean,
                val whitelist_status: String,
                val wls: Int*/
            ): Parcelable /*{
                data class CrosspostParent(
                    val all_awardings: List<Any>,
                    val allow_live_comments: Boolean,
                    val approved_at_utc: Any?,
                    val approved_by: Any?,
                    val archived: Boolean,
                    val author: String,
                    val author_flair_background_color: Any?,
                    val author_flair_css_class: Any?,
                    val author_flair_richtext: List<Any>,
                    val author_flair_template_id: Any?,
                    val author_flair_text: Any?,
                    val author_flair_text_color: Any?,
                    val author_flair_type: String,
                    val author_fullname: String,
                    val author_patreon_flair: Boolean,
                    val author_premium: Boolean,
                    val awarders: List<Any>,
                    val banned_at_utc: Any?,
                    val banned_by: Any?,
                    val can_gild: Boolean,
                    val can_mod_post: Boolean,
                    val category: Any?,
                    val clicked: Boolean,
                    val content_categories: Any?,
                    val contest_mode: Boolean,
                    val created: Double,
                    val created_utc: Double,
                    val discussion_type: Any?,
                    val distinguished: Any?,
                    val domain: String,
                    val downs: Int,
                    val edited: Boolean,
                    val gilded: Int,
                    val gildings: Gildings,
                    val hidden: Boolean,
                    val hide_score: Boolean,
                    val id: String,
                    val is_crosspostable: Boolean,
                    val is_meta: Boolean,
                    val is_original_content: Boolean,
                    val is_reddit_media_domain: Boolean,
                    val is_robot_indexable: Boolean,
                    val is_self: Boolean,
                    val is_video: Boolean,
                    val likes: Any?,
                    val link_flair_background_color: String,
                    val link_flair_css_class: Any?,
                    val link_flair_richtext: List<LinkFlairRichtext>,
                    val link_flair_template_id: String,
                    val link_flair_text: Any?,
                    val link_flair_text_color: String,
                    val link_flair_type: String,
                    val locked: Boolean,
                    val media: Any?,
                    val media_embed: MediaEmbed,
                    val media_only: Boolean,
                    val mod_note: Any?,
                    val mod_reason_by: Any?,
                    val mod_reason_title: Any?,
                    val mod_reports: List<Any>,
                    val name: String,
                    val no_follow: Boolean,
                    val num_comments: Int,
                    val num_crossposts: Int,
                    val num_reports: Any?,
                    val over_18: Boolean,
                    val parent_whitelist_status: Any?,
                    val permalink: String,
                    val pinned: Boolean,
                    val pwls: Any?,
                    val quarantine: Boolean,
                    val removal_reason: Any?,
                    val removed_by: Any?,
                    val removed_by_category: Any?,
                    val report_reasons: Any?,
                    val saved: Boolean,
                    val score: Int,
                    val secure_media: Any?,
                    val secure_media_embed: SecureMediaEmbed,
                    val selftext: String,
                    val selftext_html: Any?,
                    val send_replies: Boolean,
                    val spoiler: Boolean,
                    val stickied: Boolean,
                    val subreddit: String,
                    val subreddit_id: String,
                    val subreddit_name_prefixed: String,
                    val subreddit_subscribers: Int,
                    val subreddit_type: String,
                    val suggested_sort: Any?,
                    val thumbnail: String,
                    val title: String,
                    val top_awarded_type: Any?,
                    val total_awards_received: Int,
                    val treatment_tags: List<Any>,
                    val ups: Int,
                    val upvote_ratio: Double,
                    val url: String,
                    val url_overridden_by_dest: String,
                    val user_reports: List<Any>,
                    val view_count: Any?,
                    val visited: Boolean,
                    val whitelist_status: Any?,
                    val wls: Any?
                ) {
                    class Gildings(
                    )

                    data class LinkFlairRichtext(
                        val e: String,
                        val t: String
                    )

                    class MediaEmbed(
                    )

                    class SecureMediaEmbed(
                    )
                }

                class Gildings(
                )

                data class MediaEmbed(
                    val content: String,
                    val height: Int,
                    val scrolling: Boolean,
                    val width: Int
                )

                data class MediaMetadata(
                    val vlcl5ziqlkd51: Vlcl5ziqlkd51
                ) {
                    data class Vlcl5ziqlkd51(
                        val e: String,
                        val id: String,
                        val m: String,
                        val p: List<P>,
                        val s: S,
                        val status: String
                    ) {
                        data class P(
                            val u: String,
                            val x: Int,
                            val y: Int
                        )

                        data class S(
                            val u: String,
                            val x: Int,
                            val y: Int
                        )
                    }
                }

                data class SecureMediaEmbed(
                    val content: String,
                    val height: Int,
                    val media_domain_url: String,
                    val scrolling: Boolean,
                    val width: Int
                )
            }*/
        }
    }
}