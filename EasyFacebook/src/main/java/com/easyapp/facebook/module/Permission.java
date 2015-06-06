package com.easyapp.facebook.module;


public enum Permission {

    PUBLIC_PROFILE("public_profile"),

    USER_ABOUT_ME("user_about_me"),

    USER_ACTIONS_BOOKS("user_actions.books"),

    USER_ACTIONS_FITNESS("user_actions.fitness"),

    USER_ACTIONS_MUSIC("user_actions.music"),

    USER_ACTIONS_NEWS("user_actions.news"),

    USER_ACTIONS_VIDEO("user_actions.video"),

    USER_ACTIVITIES("user_activities"),

    USER_BIRTHDAY("user_birthday"),

    USER_EDUCATION_HISTORY("user_education_history"),

    USER_EVENTS("user_events"),

    USER_FRIENDS("user_friends"),

    USER_GAMES_ACTIVITY("user_games_activity"),

    USER_GROUPS("user_groups"),

    USER_HOMETOWN("user_hometown"),

    USER_INTERESTS("user_interests"),

    USER_LIKES("user_likes"),

    USER_LOCATION("user_location"),

    USER_PHOTOS("user_photos"),

    USER_RELATIONSHIPS("user_relationships"),

    USER_RELATIONSHIP_DETAILS("user_relationship_details"),

    USER_RELIGION_POLITICS("user_religion_politics"),

    USER_STATUS("user_status"),

    USER_TAGGED_PLACES("user_tagged_places"),

    USER_VIDEOS("user_videos"),

    USER_WEBSITE("user_website"),

    USER_WORK_HISTORY("user_work_history"),

    READ_FRIENDLISTS("read_friendlists"),

    READ_INSIGHTS("read_insights"),

    READ_MAILBOX("read_mailbox"),

    READ_PAGE_MAILBOX("read_page_mailboxes"),

    READ_STREAM("read_stream"),

    EMAIL("email"),

    PUBLISH_ACTION("publish_actions"),

    RSVP_EVENT("rsvp_event"),

    MANAGE_NOTIFICATIONS("manage_notifications"),

    MANAGE_PAGES("manage_pages");


    public static enum Type {

    }

    ;

    public static enum Role {
        /**
         * Manage admins<br>
         * Full Admin
         */
        ADMINISTER,
        /**
         * Edit the Page and add apps<br>
         * Full Admin, Content Creator
         */
        EDIT_PROFILE,
        /**
         * Create posts as the Page<br>
         * Full Admin, Content Creator
         */
        CREATE_CONTENT,
        /**
         * Respond to and delete comments, send messages as the Page<br>
         * Full Admin, Content Creator, Moderator
         */
        MODERATE_CONTENT,
        /**
         * Create ads and unpublished page posts<br>
         * Full Admin, Content Creator, Moderator, Ads Creator
         */
        CREATE_ADS,
        /**
         * View Insights<br>
         * Full Admin, Content Creator, Moderator, Ads Creator, Insights Manager
         */
        BASIC_ADMIN
    }

    private String mValue;


    private Permission(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public static Permission fromValue(String pemissionValue) {
        for (Permission permission : values()) {
            if (permission.mValue.equals(pemissionValue)) {
                return permission;
            }
        }
        return null;
    }

}