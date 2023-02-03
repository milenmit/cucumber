package Enums;

public enum SocialPagesIcons {

    ICON_LINKEDIN("Linkedin"),
    ICON_FACEBOOK("Facebook"),
    ICON_TWITTER("Twitter");

    SocialPagesIcons(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }


}
