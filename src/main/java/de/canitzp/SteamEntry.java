package de.canitzp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SteamEntry{
    
    public String type;
    public String name;
    @SerializedName("steam_appid")
    public int appId;
    @SerializedName("required_age")
    public int requiredAge;
    @SerializedName("is_free")
    public boolean isFree;
    @SerializedName("detailed_description")
    public String detailedDescription;
    @SerializedName("about_the_game")
    public String about;
    @SerializedName("short_description")
    public String shortDescription;
    @SerializedName("supported_languages")
    public String supportedLanguages;
    @SerializedName("header_image")
    public String headerImage;
    public String website;
    @SerializedName("pc_requirements")
    public PCRequirements pcRequirements;
    @SerializedName("mac_requirements")
    public PCRequirements macRequirements;
    @SerializedName("linux_requirements")
    public PCRequirements linuxRequirements;
    public List<String> developers;
    public List<String> publishers;
    public Price priceOverview;
    public List<Integer> packages;
    @SerializedName("package_groups")
    public List<PackageGroup> packageGroups;
    public Platforms platforms;
    public List<CategoryGenre> categories;
    public List<CategoryGenre> genres;
    public List<Screenshot> screenshots;
    public List<Movie> movies;
    public RecommendationAchievements recommendations;
    public RecommendationAchievements achievements;
    @SerializedName("release_date")
    public ReleaseDate releaseDate;
    @SerializedName("support_info")
    public SupportInfo supportInfo;
    public String background;
    @SerializedName("content_descriptors")
    public ContentDescriptors contentDescriptors;
    
    public class PCRequirements {
        public String minimum;
        public String recommended;
    }
    
    public class Price {
        public String currency;
        @SerializedName("initial")
        public int initialPrice;
        @SerializedName("final")
        public int finalPrice;
        @SerializedName("discount_percent")
        public int discountPercent;
        @SerializedName("initial_formatted")
        public String initialFormatted;
        @SerializedName("final_formatted")
        public String finalFormatted;
    }
    
    public class PackageGroup{
        public String name;
        public String title;
        public String description;
        @SerializedName("selection_text")
        public String selectionText;
        @SerializedName("save_text")
        public String saveText;
        @SerializedName("display_type")
        public int displayType;
        @SerializedName("is_recurring_subscription")
        public String isReccuringSubstription;
        public List<Sub> subs;
        
        public class Sub {
            @SerializedName("packageid")
            public int packageId;
            @SerializedName("percent_savings_text")
            public String percentSavingsText;
            @SerializedName("percent_savings")
            public int percentSavings;
            @SerializedName("option_text")
            public String optionText;
            @SerializedName("can_get_free_license")
            public String canGetFreeLicense;
            @SerializedName("is_free_license")
            public boolean isFreeLicense;
            @SerializedName("price_in_cents_with_discount")
            public int priceInCentsWithDiscount;
        }
    }
    
    public class Platforms {
        public boolean windows;
        public boolean mac;
        public boolean linux;
    }
    
    public class CategoryGenre{
        public int id;
        public String description;
    }
    
    public class Screenshot {
        public int id;
        @SerializedName("path_thumbnail")
        public String thumbnailPath;
        @SerializedName("path_full")
        public String fullPath;
    }
    
    public class Movie {
        public int id;
        public String name;
        public String thumbnail;
        public WebM webm;
        public boolean highlight;
        
        public class WebM{
            @SerializedName("480")
            public String res480;
            @SerializedName("max")
            public String resMax;
        }
    }
    
    public class RecommendationAchievements{
        public int total;
    }
    
    public class ReleaseDate {
        @SerializedName("coming_soon")
        public boolean comingSoon;
        public String date;
    }
    
    public class SupportInfo {
        public String url;
        public String email;
    }
    
    public class ContentDescriptors {
        public List<Object> ids; // todo find type
        public Object notes; // todo find type
    }
}
